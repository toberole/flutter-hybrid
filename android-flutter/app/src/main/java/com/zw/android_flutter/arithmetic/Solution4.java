package com.zw.android_flutter.arithmetic;

import android.util.Log;

public class Solution4 {
    public static final String TAG = Solution4.class.getSimpleName();

    public static void test1() {
        Stack_Queue<String> stringStack_queue = new Stack_Queue<>();
        String s = null;
        s = stringStack_queue.take();
        Log.i(TAG, "s: " + s);
        stringStack_queue.put("hello1");
        stringStack_queue.put("hello2");
        s = stringStack_queue.take();
        Log.i(TAG, "s: " + s);
    }

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public int fib1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int n1 = fib1(n - 1);
        int n2 = fib1(n - 2);
        return n1 + n2;
    }

    public int fib2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0;
        int b = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }

    public int findRepeatNumber(int[] nums) {
        int arr[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if (arr[k] != 0) return k;
            arr[k] = k;
        }

        return 0;
    }

    public static long jump2(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        long n1 = 1;
        long n2 = 2;
        long count = 2;
        while (count++ <= n) {
            long tmp = n1;
            n1 = n2;
            n2 = tmp + n2;
        }
        return n2;
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1;

        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) return true;

            if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int r = matrix.length;
        int c = matrix[0].length;
        int r1 = 0;
        int c1 = c;

        while (r1 < r && c1 >= 0) {
            if (matrix[r1][c1] == target) return true;

            if (matrix[r1][c1] > target) {
                c1--;
            } else {
                r1++;
            }
        }
        return false;
    }

    public int numWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1;
        int b = 2;
        int s = 0;

        for (int i = 2; i <= n; i++) {
            s = (a + b) % 1000000007;
            a = b;
            b = s;
        }

        return a;
    }

    public int minArray(int[] numbers) {
        int low = 0;
        int hight = numbers.length - 1;
        while (low < hight) {
            int mid = (low + hight) / 2;
            if (numbers[mid] > numbers[hight]) {
                low = mid + 1;
            } else if (numbers[mid] < numbers[hight]) {
                hight = mid;
            } else {
                hight--;
            }
        }
        return numbers[low];
    }

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
            return false;
        if (k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return s;

        StringBuffer sb = new StringBuffer();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chs[i]);
            }
        }

        return sb.toString();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        return null;
    }
}