package com.jagex.jnibindings.runetek6.RuntimeTool;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Y227 extends H221 {
   JPanel e;
   String[] h = new String[5];
   JPanel j;
   float[] s = new float[16];

   JTextField j() {
      JTextField var1 = new JTextField();
      var1.setMinimumSize(new Dimension(100, 30));
      T516 var2 = new T516(this, (G510)null);
      var1.addActionListener(var2);
      return var1;
   }

   public Y227(String var1) {
      super.d = var1;
      this.j = new JPanel(new BorderLayout());
      this.e = new JPanel(new GridLayout(4, 3));
      this.e.add(this.j());
      this.e.add(this.j());
      this.e.add(this.j());
      this.e.add(this.j());
      this.e.add(this.j());
      this.e.add(this.j());
      this.e.add(this.j());
      this.e.add(this.j());
      this.e.add(this.j());
      this.e.add(this.j());
      this.e.add(this.j());
      this.e.add(this.j());
      this.j.add(this.e, "Center");
      JLabel var2 = new JLabel(super.d);
      this.j.add(var2, "North");
   }

   public void g() {
      long var1 = super.g;
      RuntimeTool.h.add(new G510(this, var1));
   }
}
