package com.example.ftc_freightfrenzy_scorer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonNew = findViewById(R.id.button_new);
        Vibrator myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        buttonNew.setOnClickListener(
            v -> {
                myVib.vibrate(20);
            }
        );
    }
}