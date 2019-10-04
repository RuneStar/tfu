/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.js5;

import com.jagex.js5.E361;
import tfu.Hl134;

public class D363
extends E361 {
    public static final int d = 2;
    public static final int g = 1;
    public static final int q = 3;
    Hl134 e;
    byte[] h;
    int j;

    @Override
    byte[] g() {
        if (this.l) {
            throw new RuntimeException("Not ready!");
        }
        return this.h;
    }

    @Override
    int d() {
        if (this.l) {
            return 0;
        }
        return 100;
    }
}

