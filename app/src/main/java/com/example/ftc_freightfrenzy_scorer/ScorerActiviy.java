package com.example.ftc_freightfrenzy_scorer;

import static java.lang.String.format;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class ScorerActiviy extends AppCompatActivity{

    SwitchCompat switchParkedFullyRef;
    SwitchCompat switchTeamElementsUsedRef;
    public int autoStorage = 0;
    public int autoHub = 0;
    public boolean parkedInStorage = false;
    public boolean parkedInWarehouse = false;
    public boolean parkedFully = false;
    public boolean duckDelivery = false;
    public boolean freightBonus = false;
    public boolean teamElementUsed = false;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorer);

        Vibrator myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        SwitchCompat switchDuckDelivery = findViewById(R.id.switch_duck_delivery);
        SwitchCompat switchFreightBonus = findViewById(R.id.switch_freight_bonus);
        SwitchCompat switchTeamElementUsed = findViewById(R.id.switch_team_element_used);
        switchTeamElementsUsedRef = switchTeamElementUsed;
        SwitchCompat switchParkedInStorage = findViewById(R.id.switch_parked_in_storage);
        SwitchCompat switchParkedInWarehouse = findViewById(R.id.switch_parked_in_warehouse);
        SwitchCompat switchParkedFully = findViewById(R.id.switch_parked_fully);
        switchParkedFullyRef = switchParkedFully;
        TextView textAutoStorage = findViewById(R.id.text_auto_storage);
        TextView textAutoHub = findViewById(R.id.text_auto_hub);
        Button buttonAutoStoragePlus = findViewById(R.id.button_auto_storage_plus);
        Button buttonAutoStorageMinus = findViewById(R.id.button_auto_storage_minus);
        Button buttonAutoHubPlus = findViewById(R.id.button_auto_hub_plus);
        Button buttonAutoHubMinus = findViewById(R.id.button_auto_hub_minus);

        switchParkedInStorage.setOnClickListener(v -> {
            if(!switchParkedInStorage.isChecked()){
                switchParkedFully.setVisibility(View.GONE);
                switchParkedFully.setChecked(false);
                parkedInStorage = false;
            }
            else {
                switchParkedFully.setVisibility((View.VISIBLE));
                parkedInStorage = true;
                parkedInWarehouse = false;
                switchParkedInWarehouse.setChecked(false);
            }
        });

        switchParkedInWarehouse.setOnClickListener(v -> {
            if(!switchParkedInWarehouse.isChecked()){
                switchParkedFully.setVisibility(View.GONE);
                switchParkedFully.setChecked(false);
                parkedInWarehouse = false;
            }
            else {
                switchParkedFully.setVisibility((View.VISIBLE));
                parkedInWarehouse = true;
                parkedInStorage = false;
                switchParkedInStorage.setChecked(false);
            }
        });

        switchFreightBonus.setOnClickListener(v -> {
            if(!switchFreightBonus.isChecked()){
                switchTeamElementUsed.setVisibility(View.GONE);
                switchTeamElementUsed.setChecked(false);
                freightBonus = false;
                teamElementUsed = false;
            }
            else {
                switchTeamElementUsed.setVisibility((View.VISIBLE));
                freightBonus = true;
            }
        });

        switchTeamElementUsed.setOnClickListener(v -> teamElementUsed = switchTeamElementUsed.isChecked());

        switchDuckDelivery.setOnClickListener(v -> duckDelivery = switchDuckDelivery.isChecked());

        switchParkedFully.setOnClickListener(v -> parkedFully = switchParkedFully.isChecked());

        buttonAutoStoragePlus.setOnClickListener(v -> {
            autoStorage++;
            myVib.vibrate(20);
            textAutoStorage.setText(format("%d", autoStorage));
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
        });

        buttonAutoHubMinus.setOnClickListener(v -> {
            if(autoHub > 0){
                autoHub--;
                myVib.vibrate(20);
                textAutoHub.setText(format("%d", autoHub));
            }
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if(!(parkedInStorage || parkedInWarehouse))
                switchParkedFullyRef.setVisibility(View.GONE);
            else switchParkedFullyRef.setVisibility(View.VISIBLE);
            if(!freightBonus)
                switchTeamElementsUsedRef.setVisibility(View.GONE);
            else switchTeamElementsUsedRef.setVisibility(View.VISIBLE);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            if(!(parkedInStorage || parkedInWarehouse))
                switchParkedFullyRef.setVisibility(View.GONE);
            else switchParkedFullyRef.setVisibility(View.VISIBLE);
            if(!freightBonus)
                switchTeamElementsUsedRef.setVisibility(View.GONE);
            else switchTeamElementsUsedRef.setVisibility(View.VISIBLE);
        }
    }
}
