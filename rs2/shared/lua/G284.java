// 
// Decompiled by Procyon v0.5.36
// 

package rs2.shared.lua;

public class G284
{
    private long d;
    private long e;
    private long g;
    private long h;
    private long j;
    private long q;
    private long s;
    
    private static void d(final G284 g284) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (g284.s == 0L || currentTimeMillis > g284.s + 1000L) {
            g284.s = currentTimeMillis;
            g284.h = g284.q;
            g284.e = g284.j;
            g284.q = 0L;
            g284.j = 0L;
        }
    }
    
    public static void g(final G284 g284, final long n) {
        d(g284);
        ++g284.d;
        ++g284.q;
        g284.j += n;
        g284.g += n;
    }
    
    public G284() {
        this.g = 0L;
        this.d = 0L;
        this.q = 0L;
        this.j = 0L;
        this.e = 0L;
        this.h = 0L;
        this.s = 0L;
    }
    
    private static String q(final G284 g284, final long l) {
        if (l > 1048576L) {
            return String.format("%.2fMb", (float)l / 1024.0 / 1024.0);
        }
        if (l > 1024L) {
            return String.format("%.2fKb", (float)l / 1024.0);
        }
        return String.format("%d bytes", l);
    }
    
    public String j() {
        d(this);
        final StringBuilder sb = new StringBuilder(16);
        sb.append("Sec: ");
        sb.append(q(this, this.e));
        sb.append(" in ");
        sb.append(this.h);
        sb.append(" message");
        if (this.h != 1L) {
            sb.append("s");
        }
        sb.append(", Total: ");
        sb.append(q(this, this.g));
        sb.append(" in ");
        sb.append(this.d);
        sb.append(" message");
        if (this.d != 1L) {
            sb.append("s");
        }
        return sb.toString();
    }
}
