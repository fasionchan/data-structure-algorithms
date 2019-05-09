// 单向链表

function LinkList () {
  let head = null;
  let length = 0;

  function Node (ele) {
    this.ele = ele;
    this.next = null;
  }

  this.append = function (ele) {
    let node = new Node(ele);

    let cur = head;

    if (cur == null) {
      head = node;
    } else {
      for(let i=0; i<length; i++) {
        if (cur.next === null) {
          cur.next = node;
        }
        cur = cur.next;
      }
    }

    length++;
  }

  this.insert = function (ele, pos) {
    let node = new Node(ele);
    let cur = head;

    if (pos === 0) {
      node.next = cur;
      head = node;
    } else {
      for(let i=1; i<=pos; i++) {
        if (i === pos) {
          node.next = cur.next;
          cur.next = node;
        }
        cur = cur.next;
      }
    }
    length++;
  }

  this.removeAt = function (pos) {
    // 边界检查
    if (pos <= -1 || pos >= length) {
      return -1;
    }

    let cur = head;

    if (pos === 0) {
      head = cur.next;
      cur = null;
    } else {
      for(let i=1; i<=pos; i++) {
        if (i === pos) {
          let temp = cur.next;
          cur.next = temp.next;
          temp = null
        }
        cur = cur.next;
      }
    }

    length--;
  }

  this.remove = function (ele) {
    let cur = head;
    let next = cur.next;
    if (cur.ele === ele) {
      head = cur.next;
      cur = null;
      length--;
    } else {
      for(let i=0; i<length-1; i++) {
        if (next && next.ele === ele) {
          cur.next = next.next;
          next = null;
        }
        cur = cur.next;
        if (cur !== null) {
          next = cur.next;
        }
      }
      length--;
    }
  }

  this.indexOf = function (ele) {
    let cur = head;
    for(let i=0; i<length; i++) {
      if (cur.ele === ele) {
        return i;
      }

      cur = cur.next;
    }
  }

  this.isEmpty = function () {
    if (length === 0) {
      return true;
    }

    return false;
  }

  this.size = function () {
    return length;
  }

  this.getHead = function () {
    return head;
  }

  this.toString = function () {

  }

  this.print = function () {
    let cur = head;

    while(cur !== null) {
      console.log(cur.ele);
      cur = cur.next;
    }
  }
}

let linklist = new LinkList();

linklist.append(3);
linklist.append(2);
linklist.append(4);
linklist.append(6);
console.log(linklist.size())
console.log(linklist.indexOf(3))
console.log(linklist.getHead())
linklist.insert(56, 1);
linklist.print()
console.log('------------after---------')
linklist.removeAt(1);
linklist.print()
console.log('---------after remove----------')
linklist.remove(4)
linklist.print()
console.log(linklist.isEmpty())