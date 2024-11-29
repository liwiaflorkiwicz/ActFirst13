package com.example.actfirst1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndScene extends AppCompatActivity {

    public static final int SCENE_1 = 1;
    public static final int SCENE_2 = 2;
    public static final int SCENE_3 = 3;
    public static final int SCENE_4 = 4;

    // Pobierz numer poprzedniej sceny z intencji

    int previousScene = getIntent().getIntExtra("previous_scene", SCENE_1);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene_end);

        String username = getIntent().getStringExtra("username");
        TextView textView = findViewById(R.id.textView13);
        textView.setText(username);

        String sceneName = getIntent().getStringExtra("sceneName");
        TextView textView2 = findViewById(R.id.textView14);
        textView2.setText(sceneName);

        Button backButtonGame = findViewById(R.id.backButtonGame);
        backButtonGame.setOnClickListener(view -> {
            Class<?> targetActivity = null;
            switch (previousScene) {
                case SCENE_1:
                    targetActivity = Scene1Activity.class;
                    break;
                case SCENE_2:
                    targetActivity = Scene2Activity.class;
                    break;
                case SCENE_3:
                    targetActivity = Scene3Activity.class;
                    break;
                case SCENE_4:
                    targetActivity = Scene4Activity.class;
                    break;
            }

            if (targetActivity != null) {
                Intent intent = new Intent(EndScene.this, targetActivity);
                intent.putExtra("username", username);
                startActivity(intent);
            }
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
