function selectSort (arr) {
    var n = arr && arr.length

    for (var i=0; i<n; i++) {
        var min = arr[i]
        var minIndex = i
        for (var j=i+1; j<n; j++) {
            if (min > arr[j]) {
                min = arr[j]
                minIndex = j
            }
        }

        if (i !== minIndex) {
            arr[minIndex] = arr[i]
            arr[i] = min
        }
    }
    return arr
}
