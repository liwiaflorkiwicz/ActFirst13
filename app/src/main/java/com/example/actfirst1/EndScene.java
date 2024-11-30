package com.example.actfirst1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndScene extends AppCompatActivity {

    // Pobierz numer poprzedniej sceny z intencji

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene_end);

        // ???
        int scene = getIntent().getIntExtra("scene", 0);
        TextView textScene = findViewById(R.id.textView14);
        textScene.setText(GameSession.getSceneName(this, scene));

        String username = getIntent().getStringExtra("username");
        TextView textUsername = findViewById(R.id.textView13);
        textUsername.setText(username);

        int scores = getIntent().getIntExtra("score", 0);
        TextView textScore = findViewById(R.id.textView23);
        textScore.setText(String.format("Score: %d", scores));

        int time = getIntent().getIntExtra("time", 0);
        TextView timeScore = findViewById(R.id.textView24);
        timeScore.setText(String.format("Time: %d s", time));

        SharedPreferencesHelper.saveGameSession(this, username, scene, scores, time);

        Button backButtonGame = findViewById(R.id.backButtonGame);
        backButtonGame.setOnClickListener(view -> {

            Class<?> targetActivity;
            switch (scene) {
                case 1:
                    targetActivity = Scene1Activity.class;
                    break;
                case 2:
                    targetActivity = Scene2Activity.class;
                    break;
                case 3:
                    targetActivity = Scene3Activity.class;
                    break;
                case 4:
                    targetActivity = Scene4Activity.class;
                    break;
                default:
                    // If no previous scene is specified, return to MainActivity
                    targetActivity = MainActivity.class;
                    break;
            }

            Intent intent = new Intent(EndScene.this, targetActivity);
            intent.putExtra("username", username);
            startActivity(intent);

        });

        Button historyButton = findViewById(R.id.historyButtonEnd);
        historyButton.setOnClickListener(view -> {
            Intent intent = new Intent(EndScene.this, HistoryActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(EndScene.this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

    }

}
