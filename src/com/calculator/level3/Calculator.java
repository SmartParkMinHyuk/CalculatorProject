package com.calculator.level3;

import java.util.ArrayList;
import java.util.List;

class Calculator {

    private List<String> history = new ArrayList<>();

    /**
     * 이 메서드는 두 숫자(`a`와 `b`)와 연산자(`op`)를 받아서 계산을 수행하고 결과를 반환하는 메서드이다.
     * <T extends Number>는 이 메서드가 `Number` 클래스의 하위 타입들(예: `Integer`, `Double`, `Float` 등)을 처리할 수 있도록 한다.
     * 즉, 이 메서드는 숫자 타입의 객체를 받을 수 있습니다.
     *
     * @param num1 첫 번째 숫자 (예: 5)
     * @param num2 두 번째 숫자 (예: 3)
     * @param op 수행할 연산자 (예: 덧셈, 뺄셈 등)
     * @return 연산 결과 (예: 덧셈 결과 8)
     */
    public <T extends Number> int calculate(T num1, T num2, Operator op) {
        int x = num1.intValue();
        int y = num2.intValue();

        int result = op.apply(x, y);
        history.add(String.format("%s %s %s = %s", x, op.getSymbol(), y, result));
        return result;
    }

    // 계산결과 값을 출력한다.
    public void printHistory() {
        if (!history.isEmpty()) {
            System.out.println("----------히스토리 리스트입니다.-----------");

            // 스트림을 사용하여 히스토리 출력
            history.stream()
                    .forEach(System.out::println);  // 람다식 사용하여 출력
        } else {
            System.out.println("---------히스토리가 없습니다. 계산을 해주세요.----------");
        }
    }

    // 계산결과 값에서 가장 먼저 계산된 값을 제거한다.
    public void removeLastHistory() {
        if (!history.isEmpty()) {
            history.remove(0);
            System.out.println("---------가장 먼저 저장된 데이터 히스토리가 제거 되었습니다.----------");
        } else {
            System.out.println("---------제거 할 히스토리가 없습니다. 계산을 해주세요.----------");
        }
    }
}

