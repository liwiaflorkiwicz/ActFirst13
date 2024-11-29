package com.example.actfirst1;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String username = getIntent().getStringExtra("username");
        TextView textView = findViewById(R.id.textView);
        textView.setText(username);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button helpButton = findViewById(R.id.helpButton);
        helpButton.setOnClickListener(view -> showHelpDialog());

        ImageButton scene1Button = findViewById(R.id.scene1Button);
        scene1Button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Scene1Activity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        ImageButton scene2Button = findViewById(R.id.scene2Button);
        scene2Button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Scene2Activity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });

        ImageButton scene3Button = findViewById(R.id.scene3Button);
        scene3Button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Scene3Activity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });
    }

    private void showHelpDialog() {

        Dialog helpDialog = new Dialog(this);
        helpDialog.setContentView(R.layout.dialog_main_help);

        ImageView closeButton = helpDialog.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(v -> helpDialog.dismiss());

        TextView mainHelp = helpDialog.findViewById(R.id.mainHelp);
        mainHelp.setText(R.string.helpText2main);

        helpDialog.show();
    }
}