..
    Author: fasion
    Created time: 2019-07-30 09:56:28
    Last Modified by: fasion
    Last Modified time: 2019-07-30 15:23:16

.. meta::
	:description lang=zh:
        本文介绍如何使用C语言实现单链表(single linked list)：定义链表节点(node)以及链表结构体，实现添加、删除、查找、遍历等主要操作，附以结构清晰的源码以及详实的文字说明，希望对初学者有所帮助。
    :keywords: Data Structure, Linked List, C, 链表, C语言

=============
单链表(C语言)
=============

本文介绍如何使用 `C` 语言实现 **单链表** ( `single linked list` )：
定义链表 **节点** ( `node` ) 以及链表结构体，
实现 **添加** 、 **删除** 、 **查找** 、 **遍历** 等主要操作，
附以结构清晰的 **源码** 以及详实的 **文字说明** ，希望对 **初学者** 有所帮助。

结构定义
========

先定义链表 **节点** ( `node` )，以存储整数元素( `int` )为例：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.h
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 8-16

第 *1* 行，为 `int` 类型定义一个别名，为 *Element* ；
第 *3-4* 行，为结构体及其指针分别定义别名；
第 *6-9* 行，定义链表节点 **结构体** ，包含两个字段：

#. *element* ，节点 **存储元素** ；
#. *next* ， **后向指针** ，指向下一个节点；

接着，定义一个结构体表示链表：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.h
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 18-21

该结构体包含两个指针：

#. `head` ，指向链表 **头节点** ；
#. `tail` ，指向链表 **尾节点** ：

操作定义
========

初始化
------

`init` 函数负责初始化链表，将头、尾指针置为 `NULL` ，表示链表为空：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 12-14

动态创建
--------

`create` 函数动态创建新链表，即为链表结构体分配内存并完成初始化：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 16-23

这样一来，创建链表的方式有两种。①声明链表结构体并初始化：

.. code-block:: c

    List l;
    init(&l);

    // do something with list
    add(&l, 1);

②动态创建链表结构体：

.. code-block:: c

    ListPtr l = create();

    // do something with list
    add(l, 1);

具体采用哪种方式视情况而定。

空判断
------

`isEmpty` 函数判断链表是否为空，只需判断头指针是否为 `NULL` ：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 25-27

链表头
------

`head` 函数返回链表头指针：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 29-31

链表尾
------

`tail` 函数返回链表尾指针：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 33-35

查找
----

查找操作需要遍历整个链表，逐一验证。

头文件为节点指针定义一个别名，表示当前遍历到的位置：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.h
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 23

`find` 函数在链表中查找元素 `x` 并返回其节点指针：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 37-46

#. 第 *2-7* 行， `for` 循环遍历链表每个节点；
#. 第 *4-6* 行，如节点存储元素为 `x` ，则返回节点指针；
#. 第 *9* 行，循环结束，没有找到元素 *x* ，返回 `NULL` ；

删除
----

`delete` 函数从链表 *l* 中找到元素 *x* 并将其删除：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 48-73

删除元素前，先遍历链表每个节点，找出元素 *x* 所在节点。
由于删除节点需要调整前一节点的后向指针，因此遍历时， **需跟踪前节点** 。

#. 第 *3* 行，定义两个 **游标** ( `cursor` )变量， *p* 表示当前节点， *prev* 表示其前节点；
#. 第 *4-8* 行，循环遍历每个节点，如果元素为 *x* ，则跳出；
    - **初始条件** ：当前节点 *p* 为头节点，前节点为空( `NULL` )；
    - **循环条件** ：当前节点非空；
    - **迭代** ：跳到下一节点，跳之前先更新前节点；
#. 第 *11-13* 行，如元素 *x* 不存在，直接返回；
#. 第 *16-25* 行，删除元素 *x* 所在节点  *p* ，注意 **特殊情况** 处理：
    - 如果被删除节点为头节点，调整链表头( *16-18* )；
    - 如果被删除节点为尾节点，调整链表尾( *19-21* )；
    - 如果前一节点存在，调整其后向指针( *22-24* )；

添加
----

`add` 函数将元素 *x* 添加到链表 *l* 节点 *p* 之后( *p* 为 `NULL` 则添加到链表头)：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 75-99

#. 第 *3-6* 行，为新节点分配内存，失败则返回 *-1* ；
#. 第 *9* 行，将元素 *x* 拷贝到新节点；
#. 第 *11-14* 行，添加到链表头，节点链接到元头节点之前并调整链表头；
#. 第 *16-17* 行，添加到 *p* 之后，调整指针完成链接；
#. 第 *20-22* 行，如添加至链表尾，调整尾指针；

遍历
----

由于遍历链表是一个很常用的操作，可以实现一个通用的遍历函数 `traverse` 。
该函数遍历链表 *l* ，并为每个节点调用处理函数 *h* 。
*h* 为函数指针，原型在头文件中定义如下：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.h
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 24

`traverse` 函数实现如下：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 101-108

#. 第 *2* 行，定义游标变量 *p* ，从链表头开始遍历；
#. 第 *3-7* 行， `while` 当 *p* 非 `NULL` 时不断循环；
    - 暂存当前节点( *4* )；
    - 跳到下一节点( *5* )；
    - 调用处理函数处理当前节点( *6* )；

清空
----

`clear` 函数将链表 *l* 清空，释放所有链表节点：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 136-139

#. 第 *2* 行，调用 `traverse` 函数遍历链表，为每个节点调用 `free` 库函数，释放内存；
#. 第 *3* 行，链表清空后，将头尾指针置为 `NULL` ，表示链表为空；

反转
----

`reverse` 函数将链表 *l* 所有节点反转，即前后颠倒：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 120-134

将原链表元素从头部逐一取出并插到新链表的最前面，所得链表就是原链表的倒置：

#. 第 *2-3* 行，定义两个临时链表头， *h1* 为原链表， *h2* 为空的新链表；
#. 第 *5-11* 行， `while` 遍历原链表每个节点，并将其插到 *h2* 最前面；
#. 第 *13-14* 行，倒置后原链表头成了链表尾，原链表尾即 *h2* ，成了链表头；

打印
----

`print` 函数输出链表 *l* 所有元素， *hint* 为一个可选的输出提示：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 114-118

#. 第 *2* 行，先打印提示以及左方括号 *[* ；
#. 第 *3* 行，调用 `traverse` 函数遍历链表，为每个节点调用 `printNode` 打印函数；

`printNode` 函数为 `print` 的辅助函数，负责打印一个节点：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 110-112

销毁
----

`destroy` 函数销毁链表 *l* ：

.. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 141-144

#. 第 *2* 行，先清空链表，释放所有节点；
#. 第 *3* 行， 释放链表结构体；

应用
====

.. literalinclude:: /_src/c/list/single-linked-list/demo.c
    :language: c
    :tab-width: 4
    :linenos:
    :lines: 8-

进入源码目录，执行 `make run` 即可运行例子程序：

.. code-block:: shell-session

    $ make run
    gcc -o demo single-linked-list.c demo.c
    ./demo
    after init: [ ]
    after add 1, 2, 3 to head: [ 3 2 1 ]
    after add 4, 5, 6 to tail: [ 3 2 1 4 5 6 ]
    after add 0 after 1: [ 3 2 1 0 4 5 6 ]
    after reverse: [ 6 5 4 0 1 2 3 ]
    after delete 0: [ 6 5 4 1 2 3 ]
    after clear: [ ]

下一步
======

.. include:: /_fragments/next-step-to-wechat-mp.rst

.. include:: /_fragments/disqus.rst

.. include:: /_fragments/wechat-reward.rst

.. comments
	comment something out below

    .. literalinclude:: /_src/c/list/single-linked-list/single-linked-list.c
        :language: c
        :tab-width: 4
        :linenos:
