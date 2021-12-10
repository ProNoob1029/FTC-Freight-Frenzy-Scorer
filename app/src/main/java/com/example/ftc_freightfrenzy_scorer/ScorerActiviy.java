package com.example.ftc_freightfrenzy_scorer;

import static java.lang.String.format;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class ScorerActiviy extends AppCompatActivity{

    public int autoStorage = 0;
    public int autoHub = 0;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorer);

        Vibrator myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        SwitchCompat switchParked = findViewById(R.id.switch_parked);
        SwitchCompat switchParkedFully = findViewById(R.id.switch_parked_fully);
        TextView textAutoStorage = findViewById(R.id.text_auto_storage);
        TextView textAutoHub = findViewById(R.id.text_auto_hub);
        Button buttonAutoStoragePlus = findViewById(R.id.button_auto_storage_plus);
        Button buttonAutoStorageMinus = findViewById(R.id.button_auto_storage_minus);
        Button buttonAutoHubPlus = findViewById(R.id.button_auto_hub_plus);
        Button buttonAutoHubMinus = findViewById(R.id.button_auto_hub_minus);

        switchParked.setOnClickListener(v -> {
            if(!switchParked.isChecked()){
                switchParkedFully.setVisibility(View.GONE);
                switchParkedFully.setChecked(false);
            }
            else switchParkedFully.setVisibility((View.VISIBLE));
        });

        buttonAutoStoragePlus.setOnClickListener(v -> {
            autoStorage++;
            myVib.vibrate(20);
            textAutoStorage.setText(format("%d", autoStorage));
            //textAutoStorage.setText("" + 1);
        });

        buttonAutoStorageMinus.setOnClickListener(v -> {
            if(autoStorage > 0){
                autoStorage--;
                myVib.vibrate(20);
                textAutoStorage.setText(format("%d", autoStorage));
            }
        });

        buttonAutoHubPlus.setOnClickListener(v -> {
            autoHub++;
            myVib.vibrate(20);
            textAutoHub.setText(format("%d", autoHub));
            //textAutoStorage.setText("" + 1);
        });

        buttonAutoHubMinus.setOnClickListener(v -> {
            if(autoHub > 0){
                autoHub--;
                myVib.vibrate(20);
                textAutoHub.setText(format("%d", autoHub));
            }
        });
    }
}
