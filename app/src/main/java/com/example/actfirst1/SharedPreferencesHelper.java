package com.example.actfirst1;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    private static final String PREFS_NAME = "gameHistory";

    public static void saveGameSession(Context context, String username, int scene, int score, int time) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String key = username + "_history";

        String existingHistory = sharedPreferences.getString(key, "");

        String newHistory = existingHistory + "\nScore: " + score + ", Time: " + time + "s\n";

        editor.putString(key, newHistory);
        editor.apply();
    }

    public static String getGameHistory(Context context, String username) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // Get the user's game history
        String key = username + "_history";
        return sharedPreferences.getString(key, "No history available");
    }
}
