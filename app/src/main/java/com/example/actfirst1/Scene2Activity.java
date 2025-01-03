package com.example.actfirst1;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Scene2Activity extends BaseSceneActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene2);

        algorithm = new Algorithm();
        correctSequence = new int[]{1, 2, 3, 4, 5, 6, 7};

        setupActionButtons();
        setupViews(R.id.textViewName2, R.id.backButtonScene2, R.id.helpButtonScene2);
        startScene(R.id.progressBar2);
    }

    private void setupActionButtons() {
        FloatingActionButton ActionButtonComfort = findViewById(R.id.ActionButtonComfort);
        ActionButtonComfort.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Person is being comforted", Toast.LENGTH_LONG).show();
            handleAction(2, findViewById(R.id.scoreText2), findViewById(R.id.progressBar2));
        });

        FloatingActionButton ActionButtonWound = findViewById(R.id.ActionButtonWound);
        ActionButtonWound.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Wound is covered", Toast.LENGTH_LONG).show();
            handleAction(3, findViewById(R.id.scoreText2), findViewById(R.id.progressBar2));
        });

        FloatingActionButton ActionButtonElevate = findViewById(R.id.ActionButtonElevate);
        ActionButtonElevate.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Leg is elevated", Toast.LENGTH_LONG).show();
            handleAction(5, findViewById(R.id.scoreText2), findViewById(R.id.progressBar2));
        });

        FloatingActionButton ActionButtonImmobilize = findViewById(R.id.ActionButtonImmobilize);
        ActionButtonImmobilize.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Leg is immobilized", Toast.LENGTH_LONG).show();
            handleAction(4, findViewById(R.id.scoreText2), findViewById(R.id.progressBar2));
        });

        FloatingActionButton ActionButtonMonitorConditions = findViewById(R.id.ActionButtonMonitorConditions);
        ActionButtonMonitorConditions.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Monitoring conditions", Toast.LENGTH_LONG).show();
            handleAction(6, findViewById(R.id.scoreText2), findViewById(R.id.progressBar2));
        });

        FloatingActionButton ActionButtonSafety = findViewById(R.id.ActionButtonSafety);
        ActionButtonSafety.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Surroundings are safe", Toast.LENGTH_LONG).show();
            handleAction(1, findViewById(R.id.scoreText2), findViewById(R.id.progressBar2));
        });

        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "999 is called", Toast.LENGTH_LONG).show();
            handleAction(7, findViewById(R.id.scoreText2), findViewById(R.id.progressBar2));
        });
    }

    @Override
    protected int getSceneNumber() {
        return 2;
    }

}
