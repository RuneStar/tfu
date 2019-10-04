/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;

public final class Dq324
extends Canvas {
    private Component g;

    @Override
    public final void update(Graphics graphics) {
        this.g.update(graphics);
    }

    public Dq324(Component component) {
        this.g = component;
    }

    @Override
    public final void paint(Graphics graphics) {
        this.g.paint(graphics);
    }
}

