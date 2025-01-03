package com.example.actfirst1;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Scene4Activity extends BaseSceneActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene4);

        algorithm = new Algorithm();
        correctSequence = new int[]{1, 2, 3, 4, 5, 6, 7};

        setupActionButtons();
        setupViews(R.id.textViewName4, R.id.backButtonScene4, R.id.helpButtonScene4);
        startScene(R.id.progressBar4);
    }

    private void setupActionButtons() {
        FloatingActionButton ActionButtonEncourage = findViewById(R.id.ActionButtonEncourage);
        ActionButtonEncourage.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "COUGH ENCOURAGED", Toast.LENGTH_LONG).show();
            handleAction(2, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });

        FloatingActionButton ActionButtonCheckAirway = findViewById(R.id.ActionButtonCheckAirway);
        ActionButtonCheckAirway.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "AIRWAY CHECKED", Toast.LENGTH_LONG).show();
            handleAction(3, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });

        FloatingActionButton ActionButtonCPR = findViewById(R.id.ActionButtonCPR);
        ActionButtonCPR.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "CPR STARTED", Toast.LENGTH_LONG).show();
            handleAction(7, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });

        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "999 CALLED", Toast.LENGTH_LONG).show();
            handleAction(6, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });

        FloatingActionButton ActionButtonObserve = findViewById(R.id.ActionButtonObserve);
        ActionButtonObserve.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "PERSON OBSERVED", Toast.LENGTH_LONG).show();
            handleAction(1, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });

        FloatingActionButton ActionButtonHeimlich = findViewById(R.id.ActionButtonHeimlich);
        ActionButtonHeimlich.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "HEIMLICH MANEUVER PERFORMED", Toast.LENGTH_LONG).show();
            handleAction(5, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });

        FloatingActionButton ActionButtonBackBlow = findViewById(R.id.ActionButtonBackBlows);
        ActionButtonBackBlow.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "BACK BLOWS PERFORMED", Toast.LENGTH_LONG).show();
            handleAction(4, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });
    }

    @Override
    protected int getSceneNumber() {
        return 4;
    }

}
