package com.coderknot.gamesearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.gameSearchButton) Button mGameSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mGameSearchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mGameSearchButton) {
            Intent gameSearchIntent = new Intent(MainActivity.this, GameSearchActivity.class);
            startActivity(gameSearchIntent);
        }
    }
}
