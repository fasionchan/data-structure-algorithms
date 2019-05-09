function Set () {
  let items = {};
  let length = 0;

  this.add = function (value) {
    if (!this.has(value)) {
      items[value] = value;
      length++;
    }
  }

  this.remove = function (value) {
    if (this.has(value)) {
      delete items[value];
      length--;
    }
  }

  this.has = function (value) {
    if(items.hasOwnProperty(value)) {
      return true;
    }

    return false;
  }

  this.clear = function () {
    items = {};
  }

  this.size = function () {
    return length;
  }

  this.values = function () {
    let values = [];
    for (let key in items) {
      if (items.hasOwnProperty(key)) {
        values.push(items[key]);
      }
    }

    return values;
  }

  // 合集
  this.union = function (otherSet) {
    let unionSet = new Set();

    let values = this.values();
    for(let i=0; i<values.length; i++) {
      unionSet.add(values[i]);
    }

    let otherValues = otherSet.values();
    for(let i=0; i<otherValues.length; i++) {
      unionSet.add(otherValues[i]);
    }

    return unionSet;
  }

  // 交集
  this.intersection = function (otherSet) {
    let intersectionSet = new Set();

    let values = this.values();
    for(let i=0; i<values.length; i++) {
      if (otherSet.has(values[i])) {
        intersectionSet.add(values[i])
      }
    }

    return intersectionSet;
  }

  // 差集
  this.difference = function (otherSet) {
    let differenceSet = new Set();

    let values = this.values();

    for(let i=0; i<values.length; i++) {
      if (!otherSet.has(values[i])) {
        differenceSet.add(values[i])
      }
    }

    return differenceSet;
  }
}

let set = new Set();
set.add(2)
set.add(2);
set.add(555);
set.add(0);
console.log(set.values())
let set1 = new Set();
set1.add(2);
set1.add(99);
set1.add(1000);
set1.add(44);
set1.add(555);
console.log(set1.values());

let set2 = set.union(set1);
console.log(set2.values());

let set3 = set.intersection(set1);
console.log(set3.values());

let set4 = set.difference(set1);
console.log(set4.values())