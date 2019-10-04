/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import tfu.Gg3;
import tfu.Gs329;
import tfu.Gx298;
import tfu.Jx521;

public class Ji520 {
    public static boolean d;
    static Gx298 g;

    private static Class e(String string) throws ClassNotFoundException {
        if (string.equals("B")) {
            return Byte.TYPE;
        }
        if (string.equals("I")) {
            return Integer.TYPE;
        }
        if (string.equals("S")) {
            return Short.TYPE;
        }
        if (string.equals("J")) {
            return Long.TYPE;
        }
        if (string.equals("Z")) {
            return Boolean.TYPE;
        }
        if (string.equals("F")) {
            return Float.TYPE;
        }
        if (string.equals("D")) {
            return Double.TYPE;
        }
        if (string.equals("C")) {
            return Character.TYPE;
        }
        if (string.equals("void")) {
            return Void.TYPE;
        }
        return Class.forName(string);
    }

    public static void g() {
        g = new Gx298();
    }

    public static boolean d() {
        Jx521 jx521 = (Jx521)Gx298.i(g);
        return jx521 != null;
    }

    public static void q(Gs329 gs329) {
        Jx521 jx521 = (Jx521)Gx298.i(g);
        if (jx521 == null) {
            return;
        }
        int n = gs329.v;
        Gs329.a(gs329, jx521.g);
        for (int i = 0; i < jx521.d; ++i) {
            if (jx521.j[i] != 0) {
                Gs329.k(gs329, jx521.j[i]);
                continue;
            }
            try {
                int n2;
                AccessibleObject accessibleObject;
                int n3 = jx521.q[i];
                if (n3 == 0) {
                    accessibleObject = jx521.e[i];
                    n2 = ((Field)accessibleObject).getInt(null);
                    Gs329.k(gs329, 0);
                    Gs329.a(gs329, n2);
                } else if (n3 == 1) {
                    accessibleObject = jx521.e[i];
                    ((Field)accessibleObject).setInt(null, jx521.h[i]);
                    Gs329.k(gs329, 0);
                } else if (n3 == 2) {
                    accessibleObject = jx521.e[i];
                    int n4 = ((Field)accessibleObject).getModifiers();
                    Gs329.k(gs329, 0);
                    Gs329.a(gs329, n4);
                }
                if (n3 == 3) {
                    accessibleObject = jx521.s[i];
                    byte[][] arrby = jx521.b[i];
                    Object[] arrobject = new Object[arrby.length];
                    for (int j = 0; j < arrby.length; ++j) {
                        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(arrby[j]));
                        arrobject[j] = objectInputStream.readObject();
                    }
                    Object object = ((Method)accessibleObject).invoke(null, arrobject);
                    if (object == null) {
                        Gs329.k(gs329, 0);
                        continue;
                    }
                    if (object instanceof Number) {
                        Gs329.k(gs329, 1);
                        Gs329.ag(gs329, ((Number)object).longValue());
                        continue;
                    }
                    if (object instanceof String) {
                        Gs329.k(gs329, 2);
                        gs329.af((String)object);
                        continue;
                    }
                    Gs329.k(gs329, 4);
                    continue;
                }
                if (n3 != 4) continue;
                accessibleObject = jx521.s[i];
                n2 = ((Method)accessibleObject).getModifiers();
                Gs329.k(gs329, 0);
                Gs329.a(gs329, n2);
                continue;
            }
            catch (ClassNotFoundException classNotFoundException) {
                Gs329.k(gs329, -10);
                continue;
            }
            catch (InvalidClassException invalidClassException) {
                Gs329.k(gs329, -11);
                continue;
            }
            catch (StreamCorruptedException streamCorruptedException) {
                Gs329.k(gs329, -12);
                continue;
            }
            catch (OptionalDataException optionalDataException) {
                Gs329.k(gs329, -13);
                continue;
            }
            catch (IllegalAccessException illegalAccessException) {
                Gs329.k(gs329, -14);
                continue;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                Gs329.k(gs329, -15);
                continue;
            }
            catch (InvocationTargetException invocationTargetException) {
                Gs329.k(gs329, -16);
                continue;
            }
            catch (SecurityException securityException) {
                Gs329.k(gs329, -17);
                continue;
            }
            catch (IOException iOException) {
                Gs329.k(gs329, -18);
                continue;
            }
            catch (NullPointerException nullPointerException) {
                Gs329.k(gs329, -19);
                continue;
            }
            catch (Exception exception) {
                Gs329.k(gs329, -20);
                continue;
            }
            catch (Throwable throwable) {
                Gs329.k(gs329, -21);
            }
        }
        Gs329.bz(gs329, n);
        Jx521.ef(jx521);
    }

    public static void j(Gg3 gg3, int n) {
        if (d) {
            return;
        }
        Jx521 jx521 = new Jx521();
        jx521.d = Gg3.ar(gg3);
        jx521.g = Gg3.bd(gg3);
        jx521.q = new int[jx521.d];
        jx521.j = new int[jx521.d];
        jx521.e = new Field[jx521.d];
        jx521.h = new int[jx521.d];
        jx521.s = new Method[jx521.d];
        jx521.b = new byte[jx521.d][][];
        for (int i = 0; i < jx521.d; ++i) {
            try {
                String string;
                String string2;
                int n2;
                Method[] arrmethod;
                int n3;
                int n4 = Gg3.ar(gg3);
                if (n4 == 0 || n4 == 1 || n4 == 2) {
                    string2 = Gg3.bk(gg3);
                    string = Gg3.bk(gg3);
                    n3 = 0;
                    if (n4 == 1) {
                        n3 = Gg3.bd(gg3);
                    }
                    jx521.q[i] = n4;
                    jx521.h[i] = n3;
                    if (Ji520.e(string2).getClassLoader() == null) {
                        throw new SecurityException();
                    }
                    jx521.e[i] = Ji520.e(string2).getDeclaredField(string);
                    continue;
                }
                if (n4 != 3 && n4 != 4) continue;
                string2 = Gg3.bk(gg3);
                string = Gg3.bk(gg3);
                n3 = Gg3.ar(gg3);
                String[] arrstring = new String[n3];
                for (int j = 0; j < n3; ++j) {
                    arrstring[j] = Gg3.bk(gg3);
                }
                String string3 = Gg3.bk(gg3);
                byte[][] arrarrby = new byte[n3][];
                if (n4 == 3) {
                    for (int j = 0; j < n3; ++j) {
                        n2 = Gg3.bd(gg3);
                        arrarrby[j] = new byte[n2];
                        Gg3.bx(gg3, arrarrby[j], 0, n2);
                    }
                }
                jx521.q[i] = n4;
                Class[] arrclass = new Class[n3];
                for (n2 = 0; n2 < n3; ++n2) {
                    arrclass[n2] = Ji520.e(arrstring[n2]);
                }
                Class class_ = Ji520.e(string3);
                if (Ji520.e(string2).getClassLoader() == null) {
                    throw new SecurityException();
                }
                for (Method method : arrmethod = Ji520.e(string2).getDeclaredMethods()) {
                    Class<?>[] arrclass2;
                    if (!method.getName().equals(string) || (arrclass2 = method.getParameterTypes()).length != arrclass.length) continue;
                    boolean bl = true;
                    for (int j = 0; j < arrclass.length; ++j) {
                        if (arrclass[j] == arrclass2[j]) continue;
                        bl = false;
                        break;
                    }
                    if (!bl || class_ != method.getReturnType()) continue;
                    jx521.s[i] = method;
                }
                jx521.b[i] = arrarrby;
                continue;
            }
            catch (ClassNotFoundException classNotFoundException) {
                jx521.j[i] = -1;
                continue;
            }
            catch (SecurityException securityException) {
                jx521.j[i] = -2;
                continue;
            }
            catch (NullPointerException nullPointerException) {
                jx521.j[i] = -3;
                continue;
            }
            catch (Exception exception) {
                jx521.j[i] = -4;
                continue;
            }
            catch (Throwable throwable) {
                jx521.j[i] = -5;
            }
        }
        Gx298.t(g, jx521);
    }

    static {
        g = new Gx298();
        d = true;
    }
}

