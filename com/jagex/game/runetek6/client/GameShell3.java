package com.jagex.game.runetek6.client;

import com.jagex.core.stringtools.general.StringTools;
import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.Canvas;
import java.awt.Color;
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

public abstract class GameShell3 extends Applet implements Runnable, FocusListener, WindowListener {
   private static final int CACHE_LOCATOR_MOVECACHE = 1;
   private static final int CACHE_LOCATOR_NORMAL = 0;
   public static final int DEFAULT_LOGIC_RATE = 50;
   public static final float DEFAULT_PHYSICS_RATE = 20.0F;
   private static final String FILE_ACCESS_PERMISSIONS = "rw";
   private static final int MAX_CACHEINDEX_SIZE = 1048576;
   public static final long NANOS_PER_SECOND = 1000000000L;
   public static double PauseCountFPS = 0.0D;
   private static final String UIDFileName = "random.dat";
   public static final long UPDATE_FPS_INTERVAL = 1000000000L;
   private static final boolean allowHost8Realms = true;
   private static final boolean allowHostFunorb = true;
   private static final boolean allowHostRunescape = true;
   private static final boolean allowHostStellarDawn = true;
   private static final boolean allowHostTransformers = true;
   private static int archiveCount;
   private static Font bf;
   public static Im133 cacheDat = null;
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
   public static volatile boolean canvasReplaceRecommended = false;
   public static int canvasWid;
   public static int cpucount = 1;
   private static final boolean debug = true;
   public static GameShell3$Environment environment = null;
   public static EventQueue eventQueue;
   public static boolean focus;
   private static volatile boolean focus_in = true;
   public static double fps = 0.0D;
   public static double fpsAverage = 0.0D;
   public static double fpsCount = 0.0D;
   public static double fpsH = 0.0D;
   public static double fpsL = 999999.0D;
   public static double fpsTotal = 0.0D;
   public static Frame frame;
   public static int frameHei;
   public static int frameWid;
   public static Frame fsframe;
   public static Hw321 fsimp14;
   private static int fullRedrawForce = 500;
   public static volatile boolean fullredraw = true;
   private static String[] historicCacheDirectories;
   private static int historicCacheId;
   private static String[] historicCacheLocations;
   public static String homeDir;
   public static String javaVendor;
   public static String javaVersion;
   private static long killtime = 0L;
   private static volatile long lastCanvasReplace = 0L;
   public static int lastFullscreenHeight;
   public static int lastFullscreenWidth;
   public static int leftMargin = 0;
   public static String loadingTitle = null;
   private static final Logger logger = LoggerFactory.getLogger(GameShell3.class);
   private static int logicRate = 50;
   private static long logicUpdateInterval = 20000000L;
   public static double lps = 0.0D;
   public static Im133 masterIndex = null;
   public static int maxmemory = -1;
   public static Dv322 mouseImp;
   public static String osArchRaw;
   public static String osName;
   public static String osNameRaw;
   public static String osVersionRaw;
   public static Image percentbuf;
   protected static float physicsRate = 20.0F;
   protected static long physicsUpdateInterval = 50000000L;
   public static double pps = 0.0D;
   public static int renderFrameCount = 0;
   private static boolean shutdown = false;
   public static int topMargin = 0;
   private static Im133 uidDat = null;
   static final boolean usedirectx = true;
   private static final boolean usefullscreen = true;
   static final boolean usejaclib = true;
   static final boolean usenativelib = true;
   static final boolean useopengl = true;
   static final boolean usesw3d = true;
   static final boolean usetheora = true;
   public boolean alreadyerrored = false;
   final double dfOneOverNanosPerSecond = 1.0E-9D;
   public boolean jaclibloaded = false;

   public static void pushUID192(Gg3 var0) {
      byte[] var1 = new byte[24];

      try {
         uidDat.d(0L);
         Im133.e(uidDat, var1);

         int var2;
         for(var2 = 0; var2 < 24 && var1[var2] == 0; ++var2) {
         }

         if (var2 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var3 = 0; var3 < 24; ++var3) {
            var1[var3] = -1;
         }
      }

      Gg3.aa(var0, var1, 0, 24);
   }

   private final void shutdown(boolean var1) {
      synchronized(this) {
         if (shutdown) {
            return;
         }

         shutdown = true;
      }

      logger.debug("Shutdown start - clean:{}", var1);

      try {
         this.mainquit();
      } catch (Exception var5) {
         logger.error("", var5);
      }

      try {
         Im133.g(cacheDat);

         for(int var2 = 0; var2 < archiveCount; ++var2) {
            Im133.g(cacheIndex[var2]);
         }

         Im133.g(masterIndex);
         Im133.g(uidDat);
      } catch (Exception var6) {
      }

      this.closeLockFileArtefacts(cacheLockFile, cacheLockChannel, cacheLock);
      cacheLock = null;
      cacheLockChannel = null;
      cacheLockFile = null;
      if (canvas != null) {
         try {
            canvas.removeFocusListener(this);
            canvas.getParent().remove(canvas);
         } catch (Exception var4) {
            logger.error("", var4);
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

      logger.debug("Shutdown complete - clean:{}", var1);
   }

   private final void startCommon(String var1, String var2, int var3, int var4, boolean var5, int var6, int var7) throws Exception {
      archiveCount = var4;
      historicCacheId = var3;
      Ku323.e = var6;
      Ku323.h = var7;
      javaVendor = "Unknown";
      javaVersion = "1.1";

      try {
         javaVendor = System.getProperty("java.vendor");
         javaVersion = System.getProperty("java.version");
      } catch (Exception var17) {
      }

      try {
         osNameRaw = System.getProperty("os.name");
      } catch (Exception var16) {
         osNameRaw = "Unknown";
      }

      osName = osNameRaw.toLowerCase();

      try {
         osArchRaw = System.getProperty("os.arch").toLowerCase();
      } catch (Exception var15) {
         osArchRaw = "";
      }

      try {
         osVersionRaw = System.getProperty("os.version").toLowerCase();
      } catch (Exception var14) {
         osVersionRaw = "";
      }

      try {
         homeDir = System.getProperty("user.home");
         if (homeDir != null) {
            homeDir = homeDir + "/";
         }
      } catch (Exception var13) {
      }

      if (homeDir == null) {
         homeDir = "~/";
      }

      try {
         eventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var12) {
      }

      historicCacheLocations = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", homeDir, "/tmp/", ""};
      historicCacheDirectories = new String[]{".jagex_cache_" + historicCacheId, ".file_store_" + historicCacheId};

      int var8;
      for(var8 = 0; var8 < 4; ++var8) {
         cacheDirectory = this.getCacheDirectory(var1, var2, var8);
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
      } else {
         Dh131.g(cacheDirectory);
         openUID();
         if (var5) {
            cacheDat = new Im133(new Is139(Dh131.d("main_file_cache.dat2"), "rw", -1L), 5200, 0);
            masterIndex = new Im133(new Is139(Dh131.d("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
            cacheIndex = new Im133[archiveCount];

            for(var8 = 0; var8 < archiveCount; ++var8) {
               cacheIndex[var8] = new Im133(new Is139(Dh131.d("main_file_cache.idx" + var8), "rw", 1048576L), 6000, 0);
            }
         }

         fsimp14 = new Hw321();
         mouseImp = new Dv322();
         ThreadGroup var18 = Thread.currentThread().getThreadGroup();

         for(ThreadGroup var9 = var18.getParent(); var9 != null; var9 = var9.getParent()) {
            var18 = var9;
         }

         Thread[] var10 = new Thread[1000];
         var18.enumerate(var10);

         for(int var11 = 0; var11 < var10.length; ++var11) {
            if (var10[var11] != null && var10[var11].getName().startsWith("AWT")) {
               var10[var11].setPriority(1);
            }
         }

         Dp208.g(this, osName);
         Thread var19 = new Thread(this);
         var19.setDaemon(true);
         var19.start();
         var19.setPriority(1);
      }
   }

   private boolean tryLock(File var1) {
      if (cacheLock == null && cacheLockChannel == null && cacheLockFile == null) {
         FileOutputStream var2 = null;

         try {
            var2 = new FileOutputStream(new File(var1, "lock"));
         } catch (FileNotFoundException var7) {
            return false;
         }

         FileChannel var3 = var2.getChannel();
         FileLock var4 = null;

         try {
            var4 = var3.tryLock();
            if (var4 != null && var4.isValid()) {
               cacheLock = var4;
               cacheLockChannel = var3;
               cacheLockFile = var2;
               return true;
            } else {
               this.closeLockFileArtefacts(var2, var3, (FileLock)null);
               return false;
            }
         } catch (IOException var6) {
            this.closeLockFileArtefacts(var2, var3, (FileLock)null);
            return false;
         }
      } else {
         throw new IllegalStateException("Looks like we already have a lock on a cache - don't try and take out another one!");
      }
   }

   private void closeLockFileArtefacts(FileOutputStream var1, FileChannel var2, FileLock var3) {
      if (var3 != null) {
         try {
            var3.release();
         } catch (IOException var7) {
            var7.printStackTrace();
         }
      }

      try {
         var2.close();
      } catch (IOException var6) {
         var6.printStackTrace();
      }

      try {
         var1.close();
      } catch (IOException var5) {
         var5.printStackTrace();
      }

   }

   private File getCacheDirectory(String var1, String var2, int var3) {
      String var4 = var3 == 0 ? "" : "" + var3;
      cacheLocator = new File(homeDir, "jagex_cl_" + var1 + "_" + var2 + var4 + ".dat");
      String var5 = null;
      String var6 = null;
      boolean var7 = false;
      File var21;
      if (cacheLocator.exists()) {
         try {
            Is139 var8 = new Is139(cacheLocator, "rw", 10000L);

            Gg3 var9;
            int var10;
            for(var9 = new Gg3((int)Is139.e(var8)); var9.v < var9.r.length; var9.v += var10) {
               var10 = Is139.h(var8, var9.r, var9.v, var9.r.length - var9.v);
               if (var10 == -1) {
                  throw new IOException();
               }
            }

            var9.v = 0;
            var10 = Gg3.ar(var9);
            if (var10 < 1 || var10 > 2) {
               throw new IOException("" + var10);
            }

            int var11 = 0;
            if (var10 > 1) {
               var11 = Gg3.ar(var9);
            }

            var5 = var9.bh();
            if (var11 == 1) {
               var6 = var9.bh();
            }

            Is139.j(var8);
            logger.debug("Cache: Read cache locator file from: {}, state: {}", cacheLocator, var11);
         } catch (IOException var18) {
            logger.error("Cache: Error opening cache locator file.", var18);
         }

         if (var5 != null) {
            var21 = new File(var5);
            if (!var21.exists()) {
               logger.debug("Cache: Cache locator location does not exist: {}", var5);
               var5 = null;
            }
         }

         if (var5 != null) {
            var21 = new File(var5, "test.dat");
            if (!this.checkWritable(var21, true)) {
               logger.debug("Cache: Cache locator location not writable: {}", var5);
               var5 = null;
            }
         }
      }

      if (var5 == null && var3 == 0) {
         label98:
         for(int var19 = 0; var19 < historicCacheDirectories.length; ++var19) {
            for(int var22 = 0; var22 < historicCacheLocations.length; ++var22) {
               File var23 = new File(historicCacheLocations[var22] + historicCacheDirectories[var19] + File.separatorChar + var1 + File.separatorChar);
               if (var23.exists() && this.checkWritable(new File(var23, "test.dat"), true)) {
                  var5 = var23.toString();
                  var7 = true;
                  logger.debug("Cache: Legacy cache found: {}", var5);
                  break label98;
               }
            }
         }
      }

      if (var5 == null) {
         logger.debug("Cache: No previous cache found, using default.");
         var5 = homeDir + File.separatorChar + "jagexcache" + var4 + File.separatorChar + var1 + File.separatorChar + var2 + File.separatorChar;
         var7 = true;
      }

      if (var6 != null) {
         logger.debug("Cache: Copying cache from old location: {}", var6);
         File var20 = new File(var6);
         var21 = new File(var5);

         try {
            File[] var24 = var20.listFiles();
            File[] var25 = var24;
            int var12 = var24.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               File var14 = var25[var13];
               File var15 = new File(var21, var14.getName());
               logger.debug("Cache: Copying old file: {} to {}", var14, var15);
               boolean var16 = var14.renameTo(var15);
               if (!var16) {
                  throw new IOException();
               }
            }
         } catch (Exception var17) {
            logger.error("Cache: Error when copying cache from old location.", var17);
         }

         var7 = true;
      }

      if (var7) {
         this.writeCacheLocator(new File(var5), (File)null);
      }

      logger.debug("Cache: Using cache at: {}", var5);
      return new File(var5);
   }

   private void writeCacheLocator(File var1, File var2) {
      try {
         logger.debug("Cache: Writing cache locator file with new location: {} old location: {}", var1, var2 == null ? "N/A" : var2);
         Is139 var3 = new Is139(cacheLocator, "rw", 10000L);
         Gg3 var4 = new Gg3(500);
         Gg3.k(var4, 2);
         Gg3.k(var4, var2 != null ? 1 : 0);
         var4.ap(var1.getPath());
         if (var2 != null) {
            var4.ap(var2.getPath());
         }

         var3.q(var4.r, 0, var4.v);
         Is139.j(var3);
      } catch (IOException var5) {
         logger.error("Cache: Error writing cache locator file.", var5);
      }

   }

   private boolean checkWritable(File var1, boolean var2) {
      try {
         RandomAccessFile var3 = new RandomAccessFile(var1, "rw");
         int var4 = var3.read();
         var3.seek(0L);
         var3.write(var4);
         var3.seek(0L);
         var3.close();
         if (var2) {
            var1.delete();
         }

         return true;
      } catch (Exception var5) {
         return false;
      }
   }

   public static File getCacheLocation() {
      return cacheDirectory;
   }

   public static Is139 openPrefs(String var0, String var1, boolean var2) {
      File var3 = new File(cacheDirectory, "preferences" + var0 + ".dat");
      if (var3.exists()) {
         try {
            Is139 var10 = new Is139(var3, "rw", 10000L);
            logger.debug("Prefs: Opening existing prefs {} in modern location: {}", var0, var3);
            return var10;
         } catch (IOException var9) {
         }
      }

      String var4 = "";
      if (historicCacheId == 33) {
         var4 = "_rc";
      } else if (historicCacheId == 34) {
         var4 = "_wip";
      }

      File var5 = new File(homeDir, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      Is139 var6;
      if (!var2 && var5.exists()) {
         try {
            var6 = new Is139(var5, "rw", 10000L);
            logger.debug("Prefs: Opening existing prefs {} in historic location: {}", var0, var5);
            return var6;
         } catch (IOException var8) {
         }
      }

      try {
         var6 = new Is139(var3, "rw", 10000L);
         logger.debug("Prefs: Opening new prefs {} in modern location: {}", var0, var3);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   private static void openUID() {
      try {
         File var0 = new File(homeDir, "random.dat");
         int var2;
         if (var0.exists()) {
            uidDat = new Im133(new Is139(var0, "rw", 25L), 24, 0);
            logger.debug("UID: Opening UID in user's home directory: {}", var0);
         } else {
            label34:
            for(int var1 = 0; var1 < historicCacheDirectories.length; ++var1) {
               for(var2 = 0; var2 < historicCacheLocations.length; ++var2) {
                  File var3 = new File(historicCacheLocations[var2] + historicCacheDirectories[var1] + File.separatorChar + "random.dat");
                  if (var3.exists()) {
                     logger.debug("UID: Opening UID in historic directory: {}", var3);
                     uidDat = new Im133(new Is139(var3, "rw", 25L), 24, 0);
                     break label34;
                  }
               }
            }
         }

         if (uidDat == null) {
            logger.debug("UID: Couldn't find existing UID, creating new one in user's home directory: {}", var0);
            RandomAccessFile var5 = new RandomAccessFile(var0, "rw");
            var2 = var5.read();
            var5.seek(0L);
            var5.write(var2);
            var5.seek(0L);
            var5.close();
            uidDat = new Im133(new Is139(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var4) {
         logger.error("Error opening random.dat", var4);
      }

   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public void error(String var1) {
      if (!this.alreadyerrored) {
         this.alreadyerrored = true;
         logger.debug("error_game_{}", var1);

         try {
            Mu209.g(this, "loggedout");
         } catch (Throwable var4) {
         }

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_top");
         } catch (Exception var3) {
            logger.error("", var3);
         }

      }
   }

   private synchronized void createAndShowFrame(String var1) {
      frame = new Frame();
      frame.setTitle(var1);
      frame.setResizable(true);
      frame.addWindowListener(this);
      frame.setBackground(Color.black);
      frame.setVisible(true);
      frame.toFront();
      Insets var2 = frame.getInsets();
      frame.setSize(frameWid + var2.left + var2.right, frameHei + var2.top + var2.bottom);
   }

   public abstract void cycleend(boolean var1);

   public Container getTopContainer() {
      if (fsframe != null) {
         return fsframe;
      } else {
         return (Container)(frame != null ? frame : this);
      }
   }

   public void addCanvas(Container var1) {
      var1.setBackground(Color.black);
      var1.setLayout((LayoutManager)null);
      var1.add(canvas);
      canvas.setSize(canvasWid, canvasHei);
      canvas.setVisible(true);
      if (var1 == frame) {
         Insets var2 = frame.getInsets();
         canvas.setLocation(var2.left + leftMargin, var2.top + topMargin);
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
      Container var1 = this.getTopContainer();
      canvas = new Dq324(var1);
      this.addCanvas(var1);
   }

   public final boolean checkhost() {
      String var1 = this.getDocumentBase().getHost().toLowerCase();
      if (!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if (!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if (!var1.equals("stellardawn.com") && !var1.endsWith(".stellardawn.com")) {
               if (!var1.equals("transformersuniverse.com") && !var1.endsWith(".transformersuniverse.com")) {
                  if (!var1.equals("funorb.com") && !var1.endsWith(".funorb.com")) {
                     if (!var1.equals("8realms.com") && !var1.endsWith(".8realms.com")) {
                        if (var1.endsWith("127.0.0.1")) {
                           return true;
                        } else {
                           while(var1.length() > 0 && var1.charAt(var1.length() - 1) >= '0' && var1.charAt(var1.length() - 1) <= '9') {
                              var1 = var1.substring(0, var1.length() - 1);
                           }

                           if (var1.endsWith("192.168.1.")) {
                              return true;
                           } else {
                              this.error("invalidhost");
                              return false;
                           }
                        }
                     } else {
                        return true;
                     }
                  } else {
                     return true;
                  }
               } else {
                  return true;
               }
            } else {
               return true;
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   public void run() {
      logger.debug("run");
      this.run_inner();
      this.shutdown(true);
   }

   private void run_inner() {
      logger.debug("run_inner");
      int var3;
      if (javaVendor != null) {
         String var1 = javaVendor.toLowerCase();
         if (var1.indexOf("apple") != -1) {
            this.error("wrongjava");
            return;
         }

         if (var1.indexOf("sun") != -1) {
            String var2 = javaVersion;
            if (var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
               this.error("wrongjava");
               return;
            }

            if (var2.startsWith("1.6.0_")) {
               for(var3 = 6; var3 < var2.length() && StringTools.w(var2.charAt(var3)); ++var3) {
               }

               String var4 = var2.substring(6, var3);
               if (StringTools.d(var4) && StringTools.j(var4) < 10) {
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

      } else {
         Z132.g("GameShell.run_inner()");
         this.setFocusCycleRoot(true);
         maxmemory = (int)(Runtime.getRuntime().maxMemory() / 1048576L) + 1;
         cpucount = Runtime.getRuntime().availableProcessors();
         this.addcanvas();
         logger.debug("maininit");
         this.maininit();
         int var24 = 0;
         int var25 = 0;
         var3 = 0;
         long var26 = physicsUpdateInterval;
         long var6 = logicUpdateInterval;
         long var8 = 0L;
         long var10 = System.nanoTime();
         this.cycleend(true);
         logger.debug("mainloop");

         while(killtime == 0L || Gz143.g() < killtime) {
            this.cyclestart(false);
            boolean var22 = false;

            try {
               var22 = true;
               long var12 = System.nanoTime();
               long var14 = var12 - var10;
               var6 += var14;
               var26 += var14;
               var8 += var14;
               long var16 = 0L;

               float var18;
               for(var18 = (float)((double)var14 * 1.0E-9D); var26 > physicsUpdateInterval; ++var3) {
                  float var19 = (float)((double)physicsUpdateInterval * 1.0E-9D);
                  this.mainphysicswrapper();
                  var26 -= physicsUpdateInterval;
               }

               while(var6 > logicUpdateInterval) {
                  var18 = (float)((double)logicUpdateInterval * 1.0E-9D);
                  this.mainloopwrapper(var18);
                  var6 -= logicUpdateInterval;
                  ++var25;
                  Ap127.h = var25;
                  ++var16;
               }

               this.mainredrawwrapper();
               ++var24;
               ++renderFrameCount;
               if (var8 > 1000000000L) {
                  lps = (double)var25 / ((double)var8 * 1.0E-9D);
                  pps = (double)var3 / ((double)var8 * 1.0E-9D);
                  fps = (double)var24 / ((double)var8 * 1.0E-9D);
                  if (PauseCountFPS == 0.0D) {
                     fpsTotal += fps;
                     ++fpsCount;
                     if (fpsCount > 0.0D) {
                        fpsAverage = fpsTotal / fpsCount;
                     }

                     if (fps > fpsH) {
                        fpsH = fps;
                        if (fps > 999.0D) {
                           fpsH = 999.0D;
                        }
                     }

                     if (fps < fpsL) {
                        fpsL = fps;
                     }
                  }

                  var8 = 0L;
                  var25 = 0;
                  var3 = 0;
                  var24 = 0;
               }

               var10 = var12;
               this.cycleend(false);
               var22 = false;
            } finally {
               if (var22) {
                  this.cycleend(false);
               }
            }
         }

      }
   }

   public static final void setspeed(int var0) {
      logicRate = var0;
      logicUpdateInterval = 1000000000L / (long)logicRate;
   }

   public static final float getPhysicsSpeed() {
      return physicsRate;
   }

   public abstract void cyclestart(boolean var1);

   private void mainloopwrapper(float var1) {
      synchronized(this) {
         focus = focus_in;
      }

      this.mainloop(var1);
   }

   public static final void setPhysicsSpeed(float var0) {
      physicsRate = var0;
      physicsUpdateInterval = (long)(1.0E9F / physicsRate);
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

   public static void storeUID192(Gg3 var0, int var1) {
      if (uidDat != null) {
         try {
            uidDat.d(0L);
            Im133.b(uidDat, var0.r, var1, 24);
         } catch (Exception var3) {
         }
      }

   }

   public void stop() {
      if (!shutdown) {
         killtime = Gz143.g() + 4000L;
      }
   }

   public void destroy() {
      if (!shutdown) {
         killtime = Gz143.g();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if (!shutdown) {
         fullredraw = true;
         if (Gz143.g() - lastCanvasReplace > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if (var2 == null || var2.width >= frameWid && var2.height >= frameHei) {
               canvasReplaceRecommended = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      focus_in = true;
      fullredraw = true;
   }

   public final void windowClosed(WindowEvent var1) {
   }

   public final void startApplication(int var1, int var2, String var3, String var4, int var5, int var6, boolean var7, int var8, int var9) {
      try {
         this.setEnvironment(GameShell3$Environment.APPLICATION, false);
         canvasWid = var1;
         frameWid = var1;
         canvasHei = var2;
         frameHei = var2;
         leftMargin = 0;
         topMargin = 0;
         String var10 = "Jagex";
         this.createAndShowFrame("Jagex");
         Ku323.s = null;
         this.startCommon(var3, var4, var5, var6, var7, var8, var9);
      } catch (Exception var11) {
         logger.error("", var11);
         Ku323.g((String)null, var11);
      }

   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void startApplet(GameShell3$FrameParameters var1, String var2, String var3, int var4, int var5, boolean var6, int var7, int var8, boolean var9) {
      try {
         this.setEnvironment(GameShell3$Environment.APPLET, var9);
         frameWid = canvasWid = var1.getWidth();
         frameHei = canvasHei = var1.getHeight();
         leftMargin = 0;
         topMargin = 0;
         if (getEnvironment() == GameShell3$Environment.APPLET_WITH_EXTERNAL_FRAME) {
            frameWid += 2 * var1.getXMargin();
            frameHei += 2 * var1.getYMargin();
            this.createAndShowFrame(var1.getTitle());
         }

         Ku323.s = this;
         this.startCommon(var2, var3, var4, var5, var6, var7, var8);
      } catch (Throwable var11) {
         logger.error("", var11);
         Ku323.g((String)null, var11);
         this.error("crash");
      }

   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   public abstract void maininit();

   public abstract void mainquit();

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public abstract void mainloop(float var1);

   public abstract void mainphysics();

   public abstract void mainredraw();

   public final void focusLost(FocusEvent var1) {
      focus_in = false;
   }

   public String getParameter(String var1) {
      return getEnvironment() == GameShell3$Environment.APPLICATION ? null : super.getParameter(var1);
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public URL getDocumentBase() {
      return getEnvironment() == GameShell3$Environment.APPLICATION ? null : super.getDocumentBase();
   }

   private void mainredrawwrapper() {
      this.mainredraw();
   }

   public URL getCodeBase() {
      return getEnvironment() == GameShell3$Environment.APPLICATION ? null : super.getCodeBase();
   }

   private void setEnvironment(GameShell3$Environment var1, boolean var2) {
      if (var1 == null) {
         throw new NullPointerException();
      } else if (var1 != GameShell3$Environment.APPLET && var1 != GameShell3$Environment.APPLICATION) {
         throw new IllegalStateException();
      } else {
         environment = var1;
         if (environment != GameShell3$Environment.APPLICATION) {
            if (var2) {
               environment = GameShell3$Environment.APPLET_WITH_EXTERNAL_FRAME;
            }

         }
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

   public void start() {
      if (!shutdown) {
         killtime = 0L;
      }
   }

   public AppletContext getAppletContext() {
      return getEnvironment() == GameShell3$Environment.APPLICATION ? null : super.getAppletContext();
   }
}
