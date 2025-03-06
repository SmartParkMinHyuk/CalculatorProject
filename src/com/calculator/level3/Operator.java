package com.calculator.level3;

enum Operator {

    // symbol 4개의 연산자를 옵션으로 둠
    ADD("+", (x, y) -> x + y),
    SUBTRACT("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        if (y == 0) throw new ArithmeticException("0으로 나눌 수 없습니다");
        return x / y;
    });

    // 연사자 구별을 위한 Symbol 변수 선언
    private final String symbol;

    // 변수의 연산을 담당하는 함수형 인터페이스 선언 -> 연산할때사용
    private final Operation<Integer> operation;

    // 열거형 생성자
    Operator(String symbol, Operation<Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    // history에 연산자를 넣을 때 사용
    public String getSymbol() {
        return symbol;
    }

    // 두개의 변수를 담아와서 함수형 인터페이스를 통해 연산
    public int apply(int a, int b) {
        return operation.apply(a, b);
    }

    // 연산자를 받아와서 활용할수 없다면 지원하지 않는 연산자라고 에러코드를 보낸다.
    public static Operator fromSymbol(String symbol) {
        for (Operator op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자: " + symbol);
    }
}

