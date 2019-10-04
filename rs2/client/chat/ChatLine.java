// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.chat;

import tfu.Bs1;
import tfu.Be2;
import com.jagex.game.runetek6.script.ScriptEntryPoint;

public class ChatLine
{
    private String b;
    private long d;
    private String e;
    private int g;
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
    
    @Override
    public String toString() {
        return "{ ChatLine : " + this.e + "(" + this.g + ") }";
    }
    
    @ScriptEntryPoint
    @Be2
    @Bs1
    public int getFlags() {
        return this.j;
    }
    
    static void g(final ChatLine chatLine, final int q, final int j, final String e, final String h, final String s, final String b, final int l, final String w) {
        chatLine.g = G232.g();
        chatLine.d = System.currentTimeMillis();
        chatLine.q = q;
        chatLine.j = j;
        chatLine.e = e;
        chatLine.h = h;
        chatLine.s = s;
        chatLine.b = b;
        chatLine.l = l;
        chatLine.w = w;
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
    
    ChatLine(final int q, final int j, final String e, final String h, final String s, final String b, final int l, final String w) {
        this.g = G232.g();
        this.d = System.currentTimeMillis();
        this.q = q;
        this.j = j;
        this.e = e;
        this.h = h;
        this.s = s;
        this.b = b;
        this.l = l;
        this.w = w;
    }
}
