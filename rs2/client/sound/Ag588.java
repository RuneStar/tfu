/*
 * Decompiled with CFR 0.146.
 */
package rs2.client.sound;

import java.util.Hashtable;
import rs2.client.sound.G593;
import rs2.client.sound.V696;

public class Ag588 {
    static final Hashtable e = new Hashtable();
    String d = "";
    Hashtable g = new Hashtable();
    String j = "";
    String q = "";

    private static String g(Ag588 ag588, String string) {
        if (ag588.g.containsKey(string)) {
            return (String)ag588.g.get(string);
        }
        return null;
    }

    private static String q(Ag588 ag588) {
        return !ag588.q.equals("") ? ag588.q : null;
    }

    public static String e(int n, String string) {
        return e.containsKey(n) ? Ag588.g((Ag588)e.get(n), string) : null;
    }

    public static String h(int n) {
        return e.containsKey(n) ? Ag588.q((Ag588)e.get(n)) : null;
    }

    public static void s(String string) {
        V696 v696 = new V696();
        G593.g(string + ".dat", 100000L, false, v696, null);
    }

    private static String d(Ag588 ag588) {
        return !ag588.d.equals("") ? ag588.d : null;
    }

    public static String j(int n) {
        return e.containsKey(n) ? Ag588.d((Ag588)e.get(n)) : null;
    }
}

