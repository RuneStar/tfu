// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Component;

public class Dv322
{
    private Component d;
    private Robot g;
    
    public void g(final Component component, final int[] rgbArray, final int n, final int n2, final Point hotSpot) {
        if (rgbArray != null) {
            final BufferedImage cursor = new BufferedImage(n, n2, 2);
            cursor.setRGB(0, 0, n, n2, rgbArray, 0, n);
            component.setCursor(component.getToolkit().createCustomCursor(cursor, hotSpot, null));
        }
        else {
            component.setCursor(null);
        }
    }
    
    public Dv322() throws Exception {
        this.g = new Robot();
    }
}
