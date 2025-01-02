package com.example.actfirst1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;

public class HistoryActivity extends AppCompatActivity {

    //private static ArrayList<GameSession> gameHistory = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        String username = getIntent().getStringExtra("username");
        TextView textView = findViewById(R.id.textView16);
        textView.setText(username);

        String gameHistory1 = SharedPreferencesHelper.getGameHistory(this, username, 1);
        String gameHistory2 = SharedPreferencesHelper.getGameHistory(this, username, 2);
        String gameHistory3 = SharedPreferencesHelper.getGameHistory(this, username, 3);
        String gameHistory4 = SharedPreferencesHelper.getGameHistory(this, username, 4);

        TextView historyTextView1 = findViewById(R.id.historyTextView1);
        TextView historyTextView2 = findViewById(R.id.historyTextView2);
        TextView historyTextView3 = findViewById(R.id.historyTextView3);
        TextView historyTextView4 = findViewById(R.id.historyTextView4);

        /*historyTextView1.setText(displayGameHistory(1));
        historyTextView2.setText(displayGameHistory(2));
        historyTextView3.setText(displayGameHistory(3));
        historyTextView4.setText(displayGameHistory(4));*/

        historyTextView1.setText(gameHistory1);
        historyTextView2.setText(gameHistory2);
        historyTextView3.setText(gameHistory3);
        historyTextView4.setText(gameHistory4);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(HistoryActivity.this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

    }

    public static void addGameSession(Context context, String username, int scene, int score, int time) {
        //gameHistory.add(new GameSession(username, scene, score, time));
        SharedPreferencesHelper.saveGameSession(context, username, scene, score, time);

    }

    /*private String displayGameHistory(int scene) {
        StringBuilder historyText = new StringBuilder();
        for (GameSession session : gameHistory) {
            if (session.getScene() == scene) {
                historyText.append(String.format(Locale.getDefault(), "Score: %d, Time: %d s\n",
                        session.getScore(), session.getTime()));
            }
        }
        return historyText.toString();
    }*/
}
