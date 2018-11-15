/**
 * FileName:   bubble-sort.c
 * Author:     Fasion Chan
 * @contact:   fasionchan@gmail.com
 * @version:   $Id$
 *
 * Description:
 *
 * Changelog:
 *
 **/

void
bubbleSort(int values[], int n)
{
    int i, j;
    for (i=0; i<n-1; i++) {
        for (j=1; j<n; j++) {
            if (values[j-1] > values[j]) {
                int temp = values[j-1];
                values[j-1] = values[j];
                values[j] = temp;
            }
        }
    }
}
