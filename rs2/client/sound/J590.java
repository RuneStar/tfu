package rs2.client.sound;

import com.jagex.game.runetek6.gameentity.GameEntity;
import com.jagex.game.runetek6.gameentity.J332;
import com.jagex.maths.Vector3;
import fmod.Q244;
import fmod.X243;
import java.util.Enumeration;
import rs2.client.ScriptCamera;

final class J590 extends J332 {
   public void g(GameEntity var1, String var2) {
      if (var1 != null && var2 != null) {
         Vector3 var3 = var1.getWorldTransform().trans;
         ScriptCamera var4 = ScriptCamera.getActiveCamera();
         if (var4 != null) {
            Vector3 var5 = Vector3.k(var3, var4.getWorldTransform().trans);
            if (Vector3.f(var5) < 90.0F && var4 != null) {
               if (!var2.contains("/")) {
                  int var6 = GameEntity.ev(var1, "BotNumber", -1);
                  if (var6 != -1) {
                     String var7 = Ag588.e(var6, var2);
                     if (var7 != null) {
                        String var8 = var2 + Integer.toString(var6);
                        boolean var9 = false;
                        if (SoundManager.az.containsKey(var8) && (Integer)SoundManager.az.get(var8) == SoundManager.an) {
                           var9 = true;
                        }

                        if (var9) {
                           return;
                        }

                        SoundManager.az.put(var8, SoundManager.an);
                        var2 = var7;
                        Enumeration var10 = SoundManager.az.keys();

                        while(var10.hasMoreElements()) {
                           String var11 = (String)var10.nextElement();
                           int var12 = (Integer)SoundManager.az.get(var11);
                           if (var12 < SoundManager.an) {
                              SoundManager.az.remove(var11);
                           }
                        }
                     }
                  }
               }

               SoundManager.aw("ANIM", var2);
               X243 var13 = SoundManager.c.y(var2, new Q244(var3.x, var3.y, var3.z));
               if (X243.h(var13)) {
                  X243.ap(var13, var1);
               }
            }
         }

      } else {
         SoundManager.ar().error(var1 == null ? "SoundManager Animation: Game Entity is null" : "SoundManager Animation: Sound Trigger is null");
      }
   }
}
