// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.sound;

import java.util.Hashtable;

public class Ag588
{
    static final Hashtable e;
    String d;
    Hashtable g;
    String j;
    String q;
    
    private static String g(final Ag588 ag588, final String s) {
        if (ag588.g.containsKey(s)) {
            return ag588.g.get(s);
        }
        return null;
    }
    
    private static String q(final Ag588 ag588) {
        return ag588.q.equals("") ? null : ag588.q;
    }
    
    public static String e(final int n, final String s) {
        return Ag588.e.containsKey(n) ? g(Ag588.e.get(n), s) : null;
    }
    
    public static String h(final int n) {
        return Ag588.e.containsKey(n) ? q(Ag588.e.get(n)) : null;
    }
    
    public Ag588() {
        this.g = new Hashtable();
        this.d = "";
        this.q = "";
        this.j = "";
    }
    
    public static void s(final String str) {
        G593.g(str + ".dat", 100000L, false, new V696(), null);
    }
    
    private static String d(final Ag588 ag588) {
        return ag588.d.equals("") ? null : ag588.d;
    }
    
    static {
        e = new Hashtable();
    }
    
    public static String j(final int n) {
        return Ag588.e.containsKey(n) ? d(Ag588.e.get(n)) : null;
    }
}
