package com.example.actfirst1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginRegister extends AppCompatActivity {

    private EditText usernameField, passwordField;
    private Button btnLogin, btnRegister;

    private SharedPreferences preferences;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.passwordField);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        preferences = getSharedPreferences("user_preferences", MODE_PRIVATE);

        // if uncommented not need for login
        /*if (preferences.getBoolean("is_logged_in", false)) {
            goToMain(preferences.getString("username","Guest"));
        }*/

        btnLogin.setOnClickListener(v -> {
            String username = usernameField.getText().toString();
            String password = passwordField.getText().toString();

            String storedUsername = preferences.getString("username",null);
            String storedPassword = preferences.getString("password", null);

            if (storedUsername != null && storedPassword != null
                    && storedUsername.equals(username) && storedPassword.equals(password)) {
                preferences.edit().putBoolean("is_logged_in", true).apply();
                goToMain(username);
            }
            else if (storedUsername.equals(username) && !storedPassword.equals(password)) {
                Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "No such user, user not registered", Toast.LENGTH_SHORT).show();
            }
        });


        btnRegister.setOnClickListener(v -> {
            String username = usernameField.getText().toString();
            String password = passwordField.getText().toString();

            preferences.edit()
                    .putString("username", username)
                    .putString("password", password)
                    .putString("scores", "No scores yet")
                    .apply();

            Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show();
        });
    }

    private void goToMain(String username) {
        Intent intent = new Intent(this, MainActivity.class); // Change MainActivity to your target activity
        intent.putExtra("username", username); // Pass username to the next activity
        startActivity(intent);
        finish(); // Close the current activity
    }
}
