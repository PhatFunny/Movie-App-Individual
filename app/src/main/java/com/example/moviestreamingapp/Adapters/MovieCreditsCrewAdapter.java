package com.example.moviestreamingapp.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviestreamingapp.Model.MovieCreditsCrew;
import com.example.moviestreamingapp.PersonDetailActivity;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.ViewHolders.MovieCreditsViewHolder;

import java.util.List;

public class MovieCreditsCrewAdapter extends RecyclerView.Adapter<MovieCreditsViewHolder>
{
    private Activity activity;
    private List<MovieCreditsCrew> movieCreditsCrewsList;

    public MovieCreditsCrewAdapter(Activity activity, List<MovieCreditsCrew> movieCreditsCrewsList) {
        this.activity = activity;
        this.movieCreditsCrewsList = movieCreditsCrewsList;
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
        MovieCreditsCrew movieCreditsCrew = movieCreditsCrewsList.get(position);

        holder.setMovieCreditsImageView(activity, movieCreditsCrew.getProfile_path());

        holder.movieCreditsName.setText(movieCreditsCrew.getName());
        holder.movieCreditsCharacter.setText("Department : " + movieCreditsCrew.getDepartment());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(activity, PersonDetailActivity.class);
                intent.putExtra("id", String.valueOf(movieCreditsCrew.getId()));
                activity.startActivity(intent);

                activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return movieCreditsCrewsList.size();
    }
}
