package com.jagex.game.runetek6.gameentity;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.variables.G53;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import tfu.Js343;
import tfu.Kh56;

public final class G55 {
   private final Map d = new HashMap();
   private final GameEntity g;
   private Map j = new HashMap();
   private G53 q;

   public String g(String var1) {
      String var2 = "On" + var1 + "Changed";
      int var3 = StringTools.l(var1);
      int var4 = StringTools.l(var2);
      this.j.put(var3, var4);
      return var2;
   }

   public static int q(G55 var0, String var1, int var2) {
      Number var3 = (Number)var0.j(var1);
      return var3 != null ? var3.intValue() : var2;
   }

   public Object j(String var1) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         return this.q != null && this.q.br(var1) ? this.q.GetVar(var1) : this.d.get(var1);
      }
   }

   public static Object e(G55 var0, String var1, Object var2) {
      Object var3 = var0.j(var1);
      return var3 == null ? var2 : var3;
   }

   public void h(String var1, Object var2) {
      if (var1 == null) {
         throw new NullPointerException();
      } else {
         int var3 = StringTools.l(var1);
         Integer var4 = this.g == null ? null : (Integer)this.j.get(var3);
         Object var5;
         if (this.q != null && this.q.br(var1)) {
            try {
               var5 = this.q.GetVar(var1);
               this.q.SetVar(var1, var2);
               Object var6 = this.q.GetVar(var1);
               if (!Kh56.g(var6, var5)) {
                  if (var4 != null) {
                     this.g.triggerEvent(var4, var2);
                  }

                  Iterator var7 = this.g.ca.iterator();

                  while(var7.hasNext()) {
                     Integer var8 = (Integer)var7.next();
                     this.g.triggerEvent(var8, new Js343(var1, new Object[]{var5, var6}));
                  }
               }
            } catch (VarBitOverflowException var9) {
               throw new IllegalArgumentException(var9);
            }
         } else {
            var5 = this.d.get(var1);
            if (!Kh56.g(var2, var5)) {
               if (var2 != null) {
                  this.d.put(var1, var2);
               } else {
                  this.d.remove(var1);
               }

               if (var4 != null) {
                  this.g.triggerEvent(var4, var2);
               }
            }
         }

      }
   }

   public static Integer s(G55 var0, int var1) {
      return var0.g == null ? null : (Integer)var0.j.get(var1);
   }

   public G55(GameEntity var1) {
      this.g = var1;
   }

   public void d(G53 var1) {
      if (this.q != null) {
         throw new IllegalStateException("Already set");
      } else if (var1 == null) {
         throw new NullPointerException();
      } else {
         this.q = var1;
         Iterator var2 = this.d.entrySet().iterator();

         while(var2.hasNext()) {
            Entry var3 = (Entry)var2.next();
            if (this.q.br((String)var3.getKey())) {
               try {
                  this.q.SetVar((String)var3.getKey(), var3.getValue());
               } catch (VarBitOverflowException var5) {
                  throw new IllegalStateException(var5);
               }

               var2.remove();
            }
         }

      }
   }
}
