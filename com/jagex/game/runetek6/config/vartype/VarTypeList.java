package com.jagex.game.runetek6.config.vartype;

import com.jagex.core.constants.Language;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import java.util.HashMap;
import java.util.Map;
import tfu.Ff259;
import tfu.Gd27;
import tfu.Gg3;
import tfu.Kf58;
import tfu.Kr260;
import tfu.Kz261;

public abstract class VarTypeList extends Ff259 implements Kf58 {
   private Map hashLookup = null;
   public final VarDomainType variableDomain;

   protected VarTypeList(Gd27 var1, VarDomainType var2, Language var3, int var4) {
      super(var1, var3, var4);
      this.variableDomain = var2;
   }

   public int length() {
      return super.q;
   }

   public static Map createDomainToListEnumMap(VarTypeList... var0) {
      if (var0 != null && var0.length != 0) {
         HashMap var1 = new HashMap();
         VarTypeList[] var2 = var0;
         int var3 = var0.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            VarTypeList var5 = var2[var4];
            var1.put(var5.variableDomain, var5);
         }

         return var1;
      } else {
         return null;
      }
   }

   public abstract VarType list(int var1);

   public void createHashMapLookup() {
      this.hashLookup = new HashMap();

      for(int var1 = 0; var1 < super.q; ++var1) {
         VarType var2 = this.list(var1);
         if (var2.debugNameHash32 != 0) {
            this.hashLookup.put(var2.debugNameHash32, var1);
         }
      }

   }

   public Object getDefaultValue(int var1) {
      VarType var2 = this.list(var1);
      return var2 != null && var2.isValidDefinition() ? var2.getDefaultValue() : null;
   }

   public VarType hashLookup(int var1) {
      return this.hashLookup.containsKey(var1) ? this.list((Integer)this.hashLookup.get(var1)) : null;
   }

   public void encodeVarValue(Gg3 var1, Kr260 var2) {
      Gg3.i(var1, var2.g);
      if (var2.d instanceof Integer) {
         Gg3.a(var1, (Integer)var2.d);
      } else if (var2.d instanceof Long) {
         Gg3.ag(var1, (Long)var2.d);
      } else if (var2.d instanceof String) {
         var1.ap((String)var2.d);
      } else {
         if (!(var2.d instanceof Kz261)) {
            throw new IllegalStateException();
         }

         ((Kz261)var2.d).d(var1);
      }

   }

   public Kr260 decodeVarValue(Gg3 var1) {
      int var2 = Gg3.au(var1);
      VarType var3 = this.list(var2);
      if (!var3.isValidDefinition()) {
         return null;
      } else {
         Kr260 var4 = new Kr260(var2);
         Class var5 = var3.dataType.getVarBaseType().javaClass;
         if (var5 == Integer.class) {
            var4.d = Gg3.bd(var1);
         } else if (var5 == Long.class) {
            var4.d = Gg3.bq(var1);
         } else if (var5 == String.class) {
            var4.d = var1.bh();
         } else {
            if (!Kz261.class.isAssignableFrom(var5)) {
               throw new IllegalStateException();
            }

            try {
               Kz261 var6 = (Kz261)var5.newInstance();
               var6.q(var1);
               var4.d = var6;
            } catch (InstantiationException var7) {
            } catch (IllegalAccessException var8) {
            }
         }

         return var4;
      }
   }

   public int getValueEncodingLength(Kr260 var1) {
      byte var2 = 2;
      int var3;
      if (var1.d instanceof Integer) {
         var3 = var2 + 4;
      } else if (var1.d instanceof Long) {
         var3 = var2 + 8;
      } else if (var1.d instanceof String) {
         var3 = var2 + Gg3.av((String)var1.d);
      } else {
         if (!(var1.d instanceof Kz261)) {
            throw new IllegalStateException();
         }

         var3 = var2 + ((Kz261)var1.d).g();
      }

      return var3;
   }
}
