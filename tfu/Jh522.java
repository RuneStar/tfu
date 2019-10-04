/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public class Jh522 {
    private final byte[][] g;

    public static int g(Jh522 jh522) {
        return jh522.g.length;
    }

    public Jh522(int n) {
        this.g = new byte[n][0];
    }

    public static byte[] q(Jh522 jh522, int n) {
        return jh522.g[n];
    }

    public static void d(Jh522 jh522, int n, byte[] arrby) {
        jh522.g[n] = arrby;
    }
}

