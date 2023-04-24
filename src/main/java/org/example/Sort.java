package org.example;

public class Sort {
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * quick sort impl in ascending order
     * @param arr - int[] could be with duplicates int
     * @param l - index of left edge to sort
     * @param r - index of right edge to sort
     */
    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int mid = (r - l) / 2 + l;
        int midElem = arr[mid];

        int left = l, right = r;

        while (left <= right) {
            while (arr[left] < midElem) left++;
            while (arr[right] > midElem) right--;


            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }

            if (l < right) quickSort(arr, l, right);
            if (r > left) quickSort(arr, left, r);
        }
    }
}
