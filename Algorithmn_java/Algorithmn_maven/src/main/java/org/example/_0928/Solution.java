package org.example._0928;

class Solution {
    public static int solution(int num) {
        int count = 0;
        long result = num;
        count = recursion(result, count);

        return count;
    }

    public static int recursion(long inputNum, int count) {
        if(inputNum == 1) {
            return count;
        }
        if (count >= 500) {
            return -1;
        }
        return (inputNum % 2  == 0)? recursion(inputNum/2, ++count) : recursion(inputNum *3 +1, ++count);
    }

    public static void main(String[] args) {
        solution(626331);
    }

}