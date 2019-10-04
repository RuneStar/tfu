package com.jagex.game.runetek6.client;

public class GameShell3$FrameParameters {
   private int height;
   private String title;
   private int width;
   private int xMargin;
   private int yMargin;

   public String getTitle() {
      return this.title;
   }

   public int getWidth() {
      return this.width;
   }

   public int getYMargin() {
      return this.yMargin;
   }

   public int getXMargin() {
      return this.xMargin;
   }

   public GameShell3$FrameParameters(int var1, int var2, int var3, int var4, String var5) {
      this.width = var1;
      this.height = var2;
      this.xMargin = var3;
      this.yMargin = var4;
      this.title = var5;
   }

   public int getHeight() {
      return this.height;
   }
}
