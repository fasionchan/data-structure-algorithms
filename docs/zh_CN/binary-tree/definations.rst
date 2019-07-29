..
    Author: fasion
    Created time: 2019-07-28 19:46:17
    Last Modified by: fasion
    Last Modified time: 2019-07-29 16:37:36

.. meta::
	:description lang=zh:
        本文讨论二叉树相关术语，包括根、父子节点、叶子节点、高度、深度等；
        并介绍两个特殊的二叉树形态——满二叉树以及完全二叉树。
    :keywords: binary tree, full binary tree, complete binary tree, root, parent, child, ancestor, descendent, height, depth, level, terminology, 二叉树, 满二叉树, 完全二叉树, 根, 父节点, 子节点, 祖先节点, 子孙节点, 高度, 深度, 层, 术语

==========
二叉树定义
==========

术语
====

.. figure:: /_images/binary-tree/definations/4ee27714ed5cc57475d9f359025585d1.jpg

- **根** ( `root` )，即 *A* ，为树中 **最顶节点** ，该节点 **没有父节点** ；
-  *A* 为 *B* 的 **父节点** ( `parent` )；
-  *E* 为 *B* 的 **子节点** ( `child` )；
-  *A* 、 *B* 为 *E* 的 **祖先节点** ( `ancestor` )；
-  *B* 、 *E* 为 *A* 的 **子孙节点** ( `descendent` )；
-  *I* 、 *J* 互为 **兄弟节点** ( `sibling` )， **父节点相同** ；
- **高度** ( `height` )，节点到最远子孙的距离；
    - *A* 高度为 *3* ；
    - *H* 高度为 *1* ；
    - *I* 高度为 *0* ；
- **深度** ( `Depth` )，节点到根的距离；
    - *A* 深度为 *0* ；
    - *H* 深度为 *2* ；
    - *I* 高度为 *3* ；
- 节点可按深度分 **层** ( `level` )；
    - 根为第 *0* 层；
    - *I* 、 *J* 为第 *3* 层；
- *H* 及其全部子孙节点组成一颗 **子树** ( `subtree` )；


满二叉树
========

**满二叉树** ( `Full Binary Tree` )中，每个节点要么没有子节点( `child` )，要么有两个子节点。

.. figure:: /_images/binary-tree/definations/020e6de667d476f113ce0115658f4a6c.png

    *满二叉树*

完全二叉树
==========

**完全二叉树** ( `Complete Binary Tree` )，有以下两个性质：

#. 除了最后一层，其他所有层都是满的；
#. 最后一层节点尽可能地靠着最左边；

.. figure:: /_images/binary-tree/definations/142023250664309e83c15e256ca9456a.png

    *完全二叉树*

由于完全二叉树逐层从左到右排列， 因此对于给定节点数的树， **形态只有一种** 。
因此，完全二叉树可以用一个数组来表示：

.. figure:: /_images/binary-tree/definations/f1e5132ea80d1e751cd0c5497083f801.png

    *完全二叉树数组表示*

为每个节点编号， **根节点** 为 *0* ，那么编号即是节点在数组中的 **下标** ：

.. figure:: /_images/binary-tree/definations/e47d6b47f107cba8c5d4fea91967021b.png

对于节点 :math:`i` ，其：

- **父节点** 为： :math:`\frac{i - 1}{2}` ；
- **左子节点** 为： :math:`2i + 1` ；
- **右子节点** 为： :math:`2i + 2` ；

下一步
======

.. include:: /_fragments/next-step-to-wechat-mp.rst

.. include:: /_fragments/disqus.rst

.. include:: /_fragments/wechat-reward.rst

.. comments
    comment something out below


    .. figure:: /_images/binary-tree/definations/7f3bd013112cd06401a43ab4ba888d6f.png

    树中唯一没有父节点的节点为 **根节点** ( `root` )，如图节点 *0* 。

    **路径** ( *Path* )
    - **路径** ( `path` )，；
        *A* 、 *G* 的路径为 *ADG* ；


    .. figure:: /_images/binary-tree/definations/7f3bd013112cd06401a43ab4ba888d6f.png

    对于上图节点 *3* ，

    - 节点 *1* 是 **父节点** ( `parent` )；
    - 节点 *4* 是 **兄弟节点** ( `sibling` )；
    - 节点 *6* 是 **左子节点** ( `left child` )；
    - 节点 *7* 是 **右子节点** ( `right child` )；

    另外，节点还可以分成：

    - **根节点** ( `root` )，树中唯一 **没有父节点** 的节点；
    - **叶子节点** ( `leaf` )，没有子节点；
    - **内部节点** ( `internal` )，至少有一个子节点；
