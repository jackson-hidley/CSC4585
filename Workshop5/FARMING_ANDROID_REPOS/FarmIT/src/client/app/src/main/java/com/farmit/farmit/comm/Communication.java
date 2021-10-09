package com.farmit.farmit.comm;

public interface Communication {
    /**
     * Sends the message to the server without blocking the main thread
     * and this interface expects no response from the server.
     * @param msg
     */
    void sendMessage(String msg);

    /**
     * Receives a message from the server.
     * This is a blocking call untill data is received.
     *
     * @return message received from the server
     */
    String receiveMessage();
}
