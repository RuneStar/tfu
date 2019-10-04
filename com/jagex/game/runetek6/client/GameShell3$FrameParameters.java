// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.client;

public class GameShell3$FrameParameters
{
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
    
    public GameShell3$FrameParameters(final int width, final int height, final int xMargin, final int yMargin, final String title) {
        this.width = width;
        this.height = height;
        this.xMargin = xMargin;
        this.yMargin = yMargin;
        this.title = title;
    }
    
    public int getHeight() {
        return this.height;
    }
}
