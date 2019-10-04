package rs2.shared.movement;

import com.jagex.game.runetek6.comms.statestream.StateFactory;
import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.M47;
import com.jagex.maths.Vector3;
import java.nio.ByteBuffer;

public class B348 implements StateFactory {
   public static void q(B348 var0, E181 var1, E181 var2, ByteBuffer var3) {
      var3.putFloat(var2.g.g.x);
      var3.putFloat(var2.g.g.y);
      var3.putFloat(var2.g.g.z);
      var3.putFloat(var2.g.d.f00);
      var3.putFloat(var2.g.d.f01);
      var3.putFloat(var2.g.d.f02);
      var3.putFloat(var2.g.d.f10);
      var3.putFloat(var2.g.d.f11);
      var3.putFloat(var2.g.d.f12);
      var3.putFloat(var2.g.d.f20);
      var3.putFloat(var2.g.d.f21);
      var3.putFloat(var2.g.d.f22);
      var3.putFloat(var2.d.x);
      var3.putFloat(var2.d.y);
      var3.putFloat(var2.d.z);
      var3.putFloat(var2.q.x);
      var3.putFloat(var2.q.y);
      var3.putFloat(var2.q.z);
   }

   public E181 d(E181 var1) {
      return new E181(var1);
   }

   public E181 g() {
      return new E181();
   }

   public E181 j(E181 var1, ByteBuffer var2) {
      E181 var3 = new E181();
      Vector3 var4 = new Vector3(var2.getFloat(), var2.getFloat(), var2.getFloat());
      float var6 = var2.getFloat();
      float var7 = var2.getFloat();
      float var8 = var2.getFloat();
      float var9 = var2.getFloat();
      float var10 = var2.getFloat();
      float var11 = var2.getFloat();
      float var12 = var2.getFloat();
      float var13 = var2.getFloat();
      float var14 = var2.getFloat();
      M47 var5 = new M47(var6, var7, var8, var9, var10, var11, var12, var13, var14);
      var3.g = new Q7(var5, var4);
      var3.d = new Vector3(var2.getFloat(), var2.getFloat(), var2.getFloat());
      var3.q = new Vector3(var2.getFloat(), var2.getFloat(), var2.getFloat());
      return var3;
   }
}
