package com.calculator.level2;

/*
 제목 : 클래스를 사용해서 계산기 만들기
 날짜 : 2025/02/26
 작성자 : 박민혁
 개요 : 계산기의 클래스파일이다. 해당 클래스에서 연산을 진행과 연산히토리를 관리한다.
*/
import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<String> history = new ArrayList<>();

    // HistoryList Getter
    public List<String> getHistory() {
        return this.history;
    }

    // HistoryList Setter
    public void setHistory(String newHistory) {
        this.history.add(newHistory);
    }

    // 계산기능
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
        return result;
    }
}
