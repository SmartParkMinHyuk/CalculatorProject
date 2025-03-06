package com.calculator.level3;

import java.util.Scanner;

/*
 제목 : 제네릭, enum, 람다식, 스트림 사용해서 계산기 만들기
 날짜 : 2025/03/06 13:00
 작성자 : 박민혁
 개요 : 코딩스파르타 Spring 과정 2주차 LEVEL 3 과제 ( LEVEL 3/3 )
*/
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        String option = "";

        do {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /): ");
                String operator = sc.next();

                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt();

                sc.nextLine();  // 버퍼에 남은 개행 문자 소비

                Operator op = Operator.fromSymbol(operator);
                int result = calculator.calculate(num1, num2, op);

                System.out.println("계산 결과: " + result);

                while (true) {
                    System.out.print("옵션을 선택해주세요 [더 계산하시려면 아무 키][종료: exit][히스토리 보기: history][마지막 히스토리 제거: remove]: ");
                    option = sc.nextLine();

                    if (option.equals("history")) {
                        calculator.printHistory();
                        continue;
                    }

                    if (option.equals("remove")) {
                        calculator.removeLastHistory();
                        continue;
                    }

                    if (option.equals("exit")) {
                        System.out.println("계산기를 종료합니다.");
                        break;
                    }
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("오류: " + e.getMessage());
            } catch (ArithmeticException  e){
                System.out.println("산술 오류: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
                sc.nextLine();  // 잘못된 입력 처리 후 버퍼 초기화
            }
        } while (!option.equals("exit"));

        sc.close(); // Scanner 리소스 해제
    }
}
