/*
 * Decompiled with CFR 0.146.
 */
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

    public GameShell3$FrameParameters(int n, int n2, int n3, int n4, String string) {
        this.width = n;
        this.height = n2;
        this.xMargin = n3;
        this.yMargin = n4;
        this.title = string;
    }

    public int getHeight() {
        return this.height;
    }
}

