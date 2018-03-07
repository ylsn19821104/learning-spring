package com.hongxp.redis;

import java.util.function.Supplier;

public interface DefaultableFactory {
    static Defaultable create(Supplier<Defaultable> supplier) {
        return supplier.get();
    }
}
