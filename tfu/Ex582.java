// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

public enum Ex582
{
    CREATE_CHECK_EMAIL("CREATE_CHECK_EMAIL", 7, 28, -2), 
    INIT_JS5REMOTE_CONNECTION("INIT_JS5REMOTE_CONNECTION", 1, 15, 8), 
    REQUEST_WORLDLIST("REQUEST_WORLDLIST", 4, 23, 4), 
    INIT_GAME_CONNECTION("INIT_GAME_CONNECTION", 0, 14, 1), 
    CHECK_WORLD_SUITABILITY("CHECK_WORLD_SUITABILITY", 5, 24, -1), 
    CREATE_ACCOUNT("CREATE_ACCOUNT", 3, 22, -2), 
    INIT_SOCIAL_NETWORK_CONNECTION("INIT_SOCIAL_NETWORK_CONNECTION", 8, 29, -2), 
    GAMELOGIN("GAMELOGIN", 2, 16, -2), 
    SSL_WEBCONNECTION("SSL_WEBCONNECTION", 6, 27, 0);
    
    public static final Ex582[] v;
    public final int r;
    public final int w;
    
    static {
        v = new Ex582[32];
        final Ex582[] values = values();
        for (int i = 0; i < values.length; ++i) {
            Ex582.v[values[i].w] = values[i];
        }
    }
    
    private Ex582(final String name, final int ordinal, final int w, final int r) {
        this.w = w;
        this.r = r;
    }
}
