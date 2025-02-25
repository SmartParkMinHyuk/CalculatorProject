package com.calculator.level1;

import java.util.Scanner;

/*
 제목 : 클래스를 사용하지 않고, 계산기 만들기
 날짜 : 2025/02/25 20:07
 작성자 : 박민혁
 개요 : 코딩스파르타 Spring 과정 2주차 LEVEL 1 과제 ( LEVEL 1/3 )
 주의 : 클래스를 사용하지 않고, 실행시킨다.
*/
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String option = "";
        do {
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            int num1 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 : ");
            char operator = sc.next().charAt(0);

            System.out.print("두 번째 숫자를 입력하세요 : ");
            int num2 = sc.nextInt();

            /*
            nextInt() 매서드는 사용자가 입력한 정보만 읽는다.
            입력 후 남은 개행 문자 ('\n')는 버퍼에 남겨둔다.
            따라서, 개행문자를 바로 읽어 빈 문자열을 반환하게 된다.
            이 문제를 피하기 위해, sc.nextInt() 호출 후, sc.nextLine() 추가한다.
            버퍼에 남은 개행 문자를 소비한다.
            */
            sc.nextLine();

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
                    } else {
                        System.out.println("0으로 나눌 수 없습니다. 처음부터 다시 계산하세요");
                        continue;
                    }
                    break;
                default:
                    System.out.println("잘못된 연산 기호입니다. 처음부터 다시 계산하세요");
                    continue;
            }

            System.out.println("결과: " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            option = sc.nextLine();

        }while (!option.equals("exit"));
    }
}
