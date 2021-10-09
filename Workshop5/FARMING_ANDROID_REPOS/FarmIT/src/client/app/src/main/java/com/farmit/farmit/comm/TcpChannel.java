package com.farmit.farmit.comm;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

class TcpChannel implements Runnable {
    private static String TAG = TcpChannel.class.getSimpleName();
    private static final String SERVER_ADDR = "10.0.0.89";
    private static final int PORT = 7777;

    private PrintWriter writebuf;
    private BufferedReader readbuf;
    private boolean alive = false;

    Socket socket;
    SocketAddress serverAddr;

    public void sendMessage(String msg) {
        Log.d(TAG, msg);
        if (writebuf != null && !writebuf.checkError()) {
            writebuf.println(msg);
            writebuf.flush();
            Log.d(TAG, msg);
        }
    }

    @Override
    public void run() {
        try {
            Log.d(TAG, "running thread : before ");
            // serverAddr = InetAddress.getByName(SERVER_ADDR);
            serverAddr = new InetSocketAddress(SERVER_ADDR, PORT);
            socket = new Socket();

            Log.d(TAG, "running thread : connect to server");

            try {
                socket.connect(serverAddr, 0);
                Log.d(TAG, "connected to server");
                writebuf = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                readbuf = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while (alive) {
                    String msg = readbuf.readLine();
                    Log.d(TAG, msg);
                }
            }
            catch (Exception e) {
                Log.e("TCP", "S: Error", e);
            } finally {
                Log.d(TAG, "socket closed");
                 socket.close();
            }
        } catch (Exception e) {
            Log.e("TCP", "C: Error", e);
        }

        Log.d(TAG, "exiting from run");

    }

    public void close() {
        try {
            alive = false;

            if (writebuf != null) {
                writebuf.flush();
                writebuf.close();
            }

            readbuf = null;
            writebuf = null;

            socket.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
