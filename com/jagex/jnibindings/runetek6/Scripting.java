package com.jagex.jnibindings.runetek6;

import %s.%s124;
import java.io.InputStream;
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
   private static HashMap b = new HashMap();
   private static boolean d = false;
   public static final int e = -1;
   public static final int h = -2;
   private static ReferenceQueue j = new ReferenceQueue();
   private static HashMap l = new HashMap();
   private static final Logger logger = LoggerFactory.getLogger(Scripting.class);
   private static Set q = new HashSet();
   public static final int s = -1;
   private static HashMap w = new HashMap();

   public static final native int getLuaFunctionRef(long var0, long var2, String var4);

   public static final long[] d(int var0) {
      d = true;
      return init(var0);
   }

   public static int q() {
      return q.size();
   }

   public static void j(LuaRef var0, int var1) {
      q.add(new Q291(var0, var1));
   }

   public static final native LuaRef deserialiseScriptMessage(long var0, long var2, String var4, String var5, byte[] var6, Object var7, String var8);

   // $FF: synthetic method
   static ReferenceQueue s() {
      return j;
   }

   public static final native void postRegisterScriptAPI(long var0, long var2);

   public static final native void purge(long var0);

   @Bs1
   @Be2
   @Ju292
   public static String typeSig(Object var0) {
      if (var0 == null) {
         return "V";
      } else {
         Class var1 = var0.getClass();
         String var2 = (String)l.get(var1);
         if (var2 != null) {
            return var2;
         } else {
            StringBuilder var3 = new StringBuilder();
            Class var4 = var1;

            while(var4.isArray()) {
               var4 = var4.getComponentType();
               var3.append('[');
            }

            if (var4 == Boolean.TYPE) {
               var3.append('Z');
            } else if (var4 == Byte.TYPE) {
               var3.append('B');
            } else if (var4 == Character.TYPE) {
               var3.append('C');
            } else if (var4 == Short.TYPE) {
               var3.append('S');
            } else if (var4 == Integer.TYPE) {
               var3.append('I');
            } else if (var4 == Long.TYPE) {
               var3.append('J');
            } else if (var4 == Float.TYPE) {
               var3.append('F');
            } else if (var4 == Double.TYPE) {
               var3.append('D');
            } else if (var3.length() > 0) {
               var3.setLength(0);
               var3.append(var0.getClass().getName().replace('.', '/'));
            } else {
               var3.append('L');
               var3.append(var0.getClass().getName().replace('.', '/'));
               var3.append(';');
            }

            var2 = var3.toString();
            l.put(var1, var2);
            return var2;
         }
      }
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
   public static String getClassName(Object var0) {
      if (var0 == null) {
         throw new IllegalArgumentException("null object passed to Scripting getClassName method");
      } else {
         Class var1 = var0.getClass();
         if (b.containsKey(var1)) {
            return (String)b.get(var1);
         } else {
            String var2 = String.format(%s124.class, var1.getName().replace('.', '/'));
            b.put(var1, var2);
            return var2;
         }
      }
   }

   public static String h(String var0) {
      String var1 = (String)w.get(var0);
      if (var1 != null) {
         return var1;
      } else {
         var1 = var0;
         StringBuffer var2 = new StringBuffer();
         int var3 = var0.indexOf(60);
         int var4;
         if (var3 != -1) {
            var4 = var0.lastIndexOf(62);
            if (var4 != -1) {
               var0 = var0.substring(0, var3) + var0.substring(var4 + 1, var0.length());
            }
         }

         if (var0.startsWith("class ")) {
            var0 = var0.substring(6, var0.length());
         }

         if (var0.startsWith("interface ")) {
            var0 = var0.substring(10, var0.length());
         }

         var4 = var0.indexOf(91);

         for(int var5 = var4; var5 != -1; var5 = var0.indexOf(91, var5 + 1)) {
            var2.append('[');
         }

         var0 = var0.replace("]", "");
         var0 = var0.replace("[", "");
         if (!var0.equals("void") && !var0.equals("V")) {
            if (!var0.equals("boolean") && !var0.equals("Z")) {
               if (!var0.equals("byte") && !var0.equals("B")) {
                  if (!var0.equals("char") && !var0.equals("C")) {
                     if (!var0.equals("short") && !var0.equals("S")) {
                        if (!var0.equals("int") && !var0.equals("I")) {
                           if (!var0.equals("long") && !var0.equals("J")) {
                              if (!var0.equals("float") && !var0.equals("F")) {
                                 if (!var0.equals("double") && !var0.equals("D")) {
                                    if (var0.length() > 0 && var0.substring(0, 1).equals("L")) {
                                       var2.append(var0.replace('.', '/'));
                                    } else {
                                       var2.append('L');
                                       var2.append(var0.replace('.', '/'));
                                       var2.append(';');
                                    }
                                 } else {
                                    var2.append('D');
                                 }
                              } else {
                                 var2.append('F');
                              }
                           } else {
                              var2.append('J');
                           }
                        } else {
                           var2.append('I');
                        }
                     } else {
                        var2.append('S');
                     }
                  } else {
                     var2.append('C');
                  }
               } else {
                  var2.append('B');
               }
            } else {
               var2.append('Z');
            }
         } else {
            var2.append('V');
         }

         String var6 = var2.toString();
         w.put(var1, var6);
         return var6;
      }
   }

   @Bs1
   @Be2
   @Ju292
   public static boolean isArray(Object var0) {
      return var0 == null ? false : var0.getClass().isArray();
   }

   @Bs1
   @Be2
   @Ju292
   public static boolean lessThan(Object var0, Object var1) {
      if (var0 instanceof Comparable) {
         Comparable var2 = (Comparable)var0;
         return var2.compareTo(var1) < 0;
      } else {
         throw new RuntimeException(String.format("Class %s does not implement Comparable", var0 == null ? "null" : var0.getClass().getSimpleName()));
      }
   }

   public static final native void populateFunctionTable(long var0);

   public static final boolean g() {
      return d;
   }

   @Bs1
   @Be2
   @Ju292
   public static boolean lessThanOrEqual(Object var0, Object var1) {
      if (var0 instanceof Comparable) {
         Comparable var2 = (Comparable)var0;
         return var2.compareTo(var1) <= 0;
      } else {
         throw new RuntimeException(String.format("Class %s does not implement Comparable", var0 == null ? "null" : var0.getClass().getSimpleName()));
      }
   }

   public static void e(long var0, long var2) {
      Lb33.g(Lb33.RemovePhantomLuaRefs);

      try {
         Q291 var4;
         while((var4 = (Q291)j.poll()) != null) {
            q.remove(var4);
            unref(var0, var2, Q291.g(var4));
         }

         Lb33.d(Lb33.RemovePhantomLuaRefs);
      } finally {
         Lb33.d(Lb33.RemovePhantomLuaRefs);
      }
   }

   private static final native long[] init(int var0);
}
