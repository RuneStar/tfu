package rs2.shared.sound;

class D377 implements Runnable {
   // $FF: synthetic field
   final SoundAdapter g;

   public void run() {
      SoundAdapter.e(this.g, "SoundRemovedEvent", this.g);
   }

   D377(SoundAdapter var1) {
      this.g = var1;
   }
}
