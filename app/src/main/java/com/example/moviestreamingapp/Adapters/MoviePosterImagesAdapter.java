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

import com.example.moviestreamingapp.ImageViewActivity;
import com.example.moviestreamingapp.Model.MovieImagesBackDropsAndPosters;
import com.example.moviestreamingapp.Model.PersonImagesProfiles;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.ViewHolders.ImagesViewHolder;

import java.util.List;

public class MoviePosterImagesAdapter extends RecyclerView.Adapter<ImagesViewHolder>
{
    private Activity activity;
    private List<MovieImagesBackDropsAndPosters> movieImagesBackDropsAndPostersList;

    public MoviePosterImagesAdapter(Activity activity, List<MovieImagesBackDropsAndPosters> movieImagesBackDropsAndPostersList) {
        this.activity = activity;
        this.movieImagesBackDropsAndPostersList = movieImagesBackDropsAndPostersList;
    }

    @NonNull
    @Override
    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(activity).inflate(R.layout.profile_images_layout, parent, false);
        return new ImagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImagesViewHolder holder, int position)
    {
        final MovieImagesBackDropsAndPosters imagesBackDropsAndPosters = movieImagesBackDropsAndPostersList.get(position);

        holder.setProfileImage(activity, imagesBackDropsAndPosters.getFile_path());

        holder.profileImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent imageViewerIntent = new Intent(activity, ImageViewActivity.class);
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, holder.profileImage, ViewCompat.getTransitionName(holder.profileImage));
                imageViewerIntent.putExtra("image_url", imagesBackDropsAndPosters.getFile_path());
                activity.startActivity(imageViewerIntent, compat.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieImagesBackDropsAndPostersList.size();
    }
}
