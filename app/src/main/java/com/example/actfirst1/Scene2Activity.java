package com.example.actfirst1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Scene2Activity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene2);

        FloatingActionButton ActionButtonComfort = findViewById(R.id.ActionButtonComfort);
        ActionButtonComfort.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Person is being comforted", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonWound = findViewById(R.id.ActionButtonWound);
        ActionButtonWound.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Wound is covered", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonElevate = findViewById(R.id.ActionButtonElevate);
        ActionButtonElevate.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Person is elevated", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonImmobilize = findViewById(R.id.ActionButtonImmobilize);
        ActionButtonImmobilize.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Leg is immobilized", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonMonitorConditions = findViewById(R.id.ActionButtonMonitorConditions);
        ActionButtonMonitorConditions.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Monitoring conditions", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonSafety = findViewById(R.id.ActionButtonSafety);
        ActionButtonSafety.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "Surroundings are safe", Toast.LENGTH_LONG).show();
        });

        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene2Activity.this, "999 is called", Toast.LENGTH_LONG).show();
        });

        Button backButtonScene2 = findViewById(R.id.backButtonScene2);
        backButtonScene2.setOnClickListener(view -> {
            Intent intent = new Intent(Scene2Activity.this, MainActivity.class);
            startActivity(intent);
        });

    }
}
