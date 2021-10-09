// copyright (c) 2017 Sunil
package com.farmit.farmit;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Registration of the new user.
 *
 */
public class RegisterActivity extends Activity {

    private static String TAG = RegisterActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Button signUp = findViewById(R.id.register);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean success = true; // Should be set to false.
                Log.d(TAG, "Registering the user");

                if (success) {
                    // remove click listener
                    view.setOnClickListener(null);
                    finish();
                }
            }
        });
    }
}
