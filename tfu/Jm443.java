/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import tfu.Ix442;

public abstract class Jm443 {
    protected static final boolean q = true;
    protected int e;
    protected String j;

    public static Jm443 s(String string, int n) {
        Ix442 ix442 = new Ix442();
        ix442.j = string;
        ix442.e = n;
        System.out.println("Created ProxySocket to " + string + ":" + n);
        return ix442;
    }

    public abstract Socket g() throws IOException;

    protected Socket b() throws IOException {
        return new Socket(this.j, this.e);
    }
}

