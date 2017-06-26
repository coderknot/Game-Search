package com.coderknot.gamesearch.adapters;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coderknot.gamesearch.GamesListActivity;
import com.coderknot.gamesearch.R;
import com.coderknot.gamesearch.fragments.AddGameDialogFragment;
import com.coderknot.gamesearch.models.Game;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GamesListAdapter extends RecyclerView.Adapter<GamesListAdapter.GameViewHolder> {
    private ArrayList<Game> gamesList = new ArrayList<>();
    private Context context;

    public GamesListAdapter(Context context, ArrayList<Game> gamesList) {
        this.context = context;
        this.gamesList = gamesList;
    }

    @Override
    public GamesListAdapter.GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_list_item, parent, false);
        GameViewHolder gameViewHolder = new GameViewHolder(view);
        return gameViewHolder;
    }

    public void onBindViewHolder(GamesListAdapter.GameViewHolder viewHolder, int position) {
        viewHolder.bindGame(gamesList.get(position));
    }

    @Override
    public int getItemCount() {
        return gamesList.size();
    }

    public class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.gameTitleTextView) TextView gameTitleTextView;
        @Bind(R.id.gameThumbImageView) ImageView gameThumbImageView;
        @Bind(R.id.gameAddIconImageView) ImageView gameAddIconImageView;

        public GameViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();

            gameAddIconImageView.setOnClickListener(this);
        }

        public void bindGame(Game game) {
            gameTitleTextView.setText(game.getTitle());

            if(!(game.getThumbnailURL().equals(""))) {
                Picasso.with(context).load(game.getThumbnailURL()).into(gameThumbImageView);
            }
        }

        @Override
        public void onClick(View v) {
            if(v == gameAddIconImageView) {
                FragmentManager fragmentManager = ((GamesListActivity) context).getFragmentManager();
                AddGameDialogFragment addGameDialogFragment = new AddGameDialogFragment();
                addGameDialogFragment.show(fragmentManager, "Add Game Fragment");
            }
        }
    }
}
