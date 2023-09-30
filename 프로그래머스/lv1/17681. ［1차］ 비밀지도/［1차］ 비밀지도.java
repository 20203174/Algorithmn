class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        answer = checkArr(binaryToIntArray(arr1, n), binaryToIntArray(arr2, n));

        return answer;
    }

    public static int[][] binaryToIntArray(int[] binary, int n) {
        int[][] tmpArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            tmpArr[i] = binaryToInt(binary[i], n);
        }
        return tmpArr;
    }

    public static int[] binaryToInt(int binary, int n) {
        int[] tmpArr = new int[n];
        for (int i = n-1; i >= 0; i--) {
            if(binary == 0) {
                tmpArr[i] = 0;
                continue;
            }
            tmpArr[i] = binary % 2;
            binary /= 2;
        }
        return tmpArr;
    }

    public static String[] checkArr(int[][] arr1, int[][] arr2) {
        String[] tmpStringArr = new String[arr1.length];
        for(int i = 0; i < arr1.length; i++ ) {
            StringBuilder tmpString = new StringBuilder("");
            for(int j = 0; j < arr1.length; j++) {
                if(arr1[i][j] == 1 || arr2[i][j] == 1) {
                    tmpString.append("#");
                } else {
                    tmpString.append(" ");
                }
            }
            tmpStringArr[i] = tmpString.toString();
        }
        return tmpStringArr;
    }
}