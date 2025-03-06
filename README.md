# 계산기 개발 프로젝트

이 프로젝트는 다양한 기능을 지원하는 계산기를 구현하는 것을 목표로 합니다. 본 README는 요구사항 정의와 설계, 그리고 개발 단계별 가이드라인을 포함합니다.

---

## 1. 프로젝트 개요

- **목표**  
  기본적인 사칙연산부터 확장 기능(괄호, 제곱, 제곱근, 실수 연산 등)까지 지원하는 계산기를 개발합니다.

- **사용자 인터페이스**  
  콘솔 기반으로 구현합니다.

- **예외 처리**  
  0으로 나누기 등 계산 중 발생할 수 있는 예외 상황에 대해 적절한 처리를 구현합니다.

---


## 2. 요구사항 정의

### 2.1 기능 요구사항

- **기본 사칙연산**
    - 덧셈, 뺄셈, 곱셈, 나눗셈

- **입력 방식**
    - 실수 입력
    - 사칙연산 기호(➕, ➖, ✖️, ➗) 입력

- **출력**
    - 계산 결과를 출력하며, 오류 발생 시 명확한 오류 메시지 제공

- **반복 계산**
    - “exit” 입력 시 종료될 때까지 무한 반복으로 계산 수행

### 2.2 설계 요구사항

- **클래스 다이어그램**
    - 필요한 클래스 : `Calculator`

- **데이터 흐름 설계**
    - 사용자 입력 → 연산 처리 → 결과 출력의 흐름 파악 및 설계

- **캡슐화**
    - `Calculator` 클래스의 내부 데이터(연산 결과 저장 컬렉션)는 외부에서 직접 접근하지 못하도록 하고, Getter/Setter 메서드를 통해 간접 접근


---


## 3. 추가 요구사항 정의
### 3.1 람다식 (Lambda Expressions)
- **기능 설명**
  - 람다식은 Operator 열거형에서 사칙연산을 구현하는 데 사용됩니다. 이를 통해 각 연산에 대한 연산 로직을 람다식으로 정의하여 코드의 간결성과 가독성을 높일 수 있습니다.
  Calculator 클래스에서 사용자가 입력한 연산 기호에 맞는 연산을 람다식을 통해 처리합니다.

사용 예시:
```java
enum Operator {
  ADD("+", (a, b) -> a + b),
  SUBTRACT("-", (a, b) -> a - b),
  MULTIPLY("*", (a, b) -> a * b),
  DIVIDE("/", (a, b) -> {
    if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다");
      return a / b;
  });

    private final String symbol;
    private final Operation<Double> operation;

    Operator(String symbol, Operation<Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public double apply(double a, double b) {
        return operation.apply(a, b);
    }
}
```

- Operator 열거형에서 각 연산에 대해 람다식을 사용하여 연산을 처리합니다.
예를 들어, ADD 연산자는 (a, b) -> a + b로 덧셈을 수행하는 람다식을 할당하고, apply(a, b)로 호출하여 연산을 수행합니다.


### 3.2 제네릭 (Generics)
  - 제네릭을 사용하여 다양한 데이터 타입(예: Integer, Double)을 처리할 수 있도록 합니다. Operation<T> 인터페이스를 제네릭으로 정의하여 연산을 수행할 수 있습니다.
연산을 수행하는 Calculator 클래스에서 실수와 정수 등 다양한 타입을 처리할 수 있도록 합니다.

```java
@FunctionalInterface
interface Operation<T> {
    T apply(T a, T b);
}

public class Calculator {
    public <T extends Number> double calculate(T a, T b, Operator op) {
        double x = a.doubleValue();
        double y = b.doubleValue();
        return op.apply(x, y);
    }
}
```

- 제네릭을 사용하여 Number 타입을 상속하는 모든 숫자 타입을 처리할 수 있습니다.
예를 들어, Integer, Double 타입의 값을 모두 처리할 수 있으며, 연산 결과는 double로 반환됩니다.
### 3.3 스트림 (Streams)

스트림을 사용하여 여러 계산 기록을 효율적으로 처리할 수 있습니다.
```java
public class Calculator {
private List<String> history = new ArrayList<>();

    public void addToHistory(String entry) {
        history.add(entry);
    }

    // 계산 기록을 스트림으로 처리하기
    public void printHistory() {
        history.stream()
            .filter(entry -> entry.contains("+")) // "+"가 포함된 연산 기록만 출력
            .sorted() // 결과를 정렬
            .forEach(System.out::println); // 출력
    }
}
```
- history 리스트에서 스트림을 사용하여 연산 기호 +가 포함된 항목만 필터링하거나, 정렬된 순서로 출력할 수 있습니다.
forEach(System.out::println)을 사용하여 각 기록을 출력합니다.

### 3.4 열거형 (Enum)

- Operator 열거형을 사용하여 사칙연산을 정의하고, 각 연산에 대해 해당하는 기호와 연산 로직을 결합합니다.
fromSymbol 메서드를 통해 사용자가 입력한 기호를 기반으로 적절한 연산자를 찾고, 연산을 수행합니다.
사용 예시:

```java
public enum Operator {
  ADD("+", (a, b) -> a + b),
  SUBTRACT("-", (a, b) -> a - b),
  MULTIPLY("*", (a, b) -> a * b),
  DIVIDE("/", (a, b) -> {
    if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다");
    return a / b;
  });

    private final String symbol;
    private final Operation<Double> operation;

    Operator(String symbol, Operation<Double> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public double apply(double a, double b) {
        return operation.apply(a, b);
    }

    public static Operator fromSymbol(String symbol) {
        for (Operator op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자: " + symbol);
    }
}
```
- Operator 열거형은 연산자 기호와 해당 연산을 람다식으로 결합하여 구현합니다.
fromSymbol 메서드를 사용하여 사용자가 입력한 기호에 해당하는 연산자를 반환하고, 그 연산자를 사용하여 계산을 수행합니다.
### 3.5 예외 처리

0으로 나누기와 같은 예외적인 상황에 대해서 적절한 예외 처리를 구현합니다.
ArithmeticException을 사용하여 0으로 나누려 할 때 예외를 발생시키고, 사용자에게 적절한 오류 메시지를 전달합니다.
```java
public enum Operator {
  ADD("+", (a, b) -> a + b),
  SUBTRACT("-", (a, b) -> a - b),
  MULTIPLY("*", (a, b) -> a * b),
  DIVIDE("/", (a, b) -> {
    if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다");
        return a / b;
  });
}
```
DIVIDE 연산자에서는 0으로 나누는 상황에 대한 예외 처리를 합니다. ArithmeticException을 던져 사용자에게 알리며, 예외가 발생하면 연산을 중단합니다.
### 4. 전체 설계 흐름
   -  4.1 프로그램 흐름
   사용자 입력: 사용자는 연산을 위한 숫자와 연산 기호를 입력합니다.
   연산자 선택: 사용자가 입력한 연산 기호를 Operator.fromSymbol() 메서드를 통해 해당하는 연산자(Operator)를 찾습니다.
   연산 수행: 찾은 Operator에서 apply() 메서드를 사용하여 계산을 수행합니다.
   결과 출력: 계산 결과를 출력하고, 계산 기록을 저장합니다.
   반복 계산: "exit" 명령어를 입력할 때까지 반복하여 계산을 계속합니다.
### 5. 결론
   이 계산기 프로젝트는 람다식, 제네릭, 스트림, enum을 활용하여 코드의 간결성, 유연성 및 확장성을 높이고, 예외 처리를 통해 안전한 계산을 지원합니다. 이를 통해 사용자는 기본적인 사칙연산을 비롯한 다양한 계산을 손쉽게 수행할 수 있습니다.