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

public class Scene4Activity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
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
    }
}

