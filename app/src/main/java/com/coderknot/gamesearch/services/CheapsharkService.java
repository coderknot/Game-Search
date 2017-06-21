package com.coderknot.gamesearch.services;

import android.util.Log;

import com.coderknot.gamesearch.Constants;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CheapsharkService {
    public static final String TAG = CheapsharkService.class.getSimpleName();

    public static final String SORTBY_VALUE = "Title";
    public static final String DESC_VALUE = "0";

    public static void findGames(String title, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.CHEAPSHARK_BASE_URL + Constants.CHEAPSHARK_RESOURCE_DEALS).newBuilder();
        urlBuilder.addQueryParameter(Constants.CHEAPSHARK_TITLE_PARAMETER, title);
        urlBuilder.addQueryParameter(Constants.CHEAPSHARK_SORTBY_PARAMETER, SORTBY_VALUE);
        urlBuilder.addQueryParameter(Constants.CHEAPSHARK_DESC_PARAMETER, DESC_VALUE);
        String url = urlBuilder.build().toString();

        Log.v(TAG, url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public void processGames(Response response) {
        Log.v(TAG, "in processGames");
        try {
            if(response.isSuccessful()) {
                String jsonData = response.body().string();
                JSONArray gamesJSON = new JSONArray(jsonData);
                Log.v(TAG, String.valueOf(gamesJSON.length()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
