package tfu;

import com.jagex.game.runetek6.config.vartype.VarDomain;
import com.jagex.game.runetek6.config.vartype.VarType;
import com.jagex.game.runetek6.config.vartype.bit.VarBitOverflowException;
import com.jagex.game.runetek6.config.vartype.bit.VarBitType;
import com.jagex.game.runetek6.config.vartype.player.VarPlayerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rs2.client.client;
import rs2.client.worldelement.player;

public final class Fw152 implements VarDomain {
   private static final long d = 4611686018427387903L;
   private static final long e = 500L;
   private static final long j = 1L;
   private static final Logger logger = LoggerFactory.getLogger(Fw152.class);
   private static final long q = 4611686018427387904L;
   public Ha262 b = new Ha262(128);
   private int[] h;
   private int[] s;

   public Fw152() {
      this.h = new int[client.fd.length()];
      this.s = new int[client.fd.length()];
   }

   public static int g(Fw152 var0, boolean var1) {
      player var2 = Gc330.j();
      long var3 = Gz143.g();

      for(Lo465 var5 = var1 ? (Lo465)Ha262.e(var0.b) : (Lo465)Ha262.h(var0.b); var5 != null; var5 = (Lo465)Ha262.h(var0.b)) {
         if ((var5.g & 4611686018427387903L) < var3) {
            if ((var5.g & 4611686018427387904L) != 0L) {
               logger.trace("Copying server variable {}", var5.bq);
               int var6 = (int)var5.bq;
               int var7 = var0.s[var6];
               var0.s[var6] = var0.h[var6];
               Lo465.ef(var5);
               if (var2 != null) {
                  player.cv(var2, var6, var0.s[var6]);
                  if (var0.s[var6] != var7) {
                     VarPlayerType var8 = client.fd.list(var6);
                     if (var8 != null) {
                        player.ed(var2, var8.debugNameHash32, var0.s[var6], var7);
                     }
                  }
               }

               return var6;
            }

            Lo465.ef(var5);
         }
      }

      return -1;
   }

   public void d() {
      for(int var1 = 0; var1 < client.fd.length(); ++var1) {
         VarPlayerType var2 = client.fd.list(var1);
         if (var2 != null && var2.clientCode == 0) {
            this.h[var1] = 0;
            this.s[var1] = 0;
         }
      }

      this.b = new Ha262(128);
   }

   public int getVarValueInt(VarType var1) {
      return this.s[var1.id];
   }

   public void setVarValueInt(VarType var1, int var2) {
      logger.trace("Setting varp from client: {}", var1.id);
      int var3 = this.s[var1.id];
      this.s[var1.id] = var2;
      player var4 = Gc330.j();
      if (var4 != null) {
         player.ed(var4, var1.debugNameHash32, var2, var3);
      }

      Lo465 var5 = (Lo465)Ha262.d(this.b, (long)var1.id);
      if (var5 != null) {
         var5.g = Gz143.g() + 500L;
      } else {
         var5 = new Lo465(Gz143.g() + 500L);
         Ha262.q(this.b, var5, (long)var1.id);
      }

   }

   public void q(VarType var1, int var2) {
      logger.trace("Incoming varp from server: {}", var1.id);
      int var3 = this.h[var1.id];
      this.h[var1.id] = var2;
      player var4 = Gc330.j();
      if (var4 != null) {
         player.ed(var4, var1.debugNameHash32, var2, var3);
      }

      Lo465 var5 = (Lo465)Ha262.d(this.b, (long)var1.id);
      if (var5 != null) {
         if (var5.g != 4611686018427387905L) {
            var5.g = Gz143.g() + 500L | 4611686018427387904L;
         }
      } else {
         var5 = new Lo465(4611686018427387905L);
         Ha262.q(this.b, var5, (long)var1.id);
      }

   }

   public int getVarBitValue(VarBitType var1) {
      return var1.getVarbitValue(this.s[var1.baseVar.id]);
   }

   public void setVarValueLong(VarType var1, long var2) {
      throw new UnsupportedOperationException();
   }

   public void setVarBitValue(VarBitType var1, int var2) throws VarBitOverflowException {
      logger.trace("Setting varbit from client: {}", var1.id);
      int var3 = var1.setVarbitValue(this.s[var1.baseVar.id], var2);
      this.setVarValueInt(var1.baseVar, var3);
   }

   public long getVarValueLong(VarType var1) {
      throw new UnsupportedOperationException();
   }

   public static void j(Fw152 var0, VarBitType var1, int var2) {
      logger.trace("Incoming varbit from server: {}", var1.id);

      try {
         int var3 = var1.setVarbitValue(var0.h[var1.baseVar.id], var2);
         var0.q(var1.baseVar, var3);
      } catch (VarBitOverflowException var5) {
         logger.error("", var5);
      }

   }

   public Object getVarValue(VarType var1) {
      throw new UnsupportedOperationException();
   }

   public void setVarValue(VarType var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   public boolean canModifyVarValue(VarType var1) {
      return true;
   }
}
