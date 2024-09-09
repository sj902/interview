package com.sj902.misc;

import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SpiralMatrix4 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(res[i], -1);
        }

        int l = 0;
        int r = n - 1;
        int u = 0;
        int b = m - 1;
        int i = 0;
        int j = 0;
        ListNode curr = head;
        while (l <= r && u <= b && curr != null) {
            i = u;
            j = l;
            while (j <= r && curr != null) {
                res[i][j++] = curr.val;
                curr = curr.next;
            }
            u++;
            if (l > r || u > b || curr == null) {
                break;
            }
            i = u;
            j = r;
            while (i <= b && curr != null) {
                res[i++][j] = curr.val;
                curr = curr.next;
            }
            --r;
            if (l > r || u > b || curr == null) {
                break;
            }

            i = b;
            j = r;
            while (j >= l && curr != null) {
                res[i][j--] = curr.val;
                curr = curr.next;
            }
            --b;
            if (l > r || u > b || curr == null) {
                break;
            }

            i = b;
            j = l;
            while (i >= u && curr != null) {
                res[i--][j] = curr.val;
                curr = curr.next;
            }
            ++l;
            if (l > r || u > b || curr == null) {
                break;
            }
        }
        return res;
    }
}
