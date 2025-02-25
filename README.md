# 계산기 개발 프로젝트

이 프로젝트는 다양한 기능을 지원하는 계산기를 구현하는 것을 목표로 합니다. 본 README는 요구사항 정의와 설계, 그리고 개발 단계별 가이드라인을 포함합니다.

---

## 1. 프로젝트 개요

- **목표**  
  기본적인 사칙연산부터 확장 기능(괄호, 제곱, 제곱근, 실수 연산 등)까지 지원하는 계산기를 개발합니다.

- **사용자 인터페이스**  
  콘솔 기반 또는 GUI(그래픽 사용자 인터페이스) 방식 중 선택하여 구현할 수 있습니다.

- **예외 처리**  
  0으로 나누기 등 계산 중 발생할 수 있는 예외 상황에 대해 적절한 처리를 구현합니다.

---


## 2. 요구사항 정의

### 2.1 기능 요구사항

- **기본 사칙연산**
    - 덧셈, 뺄셈, 곱셈, 나눗셈

- **추가 연산 기능**
    - 괄호 사용, 제곱근, 제곱 등

- **입력 방식**
    - 양의 정수(0 포함) 또는 실수 입력
    - 사칙연산 기호(➕, ➖, ✖️, ➗) 입력

- **출력**
    - 계산 결과를 출력하며, 오류 발생 시 명확한 오류 메시지 제공

- **반복 계산**
    - “exit” 입력 시 종료될 때까지 무한 반복으로 계산 수행

### 2.2 설계 요구사항

- **클래스 다이어그램**
    - 필요한 클래스 예시: `Calculator`, `Operation`, `Parser` 등

- **기능 분해**
    - 각 연산을 별도의 메서드로 분리  
      예: `add()`, `subtract()`, `multiply()`, `divide()`, `evaluateExpression()` 등

- **데이터 흐름 설계**
    - 사용자 입력 → 연산 처리 → 결과 출력의 흐름 파악 및 설계

- **캡슐화**
    - `Calculator` 클래스의 내부 데이터(연산 결과 저장 컬렉션)는 외부에서 직접 접근하지 못하도록 하고, Getter/Setter 메서드를 통해 간접 접근