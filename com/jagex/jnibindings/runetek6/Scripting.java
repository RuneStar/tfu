/*
 * Decompiled with CFR 0.146.
 * 
 * Could not load the following classes:
 *  %s.%s124
 */
package com.jagex.jnibindings.runetek6;

import %s.%s124;
import com.jagex.jnibindings.runetek6.LuaRef;
import com.jagex.jnibindings.runetek6.NativeScriptAPIInfo;
import com.jagex.jnibindings.runetek6.Q291;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bs1;
import tfu.Ju292;
import tfu.Lb33;

public class Scripting {
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

    public static final native int getLuaFunctionRef(long var0, long var2, String var4);

    public static final long[] d(int n) {
        d = true;
        return Scripting.init(n);
    }

    public static int q() {
        return q.size();
    }

    public static void j(LuaRef luaRef, int n) {
        q.add(new Q291(luaRef, n));
    }

    public static final native LuaRef deserialiseScriptMessage(long var0, long var2, String var4, String var5, byte[] var6, Object var7, String var8);

    static /* synthetic */ ReferenceQueue s() {
        return j;
    }

    public static final native void postRegisterScriptAPI(long var0, long var2);

    public static final native void purge(long var0);

    @Bs1
    @Be2
    @Ju292
    public static String typeSig(Object object) {
        if (object == null) {
            return "V";
        }
        Class<?> class_ = object.getClass();
        String string = (String)l.get(class_);
        if (string != null) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Class<?> class_2 = class_;
        while (class_2.isArray()) {
            class_2 = class_2.getComponentType();
            stringBuilder.append('[');
        }
        if (class_2 == Boolean.TYPE) {
            stringBuilder.append('Z');
        } else if (class_2 == Byte.TYPE) {
            stringBuilder.append('B');
        } else if (class_2 == Character.TYPE) {
            stringBuilder.append('C');
        } else if (class_2 == Short.TYPE) {
            stringBuilder.append('S');
        } else if (class_2 == Integer.TYPE) {
            stringBuilder.append('I');
        } else if (class_2 == Long.TYPE) {
            stringBuilder.append('J');
        } else if (class_2 == Float.TYPE) {
            stringBuilder.append('F');
        } else if (class_2 == Double.TYPE) {
            stringBuilder.append('D');
        } else if (stringBuilder.length() > 0) {
            stringBuilder.setLength(0);
            stringBuilder.append(object.getClass().getName().replace('.', '/'));
        } else {
            stringBuilder.append('L');
            stringBuilder.append(object.getClass().getName().replace('.', '/'));
            stringBuilder.append(';');
        }
        string = stringBuilder.toString();
        l.put(class_, string);
        return string;
    }

    public static final native Object callLuaFunction(long var0, long var2, int var4, String var5, Object[] var6, Object var7, String var8, Object[] var9, int var10);

    public static final native boolean checkLuaFunction(long var0, long var2, int var4);

    public static final native boolean matchLuaGlobal(long var0, long var2, String var4, int var5, boolean var6, String var7);

    public static final native void createGlobalFunction(long var0, long var2, String[] var4, InputStream var5);

    public static final native void loadAllScripts(long var0, String[] var2);

    public static final native double getLuaPoolSize(long var0, long var2);

    private static final native void unref(long var0, long var2, int var4);

    public static final native void bindClass(long var0, long var2, Class var4, String var5, String var6, NativeScriptAPIInfo[] var7);

    public static final native StackTraceElement[] getLuaStackTrace(long var0, long var2);

    public static final native String executeScriptFromMemory(long var0, long var2, String var4, int var5, boolean var6);

    public static final native void initLuaProtocolBuffers(long var0, String var2);

    public static final native void enableScriptProfiler(boolean var0);

    @Bs1
    @Be2
    @Ju292
    public static String getClassName(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("null object passed to Scripting getClassName method");
        }
        Class<?> class_ = object.getClass();
        if (b.containsKey(class_)) {
            return (String)b.get(class_);
        }
        String string = String.format(%s124.class, new Object[]{class_.getName().replace('.', '/')});
        b.put(class_, string);
        return string;
    }

    public static String h(String string) {
        int n;
        String string2 = (String)w.get(string);
        if (string2 != null) {
            return string2;
        }
        string2 = string;
        StringBuffer stringBuffer = new StringBuffer();
        int n2 = string.indexOf(60);
        if (n2 != -1 && (n = string.lastIndexOf(62)) != -1) {
            string = string.substring(0, n2) + string.substring(n + 1, string.length());
        }
        if (string.startsWith("class ")) {
            string = string.substring(6, string.length());
        }
        if (string.startsWith("interface ")) {
            string = string.substring(10, string.length());
        }
        int n3 = n = string.indexOf(91);
        while (n3 != -1) {
            stringBuffer.append('[');
            n = n3;
            n3 = string.indexOf(91, n3 + 1);
        }
        string = string.replace("]", "");
        if ((string = string.replace("[", "")).equals("void") || string.equals("V")) {
            stringBuffer.append('V');
        } else if (string.equals("boolean") || string.equals("Z")) {
            stringBuffer.append('Z');
        } else if (string.equals("byte") || string.equals("B")) {
            stringBuffer.append('B');
        } else if (string.equals("char") || string.equals("C")) {
            stringBuffer.append('C');
        } else if (string.equals("short") || string.equals("S")) {
            stringBuffer.append('S');
        } else if (string.equals("int") || string.equals("I")) {
            stringBuffer.append('I');
        } else if (string.equals("long") || string.equals("J")) {
            stringBuffer.append('J');
        } else if (string.equals("float") || string.equals("F")) {
            stringBuffer.append('F');
        } else if (string.equals("double") || string.equals("D")) {
            stringBuffer.append('D');
        } else if (string.length() > 0 && string.substring(0, 1).equals("L")) {
            stringBuffer.append(string.replace('.', '/'));
        } else {
            stringBuffer.append('L');
            stringBuffer.append(string.replace('.', '/'));
            stringBuffer.append(';');
        }
        String string3 = stringBuffer.toString();
        w.put(string2, string3);
        return string3;
    }

    @Bs1
    @Be2
    @Ju292
    public static boolean isArray(Object object) {
        if (object == null) {
            return false;
        }
        return object.getClass().isArray();
    }

    @Bs1
    @Be2
    @Ju292
    public static boolean lessThan(Object object, Object object2) {
        if (object instanceof Comparable) {
            Comparable comparable = (Comparable)object;
            return comparable.compareTo(object2) < 0;
        }
        throw new RuntimeException(String.format("Class %s does not implement Comparable", object == null ? "null" : object.getClass().getSimpleName()));
    }

    public static final native void populateFunctionTable(long var0);

    public static final boolean g() {
        return d;
    }

    static {
        logger = LoggerFactory.getLogger(Scripting.class);
        d = false;
        q = new HashSet<E>();
        j = new ReferenceQueue<T>();
        b = new HashMap<K, V>();
        l = new HashMap<K, V>();
        w = new HashMap<K, V>();
    }

    @Bs1
    @Be2
    @Ju292
    public static boolean lessThanOrEqual(Object object, Object object2) {
        if (object instanceof Comparable) {
            Comparable comparable = (Comparable)object;
            return comparable.compareTo(object2) <= 0;
        }
        throw new RuntimeException(String.format("Class %s does not implement Comparable", object == null ? "null" : object.getClass().getSimpleName()));
    }

    public static void e(long l, long l2) {
        Lb33.g(Lb33.RemovePhantomLuaRefs);
        try {
            Q291 q291;
            while ((q291 = (Q291)j.poll()) != null) {
                q.remove(q291);
                Scripting.unref(l, l2, Q291.g(q291));
            }
            Lb33.d(Lb33.RemovePhantomLuaRefs);
        }
        catch (Throwable throwable) {
            Lb33.d(Lb33.RemovePhantomLuaRefs);
            throw throwable;
        }
    }

    private static final native long[] init(int var0);
}

