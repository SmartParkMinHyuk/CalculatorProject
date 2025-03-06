package com.calculator.level3;

public interface Opertaion<T> {

    @FunctionalInterface
    interface Operation<T> {
        T apply(T a, T b);  // 두 피연산자 a, b를 받아 연산을 수행하고 결과를 반환
    }

}
