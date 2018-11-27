function quickSort(arr) {
    if (arr.length <= 1) {
        return arr
    }

    var pivot = arr[0]
    var leftArr = []
    var rightArr = []

    for (var i = 0; i < arr.length; i++) {
        if (arr[i] < pivot) {
            leftArr.push(arr[i])
        } else if (arr[i] > pivot) {
            rightArr.push(arr[i])
        }
    }

    leftArr = quickSort(leftArr)
    rightArr = quickSort(rightArr)

    return [].concat(leftArr, [pivot], rightArr)
}