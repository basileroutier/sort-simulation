/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author basile
 */
public class Sort {

    public static int bubbleSort(Integer[] arraySort) {
        int operationCount=0;
        operationCount++;
        for (int i = 0; i < arraySort.length; i++) {
            for (int j = 1; j < arraySort.length; j++) {
                if (arraySort[j - 1] > arraySort[j]) {
                    int tmp = arraySort[j];
                    arraySort[j] = arraySort[j - 1];
                    arraySort[j - 1] = tmp;
                    operationCount+=4;
                }
                operationCount++;
            }
            operationCount++;
        }
        return operationCount;
    }

    public static int mergeSort(Integer[] arraySort, int n) {
        int operationCount=0;
        if (n < 2) {
            return 0;
        }
        int mid = n / 2;
        Integer[] l = new Integer[mid];
        Integer[] r = new Integer[n - mid];
        
        operationCount+=3;

        for (int i = 0; i < mid; i++) {
            l[i] = arraySort[i];
            operationCount+=2;
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arraySort[i];
            operationCount+=2;
        }
        
        operationCount += mergeSort(l, mid);
        operationCount += mergeSort(r, n - mid);

        operationCount += merge(arraySort, l, r, mid, n - mid, operationCount);
        return operationCount;
    }

    private static int merge(Integer[] a, Integer[] l, Integer[] r, int left, int right, int operationCount) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
                operationCount+=2;
            } else {
                a[k++] = r[j++];
                operationCount+=2;
            }
            operationCount++;
        }
        while (i < left) {
            a[k++] = l[i++];
            operationCount+=2;
        }
        while (j < right) {
            a[k++] = r[j++];
            operationCount+=2;
        }
        return operationCount;
    }

}
