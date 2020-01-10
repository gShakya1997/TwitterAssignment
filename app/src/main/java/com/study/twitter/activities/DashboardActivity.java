package com.study.twitter.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.study.twitter.R;
import com.study.twitter.adapter.TweetsAdapter;
import com.study.twitter.model.TweetFeeds;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        RecyclerView recyclerView = findViewById(R.id.recyclerTweet);

        List<TweetFeeds> tweetFeeds = new ArrayList<>();

        tweetFeeds.add(new TweetFeeds("Ronaldo", "CR7", "I'm not going to retired soon", R.drawable.one));
        tweetFeeds.add(new TweetFeeds("Messi", "LM10", "Football is my love", R.drawable.two));
        tweetFeeds.add(new TweetFeeds("Neymar", "NeyJr", "Best young player", R.drawable.three));
        tweetFeeds.add(new TweetFeeds("Zidane", "zidane", "Best Manager", R.drawable.four));
        tweetFeeds.add(new TweetFeeds("Maradona", "legendM", "Legend", R.drawable.five));
        tweetFeeds.add(new TweetFeeds("Pele", "peleBest", "Best player in football history", R.drawable.six));
        tweetFeeds.add(new TweetFeeds("Mane", "maneLiverpool", "Fastest", R.drawable.seven));

        TweetsAdapter tweetsAdapter = new TweetsAdapter(this, tweetFeeds);
        recyclerView.setAdapter(tweetsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
