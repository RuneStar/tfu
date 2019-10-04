package rs2.shared.movement;

import com.jagex.game.runetek6.xelement.W14;
import com.jagex.jnibindings.runetek6.jagbullet.DiscreteDynamicsWorld;
import com.jagex.jnibindings.runetek6.jagbullet.HeightfieldTerrainCollisionShape;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;

public class V17 {
   public static D18 g(DiscreteDynamicsWorld var0, W14 var1, float var2, float var3, float var4, float var5, int var6, int var7, Object var8) {
      float[][] var9 = new float[W14.g(var1)][W14.d(var1)];
      float var10 = Float.MAX_VALUE;
      float var11 = -3.4028235E38F;

      for(int var12 = 0; var12 < W14.g(var1); ++var12) {
         for(int var13 = 0; var13 < W14.d(var1); ++var13) {
            float var14 = (float)(var1.s[var13 * W14.g(var1) + var12] & '\uffff') * var1.e + var1.j;
            var9[var12][var13] = var14;
            if (var14 < var10) {
               var10 = var14;
            }

            if (var14 > var11) {
               var11 = var14;
            }
         }
      }

      float var16 = var1.h * (float)(W14.g(var1) - 1);
      float var17 = var1.h * (float)(W14.d(var1) - 1);
      HeightfieldTerrainCollisionShape var18 = var0.w(var9, var16, var17, 1.0F);
      var9 = (float[][])null;
      RotTrans var15 = new RotTrans(Quaternion.g, Vector3.g(var2 + var16 / 2.0F, (var10 + var11) / 2.0F, var3 + var17 / 2.0F));
      return new D18(var0.v(var18, Q7.g(var15), var4, var5, var6, var7, false, true, var8), var18);
   }
}
