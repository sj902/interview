package com.sj902.sliding;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {
    public static void main(String[] args) {
        System.out.println(bs(new int[]{1,2,2,3,4,5,5,5,6,6}, 5));
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pq.size() < k) {
                    pq.add(matrix[i][j]);
                } else {
                    int p = pq.peek();
                    if (matrix[i][j] < p) {
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        return pq.poll();
    }

    public int findKthNumber(int m, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());

        int l = 1;
        int r = m * n;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (count(m, n, mid) >= k)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    int count(int m, int n, int target) {
        int count = 0;

        // Iterate through each row to count numbers less than or equal to mid.
        for (int i = 1; i <= m; i++) {
            // In row i, since the numbers are i, 2i, 3i, ..., ni,
            // the count of numbers <= mid is min(mid / i, n).
            count += Math.min(target / i, n);
        }
        return count;
    }

    public static int findFirstIndexOrLower(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int result = -1; // Initialize result to -1 to handle the case when no lower number is found

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == target) {
                // Target found, move left to check for the first occurrence
                result = mid;
                high = mid - 1; // Move to the left half to find the first occurrence
            } else if (array[mid] < target) {
                result = mid; // Update result to the current mid index
                low = mid + 1; // Move to the right half
            } else {
                high = mid - 1; // Move to the left half
            }
        }

        return result; // Return the index of the first occurrence or highest number less than target
    }

    public static int bs(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        int res = -1;
        while (l <= r) {
            int m = l + ((r -l ) / 2);
            System.out.println(arr[m]);
            if (arr[m] == k) {
                res = m;
                r = m - 1;
            } else if(arr[m] > k){
                r = m - 1;
            }else{
                res = m;
                l = m + 1;
            }
        }
        return res;
    }
}
