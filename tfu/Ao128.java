// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Iterator;
import java.io.Serializable;
import java.util.ArrayList;

public class Ao128 extends Throwable
{
    private static ThreadLocal d;
    private static ArrayList g;
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        super.fillInStackTrace();
        final ArrayList<StackTraceElement> list = new ArrayList<StackTraceElement>();
        final StackTraceElement[] stackTrace = this.getStackTrace();
        int n = 2;
        for (Serializable s = this.getClass(); s != Throwable.class; s = ((Class<Throwable>)s).getSuperclass()) {
            ++n;
        }
        for (int i = n; i < stackTrace.length; ++i) {
            list.add(stackTrace[i]);
        }
        for (final Aa129 aa129 : Ao128.g) {
            final StackTraceElement[] elements = aa129.getElements();
            if (elements != null && elements.length > 0) {
                list.add(d(aa129.getHeading()));
                for (final StackTraceElement e : elements) {
                    if (e != null) {
                        list.add(e);
                    }
                }
            }
        }
        final Ao128 ao128 = Ao128.d.get();
        if (ao128 != null) {
            final StackTraceElement[] stackTrace2 = ao128.getStackTrace();
            if (stackTrace2 != null && stackTrace2.length > 0) {
                list.add(d("Cross-thread link"));
                final StackTraceElement[] array2 = stackTrace2;
                for (int length2 = array2.length, k = 0; k < length2; ++k) {
                    list.add(array2[k]);
                }
            }
        }
        this.setStackTrace(list.toArray(new StackTraceElement[list.size()]));
        return this;
    }
    
    public static StackTraceElement d(final String s) {
        return new StackTraceElement(".", ".", (s == null) ? "null" : s, -1);
    }
    
    public Ao128() {
    }
    
    public Ao128(final Throwable cause) {
        super(cause);
    }
    
    public static void g(final Aa129 e) {
        if (e == null) {
            throw new NullPointerException();
        }
        Ao128.g.add(e);
    }
    
    public Ao128(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    static {
        Ao128.g = new ArrayList();
        Ao128.d = new ThreadLocal();
    }
    
    public Ao128(final String message) {
        super(message);
    }
}
