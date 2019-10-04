/*
 * Decompiled with CFR 0.146.
 */
package com.jagex.jnibindings.runetek6.RuntimeTool;

import com.jagex.jnibindings.runetek6.RuntimeTool.A213;
import com.jagex.jnibindings.runetek6.RuntimeTool.D222;
import com.jagex.jnibindings.runetek6.RuntimeTool.E219;
import com.jagex.jnibindings.runetek6.RuntimeTool.H221;
import com.jagex.jnibindings.runetek6.RuntimeTool.J217;
import com.jagex.jnibindings.runetek6.RuntimeTool.K225;
import com.jagex.jnibindings.runetek6.RuntimeTool.L223;
import com.jagex.jnibindings.runetek6.RuntimeTool.M216;
import com.jagex.jnibindings.runetek6.RuntimeTool.N220;
import com.jagex.jnibindings.runetek6.RuntimeTool.O218;
import com.jagex.jnibindings.runetek6.RuntimeTool.P214;
import com.jagex.jnibindings.runetek6.RuntimeTool.R212;
import com.jagex.jnibindings.runetek6.RuntimeTool.S226;
import com.jagex.jnibindings.runetek6.RuntimeTool.U215;
import com.jagex.jnibindings.runetek6.RuntimeTool.W224;
import com.jagex.jnibindings.runetek6.RuntimeTool.Y227;
import com.jagex.jnibindings.runetek6.RuntimeTool.Z132;
import com.jagex.jnibindings.runetek6.StateManager;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintStream;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.accessibility.AccessibleContext;
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
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tfu.Be2;
import tfu.Bs1;

public class RuntimeTool
extends JFrame {
    static ConcurrentLinkedQueue h;
    private static final Logger logger;
    JLabel a;
    JTextField aa;
    float[] ab;
    Vector ac;
    JButton af;
    JLabel ag;
    JButton ah;
    JLabel ai;
    JButton al;
    JScrollPane am;
    JTextField an;
    JTextField ao;
    JTextField ap;
    JLabel aq;
    DefaultMutableTreeNode ar = null;
    JTextField as;
    long at = 0L;
    float au = 0.0f;
    JButton av;
    DefaultMutableTreeNode aw = null;
    boolean ax = false;
    JButton az;
    JTree b;
    JLabel c;
    JLabel f;
    JLabel i;
    JButton k;
    JTree l;
    JSplitPane m;
    JPanel n;
    JLabel o;
    JPanel p;
    Box r;
    StateManager s = new StateManager();
    JButton t;
    JSplitPane u;
    protected JTabbedPane v;
    JSplitPane w;
    JTextArea z;

    static void k(RuntimeTool runtimeTool) {
        if (runtimeTool.at != 0L) {
            runtimeTool.p.removeAll();
            runtimeTool.p.invalidate();
            runtimeTool.p.validate();
            runtimeTool.repaint();
            runtimeTool.p.repaint();
            RuntimeTool.refreshWidgets(runtimeTool.at);
            runtimeTool.p.invalidate();
            runtimeTool.invalidate();
            runtimeTool.p.validate();
            runtimeTool.repaint();
            runtimeTool.p.repaint();
            RuntimeTool.n(runtimeTool);
        }
    }

    @Be2
    @Bs1
    void activateState(String string) {
    }

    public RuntimeTool() {
        super("RTT    Feature Requests: amber.booth@jagex.com");
        this.p = new JPanel();
        this.i = new JLabel("Click on a state");
        this.o = new JLabel("Active = ");
        this.a = new JLabel("Focused = ");
        this.f = new JLabel("Enabled = ");
        this.c = new JLabel("false");
        this.ag = new JLabel("false");
        this.aq = new JLabel("false");
        this.ai = new JLabel("false");
        this.al = new JButton("toggle");
        this.af = new JButton("toggle");
        this.av = new JButton("toggle");
        this.az = new JButton("toggle");
        this.ah = new JButton("KILL!");
        this.ap = new JTextField();
        this.ao = new JTextField();
        this.aa = new JTextField();
        this.an = new JTextField();
        this.ac = new Vector();
        this.ab = new float[16];
        this.setBounds(600, 0, 700, 700);
        this.setResizable(true);
        this.b();
        StateManager.SetJVM();
    }

    public void b() {
        try {
            RuntimeTool.createRuntimeTool(this);
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        long l = StateManager.getRootState();
        this.aw = new DefaultMutableTreeNode(new R212(this, l));
        this.l(l, this.aw);
        this.b = new JTree(this.aw);
        l = StateManager.getRootProfileZone();
        this.ar = new DefaultMutableTreeNode(new A213(this, l));
        this.w(l, this.ar);
        this.l = new JTree(this.ar);
        this.y();
    }

    public void l(long l, DefaultMutableTreeNode defaultMutableTreeNode) {
        DefaultMutableTreeNode defaultMutableTreeNode2 = null;
        int n = StateManager.getNumChildren(l);
        for (int i = 0; i < n; ++i) {
            long l2 = StateManager.getChildAtIndex(l, i);
            defaultMutableTreeNode2 = new DefaultMutableTreeNode(new R212(this, l2));
            defaultMutableTreeNode.add(defaultMutableTreeNode2);
            this.l(l2, defaultMutableTreeNode2);
        }
    }

    public void w(long l, DefaultMutableTreeNode defaultMutableTreeNode) {
        DefaultMutableTreeNode defaultMutableTreeNode2 = null;
        int n = StateManager.getNumZoneChildren(l);
        if (n < 30) {
            for (int i = 0; i < n; ++i) {
                long l2 = StateManager.getZoneChildAtIndex(l, i);
                A213 a213 = new A213(this, l2);
                defaultMutableTreeNode2 = new DefaultMutableTreeNode(a213);
                defaultMutableTreeNode.add(defaultMutableTreeNode2);
                if (a213.d.equals("@Scripting_n::luaProtectedCall") || a213.d.equals("XElementQueue")) continue;
                this.w(l2, defaultMutableTreeNode2);
            }
        }
    }

    static void m(RuntimeTool runtimeTool, MouseEvent mouseEvent) {
        TreePath treePath = runtimeTool.b.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
        if (treePath != null) {
            DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)treePath.getLastPathComponent();
            runtimeTool.i.setText(treePath.toString());
            runtimeTool.at = ((R212)defaultMutableTreeNode.getUserObject()).g;
        } else {
            runtimeTool.i.setText("");
        }
        RuntimeTool.k(runtimeTool);
    }

    static void v(RuntimeTool runtimeTool) {
        do {
            try {
                do {
                    Thread.sleep(2000L);
                } while (true);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
                continue;
            }
            break;
        } while (true);
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
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("File");
        jMenu.setMnemonic(70);
        jMenu.getAccessibleContext().setAccessibleDescription("Danny thinks you are cool!");
        jMenuBar.add(jMenu);
        JMenuItem jMenuItem = new JMenuItem("Reload states", 82);
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(82, 8));
        jMenuItem.getAccessibleContext().setAccessibleDescription("Reloads all states from the xml files");
        jMenuItem.addActionListener(new J217(this));
        jMenu.add(jMenuItem);
        jMenuItem = new JMenuItem("Refresh hierarchy", 72);
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(72, 8));
        jMenuItem.getAccessibleContext().setAccessibleDescription("Reloads all states from the xml files");
        jMenuItem.addActionListener(new O218(this));
        jMenu.add(jMenuItem);
        this.setJMenuBar(jMenuBar);
        JPanel jPanel = new JPanel(new FlowLayout());
        JLabel jLabel = new JLabel("Send Event");
        jPanel.add(jLabel);
        this.as = new JTextField(64);
        this.as.setMinimumSize(new Dimension(32, 32));
        this.as.addActionListener(new E219(this));
        jPanel.add(this.as);
        this.r.setAlignmentY(0.0f);
        this.r.setAlignmentX(0.0f);
        this.r.setAlignmentY(0.0f);
        this.r.setAlignmentX(0.0f);
        this.w.setAlignmentY(0.0f);
        this.w.setAlignmentX(0.0f);
        this.r.add(this.i);
        this.r.add(jPanel);
        this.r.add(this.p);
        this.p.setMinimumSize(new Dimension(768, 768));
        this.p.setPreferredSize(new Dimension(768, 768));
        this.r.setPreferredSize(new Dimension(768, 768));
        this.v.addTab("States", this.w);
        this.v.addTab("MiscLogs", this.u);
        this.v.addTab("TableOutput", this.m);
        this.v.setMinimumSize(new Dimension(1000, 700));
        this.v.setPreferredSize(new Dimension(1000, 700));
        this.add((Component)this.v, "Center");
        RuntimeTool.p(this);
    }

    @Be2
    @Bs1
    void addTextField(String string, int n, String string2, String string3, boolean bl) {
        JPanel jPanel = new JPanel(new FlowLayout());
        JLabel jLabel = new JLabel(string);
        jPanel.add(jLabel);
        N220 n220 = new N220(string, string2, string3);
        n220.j = n;
        n220.q = bl;
        this.ac.add(n220);
        jPanel.add(n220.s);
        this.p.add(jPanel);
    }

    private String x() {
        int n;
        String[][] arrstring = Z132.j();
        StringBuffer stringBuffer = new StringBuffer(arrstring.length * 16);
        for (n = 0; n < 4; ++n) {
            stringBuffer.append(D222.d[n] + "\t");
        }
        stringBuffer.append("\n");
        for (n = 0; n < arrstring.length; ++n) {
            for (int i = 0; i < 4; ++i) {
                stringBuffer.append(arrstring[n][i] + "\t");
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    void z(String[][] arrstring, String[] arrstring2) {
        this.n.removeAll();
        this.n.setLayout(new GridLayout(1, 1));
        JTable jTable = new JTable(arrstring, arrstring2);
        jTable.enableInputMethods(false);
        JScrollPane jScrollPane = new JScrollPane(jTable);
        this.n.add(jScrollPane);
        this.m.repaint();
        this.m.revalidate();
    }

    private void t() {
        this.m = new JSplitPane(0);
        this.k = new JButton("TimedEvents");
        JPanel jPanel = new JPanel(new GridLayout(3, 3));
        jPanel.add(this.k);
        this.k.addActionListener(new L223(this));
        this.m.add(jPanel);
        this.n = new JPanel(new FlowLayout());
        String[] arrstring = new String[]{"HEADER1", "HEADER2", "HEADER3", "HEADER4"};
        String[][] arrstring2 = new String[30][4];
        this.z(arrstring2, arrstring);
        this.m.add(this.n);
    }

    static void i(RuntimeTool runtimeTool, String string) {
        StateManager.callStateCommand(runtimeTool.at, string);
    }

    static {
        logger = LoggerFactory.getLogger(RuntimeTool.class);
        h = new ConcurrentLinkedQueue();
    }

    @Be2
    @Bs1
    void addButton(String string) {
        String string2 = string;
        JButton jButton = new JButton(string);
        jButton.addActionListener(new W224(this, string2));
        this.p.add(jButton);
    }

    @Be2
    @Bs1
    void addLabel(String string) {
        JLabel jLabel = new JLabel(string, 2);
        this.p.add(jLabel);
    }

    @Be2
    @Bs1
    void addBoolTextField(String string, String string2, String string3, boolean bl) {
        JPanel jPanel = new JPanel(new FlowLayout());
        JLabel jLabel = new JLabel(string);
        jPanel.add(jLabel);
        N220 n220 = new N220(string, string2, string3);
        n220.j = 0;
        n220.q = bl;
        this.ac.add(n220);
        jPanel.add(n220.s);
        JButton jButton = new JButton("Toggle");
        jButton.addActionListener(new K225(this));
        jPanel.add(jButton);
        this.p.add(jPanel);
    }

    static void p(RuntimeTool runtimeTool) {
        runtimeTool.l.setAlignmentY(0.0f);
        runtimeTool.l.setAlignmentX(0.0f);
        runtimeTool.v.addTab("Profiling", runtimeTool.l);
    }

    @Be2
    @Bs1
    void addFloatTextField(String string, String string2, String string3, boolean bl) {
        this.addTextField(string, 2, string2, string3, bl);
    }

    @Be2
    @Bs1
    void addStringTextField(String string, String string2, String string3, boolean bl) {
        this.addTextField(string, 3, string2, string3, bl);
    }

    public static final native void createRuntimeTool(Object var0);

    private void u() {
        this.u = new JSplitPane(0);
        this.z = new JTextArea(1, 10);
        this.z.setEditable(false);
        this.t = new JButton("DumpTimedEvents");
        JPanel jPanel = new JPanel(new GridLayout(3, 3));
        JPanel jPanel2 = new JPanel(new GridLayout(1, 1));
        JScrollPane jScrollPane = new JScrollPane(this.z, 22, 30);
        jPanel.add(this.t);
        this.t.addActionListener(new S226(this));
        jPanel2.add(jScrollPane);
        this.u.add(jPanel);
        this.u.add(jPanel2);
    }

    @Be2
    @Bs1
    void deactivateState(String string) {
        this.b.invalidate();
    }

    static /* synthetic */ Logger o() {
        return logger;
    }

    static void r(RuntimeTool runtimeTool) {
        StateManager.callStateCommand(StateManager.g, "Reload");
        do {
            try {
                do {
                    Thread.sleep(2000L);
                } while (true);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
                continue;
            }
            break;
        } while (true);
    }

    @Be2
    @Bs1
    void addIntTextField(String string, String string2, String string3, boolean bl) {
        this.addTextField(string, 1, string2, string3, bl);
    }

    static void n(RuntimeTool runtimeTool) {
        for (int i = 0; i < runtimeTool.ac.size(); ++i) {
            ((H221)runtimeTool.ac.elementAt((int)i)).g = runtimeTool.at;
            ((H221)runtimeTool.ac.elementAt(i)).g();
        }
    }

    @Be2
    @Bs1
    void addMatrix(String string, boolean bl) {
        Y227 y227 = new Y227(string);
        y227.q = bl;
        this.p.add(y227.j);
        this.ac.add(y227);
    }

    public static final native void refreshWidgets(long var0);

    static /* synthetic */ String a(RuntimeTool runtimeTool) {
        return runtimeTool.x();
    }
}

