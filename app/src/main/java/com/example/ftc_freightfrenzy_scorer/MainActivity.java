package com.example.ftc_freightfrenzy_scorer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Vibrator myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        Button buttonNew = findViewById(R.id.button_new);
        Button buttonList = findViewById(R.id.button_list);

        buttonNew.setOnClickListener(v -> {
            myVib.vibrate(20);
            startActivity(new Intent(MainActivity.this, ScorerActivity.class));
        });

        buttonList.setOnClickListener(v -> myVib.vibrate(20));
    }
}