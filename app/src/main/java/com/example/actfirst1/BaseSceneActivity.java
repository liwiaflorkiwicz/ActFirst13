package com.example.actfirst1;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseSceneActivity extends AppCompatActivity {
    protected Algorithm algorithm;
    protected int currentStep = 0;
    protected int[] correctSequence;
    protected CountDownTimer countDownTimer;
    protected boolean timerRunning = false;
    protected long maxTime = 60000;
    protected String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        username = getIntent().getStringExtra("username");
    }

    protected void setupViews(int nameTextId, int scoreTextId, int progressBarId, int backButtonId, int helpButtonId) {
        TextView textView8 = findViewById(nameTextId);
        textView8.setText(username);

        TextView scoreText = findViewById(scoreTextId);
        ProgressBar timerProgressBar = findViewById(progressBarId);

        Button backButton = findViewById(backButtonId);
        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(BaseSceneActivity.this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        Button helpButton = findViewById(helpButtonId);
        helpButton.setOnClickListener(view -> showHelpDialog());

        startTimer(timerProgressBar, username, scoreText);
    }

    protected void showHelpDialog() {
        Dialog helpDialog = new Dialog(this);

        switch (getSceneNumber()) {
            case 1:
                helpDialog.setContentView(R.layout.dialog_scene1_help);
                break;
            case 2:
                helpDialog.setContentView(R.layout.dialog_scene2_help);
                break;
            case 3:
                helpDialog.setContentView(R.layout.dialog_scene3_help);
                break;
            case 4:
                helpDialog.setContentView(R.layout.dialog_scene4_help);
                break;
        }

        ImageView closeButton = helpDialog.findViewById(R.id.closeButton);
        if (closeButton != null) {
            closeButton.setOnClickListener(v -> helpDialog.dismiss());
        } else {
            Log.e("BaseSceneActivity", "closeButton is null");
        }

        helpDialog.show();
    }

    protected void handleAction(int action, TextView scoreText, ProgressBar timerProgressBar) {
        if (algorithm.isCorrectSequence(action, correctSequence, currentStep)) {
            algorithm.correctAction();
            currentStep++;
            scoreText.setText(String.format("Score: %d", algorithm.getScore()));
            Toast.makeText(this, "Correct! Score: " + algorithm.getScore(), Toast.LENGTH_SHORT).show();
        } else {
            algorithm.wrongAction();
            scoreText.setText(String.format("Score: %d", algorithm.getScore()));
            Toast.makeText(this, "Wrong! Score: " + algorithm.getScore(), Toast.LENGTH_SHORT).show();
        }

        if (currentStep == correctSequence.length) {
            countDownTimer.cancel();
            timerRunning = false;
            long elapsedTime = maxTime - timerProgressBar.getProgress();
            endGame(username, scoreText, (int) (elapsedTime / 1000));
        }
    }

    protected void endGame(String username, TextView scoreText, int time) {
        Toast.makeText(this, "Sequence complete! Final Score: " + algorithm.getScore(), Toast.LENGTH_LONG).show();
        currentStep = 0;

        int scene = getSceneNumber();

        Intent intent = new Intent(BaseSceneActivity.this, EndScene.class);
        intent.putExtra("username", username);
        intent.putExtra("score", algorithm.getScore());
        intent.putExtra("time", time);
        intent.putExtra("scene", scene);
        startActivity(intent);
    }

    protected void startTimer(ProgressBar timerProgressBar, String username, TextView scoreText) {
        timerProgressBar.setMax((int) maxTime);
        timerProgressBar.setProgress((int) maxTime);

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
                if (currentStep < correctSequence.length) {
                    endGame(username, scoreText, (int) (elapsedTime / 1000));
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

    protected abstract int getSceneNumber();
}