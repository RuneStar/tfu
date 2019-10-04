// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public class Fr156 extends Ln265
{
    public static final int aa = 0;
    public static final int ag = 3;
    public static final int ap = 0;
    public static final int aq = 4;
    public static final int c = 2;
    private static final boolean d = false;
    public static final int e = 2;
    public static final int f = 1;
    private static final boolean g = true;
    public static final int h = 3;
    public static final int i = 22;
    public static final int j = 1;
    public static final int k = 21;
    public static final int m = 9;
    public static final int n = 20;
    public static final int o = 23;
    public static final int p = 4;
    private static final int q = 6;
    public static final int r = 1;
    public static final int s = 4;
    public static final int t = 8;
    public static final int u = 6;
    public static final int v = 2;
    public static final int w = 0;
    public static final int x = 5;
    public static final int y = 3;
    public static final int z = 7;
    public int a;
    public String ab;
    public String ac;
    public int ad;
    public int af;
    public int ah;
    public int ai;
    public String aj;
    public String ak;
    public int al;
    public int am;
    public int an;
    public int ao;
    public int ar;
    public String as;
    public String at;
    public int au;
    public int av;
    public int aw;
    public int ax;
    public int[] ay;
    public boolean az;
    public int b;
    public boolean l;
    
    public Fr156() {
        this.ay = new int[3];
    }
    
    public static void d(final Fr156 fr156, final Gg3 gg3) {
        Gg3.k(gg3, 6);
        Gg3.k(gg3, fr156.b);
        Gg3.k(gg3, fr156.l ? 1 : 0);
        Gg3.k(gg3, fr156.a);
        Gg3.k(gg3, fr156.ai);
        Gg3.k(gg3, fr156.al);
        Gg3.k(gg3, fr156.af);
        Gg3.k(gg3, fr156.av);
        Gg3.k(gg3, fr156.az ? 1 : 0);
        Gg3.i(gg3, fr156.ah);
        Gg3.k(gg3, fr156.ao);
        Gg3.o(gg3, fr156.an);
        Gg3.i(gg3, fr156.am);
        gg3.ap(fr156.as);
        gg3.ap(fr156.ac);
        gg3.ap(fr156.at);
        gg3.ap(fr156.ab);
        Gg3.k(gg3, fr156.ar);
        Gg3.i(gg3, fr156.aw);
        gg3.ap(fr156.aj);
        gg3.ap(fr156.ak);
        Gg3.k(gg3, fr156.ax);
        Gg3.k(gg3, fr156.au);
        for (int i = 0; i < fr156.ay.length; ++i) {
            Gg3.a(gg3, fr156.ay[i]);
        }
        Gg3.a(gg3, fr156.ad);
    }
    
    public Fr156(final Gg3 gg3) {
        this.ay = new int[3];
        final int ar = Gg3.ar(gg3);
        if (ar > 6) {
            throw new RuntimeException("Invalid userstats version: " + ar);
        }
        this.b = Gg3.ar(gg3);
        this.l = (Gg3.ar(gg3) == 1);
        if (ar > 2) {
            this.a = Gg3.ar(gg3);
        }
        this.ai = Gg3.ar(gg3);
        this.al = Gg3.ar(gg3);
        this.af = Gg3.ar(gg3);
        if (ar > 1) {
            this.av = Gg3.ar(gg3);
        }
        this.az = (Gg3.ar(gg3) == 1);
        this.ah = Gg3.au(gg3);
        this.ao = Gg3.ar(gg3);
        this.an = Gg3.ay(gg3);
        if (ar == 3) {
            Gg3.bd(gg3);
        }
        if (ar > 3) {
            this.am = Gg3.au(gg3);
            if (ar <= 5) {
                Gg3.ar(gg3);
                Gg3.ar(gg3);
                Gg3.ar(gg3);
            }
            this.as = gg3.bh();
            this.ac = gg3.bh();
            this.at = gg3.bh();
            this.ab = gg3.bh();
            this.ar = Gg3.ar(gg3);
            this.aw = Gg3.au(gg3);
        }
        else {
            final String s = "";
            this.ab = s;
            this.at = s;
            this.ac = s;
            this.as = s;
        }
        if (ar > 5) {
            this.aj = gg3.bh();
            this.ak = gg3.bh();
            this.ax = Gg3.ar(gg3);
            this.au = Gg3.ar(gg3);
            for (int i = 0; i < this.ay.length; ++i) {
                this.ay[i] = Gg3.bd(gg3);
            }
            this.ad = Gg3.bd(gg3);
        }
        else {
            final String s2 = "";
            this.ak = s2;
            this.aj = s2;
        }
        g(this);
    }
    
    private static void g(final Fr156 fr156) {
        if (fr156.as.length() > 40) {
            fr156.as = fr156.as.substring(0, 40);
        }
        if (fr156.ac.length() > 40) {
            fr156.ac = fr156.ac.substring(0, 40);
        }
        if (fr156.at.length() > 10) {
            fr156.at = fr156.at.substring(0, 10);
        }
        if (fr156.ab.length() > 10) {
            fr156.ab = fr156.ab.substring(0, 10);
        }
    }
    
    public Fr156(final boolean p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   tfu/Ln265.<init>:()V
        //     4: aload_0        
        //     5: iconst_3       
        //     6: newarray        I
        //     8: putfield        tfu/Fr156.ay:[I
        //    11: iload_1        
        //    12: ifeq            1502
        //    15: getstatic       tfu/Dl463.bc:Ljava/lang/String;
        //    18: ldc             "win"
        //    20: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    23: ifeq            34
        //    26: aload_0        
        //    27: iconst_1       
        //    28: putfield        tfu/Fr156.b:I
        //    31: goto            77
        //    34: getstatic       tfu/Dl463.bc:Ljava/lang/String;
        //    37: ldc             "mac"
        //    39: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    42: ifeq            53
        //    45: aload_0        
        //    46: iconst_2       
        //    47: putfield        tfu/Fr156.b:I
        //    50: goto            77
        //    53: getstatic       tfu/Dl463.bc:Ljava/lang/String;
        //    56: ldc             "linux"
        //    58: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    61: ifeq            72
        //    64: aload_0        
        //    65: iconst_3       
        //    66: putfield        tfu/Fr156.b:I
        //    69: goto            77
        //    72: aload_0        
        //    73: iconst_4       
        //    74: putfield        tfu/Fr156.b:I
        //    77: getstatic       tfu/Dl463.bs:Ljava/lang/String;
        //    80: ldc             "amd64"
        //    82: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    85: ifne            99
        //    88: getstatic       tfu/Dl463.bs:Ljava/lang/String;
        //    91: ldc             "x86_64"
        //    93: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //    96: ifeq            107
        //    99: aload_0        
        //   100: iconst_1       
        //   101: putfield        tfu/Fr156.l:Z
        //   104: goto            112
        //   107: aload_0        
        //   108: iconst_0       
        //   109: putfield        tfu/Fr156.l:Z
        //   112: aload_0        
        //   113: getfield        tfu/Fr156.b:I
        //   116: iconst_1       
        //   117: if_icmpne       304
        //   120: getstatic       tfu/Dl463.cw:Ljava/lang/String;
        //   123: ldc             "4.0"
        //   125: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   128: iconst_m1      
        //   129: if_icmpeq       140
        //   132: aload_0        
        //   133: iconst_1       
        //   134: putfield        tfu/Fr156.a:I
        //   137: goto            393
        //   140: getstatic       tfu/Dl463.cw:Ljava/lang/String;
        //   143: ldc             "4.1"
        //   145: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   148: iconst_m1      
        //   149: if_icmpeq       160
        //   152: aload_0        
        //   153: iconst_2       
        //   154: putfield        tfu/Fr156.a:I
        //   157: goto            393
        //   160: getstatic       tfu/Dl463.cw:Ljava/lang/String;
        //   163: ldc             "4.9"
        //   165: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   168: iconst_m1      
        //   169: if_icmpeq       180
        //   172: aload_0        
        //   173: iconst_3       
        //   174: putfield        tfu/Fr156.a:I
        //   177: goto            393
        //   180: getstatic       tfu/Dl463.cw:Ljava/lang/String;
        //   183: ldc             "5.0"
        //   185: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   188: iconst_m1      
        //   189: if_icmpeq       200
        //   192: aload_0        
        //   193: iconst_4       
        //   194: putfield        tfu/Fr156.a:I
        //   197: goto            393
        //   200: getstatic       tfu/Dl463.cw:Ljava/lang/String;
        //   203: ldc             "5.1"
        //   205: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   208: iconst_m1      
        //   209: if_icmpeq       220
        //   212: aload_0        
        //   213: iconst_5       
        //   214: putfield        tfu/Fr156.a:I
        //   217: goto            393
        //   220: getstatic       tfu/Dl463.cw:Ljava/lang/String;
        //   223: ldc             "5.2"
        //   225: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   228: iconst_m1      
        //   229: if_icmpeq       241
        //   232: aload_0        
        //   233: bipush          8
        //   235: putfield        tfu/Fr156.a:I
        //   238: goto            393
        //   241: getstatic       tfu/Dl463.cw:Ljava/lang/String;
        //   244: ldc             "6.0"
        //   246: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   249: iconst_m1      
        //   250: if_icmpeq       262
        //   253: aload_0        
        //   254: bipush          6
        //   256: putfield        tfu/Fr156.a:I
        //   259: goto            393
        //   262: getstatic       tfu/Dl463.cw:Ljava/lang/String;
        //   265: ldc             "6.1"
        //   267: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   270: iconst_m1      
        //   271: if_icmpeq       283
        //   274: aload_0        
        //   275: bipush          7
        //   277: putfield        tfu/Fr156.a:I
        //   280: goto            393
        //   283: getstatic       tfu/Dl463.cw:Ljava/lang/String;
        //   286: ldc             "6.2"
        //   288: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   291: iconst_m1      
        //   292: if_icmpeq       393
        //   295: aload_0        
        //   296: bipush          9
        //   298: putfield        tfu/Fr156.a:I
        //   301: goto            393
        //   304: aload_0        
        //   305: getfield        tfu/Fr156.b:I
        //   308: iconst_2       
        //   309: if_icmpne       393
        //   312: getstatic       tfu/Dl463.cw:Ljava/lang/String;
        //   315: ldc             "10.4"
        //   317: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   320: iconst_m1      
        //   321: if_icmpeq       333
        //   324: aload_0        
        //   325: bipush          20
        //   327: putfield        tfu/Fr156.a:I
        //   330: goto            393
        //   333: getstatic       tfu/Dl463.cw:Ljava/lang/String;
        //   336: ldc             "10.5"
        //   338: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   341: iconst_m1      
        //   342: if_icmpeq       354
        //   345: aload_0        
        //   346: bipush          21
        //   348: putfield        tfu/Fr156.a:I
        //   351: goto            393
        //   354: getstatic       tfu/Dl463.cw:Ljava/lang/String;
        //   357: ldc             "10.6"
        //   359: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   362: iconst_m1      
        //   363: if_icmpeq       375
        //   366: aload_0        
        //   367: bipush          22
        //   369: putfield        tfu/Fr156.a:I
        //   372: goto            393
        //   375: getstatic       tfu/Dl463.cw:Ljava/lang/String;
        //   378: ldc             "10.7"
        //   380: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   383: iconst_m1      
        //   384: if_icmpeq       393
        //   387: aload_0        
        //   388: bipush          23
        //   390: putfield        tfu/Fr156.a:I
        //   393: getstatic       tfu/Dl463.bt:Ljava/lang/String;
        //   396: invokevirtual   java/lang/String.toLowerCase:()Ljava/lang/String;
        //   399: ldc_w           "sun"
        //   402: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   405: iconst_m1      
        //   406: if_icmpeq       417
        //   409: aload_0        
        //   410: iconst_1       
        //   411: putfield        tfu/Fr156.ai:I
        //   414: goto            470
        //   417: getstatic       tfu/Dl463.bt:Ljava/lang/String;
        //   420: invokevirtual   java/lang/String.toLowerCase:()Ljava/lang/String;
        //   423: ldc_w           "microsoft"
        //   426: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   429: iconst_m1      
        //   430: if_icmpeq       441
        //   433: aload_0        
        //   434: iconst_2       
        //   435: putfield        tfu/Fr156.ai:I
        //   438: goto            470
        //   441: getstatic       tfu/Dl463.bt:Ljava/lang/String;
        //   444: invokevirtual   java/lang/String.toLowerCase:()Ljava/lang/String;
        //   447: ldc_w           "apple"
        //   450: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   453: iconst_m1      
        //   454: if_icmpeq       465
        //   457: aload_0        
        //   458: iconst_3       
        //   459: putfield        tfu/Fr156.ai:I
        //   462: goto            470
        //   465: aload_0        
        //   466: iconst_4       
        //   467: putfield        tfu/Fr156.ai:I
        //   470: iconst_2       
        //   471: istore_2       
        //   472: iconst_0       
        //   473: istore_3       
        //   474: iload_2        
        //   475: getstatic       tfu/Dl463.bz:Ljava/lang/String;
        //   478: invokevirtual   java/lang/String.length:()I
        //   481: if_icmpge       524
        //   484: getstatic       tfu/Dl463.bz:Ljava/lang/String;
        //   487: iload_2        
        //   488: invokevirtual   java/lang/String.charAt:(I)C
        //   491: istore          4
        //   493: iload           4
        //   495: bipush          48
        //   497: if_icmplt       524
        //   500: iload           4
        //   502: bipush          57
        //   504: if_icmpgt       524
        //   507: iload_3        
        //   508: bipush          10
        //   510: imul           
        //   511: iload           4
        //   513: bipush          48
        //   515: isub           
        //   516: iadd           
        //   517: istore_3       
        //   518: iinc            2, 1
        //   521: goto            474
        //   524: goto            529
        //   527: astore          4
        //   529: aload_0        
        //   530: iload_3        
        //   531: putfield        tfu/Fr156.al:I
        //   534: getstatic       tfu/Dl463.bz:Ljava/lang/String;
        //   537: bipush          46
        //   539: iconst_2       
        //   540: invokevirtual   java/lang/String.indexOf:(II)I
        //   543: iconst_1       
        //   544: iadd           
        //   545: istore_2       
        //   546: iconst_0       
        //   547: istore_3       
        //   548: iload_2        
        //   549: getstatic       tfu/Dl463.bz:Ljava/lang/String;
        //   552: invokevirtual   java/lang/String.length:()I
        //   555: if_icmpge       598
        //   558: getstatic       tfu/Dl463.bz:Ljava/lang/String;
        //   561: iload_2        
        //   562: invokevirtual   java/lang/String.charAt:(I)C
        //   565: istore          4
        //   567: iload           4
        //   569: bipush          48
        //   571: if_icmplt       598
        //   574: iload           4
        //   576: bipush          57
        //   578: if_icmpgt       598
        //   581: iload_3        
        //   582: bipush          10
        //   584: imul           
        //   585: iload           4
        //   587: bipush          48
        //   589: isub           
        //   590: iadd           
        //   591: istore_3       
        //   592: iinc            2, 1
        //   595: goto            548
        //   598: goto            603
        //   601: astore          4
        //   603: aload_0        
        //   604: iload_3        
        //   605: putfield        tfu/Fr156.af:I
        //   608: getstatic       tfu/Dl463.bz:Ljava/lang/String;
        //   611: bipush          95
        //   613: iconst_4       
        //   614: invokevirtual   java/lang/String.indexOf:(II)I
        //   617: iconst_1       
        //   618: iadd           
        //   619: istore_2       
        //   620: iconst_0       
        //   621: istore_3       
        //   622: iload_2        
        //   623: getstatic       tfu/Dl463.bz:Ljava/lang/String;
        //   626: invokevirtual   java/lang/String.length:()I
        //   629: if_icmpge       672
        //   632: getstatic       tfu/Dl463.bz:Ljava/lang/String;
        //   635: iload_2        
        //   636: invokevirtual   java/lang/String.charAt:(I)C
        //   639: istore          4
        //   641: iload           4
        //   643: bipush          48
        //   645: if_icmplt       672
        //   648: iload           4
        //   650: bipush          57
        //   652: if_icmpgt       672
        //   655: iload_3        
        //   656: bipush          10
        //   658: imul           
        //   659: iload           4
        //   661: bipush          48
        //   663: isub           
        //   664: iadd           
        //   665: istore_3       
        //   666: iinc            2, 1
        //   669: goto            622
        //   672: goto            677
        //   675: astore          4
        //   677: aload_0        
        //   678: iload_3        
        //   679: putfield        tfu/Fr156.av:I
        //   682: aload_0        
        //   683: iconst_0       
        //   684: putfield        tfu/Fr156.az:Z
        //   687: aload_0        
        //   688: getstatic       tfu/Dl463.bb:I
        //   691: putfield        tfu/Fr156.ah:I
        //   694: aload_0        
        //   695: getfield        tfu/Fr156.al:I
        //   698: iconst_3       
        //   699: if_icmple       712
        //   702: aload_0        
        //   703: getstatic       tfu/Dl463.ba:I
        //   706: putfield        tfu/Fr156.ao:I
        //   709: goto            717
        //   712: aload_0        
        //   713: iconst_0       
        //   714: putfield        tfu/Fr156.ao:I
        //   717: invokestatic    jaclib/hardware_info/HardwareInfo.getCPUInfo:()[I
        //   720: astore          4
        //   722: aload           4
        //   724: ifnull          758
        //   727: aload           4
        //   729: arraylength    
        //   730: iconst_3       
        //   731: if_icmpne       758
        //   734: aload_0        
        //   735: aload           4
        //   737: iconst_0       
        //   738: iaload         
        //   739: putfield        tfu/Fr156.ax:I
        //   742: aload_0        
        //   743: aload           4
        //   745: iconst_1       
        //   746: iaload         
        //   747: putfield        tfu/Fr156.am:I
        //   750: aload_0        
        //   751: aload           4
        //   753: iconst_2       
        //   754: iaload         
        //   755: putfield        tfu/Fr156.an:I
        //   758: invokestatic    jaclib/hardware_info/HardwareInfo.getRawCPUInfo:()[I
        //   761: astore          5
        //   763: aload           5
        //   765: ifnull          1167
        //   768: aload           5
        //   770: arraylength    
        //   771: iconst_5       
        //   772: new             Ljava/util/HashMap;
        //   775: dup            
        //   776: invokespecial   java/util/HashMap.<init>:()V
        //   779: astore          6
        //   781: iconst_0       
        //   782: istore          7
        //   784: iload           7
        //   786: aload           5
        //   788: arraylength    
        //   789: iconst_5       
        //   790: idiv           
        //   791: if_icmpge       885
        //   794: aload           5
        //   796: iload           7
        //   798: iconst_5       
        //   799: imul           
        //   800: iaload         
        //   801: istore          8
        //   803: aload           5
        //   805: iload           7
        //   807: iconst_5       
        //   808: imul           
        //   809: iconst_1       
        //   810: iadd           
        //   811: iaload         
        //   812: istore          9
        //   814: aload           5
        //   816: iload           7
        //   818: iconst_5       
        //   819: imul           
        //   820: iconst_2       
        //   821: iadd           
        //   822: iaload         
        //   823: istore          10
        //   825: aload           5
        //   827: iload           7
        //   829: iconst_5       
        //   830: imul           
        //   831: iconst_3       
        //   832: iadd           
        //   833: iaload         
        //   834: istore          11
        //   836: aload           5
        //   838: iload           7
        //   840: iconst_5       
        //   841: imul           
        //   842: iconst_4       
        //   843: iadd           
        //   844: iaload         
        //   845: istore          12
        //   847: new             Ltfu/Ft464;
        //   850: dup            
        //   851: iload           8
        //   853: iload           9
        //   855: iload           10
        //   857: iload           11
        //   859: iload           12
        //   861: invokespecial   tfu/Ft464.<init>:(IIIII)V
        //   864: astore          13
        //   866: aload           6
        //   868: iload           8
        //   870: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   873: aload           13
        //   875: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   878: pop            
        //   879: iinc            7, 1
        //   882: goto            784
        //   885: aload           6
        //   887: iconst_0       
        //   888: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   891: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   894: checkcast       Ltfu/Ft464;
        //   897: astore          7
        //   899: aload           7
        //   901: ifnull          960
        //   904: new             Ltfu/Gg3;
        //   907: dup            
        //   908: bipush          13
        //   910: invokespecial   tfu/Gg3.<init>:(I)V
        //   913: astore          8
        //   915: aload           8
        //   917: aload           7
        //   919: getfield        tfu/Ft464.q:I
        //   922: invokestatic    tfu/Gg3.f:(Ltfu/Gg3;I)V
        //   925: aload           8
        //   927: aload           7
        //   929: getfield        tfu/Ft464.e:I
        //   932: invokestatic    tfu/Gg3.f:(Ltfu/Gg3;I)V
        //   935: aload           8
        //   937: aload           7
        //   939: getfield        tfu/Ft464.j:I
        //   942: invokestatic    tfu/Gg3.f:(Ltfu/Gg3;I)V
        //   945: aload           8
        //   947: iconst_0       
        //   948: putfield        tfu/Gg3.v:I
        //   951: aload_0        
        //   952: aload           8
        //   954: invokestatic    tfu/Gg3.bk:(Ltfu/Gg3;)Ljava/lang/String;
        //   957: putfield        tfu/Fr156.aj:Ljava/lang/String;
        //   960: aload           6
        //   962: iconst_1       
        //   963: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   966: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   969: checkcast       Ltfu/Ft464;
        //   972: astore          8
        //   974: aload           8
        //   976: ifnull          1030
        //   979: aload_0        
        //   980: aload           8
        //   982: getfield        tfu/Ft464.d:I
        //   985: putfield        tfu/Fr156.ad:I
        //   988: aload           8
        //   990: getfield        tfu/Ft464.q:I
        //   993: istore          9
        //   995: aload_0        
        //   996: iload           9
        //   998: bipush          16
        //  1000: ishr           
        //  1001: sipush          255
        //  1004: iand           
        //  1005: putfield        tfu/Fr156.au:I
        //  1008: aload_0        
        //  1009: getfield        tfu/Fr156.ay:[I
        //  1012: iconst_0       
        //  1013: aload           8
        //  1015: getfield        tfu/Ft464.j:I
        //  1018: iastore        
        //  1019: aload_0        
        //  1020: getfield        tfu/Fr156.ay:[I
        //  1023: iconst_1       
        //  1024: aload           8
        //  1026: getfield        tfu/Ft464.e:I
        //  1029: iastore        
        //  1030: aload           6
        //  1032: ldc_w           -2147483647
        //  1035: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  1038: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1041: checkcast       Ltfu/Ft464;
        //  1044: astore          9
        //  1046: aload           9
        //  1048: ifnull          1062
        //  1051: aload_0        
        //  1052: getfield        tfu/Fr156.ay:[I
        //  1055: iconst_2       
        //  1056: aload           9
        //  1058: getfield        tfu/Ft464.e:I
        //  1061: iastore        
        //  1062: new             Ltfu/Gg3;
        //  1065: dup            
        //  1066: bipush          49
        //  1068: invokespecial   tfu/Gg3.<init>:(I)V
        //  1071: astore          10
        //  1073: ldc_w           -2147483646
        //  1076: istore          11
        //  1078: iload           11
        //  1080: ldc_w           -2147483644
        //  1083: if_icmpgt       1152
        //  1086: aload           6
        //  1088: iload           11
        //  1090: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //  1093: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //  1096: checkcast       Ltfu/Ft464;
        //  1099: astore          12
        //  1101: aload           12
        //  1103: ifnull          1146
        //  1106: aload           10
        //  1108: aload           12
        //  1110: getfield        tfu/Ft464.d:I
        //  1113: invokestatic    tfu/Gg3.f:(Ltfu/Gg3;I)V
        //  1116: aload           10
        //  1118: aload           12
        //  1120: getfield        tfu/Ft464.q:I
        //  1123: invokestatic    tfu/Gg3.f:(Ltfu/Gg3;I)V
        //  1126: aload           10
        //  1128: aload           12
        //  1130: getfield        tfu/Ft464.j:I
        //  1133: invokestatic    tfu/Gg3.f:(Ltfu/Gg3;I)V
        //  1136: aload           10
        //  1138: aload           12
        //  1140: getfield        tfu/Ft464.e:I
        //  1143: invokestatic    tfu/Gg3.f:(Ltfu/Gg3;I)V
        //  1146: iinc            11, 1
        //  1149: goto            1078
        //  1152: aload           10
        //  1154: iconst_0       
        //  1155: putfield        tfu/Gg3.v:I
        //  1158: aload_0        
        //  1159: aload           10
        //  1161: invokestatic    tfu/Gg3.bk:(Ltfu/Gg3;)Ljava/lang/String;
        //  1164: putfield        tfu/Fr156.ak:Ljava/lang/String;
        //  1167: invokestatic    jaclib/hardware_info/HardwareInfo.getDXDiagDisplayDevicesProps:()[[Ljava/lang/String;
        //  1170: astore          6
        //  1172: aload           6
        //  1174: ifnull          1338
        //  1177: aload           6
        //  1179: arraylength    
        //  1180: ifle            1338
        //  1183: aload           6
        //  1185: iconst_0       
        //  1186: aaload         
        //  1187: ifnull          1338
        //  1190: iconst_0       
        //  1191: istore          7
        //  1193: iload           7
        //  1195: aload           6
        //  1197: iconst_0       
        //  1198: aaload         
        //  1199: arraylength    
        //  1200: if_icmpge       1338
        //  1203: aload           6
        //  1205: iconst_0       
        //  1206: aaload         
        //  1207: iload           7
        //  1209: aaload         
        //  1210: ldc_w           "szDescription"
        //  1213: invokevirtual   java/lang/String.equalsIgnoreCase:(Ljava/lang/String;)Z
        //  1216: ifeq            1235
        //  1219: aload_0        
        //  1220: aload           6
        //  1222: iconst_0       
        //  1223: aaload         
        //  1224: iload           7
        //  1226: iconst_1       
        //  1227: iadd           
        //  1228: aaload         
        //  1229: putfield        tfu/Fr156.as:Ljava/lang/String;
        //  1232: goto            1332
        //  1235: aload           6
        //  1237: iconst_0       
        //  1238: aaload         
        //  1239: iload           7
        //  1241: aaload         
        //  1242: ldc_w           "szDriverDateEnglish"
        //  1245: invokevirtual   java/lang/String.equalsIgnoreCase:(Ljava/lang/String;)Z
        //  1248: ifeq            1332
        //  1251: aload           6
        //  1253: iconst_0       
        //  1254: aaload         
        //  1255: iload           7
        //  1257: iconst_1       
        //  1258: iadd           
        //  1259: aaload         
        //  1260: astore          8
        //  1262: aload           8
        //  1264: ldc_w           "/"
        //  1267: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //  1270: istore          9
        //  1272: aload           8
        //  1274: ldc_w           "/"
        //  1277: iload           9
        //  1279: iconst_1       
        //  1280: iadd           
        //  1281: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;I)I
        //  1284: istore          10
        //  1286: aload_0        
        //  1287: aload           8
        //  1289: iconst_0       
        //  1290: iload           9
        //  1292: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //  1295: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //  1298: putfield        tfu/Fr156.ar:I
        //  1301: aload_0        
        //  1302: aload           8
        //  1304: iload           10
        //  1306: iconst_1       
        //  1307: iadd           
        //  1308: aload           8
        //  1310: ldc_w           " "
        //  1313: iload           10
        //  1315: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;I)I
        //  1318: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //  1321: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //  1324: putfield        tfu/Fr156.aw:I
        //  1327: goto            1332
        //  1330: astore          9
        //  1332: iinc            7, 2
        //  1335: goto            1193
        //  1338: invokestatic    jaclib/hardware_info/HardwareInfo.getDXDiagSystemProps:()[Ljava/lang/String;
        //  1341: astore          7
        //  1343: aload           7
        //  1345: ifnull          1487
        //  1348: ldc             ""
        //  1350: astore          8
        //  1352: ldc             ""
        //  1354: astore          9
        //  1356: ldc             ""
        //  1358: astore          10
        //  1360: iconst_0       
        //  1361: istore          11
        //  1363: iload           11
        //  1365: aload           7
        //  1367: arraylength    
        //  1368: if_icmpge       1452
        //  1371: aload           7
        //  1373: iload           11
        //  1375: aaload         
        //  1376: ldc_w           "dwDirectXVersionMajor"
        //  1379: invokevirtual   java/lang/String.equalsIgnoreCase:(Ljava/lang/String;)Z
        //  1382: ifeq            1397
        //  1385: aload           7
        //  1387: iload           11
        //  1389: iconst_1       
        //  1390: iadd           
        //  1391: aaload         
        //  1392: astore          8
        //  1394: goto            1446
        //  1397: aload           7
        //  1399: iload           11
        //  1401: aaload         
        //  1402: ldc_w           "dwDirectXVersionMinor"
        //  1405: invokevirtual   java/lang/String.equalsIgnoreCase:(Ljava/lang/String;)Z
        //  1408: ifeq            1423
        //  1411: aload           7
        //  1413: iload           11
        //  1415: iconst_1       
        //  1416: iadd           
        //  1417: aaload         
        //  1418: astore          9
        //  1420: goto            1446
        //  1423: aload           7
        //  1425: iload           11
        //  1427: aaload         
        //  1428: ldc_w           "dwDirectXVersionLetter"
        //  1431: invokevirtual   java/lang/String.equalsIgnoreCase:(Ljava/lang/String;)Z
        //  1434: ifeq            1446
        //  1437: aload           7
        //  1439: iload           11
        //  1441: iconst_1       
        //  1442: iadd           
        //  1443: aaload         
        //  1444: astore          10
        //  1446: iinc            11, 2
        //  1449: goto            1363
        //  1452: aload_0        
        //  1453: new             Ljava/lang/StringBuilder;
        //  1456: dup            
        //  1457: invokespecial   java/lang/StringBuilder.<init>:()V
        //  1460: aload           8
        //  1462: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1465: ldc_w           "."
        //  1468: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1471: aload           9
        //  1473: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1476: aload           10
        //  1478: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1481: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1484: putfield        tfu/Fr156.at:Ljava/lang/String;
        //  1487: goto            1502
        //  1490: astore          4
        //  1492: aload           4
        //  1494: invokevirtual   java/lang/Throwable.printStackTrace:()V
        //  1497: aload_0        
        //  1498: iconst_0       
        //  1499: putfield        tfu/Fr156.an:I
        //  1502: aload_0        
        //  1503: getfield        tfu/Fr156.as:Ljava/lang/String;
        //  1506: ifnonnull       1515
        //  1509: aload_0        
        //  1510: ldc             ""
        //  1512: putfield        tfu/Fr156.as:Ljava/lang/String;
        //  1515: aload_0        
        //  1516: getfield        tfu/Fr156.ac:Ljava/lang/String;
        //  1519: ifnonnull       1528
        //  1522: aload_0        
        //  1523: ldc             ""
        //  1525: putfield        tfu/Fr156.ac:Ljava/lang/String;
        //  1528: aload_0        
        //  1529: getfield        tfu/Fr156.at:Ljava/lang/String;
        //  1532: ifnonnull       1541
        //  1535: aload_0        
        //  1536: ldc             ""
        //  1538: putfield        tfu/Fr156.at:Ljava/lang/String;
        //  1541: aload_0        
        //  1542: getfield        tfu/Fr156.ab:Ljava/lang/String;
        //  1545: ifnonnull       1554
        //  1548: aload_0        
        //  1549: ldc             ""
        //  1551: putfield        tfu/Fr156.ab:Ljava/lang/String;
        //  1554: aload_0        
        //  1555: getfield        tfu/Fr156.aj:Ljava/lang/String;
        //  1558: ifnonnull       1567
        //  1561: aload_0        
        //  1562: ldc             ""
        //  1564: putfield        tfu/Fr156.aj:Ljava/lang/String;
        //  1567: aload_0        
        //  1568: getfield        tfu/Fr156.ak:Ljava/lang/String;
        //  1571: ifnonnull       1580
        //  1574: aload_0        
        //  1575: ldc             ""
        //  1577: putfield        tfu/Fr156.ak:Ljava/lang/String;
        //  1580: aload_0        
        //  1581: invokestatic    tfu/Fr156.g:(Ltfu/Fr156;)V
        //  1584: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  474    524    527    529    Ljava/lang/Exception;
        //  548    598    601    603    Ljava/lang/Exception;
        //  622    672    675    677    Ljava/lang/Exception;
        //  1262   1327   1330   1332   Ljava/lang/Exception;
        //  717    1487   1490   1502   Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Inconsistent stack size at #1167 (coming from #1164).
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2183)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        //     at org.runestar.tfudeob.MainKt.decompileProcyon(Main.kt:63)
        //     at org.runestar.tfudeob.MainKt.deob(Main.kt:45)
        //     at org.runestar.tfudeob.MainKt.main(Main.kt:11)
        //     at org.runestar.tfudeob.MainKt.main(Main.kt)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static int q(final Fr156 fr156) {
        return 38 + Gg3.av(fr156.as) + Gg3.av(fr156.ac) + Gg3.av(fr156.at) + Gg3.av(fr156.ab) + Gg3.av(fr156.aj) + Gg3.av(fr156.ak);
    }
}
