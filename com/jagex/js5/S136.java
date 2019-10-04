/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.js5;

import com.jagex.js5.H362;

public abstract class S136 {
    protected abstract H362 d();

    protected abstract byte[] q(int var1);

    protected abstract int w(int var1);

    public int g() {
        return 100;
    }

    public static int i(S136 s136) {
        if (s136.d() == null) {
            return 0;
        }
        return s136.d().e;
    }

    public abstract int b();

    public abstract int s();
}

