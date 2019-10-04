/*
 * Decompiled with CFR 0.146.
 */
package rs2.shared.lua;

public class G284 {
    private long d = 0L;
    private long e = 0L;
    private long g = 0L;
    private long h = 0L;
    private long j = 0L;
    private long q = 0L;
    private long s = 0L;

    private static void d(G284 g284) {
        long l = System.currentTimeMillis();
        if (g284.s == 0L || l > g284.s + 1000L) {
            g284.s = l;
            g284.h = g284.q;
            g284.e = g284.j;
            g284.q = 0L;
            g284.j = 0L;
        }
    }

    public static void g(G284 g284, long l) {
        G284.d(g284);
        ++g284.d;
        ++g284.q;
        g284.j += l;
        g284.g += l;
    }

    private static String q(G284 g284, long l) {
        if (l > 0x100000L) {
            return String.format("%.2fMb", (double)l / 1024.0 / 1024.0);
        }
        if (l > 1024L) {
            return String.format("%.2fKb", (double)l / 1024.0);
        }
        return String.format("%d bytes", l);
    }

    public String j() {
        G284.d(this);
        StringBuilder stringBuilder = new StringBuilder(16);
        stringBuilder.append("Sec: ");
        stringBuilder.append(G284.q(this, this.e));
        stringBuilder.append(" in ");
        stringBuilder.append(this.h);
        stringBuilder.append(" message");
        if (this.h != 1L) {
            stringBuilder.append("s");
        }
        stringBuilder.append(", Total: ");
        stringBuilder.append(G284.q(this, this.g));
        stringBuilder.append(" in ");
        stringBuilder.append(this.d);
        stringBuilder.append(" message");
        if (this.d != 1L) {
            stringBuilder.append("s");
        }
        return stringBuilder.toString();
    }
}

