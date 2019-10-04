package rs2.shared.movement;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class C184 {
   public M47 b;
   public final String d;
   public final Vector3 e;
   public final Date g;
   public Vector3 h;
   public final String j;
   public final Map l;
   public final int q;
   public final List r;
   public final M47 s;
   public PlayerPhysicsAvatar v;
   public final Map w;

   C184(Date var1, String var2, int var3, String var4, Vector3 var5, M47 var6, Vector3 var7, M47 var8) {
      this.l = new HashMap();
      this.w = new HashMap();
      this.r = new LinkedList();
      this.g = var1;
      this.d = var2;
      this.q = var3;
      this.j = var4;
      this.e = var5;
      this.s = var6;
      this.h = var7;
      this.b = var8;
   }

   public static void g(C184 var0, String var1, Object var2) {
      int var3;
      try {
         var3 = Integer.parseInt(var1);
      } catch (NumberFormatException var5) {
         var3 = StringTools.l(var1);
      }

      var0.l.put(var1, var2);
      var0.w.put(var3, var2);
   }

   public void d(String var1, Object... var2) {
      this.r.add(new O376(var1, var2));
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof C184)) {
         return false;
      } else {
         C184 var2 = (C184)var1;
         if (this.w.size() != var2.w.size()) {
            return false;
         } else {
            Iterator var3 = this.w.entrySet().iterator();

            while(var3.hasNext()) {
               Entry var4 = (Entry)var3.next();
               Integer var5 = (Integer)var4.getKey();
               if (!var2.w.containsKey(var5)) {
                  return false;
               }

               Object var6 = var4.getValue();
               Object var7 = var2.w.get(var5);
               if (var6 == null) {
                  if (var7 != null) {
                     return false;
                  }
               } else if (!var6.equals(var7)) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(this.g.getHours() + ":" + this.g.getMinutes() + ":" + this.g.getSeconds() + "." + this.g.getTime() % 1000L + " " + this.d + ": " + this.e.x + "," + this.e.y + "," + this.e.z + " [" + this.s.f00 + "," + this.s.f01 + "," + this.s.f02 + "," + this.s.f10 + "," + this.s.f11 + "," + this.s.f12 + "," + this.s.f20 + "," + this.s.f21 + "," + this.s.f22 + "] -> " + this.h.x + "," + this.h.y + "," + this.h.z + " [" + this.b.f00 + "," + this.b.f01 + "," + this.b.f02 + "," + this.b.f10 + "," + this.b.f11 + "," + this.b.f12 + "," + this.b.f20 + "," + this.b.f21 + "," + this.b.f22 + "]\n");
      Iterator var2 = this.l.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.append((String)var3.getKey() + " : " + var3.getValue() + "\n");
      }

      var2 = this.r.iterator();

      while(var2.hasNext()) {
         O376 var4 = (O376)var2.next();
         var1.append(var4.toString() + "\n");
      }

      return var1.toString();
   }

   C184(Date var1, String var2, int var3, String var4, Vector3 var5, M47 var6) {
      this.l = new HashMap();
      this.w = new HashMap();
      this.r = new LinkedList();
      this.g = var1;
      this.d = var2;
      this.q = var3;
      this.j = var4;
      this.e = var5;
      this.s = var6;
   }

   C184(Date var1, String var2, int var3, String var4, Vector3 var5, M47 var6, Map var7, Map var8) {
      this(var1, var2, var3, var4, var5, var6);

      Entry var10;
      String var11;
      for(Iterator var9 = var7.entrySet().iterator(); var9.hasNext(); g(this, var11, var10.getValue())) {
         var10 = (Entry)var9.next();
         var11 = null;
         if (var8 != null) {
            var11 = (String)var8.get(var10.getKey());
         }

         if (var11 == null) {
            var11 = Integer.toString((Integer)var10.getKey());
         }
      }

   }
}
