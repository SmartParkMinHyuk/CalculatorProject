package com.calculator.level3;

@FunctionalInterface
interface Operation<T> {
    // 두 입력값 a, b를 받아 연산을 수행하고 결과를 반환
    T apply(T a, T b);
}