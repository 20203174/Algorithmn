package org.example._0914;//소수를 분수로 구현하기

import java.math.BigDecimal;

public class Main {

    public static class Fraction {
        private int numerator; // 분자
        private int denominator; // 분모

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            normalize();
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        public void normalize() {
            int dividedValue = gcd(numerator, denominator);
            this.numerator = getNumerator() / dividedValue;
            this.denominator = getDenominator() / dividedValue;
            
        }

        public int gcd(int a, int b) { //최대공약수
            while(b!=0) {
              int r=a%b;
              a=b;
              b=r;
            }
            return a;
          }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }

    }

    /**
     * 소수점 값에 대해 자리 수 계산 하는 메서드. <br/>
     * ex) <br/>
     * 0.01 -> 100을 곱하기 위해 2를 return <br/>
     * 0.1 -> 10을 곱하기 위해 1을 return
     *
     *
     * @param num 소수 값
     * @return 소수점 이하 자리 수 값
     */
    public static int getDecimalNumber(BigDecimal num) {
        String str = num.toPlainString();
        // Fraction fraction = new Fraction(Integer.parseInt(str), (int) (Math.pow(10, str.length())));
        // fraction.normalize();

        return str.substring(str.indexOf(".")+1).length();
    }

    public static String solution(String input) {
        // 소수점 자리만큼 10의 n승
        // 약분(최대공약수로)
        BigDecimal number = new BigDecimal(input);

        int decimalNumber = getDecimalNumber(number);

        double denominator = (Math.pow(10, decimalNumber));
        int numerator = (int) (number.doubleValue() * denominator);

        return new Fraction(numerator, (int) denominator).toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("0.01"));
        System.out.println(solution("0.25"));
    }

}