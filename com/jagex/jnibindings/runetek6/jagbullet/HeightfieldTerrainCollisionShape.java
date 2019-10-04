/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.jagbullet;

import com.jagex.jnibindings.runetek6.jagbullet.E6;
import com.jagex.jnibindings.runetek6.jagbullet.S172;

public class HeightfieldTerrainCollisionShape
extends E6 {
    final int e;
    final int h;

    HeightfieldTerrainCollisionShape(long l, int n, int n2) {
        super(l, S172.HEIGHTFIELD);
        this.e = n;
        this.h = n2;
    }
}

