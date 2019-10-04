// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Lx337
{
    public String d;
    private boolean e;
    public int g;
    private boolean h;
    public int j;
    public int q;
    
    public Socket g() throws IOException {
        if (!this.h) {
            return new Socket(InetAddress.getByName(this.d), this.e ? this.j : this.q);
        }
        return Jm443.s(this.d, this.e ? this.j : this.q).g();
    }
    
    public static int d(final Lx337 lx337) {
        if (lx337.e) {
            return lx337.j;
        }
        return lx337.q;
    }
    
    public static void q(final Lx337 lx337) {
        if (!lx337.e) {
            lx337.e = true;
            lx337.h = true;
        }
        else if (lx337.h) {
            lx337.h = false;
        }
        else {
            lx337.e = false;
        }
    }
    
    public Lx337() {
        this.q = 43594;
        this.j = 443;
        this.e = true;
        this.h = false;
    }
}
