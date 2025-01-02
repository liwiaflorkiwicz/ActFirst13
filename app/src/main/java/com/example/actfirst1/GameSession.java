package com.example.actfirst1;

import android.content.Context;

public class GameSession {
    public String username;
    public int scene;
    public int score;
    public int time;

    public GameSession(String username, int scene, int score, int time) {
        this.username = username;
        this.scene = scene;
        this.score = score;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public int getScene() {
        return scene;
    }

    public int getScore() {
        return score;
    }

    public int getTime() {
        return time;
    }

    public static String getSceneName(Context context, int scene) {
        switch (scene) {
            case 1: return context.getResources().getString(R.string.Scene1Name);
            case 2: return context.getResources().getString(R.string.Scene2Name);
            case 3: return context.getResources().getString(R.string.Scene3Name);
            case 4: return context.getResources().getString(R.string.Scene4Name);
            default: return "Unknown Scene";
        }
    }

}
