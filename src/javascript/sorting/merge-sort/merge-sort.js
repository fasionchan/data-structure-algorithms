// 归并排序
function mergeSort(arr) {

    function merge(leftArr, rightArr) {
        var final = []

        while (leftArr.length && rightArr.length) {
            final.push(leftArr[0] < rightArr[0] ? leftArr.shift() : rightArr.shift())
        }

        return final.concat(leftArr.concat(rightArr))
    }

    var n = arr && arr.length

    if (n < 2) {
        return arr
    }

    var mid = parseInt(n / 2)
    var leftArr = arr.slice(0, mid)
    var rightArr = arr.slice(mid, n)

    return merge(mergeSort(leftArr), mergeSort(rightArr))
}

mergeSort([3, 5, 6, 22, 1, 45, 90, 0, 454, 32])