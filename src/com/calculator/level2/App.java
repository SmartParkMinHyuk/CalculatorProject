package com.calculator.level2;

import java.util.Scanner;

/*
 제목 : 클래스를 사용해서 계산기 만들기
 날짜 : 2025/02/26 17:13
 작성자 : 박민혁
 개요 : 코딩스파르타 Spring 과정 2주차 LEVEL 2 과제 ( LEVEL 2/3 )
 주의 : 클래스를 사용해서 계산기를 실행시킨다..
*/
public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String option = "";
        Calculator calculator = new Calculator();

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

            try {
                int result = calculator.calculate(num1, operator, num2);
                System.out.println("결과: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue; // 오류 발생 시, 현재 반복 건너뛰기
            }

            // 결과 히스토리
             calculator.resultHistory();

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
            option = sc.nextLine();

        } while (!option.equals("exit"));
    }
}