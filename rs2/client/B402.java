// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client;

import com.jagex.game.runetek6.client.GameShell3;
import java.awt.image.ImageObserver;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import tfu.Gz143;
import java.awt.Component;
import java.awt.MediaTracker;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import rs2.client.loading.Q162;
import java.awt.Canvas;
import java.awt.image.BufferedImage;
import java.awt.Image;

class B402
{
    Image b;
    BufferedImage[] d;
    Canvas e;
    private Thread g;
    Q162 h;
    private int i;
    private Runnable j;
    private long k;
    Image l;
    private long m;
    private long n;
    private int p;
    volatile boolean q;
    private int r;
    Font s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private boolean z;
    
    public List g() {
        final ArrayList<String> list = new ArrayList<String>();
        list.add("loadingscreen_box_anim.png");
        for (int i = 1; i <= 4; ++i) {
            list.add("loadingscreen_middle" + String.format("%02d", i) + ".png");
        }
        list.add("loadingscreen_top.png");
        list.add("loadingscreen_bottom.png");
        return list;
    }
    
    public void d(final Canvas canvas, final Q162 q162, final int n, final int n2, final List list) {
        if (this.g == null) {
            this.d = new BufferedImage[7];
            int n3 = 0;
            for (final BufferedImage bufferedImage : list) {
                if (n3 >= this.d.length) {
                    break;
                }
                this.d[n3++] = bufferedImage;
            }
            j(this, canvas, q162, n, n2);
            final MediaTracker mediaTracker = new MediaTracker(this.e);
            for (int i = 0; i < this.d.length; ++i) {
                mediaTracker.addImage(this.d[i], i);
            }
            try {
                mediaTracker.waitForAll();
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            this.v = 0;
            this.z = true;
            (this.g = new Thread(this.j)).start();
            this.k = Gz143.g() + 40000L;
            this.i = 1;
        }
    }
    
    B402() {
        this.j = new S401(this);
        this.w = 0;
        this.r = 0;
        this.v = 0;
        this.y = 0;
        this.p = 0;
        this.x = 0;
        this.u = 0;
        this.z = true;
        this.t = 0;
        this.m = 0L;
        this.n = 0L;
        this.k = 0L;
        this.i = 0;
    }
    
    static void e(final B402 b402) {
        b402.b = b402.e.createImage(b402.e.getWidth(), b402.e.getHeight());
        final Graphics graphics = b402.b.getGraphics();
        graphics.setColor(Av403.q);
        graphics.fillRect(0, 0, b402.e.getWidth(), b402.e.getHeight());
    }
    
    public static void q(final B402 b402) {
        if (b402.g != null) {
            b402.q = true;
            b402.g.interrupt();
            try {
                b402.g.join();
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            b402.g = null;
            e(b402);
        }
    }
    
    public static synchronized void j(final B402 b402, final Canvas e, final Q162 h, final int w, final int r) {
        b402.e = e;
        b402.h = h;
        b402.w = w;
        b402.r = r;
        if (b402.d[1] == null || b402.d[5] == null || b402.d[6] == null) {
            return;
        }
        b402.y = b402.d[1].getWidth();
        b402.x = b402.d[5].getHeight();
        b402.u = b402.d[6].getHeight();
        b402.p = b402.d[1].getHeight() + b402.x + b402.u;
    }
    
    synchronized void h(final int n, final String s, final Color color, Color color2, Color color3, Color color4) {
        try {
            final Graphics graphics = this.e.getGraphics();
            if (this.s == null) {
                this.s = new Font("Helvetica", 1, 13);
            }
            if (color2 == null) {
                color2 = new Color(140, 17, 17);
            }
            if (color3 == null) {
                color3 = new Color(140, 17, 17);
            }
            if (color4 == null) {
                color4 = new Color(255, 255, 255);
            }
            final long g = Gz143.g();
            try {
                e(this);
                this.l = this.e.createImage(this.y, this.p);
                final Graphics graphics2 = this.l.getGraphics();
                final BufferedImage bufferedImage = this.d[this.i];
                if (this.k < g) {
                    this.k = g + 15000L;
                    ++this.i;
                    if (this.i > 4) {
                        this.i = 1;
                    }
                }
                if (bufferedImage != null) {
                    graphics2.drawImage(bufferedImage, 0, this.x, null);
                    if (this.d[5] != null) {
                        graphics2.drawImage(this.d[5], 0, 0, null);
                    }
                    if (this.d[5] != null) {
                        graphics2.drawImage(this.d[6], 0, this.p - this.u, null);
                    }
                    if (this.n < g && this.t < 80 && (this.t < 5 || this.t < 3.0f * n)) {
                        this.n = g + 300L;
                        this.t = ((this.t >= n) ? (this.t + 1) : n);
                    }
                    this.t = ((this.t > 100) ? 100 : this.t);
                    final int n2 = this.t * 21 / 100;
                    final BufferedImage bufferedImage2 = this.d[0];
                    if (bufferedImage2 != null) {
                        final int n3 = bufferedImage2.getWidth() / 12;
                        final int height = bufferedImage2.getHeight();
                        for (int i = 0; i < 21; ++i) {
                            final int n4 = 511 + i * (n3 - 7);
                            final int n5 = n4 + n3;
                            final int n6 = 653 + height;
                            final int n7 = ((i < n2) ? this.v : 11) * n3;
                            graphics2.drawImage(bufferedImage2, n4, 653, n5, n6, n7, 0, n7 + n3, 0 + height, null);
                        }
                        if (this.m < g) {
                            this.m = g + 80L;
                            if (this.z) {
                                ++this.v;
                                if (this.v >= 10) {
                                    this.z = !this.z;
                                    --this.v;
                                }
                            }
                            else {
                                --this.v;
                                if (this.v < 0) {
                                    this.z = !this.z;
                                    this.v = 0;
                                }
                            }
                        }
                    }
                    final Graphics graphics3 = this.b.getGraphics();
                    if (this.w > this.y && this.r > this.p) {
                        graphics3.drawImage(this.l, (this.w - this.y) / 2, (this.r - this.p) / 2, null);
                    }
                    else {
                        final float n8 = this.w / (float)this.y;
                        final float n9 = this.r / (float)this.p;
                        if (n8 < n9) {
                            final int n10 = (this.r - (int)(this.p * n8)) / 2;
                            graphics3.drawImage(this.l, 0, n10, 0 + (int)(this.y * n8), n10 + (int)(this.p * n8), 0, 0, this.y, this.p, null);
                        }
                        else {
                            final int n11 = (this.w - (int)(this.y * n9)) / 2;
                            graphics3.drawImage(this.l, n11, 0, n11 + (int)(this.y * n9), 0 + (int)(this.p * n9), 0, 0, this.y, this.p, null);
                        }
                    }
                    graphics.drawImage(this.b, 0, 0, null);
                }
                else {
                    final int x = this.w / 2 - 152;
                    final int y = this.r / 2 - 18;
                    graphics2.setColor(color3);
                    graphics2.drawRect(x, y, 303, 33);
                    graphics2.setColor(color);
                    graphics2.fillRect(x + 2, y + 2, n * 3, 30);
                    graphics2.setColor(color2);
                    graphics2.drawRect(x + 1, y + 1, 301, 31);
                    graphics2.fillRect(x + 2 + n * 3, y + 2, 300 - n * 3, 30);
                    graphics2.setFont(this.s);
                    graphics2.setColor(color4);
                    graphics2.drawString(s, x + (304 - s.length() * 6) / 2, y + 50);
                    if (GameShell3.loadingTitle != null) {
                        graphics2.setFont(this.s);
                        graphics2.setColor(color4);
                        graphics2.drawString(GameShell3.loadingTitle, this.w / 2 - GameShell3.loadingTitle.length() * 6 / 2, this.r / 2 - 26);
                    }
                    graphics.drawImage(this.l, 0, 0, null);
                }
            }
            catch (Exception ex) {
                graphics.setColor(color2);
                graphics.fillRect(0, 0, this.w, this.r);
                final int x2 = this.w / 2 - 152;
                final int y2 = this.r / 2 - 18;
                graphics.setColor(color3);
                graphics.drawRect(x2, y2, 303, 33);
                graphics.setColor(color);
                graphics.fillRect(x2 + 2, y2 + 2, n * 3, 30);
                graphics.setColor(color2);
                graphics.drawRect(x2 + 1, y2 + 1, 301, 31);
                graphics.fillRect(x2 + 2 + n * 3, y2 + 2, 300 - n * 3, 30);
                graphics.setFont(this.s);
                graphics.setColor(color4);
                graphics.drawString(s, x2 + (304 - s.length() * 6) / 2, y2 + 22);
                if (GameShell3.loadingTitle != null) {
                    graphics.setFont(this.s);
                    graphics.setColor(color4);
                    graphics.drawString(GameShell3.loadingTitle, this.w / 2 - GameShell3.loadingTitle.length() * 6 / 2, this.r / 2 - 26);
                }
            }
        }
        catch (Exception ex2) {
            GameShell3.canvas.repaint();
        }
    }
}
