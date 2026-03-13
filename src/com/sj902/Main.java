package com.sj902;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("ff");

        String[] a = new String[]{"bdddddddddd", "bbbbbbbbbbc"};

        permutation(0, new char[]{'a', 'b', 'c'});
        System.out.println("-------------------------------");

//        System.out.println(res);

    }


    public String minWindow(String s, String t) {
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int minLeft = 0, minRight = 0, minLen = Integer.MAX_VALUE;
        int required = targetMap.size();
        int formed = 0;

        HashMap<Character, Integer> windowMap = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            if (targetMap.containsKey(c) && windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                ++formed;
            }

            while (left <= right && formed == required) {
                char q = s.charAt(left);
                if ((right - left + 1 < minLen)) {
                    minLeft = left;
                    minRight = right;
                    minLen = right - left + 1;
                }

                if (targetMap.containsKey(q) && windowMap.get(q) < targetMap.get(q)) {
                    --formed;
                }

                ++left;
            }

            ++right;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight + 1);

    }

    static void permutation(int l, char[] arr) {
        int r = arr.length;
        System.out.print("l: " + l + "r: " + r);
        System.out.println(arr);

        if (l >= r - 1) {
            System.out.print("res----------------------------------------");
            System.out.println(arr);
            return;
        }

        for (int i = l; i < r; ++i) {
            swap(i, l, arr);
            permutation(l + 1, arr);
            swap(i, l, arr);
        }
    }

    static void swap(int i, int j, char[] arr) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    static void toh(int n) {
        tohAux(n, "A", "B", "C");
    }

    private static void tohAux(int n, String a, String b, String c) {
        if (n == 1) {
            System.out.println("Moving Disk 1 from " + a + " to " + c);
            return;
        }
        tohAux(n - 1, a, c, b);
        System.out.println("Moving Disk " + n + " from " + a + " to " + c);
        tohAux(n - 1, b, a, c);
    }


    static public int kthGrammar(int n, int k) {
        if (k == 1) return 0;
        if (k == 2) return 1;

        int mid = (int) (Math.pow(2, n - 1) / 2);

        if (k > mid) {
            return kthGrammar(n - 1, k);
        }

        return rev(kthGrammar(n, (k - mid)));
    }

    static private int rev(int n) {
        if (n == 1) return 0;
        return 1;
    }

    static boolean isGCD(String prefix, String str) {
        if (str.length() % prefix.length() != 0) return false;
        int l = str.length() / prefix.length();
        String fin = "";
        for (int i = 0; i < l; i++) {
            fin = fin + prefix;
        }

        return fin.equals(str);
    }

    static public String gcdOfStrings(String str1, String str2) {
        String small;
        String large;
        if (str1.length() > str2.length()) {
            small = str2;
            large = str1;
        } else {
            large = str2;
            small = str1;
        }

        for (int i = small.length(); i >= 0; i++) {
            String prefix = small.substring(0, i);
            System.out.println("prefix:" + prefix);
            if (prefix.length() > 0 && isGCD(prefix, large) && isGCD(prefix, small)) {
                return prefix;
            }
        }

        return "";
    }

    static public boolean canPlaceFlowers(int[] flowerbed, int count) {
        int n = flowerbed.length;

        int i = 0;
        if (flowerbed[0] == 1) {
            while (i < n - 1 && flowerbed[i] == 1) {
                ++i;
            }
            i = i + 1;
        }

        for (; i < n - 1; ++i) {
            if (flowerbed[i] == 0 && i + 1 < n - 1 && flowerbed[i + 1] == 0) {
                count--;
                flowerbed[i] = 1;
            }
            while (i < n - 1 && flowerbed[i] == 1) {
                ++i;
            }
            if (count <= 0) {
                for (int j = 0; j < n; j++) {
                    System.out.print(flowerbed[j] + "\t");
                }
                return true;
            }
        }

        if (i == n - 1 && (n - 2 >= 0 && flowerbed[n - 2] == 0) && flowerbed[i] == 0) {
            flowerbed[i] = 1;
            count--;
        }
        if (count <= 0) {
            System.out.print("end");
            for (int j = 0; j < n; j++) {
                System.out.print(flowerbed[j] + "\t");
            }
            return true;
        }


        System.out.println("#####################");
        for (int j = 0; j < n; j++) {
            System.out.print(flowerbed[j] + "\t");
        }
        return false;
    }

    static class topKFrequentAux {
        public int a;
        public int b;

        public topKFrequentAux(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(len + 1);
        for (int i = 0; i < len + 1; ++i) {
            arr.add(i, new ArrayList<>());
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int s : map.keySet()) {
            int count = map.get(s);
            arr.get(count).add(s);
        }
        int[] res = new int[k];
        int i = len;
        int idx = 0;
        while (idx < k) {
            ArrayList<Integer> a = arr.get(i);
            if (a.size() > 0) {
                for (int j = 0; j < a.size(); j++) {
                    res[idx] = a.get(j);
                    ++idx;
                }
            }
            --i;
        }
        return res;
    }


    static int countCoinsAux(int[] coins, int n, int sum, HashMap<String, Integer> map) {
        if (sum == 0) return 1;
        if (sum < 0) return 0;
        if (n <= 0) return 0;
        String str = n + ":" + sum;
        if (map.containsKey(str)) return map.get(str);
        if (coins[n - 1] > sum) {
            int res = countCoins(coins, n - 1, sum);
            map.put(str, res);
            return res;
        }
        int res = countCoins(coins, n - 1, sum) + countCoins(coins, n, sum - coins[n - 1]);
        map.put(str, res);
        return res;
    }

    static int countCoins(int[] coins, int n, int sum) {
        return countCoinsAux(coins, n, sum, new HashMap<String, Integer>());
    }

    static public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < strs.length; ++i) {
            String keyStr = getCharArrayStr(strs[i]);
            if (map.containsKey(keyStr)) {
                int place = map.get(keyStr);
                List<String> a = res.get(place);
                a.add(strs[i]);
            } else {
                List<String> a = new ArrayList<>();
                a.add(strs[i]);
                res.add(a);
                map.put(keyStr, res.size() - 1);
            }
        }
        return res;
    }

    static String getCharArrayStr(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            int count = map.getOrDefault((char) ('a' + i), 0);
            res.append((char) ('a' + i));
            res.append(count);
        }

        return res.toString();
    }

    static public int bs(int[] arr, int elem) {
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == elem) return mid;
            if (arr[mid] > elem) right = mid - 1;
            if (arr[mid] <= elem) {
                ans = mid;
                left = mid + 1;
            }
        }
        return ans;
    }

    // [7,1,5,3,6,4]
    static public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > min) {
                profit = prices[i] - min;
            } else {
                min = prices[i];
            }
        }
        return profit;
    }

    static public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for (int n : nums) {
            s.add(n);
        }
        return s.size() == nums.length;
    }

    static public int[] productExceptSelf(int[] nums) {


        int n = nums.length;
        int prod = 1;
        int[] res = new int[n];
        HashSet<Integer> zero = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero.add(i);
            } else {
                prod = prod * nums[i];
            }
        }

        if (zero.size() > 1) {
            for (int i = 0; i < n; i++) {
                res[i] = 0;
            }
            return res;
        }

        for (int i = 0; i < n; i++) {
            if (zero.size() > 0 && !zero.contains(i)) {
                res[i] = 0;
            } else if (zero.contains(i)) res[i] = prod;
            else res[i] = prod / nums[i];
        }
        return res;
    }

    // [-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int localSum = nums[0];
        int res = nums[0];


        for (int i = 1; i < n; ++i) {
            localSum = localSum + nums[i];
            if (nums[i] > localSum) {
                localSum = nums[i];
            }
            if (localSum > res) {
                res = localSum;
            }
        }

        return res;
    }

    // [3,4,5,1,2]
    public int findMin(int[] nums) {
        return findMinAux(nums, 0, nums.length - 1);
    }

    int findMinAux(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 1) return nums[start];
        if (n == 2) return Math.min(nums[start], nums[end]);
        int mid = (start + end) / 2;

        if (nums[start] > nums[mid] && nums[mid] > nums[end]) {
            return nums[end];
        } else if (nums[start] > nums[mid] && nums[mid] < nums[end]) {
            return findMinAux(nums, start, mid);
        } else if (nums[start] < nums[mid] && nums[mid] > nums[end]) {
            return findMinAux(nums, mid, end);
        } else {
            return nums[start];
        }
    }

    public static void zeroMatrix(int[][] matrix) {
        int l = matrix.length;
        int w = matrix[0].length;

        boolean doesHaveZeroAtCol = false;
        boolean doesHaveZeroAtRow = false;

        for (int i = 0; i < w; ++i) {
            if (matrix[0][i] == 0) {
                doesHaveZeroAtCol = true;
            }
            matrix[0][i] = matrix[0][i];
        }


        for (int i = 0; i < l; ++i) {
            if (matrix[i][0] == 0) {
                doesHaveZeroAtRow = true;
            }
            matrix[i][0] = matrix[i][0];
        }


        for (int i = 1; i < l; ++i) {
            for (int j = 1; j < w; ++j) {
                matrix[i][j] = matrix[i][j];
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < l; ++i) {
            for (int j = 1; j < w; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if (doesHaveZeroAtRow) {
            for (int i = 0; i < l; ++i) {
                matrix[i][0] = 0;
            }
        }

        if (doesHaveZeroAtCol) {
            for (int i = 0; i < w; ++i) {
                matrix[0][i] = 0;
            }
        }
    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println();
        }
    }

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            if (area > res) res = area;
            if (height[l] > height[r]) --r;
            else ++l;
        }
        return res;
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (!isReverseSorted(nums, i)) {
                pivot = i;
                break;
            }
        }

        if (pivot == -1) {
            Arrays.sort(nums);
        } else {
            int larger = Integer.MAX_VALUE;
            int largerIdx = -1;
            for (int i = pivot + 1; i < n; ++i) {
                if (nums[i] < larger && nums[i] > nums[pivot]) {
                    largerIdx = i;
                    larger = nums[i];
                }
            }
            int p = nums[pivot];
            nums[pivot] = larger;
            nums[largerIdx] = p;
            Arrays.sort(nums, pivot + 1, n);
        }

    }


    private static boolean isReverseSorted(int[] nums, int i) {
        for (int j = i; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j] < nums[j + 1]) {
                return false;
            }
        }
        return true;
    }


    public static void sortColors(int[] nums) {
        int lI = 0;
        int hI = nums.length - 1;
        int mI = 0;
        while (mI <= hI) {
            switch (nums[mI]) {
                case 0:
                    int t = nums[lI];
                    nums[lI] = nums[mI];
                    nums[mI] = t;
                    lI++;
                    mI++;
                    break;
                case 1:
                    mI++;
                    break;
                case 2:
                    int t1 = nums[hI];
                    nums[hI] = nums[mI];
                    nums[mI] = t1;
                    hI--;
                    break;
            }
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                int idx = n - j;
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][idx];
                matrix[i][idx] = t;
            }
        }
    }

    public static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[][] res = new int[n][2];
        int i = 1;
        int len = 1;

        res[0] = intervals[0];

        while (i < n) {
            if (res[len - 1][1] >= intervals[i][0]) {
                res[len - 1][1] = Math.max(intervals[i][1], res[len - 1][1]);
            } else {
                res[len] = intervals[i];
                ++len;
            }
            ++i;
        }
        return Arrays.copyOf(res, len);
    }

    public static List<List<Integer>> generatePascal(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows == 0) return res;
        res.add(new LinkedList<>());
        res.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = res.get(i - 1);
            List<Integer> v = new LinkedList<>();
            v.add(1);
            for (int j = 1; j < i; ++j) {
                int item = prev.get(j - 1) + prev.get(j);
                v.add(item);
            }
            v.add(1);
            res.add(v);
        }
        return res;
    }


    public static int[] findDuplicate1(ArrayList<Integer> arr, int n) {
        int xor = 0;
        for (int i = 0; i < n; ++i) {
            xor = xor ^ arr.get(i);
        }

        for (int i = 1; i <= n; i++) {
            xor = xor ^ i;
        }
        int z = xor;
        int pos = 1;
        int m = 1;
        while ((z & m) == 0) {
            m = m << 1;
            ++pos;
        }

        int rm0 = 0;
        int rm1 = 0;
        for (int i = 0; i < n; i++) {
            if ((arr.get(i) & m) == 0) {
                rm0 = rm0 ^ arr.get(i);
            } else {
                rm1 = rm1 ^ arr.get(i);
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & m) == 0) {
                rm0 = rm0 ^ i;
            } else {
                rm1 = rm1 ^ i;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((arr.get(i)) == rm0) {
                ++count;
            }
        }
        if (count == 2) return new int[]{rm1, rm0};
        return new int[]{rm0, rm1};
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        fast = nums[0];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = (rows * cols) - 1;


        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("Mid: " + mid);
            int[] pos = getRowColFromInt(mid, rows, cols);
            int i = pos[0];
            int j = pos[1];
            System.out.println(i + " " + j);
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }


    private static int[] getRowColFromInt(int n, int rows, int cols) {
        int row = n / cols;
        int col = n % cols;
        return new int[]{row, col};
    }


    public static double myPow(double x, int n) {
        long newN = n;
        if (newN < 0) newN = -1 * newN;
        System.out.println(newN);
        double result = 1;
        while (newN > 0) {
            System.out.println(newN);
            if (newN % 2 == 1) {
                result = result * x;
                newN = newN - 1;
            } else {
                x = x * x;
                newN = newN / 2;
            }
        }

        if (n < 0) return 1 / result;
        return result;
    }

    public static long getInversions(long arr[], int n) {
        return mergeSort(arr, 0, n - 1);
    }

    public static int mergeSort(long[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += merge(low, mid, high, arr);  // merging sorted halves
        return cnt;
    }

    public static int merge(int low, int mid, int high, long[] arr) {
        ArrayList<Long> tmp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        int count = 0;
        while (left <= mid && right <= high) {
            if (arr[right] < arr[left]) {
                tmp.add(arr[right]);
                count = count + (mid - left);
                ++right;
            } else {
                tmp.add(arr[left]);
                ++left;
            }
        }

        while (left <= mid) {
            tmp.add(arr[left]);
            ++left;
        }

        while (right <= high) {
            tmp.add(arr[right]);
            ++right;
        }

        for (int i = low; i <= high; ++i) {
            arr[i] = tmp.get(i - low);
        }

        return count;
    }


    public int majorityElement3(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        int e1 = Integer.MIN_VALUE;
        int e2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == e1) ++c1;
            else if (nums[i] == e2) ++c2;
            else if (c1 == 0 && nums[i] != e2) {
                c1++;
                e1 = nums[i];
            } else if (c2 == 0 && nums[i] != e1) {
                c2++;
                e2 = nums[i];
            } else {
                --c1;
                --c2;
            }
        }

        int o1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == e1) ++o1;
        }
        if (o1 > Math.floor(nums.length / 3.0)) return e1;
        return e2;
    }


    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> map = new HashMap<>();
        return doUniquePaths(0, 0, m, n, map);
    }

    public int doUniquePaths(int currM, int currN, int m, int n, HashMap<String, Integer> map) {
        if (currM > m || currN > n) return 0;
        if (currM == m - 1 && currN == n - 1) return 1;
        String key = (m - 1) + "-" + (n - 1);
        if (map.containsKey(key)) return map.get(key);
        int res = doUniquePaths(currM + 1, currN, m, n, map) + doUniquePaths(currM, currN + 1, m, n, map);
        map.put(key, res);
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                long sum = nums[i] + nums[j];
                long find = target - sum;
                int hi = n - 1;
                int lo = j + 1;
                while (lo < hi) {
                    String str = nums[i] + ":" + nums[j] + ":" + nums[lo] + ":" + nums[hi];
                    long s = nums[lo] + nums[hi];
                    if (s == find) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[lo]);
                        tmp.add(nums[hi]);

                        if (!set.contains(str)) {
                            res.add(tmp);
                        }
                        set.add(str);
                        ++lo;
                        --hi;
                    } else if (s > find) {
                        --hi;
                    } else {
                        ++lo;
                    }
                }
            }
        }
        return res;
    }


    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int len = 1;
                while (set.contains(nums[i] + len)) {
                    ++len;
                }
                if (len > max) max = len;
            }
        }

        return max;
    }


    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        int n = arr.size();
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; ++i) {
            preSum[i] = preSum[i - 1] + arr.get(i - 1);
            map.put(preSum[i], i);
        }

        int res = 0;

        for (int i = 0; i < n + 1; i++) {
            int target = preSum[i];
            if (map.containsKey(target)) {
                int len = map.get(target) - i;
                res = Math.max(res, len);
            }
        }
        return res;
    }


    public static int subarraysWithSumK(int[] a, int b) {
        int n = a.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int xor = 0;

        for (int i = 1; i <= n; ++i) {
            xor = xor ^ a[i - 1];

            int target = b ^ xor;

            res = res + map.getOrDefault(target, 0);
            map.put(xor, map.getOrDefault(xor, 0) + 1);

        }
        return res;
    }

    public static void printMap(HashMap<Character, Integer> map) {
        for (Character c : map.keySet()) {
            System.out.println(c + "\t" + map.get(c));
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int lo = 0;
        int hi = 1;
        int res = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        int curr = 1;
        while (hi < s.length()) {
            System.out.println("loop");
            if (map.getOrDefault(s.charAt(hi), -1) < lo) {
                map.put(s.charAt(hi), hi);
                ++hi;
                ++curr;
                System.out.println("if:" + curr);
            } else {
                int pos = map.get(s.charAt(hi));
                lo = pos + 1;
                curr = hi - lo;
                System.out.println("else:" + curr);
            }
            System.out.println(curr);
            printMap(map);
            res = Math.max(curr, res);
        }
        return res;
    }


    public class ListNode {
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


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode res;
        ListNode ans;
        if (curr1.val < curr2.val) {
            res = curr1;
            ans = curr1;
            curr1 = curr1.next;
        } else {
            res = curr2;
            ans = curr2;
            curr2 = curr2.next;
        }

        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                res.next = curr1;
                res = curr1;
                curr1 = curr1.next;
            } else {
                res.next = curr2;
                res = curr2;
                curr2 = curr2.next;
            }
        }

        while (curr1 != null) {
            res.next = curr1;
            res = curr1;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            res.next = curr2;
            res = curr2;
            curr2 = curr2.next;
        }

        return ans;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode curr = head;
        ListNode curr1 = head;
        for (int i = 0; i < n; ++i) {
            curr = curr.next;
        }

        while (curr != null) {
            curr = curr.next;
            curr1 = curr1.next;
        }

        curr1.next = curr1.next.next;

        return start.next;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int curr = 0;

        for (int num : nums) {
            switch (num) {
                case 0:
                    curr = 0;
                    break;
                case 1:
                    curr = curr + 1;
                    res = Math.max(res, curr);
                    break;
                default:
                    return -1;
            }
        }
        return res;
    }

    public int maxPower(String s) {
        int res = 0;
        int curr = 0;
        char currChar = '-';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == currChar) {
                ++curr;
                res = Math.max(res, curr);
            } else {
                curr = 0;
                currChar = c;
            }
        }
        return res;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null;
        ListNode temp = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            ListNode l = new ListNode(sum);
            if (res == null) {
                res = l;
                temp = l;
            } else {
                temp.next = l;
                temp = temp.next;
            }
        }
        return res;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2 = 0;
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1 != null) {
            h1 = h1.next;
            ++l1;
        }
        while (h2 != null) {
            h2 = h2.next;
            ++l2;
        }
        h1 = headA;
        h2 = headB;
        int diff = Math.abs(l1 - l2);

        if (l1 > l2) {
            for (int i = 0; i < diff; i++) {
                h1 = h1.next;
            }
        }

        if (l2 > l1) {
            for (int i = 0; i < diff; i++) {
                h2 = h2.next;
            }
        }


        while (h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1;
    }


    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode grpPrev = dummy;

        while (true) {
            ListNode kth = getKthNode(grpPrev, k);
            if (kth == null) {
                break;
            }
            ListNode curr = grpPrev.next;
            ListNode grpNext = kth.next;
            ListNode p = kth.next;
            while (curr != grpNext) {
                ListNode n = curr.next;
                curr.next = p;
                p = curr;
                curr = n;
            }

            ListNode tmp = grpPrev.next;
            grpPrev.next = kth;
            grpPrev = tmp;
        }

        return dummy.next;
    }

    public ListNode getKthNode(ListNode start, int k) {
        ListNode curr = start;
        int i = 0;
        while (curr != null && i < k) {
            curr = curr.next;
            ++i;
        }
        return curr;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) break;
        }
        if (fast == null) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        int len = 0;
        ListNode lenCur = head;
        while (lenCur != null) {
            lenCur = lenCur.next;
            ++len;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode curr = head;
        ListNode p = mid.next;
        while (curr != mid) {
            ListNode n = curr.next;
            curr.next = p;
            p = curr;
            curr = n;
        }
        head = p;
        if (len % 2 == 1) mid = mid.next;
        while (mid != null) {
            if (head.val != mid.val) return false;
            mid = mid.next;
            head = head.next;
        }
        return true;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int len = 0;
        ListNode lenCur = head;
        while (lenCur != null) {
            lenCur = lenCur.next;
            ++len;
        }
        if (k % len == 0) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        int rotate = k % len;

        ListNode c = head;
        ListNode c2 = head;
        for (int i = 0; i < rotate; i++) {
            c = c.next;
        }

        while (c.next != null) {
            c = c.next;
            c2 = c2.next;
        }
        ListNode kthFromEnd = c2;
        ListNode start = kthFromEnd.next;
        c = dummy.next;
        while (c.next != null) {
            c = c.next;
        }
        c.next = head;
        c2.next = null;
        return start;
    }


    public static int trap(int[] height) {
        int n = height.length;

        int[] left = new int[n];
        left[0] = -1;
        int max = -1;

        for (int i = 1; i < n; i++) {
            max = Math.max(max, height[i - 1]);
            left[i] = max;
        }

        int[] right = new int[n];
        left[n - 1] = -1;
        max = -1;

        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, height[i + 1]);
            right[i] = max;
        }


        int sum = 0;
        for (int i = 0; i < n; i++) {
            int le = left[i];
            int ri = right[i];
            int water = Math.max(Math.min(le, ri) - height[i], 0);
            System.out.println(le + "\t" + ri + "\t" + height[i] + "\t" + water);
            sum = sum + water;
        }

        return sum;
    }

    public static int removeDuplicates(int[] nums) {
        int dupIndex = 0;
        int largest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == largest) {
                if (dupIndex == 0) {
                    dupIndex = i;
                }
            } else {
                largest = nums[i];
                if (dupIndex != 0) {
                    int tmp = nums[i];
                    nums[i] = nums[dupIndex];
                    nums[dupIndex] = tmp;
                    ++dupIndex;
                }
            }
        }
        if (dupIndex == 0) return nums.length;
        else return dupIndex;
    }


    static class Node {
        public int data;
        public Node next;
        public Node child;

        Node() {
            this.data = 0;
            this.next = null;
            this.child = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.child = null;
        }

        Node(int data, Node next, Node child) {
            this.data = data;
            this.next = next;
            this.child = child;
        }
    }

    public static Node flattenLinkedList(Node head) {
        if (head == null || head.next == null) return head;
        if (head.next.next != null) {
            head.next = flattenLinkedList(head.next);
        }
        Node res = mergeFlatLL(head);
        Node d = res;
        while (res != null) {
            res.next = null;
            res = res.child;
        }

        return d;
    }

    private static Node mergeFlatLL(Node head) {
        Node dummy = new Node(0);

        Node first = head;
        Node second = head.next;
        Node res;

        if (first.data <= second.data) {
            res = first;
            first = first.child;
        } else {
            res = second;
            second = second.child;
        }
        dummy.child = res;


        while (first != null && second != null) {
            if (first.data <= second.data) {
                res.child = first;
                first = first.child;
            } else {
                res.child = second;
                second = second.child;
            }
            res = res.child;
        }

        if (first != null) {
            res.child = first;
        } else {
            res.child = second;
        }
        return dummy.child;
    }


    static class T {
        int a;
        int b;

        public T(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "T{" + "a=" + a + ", b=" + b + '}';
        }
    }

    public static int maxMeetings(int at[], int dt[], int n) {
        T[] meets = new T[n];
        for (int i = 0; i < n; ++i) {
            meets[i] = new T(at[i], dt[i]);
        }

        Arrays.sort(meets, Comparator.comparingInt(o -> o.b));

        int res = 0;
        int t = -1;
        for (int i = 0; i < n; ++i) {
            if (meets[i].a >= t) {
                ++res;
                t = meets[i].b;
                System.out.println(meets[i]);
            }
        }
        return res;
    }


    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }

        @Override
        public String toString() {
            return "Job{" + "id=" + id + ", profit=" + profit + ", deadline=" + deadline + '}';
        }
    }

    static int[] JobScheduling(Job arr[], int n) {
        TreeSet<Integer> ts = new TreeSet<>();

        Arrays.sort(arr, (o1, o2) -> o2.profit - o1.profit);
        for (int i = 1; i <= n; i++) {
            ts.add(i);
        }

        int profit = 0;
        int jobs = 0;

        for (int i = 0; i < n; i++) {
            Integer last = ts.floor(arr[i].deadline);
            if (last != null) {
                profit += arr[i].profit;
                jobs++;
                ts.remove(last);
            }
        }
        return new int[]{jobs, profit};
    }

    static class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }

        @Override
        public String toString() {
            return "Item{" + "value=" + value + ", weight=" + weight + '}';
        }
    }

    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double v1 = ((double) (o1.value) / o1.weight);
                double v2 = ((double) (o2.value) / o2.weight);
                if (v1 > v2) return -1;
                if (v1 < v2) return 1;
                return 0;
            }
        });
        for (int i = 0; i < n; ++i) {
            System.out.println(arr[i]);
        }

        int w = 0;
        double res = 0;
        int i = 0;
        while (w < W && i < n) {
            if ((W - w) < arr[i].weight) {
                int wt = (W - w);
                res = res + ((W - w) * ((double) (arr[i].value) / arr[i].weight));
                w = w + wt;
            } else {
                w = w + arr[i].weight;
                res = res + arr[i].value;
            }
            System.out.println(w + "\t" + res);
            ++i;
        }

        return res;
    }


    public static int findMinimumCoins(int amount) {
        int[] c = new int[]{1000, 500, 100, 50, 20, 10, 5, 2, 1};
        int res = 0;
        int amt = 0;
        int i = 0;
        while (amt < amount) {
            int req = amount - amt;
            if (c[i] <= req) {
                int coins = req / c[i];
                res = res + (coins);
                amt = amt + (coins * c[i]);
            }
            ++i;
        }
        return res;
    }


    public static ArrayList<Integer> subsetSum(int num[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = num.length;
        subsetSumLen(num, 0, 0, len, res);
        return res;
    }

    private static void subsetSumLen(int[] num, int sum, int start, int len, ArrayList<Integer> res) {
        if (start == len) {
            res.add(sum);
            return;
        }
        subsetSumLen(num, sum + num[start], start + 1, len, res);
        subsetSumLen(num, sum, start + 1, len, res);

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumAux(0, candidates, target, res, new ArrayList<>());
        return res;
    }

    private void combinationSumAux(int i, int[] candidates, int target, List<List<Integer>> res, ArrayList<Integer> curr) {
        if (i >= candidates.length) return;
        if (target == 0 && i == candidates.length - 1) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) return;
        combinationSumAux(i + 1, candidates, target, res, new ArrayList<>(curr));
        curr.add(candidates[i]);
        combinationSumAux(i, candidates, target - candidates[i], res, curr);
    }

    public static List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDupAux(num, 0, res, new ArrayList<>());
        return res;
    }

    private static void subsetsWithDupAux(int[] num, int start, List<List<Integer>> res, ArrayList<Integer> curr) {
        res.add(new ArrayList<>(curr));
        for (int i = start; i < num.length; i++) {
            if (i != start && num[i] == num[i - 1]) continue;
            curr.add(num[i]);
            subsetsWithDupAux(num, i + 1, res, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        combinationSum2Aux(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void combinationSum2Aux(int[] candidates, int target, int start, ArrayList<Integer> curr, List<List<Integer>> res) {
        if (target == 0) res.add(new ArrayList<>(curr));
        if (target < 0) return;
        if (start >= candidates.length) return;
        for (int i = start; i < candidates.length; i++) {
            if (i != start && candidates[i] == candidates[i - 1]) continue;
            curr.add(candidates[i]);
            combinationSum2Aux(candidates, target - candidates[i], i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        partitionAux(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void partitionAux(String s, int start, ArrayList<String> curr, List<List<String>> res) {
        if (start == s.length() - 1) {
            res.add(new ArrayList<>(curr));
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                curr.add(s.substring(start, i + 1));
                partitionAux(s, i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }

    }

    static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteAux(nums, 0, res);
        return res;
    }

    private void permuteAux(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length - 1) {
            List<Integer> k = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                k.add(nums[i]);
            }
            res.add(k);
            return;
        }
        if (start >= nums.length) return;
        for (int i = start; i < nums.length; i++) {
            swap(i, start, nums);
            permuteAux(nums, i + 1, res);
            swap(i, start, nums);
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static int NthRoot(int n, int m) {
        return NthRootAux(2, m, n, m);
    }

    private static int NthRootAux(int start, int end, int n, int m) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        double p = Math.pow(mid, n);
        if (p == m) return mid;
        if (p > m) return NthRootAux(start, mid - 1, n, m);
        return NthRootAux(mid + 1, end, n, m);
    }


    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        return singleNonDuplicateAux(0, nums.length - 1, nums);
    }

    private static int singleNonDuplicateAux(int start, int end, int[] nums) {

        if (start > end) return -1;
        int mid = (start + end) / 2;

        int before = -1;
        if (mid - 1 >= 0) before = nums[mid - 1];

        int after = -1;
        if (mid + 1 < nums.length) after = nums[mid + 1];
        if (before != nums[mid] && after != nums[mid]) return nums[mid];

        int idx = 0;
        if (before == nums[mid]) idx = mid - 1;
        if (after == nums[mid]) idx = mid + 1;

        int larger = Math.max(idx, mid);

        if (larger % 2 == 0) {
            return singleNonDuplicateAux(start, mid - 1, nums);
        } else {
            return singleNonDuplicateAux(mid + 1, end, nums);
        }
    }


    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return findMedianSortedArrays(b, a);
        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;

    }

    public static long ayushGivesNinjatest(int days, int chapters, int[] time) {
        long high = 0;
        long low = 0;
        for (int j : time) {
            high = high + j;
            low = Math.max(low, j);
        }

        while (low <= high) {
            long mid = (low + high) / 2;
            long estDays = countDays(time, mid);
            if (estDays > days) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static long countDays(int[] time, long chapterCount) {
        int n = time.length;
        long days = 1;
        long chapsDone = 0;
        for (int i = 0; i < n; i++) {
            if (chapsDone + time[i] <= chapterCount) {
                chapsDone += time[i];
            } else {
                ++days;
                chapsDone = time[i];
            }
        }
        return days;
    }


    static int bst(int[] arr, int elem) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == elem) {
                return mid;
            } else if (arr[mid] > elem) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }


    static class TreeNode2<T> {
        T data;
        TreeNode2<T> left;
        TreeNode2<T> right;

        TreeNode2(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static ArrayList<Integer> getLeftView(TreeNode2<Integer> root) {
        ArrayList<Integer> res = new ArrayList<>();
        getLeftViewAux(res, 0, root);
        return res;
    }

    public static void getLeftViewAux(ArrayList<Integer> res, int level, TreeNode2<Integer> root) {
        if (res.size() - 1 < level && root != null) {
            res.add(root.data);
        }
        getLeftViewAux(res, level + 1, root.left);
        getLeftViewAux(res, level + 1, root.right);
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair {

        TreeNode node;
        int level;
        int pos;

        public Pair(TreeNode root, int level, int pos) {
            this.node = root;
            this.level = level;
            this.pos = pos;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "node=" + node +
                    ", level=" + level +
                    ", pos=" + pos +
                    '}';
        }
    }

    static class P {
        int min;
        int max;

        public P(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    static public int widthOfBinaryTree(TreeNode root) {
        ArrayList<Pair> list = new ArrayList<>();
        ArrayList<Pair> traverse = new ArrayList<>();
        list.add(new Pair(root, 0, 1));
        traverse.add(new Pair(root, 0, 1));
        while (!list.isEmpty()) {
            Pair p = list.remove(0);
            int level = p.level + 1;
            Pair left = new Pair(p.node.left, level, p.pos * 2);
            Pair right = new Pair(p.node.right, level, (p.pos * 2) + 1);
            if (left.node != null) {
                list.add(left);
                traverse.add(left);
            }
            if (right.node != null) {
                list.add(right);
                traverse.add(right);
            }
        }

        HashMap<Integer, P> map = new HashMap<>();

        for (int i = 0; i < traverse.size(); i++) {
            Pair v = traverse.get(i);
            if (map.containsKey(v.level)) {
                int min = map.get(v.level).min;
                int max = map.get(v.level).max;
                int newMin = Math.min(min, v.pos);
                int newMax = Math.max(max, v.pos);
                map.put(v.level, new P(newMin, newMax));
            } else {
                map.put(v.level, new P(v.pos, v.pos));
            }
        }

        int res = 0;

        for (Integer level : map.keySet()) {
            System.out.println(level + ":" + map.get(level).max + ":" + map.get(level).min);
            res = Math.max(res, map.get(level).max - map.get(level).min + 1);
        }

        return res;

    }

}
