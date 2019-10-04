// 
// Decompiled by Procyon v0.5.36
// 

package com.jagex.jnibindings.runetek6.RuntimeTool;

import org.slf4j.LoggerFactory;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.KeyStroke;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.tree.TreeCellRenderer;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import tfu.Bs1;
import tfu.Be2;
import javax.swing.JTextArea;
import javax.swing.JTabbedPane;
import com.jagex.jnibindings.runetek6.StateManager;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.util.Vector;
import javax.swing.JTextField;
import javax.swing.JLabel;
import org.slf4j.Logger;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.swing.JFrame;

public class RuntimeTool extends JFrame
{
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
    DefaultMutableTreeNode ar;
    JTextField as;
    long at;
    float au;
    JButton av;
    DefaultMutableTreeNode aw;
    boolean ax;
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
    StateManager s;
    JButton t;
    JSplitPane u;
    protected JTabbedPane v;
    JSplitPane w;
    JTextArea z;
    
    static void k(final RuntimeTool runtimeTool) {
        if (runtimeTool.at != 0L) {
            runtimeTool.p.removeAll();
            runtimeTool.p.invalidate();
            runtimeTool.p.validate();
            runtimeTool.repaint();
            runtimeTool.p.repaint();
            refreshWidgets(runtimeTool.at);
            runtimeTool.p.invalidate();
            runtimeTool.invalidate();
            runtimeTool.p.validate();
            runtimeTool.repaint();
            runtimeTool.p.repaint();
            n(runtimeTool);
        }
    }
    
    @Be2
    @Bs1
    void activateState(final String s) {
    }
    
    public RuntimeTool() {
        super("RTT    Feature Requests: amber.booth@jagex.com");
        this.s = new StateManager();
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
        this.at = 0L;
        this.ab = new float[16];
        this.aw = null;
        this.ar = null;
        this.ax = false;
        this.au = 0.0f;
        this.setBounds(600, 0, 700, 700);
        this.setResizable(true);
        this.b();
        StateManager.SetJVM();
    }
    
    public void b() {
        try {
            createRuntimeTool(this);
        }
        catch (Exception x) {
            System.out.println(x);
        }
        final long rootState = StateManager.getRootState();
        this.l(rootState, this.aw = new DefaultMutableTreeNode(new R212(this, rootState)));
        this.b = new JTree(this.aw);
        final long rootProfileZone = StateManager.getRootProfileZone();
        this.w(rootProfileZone, this.ar = new DefaultMutableTreeNode(new A213(this, rootProfileZone)));
        this.l = new JTree(this.ar);
        this.y();
    }
    
    public void l(final long n, final DefaultMutableTreeNode defaultMutableTreeNode) {
        for (int numChildren = StateManager.getNumChildren(n), i = 0; i < numChildren; ++i) {
            final long childAtIndex = StateManager.getChildAtIndex(n, i);
            final DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(new R212(this, childAtIndex));
            defaultMutableTreeNode.add(newChild);
            this.l(childAtIndex, newChild);
        }
    }
    
    public void w(final long n, final DefaultMutableTreeNode defaultMutableTreeNode) {
        final int numZoneChildren = StateManager.getNumZoneChildren(n);
        if (numZoneChildren < 30) {
            for (int i = 0; i < numZoneChildren; ++i) {
                final long zoneChildAtIndex = StateManager.getZoneChildAtIndex(n, i);
                final A213 userObject = new A213(this, zoneChildAtIndex);
                final DefaultMutableTreeNode newChild = new DefaultMutableTreeNode(userObject);
                defaultMutableTreeNode.add(newChild);
                if (!userObject.d.equals("@Scripting_n::luaProtectedCall") && !userObject.d.equals("XElementQueue")) {
                    this.w(zoneChildAtIndex, newChild);
                }
            }
        }
    }
    
    static void m(final RuntimeTool runtimeTool, final MouseEvent mouseEvent) {
        final TreePath pathForLocation = runtimeTool.b.getPathForLocation(mouseEvent.getX(), mouseEvent.getY());
        if (pathForLocation != null) {
            final DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode)pathForLocation.getLastPathComponent();
            runtimeTool.i.setText(pathForLocation.toString());
            runtimeTool.at = ((R212)defaultMutableTreeNode.getUserObject()).g;
        }
        else {
            runtimeTool.i.setText("");
        }
        k(runtimeTool);
    }
    
    static void v(final RuntimeTool runtimeTool) {
        while (true) {
            try {
                while (true) {
                    Thread.sleep(2000L);
                }
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
                continue;
            }
            break;
        }
    }
    
    void y() {
        this.p.setLayout(new GridLayout(10, 1));
        this.v = new JTabbedPane();
        this.am = new JScrollPane(this.b);
        this.r = Box.createVerticalBox();
        (this.w = new JSplitPane(1, this.am, this.r)).setDividerLocation(250);
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
        final JMenuBar jMenuBar = new JMenuBar();
        final JMenu c = new JMenu("File");
        c.setMnemonic(70);
        c.getAccessibleContext().setAccessibleDescription("Danny thinks you are cool!");
        jMenuBar.add(c);
        final JMenuItem menuItem = new JMenuItem("Reload states", 82);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(82, 8));
        menuItem.getAccessibleContext().setAccessibleDescription("Reloads all states from the xml files");
        menuItem.addActionListener(new J217(this));
        c.add(menuItem);
        final JMenuItem menuItem2 = new JMenuItem("Refresh hierarchy", 72);
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(72, 8));
        menuItem2.getAccessibleContext().setAccessibleDescription("Reloads all states from the xml files");
        menuItem2.addActionListener(new O218(this));
        c.add(menuItem2);
        this.setJMenuBar(jMenuBar);
        final JPanel comp = new JPanel(new FlowLayout());
        comp.add(new JLabel("Send Event"));
        (this.as = new JTextField(64)).setMinimumSize(new Dimension(32, 32));
        this.as.addActionListener(new E219(this));
        comp.add(this.as);
        this.r.setAlignmentY(0.0f);
        this.r.setAlignmentX(0.0f);
        this.r.setAlignmentY(0.0f);
        this.r.setAlignmentX(0.0f);
        this.w.setAlignmentY(0.0f);
        this.w.setAlignmentX(0.0f);
        this.r.add(this.i);
        this.r.add(comp);
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
    void addTextField(final String text, final int j, final String s, final String s2, final boolean q) {
        final JPanel comp = new JPanel(new FlowLayout());
        comp.add(new JLabel(text));
        final N220 e = new N220(text, s, s2);
        e.j = j;
        e.q = q;
        this.ac.add(e);
        comp.add(e.s);
        this.p.add(comp);
    }
    
    private String x() {
        final String[][] j = Z132.j();
        final StringBuffer sb = new StringBuffer(j.length * 16);
        for (int i = 0; i < 4; ++i) {
            sb.append(D222.d[i] + "\t");
        }
        sb.append("\n");
        for (int k = 0; k < j.length; ++k) {
            for (int l = 0; l < 4; ++l) {
                sb.append(j[k][l] + "\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    void z(final String[][] rowData, final String[] columnNames) {
        this.n.removeAll();
        this.n.setLayout(new GridLayout(1, 1));
        final JTable view = new JTable(rowData, columnNames);
        view.enableInputMethods(false);
        this.n.add(new JScrollPane(view));
        this.m.repaint();
        this.m.revalidate();
    }
    
    private void t() {
        this.m = new JSplitPane(0);
        this.k = new JButton("TimedEvents");
        final JPanel comp = new JPanel(new GridLayout(3, 3));
        comp.add(this.k);
        this.k.addActionListener(new L223(this));
        this.m.add(comp);
        this.n = new JPanel(new FlowLayout());
        this.z(new String[30][4], new String[] { "HEADER1", "HEADER2", "HEADER3", "HEADER4" });
        this.m.add(this.n);
    }
    
    static void i(final RuntimeTool runtimeTool, final String s) {
        StateManager.callStateCommand(runtimeTool.at, s);
    }
    
    static {
        logger = LoggerFactory.getLogger(RuntimeTool.class);
        RuntimeTool.h = new ConcurrentLinkedQueue();
    }
    
    @Be2
    @Bs1
    void addButton(final String text) {
        final JButton comp = new JButton(text);
        comp.addActionListener(new W224(this, text));
        this.p.add(comp);
    }
    
    @Be2
    @Bs1
    void addLabel(final String text) {
        this.p.add(new JLabel(text, 2));
    }
    
    @Be2
    @Bs1
    void addBoolTextField(final String text, final String s, final String s2, final boolean q) {
        final JPanel comp = new JPanel(new FlowLayout());
        comp.add(new JLabel(text));
        final N220 e = new N220(text, s, s2);
        e.j = 0;
        e.q = q;
        this.ac.add(e);
        comp.add(e.s);
        final JButton comp2 = new JButton("Toggle");
        comp2.addActionListener(new K225(this));
        comp.add(comp2);
        this.p.add(comp);
    }
    
    static void p(final RuntimeTool runtimeTool) {
        runtimeTool.l.setAlignmentY(0.0f);
        runtimeTool.l.setAlignmentX(0.0f);
        runtimeTool.v.addTab("Profiling", runtimeTool.l);
    }
    
    @Be2
    @Bs1
    void addFloatTextField(final String s, final String s2, final String s3, final boolean b) {
        this.addTextField(s, 2, s2, s3, b);
    }
    
    @Be2
    @Bs1
    void addStringTextField(final String s, final String s2, final String s3, final boolean b) {
        this.addTextField(s, 3, s2, s3, b);
    }
    
    public static final native void createRuntimeTool(final Object p0);
    
    private void u() {
        this.u = new JSplitPane(0);
        (this.z = new JTextArea(1, 10)).setEditable(false);
        this.t = new JButton("DumpTimedEvents");
        final JPanel comp = new JPanel(new GridLayout(3, 3));
        final JPanel comp2 = new JPanel(new GridLayout(1, 1));
        final JScrollPane comp3 = new JScrollPane(this.z, 22, 30);
        comp.add(this.t);
        this.t.addActionListener(new S226(this));
        comp2.add(comp3);
        this.u.add(comp);
        this.u.add(comp2);
    }
    
    @Be2
    @Bs1
    void deactivateState(final String s) {
        this.b.invalidate();
    }
    
    static void r(final RuntimeTool runtimeTool) {
        StateManager.callStateCommand(StateManager.g, "Reload");
    Label_0009_Outer:
        while (true) {
            while (true) {
                try {
                    while (true) {
                        Thread.sleep(2000L);
                    }
                }
                catch (InterruptedException ex) {
                    ex.printStackTrace();
                    continue Label_0009_Outer;
                }
                continue;
            }
        }
    }
    
    @Be2
    @Bs1
    void addIntTextField(final String s, final String s2, final String s3, final boolean b) {
        this.addTextField(s, 1, s2, s3, b);
    }
    
    static void n(final RuntimeTool runtimeTool) {
        for (int i = 0; i < runtimeTool.ac.size(); ++i) {
            ((H221)runtimeTool.ac.elementAt(i)).g = runtimeTool.at;
            ((H221)runtimeTool.ac.elementAt(i)).g();
        }
    }
    
    @Be2
    @Bs1
    void addMatrix(final String s, final boolean q) {
        final Y227 e = new Y227(s);
        e.q = q;
        this.p.add(e.j);
        this.ac.add(e);
    }
    
    public static final native void refreshWidgets(final long p0);
}
