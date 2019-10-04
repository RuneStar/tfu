// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.lang.reflect.Field;
import java.awt.Window;
import sun.awt.Win32GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.DisplayMode;

public class Hw321
{
    private static final boolean d = true;
    private static final boolean g = true;
    private DisplayMode j;
    private GraphicsDevice q;
    
    public static int[] g(final Hw321 hw321) {
        final DisplayMode[] displayModes = hw321.q.getDisplayModes();
        final int[] array = new int[displayModes.length << 2];
        for (int i = 0; i < displayModes.length; ++i) {
            array[i << 2] = displayModes[i].getWidth();
            array[(i << 2) + 1] = displayModes[i].getHeight();
            array[(i << 2) + 2] = displayModes[i].getBitDepth();
            array[(i << 2) + 3] = displayModes[i].getRefreshRate();
        }
        return array;
    }
    
    public void d(final Frame frame, final int n, final int n2, final int n3, int n4) {
        System.out.println("fullscreen.fsimp14: w=" + n + " h=" + n2 + " bits=" + n3 + " refreshrate=" + n4);
        this.j = this.q.getDisplayMode();
        if (this.j == null) {
            throw new NullPointerException();
        }
        frame.setUndecorated(true);
        frame.enableInputMethods(false);
        j(this, frame);
        if (n4 == 0) {
            final int refreshRate = this.j.getRefreshRate();
            final DisplayMode[] displayModes = this.q.getDisplayModes();
            int n5 = 0;
            for (int i = 0; i < displayModes.length; ++i) {
                if (displayModes[i].getWidth() == n && displayModes[i].getHeight() == n2 && displayModes[i].getBitDepth() == n3) {
                    final int refreshRate2 = displayModes[i].getRefreshRate();
                    if (n5 == 0 || Math.abs(refreshRate2 - refreshRate) < Math.abs(n4 - refreshRate)) {
                        n4 = refreshRate2;
                        n5 = 1;
                    }
                }
            }
            if (n5 != 0) {
                System.out.println("fullscreen.fsimp14: using refreshrate=" + n4 + " - closest found to currentrate=" + refreshRate);
            }
            else {
                n4 = refreshRate;
                System.out.println("fullscreen.fsimp14: no refreshrate found, falling back to current refreshrate=" + n4);
            }
        }
        this.q.setDisplayMode(new DisplayMode(n, n2, n3, n4));
        System.out.println("fullscreen.fsimp14: mode set successfully");
    }
    
    public Hw321() throws Exception {
        final GraphicsEnvironment localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.q = localGraphicsEnvironment.getDefaultScreenDevice();
        if (!this.q.isFullScreenSupported()) {
            for (final GraphicsDevice q : localGraphicsEnvironment.getScreenDevices()) {
                if (q != null && q.isFullScreenSupported()) {
                    this.q = q;
                    return;
                }
            }
            throw new Exception();
        }
    }
    
    private static void j(final Hw321 hw321, final Frame fullScreenWindow) {
        boolean b = false;
        try {
            final Field declaredField = Win32GraphicsDevice.class.getDeclaredField("valid");
            declaredField.setAccessible(true);
            if (declaredField.get(hw321.q)) {
                declaredField.set(hw321.q, Boolean.FALSE);
                b = true;
            }
        }
        catch (Throwable t) {}
        try {
            hw321.q.setFullScreenWindow(fullScreenWindow);
        }
        finally {
            if (b) {
                try {
                    Win32GraphicsDevice.class.getDeclaredField("valid").set(hw321.q, Boolean.TRUE);
                }
                catch (Throwable t2) {}
            }
        }
    }
    
    public static void q(final Hw321 hw321) {
        System.out.println("fullscreen.fsimp14: exiting");
        if (hw321.j != null) {
            final DisplayMode[] displayModes = hw321.q.getDisplayModes();
            boolean b = false;
            final DisplayMode[] array = displayModes;
            for (int length = array.length, i = 0; i < length; ++i) {
                if (array[i].equals(hw321.j)) {
                    hw321.q.setDisplayMode(hw321.j);
                    b = true;
                    break;
                }
            }
            if (!b) {
                try {
                    final Field declaredField = Win32GraphicsDevice.class.getDeclaredField("defaultDisplayMode");
                    declaredField.setAccessible(true);
                    declaredField.set(hw321.q, null);
                }
                catch (Throwable t) {}
            }
            hw321.j = null;
        }
        j(hw321, null);
        System.out.println("fullscreen.fsimp14: exited");
    }
}
