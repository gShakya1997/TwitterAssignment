package com.study.twitter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.study.twitter.R;
import com.study.twitter.model.TweetFeeds;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.TweetsViewAdapter> {

    Context context;
    List<TweetFeeds> tweetFeedsList;

    public TweetsAdapter(Context context, List<TweetFeeds> tweetFeedsList) {
        this.context = context;
        this.tweetFeedsList = tweetFeedsList;
    }

    @NonNull
    @Override
    public TweetsViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tweetfeed, parent, false);
        return new TweetsViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TweetsViewAdapter holder, int position) {
        final TweetFeeds tweetFeeds = tweetFeedsList.get(position);
        holder.circleImageView.setImageResource(tweetFeeds.getImage());
        holder.tv1.setText(tweetFeeds.getUsername());
        holder.tv2.setText(tweetFeeds.getName());
        holder.tv3.setText(tweetFeeds.getTweet());
    }

    @Override
    public int getItemCount() {
        return tweetFeedsList.size();
    }

    public class TweetsViewAdapter extends RecyclerView.ViewHolder {

        private CircleImageView circleImageView;
        private TextView tv1, tv2, tv3;

        public TweetsViewAdapter(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.nameTv);
            tv2 = itemView.findViewById(R.id.usernameTv);
            tv3 = itemView.findViewById(R.id.timeTv);
            circleImageView = itemView.findViewById(R.id.imgProfile);
        }
    }
}
