package com.coderknot.gamesearch.models;

public class Game {
    String gameId;
    String title;
    String releaseDate;
    String storeId;
    String normalPrice;
    String salePrice;
    String thumbnailURL;

    public Game(String gameId, String title, String releaseDate, String storeId, String normalPrice, String salePrice, String thumbnailURL) {
        this.gameId = gameId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.storeId = storeId;
        this.normalPrice = normalPrice;
        this.salePrice = salePrice;
        this.thumbnailURL = thumbnailURL;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }

    public String getStoreId() {
        return this.storeId;
    }

    public String getNormalPrice() {
        return this.normalPrice;
    }

    public String getSalePrice() {
        return this.salePrice;
    }

    public String getThumbnailURL() {
        return this.thumbnailURL;
    }

}
