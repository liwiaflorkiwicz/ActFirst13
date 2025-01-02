package com.example.actfirst1;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Scene3Activity extends BaseSceneActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene3);

        algorithm = new Algorithm();
        correctSequence = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        setupActionButtons();
        setupViews(R.id.textViewName3, R.id.scoreText3, R.id.progressBar3, R.id.backButton3, R.id.helpButton3);

    }

    private void setupActionButtons() {
        FloatingActionButton ActionButtonObserve = findViewById(R.id.ActionButtonObserve);
        ActionButtonObserve.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "PERSON OBSERVED", Toast.LENGTH_LONG).show();
            handleAction(1, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonBlood = findViewById(R.id.ActionButtonBlood);
        ActionButtonBlood.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "BLOOD CIRCULATION CHECKED", Toast.LENGTH_LONG).show();
            handleAction(2, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonHot = findViewById(R.id.ActionButtonHot);
        ActionButtonHot.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "WARM HAS BEEN ENSURED", Toast.LENGTH_LONG).show();
            handleAction(3, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonCheckBreath = findViewById(R.id.ActionButtonCheckBreath);
        ActionButtonCheckBreath.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "BREATH CHECKED", Toast.LENGTH_LONG).show();
            handleAction(4, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonCheckCons = findViewById(R.id.ActionButtonCheckCons);
        ActionButtonCheckCons.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "CONSCIOUSNESS CHECKED", Toast.LENGTH_LONG).show();
            handleAction(5, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonCPR = findViewById(R.id.ActionButtonCPR);
        ActionButtonCPR.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "PERFORMING CPR", Toast.LENGTH_LONG).show();
            handleAction(6, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonSafety = findViewById(R.id.ActionButtonSafety);
        ActionButtonSafety.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "SURROUNDINGS IS SAFE", Toast.LENGTH_LONG).show();
            handleAction(7, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "999 CALLED, AMBULANCE ON THEIR WAY", Toast.LENGTH_LONG).show();
            handleAction(8, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });
    }

    @Override
    protected int getSceneNumber() {
        return 3;
    }

}

