package com.example.actfirst1;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Scene1Activity extends AppCompatActivity {

    public Algorithm algorithmScene1;
    private int currentStep = 0;
    private final int[] correctSequence1 = {1, 2, 3, 4, 5, 6, 7, 8};
    public String username;
    private CountDownTimer countDownTimer;
    private boolean timerRunning = false;
    public long maxTime = 60000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene1); // load layout scene1.xml
        algorithmScene1 = new Algorithm();

        username = getIntent().getStringExtra("username");
        TextView textView = findViewById(R.id.textView8);
        textView.setText(username);

        TextView scoreText = findViewById(R.id.scoreText);
        ProgressBar timerProgressBar = findViewById(R.id.progressBar);

        startTimer(timerProgressBar, username, scoreText);

        FloatingActionButton ActionButtonSafety = findViewById(R.id.ActionButtonSafety);
        ActionButtonSafety.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "SURROUNDINGS IS SAFE", Toast.LENGTH_SHORT).show();
            handleAction1(1, scoreText, timerProgressBar);
        });

        FloatingActionButton ActionButtonCheckCons = findViewById(R.id.ActionButtonCheckCons);
        ActionButtonCheckCons.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "PERSON IS UNCONSCIOUS", Toast.LENGTH_SHORT).show();
            handleAction1(2, scoreText, timerProgressBar);
        });

        FloatingActionButton ActionButtonPerfBreath = findViewById(R.id.ActionButtonPerfBreath);
        ActionButtonPerfBreath.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "2 BREATHS PERFORMED", Toast.LENGTH_SHORT).show();
            handleAction1(7, scoreText, timerProgressBar);
        });

        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "999 CALLED \n AMBULANCE ON THEIR WAY", Toast.LENGTH_SHORT).show();
            handleAction1(5, scoreText, timerProgressBar);
        });

        FloatingActionButton ActionButtonCompression = findViewById(R.id.ActionButtonCompression);
        ActionButtonCompression.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "30 COMPRESSIONS PERFORMED", Toast.LENGTH_SHORT).show();
            handleAction1(6, scoreText, timerProgressBar);
        });

        FloatingActionButton ActionButtonHelp = findViewById(R.id.ActionButtonHelp);
        ActionButtonHelp.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "HELP CALLED, PERSON ON THEIR WAY", Toast.LENGTH_SHORT).show();
            handleAction1(4, scoreText, timerProgressBar);
        });

        FloatingActionButton ActionButtonCheckBreath = findViewById(R.id.ActionButtonCheckBreath);
        ActionButtonCheckBreath.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "PERSON IS NOT BREATHING", Toast.LENGTH_SHORT).show();
            handleAction1(3, scoreText, timerProgressBar);
        });

        FloatingActionButton ActionButtonAED = findViewById(R.id.ActionButtonAED);
        ActionButtonAED.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "AED IN USE, LISTEN TO ITS INSTRUCTIONS", Toast.LENGTH_SHORT).show();
            handleAction1(8, scoreText, timerProgressBar);
        });


        Button backButtonScene1 = findViewById(R.id.backButtonScene1);
        backButtonScene1.setOnClickListener(view -> {
            Intent intent = new Intent(Scene1Activity.this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        Button helpButtonScene1 = findViewById(R.id.helpButtonScene1);
        helpButtonScene1.setOnClickListener(view -> showHelpDialogScene1());

    }

    private void showHelpDialogScene1() {

        Dialog helpDialog = new Dialog(this);
        helpDialog.setContentView(R.layout.dialog_scene1_help);

        ImageView closeButton = helpDialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> helpDialog.dismiss());

        helpDialog.show();
    }

    private void handleAction1(int action1, TextView scoreText, ProgressBar timerProgressBar) {
        if (algorithmScene1.isCorrectSequence(action1, correctSequence1, currentStep)) {
            algorithmScene1.correctAction();
            currentStep++; // Move to the next step in the sequence
            scoreText.setText(String.format("Score: %d", algorithmScene1.getScore()));
            Toast.makeText(this, "Correct! Score: " + algorithmScene1.getScore(), Toast.LENGTH_SHORT).show();
        } else {
            algorithmScene1.wrongAction();
            scoreText.setText(String.format("Score: %d", algorithmScene1.getScore()));
            Toast.makeText(this, "Wrong! Score: " + algorithmScene1.getScore(), Toast.LENGTH_SHORT).show();
        }

        // Check if the sequence is complete
        if (currentStep == correctSequence1.length) {
            countDownTimer.cancel();
            timerRunning = false;
            long elapsedTime = maxTime - timerProgressBar.getProgress();
            endGame(username, scoreText, (int) (elapsedTime / 1000)); // in here time is getting wrongly
        }
    }

    private void endGame(String username, TextView scoreText, int time) {
        Toast.makeText(this, "Sequence complete! Final Score: " + algorithmScene1.getScore(), Toast.LENGTH_LONG).show();
        currentStep = 0;

        int scene = 1;
        HistoryActivity.addGameSession(username, scene, algorithmScene1.getScore(), time);

        Intent intent = new Intent(Scene1Activity.this, EndScene.class);
        intent.putExtra("username", username);
        intent.putExtra("score", algorithmScene1.getScore());
        intent.putExtra("time", time);
        intent.putExtra("scene", scene);
        startActivity(intent);
    }

    private void startTimer(ProgressBar timerProgressBar, String username, TextView scoreText) {

        timerProgressBar.setMax((int)maxTime); // max time for timer
        timerProgressBar.setProgress((int)maxTime);

        countDownTimer = new CountDownTimer(maxTime, 1000) {
            long elapsedTime = 0;

            @Override
            public void onTick(long millisUntilFinished) {
                timerProgressBar.setProgress((int) millisUntilFinished);
                elapsedTime = maxTime - millisUntilFinished;
            }

            @Override
            public void onFinish() {
                timerProgressBar.setProgress(0);
                if (currentStep < correctSequence1.length) {
                    endGame(username, scoreText, (int) elapsedTime / 1000);
                }
            }
        };
        countDownTimer.start();
        timerRunning = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timerRunning) {
            countDownTimer.cancel();
        }
    }
}
