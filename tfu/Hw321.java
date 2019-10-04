/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.io.PrintStream;
import java.lang.reflect.Field;
import sun.awt.Win32GraphicsDevice;

public class Hw321 {
    private static final boolean d = true;
    private static final boolean g = true;
    private DisplayMode j;
    private GraphicsDevice q;

    public static int[] g(Hw321 hw321) {
        DisplayMode[] arrdisplayMode = hw321.q.getDisplayModes();
        int[] arrn = new int[arrdisplayMode.length << 2];
        for (int i = 0; i < arrdisplayMode.length; ++i) {
            arrn[i << 2] = arrdisplayMode[i].getWidth();
            arrn[(i << 2) + 1] = arrdisplayMode[i].getHeight();
            arrn[(i << 2) + 2] = arrdisplayMode[i].getBitDepth();
            arrn[(i << 2) + 3] = arrdisplayMode[i].getRefreshRate();
        }
        return arrn;
    }

    public void d(Frame frame, int n, int n2, int n3, int n4) {
        System.out.println("fullscreen.fsimp14: w=" + n + " h=" + n2 + " bits=" + n3 + " refreshrate=" + n4);
        this.j = this.q.getDisplayMode();
        if (this.j == null) {
            throw new NullPointerException();
        }
        frame.setUndecorated(true);
        frame.enableInputMethods(false);
        Hw321.j(this, frame);
        if (n4 == 0) {
            int n5 = this.j.getRefreshRate();
            DisplayMode[] arrdisplayMode = this.q.getDisplayModes();
            boolean bl = false;
            for (int i = 0; i < arrdisplayMode.length; ++i) {
                if (arrdisplayMode[i].getWidth() != n || arrdisplayMode[i].getHeight() != n2 || arrdisplayMode[i].getBitDepth() != n3) continue;
                int n6 = arrdisplayMode[i].getRefreshRate();
                if (bl && Math.abs(n6 - n5) >= Math.abs(n4 - n5)) continue;
                n4 = n6;
                bl = true;
            }
            if (bl) {
                System.out.println("fullscreen.fsimp14: using refreshrate=" + n4 + " - closest found to currentrate=" + n5);
            } else {
                n4 = n5;
                System.out.println("fullscreen.fsimp14: no refreshrate found, falling back to current refreshrate=" + n4);
            }
        }
        this.q.setDisplayMode(new DisplayMode(n, n2, n3, n4));
        System.out.println("fullscreen.fsimp14: mode set successfully");
    }

    public Hw321() throws Exception {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.q = graphicsEnvironment.getDefaultScreenDevice();
        if (!this.q.isFullScreenSupported()) {
            GraphicsDevice[] arrgraphicsDevice;
            for (GraphicsDevice graphicsDevice : arrgraphicsDevice = graphicsEnvironment.getScreenDevices()) {
                if (graphicsDevice == null || !graphicsDevice.isFullScreenSupported()) continue;
                this.q = graphicsDevice;
                return;
            }
            throw new Exception();
        }
    }

    private static void j(Hw321 hw321, Frame frame) {
        Field field;
        boolean bl = false;
        try {
            field = Win32GraphicsDevice.class.getDeclaredField("valid");
            field.setAccessible(true);
            boolean bl2 = (Boolean)field.get(hw321.q);
            if (bl2) {
                field.set(hw321.q, Boolean.FALSE);
                bl = true;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            hw321.q.setFullScreenWindow(frame);
            if (bl) {
                try {
                    field = Win32GraphicsDevice.class.getDeclaredField("valid");
                    field.set(hw321.q, Boolean.TRUE);
                }
                catch (Throwable throwable) {}
            }
        }
        catch (Throwable throwable) {
            if (bl) {
                try {
                    Field field2 = Win32GraphicsDevice.class.getDeclaredField("valid");
                    field2.set(hw321.q, Boolean.TRUE);
                }
                catch (Throwable throwable2) {
                    // empty catch block
                }
            }
            throw throwable;
        }
    }

    public static void q(Hw321 hw321) {
        System.out.println("fullscreen.fsimp14: exiting");
        if (hw321.j != null) {
            DisplayMode[] arrdisplayMode = hw321.q.getDisplayModes();
            boolean bl = false;
            for (DisplayMode displayMode : arrdisplayMode) {
                if (!displayMode.equals(hw321.j)) continue;
                hw321.q.setDisplayMode(hw321.j);
                bl = true;
                break;
            }
            if (!bl) {
                try {
                    Field field = Win32GraphicsDevice.class.getDeclaredField("defaultDisplayMode");
                    field.setAccessible(true);
                    field.set(hw321.q, null);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            hw321.j = null;
        }
        Hw321.j(hw321, null);
        System.out.println("fullscreen.fsimp14: exited");
    }
}

