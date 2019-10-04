package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.StateManager;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bs1;

public class RuntimeTool extends JFrame {
   static ConcurrentLinkedQueue h = new ConcurrentLinkedQueue();
   private static final Logger logger = LoggerFactory.getLogger(RuntimeTool.class);
   JLabel a = new JLabel("Focused = ");
   JTextField aa = new JTextField();
   float[] ab = new float[16];
   Vector ac = new Vector();
   JButton af = new JButton("toggle");
   JLabel ag = new JLabel("false");
   JButton ah = new JButton("KILL!");
   JLabel ai = new JLabel("false");
   JButton al = new JButton("toggle");
   JScrollPane am;
   JTextField an = new JTextField();
   JTextField ao = new JTextField();
   JTextField ap = new JTextField();
   JLabel aq = new JLabel("false");
   DefaultMutableTreeNode ar = null;
   JTextField as;
   long at = 0L;
   float au = 0.0F;
   JButton av = new JButton("toggle");
   DefaultMutableTreeNode aw = null;
   boolean ax = false;
   JButton az = new JButton("toggle");
   JTree b;
   JLabel c = new JLabel("false");
   JLabel f = new JLabel("Enabled = ");
   JLabel i = new JLabel("Click on a state");
   JButton k;
   JTree l;
   JSplitPane m;
   JPanel n;
   JLabel o = new JLabel("Active = ");
   JPanel p = new JPanel();
   Box r;
   StateManager s = new StateManager();
   JButton t;
   JSplitPane u;
   protected JTabbedPane v;
   JSplitPane w;
   JTextArea z;

   static void k(RuntimeTool var0) {
      if (var0.at != 0L) {
         var0.p.removeAll();
         var0.p.invalidate();
         var0.p.validate();
         var0.repaint();
         var0.p.repaint();
         refreshWidgets(var0.at);
         var0.p.invalidate();
         var0.invalidate();
         var0.p.validate();
         var0.repaint();
         var0.p.repaint();
         n(var0);
      }

   }

   @Be2
   @Bs1
   void activateState(String var1) {
   }

   public RuntimeTool() {
      super("RTT    Feature Requests: amber.booth@jagex.com");
      this.setBounds(600, 0, 700, 700);
      this.setResizable(true);
      this.b();
      StateManager.SetJVM();
   }

   public void b() {
      try {
         createRuntimeTool(this);
      } catch (Exception var3) {
         System.out.println(var3);
      }

      long var1 = StateManager.getRootState();
      this.aw = new DefaultMutableTreeNode(new R212(this, var1));
      this.l(var1, this.aw);
      this.b = new JTree(this.aw);
      var1 = StateManager.getRootProfileZone();
      this.ar = new DefaultMutableTreeNode(new A213(this, var1));
      this.w(var1, this.ar);
      this.l = new JTree(this.ar);
      this.y();
   }

   public void l(long var1, DefaultMutableTreeNode var3) {
      DefaultMutableTreeNode var4 = null;
      int var5 = StateManager.getNumChildren(var1);

      for(int var6 = 0; var6 < var5; ++var6) {
         long var7 = StateManager.getChildAtIndex(var1, var6);
         var4 = new DefaultMutableTreeNode(new R212(this, var7));
         var3.add(var4);
         this.l(var7, var4);
      }

   }

   public void w(long var1, DefaultMutableTreeNode var3) {
      DefaultMutableTreeNode var4 = null;
      int var5 = StateManager.getNumZoneChildren(var1);
      if (var5 < 30) {
         for(int var6 = 0; var6 < var5; ++var6) {
            long var7 = StateManager.getZoneChildAtIndex(var1, var6);
            A213 var9 = new A213(this, var7);
            var4 = new DefaultMutableTreeNode(var9);
            var3.add(var4);
            if (!var9.d.equals("@Scripting_n::luaProtectedCall") && !var9.d.equals("XElementQueue")) {
               this.w(var7, var4);
            }
         }
      }

   }

   static void m(RuntimeTool var0, MouseEvent var1) {
      TreePath var2 = var0.b.getPathForLocation(var1.getX(), var1.getY());
      if (var2 != null) {
         DefaultMutableTreeNode var3 = (DefaultMutableTreeNode)var2.getLastPathComponent();
         var0.i.setText(var2.toString());
         var0.at = ((R212)((R212)var3.getUserObject())).g;
      } else {
         var0.i.setText("");
      }

      k(var0);
   }

   static void v(RuntimeTool var0) {
      while(true) {
         try {
            Thread.sleep(2000L);
         } catch (InterruptedException var4) {
            var4.printStackTrace();
         }
      }
   }

   void y() {
      this.p.setLayout(new GridLayout(10, 1));
      this.v = new JTabbedPane();
      this.am = new JScrollPane(this.b);
      this.r = Box.createVerticalBox();
      this.w = new JSplitPane(1, this.am, this.r);
      this.w.setDividerLocation(250);
      this.u();
      this.t();
      this.setMinimumSize(new Dimension(768, 768));
      this.am.setMinimumSize(new Dimension(256, 768));
      this.am.setPreferredSize(new Dimension(256, 768));
      this.w.setSize(700, 700);
      this.l.setLargeModel(true);
      this.b.setLargeModel(true);
      this.b.addMouseListener(new P214(this));
      this.b.setCellRenderer(new U215(this));
      this.l.setCellRenderer(new M216(this));
      JMenuBar var1 = new JMenuBar();
      JMenu var2 = new JMenu("File");
      var2.setMnemonic(70);
      var2.getAccessibleContext().setAccessibleDescription("Danny thinks you are cool!");
      var1.add(var2);
      JMenuItem var3 = new JMenuItem("Reload states", 82);
      var3.setAccelerator(KeyStroke.getKeyStroke(82, 8));
      var3.getAccessibleContext().setAccessibleDescription("Reloads all states from the xml files");
      var3.addActionListener(new J217(this));
      var2.add(var3);
      var3 = new JMenuItem("Refresh hierarchy", 72);
      var3.setAccelerator(KeyStroke.getKeyStroke(72, 8));
      var3.getAccessibleContext().setAccessibleDescription("Reloads all states from the xml files");
      var3.addActionListener(new O218(this));
      var2.add(var3);
      this.setJMenuBar(var1);
      JPanel var4 = new JPanel(new FlowLayout());
      JLabel var5 = new JLabel("Send Event");
      var4.add(var5);
      this.as = new JTextField(64);
      this.as.setMinimumSize(new Dimension(32, 32));
      this.as.addActionListener(new E219(this));
      var4.add(this.as);
      this.r.setAlignmentY(0.0F);
      this.r.setAlignmentX(0.0F);
      this.r.setAlignmentY(0.0F);
      this.r.setAlignmentX(0.0F);
      this.w.setAlignmentY(0.0F);
      this.w.setAlignmentX(0.0F);
      this.r.add(this.i);
      this.r.add(var4);
      this.r.add(this.p);
      this.p.setMinimumSize(new Dimension(768, 768));
      this.p.setPreferredSize(new Dimension(768, 768));
      this.r.setPreferredSize(new Dimension(768, 768));
      this.v.addTab("States", this.w);
      this.v.addTab("MiscLogs", this.u);
      this.v.addTab("TableOutput", this.m);
      this.v.setMinimumSize(new Dimension(1000, 700));
      this.v.setPreferredSize(new Dimension(1000, 700));
      this.add(this.v, "Center");
      p(this);
   }

   @Be2
   @Bs1
   void addTextField(String var1, int var2, String var3, String var4, boolean var5) {
      JPanel var6 = new JPanel(new FlowLayout());
      JLabel var7 = new JLabel(var1);
      var6.add(var7);
      N220 var8 = new N220(var1, var3, var4);
      var8.j = var2;
      var8.q = var5;
      this.ac.add(var8);
      var6.add(var8.s);
      this.p.add(var6);
   }

   private String x() {
      String[][] var1 = Z132.j();
      StringBuffer var2 = new StringBuffer(var1.length * 16);

      int var3;
      for(var3 = 0; var3 < 4; ++var3) {
         var2.append(D222.d[var3] + "\t");
      }

      var2.append("\n");

      for(var3 = 0; var3 < var1.length; ++var3) {
         for(int var4 = 0; var4 < 4; ++var4) {
            var2.append(var1[var3][var4] + "\t");
         }

         var2.append("\n");
      }

      return var2.toString();
   }

   void z(String[][] var1, String[] var2) {
      this.n.removeAll();
      this.n.setLayout(new GridLayout(1, 1));
      JTable var3 = new JTable(var1, var2);
      var3.enableInputMethods(false);
      JScrollPane var4 = new JScrollPane(var3);
      this.n.add(var4);
      this.m.repaint();
      this.m.revalidate();
   }

   private void t() {
      this.m = new JSplitPane(0);
      this.k = new JButton("TimedEvents");
      JPanel var1 = new JPanel(new GridLayout(3, 3));
      var1.add(this.k);
      this.k.addActionListener(new L223(this));
      this.m.add(var1);
      this.n = new JPanel(new FlowLayout());
      String[] var2 = new String[]{"HEADER1", "HEADER2", "HEADER3", "HEADER4"};
      String[][] var3 = new String[30][4];
      this.z(var3, var2);
      this.m.add(this.n);
   }

   static void i(RuntimeTool var0, String var1) {
      StateManager.callStateCommand(var0.at, var1);
   }

   @Be2
   @Bs1
   void addButton(String var1) {
      JButton var3 = new JButton(var1);
      var3.addActionListener(new W224(this, var1));
      this.p.add(var3);
   }

   @Be2
   @Bs1
   void addLabel(String var1) {
      JLabel var2 = new JLabel(var1, 2);
      this.p.add(var2);
   }

   @Be2
   @Bs1
   void addBoolTextField(String var1, String var2, String var3, boolean var4) {
      JPanel var5 = new JPanel(new FlowLayout());
      JLabel var6 = new JLabel(var1);
      var5.add(var6);
      N220 var7 = new N220(var1, var2, var3);
      var7.j = 0;
      var7.q = var4;
      this.ac.add(var7);
      var5.add(var7.s);
      JButton var8 = new JButton("Toggle");
      var8.addActionListener(new K225(this));
      var5.add(var8);
      this.p.add(var5);
   }

   static void p(RuntimeTool var0) {
      var0.l.setAlignmentY(0.0F);
      var0.l.setAlignmentX(0.0F);
      var0.v.addTab("Profiling", var0.l);
   }

   @Be2
   @Bs1
   void addFloatTextField(String var1, String var2, String var3, boolean var4) {
      this.addTextField(var1, 2, var2, var3, var4);
   }

   @Be2
   @Bs1
   void addStringTextField(String var1, String var2, String var3, boolean var4) {
      this.addTextField(var1, 3, var2, var3, var4);
   }

   public static final native void createRuntimeTool(Object var0);

   private void u() {
      this.u = new JSplitPane(0);
      this.z = new JTextArea(1, 10);
      this.z.setEditable(false);
      this.t = new JButton("DumpTimedEvents");
      JPanel var1 = new JPanel(new GridLayout(3, 3));
      JPanel var2 = new JPanel(new GridLayout(1, 1));
      JScrollPane var3 = new JScrollPane(this.z, 22, 30);
      var1.add(this.t);
      this.t.addActionListener(new S226(this));
      var2.add(var3);
      this.u.add(var1);
      this.u.add(var2);
   }

   @Be2
   @Bs1
   void deactivateState(String var1) {
      this.b.invalidate();
   }

   // $FF: synthetic method
   static Logger o() {
      return logger;
   }

   static void r(RuntimeTool var0) {
      StateManager.callStateCommand(StateManager.g, "Reload");

      while(true) {
         while(true) {
            try {
               Thread.sleep(2000L);
            } catch (InterruptedException var4) {
               var4.printStackTrace();
            }
         }
      }
   }

   @Be2
   @Bs1
   void addIntTextField(String var1, String var2, String var3, boolean var4) {
      this.addTextField(var1, 1, var2, var3, var4);
   }

   static void n(RuntimeTool var0) {
      for(int var1 = 0; var1 < var0.ac.size(); ++var1) {
         ((H221)var0.ac.elementAt(var1)).g = var0.at;
         ((H221)var0.ac.elementAt(var1)).g();
      }

   }

   @Be2
   @Bs1
   void addMatrix(String var1, boolean var2) {
      Y227 var3 = new Y227(var1);
      var3.q = var2;
      this.p.add(var3.j);
      this.ac.add(var3);
   }

   public static final native void refreshWidgets(long var0);

   // $FF: synthetic method
   static String a(RuntimeTool var0) {
      return var0.x();
   }
}
