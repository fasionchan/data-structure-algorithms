.. 冒泡排序(JavaScript版)
    FileName:   bubble-sort.rst
    Author:     Huang Xiaoyan
    Created:    2018-11-23 16:04:00
    @contact:   hxysnail@gmail.com
    @version:   $Id$

    Description:

    Changelog:

======================
冒泡排序(JavaScript版)
======================

算法简析
========

冒泡排序，是一种比较简单的排序算法。

该算法的基本思路是：它重复地遍历要排序的数列，一次比较两个元素，若顺序错误则进行交换。
如此重复 *n-1* 趟，直到不再需要交换，也就说明该数列已经排序完成。

代码实现
========

.. literalinclude:: /_src/javascript/sorting/bubble-sort/bubble-sort.js

代码解读
========

代码有两层循环。

外层循环控制遍历数列的次数，记次数为 *i* 。
由于到第 *n-1* 遍时，该数列后 *n-1* 个数必定已经有序，所以遍历数列时，只需遍历 *n-1* 遍。

内层循环针对数列前 *n-i* 个元素，执行以下的算法：

#. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
#. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。
   这步做完后，最后的元素会是最大的数。
#. 针对前面 *n-i* 个元素重复以上的步骤，直到数列完全有序。

下一步
======

.. include:: /_fragments/next-step-to-wechat-mp.rst

.. include:: /_fragments/disqus.rst

.. include:: /_fragments/wechat-reward.rst

.. comments
    comment something out below

