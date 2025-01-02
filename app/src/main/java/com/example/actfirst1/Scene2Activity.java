package com.example.actfirst1;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Scene2Activity extends BaseSceneActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene2);

        algorithm = new Algorithm();
        correctSequence = new int[]{1, 2, 3, 4, 5, 6, 7};

        setupActionButtons();
        setupViews(R.id.textViewName2, R.id.scoreText2, R.id.progressBar2, R.id.backButtonScene2, R.id.helpButtonScene2);
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
            handleAction(7, findViewById(R.id.scoreText2), findViewById(R.id.progressBar2));
        });

        FloatingActionButton ActionButtonSafety = findViewById(R.id.ActionButtonSafety);
        ActionButtonSafety.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Surroundings are safe", Toast.LENGTH_LONG).show();
            handleAction(1, findViewById(R.id.scoreText2), findViewById(R.id.progressBar2));
        });

        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "999 is called", Toast.LENGTH_LONG).show();
            handleAction(6, findViewById(R.id.scoreText2), findViewById(R.id.progressBar2));
        });
    }

    @Override
    protected int getSceneNumber() {
        return 2;
    }

    /*private Algorithm algorithmScene2;
    private int currentStep = 0;
    private final int[] correctSequence2 = {1, 2, 3, 4, 5, 6, 7};
    private CountDownTimer countDownTimer;
    private boolean timerRunning = false;
    private long maxTime = 60000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene2);

        algorithmScene2 = new Algorithm();

        String username = getIntent().getStringExtra("username");
        TextView textView = findViewById(R.id.textView8);
        textView.setText(username);

        TextView scoreText2 = findViewById(R.id.scoreText2);
        ProgressBar timerProgressBar2 = findViewById(R.id.progressBar2);

        startTimer(timerProgressBar2, username, scoreText2);

        FloatingActionButton ActionButtonComfort = findViewById(R.id.ActionButtonComfort);
        ActionButtonComfort.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Person is being comforted", Toast.LENGTH_LONG).show();
            handleAction2(2, scoreText2, timerProgressBar2);
        });

        FloatingActionButton ActionButtonWound = findViewById(R.id.ActionButtonWound);
        ActionButtonWound.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Wound is covered", Toast.LENGTH_LONG).show();
            handleAction2(3, scoreText2, timerProgressBar2);
        });

        FloatingActionButton ActionButtonElevate = findViewById(R.id.ActionButtonElevate);
        ActionButtonElevate.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Leg is elevated", Toast.LENGTH_LONG).show();
            handleAction2(5, scoreText2, timerProgressBar2);
        });

        FloatingActionButton ActionButtonImmobilize = findViewById(R.id.ActionButtonImmobilize);
        ActionButtonImmobilize.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Leg is immobilized", Toast.LENGTH_LONG).show();
            handleAction2(4, scoreText2, timerProgressBar2);
        });

        FloatingActionButton ActionButtonMonitorConditions = findViewById(R.id.ActionButtonMonitorConditions);
        ActionButtonMonitorConditions.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Monitoring conditions", Toast.LENGTH_LONG).show();
            handleAction2(7, scoreText2, timerProgressBar2);
        });

        FloatingActionButton ActionButtonSafety = findViewById(R.id.ActionButtonSafety);
        ActionButtonSafety.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Surroundings are safe", Toast.LENGTH_LONG).show();
            handleAction2(1, scoreText2, timerProgressBar2);
        });

        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "999 is called", Toast.LENGTH_LONG).show();
            handleAction2(6, scoreText2, timerProgressBar2);
        });

        Button backButtonScene2 = findViewById(R.id.backButtonScene2);
        backButtonScene2.setOnClickListener(view -> {
            Intent intent = new Intent(Scene2Activity.this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        Button helpButtonScene2 = findViewById(R.id.helpButtonScene2);
        helpButtonScene2.setOnClickListener(view -> showHelpDialogScene2());

    }

    private void showHelpDialogScene2() {

        Dialog helpDialog = new Dialog(this);
        helpDialog.setContentView(R.layout.dialog_scene2_help);

        ImageView closeButton = helpDialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> helpDialog.dismiss());

        helpDialog.show();
    }

    private void handleAction2(int action, TextView scoreText2, ProgressBar timerProgressBar2) {
        if (algorithmScene2.isCorrectSequence(action, correctSequence2, currentStep)) {
            algorithmScene2.correctAction();
            currentStep++;
            scoreText2.setText(String.format("Score: %d", algorithmScene2.getScore()));
            Toast.makeText(this, "Correct! Score: " + algorithmScene2.getScore(), Toast.LENGTH_SHORT).show();
        } else {
            algorithmScene2.wrongAction();
            scoreText2.setText(String.format("Score: %d", algorithmScene2.getScore()));
            Toast.makeText(this, "Wrong! Score: " + algorithmScene2.getScore(), Toast.LENGTH_SHORT).show();
        }

        if (currentStep == correctSequence2.length) {
            countDownTimer.cancel();
            timerRunning = false;
            long elapsedTime = maxTime - timerProgressBar2.getProgress();
            endGame("username", scoreText2, (int) (elapsedTime / 1000));
        }

    }

    private void endGame(String username, TextView scoreText2, int time) {
        Toast.makeText(this, "Sequence complete! Final Score: " + algorithmScene2.getScore(), Toast.LENGTH_LONG).show();
        currentStep = 0;

        int scene = 2;
        HistoryActivity.addGameSession(username, scene, algorithmScene2.getScore(), time);

        Intent intent = new Intent(Scene2Activity.this, EndScene.class);
        intent.putExtra("username", username);
        intent.putExtra("score", algorithmScene2.getScore());
        intent.putExtra("time", time);
        intent.putExtra("scene", scene);
        startActivity(intent);
    }

    private void startTimer(ProgressBar timerProgressBar2, String username, TextView scoreText2) {
        timerProgressBar2.setMax((int) maxTime);
        timerProgressBar2.setProgress((int) maxTime);

        countDownTimer = new CountDownTimer(maxTime, 1000) {
            long elapsedTime = 0;

            @Override
            public void onTick(long millisUntilFinished) {
                timerProgressBar2.setProgress((int) millisUntilFinished);
                elapsedTime = maxTime - millisUntilFinished;
            }

            @Override
            public void onFinish() {
                timerProgressBar2.setProgress(0);
                if (currentStep < correctSequence2.length) {
                    endGame(username, scoreText2, (int) elapsedTime / 1000);
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
    }*/
}
