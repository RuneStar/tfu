package tfu;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ji520 {
   public static boolean d = true;
   static Gx298 g = new Gx298();

   private static Class e(String var0) throws ClassNotFoundException {
      if (var0.equals("B")) {
         return Byte.TYPE;
      } else if (var0.equals("I")) {
         return Integer.TYPE;
      } else if (var0.equals("S")) {
         return Short.TYPE;
      } else if (var0.equals("J")) {
         return Long.TYPE;
      } else if (var0.equals("Z")) {
         return Boolean.TYPE;
      } else if (var0.equals("F")) {
         return Float.TYPE;
      } else if (var0.equals("D")) {
         return Double.TYPE;
      } else if (var0.equals("C")) {
         return Character.TYPE;
      } else {
         return var0.equals("void") ? Void.TYPE : Class.forName(var0);
      }
   }

   public static void g() {
      g = new Gx298();
   }

   public static boolean d() {
      Jx521 var0 = (Jx521)Gx298.i(g);
      return var0 != null;
   }

   public static void q(Gs329 var0) {
      Jx521 var1 = (Jx521)Gx298.i(g);
      if (var1 != null) {
         int var2 = var0.v;
         Gs329.a(var0, var1.g);

         for(int var3 = 0; var3 < var1.d; ++var3) {
            if (var1.j[var3] != 0) {
               Gs329.k(var0, var1.j[var3]);
            } else {
               try {
                  int var4 = var1.q[var3];
                  Field var5;
                  int var6;
                  if (var4 == 0) {
                     var5 = var1.e[var3];
                     var6 = var5.getInt((Object)null);
                     Gs329.k(var0, 0);
                     Gs329.a(var0, var6);
                  } else if (var4 == 1) {
                     var5 = var1.e[var3];
                     var5.setInt((Object)null, var1.h[var3]);
                     Gs329.k(var0, 0);
                  } else if (var4 == 2) {
                     var5 = var1.e[var3];
                     var6 = var5.getModifiers();
                     Gs329.k(var0, 0);
                     Gs329.a(var0, var6);
                  }

                  Method var22;
                  if (var4 != 3) {
                     if (var4 == 4) {
                        var22 = var1.s[var3];
                        var6 = var22.getModifiers();
                        Gs329.k(var0, 0);
                        Gs329.a(var0, var6);
                     }
                  } else {
                     var22 = var1.s[var3];
                     byte[][] var23 = var1.b[var3];
                     Object[] var7 = new Object[var23.length];

                     for(int var8 = 0; var8 < var23.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var23[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var24 = var22.invoke((Object)null, var7);
                     if (var24 == null) {
                        Gs329.k(var0, 0);
                     } else if (var24 instanceof Number) {
                        Gs329.k(var0, 1);
                        Gs329.ag(var0, ((Number)var24).longValue());
                     } else if (var24 instanceof String) {
                        Gs329.k(var0, 2);
                        var0.af((String)var24);
                     } else {
                        Gs329.k(var0, 4);
                     }
                  }
               } catch (ClassNotFoundException var10) {
                  Gs329.k(var0, -10);
               } catch (InvalidClassException var11) {
                  Gs329.k(var0, -11);
               } catch (StreamCorruptedException var12) {
                  Gs329.k(var0, -12);
               } catch (OptionalDataException var13) {
                  Gs329.k(var0, -13);
               } catch (IllegalAccessException var14) {
                  Gs329.k(var0, -14);
               } catch (IllegalArgumentException var15) {
                  Gs329.k(var0, -15);
               } catch (InvocationTargetException var16) {
                  Gs329.k(var0, -16);
               } catch (SecurityException var17) {
                  Gs329.k(var0, -17);
               } catch (IOException var18) {
                  Gs329.k(var0, -18);
               } catch (NullPointerException var19) {
                  Gs329.k(var0, -19);
               } catch (Exception var20) {
                  Gs329.k(var0, -20);
               } catch (Throwable var21) {
                  Gs329.k(var0, -21);
               }
            }
         }

         Gs329.bz(var0, var2);
         Jx521.ef(var1);
      }
   }

   public static void j(Gg3 var0, int var1) {
      if (!d) {
         Jx521 var2 = new Jx521();
         var2.d = Gg3.ar(var0);
         var2.g = Gg3.bd(var0);
         var2.q = new int[var2.d];
         var2.j = new int[var2.d];
         var2.e = new Field[var2.d];
         var2.h = new int[var2.d];
         var2.s = new Method[var2.d];
         var2.b = new byte[var2.d][][];

         for(int var3 = 0; var3 < var2.d; ++var3) {
            try {
               int var4 = Gg3.ar(var0);
               String var5;
               String var6;
               int var7;
               if (var4 != 0 && var4 != 1 && var4 != 2) {
                  if (var4 == 3 || var4 == 4) {
                     var5 = Gg3.bk(var0);
                     var6 = Gg3.bk(var0);
                     var7 = Gg3.ar(var0);
                     String[] var8 = new String[var7];

                     for(int var9 = 0; var9 < var7; ++var9) {
                        var8[var9] = Gg3.bk(var0);
                     }

                     String var26 = Gg3.bk(var0);
                     byte[][] var10 = new byte[var7][];
                     int var12;
                     if (var4 == 3) {
                        for(int var11 = 0; var11 < var7; ++var11) {
                           var12 = Gg3.bd(var0);
                           var10[var11] = new byte[var12];
                           Gg3.bx(var0, var10[var11], 0, var12);
                        }
                     }

                     var2.q[var3] = var4;
                     Class[] var27 = new Class[var7];

                     for(var12 = 0; var12 < var7; ++var12) {
                        var27[var12] = e(var8[var12]);
                     }

                     Class var28 = e(var26);
                     if (e(var5).getClassLoader() == null) {
                        throw new SecurityException();
                     }

                     Method[] var13 = e(var5).getDeclaredMethods();
                     Method[] var14 = var13;
                     int var15 = var13.length;

                     for(int var16 = 0; var16 < var15; ++var16) {
                        Method var17 = var14[var16];
                        if (var17.getName().equals(var6)) {
                           Class[] var18 = var17.getParameterTypes();
                           if (var18.length == var27.length) {
                              boolean var19 = true;

                              for(int var20 = 0; var20 < var27.length; ++var20) {
                                 if (var27[var20] != var18[var20]) {
                                    var19 = false;
                                    break;
                                 }
                              }

                              if (var19 && var28 == var17.getReturnType()) {
                                 var2.s[var3] = var17;
                              }
                           }
                        }
                     }

                     var2.b[var3] = var10;
                  }
               } else {
                  var5 = Gg3.bk(var0);
                  var6 = Gg3.bk(var0);
                  var7 = 0;
                  if (var4 == 1) {
                     var7 = Gg3.bd(var0);
                  }

                  var2.q[var3] = var4;
                  var2.h[var3] = var7;
                  if (e(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  var2.e[var3] = e(var5).getDeclaredField(var6);
               }
            } catch (ClassNotFoundException var21) {
               var2.j[var3] = -1;
            } catch (SecurityException var22) {
               var2.j[var3] = -2;
            } catch (NullPointerException var23) {
               var2.j[var3] = -3;
            } catch (Exception var24) {
               var2.j[var3] = -4;
            } catch (Throwable var25) {
               var2.j[var3] = -5;
            }
         }

         Gx298.t(g, var2);
      }
   }
}
