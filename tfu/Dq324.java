// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.awt.Graphics;
import java.awt.Component;
import java.awt.Canvas;

public final class Dq324 extends Canvas
{
    private Component g;
    
    @Override
    public final void update(final Graphics g) {
        this.g.update(g);
    }
    
    public Dq324(final Component g) {
        this.g = g;
    }
    
    @Override
    public final void paint(final Graphics g) {
        this.g.paint(g);
    }
}
