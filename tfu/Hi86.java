package tfu;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hi86 {
   private static final Logger logger = LoggerFactory.getLogger(Hi86.class);
   private static final boolean q = false;
   private final Bu350 b = new Bu350("Resource Manager Loader Thread");
   final In418 e = new In418();
   private Map g = new HashMap();
   final Bu350 h = new Bu350("Resource Manager Provider Thread");
   private final Class j;
   private final Bu350 l = new Bu350("Resource Manager Loader and Combiner Thread");
   private final Map r = new HashMap();
   final Bu350 s = new Bu350("Resource Manager Constructor Thread");
   private final Map v = new HashMap();
   private final Map w = new HashMap();
   private final Map y = new HashMap();

   public Bn279 e(Class var1, Object var2, int var3, Bv351 var4, Object var5) {
      Hc416 var6 = new Hc416(this, var1, var2, var3, (Mz200)null);
      return this.b.g(var6, var4, var5);
   }

   public static void d(Hi86 var0, Gg3 var1) {
      int var2 = Gg3.ar(var1);

      for(int var3 = 0; var3 < var2; ++var3) {
         String var4 = var1.bh();
         String var5 = var1.bh();
         var4 = var4.toLowerCase();
         var5 = var5.toLowerCase();
         Iterator var6 = var0.v.keySet().iterator();

         while(var6.hasNext()) {
            Class var7 = (Class)var6.next();
            Ib29 var8 = (Ib29)var0.v.get(var7);
            String var9 = var8.getIdentifier();
            if (var9 != null) {
               var9 = var9.toLowerCase();
               if (var9.equals(var4)) {
                  Object var10 = var8.getResourceAddress(var5);
                  g(var0, var7, var10);
               }
            }
         }
      }

   }

   public Hi86(Class var1) {
      this.j = var1;
   }

   public static void q(Hi86 var0) {
      var0.e.g();
   }

   public Hp62 j(Class var1, Object var2) throws Ik357 {
      Hm417 var3 = new Hm417(var1, var2);

      try {
         Hp62 var4 = this.e.j(var3, (Ao128)null);
         if (var4 != null) {
            return var4;
         } else {
            Ib29 var9 = y(this, var1);
            Ia63 var6 = x(this, var1);
            byte[] var7 = var9.getData(var2);
            var4 = var6.constructResource(var7, var2, this);
            this.e.e(var3, var4, var6);
            return var4;
         }
      } catch (Throwable var8) {
         this.e.h(var3, var8);
         Object var5 = this.g.get(var1);
         if (var5 != null && !var5.equals(var2)) {
            return this.j(var1, var5);
         } else if (var8 instanceof Ik357) {
            throw (Ik357)var8;
         } else if (var8 instanceof RuntimeException) {
            throw (RuntimeException)var8;
         } else if (var8 instanceof Error) {
            throw (Error)var8;
         } else {
            throw new RuntimeException(var8);
         }
      }
   }

   public Bn279 b(Class var1, Class var2, Object[] var3, Ir421 var4, int var5, Bv351 var6, Object var7) {
      Iq422 var8 = new Iq422(this, var1, var2, var3, var4, var5, (Mz200)null);
      return this.l.g(var8, var6, var7);
   }

   public static void g(Hi86 var0, Class var1, Object var2) {
      var0.g.put(var1, var2);
   }

   public static void w(Hi86 var0) {
      var0.b.d();
   }

   public static void r(Hi86 var0, Class var1, Ij60 var2) {
      var0.r.put(var1, var2);
   }

   // $FF: synthetic method
   static Map t(Hi86 var0) {
      return var0.g;
   }

   public static List v(Hi86 var0, Class var1) {
      Ij60 var2 = (Ij60)var0.r.get(var1);
      return var2 == null ? Collections.emptyList() : var2.getAddresses();
   }

   public static void p(Hi86 var0, Class var1, Ib29 var2) {
      var0.v.put(var1, var2);
   }

   public static Ia63 x(Hi86 var0, Class var1) {
      return (Ia63)var0.y.get(var1);
   }

   public static void u(Hi86 var0, Class var1, Ia63 var2) {
      var0.y.put(var1, var2);
   }

   public static Ib29 y(Hi86 var0, Class var1) {
      return (Ib29)var0.v.get(var1);
   }

   // $FF: synthetic method
   static Logger z() {
      return logger;
   }

   public static void l(Hi86 var0, Hp62 var1) {
      var0.e.s(var1);
   }

   public static Bn279 s(Hi86 var0, Class var1, Class var2, Collection var3, Ir421 var4, int var5, Bv351 var6, Object var7) {
      Object[] var8 = var3.toArray((Object[])Array.newInstance(var0.j, var3.size()));
      return var0.b(var1, var2, var8, var4, var5, var6, var7);
   }

   public Bn279 h(Class var1, Object var2, Mz200 var3, Bv351 var4, Object var5) {
      Hc416 var6 = new Hc416(this, var1, var2, 0, var3);
      return this.b.g(var6, var4, var5);
   }
}
