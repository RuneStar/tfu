// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import com.jagex.game.runetek6.client.GameShell3;

public class W159
{
    private static W159 d;
    public final boolean b;
    public final I384 e;
    public final int g = 0;
    public final int h;
    public J160 j;
    public final int q;
    public final int s;
    
    public static W159 g() {
        if (W159.d == null) {
            W159.d = new W159();
        }
        return W159.d;
    }
    
    private W159() {
        this.q = 0;
        this.h = 127;
        this.s = 127;
        this.j = ((GameShell3.osArchRaw.toLowerCase().indexOf("arm") != -1) ? J160.FULLSCREEN : J160.RESIZABLE);
        this.e = I384.ANY;
        this.b = true;
    }
}
