package com.example.ftc_freight_frenzy_scorer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ftc_freight_frenzy_scorer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    protected ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Vibrator myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        binding.buttonNew.setOnClickListener(v -> {
            myVib.vibrate(20);
            startActivity(new Intent(MainActivity.this, ScorerActivity.class));
        });

        binding.buttonList.setOnClickListener(v -> {
            myVib.vibrate(20);
            startActivity(new Intent(MainActivity.this, ListActivity.class));
        });
    }
}