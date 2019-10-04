/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.game.runetek6.client;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.game.runetek6.client.GameShell3$Environment;
import com.jagex.game.runetek6.client.GameShell3$FrameParameters;
import com.jagex.game.runetek6.client.SystemRequirementsCheck;
import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Ap127;
import tfu.Dh131;
import tfu.Dp208;
import tfu.Dq324;
import tfu.Dv322;
import tfu.Gg3;
import tfu.Gz143;
import tfu.Hw321;
import tfu.Im133;
import tfu.Is139;
import tfu.Kt125;
import tfu.Ku323;
import tfu.Mu209;

public abstract class GameShell3
extends Applet
implements Runnable,
FocusListener,
WindowListener {
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
    public boolean alreadyerrored = false;
    final double dfOneOverNanosPerSecond = 1.0E-9;
    public boolean jaclibloaded = false;

    public static void pushUID192(Gg3 gg3) {
        byte[] arrby = new byte[24];
        try {
            int n;
            uidDat.d(0L);
            Im133.e(uidDat, arrby);
            for (n = 0; n < 24 && arrby[n] == 0; ++n) {
            }
            if (n >= 24) {
                throw new IOException();
            }
        }
        catch (Exception exception) {
            for (int i = 0; i < 24; ++i) {
                arrby[i] = -1;
            }
        }
        Gg3.aa(gg3, arrby, 0, 24);
    }

    private final void shutdown(boolean bl) {
        GameShell3 gameShell3 = this;
        synchronized (gameShell3) {
            if (shutdown) {
                return;
            }
            shutdown = true;
        }
        logger.debug("Shutdown start - clean:{}", bl);
        try {
            this.mainquit();
        }
        catch (Exception exception) {
            logger.error("", exception);
        }
        try {
            Im133.g(cacheDat);
            for (int i = 0; i < archiveCount; ++i) {
                Im133.g(cacheIndex[i]);
            }
            Im133.g(masterIndex);
            Im133.g(uidDat);
        }
        catch (Exception exception) {
            // empty catch block
        }
        this.closeLockFileArtefacts(cacheLockFile, cacheLockChannel, cacheLock);
        cacheLock = null;
        cacheLockChannel = null;
        cacheLockFile = null;
        if (canvas != null) {
            try {
                canvas.removeFocusListener(this);
                canvas.getParent().remove(canvas);
            }
            catch (Exception exception) {
                logger.error("", exception);
            }
        }
        if (frame != null) {
            frame.setVisible(false);
            frame.dispose();
            frame = null;
        }
        if (Kt125.q()) {
            Kt125.d().b();
        }
        logger.debug("Shutdown complete - clean:{}", bl);
    }

    private final void startCommon(String string, String string2, int n, int n2, boolean bl, int n3, int n4) throws Exception {
        int n5;
        archiveCount = n2;
        historicCacheId = n;
        Ku323.e = n3;
        Ku323.h = n4;
        javaVendor = "Unknown";
        javaVersion = "1.1";
        try {
            javaVendor = System.getProperty("java.vendor");
            javaVersion = System.getProperty("java.version");
        }
        catch (Exception exception) {
            // empty catch block
        }
        try {
            osNameRaw = System.getProperty("os.name");
        }
        catch (Exception exception) {
            osNameRaw = "Unknown";
        }
        osName = osNameRaw.toLowerCase();
        try {
            osArchRaw = System.getProperty("os.arch").toLowerCase();
        }
        catch (Exception exception) {
            osArchRaw = "";
        }
        try {
            osVersionRaw = System.getProperty("os.version").toLowerCase();
        }
        catch (Exception exception) {
            osVersionRaw = "";
        }
        try {
            homeDir = System.getProperty("user.home");
            if (homeDir != null) {
                homeDir = homeDir + "/";
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        if (homeDir == null) {
            homeDir = "~/";
        }
        try {
            eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        historicCacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", homeDir, "/tmp/", ""};
        historicCacheDirectories = new String[]{".jagex_cache_" + historicCacheId, ".file_store_" + historicCacheId};
        for (n5 = 0; n5 < 4; ++n5) {
            cacheDirectory = this.getCacheDirectory(string, string2, n5);
            if (!cacheDirectory.exists()) {
                cacheDirectory.mkdirs();
            }
            if (this.tryLock(cacheDirectory)) {
                logger.info("using " + cacheDirectory + " as cache");
                break;
            }
            logger.info("can't use " + cacheDirectory + " as cache");
            cacheDirectory = null;
        }
        if (cacheDirectory == null) {
            throw new IllegalStateException("All desired cache directories seemed to be in use!");
        }
        Dh131.g(cacheDirectory);
        GameShell3.openUID();
        if (bl) {
            cacheDat = new Im133(new Is139(Dh131.d(cacheDatFilename), FILE_ACCESS_PERMISSIONS, -1L), 5200, 0);
            masterIndex = new Im133(new Is139(Dh131.d(cacheMasterIndexFilename), FILE_ACCESS_PERMISSIONS, 0x100000L), 6000, 0);
            cacheIndex = new Im133[archiveCount];
            for (n5 = 0; n5 < archiveCount; ++n5) {
                GameShell3.cacheIndex[n5] = new Im133(new Is139(Dh131.d(cacheIndexFilename + n5), FILE_ACCESS_PERMISSIONS, 0x100000L), 6000, 0);
            }
        }
        fsimp14 = new Hw321();
        mouseImp = new Dv322();
        Object object = Thread.currentThread().getThreadGroup();
        ThreadGroup threadGroup = ((ThreadGroup)object).getParent();
        while (threadGroup != null) {
            object = threadGroup;
            threadGroup = ((ThreadGroup)object).getParent();
        }
        Thread[] arrthread = new Thread[1000];
        ((ThreadGroup)object).enumerate(arrthread);
        for (int i = 0; i < arrthread.length; ++i) {
            if (arrthread[i] == null || !arrthread[i].getName().startsWith("AWT")) continue;
            arrthread[i].setPriority(1);
        }
        Dp208.g(this, osName);
        object = new Thread(this);
        ((Thread)object).setDaemon(true);
        ((Thread)object).start();
        ((Thread)object).setPriority(1);
    }

    private boolean tryLock(File file) {
        if (cacheLock != null || cacheLockChannel != null || cacheLockFile != null) {
            throw new IllegalStateException("Looks like we already have a lock on a cache - don't try and take out another one!");
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(file, "lock"));
        }
        catch (FileNotFoundException fileNotFoundException) {
            return false;
        }
        FileChannel fileChannel = fileOutputStream.getChannel();
        FileLock fileLock = null;
        try {
            fileLock = fileChannel.tryLock();
            if (fileLock != null && fileLock.isValid()) {
                cacheLock = fileLock;
                cacheLockChannel = fileChannel;
                cacheLockFile = fileOutputStream;
                return true;
            }
            this.closeLockFileArtefacts(fileOutputStream, fileChannel, null);
            return false;
        }
        catch (IOException iOException) {
            this.closeLockFileArtefacts(fileOutputStream, fileChannel, null);
            return false;
        }
    }

    private void closeLockFileArtefacts(FileOutputStream fileOutputStream, FileChannel fileChannel, FileLock fileLock) {
        if (fileLock != null) {
            try {
                fileLock.release();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
        try {
            fileChannel.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        try {
            fileOutputStream.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private File getCacheDirectory(String string, String string2, int n) {
        Object object;
        Object object2;
        String string3 = n == 0 ? "" : "" + n;
        cacheLocator = new File(homeDir, "jagex_cl_" + string + "_" + string2 + string3 + ".dat");
        String string4 = null;
        String string5 = null;
        boolean bl = false;
        if (cacheLocator.exists()) {
            try {
                int n2;
                object2 = new Is139(cacheLocator, FILE_ACCESS_PERMISSIONS, 10000L);
                object = new Gg3((int)Is139.e((Is139)object2));
                while (((Gg3)object).v < ((Gg3)object).r.length) {
                    n2 = Is139.h((Is139)object2, ((Gg3)object).r, ((Gg3)object).v, ((Gg3)object).r.length - ((Gg3)object).v);
                    if (n2 == -1) {
                        throw new IOException();
                    }
                    ((Gg3)object).v += n2;
                }
                ((Gg3)object).v = 0;
                n2 = Gg3.ar((Gg3)object);
                if (n2 < 1 || n2 > 2) {
                    throw new IOException("" + n2);
                }
                int n3 = 0;
                if (n2 > 1) {
                    n3 = Gg3.ar((Gg3)object);
                }
                string4 = ((Gg3)object).bh();
                if (n3 == 1) {
                    string5 = ((Gg3)object).bh();
                }
                Is139.j((Is139)object2);
                logger.debug("Cache: Read cache locator file from: {}, state: {}", cacheLocator, (Object)n3);
            }
            catch (IOException iOException) {
                logger.error("Cache: Error opening cache locator file.", iOException);
            }
            if (string4 != null && !((File)(object = new File(string4))).exists()) {
                logger.debug("Cache: Cache locator location does not exist: {}", string4);
                string4 = null;
            }
            if (string4 != null && !this.checkWritable((File)(object = new File(string4, "test.dat")), true)) {
                logger.debug("Cache: Cache locator location not writable: {}", string4);
                string4 = null;
            }
        }
        if (string4 == null && n == 0) {
            block5 : for (int i = 0; i < historicCacheDirectories.length; ++i) {
                for (int j = 0; j < historicCacheLocations.length; ++j) {
                    File file = new File(historicCacheLocations[j] + historicCacheDirectories[i] + File.separatorChar + string + File.separatorChar);
                    if (!file.exists() || !this.checkWritable(new File(file, "test.dat"), true)) continue;
                    string4 = file.toString();
                    bl = true;
                    logger.debug("Cache: Legacy cache found: {}", (Object)string4);
                    break block5;
                }
            }
        }
        if (string4 == null) {
            logger.debug("Cache: No previous cache found, using default.");
            string4 = homeDir + File.separatorChar + "jagexcache" + string3 + File.separatorChar + string + File.separatorChar + string2 + File.separatorChar;
            bl = true;
        }
        if (string5 != null) {
            logger.debug("Cache: Copying cache from old location: {}", string5);
            object2 = new File(string5);
            object = new File(string4);
            try {
                File[] arrfile;
                for (File file : arrfile = ((File)object2).listFiles()) {
                    File file2 = new File((File)object, file.getName());
                    logger.debug("Cache: Copying old file: {} to {}", file, (Object)file2);
                    boolean bl2 = file.renameTo(file2);
                    if (bl2) continue;
                    throw new IOException();
                }
            }
            catch (Exception exception) {
                logger.error("Cache: Error when copying cache from old location.", exception);
            }
            bl = true;
        }
        if (bl) {
            this.writeCacheLocator(new File(string4), null);
        }
        logger.debug("Cache: Using cache at: {}", string4);
        return new File(string4);
    }

    private void writeCacheLocator(File file, File file2) {
        try {
            logger.debug("Cache: Writing cache locator file with new location: {} old location: {}", file, file2 == null ? "N/A" : file2);
            Is139 is139 = new Is139(cacheLocator, FILE_ACCESS_PERMISSIONS, 10000L);
            Gg3 gg3 = new Gg3(500);
            Gg3.k(gg3, 2);
            Gg3.k(gg3, file2 != null ? 1 : 0);
            gg3.ap(file.getPath());
            if (file2 != null) {
                gg3.ap(file2.getPath());
            }
            is139.q(gg3.r, 0, gg3.v);
            Is139.j(is139);
        }
        catch (IOException iOException) {
            logger.error("Cache: Error writing cache locator file.", iOException);
        }
    }

    private boolean checkWritable(File file, boolean bl) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, FILE_ACCESS_PERMISSIONS);
            int n = randomAccessFile.read();
            randomAccessFile.seek(0L);
            randomAccessFile.write(n);
            randomAccessFile.seek(0L);
            randomAccessFile.close();
            if (bl) {
                file.delete();
            }
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public static File getCacheLocation() {
        return cacheDirectory;
    }

    public static Is139 openPrefs(String string, String string2, boolean bl) {
        File file = new File(cacheDirectory, "preferences" + string + ".dat");
        if (file.exists()) {
            try {
                Is139 is139 = new Is139(file, FILE_ACCESS_PERMISSIONS, 10000L);
                logger.debug("Prefs: Opening existing prefs {} in modern location: {}", (Object)string, (Object)file);
                return is139;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        String string3 = "";
        if (historicCacheId == 33) {
            string3 = "_rc";
        } else if (historicCacheId == 34) {
            string3 = "_wip";
        }
        File file2 = new File(homeDir, "jagex_" + string2 + "_preferences" + string + string3 + ".dat");
        if (!bl && file2.exists()) {
            try {
                Is139 is139 = new Is139(file2, FILE_ACCESS_PERMISSIONS, 10000L);
                logger.debug("Prefs: Opening existing prefs {} in historic location: {}", (Object)string, (Object)file2);
                return is139;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        try {
            Is139 is139 = new Is139(file, FILE_ACCESS_PERMISSIONS, 10000L);
            logger.debug("Prefs: Opening new prefs {} in modern location: {}", (Object)string, (Object)file);
            return is139;
        }
        catch (IOException iOException) {
            throw new RuntimeException();
        }
    }

    private static void openUID() {
        try {
            int n;
            File file = new File(homeDir, UIDFileName);
            if (file.exists()) {
                uidDat = new Im133(new Is139(file, FILE_ACCESS_PERMISSIONS, 25L), 24, 0);
                logger.debug("UID: Opening UID in user's home directory: {}", file);
            } else {
                block2 : for (int i = 0; i < historicCacheDirectories.length; ++i) {
                    for (n = 0; n < historicCacheLocations.length; ++n) {
                        File file2 = new File(historicCacheLocations[n] + historicCacheDirectories[i] + File.separatorChar + UIDFileName);
                        if (!file2.exists()) continue;
                        logger.debug("UID: Opening UID in historic directory: {}", file2);
                        uidDat = new Im133(new Is139(file2, FILE_ACCESS_PERMISSIONS, 25L), 24, 0);
                        break block2;
                    }
                }
            }
            if (uidDat == null) {
                logger.debug("UID: Couldn't find existing UID, creating new one in user's home directory: {}", file);
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, FILE_ACCESS_PERMISSIONS);
                n = randomAccessFile.read();
                randomAccessFile.seek(0L);
                randomAccessFile.write(n);
                randomAccessFile.seek(0L);
                randomAccessFile.close();
                uidDat = new Im133(new Is139(file, FILE_ACCESS_PERMISSIONS, 25L), 24, 0);
            }
        }
        catch (IOException iOException) {
            logger.error("Error opening random.dat", iOException);
        }
    }

    @Override
    public final void windowDeactivated(WindowEvent windowEvent) {
    }

    public void error(String string) {
        if (this.alreadyerrored) {
            return;
        }
        this.alreadyerrored = true;
        logger.debug("error_game_{}", (Object)string);
        try {
            Mu209.g(this, "loggedout");
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + string + ".ws"), "_top");
        }
        catch (Exception exception) {
            logger.error("", exception);
        }
    }

    private synchronized void createAndShowFrame(String string) {
        frame = new Frame();
        frame.setTitle(string);
        frame.setResizable(true);
        frame.addWindowListener(this);
        frame.setBackground(Color.black);
        frame.setVisible(true);
        frame.toFront();
        Insets insets = frame.getInsets();
        frame.setSize(frameWid + insets.left + insets.right, frameHei + insets.top + insets.bottom);
    }

    public abstract void cycleend(boolean var1);

    public Container getTopContainer() {
        if (fsframe != null) {
            return fsframe;
        }
        if (frame != null) {
            return frame;
        }
        return this;
    }

    public void addCanvas(Container container) {
        container.setBackground(Color.black);
        container.setLayout(null);
        container.add(canvas);
        canvas.setSize(canvasWid, canvasHei);
        canvas.setVisible(true);
        if (container == frame) {
            Insets insets = frame.getInsets();
            canvas.setLocation(insets.left + leftMargin, insets.top + topMargin);
        } else {
            canvas.setLocation(leftMargin, topMargin);
        }
        canvas.addFocusListener(this);
        canvas.requestFocus();
        focus = true;
        focus_in = true;
        canvas.setFocusTraversalKeysEnabled(false);
        fullredraw = true;
        canvasReplaceRecommended = false;
        lastCanvasReplace = Gz143.g();
    }

    public synchronized void addcanvas() {
        this.removeCanvas();
        Container container = this.getTopContainer();
        canvas = new Dq324(container);
        this.addCanvas(container);
    }

    public final boolean checkhost() {
        String string = this.getDocumentBase().getHost().toLowerCase();
        if (string.equals("jagex.com") || string.endsWith(".jagex.com")) {
            return true;
        }
        if (string.equals("runescape.com") || string.endsWith(".runescape.com")) {
            return true;
        }
        if (string.equals("stellardawn.com") || string.endsWith(".stellardawn.com")) {
            return true;
        }
        if (string.equals("transformersuniverse.com") || string.endsWith(".transformersuniverse.com")) {
            return true;
        }
        if (string.equals("funorb.com") || string.endsWith(".funorb.com")) {
            return true;
        }
        if (string.equals("8realms.com") || string.endsWith(".8realms.com")) {
            return true;
        }
        if (string.endsWith("127.0.0.1")) {
            return true;
        }
        while (string.length() > 0 && string.charAt(string.length() - 1) >= '0' && string.charAt(string.length() - 1) <= '9') {
            string = string.substring(0, string.length() - 1);
        }
        if (string.endsWith("192.168.1.")) {
            return true;
        }
        this.error("invalidhost");
        return false;
    }

    @Override
    public void run() {
        logger.debug("run");
        this.run_inner();
        this.shutdown(true);
    }

    private void run_inner() {
        int n;
        logger.debug("run_inner");
        if (javaVendor != null) {
            String string = javaVendor.toLowerCase();
            if (string.indexOf("apple") != -1) {
                this.error("wrongjava");
                return;
            }
            if (string.indexOf("sun") != -1) {
                String string2 = javaVersion;
                if (string2.equals("1.1") || string2.startsWith("1.1.") || string2.equals("1.2") || string2.startsWith("1.2.") || string2.equals("1.3") || string2.startsWith("1.3.") || string2.equals("1.4") || string2.startsWith("1.4.") || string2.equals("1.5") || string2.startsWith("1.5.") || string2.equals("1.6.0")) {
                    this.error("wrongjava");
                    return;
                }
                if (string2.startsWith("1.6.0_")) {
                    for (n = 6; n < string2.length() && StringTools.w(string2.charAt(n)); ++n) {
                    }
                    String string3 = string2.substring(6, n);
                    if (StringTools.d(string3) && StringTools.j(string3) < 10) {
                        this.error("wrongjava");
                        return;
                    }
                }
            }
        }
        logger.info("Perform DirectX and VS2010 runtime checks");
        if (!SystemRequirementsCheck.performAllChecks()) {
            logger.error("Could not load dlls redirecting user to error page");
            if (!SystemRequirementsCheck.getLoadedDirectX()) {
                this.error("wrongdirectx");
            } else {
                this.error("wrongvsredist");
            }
            return;
        }
        Z132.g("GameShell.run_inner()");
        this.setFocusCycleRoot(true);
        maxmemory = (int)(Runtime.getRuntime().maxMemory() / 0x100000L) + 1;
        cpucount = Runtime.getRuntime().availableProcessors();
        this.addcanvas();
        logger.debug("maininit");
        this.maininit();
        int n2 = 0;
        int n3 = 0;
        n = 0;
        long l = physicsUpdateInterval;
        long l2 = logicUpdateInterval;
        long l3 = 0L;
        long l4 = System.nanoTime();
        this.cycleend(true);
        logger.debug("mainloop");
        while (killtime == 0L || Gz143.g() < killtime) {
            this.cyclestart(false);
            try {
                long l5 = System.nanoTime();
                long l6 = l5 - l4;
                l2 += l6;
                l += l6;
                l3 += l6;
                long l7 = 0L;
                float f = (float)((double)l6 * 1.0E-9);
                while (l > physicsUpdateInterval) {
                    float f2 = (float)((double)physicsUpdateInterval * 1.0E-9);
                    this.mainphysicswrapper();
                    l -= physicsUpdateInterval;
                    ++n;
                }
                while (l2 > logicUpdateInterval) {
                    f = (float)((double)logicUpdateInterval * 1.0E-9);
                    this.mainloopwrapper(f);
                    l2 -= logicUpdateInterval;
                    Ap127.h = ++n3;
                    ++l7;
                }
                this.mainredrawwrapper();
                ++n2;
                ++renderFrameCount;
                if (l3 > 1000000000L) {
                    lps = (double)n3 / ((double)l3 * 1.0E-9);
                    pps = (double)n / ((double)l3 * 1.0E-9);
                    fps = (double)n2 / ((double)l3 * 1.0E-9);
                    if (PauseCountFPS == 0.0) {
                        fpsTotal += fps;
                        if ((fpsCount += 1.0) > 0.0) {
                            fpsAverage = fpsTotal / fpsCount;
                        }
                        if (fps > fpsH) {
                            fpsH = fps;
                            if (fps > 999.0) {
                                fpsH = 999.0;
                            }
                        }
                        if (fps < fpsL) {
                            fpsL = fps;
                        }
                    }
                    l3 = 0L;
                    n3 = 0;
                    n = 0;
                    n2 = 0;
                }
                l4 = l5;
                this.cycleend(false);
            }
            catch (Throwable throwable) {
                this.cycleend(false);
                throw throwable;
            }
        }
    }

    public static final void setspeed(int n) {
        logicRate = n;
        logicUpdateInterval = 1000000000L / (long)logicRate;
    }

    public static final float getPhysicsSpeed() {
        return physicsRate;
    }

    public abstract void cyclestart(boolean var1);

    private void mainloopwrapper(float f) {
        GameShell3 gameShell3 = this;
        synchronized (gameShell3) {
            focus = focus_in;
        }
        this.mainloop(f);
    }

    public static final void setPhysicsSpeed(float f) {
        physicsRate = f;
        physicsUpdateInterval = (long)(1.0E9f / physicsRate);
    }

    public static final int getspeed() {
        return logicRate;
    }

    public boolean load_jagtheora() {
        return Kt125.d().h("jagtheora");
    }

    private void mainphysicswrapper() {
        this.mainphysics();
    }

    public static void storeUID192(Gg3 gg3, int n) {
        if (uidDat != null) {
            try {
                uidDat.d(0L);
                Im133.b(uidDat, gg3.r, n, 24);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    @Override
    public void stop() {
        if (shutdown) {
            return;
        }
        killtime = Gz143.g() + 4000L;
    }

    @Override
    public void destroy() {
        if (shutdown) {
            return;
        }
        killtime = Gz143.g();
    }

    @Override
    public final synchronized void paint(Graphics graphics) {
        Rectangle rectangle;
        if (shutdown) {
            return;
        }
        fullredraw = true;
        if (Gz143.g() - lastCanvasReplace > 1000L && ((rectangle = graphics.getClipBounds()) == null || rectangle.width >= frameWid && rectangle.height >= frameHei)) {
            canvasReplaceRecommended = true;
        }
    }

    @Override
    public final void focusGained(FocusEvent focusEvent) {
        focus_in = true;
        fullredraw = true;
    }

    @Override
    public final void windowClosed(WindowEvent windowEvent) {
    }

    public final void startApplication(int n, int n2, String string, String string2, int n3, int n4, boolean bl, int n5, int n6) {
        try {
            this.setEnvironment(GameShell3$Environment.APPLICATION, false);
            frameWid = canvasWid = n;
            frameHei = canvasHei = n2;
            leftMargin = 0;
            topMargin = 0;
            String string3 = "Jagex";
            this.createAndShowFrame("Jagex");
            Ku323.s = null;
            this.startCommon(string, string2, n3, n4, bl, n5, n6);
        }
        catch (Exception exception) {
            logger.error("", exception);
            Ku323.g(null, exception);
        }
    }

    @Override
    public final void windowDeiconified(WindowEvent windowEvent) {
    }

    @Override
    public final void windowClosing(WindowEvent windowEvent) {
        this.destroy();
    }

    public final void startApplet(GameShell3$FrameParameters gameShell3$FrameParameters, String string, String string2, int n, int n2, boolean bl, int n3, int n4, boolean bl2) {
        try {
            this.setEnvironment(GameShell3$Environment.APPLET, bl2);
            frameWid = canvasWid = gameShell3$FrameParameters.getWidth();
            frameHei = canvasHei = gameShell3$FrameParameters.getHeight();
            leftMargin = 0;
            topMargin = 0;
            if (GameShell3.getEnvironment() == GameShell3$Environment.APPLET_WITH_EXTERNAL_FRAME) {
                frameWid += 2 * gameShell3$FrameParameters.getXMargin();
                frameHei += 2 * gameShell3$FrameParameters.getYMargin();
                this.createAndShowFrame(gameShell3$FrameParameters.getTitle());
            }
            Ku323.s = this;
            this.startCommon(string, string2, n, n2, bl, n3, n4);
        }
        catch (Throwable throwable) {
            logger.error("", throwable);
            Ku323.g(null, throwable);
            this.error("crash");
        }
    }

    @Override
    public final void windowIconified(WindowEvent windowEvent) {
    }

    @Override
    public final void windowOpened(WindowEvent windowEvent) {
    }

    @Override
    public abstract void init();

    public abstract void maininit();

    public abstract void mainquit();

    @Override
    public final void update(Graphics graphics) {
        this.paint(graphics);
    }

    public abstract void mainloop(float var1);

    public abstract void mainphysics();

    public abstract void mainredraw();

    @Override
    public final void focusLost(FocusEvent focusEvent) {
        focus_in = false;
    }

    @Override
    public String getParameter(String string) {
        if (GameShell3.getEnvironment() == GameShell3$Environment.APPLICATION) {
            return null;
        }
        return super.getParameter(string);
    }

    @Override
    public final void windowActivated(WindowEvent windowEvent) {
    }

    @Override
    public URL getDocumentBase() {
        if (GameShell3.getEnvironment() == GameShell3$Environment.APPLICATION) {
            return null;
        }
        return super.getDocumentBase();
    }

    private void mainredrawwrapper() {
        this.mainredraw();
    }

    @Override
    public URL getCodeBase() {
        if (GameShell3.getEnvironment() == GameShell3$Environment.APPLICATION) {
            return null;
        }
        return super.getCodeBase();
    }

    private void setEnvironment(GameShell3$Environment gameShell3$Environment, boolean bl) {
        if (gameShell3$Environment == null) {
            throw new NullPointerException();
        }
        if (gameShell3$Environment != GameShell3$Environment.APPLET && gameShell3$Environment != GameShell3$Environment.APPLICATION) {
            throw new IllegalStateException();
        }
        environment = gameShell3$Environment;
        if (environment == GameShell3$Environment.APPLICATION) {
            return;
        }
        if (bl) {
            environment = GameShell3$Environment.APPLET_WITH_EXTERNAL_FRAME;
        }
    }

    public static GameShell3$Environment getEnvironment() {
        return environment;
    }

    public static final void doneslowupdate() {
    }

    public void removeCanvas() {
        if (canvas != null) {
            canvas.removeFocusListener(this);
            canvas.getParent().setBackground(Color.black);
            canvas.getParent().remove(canvas);
        }
    }

    @Override
    public void start() {
        if (shutdown) {
            return;
        }
        killtime = 0L;
    }

    static {
        logger = LoggerFactory.getLogger(GameShell3.class);
        fps = 0.0;
        fpsL = 999999.0;
        fpsH = 0.0;
        lps = 0.0;
        pps = 0.0;
        fpsAverage = 0.0;
        fpsCount = 0.0;
        fpsTotal = 0.0;
        logicRate = 50;
        logicUpdateInterval = 20000000L;
        physicsRate = 20.0f;
        physicsUpdateInterval = 50000000L;
        PauseCountFPS = 0.0;
        leftMargin = 0;
        topMargin = 0;
        loadingTitle = null;
        fullredraw = true;
        fullRedrawForce = 500;
        canvasReplaceRecommended = false;
        lastCanvasReplace = 0L;
        renderFrameCount = 0;
        focus_in = true;
        uidDat = null;
        cacheDat = null;
        masterIndex = null;
        environment = null;
        killtime = 0L;
        shutdown = false;
        maxmemory = -1;
        cpucount = 1;
    }

    @Override
    public AppletContext getAppletContext() {
        if (GameShell3.getEnvironment() == GameShell3$Environment.APPLICATION) {
            return null;
        }
        return super.getAppletContext();
    }
}

