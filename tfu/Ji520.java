// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.InvalidClassException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ByteArrayInputStream;

public class Ji520
{
    public static boolean d;
    static Gx298 g;
    
    private static Class e(final String className) throws ClassNotFoundException {
        if (className.equals("B")) {
            return Byte.TYPE;
        }
        if (className.equals("I")) {
            return Integer.TYPE;
        }
        if (className.equals("S")) {
            return Short.TYPE;
        }
        if (className.equals("J")) {
            return Long.TYPE;
        }
        if (className.equals("Z")) {
            return Boolean.TYPE;
        }
        if (className.equals("F")) {
            return Float.TYPE;
        }
        if (className.equals("D")) {
            return Double.TYPE;
        }
        if (className.equals("C")) {
            return Character.TYPE;
        }
        if (className.equals("void")) {
            return Void.TYPE;
        }
        return Class.forName(className);
    }
    
    public static void g() {
        Ji520.g = new Gx298();
    }
    
    public static boolean d() {
        return Gx298.i(Ji520.g) != null;
    }
    
    public static void q(final Gs329 gs329) {
        final Jx521 jx521 = (Jx521)Gx298.i(Ji520.g);
        if (jx521 == null) {
            return;
        }
        final int v = gs329.v;
        Gg3.a(gs329, jx521.g);
        for (int i = 0; i < jx521.d; ++i) {
            if (jx521.j[i] != 0) {
                Gg3.k(gs329, jx521.j[i]);
            }
            else {
                try {
                    final int n = jx521.q[i];
                    if (n == 0) {
                        final int int1 = jx521.e[i].getInt(null);
                        Gg3.k(gs329, 0);
                        Gg3.a(gs329, int1);
                    }
                    else if (n == 1) {
                        jx521.e[i].setInt(null, jx521.h[i]);
                        Gg3.k(gs329, 0);
                    }
                    else if (n == 2) {
                        final int modifiers = jx521.e[i].getModifiers();
                        Gg3.k(gs329, 0);
                        Gg3.a(gs329, modifiers);
                    }
                    if (n == 3) {
                        final Method method = jx521.s[i];
                        final byte[][] array = jx521.b[i];
                        final Object[] args = new Object[array.length];
                        for (int j = 0; j < array.length; ++j) {
                            args[j] = new ObjectInputStream(new ByteArrayInputStream(array[j])).readObject();
                        }
                        final Object invoke = method.invoke(null, args);
                        if (invoke == null) {
                            Gg3.k(gs329, 0);
                        }
                        else if (invoke instanceof Number) {
                            Gg3.k(gs329, 1);
                            Gg3.ag(gs329, ((Number)invoke).longValue());
                        }
                        else if (invoke instanceof String) {
                            Gg3.k(gs329, 2);
                            gs329.af((String)invoke);
                        }
                        else {
                            Gg3.k(gs329, 4);
                        }
                    }
                    else if (n == 4) {
                        final int modifiers2 = jx521.s[i].getModifiers();
                        Gg3.k(gs329, 0);
                        Gg3.a(gs329, modifiers2);
                    }
                }
                catch (ClassNotFoundException ex) {
                    Gg3.k(gs329, -10);
                }
                catch (InvalidClassException ex2) {
                    Gg3.k(gs329, -11);
                }
                catch (StreamCorruptedException ex3) {
                    Gg3.k(gs329, -12);
                }
                catch (OptionalDataException ex4) {
                    Gg3.k(gs329, -13);
                }
                catch (IllegalAccessException ex5) {
                    Gg3.k(gs329, -14);
                }
                catch (IllegalArgumentException ex6) {
                    Gg3.k(gs329, -15);
                }
                catch (InvocationTargetException ex7) {
                    Gg3.k(gs329, -16);
                }
                catch (SecurityException ex8) {
                    Gg3.k(gs329, -17);
                }
                catch (IOException ex9) {
                    Gg3.k(gs329, -18);
                }
                catch (NullPointerException ex10) {
                    Gg3.k(gs329, -19);
                }
                catch (Exception ex11) {
                    Gg3.k(gs329, -20);
                }
                catch (Throwable t) {
                    Gg3.k(gs329, -21);
                }
            }
        }
        Gg3.bz(gs329, v);
        Ln265.ef(jx521);
    }
    
    public static void j(final Gg3 gg3, final int n) {
        if (Ji520.d) {
            return;
        }
        final Jx521 jx521 = new Jx521();
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
                final int ar = Gg3.ar(gg3);
                if (ar == 0 || ar == 1 || ar == 2) {
                    final String bk = Gg3.bk(gg3);
                    final String bk2 = Gg3.bk(gg3);
                    int bd = 0;
                    if (ar == 1) {
                        bd = Gg3.bd(gg3);
                    }
                    jx521.q[i] = ar;
                    jx521.h[i] = bd;
                    if (e(bk).getClassLoader() == null) {
                        throw new SecurityException();
                    }
                    jx521.e[i] = e(bk).getDeclaredField(bk2);
                }
                else if (ar == 3 || ar == 4) {
                    final String bk3 = Gg3.bk(gg3);
                    final String bk4 = Gg3.bk(gg3);
                    final int ar2 = Gg3.ar(gg3);
                    final String[] array = new String[ar2];
                    for (int j = 0; j < ar2; ++j) {
                        array[j] = Gg3.bk(gg3);
                    }
                    final String bk5 = Gg3.bk(gg3);
                    final byte[][] array2 = new byte[ar2][];
                    if (ar == 3) {
                        for (int k = 0; k < ar2; ++k) {
                            final int bd2 = Gg3.bd(gg3);
                            Gg3.bx(gg3, array2[k] = new byte[bd2], 0, bd2);
                        }
                    }
                    jx521.q[i] = ar;
                    final Class[] array3 = new Class[ar2];
                    for (int l = 0; l < ar2; ++l) {
                        array3[l] = e(array[l]);
                    }
                    final Class e = e(bk5);
                    if (e(bk3).getClassLoader() == null) {
                        throw new SecurityException();
                    }
                    for (final Method method : e(bk3).getDeclaredMethods()) {
                        if (method.getName().equals(bk4)) {
                            final Class<?>[] parameterTypes = method.getParameterTypes();
                            if (parameterTypes.length == array3.length) {
                                boolean b = true;
                                for (int n3 = 0; n3 < array3.length; ++n3) {
                                    if (array3[n3] != parameterTypes[n3]) {
                                        b = false;
                                        break;
                                    }
                                }
                                if (b && e == method.getReturnType()) {
                                    jx521.s[i] = method;
                                }
                            }
                        }
                    }
                    jx521.b[i] = array2;
                }
            }
            catch (ClassNotFoundException ex) {
                jx521.j[i] = -1;
            }
            catch (SecurityException ex2) {
                jx521.j[i] = -2;
            }
            catch (NullPointerException ex3) {
                jx521.j[i] = -3;
            }
            catch (Exception ex4) {
                jx521.j[i] = -4;
            }
            catch (Throwable t) {
                jx521.j[i] = -5;
            }
        }
        Gx298.t(Ji520.g, jx521);
    }
    
    static {
        Ji520.g = new Gx298();
        Ji520.d = true;
    }
}
