/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.client.GameShell3;
import rs2.client.I384;
import rs2.client.J160;

public class W159 {
    private static W159 d;
    public final boolean b;
    public final I384 e;
    public final int g = 0;
    public final int h;
    public J160 j = GameShell3.osArchRaw.toLowerCase().indexOf("arm") != -1 ? J160.FULLSCREEN : J160.RESIZABLE;
    public final int q;
    public final int s;

    public static W159 g() {
        if (d == null) {
            d = new W159();
        }
        return d;
    }

    private W159() {
        this.q = 0;
        this.h = 127;
        this.s = 127;
        this.e = I384.ANY;
        this.b = true;
    }
}

