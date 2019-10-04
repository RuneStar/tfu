// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.io.IOException;
import java.net.Socket;

public abstract class Jm443
{
    protected static final boolean q = true;
    protected int e;
    protected String j;
    
    public static Jm443 s(final String s, final int n) {
        final Ix442 ix442 = new Ix442();
        ix442.j = s;
        ix442.e = n;
        System.out.println("Created ProxySocket to " + s + ":" + n);
        return ix442;
    }
    
    public abstract Socket g() throws IOException;
    
    protected Socket b() throws IOException {
        return new Socket(this.j, this.e);
    }
}
