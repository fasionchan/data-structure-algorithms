.. 泛型数组表(Java语言)
    FileName:   generic-array-list-java.rst
    Author:     Fasion Chan
    Created:    2019-07-21 10:21:49
    @contact:   fasionchan@gmail.com
    @version:   $Id$

    Description:

    Changelog:

.. meta::
    :description lang=zh:
        Java支持泛型编程，有能力实现一个同时支持多种数据类型的数组表。
    :keywords: Data Structure, Array, List, Array List, Dynamic Array, Java, Generic Programming, 数据结构, 数组, 动态数组, 泛型编程

====================
泛型数组表(Java语言)
====================

:doc:`naive-array-list-java` 中实现的 :doc:`index` ，只能处理 `int` 类型数据，很局限。

如果语言不支持泛型编程( `Generic Programming` )，就只能再为其他类型重写一遍了。
好在 `Java` 支持泛型编程，有能力实现一个同时支持多种数据类型的数组表。
具体如何实现呢？

泛型化
======

泛型编程的思想是，在实现类或方法时，暂时不指定类型，而是稍后再决定使用什么类型。
为达到这个目的，需要借助类型参数，以尖括号括住，位于类名之后：

.. literalinclude:: /_src/java/list/GenericArrayList/GenericArrayList.java
	:language: java
	:tab-width: 4
	:lines: 8,102-103,154
	:linenos:

这段代码表明， *GenericArrayList* 是一个泛型类，关联类型暂不确定， *AnyType* 为类型参数。
之后，修改相关类方法，将类型参数化。

由于数组类型暂不确定，我们需要将其换成 **类型参数** 。
第 *3* 行表示，该类有一个成员变量 *listItems* ，类型是一个数组，但数据类型暂不确定。
如果实例化 *GenericArrayList* 对象时指定了 *int* 类型，那么 *listItems* 就是一个 *int* 数组。

类方法也需要以类型参数代替固定类型，以构造函数为例：

.. literalinclude:: /_src/java/list/GenericArrayList/GenericArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:lines: 10-13
	:linenos:

构造函数比较特殊，需要创建底层数组。
由于 *Java* 不支持动态创建数组，需要创建 *Object* 数组并做类型转换。

一般方法，只需简单替换，例如 *set* 方法：

.. literalinclude:: /_src/java/list/GenericArrayList/GenericArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 4
	:lines: 40-51
	:linenos:

最后，使用该类实例化对象时，通过尖括号确定实际类型。

例如，创建一个存储整数的数组表对象：

.. literalinclude:: /_src/java/list/GenericArrayList/GenericArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 8
	:lines: 130
	:linenos:

例如，创建一个存储整数的数组表对象：

.. literalinclude:: /_src/java/list/GenericArrayList/GenericArrayList.java
	:language: java
	:tab-width: 4
	:dedent: 8
	:lines: 106
	:linenos:

.. include:: /_fragments/next-step-to-wechat-mp.rst

.. include:: /_fragments/disqus.rst

.. include:: /_fragments/wechat-reward.rst

.. comments
    comment something out below

