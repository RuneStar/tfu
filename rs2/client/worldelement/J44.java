package rs2.client.worldelement;

import com.jagex.maths.E41;
import com.jagex.maths.Vector3;
import rs2.client.client;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.Q40;
import tfu.Jt38;

class J44 implements Q40 {
   // $FF: synthetic field
   final Npc g;

   J44(Npc var1) {
      this.g = var1;
   }

   public int d() {
      throw new IllegalStateException("This is a server-only command!");
   }

   public void q(Vector3 var1) {
      throw new IllegalStateException("This is a server-only command at present!");
   }

   public E41 j() {
      if (this.g.aq != null) {
         return Jt38.af(this.g.aq);
      } else {
         Vector3 var1 = this.g.getWorldTransform().trans;
         return new E41(var1.x, var1.y, var1.z, var1.x, var1.y, var1.z);
      }
   }

   public PhysicsWorldWrapper g() {
      return client.gz.d;
   }

   public Vector3 h() {
      return Npc.bs(this.g);
   }

   public Vector3 e() {
      return Npc.be(this.g);
   }
}
