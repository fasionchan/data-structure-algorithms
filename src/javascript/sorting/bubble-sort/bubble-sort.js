function bubbleSort(arr) {
  var n = arr && arr.length
  for (var i=0; i<n-1; i++) {
      for (var j=1; j<n-i; j++) {
          if (arr[j-1] > arr[j]) {
              var temp = arr[j-1]
              arr[j-1] = arr[j]
              arr[j] = temp
          }
      }
  }
}