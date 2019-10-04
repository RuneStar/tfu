package rs2.shared.movement;

import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.M47;
import com.jagex.maths.Quaternion;
import com.jagex.maths.Vector3;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import tfu.Gg3;

public class Y192 {
   private static final List d = new LinkedList();
   public static boolean e = false;
   public static final Map g = new HashMap();
   static PrintStream h = null;
   private static boolean j;
   private static final List q = new LinkedList();

   public static void q() {
      if (e) {
         Iterator var0 = d.iterator();

         while(var0.hasNext()) {
            C184 var1 = (C184)var0.next();
            Q7 var2 = var1.v.getCurrentTransform();
            if (var2 != null) {
               var1.h = var2.g;
               var1.b = var2.d;
               if (!j) {
                  Object var3 = (Map)g.get(var1.q);
                  if (var3 == null) {
                     var3 = new HashMap();
                     g.put(var1.q, var3);
                  }

                  Object var4 = (Map)((Map)var3).get(var1.j);
                  if (var4 == null) {
                     var4 = new HashMap();
                     ((Map)var3).put(var1.j, var4);
                  }

                  ((Map)var4).put(var1.d, var1);
               }

               if (j) {
                  q.add(var1);
               }
            }
         }

         d.clear();
      }
   }

   public static void g(boolean var0) {
      j = var0;
   }

   public static boolean j() {
      return !q.isEmpty();
   }

   public static C184 d(String var0, int var1, String var2, PlayerPhysicsAvatar var3, Map var4, Map var5) {
      if (!e) {
         return null;
      } else {
         Q7 var6 = var3.getCurrentTransform();
         if (var6 != null) {
            C184 var7 = new C184(new Date(), var0, var1, var2, var6.g, var6.d, var4, var5);
            var7.v = var3;
            d.add(var7);
            return var7;
         } else {
            return null;
         }
      }
   }

   public static boolean e(Gg3 var0) {
      int var1 = var0.v;
      Gg3.i(var0, q.size());
      LinkedList var2 = new LinkedList();
      Iterator var3 = q.iterator();

      while(var3.hasNext()) {
         C184 var4 = (C184)var3.next();
         if (var0.v > 512) {
            break;
         }

         Gg3.ag(var0, var4.g.getTime());
         var0.af(var4.d);
         var0.af(var4.j);
         Gg3.a(var0, var4.q);
         Vector3.w(var4.e, var0);
         Vector3.w(var4.h, var0);
         M47.b(var4.s, var0);
         M47.b(var4.b, var0);
         Gg3.i(var0, var4.l.size());
         Iterator var5 = var4.l.entrySet().iterator();

         while(var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            var0.af((String)var6.getKey());
            Object var7 = var6.getValue();
            if (var7 instanceof Boolean) {
               if ((Boolean)var7) {
                  Gg3.k(var0, 1);
               } else {
                  Gg3.k(var0, 0);
               }
            } else {
               if (!(var7 instanceof Double)) {
                  throw new IllegalStateException("Only boolean and number controls are currently supported");
               }

               Gg3.k(var0, 2);
               Gg3.ai(var0, (Double)var7);
            }
         }

         Gg3.i(var0, var4.r.size());
         var5 = var4.r.iterator();

         while(var5.hasNext()) {
            O376 var13 = (O376)var5.next();
            var0.ap(var13.g);
            Gg3.k(var0, var13.d.length);
            Object[] var14 = var13.d;
            int var8 = var14.length;

            for(int var9 = 0; var9 < var8; ++var9) {
               Object var10 = var14[var9];
               if (var10 instanceof Integer) {
                  Gg3.k(var0, 0);
                  Gg3.a(var0, (Integer)var10);
               } else if (var10 instanceof Boolean) {
                  Gg3.k(var0, (Boolean)var10 ? 2 : 1);
               } else if (var10 instanceof Float) {
                  Gg3.k(var0, 3);
                  Gg3.aq(var0, (Float)var10);
               } else if (var10 instanceof Quaternion) {
                  Gg3.k(var0, 4);
                  Quaternion.q((Quaternion)var10, var0);
               } else if (var10 instanceof Vector3) {
                  Gg3.k(var0, 5);
                  Vector3.w((Vector3)var10, var0);
               }
            }
         }

         var2.add(var4);
      }

      int var11 = var2.size();
      if (var11 == 0) {
         return false;
      } else {
         if (var11 != q.size()) {
            int var12 = var0.v;
            var0.v = var1;
            Gg3.i(var0, var11);
            var0.v = var12;
         }

         q.removeAll(var2);
         return true;
      }
   }
}
