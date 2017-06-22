package com.coderknot.gamesearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.coderknot.gamesearch.adapters.GamesListAdapter;
import com.coderknot.gamesearch.models.Game;
import com.coderknot.gamesearch.services.CheapsharkService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class GamesListActivity extends AppCompatActivity {
    private static final String TAG = GamesListActivity.class.getSimpleName();
    private GamesListAdapter gamesListAdapter;
    private ArrayList<Game> gamesList = new ArrayList<>();

    @Bind(R.id.gameRecyclerView) RecyclerView gameRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_list);
        ButterKnife.bind(this);

        Intent gameSearchIntent = getIntent();
        String game = gameSearchIntent.getStringExtra("game");

        Log.v(TAG, game);
        getGamesList(game);
    }

    private void getGamesList(String game) {
        final CheapsharkService cheapsharkService = new CheapsharkService();

        cheapsharkService.findGames(game, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.v(TAG, response.toString());
                gamesList = cheapsharkService.processGames(response);

                GamesListActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        gamesListAdapter = new GamesListAdapter(getApplicationContext(), gamesList);
                        gameRecyclerView.setAdapter(gamesListAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(GamesListActivity.this);
                        gameRecyclerView.setLayoutManager(layoutManager);
                        gameRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}
