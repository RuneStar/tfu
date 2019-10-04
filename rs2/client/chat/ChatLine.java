/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.chat;

import com.jagex.game.runetek6.script.ScriptEntryPoint;
import rs2.client.chat.G232;
import tfu.Be2;
import tfu.Bs1;

public class ChatLine {
    private String b;
    private long d;
    private String e;
    private int g = G232.g();
    private String h;
    private int j;
    private int l;
    private int q;
    private String s;
    private String w;

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String getNameSimple() {
        return this.s;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getType() {
        return this.q;
    }

    public String toString() {
        return "{ ChatLine : " + this.e + "(" + this.g + ") }";
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getFlags() {
        return this.j;
    }

    static void g(ChatLine chatLine, int n, int n2, String string, String string2, String string3, String string4, int n3, String string5) {
        chatLine.g = G232.g();
        chatLine.d = System.currentTimeMillis();
        chatLine.q = n;
        chatLine.j = n2;
        chatLine.e = string;
        chatLine.h = string2;
        chatLine.s = string3;
        chatLine.b = string4;
        chatLine.l = n3;
        chatLine.w = string5;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String getNameUnfiltered() {
        return this.h;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String getName() {
        return this.e;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String getMessage() {
        return this.w;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public String getClan() {
        return this.b;
    }

    @ScriptEntryPoint
    @Be2
    @Bs1
    public long getTime() {
        return this.d;
    }

    ChatLine(int n, int n2, String string, String string2, String string3, String string4, int n3, String string5) {
        this.d = System.currentTimeMillis();
        this.q = n;
        this.j = n2;
        this.e = string;
        this.h = string2;
        this.s = string3;
        this.b = string4;
        this.l = n3;
        this.w = string5;
    }
}

