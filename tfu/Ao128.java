/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.ArrayList;
import tfu.Aa129;

public class Ao128
extends Throwable {
    private static ThreadLocal d;
    private static ArrayList g;

    @Override
    public synchronized Throwable fillInStackTrace() {
        StackTraceElement[] arrstackTraceElement3;
        super.fillInStackTrace();
        ArrayList<StackTraceElement> arrayList = new ArrayList<StackTraceElement>();
        StackTraceElement[] arrstackTraceElement2 = this.getStackTrace();
        int n = 2;
        for (Class<?> class_ = this.getClass(); class_ != Throwable.class; class_ = class_.getSuperclass()) {
            ++n;
        }
        for (int i = n; i < arrstackTraceElement2.length; ++i) {
            arrayList.add(arrstackTraceElement2[i]);
        }
        for (StackTraceElement[] arrstackTraceElement3 : g) {
            StackTraceElement[] arrstackTraceElement4 = arrstackTraceElement3.getElements();
            if (arrstackTraceElement4 == null || arrstackTraceElement4.length <= 0) continue;
            arrayList.add(Ao128.d(arrstackTraceElement3.getHeading()));
            StackTraceElement[] arrstackTraceElement5 = arrstackTraceElement4;
            int n2 = arrstackTraceElement5.length;
            for (int i = 0; i < n2; ++i) {
                StackTraceElement stackTraceElement = arrstackTraceElement5[i];
                if (stackTraceElement == null) continue;
                arrayList.add(stackTraceElement);
            }
        }
        Ao128 ao128 = (Ao128)d.get();
        if (ao128 != null && (arrstackTraceElement3 = ao128.getStackTrace()) != null && arrstackTraceElement3.length > 0) {
            arrayList.add(Ao128.d("Cross-thread link"));
            for (StackTraceElement stackTraceElement : arrstackTraceElement3) {
                arrayList.add(stackTraceElement);
            }
        }
        this.setStackTrace(arrayList.toArray(new StackTraceElement[arrayList.size()]));
        return this;
    }

    public static StackTraceElement d(String string) {
        return new StackTraceElement(".", ".", string == null ? "null" : string, -1);
    }

    public Ao128() {
    }

    public Ao128(Throwable throwable) {
        super(throwable);
    }

    public static void g(Aa129 aa129) {
        if (aa129 == null) {
            throw new NullPointerException();
        }
        g.add(aa129);
    }

    public Ao128(String string, Throwable throwable) {
        super(string, throwable);
    }

    static {
        g = new ArrayList();
        d = new ThreadLocal();
    }

    public Ao128(String string) {
        super(string);
    }
}

