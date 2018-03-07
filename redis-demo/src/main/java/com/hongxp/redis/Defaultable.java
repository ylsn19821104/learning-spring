package com.hongxp.redis;

@FunctionalInterface
public interface Defaultable {
    void run();

    default String notRequired() {
        return "Default implementation";
    }
}
