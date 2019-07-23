.. 朴素数组表(Java语言)
	FileName:   naive-array-list-java.rst
	Author:     Fasion Chan
	Created:    2019-07-21 10:21:49
	@contact:   fasionchan@gmail.com
	@version:   $Id$

	Description:

	Changelog:

.. meta::
	:description lang=zh:
	:keywords:

====================
朴素数组表(Java语言)
====================

**朴素数组表** ( *Naive Array List* )是本文自创的名词，表示一种 **最直观最原始** 的数组表。

类实现
======

首先定义一个 `NaiveArrayList` 类，有两个私有成元变量：

- *listSize* ，表示当前表中已存储的元素个数；
- *listItems* ，用于存储元素的数组，大小固定；

.. literalinclude:: /_src/java/list/NaiveArrayList/NaiveArrayList.java
	:language: java
	:tab-width: 4
	:lines: 8,102-103,136
	:linenos:

构造函数
--------

构造函数在创建该类对象时调用，作用是初始化类对象。

*NaiveArrayList* 构造函数接收一个参数 *capacity* ，指定了数组大小，即数组表的 **容量** 。
函数体先创建一个指定大小的数组，并将元素个数初始化为 *0* 。

.. literalinclude:: /_src/java/list/NaiveArrayList/NaiveArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:linenos:
	:lines: 10-13

容量与大小
----------

容量
++++

*capacity* 返回数组表的容量，即底层数组的大小：

.. literalinclude:: /_src/java/list/NaiveArrayList/NaiveArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:linenos:
	:lines: 19-21

大小
++++

*size* 方法返回数组表已存储的元素个数，即 *listSize* ：

.. literalinclude:: /_src/java/list/NaiveArrayList/NaiveArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:linenos:
	:lines: 15-17

是否为空
++++++++

*isEmpty* 方法在数组表为空，即 *size* 为 *0* 时，返回 *true* ：

.. literalinclude:: /_src/java/list/NaiveArrayList/NaiveArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:linenos:
	:lines: 23-25

是否已满
++++++++

*isFull* 方法在数组表已满，即 *size* 等于 *capacity* 时，返回 *true* ：

.. literalinclude:: /_src/java/list/NaiveArrayList/NaiveArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:linenos:
	:lines: 27-29

增删改查
--------

查
++

*get* 方法根据给定下标( `index` )，查找对应元素并返回：

.. literalinclude:: /_src/java/list/NaiveArrayList/NaiveArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:linenos:
	:lines: 31-38

#. 第 *3-5* 行，先判断下标是否超出有效范围，超出则抛异常；
#. 第 *7* 行，以给定下标取回数组中的元素；

改
++

*set* 方法为给定下标元素设置新值，并返回旧值：

.. literalinclude:: /_src/java/list/NaiveArrayList/NaiveArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:linenos:
	:lines: 40-51

函数逻辑与 *get* 方法类似，注意到第 *8* 行先暂存旧值用于返回。

增
++

*add* 方法在指定下标处添加新元素，如果该位置已被占用，需将相关元素往后挪：

.. literalinclude:: /_src/java/list/NaiveArrayList/NaiveArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:linenos:
	:lines: 53-67

#. 第 *3-5* 行，判断数组表是否已满，满则抛异常；
#. 第 *8-10* 行，将该位置(如有)以及其后所有元素往后挪一个位置；
#. 第 *13-14* 行，将新元素存储到指定位置，并自增 *listSize* ；

实现另一个版本的 *add* 方法，无须指定下标，将新元素添加到末尾：

.. literalinclude:: /_src/java/list/NaiveArrayList/NaiveArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:linenos:
	:lines: 69-71

注意到， *size()* 为底层数组下一个可用位置。

删
++

*remove* 方法将指定下标元素从表中删除，并将其返回：

.. literalinclude:: /_src/java/list/NaiveArrayList/NaiveArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:linenos:
	:lines: 73-90

#. 第 *3-5* 行，先判断下标是否超出有效范围，超出则抛异常；
#. 第 *8* 行，暂存待删除元素，以便向调用者返回；
#. 第 *11-13* 行，将被删除元素后面所有元素往前挪一个位置；
#. 第 *15* 行，自减 *listSize* ；
#. 第 *17* 行，返回被删除元素；

辅助方法
--------

打印
++++

*print* 方法将数值表所有元素打印出来：

.. literalinclude:: /_src/java/list/NaiveArrayList/NaiveArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:linenos:
	:lines: 92-100

该方法接收一个参数 *hint* ，用于区分不同时机的打印。

时间复杂度
==========

类应用
======

下面，实现一个 *main* 函数，考察 *NaiveArrayList* 类的用法：

.. literalinclude:: /_src/java/list/NaiveArrayList/NaiveArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:linenos:
	:lines: 105-135

#. 第 *2* 行，实例化一个容量为 *10* 的数组表，最多可存储 *10* 个整数元素；
#. 第 *3-4* 行，将数组表输出，确认其为空；
#. 第 *6-8* 行，依次将 *1* 、 *2* 、 *3* 添加到数组表；
#. 第 *10-11* 行，将数组表输出确认添加效果，并查询小标为 *1* 的元素；
#. 第 *14* 行，将 *-1* 添加到位置 *0* ；
#. 第 *18* 行，将存储在位置 *1* 的元素删除；
#. 第 *22* 行，将元素 *4* 添加到末尾；
#. 第 *26-30* 行，循环添加元素，确认超出容量后抛异常；

运行
----

执行 `javac` 命令编译程序：

.. code-block:: shell-session

	$ javac NaiveArrayList

执行 `java` 命令运行程序：

.. code-block:: shell-session

	$ java NaiveArrayList

程序输出如下：

.. code-block:: text

	After init: [ ]

	After add 1, 2, 3: [ 1 2 3 ]
	#1 is: 2

	After insert -1: [ -1 1 2 3 ]

	After remove #1: [ -1 2 3 ]

	After append 4: [ -1 2 3 4 ]

	After append i: [ -1 2 3 4 5 ]

	After append i: [ -1 2 3 4 5 6 ]

	After append i: [ -1 2 3 4 5 6 7 ]

	After append i: [ -1 2 3 4 5 6 7 8 ]

	After append i: [ -1 2 3 4 5 6 7 8 9 ]

	After append i: [ -1 2 3 4 5 6 7 8 9 10 ]

	Exception in thread "main" ArrayOutOfCapacity: Array out of capacity
			at NaiveArrayList.add(NaiveArrayList.java:56)
			at NaiveArrayList.add(NaiveArrayList.java:70)
			at NaiveArrayList.main(NaiveArrayList.java:131)
	make: *** [run] Error 1

下一步
======

.. include:: /_fragments/next-step-to-wechat-mp.rst

.. include:: /_fragments/disqus.rst

.. include:: /_fragments/wechat-reward.rst

.. _NaiveArrayList.java: https://github.com/fasionchan/data-structure-algorithms/blob/master/src/java/list/NaiveArrayList/NaiveArrayList.java

.. comments
	comment something out below
