// 
// Decompiled by Procyon v0.5.36
// 

package rs2.client.login;

enum L606
{
    WAIT_FOR_HOP_BLOCK_DURATION("WAIT_FOR_HOP_BLOCK_DURATION", 7), 
    CONNECT_UDP("CONNECT_UDP", 1), 
    SEND_LOGIN_REQUEST("SEND_LOGIN_REQUEST", 4), 
    DELAY("DELAY", 0), 
    WAIT_FOR_LOGIN_RESPONSE("WAIT_FOR_LOGIN_RESPONSE", 5), 
    WAIT_FOR_CONNECTION_ACK("WAIT_FOR_CONNECTION_ACK", 3), 
    WAIT_FOR_QUEUE_POSITION("WAIT_FOR_QUEUE_POSITION", 8), 
    WAIT_FOR_UDP_LOGIN("WAIT_FOR_UDP_LOGIN", 13), 
    CONNECT_TCP("CONNECT_TCP", 2), 
    WAIT_FOR_LOGIN_DETAILS("WAIT_FOR_LOGIN_DETAILS", 10), 
    WAIT_FOR_SCRIPT_DISALLOW_REASON("WAIT_FOR_SCRIPT_DISALLOW_REASON", 6), 
    WAIT_FOR_PLAYER_PACKET("WAIT_FOR_PLAYER_PACKET", 15), 
    WAIT_FOR_PLAYER_PACKET_LENGTH1("WAIT_FOR_PLAYER_PACKET_LENGTH1", 11), 
    WAIT_FOR_LOGIN_OK_LENGTH("WAIT_FOR_LOGIN_OK_LENGTH", 9), 
    WAIT_FOR_UDP_LOGIN_RECONNECT("WAIT_FOR_UDP_LOGIN_RECONNECT", 14), 
    WAIT_FOR_PLAYER_PACKET_LENGTH2("WAIT_FOR_PLAYER_PACKET_LENGTH2", 12);
    
    private L606(final String name, final int ordinal) {
    }
}
