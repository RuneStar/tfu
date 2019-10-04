package rs2.shared.movement;

public enum S15 {
   GROUND(1),
   CAMERA(4),
   SCENERY(0),
   NPC(3),
   PLAYER(2);

   public final int h;

   private S15(int var3) {
      this.h = var3;
   }
}
