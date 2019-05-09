.. 选择排序(JavaScript版)
    FileName:   merge-sort.rst
    Author:     Huang Xiaoyan
    Created:    2018-01-21 16:04:00
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
归并排序(JavaScript版)
======================

算法简析
========

归并排序是一种分治算法。算法思想是将要排序的原始数组，切分成若干小数组，直到每个小数组只有一个位置。
对小数组进行排序，然后相邻两两合并，重复这个步骤，直到合并成一个大数组。


代码实现
========

.. literalinclude:: /_src/javascript/sorting/merge-sort/merge-sort.js

代码解读
========

该算法采用递归方式。


下一步
======

.. include:: /_fragments/next-step-to-wechat-mp.rst

.. include:: /_fragments/disqus.rst

.. include:: /_fragments/wechat-reward.rst

.. comments
    comment something out below

