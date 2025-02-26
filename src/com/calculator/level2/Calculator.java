package com.calculator.level2;

/*
 제목 : 클래스를 사용해서 계산기 만들기
 날짜 : 2025/02/26
 작성자 : 박민혁
 개요 : 계산기의 클래스파일이다. 해당 클래스에서 연산을 진행한다.
*/
public class Calculator {
    public static int calculate(int num1, char operator, int num2) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다. 처음부터 다시 계산하세요");
                }
            default:
                throw new IllegalArgumentException("잘못된 연산 기호입니다. 처음부터 다시 계산하세요");
        }
    }
}
