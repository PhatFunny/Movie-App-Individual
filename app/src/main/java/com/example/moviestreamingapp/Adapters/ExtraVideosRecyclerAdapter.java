package com.example.moviestreamingapp.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviestreamingapp.Model.MovieVideosResults;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.VideoPlayActivity;
import com.example.moviestreamingapp.ViewHolders.MovieVideosViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ExtraVideosRecyclerAdapter extends RecyclerView.Adapter<MovieVideosViewHolder>
{
    private Activity activity;
    private List<MovieVideosResults> movieVideosResultsList;

    public ExtraVideosRecyclerAdapter(Activity activity, List<MovieVideosResults> movieVideosResultsList) {
        this.activity = activity;
        this.movieVideosResultsList = movieVideosResultsList;
    }

    @NonNull
    @Override
    public MovieVideosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(activity).inflate(R.layout.video_layout, parent, false);
        return new MovieVideosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieVideosViewHolder holder, int position)
    {
        MovieVideosResults movieVideosResults = movieVideosResultsList.get(position);

        String baseUrl = "https://www.youtube.com/watch?v=";

        String videoUrl = baseUrl + movieVideosResults.getKey();

        holder.setThumbnailView(activity, videoUrl);
        holder.videoTitle.setText(movieVideosResults.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ArrayList<MovieVideosResults> movieVideosResultsArrayList = new ArrayList<>(movieVideosResultsList);

                Intent intent = new Intent(activity, VideoPlayActivity.class);

                //set animation to open the video

                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, holder.thumbnailView, ViewCompat.getTransitionName(holder.thumbnailView));

                //put the current video position and video list

                intent.putExtra("position", String.valueOf(holder.getAdapterPosition()));
                intent.putExtra("video", movieVideosResultsArrayList);

                activity.startActivity(intent, compat.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieVideosResultsList.size();
    }
}
