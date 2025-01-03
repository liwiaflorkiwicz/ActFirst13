package com.example.actfirst1;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class Scene1Activity extends BaseSceneActivity {

    int[] sequence1 = new int[]{1, 2, 3, 4, 5, 7, 8, 9};
    int[] sequence2 = new int[]{1, 2, 3, 6, 5};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene1);

        algorithm = new Algorithm();

        Random random = new Random();
        if (random.nextBoolean()) {
            correctSequence = sequence1;
        } else {
            correctSequence = sequence2;
        }

        setupActionButtons();
        setupViews(R.id.textViewName1, R.id.backButtonScene1, R.id.helpButtonScene1);
        startScene(R.id.progressBar1);
    }

    private void setupActionButtons() {
        FloatingActionButton ActionButtonSafety = findViewById(R.id.ActionButtonSafety);
        ActionButtonSafety.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "SURROUNDINGS IS SAFE", Toast.LENGTH_SHORT).show();
            handleAction(1, findViewById(R.id.scoreText1), findViewById(R.id.progressBar1));
        });

        FloatingActionButton ActionButtonCheckCons = findViewById(R.id.ActionButtonCheckCons);
        ActionButtonCheckCons.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "PERSON IS UNCONSCIOUS", Toast.LENGTH_SHORT).show();
            handleAction(2, findViewById(R.id.scoreText1), findViewById(R.id.progressBar1));
        });

        FloatingActionButton ActionButtonPerfBreath = findViewById(R.id.ActionButtonPerfBreath);
        ActionButtonPerfBreath.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "2 BREATHS PERFORMED", Toast.LENGTH_SHORT).show();
            handleAction(8, findViewById(R.id.scoreText1), findViewById(R.id.progressBar1));
        });

        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "999 CALLED \n AMBULANCE ON THEIR WAY", Toast.LENGTH_SHORT).show();
            handleAction(5, findViewById(R.id.scoreText1), findViewById(R.id.progressBar1));
        });

        FloatingActionButton ActionButtonCompression = findViewById(R.id.ActionButtonCompression);
        ActionButtonCompression.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "30 COMPRESSIONS PERFORMED", Toast.LENGTH_SHORT).show();
            handleAction(7, findViewById(R.id.scoreText1), findViewById(R.id.progressBar1));
        });

        FloatingActionButton ActionButtonHelp = findViewById(R.id.ActionButtonHelp);
        ActionButtonHelp.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "HELP CALLED, HELP IS ON THEIR WAY", Toast.LENGTH_SHORT).show();
            handleAction(4, findViewById(R.id.scoreText1), findViewById(R.id.progressBar1));
        });

        FloatingActionButton ActionButtonCheckBreath = findViewById(R.id.ActionButtonCheckBreath);
        ActionButtonCheckBreath.setOnClickListener(view -> {
            if (correctSequence == sequence1) {
                Toast.makeText(Scene1Activity.this, "PERSON IS NOT BREATHING", Toast.LENGTH_SHORT).show();
            } else if (correctSequence == sequence2) {
                Toast.makeText(Scene1Activity.this, "PERSON IS BREATHING", Toast.LENGTH_SHORT).show(); }
            handleAction(3, findViewById(R.id.scoreText1), findViewById(R.id.progressBar1));
        });

        FloatingActionButton ActionButtonAED = findViewById(R.id.ActionButtonAED);
        ActionButtonAED.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "AED IN USE, LISTEN TO ITS INSTRUCTIONS", Toast.LENGTH_SHORT).show();
            handleAction(9, findViewById(R.id.scoreText1), findViewById(R.id.progressBar1));
        });

        FloatingActionButton ActionButtonSafePose = findViewById(R.id.ActionButtonSafePose);
        ActionButtonSafePose.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "PERSON IN RECOVERY POSITION", Toast.LENGTH_SHORT).show();
            handleAction(6, findViewById(R.id.scoreText1), findViewById(R.id.progressBar1));
        });
    }

    @Override
    protected int getSceneNumber() {
        return 1;
    }
}
