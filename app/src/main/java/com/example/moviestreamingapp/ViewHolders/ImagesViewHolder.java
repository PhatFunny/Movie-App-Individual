package com.example.moviestreamingapp.ViewHolders;

import android.app.Activity;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviestreamingapp.R;
import com.squareup.picasso.Picasso;

public class ImagesViewHolder extends RecyclerView.ViewHolder
{
    public AppCompatImageView profileImage;

    public ImagesViewHolder(@NonNull View itemView) {
        super(itemView);

        profileImage = itemView.findViewById(R.id.profile_image);
    }

    public void setProfileImage(Activity activity, String profilePath)
    {
        Picasso.with(activity).load(profilePath).into(profileImage);
    }
}
