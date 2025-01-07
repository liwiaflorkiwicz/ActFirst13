package com.example.actfirst1;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {
    
    private boolean isGameRunning = false;
    private int pressCount = 0;
    private int rightCount = 0;
    private final int maxPressCount = 30;
    private boolean isGreen = false;
    private final Handler handler = new Handler();

    private FloatingActionButton timeButton;
    private FloatingActionButton pushButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        String username = getIntent().getStringExtra("username");
        TextView textView = findViewById(R.id.textView8);
        textView.setText(username);

        timeButton = findViewById(R.id.timeButton);
        pushButton = findViewById(R.id.pushButton);

        timeButton.setBackgroundColor(Color.GRAY);

        timeButton.setOnClickListener(view -> {
            if (!isGameRunning) {
                startGame();
            }
        });

        //TextView rightCountTextView = findViewById(R.id.rightCount);

        pushButton.setOnClickListener(view -> {
            if (isGameRunning) {
                pressCount++;
                if (pressCount >= maxPressCount) {
                    stopGame();
                }
                if (isGreen) {
                    rightCount++;
                    //rightCountTextView.setText(String.valueOf(rightCount));
                }
            }
        });

        Button backButtonGame = findViewById(R.id.backButtonGame);
        backButtonGame.setOnClickListener(view -> {
            Intent intent = new Intent(GameActivity.this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });
    }

    private void startGame() {
        isGameRunning = true;
        pressCount = 0;
        rightCount = 0;
        timeButton.setEnabled(false);
        pushButton.setEnabled(true);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isGameRunning) {
                    changeColor();
                    handler.postDelayed(this, 1000); // Change every second
                }
            }
        }, 3000);    }

    private void stopGame() {
        isGameRunning = false;
        timeButton.setEnabled(true);
        timeButton.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
        pushButton.setEnabled(false);

        handler.removeCallbacksAndMessages(null);
    }

    private void changeColor() {
        isGreen = !isGreen;
        pushButton.setBackgroundTintList(ColorStateList.valueOf(isGreen ? Color.GREEN : Color.RED));
    }
    
}

