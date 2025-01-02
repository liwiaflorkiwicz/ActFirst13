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

public class Scene4Activity extends BaseSceneActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene4);

        algorithm = new Algorithm();
        correctSequence = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        setupActionButtons();
        setupViews(R.id.textViewName4, R.id.scoreText4, R.id.progressBar4, R.id.backButtonScene4, R.id.helpButtonScene4);
    }

    private void setupActionButtons() {
        FloatingActionButton ActionButtonEncourage = findViewById(R.id.ActionButtonEncourage);
        ActionButtonEncourage.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "COUGH ENCOURAGED", Toast.LENGTH_LONG).show();
            handleAction(3, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });

        FloatingActionButton ActionButtonCheckAirway = findViewById(R.id.ActionButtonCheckAirway);
        ActionButtonCheckAirway.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "AIRWAY CHECKED", Toast.LENGTH_LONG).show();
            handleAction(4, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });

        FloatingActionButton ActionButtonCPR = findViewById(R.id.ActionButtonCPR);
        ActionButtonCPR.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "CPR STARTED", Toast.LENGTH_LONG).show();
            handleAction(7, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });

        FloatingActionButton ActionButtonSafety = findViewById(R.id.ActionButtonSafety);
        ActionButtonSafety.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "SAFETY CHECKED", Toast.LENGTH_LONG).show();
            handleAction(1, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });

        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "999 CALLED", Toast.LENGTH_LONG).show();
            handleAction(8, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });

        FloatingActionButton ActionButtonObserve = findViewById(R.id.ActionButtonObserve);
        ActionButtonObserve.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "PERSON OBSERVED", Toast.LENGTH_LONG).show();
            handleAction(2, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });

        FloatingActionButton ActionButtonHeimlich = findViewById(R.id.ActionButtonHeimlich);
        ActionButtonHeimlich.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "HEIMLICH MANEUVER PERFORMED", Toast.LENGTH_LONG).show();
            handleAction(6, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });

        FloatingActionButton ActionButtonBackBlow = findViewById(R.id.ActionButtonBackBlows);
        ActionButtonBackBlow.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "BACK BLOWS PERFORMED", Toast.LENGTH_LONG).show();
            handleAction(5, findViewById(R.id.scoreText4), findViewById(R.id.progressBar4));
        });
    }

    @Override
    protected int getSceneNumber() {
        return 4;
    }

}
    /*private Algorithm algorithmScene4;
    private int currentStep = 0;
    private final int[] correctSequence4 = {1, 2, 3, 4, 5, 6, 7, 8};
    private CountDownTimer countDownTimer;
    private boolean timerRunning = false;
    private long maxTime = 60000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene4);

        String username = getIntent().getStringExtra("username");
        TextView textView = findViewById(R.id.textView8);
        textView.setText(username);

        TextView scoreText4 = findViewById(R.id.scoreText4);
        ProgressBar timerProgressBar4 = findViewById(R.id.progressBar4);

        algorithmScene4 = new Algorithm();
        startTimer(timerProgressBar4, username, scoreText4);

        setupActionButtons(scoreText4, timerProgressBar4);
        setupNavigationButtons(username);
    }
        *//*FloatingActionButton ActionButtonObserve = findViewById(R.id.ActionButtonObserve);
        ActionButtonObserve.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "PERSON OBSERVED", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonBlood = findViewById(R.id.ActionButtonBlood);
        ActionButtonBlood.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "BLOOD CIRCULATION CHECKED", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonHot = findViewById(R.id.ActionButtonHot);
        ActionButtonHot.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "WARM HAS BEN ENSURED", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonCheckBreath = findViewById(R.id.ActionButtonCheckBreath);
        ActionButtonCheckBreath.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "BREATH CHECKED", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonCheckCons = findViewById(R.id.ActionButtonCheckCons);
        ActionButtonCheckCons.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "CONSCIOUSNESS CHECKED", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonCPR = findViewById(R.id.ActionButtonCPR);
        ActionButtonCPR.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "PERFORMING CPR", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonSafety = findViewById(R.id.ActionButtonSafety);
        ActionButtonSafety.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "SURROUNDINGS IS SAFE", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene3Activity.this, "999 CALLED, AMBULANCE ON THEIR WAY", Toast.LENGTH_LONG).show();
        });*//*

    private void setupActionButtons(TextView scoreText4, ProgressBar timerProgressBar4) {
        FloatingActionButton ActionButtonEncourage = findViewById(R.id.ActionButtonEncourage);
        ActionButtonEncourage.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "COUGH ENCOURAGED", Toast.LENGTH_LONG).show();
            handleAction(3, scoreText4, timerProgressBar4);
        });

        FloatingActionButton ActionButtonCheckAirway = findViewById(R.id.ActionButtonCheckAirway);
        ActionButtonCheckAirway.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "AIRWAY CHECKED", Toast.LENGTH_LONG).show();
            handleAction(4, scoreText4, timerProgressBar4);
        });

        FloatingActionButton ActionButtonCPR = findViewById(R.id.ActionButtonCPR);
        ActionButtonCPR.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "CPR STARTED", Toast.LENGTH_LONG).show();
            handleAction(7, scoreText4, timerProgressBar4);
        });

        FloatingActionButton ActionButtonSafety = findViewById(R.id.ActionButtonSafety);
        ActionButtonSafety.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "SAFETY CHECKED", Toast.LENGTH_LONG).show();
            handleAction(1, scoreText4, timerProgressBar4);
        });

        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "999 CALLED", Toast.LENGTH_LONG).show();
            handleAction(8, scoreText4, timerProgressBar4);
        });

        FloatingActionButton ActionButtonObserve = findViewById(R.id.ActionButtonObserve);
        ActionButtonObserve.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "PERSON OBSERVED", Toast.LENGTH_LONG).show();
            handleAction(2, scoreText4, timerProgressBar4);
        });

        FloatingActionButton ActionButtonHeimlich = findViewById(R.id.ActionButtonHeimlich);
        ActionButtonHeimlich.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "HEIMLICH MANEUVER PERFORMED", Toast.LENGTH_LONG).show();
            handleAction(6, scoreText4, timerProgressBar4);
        });

        FloatingActionButton ActionButtonBackBlow = findViewById(R.id.ActionButtonBackBlows);
        ActionButtonBackBlow.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "BACK BLOWS PERFORMED", Toast.LENGTH_LONG).show();
            handleAction(5, scoreText4, timerProgressBar4);
        });
    }

    private void setupNavigationButtons(String username) {
        Button backButtonScene4 = findViewById(R.id.backButtonScene4);
        backButtonScene4.setOnClickListener(view -> {
            Intent intent = new Intent(Scene4Activity.this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        Button helpButtonScene4 = findViewById(R.id.helpButtonScene4);
        helpButtonScene4.setOnClickListener(view -> showHelpDialogScene4());
    }

    private void handleAction(int action, TextView scoreText4, ProgressBar timerProgressBar4) {
        if (algorithmScene4.isCorrectSequence(action, correctSequence4, currentStep)) {
            algorithmScene4.correctAction();
            currentStep++;
            scoreText4.setText(String.format("Score: %d", algorithmScene4.getScore()));
            Toast.makeText(this, "Correct! Score: " + algorithmScene4.getScore(), Toast.LENGTH_SHORT).show();
        } else {
            algorithmScene4.wrongAction();
            scoreText4.setText(String.format("Score: %d", algorithmScene4.getScore()));
            Toast.makeText(this, "Wrong! Score: " + algorithmScene4.getScore(), Toast.LENGTH_SHORT).show();
        }

        if (currentStep == correctSequence4.length) {
            countDownTimer.cancel();
            timerRunning = false;
            long elapsedTime = maxTime - timerProgressBar4.getProgress();
            endGame("username", scoreText4, (int) (elapsedTime / 1000));
        }
    }

    private void endGame(String username, TextView scoreText4, int time) {
        Toast.makeText(this, "Sequence complete! Final Score: " + algorithmScene4.getScore(), Toast.LENGTH_LONG).show();
        currentStep = 0;

        int scene = 4;
        HistoryActivity.addGameSession(username, scene, algorithmScene4.getScore(), time);

        Intent intent = new Intent(Scene4Activity.this, EndScene.class);
        intent.putExtra("username", username);
        intent.putExtra("score", algorithmScene4.getScore());
        intent.putExtra("time", time);
        intent.putExtra("scene", scene);
        startActivity(intent);
    }

    private void startTimer(ProgressBar timerProgressBar4, String username, TextView scoreText4) {
        timerProgressBar4.setMax((int) maxTime);
        timerProgressBar4.setProgress((int) maxTime);

        countDownTimer = new CountDownTimer(maxTime, 1000) {
            long elapsedTime = 0;

            @Override
            public void onTick(long millisUntilFinished) {
                timerProgressBar4.setProgress((int) millisUntilFinished);
                elapsedTime = maxTime - millisUntilFinished;
            }

            @Override
            public void onFinish() {
                timerProgressBar4.setProgress(0);
                if (currentStep < correctSequence4.length) {
                    endGame(username, scoreText4, (int) elapsedTime / 1000);
                }
            }
        };
        countDownTimer.start();
        timerRunning = true;
    }

    private void showHelpDialogScene4() {

        Dialog helpDialog = new Dialog(this);
        helpDialog.setContentView(R.layout.dialog_scene4_help);

        ImageView closeButton = helpDialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> helpDialog.dismiss());

        helpDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timerRunning) {
            countDownTimer.cancel();
        }
    }*/


    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene4);

        String username = getIntent().getStringExtra("username");
        TextView textView = findViewById(R.id.textView8);
        textView.setText(username);

        FloatingActionButton ActionButtonEncourage = findViewById(R.id.ActionButtonEncourage);
        ActionButtonEncourage.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "COUGH ENCOURAGED", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonCheckAirway = findViewById(R.id.ActionButtonCheckAirway);
        ActionButtonCheckAirway.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "AIRWAY CHECKED", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonCPR = findViewById(R.id.ActionButtonCPR);
        ActionButtonCPR.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "CPR STARTED", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonSafety = findViewById(R.id.ActionButtonSafety);
        ActionButtonSafety.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "SAFETY CHECKED", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "999 CALLED", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonObserve = findViewById(R.id.ActionButtonObserve);
        ActionButtonObserve.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "PERSON OBSERVED", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonHeimlich = findViewById(R.id.ActionButtonHeimlich);
        ActionButtonHeimlich.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "HEIMLICH MANEUVER PERFORMED", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonBackBlow = findViewById(R.id.ActionButtonBackBlows);
        ActionButtonBackBlow.setOnClickListener(view -> {
            Toast.makeText(Scene4Activity.this, "BACK BLOWS PERFORMED", Toast.LENGTH_LONG).show();
        });


        Button backButtonScene3 = findViewById(R.id.backButtonScene4);
        backButtonScene3.setOnClickListener(view -> {
            Intent intent = new Intent(Scene4Activity.this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        Button helpButtonScene4 = findViewById(R.id.helpButtonScene4);
        helpButtonScene4.setOnClickListener(view -> showHelpDialogScene4());
    }

    private void showHelpDialogScene4() {

        Dialog helpDialog = new Dialog(this);
        helpDialog.setContentView(R.layout.dialog_scene4_help);

        ImageView closeButton = helpDialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> helpDialog.dismiss());

        helpDialog.show();
    }*/

