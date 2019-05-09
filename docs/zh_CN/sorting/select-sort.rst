.. 选择排序(JavaScript版)
    FileName:   select-sort.rst
    Author:     Huang Xiaoyan
    Created:    2018-12-05 16:04:00
    @contact:   hxysnail@gmail.com
    @version:   $Id$

    Description:

    Changelog:

    Note:
        You can adapt this file completely to your liking, but it should at least
        contain the root `toctree` directive.

.. meta::
    :description lang=zh:
        本专栏收录常用数据结构及算法，附以详细讲解和代码示例。
    :keywords: Data Structure, Algorithm, C++, Javascript, Python, 数据结构, 算法

======================
选择排序(JavaScript版)
======================

算法简析
========

选择排序，它的算法原理比较简单直观：

在未排序的序列中，寻找最小(大)的元素，与第i个未排序的元素进行交换，以此类推，直到所有元素全部排序完毕。

代码实现
========

.. literalinclude:: /_src/javascript/sorting/select-sort/select-sort.js

代码解读
========

代码有两层循环：

#. 外层循环主要控制寻找次数。每次寻找前，都将未排序序列的第一个元素arr[i]记录为min值，同时记录下标minIndex
#. 内层循环寻找未排序序列中的最小值，从第i+1个元素开始寻找。每当找到比上一次min值小的元素，就更新min值和下标minIndex。
#. 每次寻找到最小的值后，将当前min值对应的元素与第i个元素进行交换，结束此次循环
#. 依据上述算法，直到循环结束，也就完成了排序。

下一步
======

.. include:: /_fragments/next-step-to-wechat-mp.rst

.. include:: /_fragments/disqus.rst

.. include:: /_fragments/wechat-reward.rst

.. comments
    comment something out below

