/*
 * Decompiled with CFR 0.146.
 */
package rs2.client;

import com.jagex.game.runetek6.client.GameShell3;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import rs2.client.Av403;
import rs2.client.S401;
import rs2.client.loading.Q162;
import tfu.Gz143;

class B402 {
    Image b;
    BufferedImage[] d;
    Canvas e;
    private Thread g;
    Q162 h;
    private int i = 0;
    private Runnable j = new S401(this);
    private long k = 0L;
    Image l;
    private long m = 0L;
    private long n = 0L;
    private int p = 0;
    volatile boolean q;
    private int r = 0;
    Font s;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private int x = 0;
    private int y = 0;
    private boolean z = true;

    public List g() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("loadingscreen_box_anim.png");
        for (int i = 1; i <= 4; ++i) {
            arrayList.add("loadingscreen_middle" + String.format("%02d", i) + ".png");
        }
        arrayList.add("loadingscreen_top.png");
        arrayList.add("loadingscreen_bottom.png");
        return arrayList;
    }

    public void d(Canvas canvas, Q162 q162, int n, int n2, List list) {
        if (this.g == null) {
            this.d = new BufferedImage[7];
            int n3 = 0;
            for (BufferedImage bufferedImage : list) {
                if (n3 >= this.d.length) break;
                this.d[n3++] = bufferedImage;
            }
            B402.j(this, canvas, q162, n, n2);
            MediaTracker mediaTracker = new MediaTracker(this.e);
            for (int i = 0; i < this.d.length; ++i) {
                mediaTracker.addImage(this.d[i], i);
            }
            try {
                mediaTracker.waitForAll();
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            this.v = 0;
            this.z = true;
            this.g = new Thread(this.j);
            this.g.start();
            this.k = Gz143.g() + 40000L;
            this.i = 1;
        }
    }

    B402() {
    }

    static void e(B402 b402) {
        b402.b = b402.e.createImage(b402.e.getWidth(), b402.e.getHeight());
        Graphics graphics = b402.b.getGraphics();
        graphics.setColor(Av403.q);
        graphics.fillRect(0, 0, b402.e.getWidth(), b402.e.getHeight());
    }

    public static void q(B402 b402) {
        if (b402.g != null) {
            b402.q = true;
            b402.g.interrupt();
            try {
                b402.g.join();
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            b402.g = null;
            B402.e(b402);
        }
    }

    public static synchronized void j(B402 b402, Canvas canvas, Q162 q162, int n, int n2) {
        b402.e = canvas;
        b402.h = q162;
        b402.w = n;
        b402.r = n2;
        if (b402.d[1] == null || b402.d[5] == null || b402.d[6] == null) {
            return;
        }
        b402.y = b402.d[1].getWidth();
        b402.x = b402.d[5].getHeight();
        b402.u = b402.d[6].getHeight();
        b402.p = b402.d[1].getHeight() + b402.x + b402.u;
    }

    synchronized void h(int n, String string, Color color, Color color2, Color color3, Color color4) {
        block27 : {
            try {
                Graphics graphics = this.e.getGraphics();
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
                long l = Gz143.g();
                try {
                    B402.e(this);
                    this.l = this.e.createImage(this.y, this.p);
                    Graphics graphics2 = this.l.getGraphics();
                    BufferedImage bufferedImage = this.d[this.i];
                    if (this.k < l) {
                        this.k = l + 15000L;
                        ++this.i;
                        if (this.i > 4) {
                            this.i = 1;
                        }
                    }
                    if (bufferedImage != null) {
                        int n2;
                        int n3;
                        int n4;
                        int n5;
                        graphics2.drawImage(bufferedImage, 0, this.x, null);
                        if (this.d[5] != null) {
                            graphics2.drawImage(this.d[5], 0, 0, null);
                        }
                        if (this.d[5] != null) {
                            graphics2.drawImage(this.d[6], 0, this.p - this.u, null);
                        }
                        if (this.n < l && this.t < 80 && (this.t < 5 || (float)this.t < 3.0f * (float)n)) {
                            this.n = l + 300L;
                            this.t = this.t >= n ? this.t + 1 : n;
                        }
                        this.t = this.t > 100 ? 100 : this.t;
                        int n6 = this.t * 21 / 100;
                        BufferedImage bufferedImage2 = this.d[0];
                        if (bufferedImage2 != null) {
                            int n7 = bufferedImage2.getWidth() / 12;
                            int n8 = bufferedImage2.getHeight();
                            for (int i = 0; i < 21; ++i) {
                                n2 = 511 + i * (n7 + -7);
                                n4 = 653;
                                n3 = n2 + n7;
                                n5 = 653 + n8;
                                int n9 = i < n6 ? this.v : 11;
                                int n10 = n9 * n7;
                                boolean bl = false;
                                int n11 = n10 + n7;
                                int n12 = 0 + n8;
                                graphics2.drawImage(bufferedImage2, n2, 653, n3, n5, n10, 0, n11, n12, null);
                            }
                            if (this.m < l) {
                                this.m = l + 80L;
                                if (this.z) {
                                    ++this.v;
                                    if (this.v >= 10) {
                                        this.z = !this.z;
                                        --this.v;
                                    }
                                } else {
                                    --this.v;
                                    if (this.v < 0) {
                                        this.z = !this.z;
                                        this.v = 0;
                                    }
                                }
                            }
                        }
                        Graphics graphics3 = this.b.getGraphics();
                        if (this.w > this.y && this.r > this.p) {
                            graphics3.drawImage(this.l, (this.w - this.y) / 2, (this.r - this.p) / 2, null);
                        } else {
                            float f = (float)this.w / (float)this.y;
                            float f2 = (float)this.r / (float)this.p;
                            if (f < f2) {
                                n2 = 0;
                                n4 = (this.r - (int)((float)this.p * f)) / 2;
                                n3 = 0 + (int)((float)this.y * f);
                                n5 = n4 + (int)((float)this.p * f);
                                graphics3.drawImage(this.l, 0, n4, n3, n5, 0, 0, this.y, this.p, null);
                            } else {
                                n2 = (this.w - (int)((float)this.y * f2)) / 2;
                                n4 = 0;
                                n3 = n2 + (int)((float)this.y * f2);
                                n5 = 0 + (int)((float)this.p * f2);
                                graphics3.drawImage(this.l, n2, 0, n3, n5, 0, 0, this.y, this.p, null);
                            }
                        }
                        graphics.drawImage(this.b, 0, 0, null);
                        break block27;
                    }
                    int n13 = this.w / 2 - 152;
                    int n14 = this.r / 2 - 18;
                    graphics2.setColor(color3);
                    graphics2.drawRect(n13, n14, 303, 33);
                    graphics2.setColor(color);
                    graphics2.fillRect(n13 + 2, n14 + 2, n * 3, 30);
                    graphics2.setColor(color2);
                    graphics2.drawRect(n13 + 1, n14 + 1, 301, 31);
                    graphics2.fillRect(n13 + 2 + n * 3, n14 + 2, 300 - n * 3, 30);
                    graphics2.setFont(this.s);
                    graphics2.setColor(color4);
                    graphics2.drawString(string, n13 + (304 - string.length() * 6) / 2, n14 + 50);
                    if (GameShell3.loadingTitle != null) {
                        graphics2.setFont(this.s);
                        graphics2.setColor(color4);
                        graphics2.drawString(GameShell3.loadingTitle, this.w / 2 - GameShell3.loadingTitle.length() * 6 / 2, this.r / 2 - 26);
                    }
                    graphics.drawImage(this.l, 0, 0, null);
                }
                catch (Exception exception) {
                    graphics.setColor(color2);
                    graphics.fillRect(0, 0, this.w, this.r);
                    int n15 = this.w / 2 - 152;
                    int n16 = this.r / 2 - 18;
                    graphics.setColor(color3);
                    graphics.drawRect(n15, n16, 303, 33);
                    graphics.setColor(color);
                    graphics.fillRect(n15 + 2, n16 + 2, n * 3, 30);
                    graphics.setColor(color2);
                    graphics.drawRect(n15 + 1, n16 + 1, 301, 31);
                    graphics.fillRect(n15 + 2 + n * 3, n16 + 2, 300 - n * 3, 30);
                    graphics.setFont(this.s);
                    graphics.setColor(color4);
                    graphics.drawString(string, n15 + (304 - string.length() * 6) / 2, n16 + 22);
                    if (GameShell3.loadingTitle != null) {
                        graphics.setFont(this.s);
                        graphics.setColor(color4);
                        graphics.drawString(GameShell3.loadingTitle, this.w / 2 - GameShell3.loadingTitle.length() * 6 / 2, this.r / 2 - 26);
                    }
                }
            }
            catch (Exception exception) {
                GameShell3.canvas.repaint();
            }
        }
    }
}

