package com.example.actfirst1;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Scene3Activity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene3);

        String username = getIntent().getStringExtra("username");
        TextView textView = findViewById(R.id.textView8);
        textView.setText(username);

        FloatingActionButton ActionButtonObserve = findViewById(R.id.ActionButtonObserve);
        ActionButtonObserve.setOnClickListener(view -> Toast.makeText(Scene3Activity.this, "PERSON OBSERVED", Toast.LENGTH_LONG).show());

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
        });

        Button backButtonScene3 = findViewById(R.id.backButtonScene1);
        backButtonScene3.setOnClickListener(view -> {
            Intent intent = new Intent(Scene3Activity.this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        Button helpButtonScene3 = findViewById(R.id.helpButtonScene3);
        helpButtonScene3.setOnClickListener(view -> showHelpDialogScene3());
    }

    private void showHelpDialogScene3() {

        Dialog helpDialog = new Dialog(this);
        helpDialog.setContentView(R.layout.dialog_scene3_help);

        ImageView closeButton = helpDialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> helpDialog.dismiss());

        helpDialog.show();
    }
}

