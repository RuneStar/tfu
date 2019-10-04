package rs2.client.inventory;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.config.objtype.ObjStackability;
import com.jagex.game.runetek6.config.objtype.ObjType;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.constants.VarDomainType;
import com.jagex.game.runetek6.config.vartype.general.VarBasicType;
import com.jagex.game.runetek6.script.ScriptDefaults;
import com.jagex.game.runetek6.script.ScriptEntryPoint;
import com.jagex.game.runetek6.script.ScriptID;
import rs2.client.client;
import tfu.Be2;
import tfu.Bs1;
import tfu.Ln265;
import tfu.Mq489;

public final class ClientInventory extends Ln265 {
   boolean d = false;
   private final int g;
   private Mq489[] q = new Mq489[]{null};

   ClientInventory(int var1) {
      this.g = var1;
   }

   public void g(int var1, int var2, int var3) {
      if (this.q.length <= var1) {
         Mq489[] var4 = new Mq489[var1 + 1];
         System.arraycopy(this.q, 0, var4, 0, this.q.length);
         this.q = var4;
      }

      if (this.q[var1] != null && Mq489.d(this.q[var1]) == var2) {
         Mq489.j(this.q[var1], var3);
      } else {
         this.q[var1] = new Mq489(var2, var3, client.fi);
      }

   }

   public static void d(ClientInventory var0) {
      for(int var1 = 0; var1 < var0.q.length; ++var1) {
         var0.q[var1] = null;
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int GetID() {
      return this.g;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int GetSlotTotal(int var1) {
      return var1 >= 0 && var1 < this.q.length ? Mq489.d(this.q[var1]) : 0;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int GetFreeSpace() {
      int var1 = 0;

      for(int var2 = 0; var2 < this.q.length; ++var2) {
         if (this.q[var2] == null) {
            ++var1;
         }
      }

      var1 += client.fv.list(this.g).size - this.q.length;
      return var1;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int GetTotalParam(int var1, int var2, @ScriptID @ScriptDefaults(defaultBoolean = true) boolean var3) {
      int var4 = 0;

      for(int var5 = 0; var5 < this.q.length; ++var5) {
         if (this.q[var5] != null && var1 == Mq489.d(this.q[var5])) {
            ObjType var6 = client.fa.list(Mq489.d(this.q[var5]));
            int var7 = var6.getParam(var2, client.fh.list(var2).defaultint);
            if (var3) {
               var4 += Mq489.q(this.q[var5]) * var7;
            } else {
               var4 += var7;
            }
         }
      }

      return var4;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int GetSize() {
      return client.fv.list(this.g).size;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public String GetItemName(int var1) {
      return var1 >= 0 && var1 < client.fa.num ? client.fa.list(var1).name : null;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public Object GetSlotObjVar(int var1, String var2) {
      if (var1 >= 0 && var1 < this.q.length) {
         VarType var3 = client.fi.hashLookup(StringTools.l(var2));
         if (var3 != null) {
            if (var3.domain != VarDomainType.OBJECT) {
               throw new RuntimeException("'" + var2 + "' is not an object variable, it's a " + var3.domain.name());
            } else {
               return this.q[var1] == null ? client.fi.getDefaultValue(var3.id) : this.q[var1].getVarValue(var3);
            }
         } else {
            VarBitType var4 = client.fl.hashLookup(StringTools.l(var2));
            if (var4 != null) {
               if (var4.baseVar.domain != VarDomainType.OBJECT) {
                  throw new RuntimeException("'" + var2 + "' is not an object varbit, it's a " + var4.baseVar.domain.name());
               } else {
                  return this.q[var1].getVarBitValue(var4);
               }
            } else {
               throw new RuntimeException("Object variable '" + var2 + "' not defined");
            }
         }
      } else {
         throw new RuntimeException("GetSlotObjVar: slot out of range 0 >= " + var1 + " >= " + this.q.length);
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int GetItemType(int var1) {
      return var1 >= 0 && var1 < this.q.length ? Mq489.d(this.q[var1]) : -1;
   }

   public void q(int var1, int var2, Object var3) {
      if (var1 >= 0 && var1 < this.q.length && this.q[var1] != null) {
         VarBasicType var4 = client.fi.list(var2);
         if (var4 != null) {
            if (var4.domain != VarDomainType.OBJECT) {
               throw new IllegalStateException("'" + var2 + "' is not an object variable, it's a " + var4.domain.name());
            }

            this.q[var1].setVarValue(var4, var3);
         }
      }

   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int GetItemCount(int var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < this.q.length; ++var3) {
         if (this.q[var3] != null && Mq489.d(this.q[var3]) == var1) {
            var2 += Mq489.q(this.q[var3]);
         }
      }

      return var2;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean IsItemStackable(int var1) {
      if (var1 >= 0 && var1 < client.fa.num) {
         return client.fa.list(var1).stackable != ObjStackability.NEVER;
      } else {
         return false;
      }
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public boolean IsMembersItem(int var1) {
      return var1 >= 0 && var1 < client.fa.num ? client.fa.list(var1).IsMembers() : false;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int GetItemMultiStacksize(int var1) {
      return var1 >= 0 && var1 < client.fa.num ? client.fa.list(var1).multistacksize : 0;
   }

   @ScriptEntryPoint
   @Be2
   @Bs1
   public int GetItemCost(int var1) {
      return var1 >= 0 && var1 < client.fa.num ? client.fa.list(var1).cost : 0;
   }

   public String toString() {
      String var1 = super.toString();
      var1 = var1.substring(var1.lastIndexOf(64));
      return this.g + (this.d ? " [dead]" : "") + " (" + var1 + ")";
   }
}
