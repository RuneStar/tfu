/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import com.jagex.js5.js5;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Dh131;
import tfu.Dw624;
import tfu.If31;
import tfu.Ke537;
import tfu.Ks126;

public class Df147
implements Ks126 {
    private static final boolean d = false;
    private static boolean g = false;
    private static final Logger logger = LoggerFactory.getLogger(Df147.class);
    private static final boolean q = false;
    private Hashtable b;
    private final js5 e;
    private final String h;
    private String[] l;
    private Hashtable s = new Hashtable();
    private String[] w;

    @Override
    public boolean j(String string) {
        return this.s.containsKey(string);
    }

    public static String g(String string) {
        if (Ke537.q.startsWith("win")) {
            return string + ".dll";
        }
        if (Ke537.q.startsWith("linux")) {
            return "lib" + string + ".so";
        }
        if (Ke537.q.startsWith("mac")) {
            return "lib" + string + ".dylib";
        }
        return null;
    }

    @Override
    public void q(String string, File file) {
        if (g) {
            System.out.println("Registered library " + string + ": " + file.getPath());
        }
        this.s.put(string, file);
    }

    public int d(String string) {
        if (this.s.containsKey(string)) {
            return 100;
        }
        String string2 = Df147.g(string);
        if (string2 == null) {
            if (g) {
                System.out.println("Unsupported operating system: " + Ke537.q);
            }
            return -1;
        }
        byte[] arrby = null;
        byte[] arrby2 = "unfluttered/" + this.h + string2;
        if (js5.o(this.e, (String)arrby2, "")) {
            arrby = arrby2;
        }
        if (arrby == null && !js5.o(this.e, (String)(arrby = this.h + string2), "")) {
            if (g) {
                System.out.println("Library download failed (library doesn't exist): " + (String)arrby);
            }
            return -1;
        }
        if (!js5.ai(this.e, (String)arrby)) {
            return js5.al(this.e, (String)arrby);
        }
        logger.info("retrieving " + (String)arrby);
        arrby2 = js5.a(this.e, (String)arrby, "");
        File file = null;
        try {
            file = Dh131.d(string2);
        }
        catch (RuntimeException runtimeException) {
            return -1;
        }
        if (arrby2 != null && file != null) {
            block19 : {
                boolean bl = true;
                byte[] arrby3 = If31.q(file);
                if (arrby3 != null && arrby3.length == arrby2.length) {
                    for (int i = 0; i < arrby3.length; ++i) {
                        if (arrby3[i] == arrby2[i]) continue;
                        bl = false;
                        break;
                    }
                } else {
                    bl = false;
                }
                try {
                    if (bl) break block19;
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(arrby2, 0, arrby2.length);
                        fileOutputStream.close();
                    }
                    catch (IOException iOException) {
                        if (g) {
                            throw new RuntimeException("Error saving file: " + file.getPath() + " error:" + iOException.getMessage());
                        }
                        throw new RuntimeException();
                    }
                }
                catch (Throwable throwable) {
                    return -1;
                }
            }
            this.q(string, file);
            return 100;
        }
        return -1;
    }

    @Override
    public boolean e(String string) {
        return this.b.containsKey(string);
    }

    @Override
    public boolean h(String string) {
        return this.s(string, Dw624.class);
    }

    @Override
    public boolean s(String string, Class class_) {
        Class class_2 = (Class)this.b.get(string);
        if (class_2 != null) {
            if (class_2.getClassLoader() != class_.getClassLoader()) {
                if (g) {
                    System.out.println("Native library already loaded in another class loader: " + Ke537.q);
                }
                return false;
            }
            return true;
        }
        File file = null;
        if (System.getenv("OVERRIDE_" + string.toUpperCase()) != null) {
            file = new File(System.getenv("OVERRIDE_" + string.toUpperCase()));
            if (!file.exists()) {
                file = null;
            } else {
                file = new File(file, Df147.g(string));
                this.s.put(string, file);
                System.out.println("Overrode library " + string + " with " + file);
            }
        }
        if (file == null) {
            // empty if block
        }
        if (file == null) {
            file = (File)this.s.get(string);
            if (g && file == null) {
                System.out.println(string + " has not been registered");
            }
        }
        if (file != null) {
            try {
                file = new File(file.getCanonicalPath());
                Class<Runtime> class_3 = Runtime.class;
                Class<AccessibleObject> class_4 = AccessibleObject.class;
                Method method = class_4.getDeclaredMethod("setAccessible", Boolean.TYPE);
                Method method2 = class_3.getDeclaredMethod("load0", Class.class, String.class);
                method.invoke(method2, Boolean.TRUE);
                method2.invoke(Runtime.getRuntime(), class_, file.getPath());
                method.invoke(method2, Boolean.FALSE);
                this.b.put(string, class_);
                if (g) {
                    System.out.println("Loaded " + string);
                }
                return true;
            }
            catch (NoSuchMethodException noSuchMethodException) {
                System.load(file.getPath());
                this.b.put(string, Dw624.class);
                if (g) {
                    System.out.println("Loaded " + string + " using fallback!");
                }
                return true;
            }
            catch (Throwable throwable) {
                if (g) {
                    System.out.println(string + " load failed:");
                    throwable.printStackTrace();
                    Throwable throwable2 = throwable.getCause();
                    if (throwable2 != null) {
                        System.out.println("Reason:");
                        throwable2.printStackTrace();
                    }
                }
                throwable.getCause().printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean b() {
        Object object;
        Hashtable hashtable = new Hashtable();
        Enumeration enumeration = this.b.keys();
        while (enumeration.hasMoreElements()) {
            object = (String)enumeration.nextElement();
            hashtable.put(object, this.b.get(object));
        }
        try {
            object = AccessibleObject.class;
            Class<ClassLoader> class_ = ClassLoader.class;
            Field field = class_.getDeclaredField("nativeLibraries");
            Method method = ((Class)object).getDeclaredMethod("setAccessible", Boolean.TYPE);
            method.invoke(field, Boolean.TRUE);
            try {
                enumeration = this.b.keys();
                while (enumeration.hasMoreElements()) {
                    String string = (String)enumeration.nextElement();
                    try {
                        File file = (File)this.s.get(string);
                        Class class_2 = (Class)this.b.get(string);
                        Vector vector = (Vector)field.get(class_2.getClassLoader());
                        for (int i = 0; i < vector.size(); ++i) {
                            try {
                                Field field2;
                                block16 : {
                                    Object e = vector.elementAt(i);
                                    field2 = e.getClass().getDeclaredField("name");
                                    method.invoke(field2, Boolean.TRUE);
                                    try {
                                        String string2 = (String)field2.get(e);
                                        if (string2 == null || !string2.equalsIgnoreCase(file.getCanonicalPath())) break block16;
                                        Field field3 = e.getClass().getDeclaredField("handle");
                                        Method method2 = e.getClass().getDeclaredMethod("finalize", new Class[0]);
                                        method.invoke(field3, Boolean.TRUE);
                                        method.invoke(method2, Boolean.TRUE);
                                        try {
                                            method2.invoke(e, new Object[0]);
                                            field3.set(e, new Integer(0));
                                            hashtable.remove(string);
                                            if (g) {
                                                System.out.println("Unloaded " + string);
                                            }
                                        }
                                        catch (Throwable throwable) {
                                            // empty catch block
                                        }
                                        method.invoke(method2, Boolean.FALSE);
                                        method.invoke(field3, Boolean.FALSE);
                                    }
                                    catch (Throwable throwable) {
                                        // empty catch block
                                    }
                                }
                                method.invoke(field2, Boolean.FALSE);
                                continue;
                            }
                            catch (Throwable throwable) {
                                // empty catch block
                            }
                        }
                    }
                    catch (Throwable throwable) {
                    }
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            method.invoke(field, Boolean.FALSE);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        this.b = hashtable;
        return this.b.isEmpty();
    }

    public Df147(js5 js52) {
        this.b = new Hashtable();
        this.e = js52;
        String string = "";
        if (Ke537.q.startsWith("win") || Ke537.q.startsWith("windows 7")) {
            string = string + "windows/";
        } else if (Ke537.q.startsWith("linux")) {
            string = string + "linux/";
        } else if (Ke537.q.startsWith("mac")) {
            string = string + "macos/";
        }
        if (Ke537.j.startsWith("amd64") || Ke537.j.startsWith("x86_64")) {
            string = string + "x86_64/";
        } else if (Ke537.j.startsWith("i386") || Ke537.j.startsWith("i486") || Ke537.j.startsWith("i586") || Ke537.j.startsWith("x86")) {
            string = string + "x86/";
        } else if (Ke537.j.startsWith("ppc")) {
            string = string + "ppc/";
        } else {
            if (g) {
                System.out.println("Native library architecture: " + Ke537.j);
            }
            string = string + "universal/";
        }
        this.h = string;
        if (g) {
            System.out.println("Native library js5 path: " + string);
        }
    }
}

