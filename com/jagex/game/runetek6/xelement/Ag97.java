/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.xelement;

import com.jagex.game.runetek6.xelement.Al118;
import com.jagex.game.runetek6.xelement.Az96;
import com.jagex.game.runetek6.xelement.C196;
import com.jagex.game.runetek6.xelement.M195;
import com.jagex.game.runetek6.xelement.Y197;
import com.jagex.game.runetek6.xelement.Z98;
import com.jagex.maths.V198;
import com.jagex.maths.Vector3;

public class Ag97
extends Enum<Ag97> {
    public static final /* enum */ Ag97 d;
    public static final /* enum */ Ag97 e;
    public static final /* enum */ Ag97 g;
    public static final /* enum */ Ag97 j;
    public static final /* enum */ Ag97 q;
    public final Class h;
    public final String s;
    private static final /* synthetic */ Ag97[] $VALUES;

    public static Ag97 valueOf(String string) {
        return Enum.valueOf(Ag97.class, string);
    }

    public static Ag97[] values() {
        return (Ag97[])$VALUES.clone();
    }

    private Ag97(Class class_, String string2) {
        this.h = class_;
        this.s = string2;
    }

    /* synthetic */ Ag97(String string, int n, Class class_, String string2, Z98 z98) {
        this(class_, string2);
    }

    static {
        g = new M195(String.class, "string");
        d = new Az96(Double.class, "number");
        q = new C196(Boolean.class, "boolean");
        j = new Y197(Vector3.class, "vector3");
        e = new Al118(V198.class, "vector4");
        $VALUES = new Ag97[]{g, d, q, j, e};
    }
}

