// copyright (c) 2017 Sunil
package com.farmit.farmit;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.farmit.farmit.comm.CommunicationService;

/**
 * Main Activity defines the starting activity of the FarmIT app.
 *
 */
public class MainActivity extends Activity {

    private static String TAG = MainActivity.class.getSimpleName();
    private CommunicationService comm;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Toast.makeText(MainActivity.this, "Service is connected", Toast.LENGTH_SHORT).show();
            CommunicationService.CommunicationBinder binder = (CommunicationService.CommunicationBinder) iBinder;
            comm = binder.getService();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        Log.d(TAG, "sending message");
                        // comm.sendMessage("Sunil.localhost.6767.");
                        break;
                    }
                }
            }).start();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Toast.makeText(MainActivity.this, "Service is disconnected", Toast.LENGTH_SHORT).show();
        }
    };

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "Got message from server");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent socketService = new Intent(this, CommunicationService.class);
        startService(socketService);
        bindService(socketService, connection, BIND_AUTO_CREATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, new IntentFilter("AuthenticationFilter"));

        TextView register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Starting Register user activity here");
                Intent registerUser = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerUser);
            }
        });

        Button signin = findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Starting video list activity");
                Intent videos = new Intent(MainActivity.this, VideoListActivity.class);
                startActivity(videos);
            }
        });
    }
}
