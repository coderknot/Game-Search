package com.coderknot.gamesearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class GamesListActivity extends AppCompatActivity {
    private static final String TAG = GamesListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);

        Intent gameSearchIntent = getIntent();
        String game = gameSearchIntent.getStringExtra("game");

        Log.v(TAG, game);
    }
}
