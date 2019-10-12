function binarySearch (arr, keyword) {
  let len = arr.length

  if (len <= 0) {
    console.log('sorry, not find ' + keyword)
    return false
  }

  let middleIndex = parseInt(len/2)
  let middle = arr[middleIndex]

  if (keyword > middle) {
    let rightArr = arr.splice(middleIndex+1, len-(middleIndex+1))
    binarySearch(rightArr, keyword)
  }

  if (keyword < middle) {
    let leftArr = arr.splice(0, middleIndex)
    binarySearch(leftArr, keyword)
  }

  if (keyword === middle) {
    console.log('bingo, find ' + keyword)
    return true
  }
}

let arr = [1,2,3,4,5,6,7,8,9,10]
let keyword = 5
binarySearch(arr, keyword)