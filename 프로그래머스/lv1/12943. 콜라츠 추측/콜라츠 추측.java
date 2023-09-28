class Solution {
    public static int solution(int num) {
        if(num == 1) {
            return 0;
        }
        int count = 0;
        long result = num;
        do{
            if(count >= 500) {
                return -1;
            }
            result = recursion(result);
            count++;
            System.out.println(result);
        } while (result != 1);

        return count;
    }

    public static long recursion(long inputNum) {
        if (inputNum % 2 == 0) {
            return inputNum / 2;
        } else {
            return (inputNum * 3 + 1);
        }
    }

}