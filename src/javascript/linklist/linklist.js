class Node {
  constructor (ele) {
    this.ele = ele
    this.next = null
  }
}

class LinkList {
  constructor () {
    this.head = null
    this.tail  = null
    this.length = 0
  }

  append (ele) {
    let node = new Node(ele);

    let cur = this.head;

    if (cur == null) {
      this.head = node;
    } else {
      for(let i=0; i<this.length; i++) {
        if (cur.next === null) {
          cur.next = node;
        }
        cur = cur.next;
      }
    }

    this.length++;
  }

  insert (ele, pos) {
    let node = new Node(ele);
    let cur = this.head;

    if (pos === 0) {
      node.next = cur;
      this.head = node;
    } else {
      for(let i=1; i<=pos; i++) {
        if (i === pos) {
          node.next = cur.next;
          cur.next = node;
        }
        cur = cur.next;
      }
    }
    this.length++;
  }

  removeAt (pos) {
    // 边界检查
    if (pos <= -1 || pos >= this.length) {
      return -1;
    }

    let cur = this.head;

    if (pos === 0) {
      this.head = cur.next;
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

    this.length--;
  }

  remove (ele) {
    let cur = this.head;
    let next = cur.next;
    if (cur.ele === ele) {
      this.head = cur.next;
      cur = null;
      length--;
    } else {
      for(let i=0; i<this.length-1; i++) {
        if (next && next.ele === ele) {
          cur.next = next.next;
          next = null;
        }
        cur = cur.next;
        if (cur !== null) {
          next = cur.next;
        }
      }
      this.length--;
    }
  }

  indexOf (ele) {
    let cur = this.head;
    for(let i=0; i<this.length; i++) {
      if (cur.ele === ele) {
        return i;
      }

      cur = cur.next;
    }
  }

  isEmpty () {
    if (this.length === 0) {
      return true;
    }

    return false;
  }

  size () {
    return this.length;
  }

  getHead () {
    return this.head;
  }

  getTail () {
    let cur = this.head

    if (this.length === 0) {
      this.tail = null
    } else if (this.length === 1) {
      this.tail = this.head
    } else {
      while(cur.next) {
        cur = cur.next
      }

      this.tail = cur
    }
  }

  print () {
    let cur = this.head;

    while(cur !== null) {
      console.log(cur.ele);
      cur = cur.next;
    }
  }
  // 是否相交
  isIntersect (linklist) {
    if (this.tail === linklist.tail) {
      return true
    }
  }

  findIntersectNode (linklist) {
    let len1 = this.length
    let len2 = linklist.length

    let cur1 = this.head
    let cur2 = linklist.head

    let i = Math.abs(len1 - len2)

    for (let j=0; j<i; j++) {
      if (len1 > len2) {
        cur1 = cur1.next
      } else {
        cur2 = cur2.next
      }
    }

    while (cur1) {
      if (cur1 === cur2) {
        return cur1
      }
      cur1 = cur1.next
      cur2 = cur2.next
    }

    return null
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