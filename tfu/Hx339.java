/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.IOException;
import java.net.Socket;
import tfu.Hu432;

public abstract class Hx339 {
    public abstract void s();

    public abstract boolean d(int var1) throws IOException;

    public abstract int q() throws IOException;

    public static Hx339 g(Socket socket, int n) throws IOException {
        return new Hu432(socket, n);
    }

    public abstract void h();

    public abstract void e(byte[] var1, int var2, int var3) throws IOException;

    public abstract int j(byte[] var1, int var2, int var3) throws IOException;
}

