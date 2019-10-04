package rs2.client;

import com.jagex.maths.E41;
import com.jagex.maths.Vector3;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.Q40;

final class C414 implements Q40 {
   public PhysicsWorldWrapper g() {
      return client.gz.d;
   }

   public int d() {
      throw new IllegalStateException("This is a server-only command!");
   }

   public void q(Vector3 var1) {
      throw new IllegalStateException("This is a server-only command at present!");
   }

   public E41 j() {
      throw new IllegalStateException("getAabb not supported on this entity");
   }

   public Vector3 h() {
      return Vector3.g;
   }

   public Vector3 e() {
      return Vector3.g;
   }
}
