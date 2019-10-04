// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import org.slf4j.LoggerFactory;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.Vector;
import java.lang.reflect.Method;
import java.lang.reflect.AccessibleObject;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import com.jagex.js5.js5;
import java.util.Hashtable;
import org.slf4j.Logger;

public class Df147 implements Ks126
{
    private static final boolean d = false;
    private static boolean g;
    private static final Logger logger;
    private static final boolean q = false;
    private Hashtable b;
    private final js5 e;
    private final String h;
    private String[] l;
    private Hashtable s;
    private String[] w;
    
    @Override
    public boolean j(final String key) {
        return this.s.containsKey(key);
    }
    
    public static String g(final String str) {
        if (Ke537.q.startsWith("win")) {
            return str + ".dll";
        }
        if (Ke537.q.startsWith("linux")) {
            return "lib" + str + ".so";
        }
        if (Ke537.q.startsWith("mac")) {
            return "lib" + str + ".dylib";
        }
        return null;
    }
    
    @Override
    public void q(final String s, final File value) {
        if (Df147.g) {
            System.out.println("Registered library " + s + ": " + value.getPath());
        }
        this.s.put(s, value);
    }
    
    public int d(final String key) {
        if (this.s.containsKey(key)) {
            return 100;
        }
        final String g = g(key);
        if (g == null) {
            if (Df147.g) {
                System.out.println("Unsupported operating system: " + Ke537.q);
            }
            return -1;
        }
        String string = null;
        final String string2 = "unfluttered/" + this.h + g;
        if (js5.o(this.e, string2, "")) {
            string = string2;
        }
        if (string == null) {
            string = this.h + g;
            if (!js5.o(this.e, string, "")) {
                if (Df147.g) {
                    System.out.println("Library download failed (library doesn't exist): " + string);
                }
                return -1;
            }
        }
        if (!js5.ai(this.e, string)) {
            return js5.al(this.e, string);
        }
        Df147.logger.info("retrieving " + string);
        final byte[] a = js5.a(this.e, string, "");
        File d;
        try {
            d = Dh131.d(g);
        }
        catch (RuntimeException ex2) {
            return -1;
        }
        if (a != null && d != null) {
            boolean b = true;
            final byte[] q = If31.q(d);
            if (q != null && q.length == a.length) {
                for (int i = 0; i < q.length; ++i) {
                    if (q[i] != a[i]) {
                        b = false;
                        break;
                    }
                }
            }
            else {
                b = false;
            }
            try {
                if (!b) {
                    try {
                        final FileOutputStream fileOutputStream = new FileOutputStream(d);
                        fileOutputStream.write(a, 0, a.length);
                        fileOutputStream.close();
                    }
                    catch (IOException ex) {
                        if (Df147.g) {
                            throw new RuntimeException("Error saving file: " + d.getPath() + " error:" + ex.getMessage());
                        }
                        throw new RuntimeException();
                    }
                }
            }
            catch (Throwable t) {
                return -1;
            }
            this.q(key, d);
            return 100;
        }
        return -1;
    }
    
    @Override
    public boolean e(final String key) {
        return this.b.containsKey(key);
    }
    
    @Override
    public boolean h(final String s) {
        return this.s(s, Dw624.class);
    }
    
    @Override
    public boolean s(final String s, final Class value) {
        final Class clazz = this.b.get(s);
        if (clazz == null) {
            File file = null;
            if (System.getenv("OVERRIDE_" + s.toUpperCase()) != null) {
                final File parent = new File(System.getenv("OVERRIDE_" + s.toUpperCase()));
                if (!parent.exists()) {
                    file = null;
                }
                else {
                    file = new File(parent, g(s));
                    this.s.put(s, file);
                    System.out.println("Overrode library " + s + " with " + file);
                }
            }
            if (file == null) {}
            if (file == null) {
                file = this.s.get(s);
                if (Df147.g && file == null) {
                    System.out.println(s + " has not been registered");
                }
            }
            if (file != null) {
                try {
                    file = new File(file.getCanonicalPath());
                    final Class<Runtime> clazz2 = Runtime.class;
                    final Method declaredMethod = AccessibleObject.class.getDeclaredMethod("setAccessible", Boolean.TYPE);
                    final Method declaredMethod2 = clazz2.getDeclaredMethod("load0", Class.class, String.class);
                    declaredMethod.invoke(declaredMethod2, Boolean.TRUE);
                    declaredMethod2.invoke(Runtime.getRuntime(), value, file.getPath());
                    declaredMethod.invoke(declaredMethod2, Boolean.FALSE);
                    this.b.put(s, value);
                    if (Df147.g) {
                        System.out.println("Loaded " + s);
                    }
                    return true;
                }
                catch (NoSuchMethodException ex) {
                    System.load(file.getPath());
                    this.b.put(s, Dw624.class);
                    if (Df147.g) {
                        System.out.println("Loaded " + s + " using fallback!");
                    }
                    return true;
                }
                catch (Throwable t) {
                    if (Df147.g) {
                        System.out.println(s + " load failed:");
                        t.printStackTrace();
                        final Throwable cause = t.getCause();
                        if (cause != null) {
                            System.out.println("Reason:");
                            cause.printStackTrace();
                        }
                    }
                    else {
                        t.getCause().printStackTrace();
                    }
                }
            }
            return false;
        }
        if (clazz.getClassLoader() != value.getClassLoader()) {
            if (Df147.g) {
                System.out.println("Native library already loaded in another class loader: " + Ke537.q);
            }
            return false;
        }
        return true;
    }
    
    @Override
    public boolean b() {
        final Hashtable<String, Object> b = new Hashtable<String, Object>();
        final Enumeration<String> keys = this.b.keys();
        while (keys.hasMoreElements()) {
            final String s = keys.nextElement();
            b.put(s, this.b.get(s));
        }
        try {
            final Class<AccessibleObject> clazz = AccessibleObject.class;
            final Field declaredField = ClassLoader.class.getDeclaredField("nativeLibraries");
            final Method declaredMethod = clazz.getDeclaredMethod("setAccessible", Boolean.TYPE);
            declaredMethod.invoke(declaredField, Boolean.TRUE);
            try {
                final Enumeration<String> keys2 = this.b.keys();
                while (keys2.hasMoreElements()) {
                    final String s2 = keys2.nextElement();
                    try {
                        final File file = this.s.get(s2);
                        final Vector vector = (Vector)declaredField.get(this.b.get(s2).getClassLoader());
                        for (int i = 0; i < vector.size(); ++i) {
                            try {
                                final Object element = vector.elementAt(i);
                                final Field declaredField2 = element.getClass().getDeclaredField("name");
                                declaredMethod.invoke(declaredField2, Boolean.TRUE);
                                try {
                                    final String s3 = (String)declaredField2.get(element);
                                    if (s3 != null && s3.equalsIgnoreCase(file.getCanonicalPath())) {
                                        final Field declaredField3 = element.getClass().getDeclaredField("handle");
                                        final Method declaredMethod2 = element.getClass().getDeclaredMethod("finalize", (Class<?>[])new Class[0]);
                                        declaredMethod.invoke(declaredField3, Boolean.TRUE);
                                        declaredMethod.invoke(declaredMethod2, Boolean.TRUE);
                                        try {
                                            declaredMethod2.invoke(element, new Object[0]);
                                            declaredField3.set(element, new Integer(0));
                                            b.remove(s2);
                                            if (Df147.g) {
                                                System.out.println("Unloaded " + s2);
                                            }
                                        }
                                        catch (Throwable t) {}
                                        declaredMethod.invoke(declaredMethod2, Boolean.FALSE);
                                        declaredMethod.invoke(declaredField3, Boolean.FALSE);
                                    }
                                }
                                catch (Throwable t2) {}
                                declaredMethod.invoke(declaredField2, Boolean.FALSE);
                            }
                            catch (Throwable t3) {}
                        }
                    }
                    catch (Throwable t4) {}
                }
            }
            catch (Throwable t5) {}
            declaredMethod.invoke(declaredField, Boolean.FALSE);
        }
        catch (Throwable t6) {}
        this.b = b;
        return this.b.isEmpty();
    }
    
    static {
        Df147.g = false;
        logger = LoggerFactory.getLogger(Df147.class);
    }
    
    public Df147(final js5 e) {
        this.s = new Hashtable();
        this.b = new Hashtable();
        this.e = e;
        String str = "";
        if (Ke537.q.startsWith("win") || Ke537.q.startsWith("windows 7")) {
            str += "windows/";
        }
        else if (Ke537.q.startsWith("linux")) {
            str += "linux/";
        }
        else if (Ke537.q.startsWith("mac")) {
            str += "macos/";
        }
        String s;
        if (Ke537.j.startsWith("amd64") || Ke537.j.startsWith("x86_64")) {
            s = str + "x86_64/";
        }
        else if (Ke537.j.startsWith("i386") || Ke537.j.startsWith("i486") || Ke537.j.startsWith("i586") || Ke537.j.startsWith("x86")) {
            s = str + "x86/";
        }
        else if (Ke537.j.startsWith("ppc")) {
            s = str + "ppc/";
        }
        else {
            if (Df147.g) {
                System.out.println("Native library architecture: " + Ke537.j);
            }
            s = str + "universal/";
        }
        this.h = s;
        if (Df147.g) {
            System.out.println("Native library js5 path: " + s);
        }
    }
}
