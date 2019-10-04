// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6;

import tfu.Lb33;
import java.util.HashSet;
import org.slf4j.LoggerFactory;
import %s.%s124;
import java.io.InputStream;
import tfu.Ju292;
import tfu.Be2;
import tfu.Bs1;
import java.util.Set;
import org.slf4j.Logger;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public class Scripting
{
    private static HashMap b;
    private static boolean d;
    public static final int e = -1;
    public static final int h = -2;
    private static ReferenceQueue j;
    private static HashMap l;
    private static final Logger logger;
    private static Set q;
    public static final int s = -1;
    private static HashMap w;
    
    public static final native int getLuaFunctionRef(final long p0, final long p1, final String p2);
    
    public static final long[] d(final int n) {
        Scripting.d = true;
        return init(n);
    }
    
    public static int q() {
        return Scripting.q.size();
    }
    
    public static void j(final LuaRef luaRef, final int n) {
        Scripting.q.add(new Q291(luaRef, n));
    }
    
    public static final native LuaRef deserialiseScriptMessage(final long p0, final long p1, final String p2, final String p3, final byte[] p4, final Object p5, final String p6);
    
    public static final native void postRegisterScriptAPI(final long p0, final long p1);
    
    public static final native void purge(final long p0);
    
    @Bs1
    @Be2
    @Ju292
    public static String typeSig(final Object o) {
        if (o == null) {
            return "V";
        }
        final Class<?> class1 = o.getClass();
        final String s = Scripting.l.get(class1);
        if (s != null) {
            return s;
        }
        final StringBuilder sb = new StringBuilder();
        Class<?> componentType = class1;
        while (componentType.isArray()) {
            componentType = componentType.getComponentType();
            sb.append('[');
        }
        if (componentType == Boolean.TYPE) {
            sb.append('Z');
        }
        else if (componentType == Byte.TYPE) {
            sb.append('B');
        }
        else if (componentType == Character.TYPE) {
            sb.append('C');
        }
        else if (componentType == Short.TYPE) {
            sb.append('S');
        }
        else if (componentType == Integer.TYPE) {
            sb.append('I');
        }
        else if (componentType == Long.TYPE) {
            sb.append('J');
        }
        else if (componentType == Float.TYPE) {
            sb.append('F');
        }
        else if (componentType == Double.TYPE) {
            sb.append('D');
        }
        else if (sb.length() > 0) {
            sb.setLength(0);
            sb.append(o.getClass().getName().replace('.', '/'));
        }
        else {
            sb.append('L');
            sb.append(o.getClass().getName().replace('.', '/'));
            sb.append(';');
        }
        final String string = sb.toString();
        Scripting.l.put(class1, string);
        return string;
    }
    
    public static final native Object callLuaFunction(final long p0, final long p1, final int p2, final String p3, final Object[] p4, final Object p5, final String p6, final Object[] p7, final int p8);
    
    public static final native boolean checkLuaFunction(final long p0, final long p1, final int p2);
    
    public static final native boolean matchLuaGlobal(final long p0, final long p1, final String p2, final int p3, final boolean p4, final String p5);
    
    public static final native void createGlobalFunction(final long p0, final long p1, final String[] p2, final InputStream p3);
    
    public static final native void loadAllScripts(final long p0, final String[] p1);
    
    public static final native double getLuaPoolSize(final long p0, final long p1);
    
    private static final native void unref(final long p0, final long p1, final int p2);
    
    public static final native void bindClass(final long p0, final long p1, final Class p2, final String p3, final String p4, final NativeScriptAPIInfo[] p5);
    
    public static final native StackTraceElement[] getLuaStackTrace(final long p0, final long p1);
    
    public static final native String executeScriptFromMemory(final long p0, final long p1, final String p2, final int p3, final boolean p4);
    
    public static final native void initLuaProtocolBuffers(final long p0, final String p1);
    
    public static final native void enableScriptProfiler(final boolean p0);
    
    @Bs1
    @Be2
    @Ju292
    public static String getClassName(final Object o) {
        if (o == null) {
            throw new IllegalArgumentException("null object passed to Scripting getClassName method");
        }
        final Class<?> class1 = o.getClass();
        if (Scripting.b.containsKey(class1)) {
            return (String)Scripting.b.get(class1);
        }
        final String format = String.format((String)%s124.class, class1.getName().replace('.', '/'));
        Scripting.b.put(class1, format);
        return format;
    }
    
    public static String h(String key) {
        final String s = Scripting.w.get(key);
        if (s != null) {
            return s;
        }
        final String key2 = key;
        final StringBuffer sb = new StringBuffer();
        final int index = key.indexOf(60);
        if (index != -1) {
            final int lastIndex = key.lastIndexOf(62);
            if (lastIndex != -1) {
                key = key.substring(0, index) + key.substring(lastIndex + 1, key.length());
            }
        }
        if (key.startsWith("class ")) {
            key = key.substring(6, key.length());
        }
        if (key.startsWith("interface ")) {
            key = key.substring(10, key.length());
        }
        for (int i = key.indexOf(91); i != -1; i = key.indexOf(91, i + 1)) {
            sb.append('[');
        }
        key = key.replace("]", "");
        key = key.replace("[", "");
        if (key.equals("void") || key.equals("V")) {
            sb.append('V');
        }
        else if (key.equals("boolean") || key.equals("Z")) {
            sb.append('Z');
        }
        else if (key.equals("byte") || key.equals("B")) {
            sb.append('B');
        }
        else if (key.equals("char") || key.equals("C")) {
            sb.append('C');
        }
        else if (key.equals("short") || key.equals("S")) {
            sb.append('S');
        }
        else if (key.equals("int") || key.equals("I")) {
            sb.append('I');
        }
        else if (key.equals("long") || key.equals("J")) {
            sb.append('J');
        }
        else if (key.equals("float") || key.equals("F")) {
            sb.append('F');
        }
        else if (key.equals("double") || key.equals("D")) {
            sb.append('D');
        }
        else if (key.length() > 0 && key.substring(0, 1).equals("L")) {
            sb.append(key.replace('.', '/'));
        }
        else {
            sb.append('L');
            sb.append(key.replace('.', '/'));
            sb.append(';');
        }
        final String string = sb.toString();
        Scripting.w.put(key2, string);
        return string;
    }
    
    @Bs1
    @Be2
    @Ju292
    public static boolean isArray(final Object o) {
        return o != null && o.getClass().isArray();
    }
    
    @Bs1
    @Be2
    @Ju292
    public static boolean lessThan(final Object o, final Object o2) {
        if (o instanceof Comparable) {
            return ((Comparable)o).compareTo(o2) < 0;
        }
        throw new RuntimeException(String.format("Class %s does not implement Comparable", (o == null) ? "null" : o.getClass().getSimpleName()));
    }
    
    public static final native void populateFunctionTable(final long p0);
    
    public static final boolean g() {
        return Scripting.d;
    }
    
    static {
        logger = LoggerFactory.getLogger(Scripting.class);
        Scripting.d = false;
        Scripting.q = new HashSet();
        Scripting.j = new ReferenceQueue();
        Scripting.b = new HashMap();
        Scripting.l = new HashMap();
        Scripting.w = new HashMap();
    }
    
    @Bs1
    @Be2
    @Ju292
    public static boolean lessThanOrEqual(final Object o, final Object o2) {
        if (o instanceof Comparable) {
            return ((Comparable)o).compareTo(o2) <= 0;
        }
        throw new RuntimeException(String.format("Class %s does not implement Comparable", (o == null) ? "null" : o.getClass().getSimpleName()));
    }
    
    public static void e(final long n, final long n2) {
        Lb33.g(Lb33.RemovePhantomLuaRefs);
        try {
            Q291 q291;
            while ((q291 = (Q291)Scripting.j.poll()) != null) {
                Scripting.q.remove(q291);
                unref(n, n2, Q291.g(q291));
            }
        }
        finally {
            Lb33.d(Lb33.RemovePhantomLuaRefs);
        }
    }
    
    private static final native long[] init(final int p0);
}
