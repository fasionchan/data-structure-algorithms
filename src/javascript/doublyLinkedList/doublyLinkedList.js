// 双向链表

function DoublyLinkedList () {
  function Node (ele) {
    this.ele = ele;
    this.next = null;
    this.prev = null;
  }

  let head = null;
  let tail = null;
  let length = 0;

  this.append = function (ele) {
    let node = new Node(ele);

    if (head === null) {
      head = node;
      tail = node;
    } else {
      let cur = head;
      while(cur.next) {
        cur = cur.next;
      }
      cur.next = node;
      node.prev = cur;
      tail = node;
    }
    length++;
  }

  this.insert = function (ele, pos) {
    let node = new Node(ele);

    if (pos === 0) {
      node.next = head;
      head.prev = node;
      head = node;
    } 
    else if (pos === length) {
      tail.next = node;
      node.prev = tail;
      tail = node;
    }
    else {
      let cur = head;
      let index = 0;
      while(index < pos) {
        index++;
        cur = cur.next;
      }

      cur.prev.next = node;
      node.next = cur;
      node.prev = cur.prev;
      cur.prev = node;

    }
    length++;
  }

  this.removeAt = function (pos) {
    if (pos === 0) {
      head = hea.next
    } else if (pos === length) {
      tail = tail.prev;
    } else {
      let index = 0;
      let cur = head;
      while(index++ < pos) {
        cur = cur.next;
      }

      cur.prev.next = cur.next;
      cur.next.prev = cur.prev;
    }
    length--;
  }

  this.remove = function (ele) {
    if (ele === head.ele) {
      head = head.next
    } else if (ele === tail.ele) {
      tail = tail.prev;
    } else {
      let cur = head;
      while (ele !== cur.ele) {
        cur = cur.next;
      }
      cur.prev.next = cur.next;
      cur.next.prev = cur.prev;
    }
    length--;
  }

  this.indexOf = function (ele) {
    let cur = head;

    while(ele !== cur.ele) {
      cur = cur.next;
    }

    return cur.ele;
  }

  this.isEmpty = function () {
    if (length > 0) {
      return false;
    }

    return true;
  }

  this.size = function () {
    return length;
  }

  this.getHead = function () {
    return head;
  }

  this.getTail = function () {
    return tail;
  }

  this.print = function () {
    let cur = head;

    while(cur) {
      console.log(cur.ele);
      cur = cur.next;
    }
  }
}

let doublyLinkedList = new DoublyLinkedList()
doublyLinkedList.append(3)
doublyLinkedList.append(4);
doublyLinkedList.append(33);
doublyLinkedList.append(89);
doublyLinkedList.append(3000);
doublyLinkedList.insert(444, 1)
doublyLinkedList.remove(4);
doublyLinkedList.removeAt(2);
doublyLinkedList.print()
console.log(doublyLinkedList.getHead())
console.log(doublyLinkedList.size())