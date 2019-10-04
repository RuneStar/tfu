// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.net.Socket;
import java.io.IOException;

public abstract class Hx339
{
    public abstract void s();
    
    public abstract boolean d(final int p0) throws IOException;
    
    public abstract int q() throws IOException;
    
    public static Hx339 g(final Socket socket, final int n) throws IOException {
        return new Hu432(socket, n);
    }
    
    public abstract void h();
    
    public abstract void e(final byte[] p0, final int p1, final int p2) throws IOException;
    
    public abstract int j(final byte[] p0, final int p1, final int p2) throws IOException;
}
