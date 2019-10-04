// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.game.runetek6.client;

import java.applet.AppletContext;
import org.slf4j.LoggerFactory;
import java.awt.event.FocusEvent;
import java.awt.Rectangle;
import java.awt.Graphics;
import tfu.Ap127;
import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import com.jagex.core.stringtools.general.StringTools;
import tfu.Dq324;
import tfu.Gz143;
import java.awt.LayoutManager;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Color;
import java.net.URL;
import tfu.Mu209;
import java.awt.event.WindowEvent;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import tfu.Dp208;
import tfu.Is139;
import tfu.Dh131;
import java.awt.Toolkit;
import tfu.Ku323;
import tfu.Kt125;
import java.awt.Component;
import java.io.IOException;
import tfu.Gg3;
import java.awt.Image;
import tfu.Dv322;
import org.slf4j.Logger;
import tfu.Hw321;
import java.awt.Frame;
import java.awt.EventQueue;
import java.awt.Canvas;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.io.File;
import tfu.Im133;
import java.awt.Font;
import java.awt.event.WindowListener;
import java.awt.event.FocusListener;
import java.applet.Applet;

public abstract class GameShell3 extends Applet implements Runnable, FocusListener, WindowListener
{
    private static final int CACHE_LOCATOR_MOVECACHE = 1;
    private static final int CACHE_LOCATOR_NORMAL = 0;
    public static final int DEFAULT_LOGIC_RATE = 50;
    public static final float DEFAULT_PHYSICS_RATE = 20.0f;
    private static final String FILE_ACCESS_PERMISSIONS = "rw";
    private static final int MAX_CACHEINDEX_SIZE = 1048576;
    public static final long NANOS_PER_SECOND = 1000000000L;
    public static double PauseCountFPS;
    private static final String UIDFileName = "random.dat";
    public static final long UPDATE_FPS_INTERVAL = 1000000000L;
    private static final boolean allowHost8Realms = true;
    private static final boolean allowHostFunorb = true;
    private static final boolean allowHostRunescape = true;
    private static final boolean allowHostStellarDawn = true;
    private static final boolean allowHostTransformers = true;
    private static int archiveCount;
    private static Font bf;
    public static Im133 cacheDat;
    private static final String cacheDatFilename = "main_file_cache.dat2";
    private static File cacheDirectory;
    public static Im133[] cacheIndex;
    private static final String cacheIndexFilename = "main_file_cache.idx";
    private static File cacheLocator;
    private static FileLock cacheLock;
    private static FileChannel cacheLockChannel;
    private static FileOutputStream cacheLockFile;
    private static final String cacheMasterIndexFilename = "main_file_cache.idx255";
    public static Canvas canvas;
    public static int canvasHei;
    public static volatile boolean canvasReplaceRecommended;
    public static int canvasWid;
    public static int cpucount;
    private static final boolean debug = true;
    public static GameShell3$Environment environment;
    public static EventQueue eventQueue;
    public static boolean focus;
    private static volatile boolean focus_in;
    public static double fps;
    public static double fpsAverage;
    public static double fpsCount;
    public static double fpsH;
    public static double fpsL;
    public static double fpsTotal;
    public static Frame frame;
    public static int frameHei;
    public static int frameWid;
    public static Frame fsframe;
    public static Hw321 fsimp14;
    private static int fullRedrawForce;
    public static volatile boolean fullredraw;
    private static String[] historicCacheDirectories;
    private static int historicCacheId;
    private static String[] historicCacheLocations;
    public static String homeDir;
    public static String javaVendor;
    public static String javaVersion;
    private static long killtime;
    private static volatile long lastCanvasReplace;
    public static int lastFullscreenHeight;
    public static int lastFullscreenWidth;
    public static int leftMargin;
    public static String loadingTitle;
    private static final Logger logger;
    private static int logicRate;
    private static long logicUpdateInterval;
    public static double lps;
    public static Im133 masterIndex;
    public static int maxmemory;
    public static Dv322 mouseImp;
    public static String osArchRaw;
    public static String osName;
    public static String osNameRaw;
    public static String osVersionRaw;
    public static Image percentbuf;
    protected static float physicsRate;
    protected static long physicsUpdateInterval;
    public static double pps;
    public static int renderFrameCount;
    private static boolean shutdown;
    public static int topMargin;
    private static Im133 uidDat;
    static final boolean usedirectx = true;
    private static final boolean usefullscreen = true;
    static final boolean usejaclib = true;
    static final boolean usenativelib = true;
    static final boolean useopengl = true;
    static final boolean usesw3d = true;
    static final boolean usetheora = true;
    public boolean alreadyerrored;
    final double dfOneOverNanosPerSecond = 1.0E-9;
    public boolean jaclibloaded;
    
    public static void pushUID192(final Gg3 gg3) {
        final byte[] array = new byte[24];
        try {
            GameShell3.uidDat.d(0L);
            Im133.e(GameShell3.uidDat, array);
            int n;
            for (n = 0; n < 24 && array[n] == 0; ++n) {}
            if (n >= 24) {
                throw new IOException();
            }
        }
        catch (Exception ex) {
            for (int i = 0; i < 24; ++i) {
                array[i] = -1;
            }
        }
        Gg3.aa(gg3, array, 0, 24);
    }
    
    private final void shutdown(final boolean b) {
        synchronized (this) {
            if (GameShell3.shutdown) {
                return;
            }
            GameShell3.shutdown = true;
        }
        GameShell3.logger.debug("Shutdown start - clean:{}", b);
        try {
            this.mainquit();
        }
        catch (Exception ex) {
            GameShell3.logger.error("", ex);
        }
        try {
            Im133.g(GameShell3.cacheDat);
            for (int i = 0; i < GameShell3.archiveCount; ++i) {
                Im133.g(GameShell3.cacheIndex[i]);
            }
            Im133.g(GameShell3.masterIndex);
            Im133.g(GameShell3.uidDat);
        }
        catch (Exception ex3) {}
        this.closeLockFileArtefacts(GameShell3.cacheLockFile, GameShell3.cacheLockChannel, GameShell3.cacheLock);
        GameShell3.cacheLock = null;
        GameShell3.cacheLockChannel = null;
        GameShell3.cacheLockFile = null;
        if (GameShell3.canvas != null) {
            try {
                GameShell3.canvas.removeFocusListener(this);
                GameShell3.canvas.getParent().remove(GameShell3.canvas);
            }
            catch (Exception ex2) {
                GameShell3.logger.error("", ex2);
            }
        }
        if (GameShell3.frame != null) {
            GameShell3.frame.setVisible(false);
            GameShell3.frame.dispose();
            GameShell3.frame = null;
        }
        if (Kt125.q()) {
            Kt125.d().b();
        }
        GameShell3.logger.debug("Shutdown complete - clean:{}", b);
    }
    
    private final void startCommon(final String s, final String s2, final int historicCacheId, final int archiveCount, final boolean b, final int e, final int h) throws Exception {
        GameShell3.archiveCount = archiveCount;
        GameShell3.historicCacheId = historicCacheId;
        Ku323.e = e;
        Ku323.h = h;
        GameShell3.javaVendor = "Unknown";
        GameShell3.javaVersion = "1.1";
        try {
            GameShell3.javaVendor = System.getProperty("java.vendor");
            GameShell3.javaVersion = System.getProperty("java.version");
        }
        catch (Exception ex) {}
        try {
            GameShell3.osNameRaw = System.getProperty("os.name");
        }
        catch (Exception ex2) {
            GameShell3.osNameRaw = "Unknown";
        }
        GameShell3.osName = GameShell3.osNameRaw.toLowerCase();
        try {
            GameShell3.osArchRaw = System.getProperty("os.arch").toLowerCase();
        }
        catch (Exception ex3) {
            GameShell3.osArchRaw = "";
        }
        try {
            GameShell3.osVersionRaw = System.getProperty("os.version").toLowerCase();
        }
        catch (Exception ex4) {
            GameShell3.osVersionRaw = "";
        }
        try {
            GameShell3.homeDir = System.getProperty("user.home");
            if (GameShell3.homeDir != null) {
                GameShell3.homeDir += "/";
            }
        }
        catch (Exception ex5) {}
        if (GameShell3.homeDir == null) {
            GameShell3.homeDir = "~/";
        }
        try {
            GameShell3.eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
        }
        catch (Throwable t) {}
        GameShell3.historicCacheLocations = new String[] { "c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", GameShell3.homeDir, "/tmp/", "" };
        GameShell3.historicCacheDirectories = new String[] { ".jagex_cache_" + GameShell3.historicCacheId, ".file_store_" + GameShell3.historicCacheId };
        for (int i = 0; i < 4; ++i) {
            GameShell3.cacheDirectory = this.getCacheDirectory(s, s2, i);
            if (!GameShell3.cacheDirectory.exists()) {
                GameShell3.cacheDirectory.mkdirs();
            }
            if (this.tryLock(GameShell3.cacheDirectory)) {
                GameShell3.logger.info("using " + GameShell3.cacheDirectory + " as cache");
                break;
            }
            GameShell3.logger.info("can't use " + GameShell3.cacheDirectory + " as cache");
            GameShell3.cacheDirectory = null;
        }
        if (GameShell3.cacheDirectory == null) {
            throw new IllegalStateException("All desired cache directories seemed to be in use!");
        }
        Dh131.g(GameShell3.cacheDirectory);
        openUID();
        if (b) {
            GameShell3.cacheDat = new Im133(new Is139(Dh131.d("main_file_cache.dat2"), "rw", -1L), 5200, 0);
            GameShell3.masterIndex = new Im133(new Is139(Dh131.d("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            GameShell3.cacheIndex = new Im133[GameShell3.archiveCount];
            for (int j = 0; j < GameShell3.archiveCount; ++j) {
                GameShell3.cacheIndex[j] = new Im133(new Is139(Dh131.d("main_file_cache.idx" + j), "rw", 1048576L), 6000, 0);
            }
        }
        GameShell3.fsimp14 = new Hw321();
        GameShell3.mouseImp = new Dv322();
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        for (ThreadGroup threadGroup2 = threadGroup.getParent(); threadGroup2 != null; threadGroup2 = threadGroup.getParent()) {
            threadGroup = threadGroup2;
        }
        final Thread[] list = new Thread[1000];
        threadGroup.enumerate(list);
        for (int k = 0; k < list.length; ++k) {
            if (list[k] != null && list[k].getName().startsWith("AWT")) {
                list[k].setPriority(1);
            }
        }
        Dp208.g(this, GameShell3.osName);
        final Thread thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
        thread.setPriority(1);
    }
    
    private boolean tryLock(final File parent) {
        if (GameShell3.cacheLock != null || GameShell3.cacheLockChannel != null || GameShell3.cacheLockFile != null) {
            throw new IllegalStateException("Looks like we already have a lock on a cache - don't try and take out another one!");
        }
        FileOutputStream cacheLockFile;
        try {
            cacheLockFile = new FileOutputStream(new File(parent, "lock"));
        }
        catch (FileNotFoundException ex) {
            return false;
        }
        final FileChannel channel = cacheLockFile.getChannel();
        try {
            final FileLock tryLock = channel.tryLock();
            if (tryLock != null && tryLock.isValid()) {
                GameShell3.cacheLock = tryLock;
                GameShell3.cacheLockChannel = channel;
                GameShell3.cacheLockFile = cacheLockFile;
                return true;
            }
            this.closeLockFileArtefacts(cacheLockFile, channel, null);
            return false;
        }
        catch (IOException ex2) {
            this.closeLockFileArtefacts(cacheLockFile, channel, null);
            return false;
        }
    }
    
    private void closeLockFileArtefacts(final FileOutputStream fileOutputStream, final FileChannel fileChannel, final FileLock fileLock) {
        if (fileLock != null) {
            try {
                fileLock.release();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            fileChannel.close();
        }
        catch (IOException ex2) {
            ex2.printStackTrace();
        }
        try {
            fileOutputStream.close();
        }
        catch (IOException ex3) {
            ex3.printStackTrace();
        }
    }
    
    private File getCacheDirectory(final String str, final String s, final int i) {
        final String s2 = (i == 0) ? "" : ("" + i);
        GameShell3.cacheLocator = new File(GameShell3.homeDir, "jagex_cl_" + str + "_" + s + s2 + ".dat");
        String pathname = null;
        String bh = null;
        boolean b = false;
        if (GameShell3.cacheLocator.exists()) {
            try {
                final Is139 is139 = new Is139(GameShell3.cacheLocator, "rw", 10000L);
                final Gg3 gg3 = new Gg3((int)Is139.e(is139));
                while (gg3.v < gg3.r.length) {
                    final int h = Is139.h(is139, gg3.r, gg3.v, gg3.r.length - gg3.v);
                    if (h == -1) {
                        throw new IOException();
                    }
                    final Gg3 gg4 = gg3;
                    gg4.v += h;
                }
                gg3.v = 0;
                final int ar = Gg3.ar(gg3);
                if (ar < 1 || ar > 2) {
                    throw new IOException("" + ar);
                }
                int ar2 = 0;
                if (ar > 1) {
                    ar2 = Gg3.ar(gg3);
                }
                pathname = gg3.bh();
                if (ar2 == 1) {
                    bh = gg3.bh();
                }
                Is139.j(is139);
                GameShell3.logger.debug("Cache: Read cache locator file from: {}, state: {}", GameShell3.cacheLocator, ar2);
            }
            catch (IOException ex) {
                GameShell3.logger.error("Cache: Error opening cache locator file.", ex);
            }
            if (pathname != null && !new File(pathname).exists()) {
                GameShell3.logger.debug("Cache: Cache locator location does not exist: {}", pathname);
                pathname = null;
            }
            if (pathname != null && !this.checkWritable(new File(pathname, "test.dat"), true)) {
                GameShell3.logger.debug("Cache: Cache locator location not writable: {}", pathname);
                pathname = null;
            }
        }
        Label_0574: {
            if (pathname == null && i == 0) {
                for (int j = 0; j < GameShell3.historicCacheDirectories.length; ++j) {
                    for (int k = 0; k < GameShell3.historicCacheLocations.length; ++k) {
                        final File parent = new File(GameShell3.historicCacheLocations[k] + GameShell3.historicCacheDirectories[j] + File.separatorChar + str + File.separatorChar);
                        if (parent.exists() && this.checkWritable(new File(parent, "test.dat"), true)) {
                            pathname = parent.toString();
                            b = true;
                            GameShell3.logger.debug("Cache: Legacy cache found: {}", pathname);
                            break Label_0574;
                        }
                    }
                }
            }
        }
        if (pathname == null) {
            GameShell3.logger.debug("Cache: No previous cache found, using default.");
            pathname = GameShell3.homeDir + File.separatorChar + "jagexcache" + s2 + File.separatorChar + str + File.separatorChar + s + File.separatorChar;
            b = true;
        }
        if (bh != null) {
            GameShell3.logger.debug("Cache: Copying cache from old location: {}", bh);
            final File file = new File(bh);
            final File parent2 = new File(pathname);
            try {
                for (final File file2 : file.listFiles()) {
                    final File dest = new File(parent2, file2.getName());
                    GameShell3.logger.debug("Cache: Copying old file: {} to {}", file2, dest);
                    if (!file2.renameTo(dest)) {
                        throw new IOException();
                    }
                }
            }
            catch (Exception ex2) {
                GameShell3.logger.error("Cache: Error when copying cache from old location.", ex2);
            }
            b = true;
        }
        if (b) {
            this.writeCacheLocator(new File(pathname), null);
        }
        GameShell3.logger.debug("Cache: Using cache at: {}", pathname);
        return new File(pathname);
    }
    
    private void writeCacheLocator(final File file, final File file2) {
        try {
            GameShell3.logger.debug("Cache: Writing cache locator file with new location: {} old location: {}", file, (file2 == null) ? "N/A" : file2);
            final Is139 is139 = new Is139(GameShell3.cacheLocator, "rw", 10000L);
            final Gg3 gg3 = new Gg3(500);
            Gg3.k(gg3, 2);
            Gg3.k(gg3, (file2 != null) ? 1 : 0);
            gg3.ap(file.getPath());
            if (file2 != null) {
                gg3.ap(file2.getPath());
            }
            is139.q(gg3.r, 0, gg3.v);
            Is139.j(is139);
        }
        catch (IOException ex) {
            GameShell3.logger.error("Cache: Error writing cache locator file.", ex);
        }
    }
    
    private boolean checkWritable(final File file, final boolean b) {
        try {
            final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            final int read = randomAccessFile.read();
            randomAccessFile.seek(0L);
            randomAccessFile.write(read);
            randomAccessFile.seek(0L);
            randomAccessFile.close();
            if (b) {
                file.delete();
            }
            return true;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    public static File getCacheLocation() {
        return GameShell3.cacheDirectory;
    }
    
    public static Is139 openPrefs(final String s, final String str, final boolean b) {
        final File file = new File(GameShell3.cacheDirectory, "preferences" + s + ".dat");
        if (file.exists()) {
            try {
                final Is139 is139 = new Is139(file, "rw", 10000L);
                GameShell3.logger.debug("Prefs: Opening existing prefs {} in modern location: {}", s, file);
                return is139;
            }
            catch (IOException ex) {}
        }
        String str2 = "";
        if (GameShell3.historicCacheId == 33) {
            str2 = "_rc";
        }
        else if (GameShell3.historicCacheId == 34) {
            str2 = "_wip";
        }
        final File file2 = new File(GameShell3.homeDir, "jagex_" + str + "_preferences" + s + str2 + ".dat");
        if (!b && file2.exists()) {
            try {
                final Is139 is140 = new Is139(file2, "rw", 10000L);
                GameShell3.logger.debug("Prefs: Opening existing prefs {} in historic location: {}", s, file2);
                return is140;
            }
            catch (IOException ex2) {}
        }
        try {
            final Is139 is141 = new Is139(file, "rw", 10000L);
            GameShell3.logger.debug("Prefs: Opening new prefs {} in modern location: {}", s, file);
            return is141;
        }
        catch (IOException ex3) {
            throw new RuntimeException();
        }
    }
    
    private static void openUID() {
        try {
            final File file = new File(GameShell3.homeDir, "random.dat");
            Label_0186: {
                if (file.exists()) {
                    GameShell3.uidDat = new Im133(new Is139(file, "rw", 25L), 24, 0);
                    GameShell3.logger.debug("UID: Opening UID in user's home directory: {}", file);
                }
                else {
                    for (int i = 0; i < GameShell3.historicCacheDirectories.length; ++i) {
                        for (int j = 0; j < GameShell3.historicCacheLocations.length; ++j) {
                            final File file2 = new File(GameShell3.historicCacheLocations[j] + GameShell3.historicCacheDirectories[i] + File.separatorChar + "random.dat");
                            if (file2.exists()) {
                                GameShell3.logger.debug("UID: Opening UID in historic directory: {}", file2);
                                GameShell3.uidDat = new Im133(new Is139(file2, "rw", 25L), 24, 0);
                                break Label_0186;
                            }
                        }
                    }
                }
            }
            if (GameShell3.uidDat == null) {
                GameShell3.logger.debug("UID: Couldn't find existing UID, creating new one in user's home directory: {}", file);
                final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                final int read = randomAccessFile.read();
                randomAccessFile.seek(0L);
                randomAccessFile.write(read);
                randomAccessFile.seek(0L);
                randomAccessFile.close();
                GameShell3.uidDat = new Im133(new Is139(file, "rw", 25L), 24, 0);
            }
        }
        catch (IOException ex) {
            GameShell3.logger.error("Error opening random.dat", ex);
        }
    }
    
    @Override
    public final void windowDeactivated(final WindowEvent windowEvent) {
    }
    
    public void error(final String str) {
        if (this.alreadyerrored) {
            return;
        }
        this.alreadyerrored = true;
        GameShell3.logger.debug("error_game_{}", str);
        try {
            Mu209.g(this, "loggedout");
        }
        catch (Throwable t) {}
        try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + str + ".ws"), "_top");
        }
        catch (Exception ex) {
            GameShell3.logger.error("", ex);
        }
    }
    
    private synchronized void createAndShowFrame(final String title) {
        (GameShell3.frame = new Frame()).setTitle(title);
        GameShell3.frame.setResizable(true);
        GameShell3.frame.addWindowListener(this);
        GameShell3.frame.setBackground(Color.black);
        GameShell3.frame.setVisible(true);
        GameShell3.frame.toFront();
        final Insets insets = GameShell3.frame.getInsets();
        GameShell3.frame.setSize(GameShell3.frameWid + insets.left + insets.right, GameShell3.frameHei + insets.top + insets.bottom);
    }
    
    public abstract void cycleend(final boolean p0);
    
    public Container getTopContainer() {
        if (GameShell3.fsframe != null) {
            return GameShell3.fsframe;
        }
        if (GameShell3.frame != null) {
            return GameShell3.frame;
        }
        return this;
    }
    
    public void addCanvas(final Container container) {
        container.setBackground(Color.black);
        container.setLayout(null);
        container.add(GameShell3.canvas);
        GameShell3.canvas.setSize(GameShell3.canvasWid, GameShell3.canvasHei);
        GameShell3.canvas.setVisible(true);
        if (container == GameShell3.frame) {
            final Insets insets = GameShell3.frame.getInsets();
            GameShell3.canvas.setLocation(insets.left + GameShell3.leftMargin, insets.top + GameShell3.topMargin);
        }
        else {
            GameShell3.canvas.setLocation(GameShell3.leftMargin, GameShell3.topMargin);
        }
        GameShell3.canvas.addFocusListener(this);
        GameShell3.canvas.requestFocus();
        GameShell3.focus = true;
        GameShell3.focus_in = true;
        GameShell3.canvas.setFocusTraversalKeysEnabled(false);
        GameShell3.fullredraw = true;
        GameShell3.canvasReplaceRecommended = false;
        GameShell3.lastCanvasReplace = Gz143.g();
    }
    
    public synchronized void addcanvas() {
        this.removeCanvas();
        final Container topContainer = this.getTopContainer();
        GameShell3.canvas = new Dq324(topContainer);
        this.addCanvas(topContainer);
    }
    
    public final boolean checkhost() {
        String s = this.getDocumentBase().getHost().toLowerCase();
        if (s.equals("jagex.com") || s.endsWith(".jagex.com")) {
            return true;
        }
        if (s.equals("runescape.com") || s.endsWith(".runescape.com")) {
            return true;
        }
        if (s.equals("stellardawn.com") || s.endsWith(".stellardawn.com")) {
            return true;
        }
        if (s.equals("transformersuniverse.com") || s.endsWith(".transformersuniverse.com")) {
            return true;
        }
        if (s.equals("funorb.com") || s.endsWith(".funorb.com")) {
            return true;
        }
        if (s.equals("8realms.com") || s.endsWith(".8realms.com")) {
            return true;
        }
        if (s.endsWith("127.0.0.1")) {
            return true;
        }
        while (s.length() > 0 && s.charAt(s.length() - 1) >= '0' && s.charAt(s.length() - 1) <= '9') {
            s = s.substring(0, s.length() - 1);
        }
        if (s.endsWith("192.168.1.")) {
            return true;
        }
        this.error("invalidhost");
        return false;
    }
    
    @Override
    public void run() {
        GameShell3.logger.debug("run");
        this.run_inner();
        this.shutdown(true);
    }
    
    private void run_inner() {
        GameShell3.logger.debug("run_inner");
        if (GameShell3.javaVendor != null) {
            final String lowerCase = GameShell3.javaVendor.toLowerCase();
            if (lowerCase.indexOf("apple") != -1) {
                this.error("wrongjava");
                return;
            }
            if (lowerCase.indexOf("sun") != -1) {
                final String javaVersion = GameShell3.javaVersion;
                if (javaVersion.equals("1.1") || javaVersion.startsWith("1.1.") || javaVersion.equals("1.2") || javaVersion.startsWith("1.2.") || javaVersion.equals("1.3") || javaVersion.startsWith("1.3.") || javaVersion.equals("1.4") || javaVersion.startsWith("1.4.") || javaVersion.equals("1.5") || javaVersion.startsWith("1.5.") || javaVersion.equals("1.6.0")) {
                    this.error("wrongjava");
                    return;
                }
                if (javaVersion.startsWith("1.6.0_")) {
                    int n;
                    for (n = 6; n < javaVersion.length() && StringTools.w(javaVersion.charAt(n)); ++n) {}
                    final String substring = javaVersion.substring(6, n);
                    if (StringTools.d(substring) && StringTools.j(substring) < 10) {
                        this.error("wrongjava");
                        return;
                    }
                }
            }
        }
        GameShell3.logger.info("Perform DirectX and VS2010 runtime checks");
        if (!SystemRequirementsCheck.performAllChecks()) {
            GameShell3.logger.error("Could not load dlls redirecting user to error page");
            if (!SystemRequirementsCheck.getLoadedDirectX()) {
                this.error("wrongdirectx");
            }
            else {
                this.error("wrongvsredist");
            }
            return;
        }
        Z132.g("GameShell.run_inner()");
        this.setFocusCycleRoot(true);
        GameShell3.maxmemory = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
        GameShell3.cpucount = Runtime.getRuntime().availableProcessors();
        this.addcanvas();
        GameShell3.logger.debug("maininit");
        this.maininit();
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        long physicsUpdateInterval = GameShell3.physicsUpdateInterval;
        long logicUpdateInterval = GameShell3.logicUpdateInterval;
        long n5 = 0L;
        long nanoTime = System.nanoTime();
        this.cycleend(true);
        GameShell3.logger.debug("mainloop");
        while (GameShell3.killtime == 0L || Gz143.g() < GameShell3.killtime) {
            this.cyclestart(false);
            try {
                final long nanoTime2 = System.nanoTime();
                final long n6 = nanoTime2 - nanoTime;
                logicUpdateInterval += n6;
                physicsUpdateInterval += n6;
                n5 += n6;
                long n7 = 0L;
                final float n8 = (float)(n6 * 1.0E-9);
                while (physicsUpdateInterval > GameShell3.physicsUpdateInterval) {
                    final float n9 = (float)(GameShell3.physicsUpdateInterval * 1.0E-9);
                    this.mainphysicswrapper();
                    physicsUpdateInterval -= GameShell3.physicsUpdateInterval;
                    ++n4;
                }
                while (logicUpdateInterval > GameShell3.logicUpdateInterval) {
                    this.mainloopwrapper((float)(GameShell3.logicUpdateInterval * 1.0E-9));
                    logicUpdateInterval -= GameShell3.logicUpdateInterval;
                    Ap127.h = ++n3;
                    ++n7;
                }
                this.mainredrawwrapper();
                ++n2;
                ++GameShell3.renderFrameCount;
                if (n5 > 1000000000L) {
                    GameShell3.lps = n3 / (n5 * 1.0E-9);
                    GameShell3.pps = n4 / (n5 * 1.0E-9);
                    GameShell3.fps = n2 / (n5 * 1.0E-9);
                    if (GameShell3.PauseCountFPS == 0.0) {
                        GameShell3.fpsTotal += GameShell3.fps;
                        ++GameShell3.fpsCount;
                        if (GameShell3.fpsCount > 0.0) {
                            GameShell3.fpsAverage = GameShell3.fpsTotal / GameShell3.fpsCount;
                        }
                        if (GameShell3.fps > GameShell3.fpsH) {
                            GameShell3.fpsH = GameShell3.fps;
                            if (GameShell3.fps > 999.0) {
                                GameShell3.fpsH = 999.0;
                            }
                        }
                        if (GameShell3.fps < GameShell3.fpsL) {
                            GameShell3.fpsL = GameShell3.fps;
                        }
                    }
                    n5 = 0L;
                    n3 = 0;
                    n4 = 0;
                    n2 = 0;
                }
                nanoTime = nanoTime2;
            }
            finally {
                this.cycleend(false);
            }
        }
    }
    
    public static final void setspeed(final int logicRate) {
        GameShell3.logicRate = logicRate;
        GameShell3.logicUpdateInterval = 1000000000L / GameShell3.logicRate;
    }
    
    public static final float getPhysicsSpeed() {
        return GameShell3.physicsRate;
    }
    
    public abstract void cyclestart(final boolean p0);
    
    private void mainloopwrapper(final float n) {
        synchronized (this) {
            GameShell3.focus = GameShell3.focus_in;
        }
        this.mainloop(n);
    }
    
    public static final void setPhysicsSpeed(final float physicsRate) {
        GameShell3.physicsRate = physicsRate;
        GameShell3.physicsUpdateInterval = (long)(1.0E9f / GameShell3.physicsRate);
    }
    
    public static final int getspeed() {
        return GameShell3.logicRate;
    }
    
    public boolean load_jagtheora() {
        return Kt125.d().h("jagtheora");
    }
    
    private void mainphysicswrapper() {
        this.mainphysics();
    }
    
    public static void storeUID192(final Gg3 gg3, final int n) {
        if (GameShell3.uidDat != null) {
            try {
                GameShell3.uidDat.d(0L);
                Im133.b(GameShell3.uidDat, gg3.r, n, 24);
            }
            catch (Exception ex) {}
        }
    }
    
    @Override
    public void stop() {
        if (GameShell3.shutdown) {
            return;
        }
        GameShell3.killtime = Gz143.g() + 4000L;
    }
    
    @Override
    public void destroy() {
        if (GameShell3.shutdown) {
            return;
        }
        GameShell3.killtime = Gz143.g();
    }
    
    public GameShell3() {
        this.alreadyerrored = false;
        this.jaclibloaded = false;
    }
    
    @Override
    public final synchronized void paint(final Graphics graphics) {
        if (GameShell3.shutdown) {
            return;
        }
        GameShell3.fullredraw = true;
        if (Gz143.g() - GameShell3.lastCanvasReplace > 1000L) {
            final Rectangle clipBounds = graphics.getClipBounds();
            if (clipBounds == null || (clipBounds.width >= GameShell3.frameWid && clipBounds.height >= GameShell3.frameHei)) {
                GameShell3.canvasReplaceRecommended = true;
            }
        }
    }
    
    @Override
    public final void focusGained(final FocusEvent focusEvent) {
        GameShell3.focus_in = true;
        GameShell3.fullredraw = true;
    }
    
    @Override
    public final void windowClosed(final WindowEvent windowEvent) {
    }
    
    public final void startApplication(final int n, final int n2, final String s, final String s2, final int n3, final int n4, final boolean b, final int n5, final int n6) {
        try {
            this.setEnvironment(GameShell3$Environment.APPLICATION, false);
            GameShell3.canvasWid = n;
            GameShell3.frameWid = n;
            GameShell3.canvasHei = n2;
            GameShell3.frameHei = n2;
            GameShell3.leftMargin = 0;
            GameShell3.topMargin = 0;
            this.createAndShowFrame("Jagex");
            Ku323.s = null;
            this.startCommon(s, s2, n3, n4, b, n5, n6);
        }
        catch (Exception ex) {
            GameShell3.logger.error("", ex);
            Ku323.g(null, ex);
        }
    }
    
    @Override
    public final void windowDeiconified(final WindowEvent windowEvent) {
    }
    
    @Override
    public final void windowClosing(final WindowEvent windowEvent) {
        this.destroy();
    }
    
    public final void startApplet(final GameShell3$FrameParameters gameShell3$FrameParameters, final String s, final String s2, final int n, final int n2, final boolean b, final int n3, final int n4, final boolean b2) {
        try {
            this.setEnvironment(GameShell3$Environment.APPLET, b2);
            GameShell3.frameWid = (GameShell3.canvasWid = gameShell3$FrameParameters.getWidth());
            GameShell3.frameHei = (GameShell3.canvasHei = gameShell3$FrameParameters.getHeight());
            GameShell3.leftMargin = 0;
            GameShell3.topMargin = 0;
            if (getEnvironment() == GameShell3$Environment.APPLET_WITH_EXTERNAL_FRAME) {
                GameShell3.frameWid += 2 * gameShell3$FrameParameters.getXMargin();
                GameShell3.frameHei += 2 * gameShell3$FrameParameters.getYMargin();
                this.createAndShowFrame(gameShell3$FrameParameters.getTitle());
            }
            ((GameShell3)(Ku323.s = this)).startCommon(s, s2, n, n2, b, n3, n4);
        }
        catch (Throwable t) {
            GameShell3.logger.error("", t);
            Ku323.g(null, t);
            this.error("crash");
        }
    }
    
    @Override
    public final void windowIconified(final WindowEvent windowEvent) {
    }
    
    @Override
    public final void windowOpened(final WindowEvent windowEvent) {
    }
    
    @Override
    public abstract void init();
    
    public abstract void maininit();
    
    public abstract void mainquit();
    
    @Override
    public final void update(final Graphics graphics) {
        this.paint(graphics);
    }
    
    public abstract void mainloop(final float p0);
    
    public abstract void mainphysics();
    
    public abstract void mainredraw();
    
    @Override
    public final void focusLost(final FocusEvent focusEvent) {
        GameShell3.focus_in = false;
    }
    
    @Override
    public String getParameter(final String name) {
        if (getEnvironment() == GameShell3$Environment.APPLICATION) {
            return null;
        }
        return super.getParameter(name);
    }
    
    @Override
    public final void windowActivated(final WindowEvent windowEvent) {
    }
    
    @Override
    public URL getDocumentBase() {
        if (getEnvironment() == GameShell3$Environment.APPLICATION) {
            return null;
        }
        return super.getDocumentBase();
    }
    
    private void mainredrawwrapper() {
        this.mainredraw();
    }
    
    @Override
    public URL getCodeBase() {
        if (getEnvironment() == GameShell3$Environment.APPLICATION) {
            return null;
        }
        return super.getCodeBase();
    }
    
    private void setEnvironment(final GameShell3$Environment environment, final boolean b) {
        if (environment == null) {
            throw new NullPointerException();
        }
        if (environment != GameShell3$Environment.APPLET && environment != GameShell3$Environment.APPLICATION) {
            throw new IllegalStateException();
        }
        GameShell3.environment = environment;
        if (GameShell3.environment == GameShell3$Environment.APPLICATION) {
            return;
        }
        if (b) {
            GameShell3.environment = GameShell3$Environment.APPLET_WITH_EXTERNAL_FRAME;
        }
    }
    
    public static GameShell3$Environment getEnvironment() {
        return GameShell3.environment;
    }
    
    public static final void doneslowupdate() {
    }
    
    public void removeCanvas() {
        if (GameShell3.canvas != null) {
            GameShell3.canvas.removeFocusListener(this);
            GameShell3.canvas.getParent().setBackground(Color.black);
            GameShell3.canvas.getParent().remove(GameShell3.canvas);
        }
    }
    
    @Override
    public void start() {
        if (GameShell3.shutdown) {
            return;
        }
        GameShell3.killtime = 0L;
    }
    
    static {
        logger = LoggerFactory.getLogger(GameShell3.class);
        GameShell3.fps = 0.0;
        GameShell3.fpsL = 999999.0;
        GameShell3.fpsH = 0.0;
        GameShell3.lps = 0.0;
        GameShell3.pps = 0.0;
        GameShell3.fpsAverage = 0.0;
        GameShell3.fpsCount = 0.0;
        GameShell3.fpsTotal = 0.0;
        GameShell3.logicRate = 50;
        GameShell3.logicUpdateInterval = 20000000L;
        GameShell3.physicsRate = 20.0f;
        GameShell3.physicsUpdateInterval = 50000000L;
        GameShell3.PauseCountFPS = 0.0;
        GameShell3.leftMargin = 0;
        GameShell3.topMargin = 0;
        GameShell3.loadingTitle = null;
        GameShell3.fullredraw = true;
        GameShell3.fullRedrawForce = 500;
        GameShell3.canvasReplaceRecommended = false;
        GameShell3.lastCanvasReplace = 0L;
        GameShell3.renderFrameCount = 0;
        GameShell3.focus_in = true;
        GameShell3.uidDat = null;
        GameShell3.cacheDat = null;
        GameShell3.masterIndex = null;
        GameShell3.environment = null;
        GameShell3.killtime = 0L;
        GameShell3.shutdown = false;
        GameShell3.maxmemory = -1;
        GameShell3.cpucount = 1;
    }
    
    @Override
    public AppletContext getAppletContext() {
        if (getEnvironment() == GameShell3$Environment.APPLICATION) {
            return null;
        }
        return super.getAppletContext();
    }
}
