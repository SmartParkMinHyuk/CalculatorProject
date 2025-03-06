package com.calculator.level2;

import java.util.List;
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
        Calculator calculator = new Calculator();

        String option = "";

        do {
            try {
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

                int result = calculator.calculate(num1, operator, num2);
                System.out.print("요청하신, 계산 ");

                String notice = num1 + " " + operator + " " + num2 + " 는 " + result;
                System.out.println(notice + " 입니다. ");
                calculator.setHistory(notice); // 적용하기(반드시 해야 적용된다.

                while( true ) {
                    System.out.print("옵션을 선택해주세요 [더 계산하시려면 : 아무키][종료 : exit][히스토리 보기 : history][마지막 히스토리제거 : remove] : ");
                    option = sc.nextLine();

                    if(option.equals("history")) {
                        // getter를 활용
                        if (!calculator.getHistory().isEmpty()) {
                            System.out.println("----------히스토리 리스트입니다.-----------");
                            for (String record : calculator.getHistory()) {
                                System.out.println(record);
                            }
                        } else {
                            System.out.println("---------히스토리가 없습니다. 계산을 해주세요.----------");
                        }
                        continue;
                    }

                    if(option.equals("remove")) {
                        List<String> currentHistory = calculator.getHistory();
                        if (!currentHistory.isEmpty()) {
                            currentHistory.remove(currentHistory.remove(0));
                            System.out.println("---------가장 먼저 저장된 데이터 히스토리가 제거 되었습니다.----------");
                        } else {
                            System.out.println("---------제거 할 히스토리가 없습니다. 계산을 해주세요.----------");
                        }
                        continue;
                    }
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("틀렸습니다. 처음부터 다시 계산하세요");
                sc.nextLine();
            }
        } while (!option.equals("exit"));
    }
}