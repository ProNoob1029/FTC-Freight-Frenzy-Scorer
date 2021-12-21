package com.example.ftc_freightfrenzy_scorer;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ftc_freightfrenzy_scorer.databinding.ActivityScorerBinding;
import java.util.Locale;

public class ScorerActivity extends AppCompatActivity{

    ///Autonomous
    public boolean duckDelivery = false;
    public int autoStorage = 0;
    public int autoHub = 0;
    public boolean freightBonus = false;
    public boolean teamElementUsed = false;
    public boolean parkedInStorage = false;
    public boolean parkedInWarehouse = false;
    public boolean parkedFully = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.example.ftc_freightfrenzy_scorer.databinding.ActivityScorerBinding binding = ActivityScorerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Vibrator myVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        /*SwitchCompat switchDuckDelivery = findViewById(R.id.switch_duck_delivery);
        SwitchCompat switchFreightBonus = findViewById(R.id.switch_freight_bonus);
        SwitchCompat switchTeamElementUsed = findViewById(R.id.switch_team_element_used);
        switchTeamElementsUsedRef = switchTeamElementUsed;
        SwitchCompat switchParkedInStorage = findViewById(R.id.switch_auto_parked_in_storage);
        SwitchCompat switchParkedInWarehouse = findViewById(R.id.switch_auto_parked_in_warehouse);
        SwitchCompat switchParkedFully = findViewById(R.id.switch_auto_parked_fully);
        switchParkedFullyRef = switchParkedFully;
        TextView textAutoStorage = findViewById(R.id.text_auto_storage_nr);
        TextView textAutoHub = findViewById(R.id.text_auto_hub_nr);
        Button buttonAutoStoragePlus = findViewById(R.id.button_auto_storage_plus);
        Button buttonAutoStorageMinus = findViewById(R.id.button_auto_storage_minus);
        Button buttonAutoHubPlus = findViewById(R.id.button_auto_hub_plus);
        Button buttonAutoHubMinus = findViewById(R.id.button_auto_hub_minus);*/

        binding.switchAutoParkedInStorage.setOnClickListener(v -> {
            if(!binding.switchAutoParkedInStorage.isChecked()){
                binding.switchAutoParkedFully.setVisibility(View.GONE);
                binding.switchAutoParkedFully.setChecked(false);
                parkedInStorage = false;
            }
            else {
                binding.switchAutoParkedFully.setVisibility((View.VISIBLE));
                parkedInStorage = true;
                parkedInWarehouse = false;
                binding.switchAutoParkedInWarehouse.setChecked(false);
            }
        });

        binding.switchAutoParkedInWarehouse.setOnClickListener(v -> {
            if(!binding.switchAutoParkedInWarehouse.isChecked()){
                binding.switchAutoParkedFully.setVisibility(View.GONE);
                binding.switchAutoParkedFully.setChecked(false);
                parkedInWarehouse = false;
            }
            else {
                binding.switchAutoParkedFully.setVisibility((View.VISIBLE));
                parkedInWarehouse = true;
                parkedInStorage = false;
                binding.switchAutoParkedInStorage.setChecked(false);
            }
        });

        binding.switchFreightBonus.setOnClickListener(v -> {
            if(!binding.switchFreightBonus.isChecked()){
                binding.switchTeamElementUsed.setVisibility(View.GONE);
                binding.switchTeamElementUsed.setChecked(false);
                freightBonus = false;
                teamElementUsed = false;
            }
            else {
                binding.switchTeamElementUsed.setVisibility((View.VISIBLE));
                freightBonus = true;
            }
        });

        binding.switchTeamElementUsed.setOnClickListener(v -> teamElementUsed = binding.switchTeamElementUsed.isChecked());

        binding.switchDuckDelivery.setOnClickListener(v -> duckDelivery = binding.switchDuckDelivery.isChecked());

        binding.switchAutoParkedFully.setOnClickListener(v -> parkedFully = binding.switchAutoParkedFully.isChecked());

        binding.buttonAutoStoragePlus.setOnClickListener(v -> {
            autoStorage++;
            myVib.vibrate(20);
            binding.textAutoStorageNr.setText(String.format(Locale.US,"%d", autoStorage));
        });

        binding.buttonAutoStorageMinus.setOnClickListener(v -> {
            if(autoStorage > 0){
                autoStorage--;
                myVib.vibrate(20);
                binding.textAutoStorageNr.setText(String.format(Locale.US,"%d", autoStorage));
            }
        });

        binding.buttonAutoHubPlus.setOnClickListener(v -> {
            autoHub++;
            myVib.vibrate(20);
            binding.textAutoHubNr.setText(String.format(Locale.US,"%d", autoHub));
        });

        binding.buttonAutoHubMinus.setOnClickListener(v -> {
            if(autoHub > 0){
                autoHub--;
                myVib.vibrate(20);
                binding.textAutoHubNr.setText(String.format(Locale.US,"%d", autoHub));
            }
        });
    }

    /*@Override
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
    }*/
}
