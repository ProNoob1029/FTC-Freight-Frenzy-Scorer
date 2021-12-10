package com.example.ftc_freightfrenzy_scorer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

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
            startActivity(new Intent(MainActivity.this, ScorerActiviy.class));
        });

        buttonList.setOnClickListener(v -> myVib.vibrate(20));
    }
}