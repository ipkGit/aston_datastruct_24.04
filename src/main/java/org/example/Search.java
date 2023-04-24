package org.example;

public class Search {

    /**
     * @param sortedArr - Should be sorted in ascending order
     * @param toFind    - What need to find
     * @return - index in sortedArr if exist and -1 if not exist
     */
    public static int binarySearch(int[] sortedArr, int toFind) {
        int left = 0;
        int right = sortedArr.length - 1;

        while (left <= right) {
            int position = (left + right) / 2;
            int current = sortedArr[position];

            if (current == toFind)
                return position;
            else if (current < toFind)
                left = position + 1;
            else
                right = position - 1;
        }
        return -1;
    }

}
