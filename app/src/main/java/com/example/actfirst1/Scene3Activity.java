package com.example.actfirst1;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class Scene3Activity extends BaseSceneActivity {

    int[] sequence1 = new int[]{1, 2, 3, 4, 5, 6};
    int[] sequence2 = new int[]{1, 2, 3, 7, 8};
    int[] sequence3 = new int[]{1, 2, 3, 4, 7, 5, 6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene3);

        algorithm = new Algorithm();

        Random random = new Random();
        int randomIndex = random.nextInt(3);
        switch (randomIndex) {
            case 0:
                correctSequence = sequence1;
                break;
            case 1:
                correctSequence = sequence2;
                break;
            case 2:
                correctSequence = sequence3;
                break;
        }

        setupActionButtons();
        setupViews(R.id.textViewName3, R.id.backButton3, R.id.helpButton3);
        startScene(R.id.progressBar3);

    }

    private void setupActionButtons() {
        FloatingActionButton ActionButtonObserve = findViewById(R.id.ActionButtonObserve);
        ActionButtonObserve.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "PERSON BEING OBSERVED", Toast.LENGTH_LONG).show();
            handleAction(6, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonHelp = findViewById(R.id.ActionButtonHelp);
        ActionButtonHelp.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "HELP CALLED", Toast.LENGTH_LONG).show();
            handleAction(2, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonHot = findViewById(R.id.ActionButtonHot);
        ActionButtonHot.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "WARM HAS BEEN ENSURED", Toast.LENGTH_LONG).show();
            handleAction(5, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonCheckBreath = findViewById(R.id.ActionButtonCheckBreath);
        ActionButtonCheckBreath.setOnClickListener(view -> {
            if (correctSequence == sequence1 ||correctSequence == sequence3) {
                Toast.makeText(Scene3Activity.this, "PERSON IS BREATHING", Toast.LENGTH_SHORT).show();
            } else if ( correctSequence == sequence2) {
                Toast.makeText(Scene3Activity.this, "PERSON IS NOT BREATHING", Toast.LENGTH_SHORT).show(); }
            handleAction(3, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonCheckCons = findViewById(R.id.ActionButtonCheckCons);
        ActionButtonCheckCons.setOnClickListener(view -> {
            if (correctSequence == sequence1) {
                Toast.makeText(Scene3Activity.this, "PERSON IS CONSCIOUS", Toast.LENGTH_SHORT).show();
            } else if (correctSequence == sequence3) {
                Toast.makeText(Scene3Activity.this, "PERSON IS NOT CONSCIOUS", Toast.LENGTH_SHORT).show(); }
            handleAction(4, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonCPR = findViewById(R.id.ActionButtonCPR);
        ActionButtonCPR.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "PERFORMING CPR", Toast.LENGTH_LONG).show();
            handleAction(8, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonSafety = findViewById(R.id.ActionButtonSafety);
        ActionButtonSafety.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "SURROUNDINGS IS SAFE", Toast.LENGTH_LONG).show();
            handleAction(1, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });

        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "999 CALLED, AMBULANCE ON THEIR WAY", Toast.LENGTH_LONG).show();
            handleAction(7, findViewById(R.id.scoreText3), findViewById(R.id.progressBar3));
        });
    }

    @Override
    protected int getSceneNumber() {
        return 3;
    }

}

