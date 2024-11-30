package com.example.actfirst1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private static ArrayList<GameSession> gameHistory = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        String username = getIntent().getStringExtra("username");
        TextView textView = findViewById(R.id.textView16);
        textView.setText(username);

        String gameHistory = SharedPreferencesHelper.getGameHistory(this, username);
        /*displayGameHistory();*/
        TextView historyTextView1 = findViewById(R.id.historyTextView1);
        historyTextView1.setText(gameHistory);


        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> {
            Intent intent = new Intent(HistoryActivity.this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

    }

    public static void addGameSession(String username, int scene, int score, int time) {
        gameHistory.add(new GameSession(username, scene, score, time));
    }

    /*private void displayGameHistory() {
        TextView historyTextView1 = findViewById(R.id.historyTextView1); // Create a TextView in `history.xml` to display history

        StringBuilder historyText = new StringBuilder();
        for (GameSession session : gameHistory) {
            historyText.append(String.format("Score: %d, Time: %d s\n",
                    session.getScore(),
                    session.getTime()));
        }
        historyTextView1.setText(historyText.toString());
    }*/
}
