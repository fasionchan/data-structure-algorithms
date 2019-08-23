// 二叉搜索树

function BinarySearchTree () {
  function Node (value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  let root = null;

  this.insert = function (value) {
    let node = new Node(value);
    if (root === null) {
      root = node;
    } else {
      insertNode(root, node)
    }
  }

  function insertNode(node, newNode) {
    if (newNode.value < node.value) {
      if (node.left === null) {
        node.left = newNode;
      } else {
        insertNode(node.left, newNode);
      }
    } else if (newNode.value > node.value) {
      if (node.right === null) {
        node.right = newNode;
      } else {
        insertNode(node.right, newNode);
      }
    }
  }

  this.search = function (value) {
    if (value === root.value) {
      return true;
    } else {
      searchNode(root, value);
    }
  }

  function searchNode (node, value) {
    if (value < node.value) {
      searchNode(node.left, value);
    } else if (value > node.value) {
      searchNode(node.right, value);
    } else {
      return true;
    }

    return false;
  }

  // 中序遍历
  this.inOrderTraverse = function () {
    
  }

  // 前序遍历
  this.preOrderTraverse = function () {

  }

  // 后序遍历
  this.postOrderTraverse = function () {

  }

  this.min = function () {

  }

  this.max = function () {

  }

  this.remove = function () {

  }
}