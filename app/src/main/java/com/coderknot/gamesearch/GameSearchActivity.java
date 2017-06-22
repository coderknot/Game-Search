package com.coderknot.gamesearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameSearchActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.gameEditText) EditText mGameEditText;
    @Bind(R.id.gameSearchSubmitButton) Button mGameSearchSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_search);
        ButterKnife.bind(this);

        mGameSearchSubmitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mGameSearchSubmitButton) {
            String game = mGameEditText.getText().toString().toLowerCase();

            if(!isValidSearchText(game)) {
                return;
            }

            Intent gameSearchIntent = new Intent(GameSearchActivity.this, GamesListActivity.class);
            gameSearchIntent.putExtra("game", game);
            startActivity(gameSearchIntent);
        }
    }

    private boolean isValidSearchText(String searchText) {
        if (searchText.equals("")) {
            mGameEditText.setError("Please enter a game.");
            return false;
        }

        return true;
    }
}
