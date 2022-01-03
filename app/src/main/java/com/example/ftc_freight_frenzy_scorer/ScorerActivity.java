package com.example.ftc_freight_frenzy_scorer;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ftc_freight_frenzy_scorer.databinding.ActivityScorerBinding;
import java.util.Locale;

public class ScorerActivity extends AppCompatActivity{

    protected ActivityScorerBinding binding;

    ///Autonomous
    public int autoTotalPoints = 0;
    public boolean duckDelivery = false;
    public int autoStorage = 0;
    public int autoHub = 0;
    public boolean freightBonus = false;
    public boolean teamElementUsed = false;
    public boolean autoParkedInStorage = false;
    public boolean autoParkedInWarehouse = false;
    public boolean autoParkedFully = false;

    ///Driver
    public int driverTotalPoints = 0;
    public int driverStorage = 0;
    public int driverHubL1 = 0;
    public int driverHubL2 = 0;
    public int driverHubL3 = 0;
    public int driverShared = 0;

    ///Endgame
    public int endgameTotalPoints = 0;
    public int carouselDelivery = 0;
    public boolean balancedShipping = false;
    public boolean leaningShared = false;
    public boolean endgameParked = false;
    public boolean endgameFullyParked = false;
    public int capping = 0;

    //Penalties
    public int penaltiesTotal = 0;
    public int penaltiesMinor = 0;
    public int penaltiesMajor = 0;

    //Total
    public int totalPoints = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScorerBinding.inflate(getLayoutInflater());
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

        ///Autonomous

        binding.switchDuckDelivery.setOnClickListener(v -> {
            duckDelivery = binding.switchDuckDelivery.isChecked();
            CalculateAutoPoints();
        });

        binding.buttonAutoStoragePlus.setOnClickListener(v -> {
            autoStorage++;
            myVib.vibrate(20);
            binding.textAutoStorageNr.setText(String.format(Locale.US,"%d", autoStorage));
            CalculateAutoPoints();
        });

        binding.buttonAutoStorageMinus.setOnClickListener(v -> {
            if(autoStorage > 0){
                autoStorage--;
                myVib.vibrate(20);
                binding.textAutoStorageNr.setText(String.format(Locale.US,"%d", autoStorage));
                CalculateAutoPoints();
            }
        });

        binding.buttonAutoHubPlus.setOnClickListener(v -> {
            autoHub++;
            myVib.vibrate(20);
            binding.textAutoHubNr.setText(String.format(Locale.US,"%d", autoHub));
            CalculateAutoPoints();
        });

        binding.buttonAutoHubMinus.setOnClickListener(v -> {
            if(autoHub > 0){
                autoHub--;
                myVib.vibrate(20);
                binding.textAutoHubNr.setText(String.format(Locale.US,"%d", autoHub));
                CalculateAutoPoints();
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
            CalculateAutoPoints();
        });

        binding.switchTeamElementUsed.setOnClickListener(v -> {
            teamElementUsed = binding.switchTeamElementUsed.isChecked();
            CalculateAutoPoints();
        });

        binding.switchAutoParkedInStorage.setOnClickListener(v -> {
            if(!binding.switchAutoParkedInStorage.isChecked()){
                binding.switchAutoParkedFully.setVisibility(View.GONE);
                binding.switchAutoParkedFully.setChecked(false);
                autoParkedInStorage = false;

            }
            else {
                binding.switchAutoParkedFully.setVisibility((View.VISIBLE));
                autoParkedInStorage = true;
                autoParkedInWarehouse = false;
                binding.switchAutoParkedInWarehouse.setChecked(false);
            }
            CalculateAutoPoints();
        });

        binding.switchAutoParkedInWarehouse.setOnClickListener(v -> {
            if(!binding.switchAutoParkedInWarehouse.isChecked()){
                binding.switchAutoParkedFully.setVisibility(View.GONE);
                binding.switchAutoParkedFully.setChecked(false);
                autoParkedInWarehouse = false;
            }
            else {
                binding.switchAutoParkedFully.setVisibility((View.VISIBLE));
                autoParkedInWarehouse = true;
                autoParkedInStorage = false;
                binding.switchAutoParkedInStorage.setChecked(false);
            }
            CalculateAutoPoints();
        });

        binding.switchAutoParkedFully.setOnClickListener(v -> {
            autoParkedFully = binding.switchAutoParkedFully.isChecked();
            CalculateAutoPoints();
        });

        ///Driver

        binding.buttonDriverStoragePlus.setOnClickListener(v -> {
            driverStorage++;
            myVib.vibrate(20);
            binding.textDriverStorageNr.setText(String.format(Locale.US,"%d", driverStorage));
            CalculateDriverPoints();
        });

        binding.buttonDriverStorageMinus.setOnClickListener(v -> {
            if(driverStorage > 0){
                driverStorage--;
                myVib.vibrate(20);
                binding.textDriverStorageNr.setText(String.format(Locale.US,"%d", driverStorage));
                CalculateDriverPoints();
            }
        });

        binding.buttonDriverHubL1Plus.setOnClickListener(v -> {
            driverHubL1++;
            myVib.vibrate(20);
            binding.textDriverHubL1Nr.setText(String.format(Locale.US,"%d", driverHubL1));
            CalculateDriverPoints();
        });

        binding.buttonDriverHubL1Minus.setOnClickListener(v -> {
            if(driverHubL1 > 0){
                driverHubL1--;
                myVib.vibrate(20);
                binding.textDriverHubL1Nr.setText(String.format(Locale.US,"%d", driverHubL1));
                CalculateDriverPoints();
            }
        });

        binding.buttonDriverHubL2Plus.setOnClickListener(v -> {
            driverHubL2++;
            myVib.vibrate(20);
            binding.textDriverHubL2Nr.setText(String.format(Locale.US,"%d", driverHubL2));
            CalculateDriverPoints();
        });

        binding.buttonDriverHubL2Minus.setOnClickListener(v -> {
            if(driverHubL2 > 0){
                driverHubL2--;
                myVib.vibrate(20);
                binding.textDriverHubL2Nr.setText(String.format(Locale.US,"%d", driverHubL2));
                CalculateDriverPoints();
            }
        });

        binding.buttonDriverHubL3Plus.setOnClickListener(v -> {
            driverHubL3++;
            myVib.vibrate(20);
            binding.textDriverHubL3Nr.setText(String.format(Locale.US,"%d", driverHubL3));
            CalculateDriverPoints();
        });

        binding.buttonDriverHubL3Minus.setOnClickListener(v -> {
            if(driverHubL3 > 0){
                driverHubL3--;
                myVib.vibrate(20);
                binding.textDriverHubL3Nr.setText(String.format(Locale.US,"%d", driverHubL3));
                CalculateDriverPoints();
            }
        });

        binding.buttonDriverSharedPlus.setOnClickListener(v -> {
            driverShared++;
            myVib.vibrate(20);
            binding.textDriverSharedNr.setText(String.format(Locale.US,"%d", driverShared));
            CalculateDriverPoints();
        });

        binding.buttonDriverSharedMinus.setOnClickListener(v -> {
            if(driverShared > 0){
                driverShared--;
                myVib.vibrate(20);
                binding.textDriverSharedNr.setText(String.format(Locale.US,"%d", driverShared));
                CalculateDriverPoints();
            }
        });

        ///Endgame

        binding.buttonEndgameCarouselPlus.setOnClickListener(v -> {
            if(carouselDelivery < 12) {
                carouselDelivery++;
                myVib.vibrate(20);
                binding.textEndgameCarouselNr.setText(String.format(Locale.US,"%d", carouselDelivery));
                CalculateEndgamePoints();
            }
        });

        binding.buttonEndgameCarouselMinus.setOnClickListener(v -> {
            if(carouselDelivery > 0){
                carouselDelivery--;
                myVib.vibrate(20);
                binding.textEndgameCarouselNr.setText(String.format(Locale.US,"%d", carouselDelivery));
                CalculateEndgamePoints();
            }
        });

        binding.switchEndgameBalancedShipping.setOnClickListener(v -> {
            balancedShipping = binding.switchEndgameBalancedShipping.isChecked();
            CalculateEndgamePoints();
        });

        binding.switchEndgameLeaningShared.setOnClickListener(v -> {
            leaningShared = binding.switchEndgameLeaningShared.isChecked();
            CalculateEndgamePoints();
        });

        binding.switchEndgameParked.setOnClickListener(v -> {
            endgameParked = binding.switchEndgameParked.isChecked();
            if(endgameParked)
                binding.switchEndgameParkedFully.setVisibility(View.VISIBLE);
            else {
                binding.switchEndgameParkedFully.setVisibility(View.GONE);
                binding.switchEndgameParkedFully.setChecked(false);
                endgameFullyParked = false;
            }
            CalculateEndgamePoints();
        });

        binding.switchEndgameParkedFully.setOnClickListener(v -> {
            endgameFullyParked = binding.switchEndgameParkedFully.isChecked();
            CalculateEndgamePoints();
        });

        binding.buttonEndgameCappingPlus.setOnClickListener(v -> {
            if(capping < 2){
                capping++;
                myVib.vibrate(20);
                binding.textEndgameCappingNr.setText(String.format(Locale.US,"%d", capping));
                CalculateEndgamePoints();
            }
        });

        binding.buttonEndgameCappingMinus.setOnClickListener(v -> {
            if(capping > 0){
                capping--;
                myVib.vibrate(20);
                binding.textEndgameCappingNr.setText(String.format(Locale.US,"%d", capping));
                CalculateEndgamePoints();
            }
        });

        //Penalties

        binding.buttonPenaltiesMinorPlus.setOnClickListener(v -> {
            penaltiesMinor++;
            myVib.vibrate(20);
            binding.textPenaltiesMinorNr.setText(String.format(Locale.US,"%d", penaltiesMinor));
            CalculatePenalties();
        });

        binding.buttonPenaltiesMinorMinus.setOnClickListener(v -> {
            if(penaltiesMinor > 0){
                penaltiesMinor--;
                myVib.vibrate(20);
                binding.textPenaltiesMinorNr.setText(String.format(Locale.US,"%d", penaltiesMinor));
                CalculatePenalties();
            }
        });

        binding.buttonPenaltiesMajorPlus.setOnClickListener(v -> {
            penaltiesMajor++;
            myVib.vibrate(20);
            binding.textPenaltiesMajorNr.setText(String.format(Locale.US,"%d", penaltiesMajor));
            CalculatePenalties();
        });

        binding.buttonPenaltiesMajorMinus.setOnClickListener(v -> {
            if(penaltiesMajor > 0){
                penaltiesMajor--;
                myVib.vibrate(20);
                binding.textPenaltiesMajorNr.setText(String.format(Locale.US,"%d", penaltiesMajor));
                CalculatePenalties();
            }
        });
    }

    public void CalculateAutoPoints() {
        autoTotalPoints = autoStorage * 2 + autoHub * 6;
        if(duckDelivery)
            autoTotalPoints += 10;
        if(freightBonus) {
            if(teamElementUsed)
                autoTotalPoints += 20;
            else autoTotalPoints += 10;
        }
        if(autoParkedInStorage) {
            if(autoParkedFully)
                autoTotalPoints += 6;
            else autoTotalPoints += 3;
        }else if(autoParkedInWarehouse) {
            if(autoParkedFully)
                autoTotalPoints += 10;
            else autoTotalPoints += 5;
        }
        binding.textAutoTotalPointsNr.setText(String.format(Locale.US,"%d", autoTotalPoints));
        CalculateTotalPoints();
    }

    public void CalculateDriverPoints() {
        driverTotalPoints = driverStorage + 2 * driverHubL1 + 4 * driverHubL2 + 6 * driverHubL3 + 4 * driverShared;
        binding.textDriverTotalPointsNr.setText(String.format(Locale.US, "%d", driverTotalPoints));
        CalculateTotalPoints();
    }

    public void CalculateEndgamePoints() {
        endgameTotalPoints = 6 * carouselDelivery + 15 * capping;
        if(balancedShipping)
            endgameTotalPoints += 10;
        if(leaningShared)
            endgameTotalPoints += 20;
        if(endgameParked){
            if(endgameFullyParked)
                endgameTotalPoints += 6;
            else endgameTotalPoints += 3;
        }
        binding.textEndgameTotalPointsNr.setText(String.format(Locale.US, "%d", endgameTotalPoints));
        CalculateTotalPoints();
    }

    public void CalculatePenalties() {
        penaltiesTotal = -10 * penaltiesMinor + -30 * penaltiesMajor;
        binding.textPenaltiesNr.setText(String.format(Locale.US, "%d", penaltiesTotal));
        CalculateTotalPoints();
    }

    public void CalculateTotalPoints() {
        totalPoints = autoTotalPoints + driverTotalPoints + endgameTotalPoints + penaltiesTotal;
        binding.textTotalNr.setText(String.format(Locale.US, "%d", totalPoints));
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
