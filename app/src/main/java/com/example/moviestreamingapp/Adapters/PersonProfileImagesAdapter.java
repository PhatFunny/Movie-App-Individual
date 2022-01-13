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
import com.example.moviestreamingapp.Model.PersonImagesProfiles;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.ViewHolders.ImagesViewHolder;

import java.util.List;

public class PersonProfileImagesAdapter extends RecyclerView.Adapter<ImagesViewHolder>
{
    private Activity activity;
    private List<PersonImagesProfiles> profileImagesList;

    public PersonProfileImagesAdapter(Activity activity, List<PersonImagesProfiles> profileImagesList) {
        this.activity = activity;
        this.profileImagesList = profileImagesList;
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
        PersonImagesProfiles imagesProfiles = profileImagesList.get(position);

        holder.setProfileImage(activity, imagesProfiles.getFile_path());

        holder.profileImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent imageViewerIntent = new Intent(activity, ImageViewActivity.class);
                ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, holder.profileImage, ViewCompat.getTransitionName(holder.profileImage));
                imageViewerIntent.putExtra("image_url", imagesProfiles.getFile_path());
                activity.startActivity(imageViewerIntent, compat.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return profileImagesList.size();
    }
}
