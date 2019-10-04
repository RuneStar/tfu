/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class Dv322 {
    private Component d;
    private Robot g = new Robot();

    public void g(Component component, int[] arrn, int n, int n2, Point point) {
        if (arrn != null) {
            BufferedImage bufferedImage = new BufferedImage(n, n2, 2);
            bufferedImage.setRGB(0, 0, n, n2, arrn, 0, n);
            component.setCursor(component.getToolkit().createCustomCursor(bufferedImage, point, null));
        } else {
            component.setCursor(null);
        }
    }
}

