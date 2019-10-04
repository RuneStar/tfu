package rs2.client.worldelement;

import com.jagex.maths.E41;
import com.jagex.maths.Vector3;
import rs2.client.client;
import rs2.shared.movement.PhysicsWorldWrapper;
import rs2.shared.movement.PlayerPhysicsComponent;
import rs2.shared.movement.Q40;

class E39 implements Q40 {
   // $FF: synthetic field
   final player g;

   public Vector3 h() {
      return ((PlayerPhysicsComponent)player.eb(this.g, PlayerPhysicsComponent.class)).h;
   }

   public int d() {
      throw new IllegalStateException("This is a server-only command!");
   }

   public E41 j() {
      return PlayerPhysicsComponent.b((PlayerPhysicsComponent)player.eb(this.g, PlayerPhysicsComponent.class));
   }

   public PhysicsWorldWrapper g() {
      return client.gz.d;
   }

   public void q(Vector3 var1) {
      throw new IllegalStateException("This is a server-only command at present!");
   }

   E39(player var1) {
      this.g = var1;
   }

   public Vector3 e() {
      return ((PlayerPhysicsComponent)player.eb(this.g, PlayerPhysicsComponent.class)).e;
   }
}
