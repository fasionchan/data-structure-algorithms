/**
 * FileName:   demo.c
 * Author:     Fasion Chan
 * @contact:   fasionchan@gmail.com
 * @version:   $Id$
 *
 * Description:
 *
 * Changelog:
 *
 **/

#include <stdio.h>

#include "bubble-sort.h"

void printIntegers(int integers[], int n, char *title)
{
    if (title != NULL) {
        printf("%s: ", title);
    }

    int i;
    for (i=0; i<n-1; i++) {
        printf("%d ", integers[i]);
    }
    printf("%d\n", integers[n-1]);
}

int main() {
    int values[] = {7, 1, 3, 7, 4, 9, 7, 9, 5, 4};
    int n = sizeof(values) / sizeof(values[0]);

    printIntegers(values, n, "Before sort");

    bubbleSort(values, n);

    printIntegers(values, n, " After sort");

    return 0;
}
