/*
 * Decompiled with CFR 0.146.
 */
package tfu;

public enum Ex582 {
    INIT_GAME_CONNECTION(14, 1),
    INIT_JS5REMOTE_CONNECTION(15, 8),
    GAMELOGIN(16, -2),
    CREATE_ACCOUNT(22, -2),
    REQUEST_WORLDLIST(23, 4),
    CHECK_WORLD_SUITABILITY(24, -1),
    SSL_WEBCONNECTION(27, 0),
    CREATE_CHECK_EMAIL(28, -2),
    INIT_SOCIAL_NETWORK_CONNECTION(29, -2);
    
    public static final Ex582[] v;
    public final int r;
    public final int w;

    static {
        v = new Ex582[32];
        Ex582[] arrex582 = Ex582.values();
        for (int i = 0; i < arrex582.length; ++i) {
            Ex582.v[arrex582[i].w] = arrex582[i];
        }
    }

    private Ex582(int n2, int n3) {
        this.w = n2;
        this.r = n3;
    }
}

