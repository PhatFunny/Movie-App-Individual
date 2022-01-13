package com.example.moviestreamingapp.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviestreamingapp.Model.MovieCreditsCast;
import com.example.moviestreamingapp.Model.MovieDetailsProductionCompanies;
import com.example.moviestreamingapp.PersonDetailActivity;
import com.example.moviestreamingapp.R;
import com.example.moviestreamingapp.ViewHolders.MovieCreditsViewHolder;
import com.example.moviestreamingapp.ViewHolders.MovieProductionCompaniesViewHolder;

import java.util.List;

public class MovieProductionCompaniesAdapter extends RecyclerView.Adapter<MovieProductionCompaniesViewHolder>
{
    private Activity activity;
    private List<MovieDetailsProductionCompanies> movieDetailsProductionCompaniesList;

    public MovieProductionCompaniesAdapter(Activity activity, List<MovieDetailsProductionCompanies> movieDetailsProductionCompaniesList) {
        this.activity = activity;
        this.movieDetailsProductionCompaniesList = movieDetailsProductionCompaniesList;
    }

    @NonNull
    @Override
    public MovieProductionCompaniesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(activity).inflate(R.layout.production_company_layout, parent, false);
        return new MovieProductionCompaniesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieProductionCompaniesViewHolder holder, int position)
    {
        final MovieDetailsProductionCompanies movieDetailsProductionCompanies = movieDetailsProductionCompaniesList.get(position);

        holder.setProductionCompanyImageView(activity, movieDetailsProductionCompanies.getLogo_path());

        holder.productionCompanyName.setText(movieDetailsProductionCompanies.getName());

    }

    @Override
    public int getItemCount()
    {
        return movieDetailsProductionCompaniesList.size();
    }
}
