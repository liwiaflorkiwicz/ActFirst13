package com.example.actfirst1;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Scene1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scene1); // load layout scene1.xml

        FloatingActionButton ActionButtonSafety = findViewById(R.id.ActionButtonSafety);
        FloatingActionButton ActionButtonCheckCons = findViewById(R.id.ActionButtonCheckCons);
        FloatingActionButton ActionButtonPerfBreath = findViewById(R.id.ActionButtonPerfBreath);
        FloatingActionButton ActionButtonBlood = findViewById(R.id.ActionButtonBlood);
        FloatingActionButton ActionButtonCall999 = findViewById(R.id.ActionButtonCall999);
        FloatingActionButton ActionButtonCompression = findViewById(R.id.ActionButtonCompression);
        FloatingActionButton ActionButtonHelp = findViewById(R.id.ActionButtonHelp);
        FloatingActionButton ActionButtonCheckBreath = findViewById(R.id.ActionButtonCheckBreath);

        ActionButtonSafety.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "SURROUNDINGS IS SAFE", Toast.LENGTH_LONG).show();
        });

        ActionButtonCheckCons.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "PERSON IS UNCONSCIOUS", Toast.LENGTH_LONG).show();
        });

        ActionButtonCheckBreath.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "PERSON IS NOT BREATHING", Toast.LENGTH_LONG).show();
        });

        ActionButtonBlood.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "BLOOD FLOW UNNOTICEABLE", Toast.LENGTH_LONG).show();
        });

        ActionButtonCall999.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "999 CALLED \n AMBULANCE ON THEIR WAY", Toast.LENGTH_LONG).show();
        });

        ActionButtonCompression.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "30 COMPRESSIONS PERFORMED", Toast.LENGTH_LONG).show();
        });

        ActionButtonHelp.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "HELP CALLED, PERSON ON THEIR WAY", Toast.LENGTH_LONG).show();
        });

        ActionButtonPerfBreath.setOnClickListener(view -> {
            Toast.makeText(Scene1Activity.this, "2 BREATHS PERFORMED", Toast.LENGTH_LONG).show();
        });

        Button backButtonScene1 = findViewById(R.id.backButtonScene1);
        backButtonScene1.setOnClickListener(view -> {
            Intent intent = new Intent(Scene1Activity.this, MainActivity.class);
            startActivity(intent);
        });

        Button helpButtonScene1 = findViewById(R.id.helpButtonScene1);
        helpButtonScene1.setOnClickListener(view -> showHelpDialogScene1());

    }

    private void showHelpDialogScene1() {

        Dialog helpDialog = new Dialog(this);
        helpDialog.setContentView(R.layout.dialog_scene1_help);

        ImageView closeButton = helpDialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> helpDialog.dismiss());

        helpDialog.show();
    }

}
