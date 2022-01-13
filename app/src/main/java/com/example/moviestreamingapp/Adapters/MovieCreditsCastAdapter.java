package com.example.moviestreamingapp.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviestreamingapp.Model.MovieCreditsCast;
import com.example.moviestreamingapp.Model.MovieCreditsCrew;
import com.example.moviestreamingapp.PersonDetailActivity;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.ViewHolders.MovieCreditsViewHolder;

import java.util.List;

public class MovieCreditsCastAdapter extends RecyclerView.Adapter<MovieCreditsViewHolder>
{
    private Activity activity;
    private List<MovieCreditsCast> movieCreditsCastList;

    public MovieCreditsCastAdapter(Activity activity, List<MovieCreditsCast> movieCreditsCastList) {
        this.activity = activity;
        this.movieCreditsCastList = movieCreditsCastList;
    }

    @NonNull
    @Override
    public MovieCreditsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(activity).inflate(R.layout.movie_credits_layout, parent, false);
        return new MovieCreditsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieCreditsViewHolder holder, int position)
    {
        final MovieCreditsCast movieCreditsCast = movieCreditsCastList.get(position);

        holder.setMovieCreditsImageView(activity, movieCreditsCast.getProfile_path());

        holder.movieCreditsName.setText(movieCreditsCast.getName());
        holder.movieCreditsCharacter.setText("Character : " + movieCreditsCast.getCharacter());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(activity, PersonDetailActivity.class);
                intent.putExtra("id", String.valueOf(movieCreditsCast.getId()));
                activity.startActivity(intent);

                activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return movieCreditsCastList.size();
    }
}
