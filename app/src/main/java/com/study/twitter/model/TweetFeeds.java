package com.study.twitter.model;

public class TweetFeeds {
    private String name;
    private String username;
    private String tweet;
    private int image;

    public TweetFeeds(String name, String username, String tweet, int image) {
        this.name = name;
        this.username = username;
        this.tweet = tweet;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
