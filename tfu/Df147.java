package tfu;

import com.jagex.js5.js5;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Df147 implements Ks126 {
   private static final boolean d = false;
   private static boolean g = false;
   private static final Logger logger = LoggerFactory.getLogger(Df147.class);
   private static final boolean q = false;
   private Hashtable b = new Hashtable();
   private final js5 e;
   private final String h;
   private String[] l;
   private Hashtable s = new Hashtable();
   private String[] w;

   public boolean j(String var1) {
      return this.s.containsKey(var1);
   }

   public static String g(String var0) {
      if (Ke537.q.startsWith("win")) {
         return var0 + ".dll";
      } else if (Ke537.q.startsWith("linux")) {
         return "lib" + var0 + ".so";
      } else {
         return Ke537.q.startsWith("mac") ? "lib" + var0 + ".dylib" : null;
      }
   }

   public void q(String var1, File var2) {
      if (g) {
         System.out.println("Registered library " + var1 + ": " + var2.getPath());
      }

      this.s.put(var1, var2);
   }

   public int d(String var1) {
      if (this.s.containsKey(var1)) {
         return 100;
      } else {
         String var2 = g(var1);
         if (var2 == null) {
            if (g) {
               System.out.println("Unsupported operating system: " + Ke537.q);
            }

            return -1;
         } else {
            String var3 = null;
            String var4 = "unfluttered/" + this.h + var2;
            if (js5.o(this.e, var4, "")) {
               var3 = var4;
            }

            if (var3 == null) {
               var3 = this.h + var2;
               if (!js5.o(this.e, var3, "")) {
                  if (g) {
                     System.out.println("Library download failed (library doesn't exist): " + var3);
                  }

                  return -1;
               }
            }

            if (!js5.ai(this.e, var3)) {
               return js5.al(this.e, var3);
            } else {
               logger.info("retrieving " + var3);
               byte[] var12 = js5.a(this.e, var3, "");
               File var5 = null;

               try {
                  var5 = Dh131.d(var2);
               } catch (RuntimeException var9) {
                  return -1;
               }

               if (var12 != null && var5 != null) {
                  boolean var6 = true;
                  byte[] var7 = If31.q(var5);
                  if (var7 != null && var7.length == var12.length) {
                     for(int var8 = 0; var8 < var7.length; ++var8) {
                        if (var7[var8] != var12[var8]) {
                           var6 = false;
                           break;
                        }
                     }
                  } else {
                     var6 = false;
                  }

                  try {
                     if (!var6) {
                        try {
                           FileOutputStream var13 = new FileOutputStream(var5);
                           var13.write(var12, 0, var12.length);
                           var13.close();
                        } catch (IOException var10) {
                           if (g) {
                              throw new RuntimeException("Error saving file: " + var5.getPath() + " error:" + var10.getMessage());
                           }

                           throw new RuntimeException();
                        }
                     }
                  } catch (Throwable var11) {
                     return -1;
                  }

                  this.q(var1, var5);
                  return 100;
               } else {
                  return -1;
               }
            }
         }
      }
   }

   public boolean e(String var1) {
      return this.b.containsKey(var1);
   }

   public boolean h(String var1) {
      return this.s(var1, Dw624.class);
   }

   public boolean s(String var1, Class var2) {
      Class var3 = (Class)this.b.get(var1);
      if (var3 != null) {
         if (var3.getClassLoader() != var2.getClassLoader()) {
            if (g) {
               System.out.println("Native library already loaded in another class loader: " + Ke537.q);
            }

            return false;
         } else {
            return true;
         }
      } else {
         File var4 = null;
         if (System.getenv("OVERRIDE_" + var1.toUpperCase()) != null) {
            var4 = new File(System.getenv("OVERRIDE_" + var1.toUpperCase()));
            if (!var4.exists()) {
               var4 = null;
            } else {
               var4 = new File(var4, g(var1));
               this.s.put(var1, var4);
               System.out.println("Overrode library " + var1 + " with " + var4);
            }
         }

         if (var4 == null) {
         }

         if (var4 == null) {
            var4 = (File)this.s.get(var1);
            if (g && var4 == null) {
               System.out.println(var1 + " has not been registered");
            }
         }

         if (var4 != null) {
            try {
               var4 = new File(var4.getCanonicalPath());
               Class var5 = Runtime.class;
               Class var11 = AccessibleObject.class;
               Method var7 = var11.getDeclaredMethod("setAccessible", Boolean.TYPE);
               Method var8 = var5.getDeclaredMethod("load0", Class.class, String.class);
               var7.invoke(var8, Boolean.TRUE);
               var8.invoke(Runtime.getRuntime(), var2, var4.getPath());
               var7.invoke(var8, Boolean.FALSE);
               this.b.put(var1, var2);
               if (g) {
                  System.out.println("Loaded " + var1);
               }

               return true;
            } catch (NoSuchMethodException var9) {
               System.load(var4.getPath());
               this.b.put(var1, Dw624.class);
               if (g) {
                  System.out.println("Loaded " + var1 + " using fallback!");
               }

               return true;
            } catch (Throwable var10) {
               if (g) {
                  System.out.println(var1 + " load failed:");
                  var10.printStackTrace();
                  Throwable var6 = var10.getCause();
                  if (var6 != null) {
                     System.out.println("Reason:");
                     var6.printStackTrace();
                  }
               } else {
                  var10.getCause().printStackTrace();
               }
            }
         }

         return false;
      }
   }

   public boolean b() {
      Hashtable var1 = new Hashtable();
      Enumeration var2 = this.b.keys();

      while(var2.hasMoreElements()) {
         String var3 = (String)var2.nextElement();
         var1.put(var3, this.b.get(var3));
      }

      try {
         Class var24 = AccessibleObject.class;
         Class var4 = ClassLoader.class;
         Field var5 = var4.getDeclaredField("nativeLibraries");
         Method var6 = var24.getDeclaredMethod("setAccessible", Boolean.TYPE);
         var6.invoke(var5, Boolean.TRUE);

         try {
            var2 = this.b.keys();

            while(var2.hasMoreElements()) {
               String var7 = (String)var2.nextElement();

               try {
                  File var8 = (File)this.s.get(var7);
                  Class var9 = (Class)this.b.get(var7);
                  Vector var10 = (Vector)var5.get(var9.getClassLoader());

                  for(int var11 = 0; var11 < var10.size(); ++var11) {
                     try {
                        Object var12 = var10.elementAt(var11);
                        Field var13 = var12.getClass().getDeclaredField("name");
                        var6.invoke(var13, Boolean.TRUE);

                        try {
                           String var14 = (String)var13.get(var12);
                           if (var14 != null && var14.equalsIgnoreCase(var8.getCanonicalPath())) {
                              Field var15 = var12.getClass().getDeclaredField("handle");
                              Method var16 = var12.getClass().getDeclaredMethod("finalize");
                              var6.invoke(var15, Boolean.TRUE);
                              var6.invoke(var16, Boolean.TRUE);

                              try {
                                 var16.invoke(var12);
                                 var15.set(var12, new Integer(0));
                                 var1.remove(var7);
                                 if (g) {
                                    System.out.println("Unloaded " + var7);
                                 }
                              } catch (Throwable var18) {
                              }

                              var6.invoke(var16, Boolean.FALSE);
                              var6.invoke(var15, Boolean.FALSE);
                           }
                        } catch (Throwable var19) {
                        }

                        var6.invoke(var13, Boolean.FALSE);
                     } catch (Throwable var20) {
                     }
                  }
               } catch (Throwable var21) {
               }
            }
         } catch (Throwable var22) {
         }

         var6.invoke(var5, Boolean.FALSE);
      } catch (Throwable var23) {
      }

      this.b = var1;
      return this.b.isEmpty();
   }

   public Df147(js5 var1) {
      this.e = var1;
      String var2 = "";
      if (!Ke537.q.startsWith("win") && !Ke537.q.startsWith("windows 7")) {
         if (Ke537.q.startsWith("linux")) {
            var2 = var2 + "linux/";
         } else if (Ke537.q.startsWith("mac")) {
            var2 = var2 + "macos/";
         }
      } else {
         var2 = var2 + "windows/";
      }

      if (!Ke537.j.startsWith("amd64") && !Ke537.j.startsWith("x86_64")) {
         if (!Ke537.j.startsWith("i386") && !Ke537.j.startsWith("i486") && !Ke537.j.startsWith("i586") && !Ke537.j.startsWith("x86")) {
            if (Ke537.j.startsWith("ppc")) {
               var2 = var2 + "ppc/";
            } else {
               if (g) {
                  System.out.println("Native library architecture: " + Ke537.j);
               }

               var2 = var2 + "universal/";
            }
         } else {
            var2 = var2 + "x86/";
         }
      } else {
         var2 = var2 + "x86_64/";
      }

      this.h = var2;
      if (g) {
         System.out.println("Native library js5 path: " + var2);
      }

   }
}
