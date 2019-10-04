package rs2.shared.movement;

import com.jagex.jnibindings.runetek6.jagbullet.Q7;
import com.jagex.maths.M47;
import com.jagex.maths.Quaternion;
import com.jagex.maths.RotTrans;
import com.jagex.maths.Vector3;

public class T278 implements Ai37 {
   private Vector3 d;
   private Vector3 g;

   public Vector3 g() {
      return this.d;
   }

   public RotTrans q() {
      return new RotTrans(Quaternion.g, this.g);
   }

   public E181 j() {
      E181 var1 = new E181();
      var1.g = new Q7(M47.g, this.g);
      var1.d = this.d;
      return var1;
   }

   public void h(Q7 var1) {
      this.g = var1.g;
   }

   public T278(Vector3 var1) {
      this.d = Vector3.g;
      this.g = var1;
   }

   public void d(Vector3 var1, float var2, boolean var3) {
      this.d = var1;
      this.g = Vector3.z(this.g, this.d);
   }
}
