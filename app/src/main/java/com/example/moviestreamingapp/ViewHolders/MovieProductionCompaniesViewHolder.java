package com.example.moviestreamingapp.ViewHolders;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviestreamingapp.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

public class MovieProductionCompaniesViewHolder extends RecyclerView.ViewHolder
{
    private KenBurnsView productionCompanyImageView;

    public AppCompatTextView productionCompanyName;

    public MovieProductionCompaniesViewHolder(@NonNull View itemView)
    {
        super(itemView);

        productionCompanyImageView = itemView.findViewById(R.id.production_company_image_view);

        productionCompanyName = itemView.findViewById(R.id.production_company_name);


    }

    public void setProductionCompanyImageView(Context context, String imageUrl)
    {
        Picasso.with(context).load(imageUrl).into(productionCompanyImageView);
    }
}
