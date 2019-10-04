package tfu;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;

public final class Dq324 extends Canvas {
   private Component g;

   public final void update(Graphics var1) {
      this.g.update(var1);
   }

   public Dq324(Component var1) {
      this.g = var1;
   }

   public final void paint(Graphics var1) {
      this.g.paint(var1);
   }
}
