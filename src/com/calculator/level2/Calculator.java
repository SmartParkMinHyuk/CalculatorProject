package com.calculator.level2;

/*
 제목 : 클래스를 사용해서 계산기 만들기
 날짜 : 2025/02/26
 작성자 : 박민혁
 개요 : 계산기의 클래스파일이다. 해당 클래스에서 연산을 진행한다.
*/

import java.util.ArrayList;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    ArrayList<String> list = new ArrayList<>();

    public int calculate(int num1, char operator, int num2) {

        int result = 0;

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                    break;
                } else {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다. 처음부터 다시 계산하세요");
                }
            default:
                throw new IllegalArgumentException("잘못된 연산 기호입니다. 처음부터 다시 계산하세요");
        }

        list.add(num1 + operator + num2 + "=" + result);
        return result;
    }

    public void resultHistory() {
        System.out.println(list);
    }

}
