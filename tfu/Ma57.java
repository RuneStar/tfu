package tfu;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ma57 implements Mn54 {
   protected final Kf58 d;
   protected Map g;

   public int d(int var1) {
      if (this.g != null) {
         Kr260 var2 = (Kr260)this.g.get(var1);
         if (var2 != null) {
            return (Integer)var2.d;
         }
      }

      return (Integer)this.d.getDefaultValue(var1);
   }

   public void q(int var1, int var2) {
      if (this.g == null) {
         this.g = new HashMap();
         this.g.put(var1, new Kr260(var1, var2));
      } else {
         Kr260 var3 = (Kr260)this.g.get(var1);
         if (var3 == null) {
            this.g.put(var1, new Kr260(var1, var2));
         } else {
            var3.d = var2;
         }
      }

   }

   public long j(int var1) {
      if (this.g != null) {
         Kr260 var2 = (Kr260)this.g.get(var1);
         if (var2 != null) {
            return (Long)var2.d;
         }
      }

      return (Long)this.d.getDefaultValue(var1);
   }

   public void b() {
      if (this.g != null) {
         this.g.clear();
      }

   }

   public Object h(int var1) {
      if (this.g != null) {
         Kr260 var2 = (Kr260)this.g.get(var1);
         if (var2 != null) {
            return var2.d;
         }
      }

      return this.d.getDefaultValue(var1);
   }

   public void s(int var1, Object var2) {
      if (this.g == null) {
         this.g = new HashMap();
         this.g.put(var1, new Kr260(var1, var2));
      } else {
         Kr260 var3 = (Kr260)this.g.get(var1);
         if (var3 == null) {
            this.g.put(var1, new Kr260(var1, var2));
         } else {
            var3.d = var2;
         }
      }

   }

   public Ma57(Kf58 var1) {
      this.d = var1;
   }

   public void l(int var1) {
      if (this.g != null) {
         this.g.remove(var1);
      }

   }

   public Iterator iterator() {
      return this.g == null ? Collections.emptyList().iterator() : this.g.values().iterator();
   }

   public void e(int var1, long var2) {
      if (this.g == null) {
         this.g = new HashMap();
         this.g.put(var1, new Kr260(var1, var2));
      } else {
         Kr260 var4 = (Kr260)this.g.get(var1);
         if (var4 == null) {
            this.g.put(var1, new Kr260(var1, var2));
         } else {
            var4.d = var2;
         }
      }

   }
}
