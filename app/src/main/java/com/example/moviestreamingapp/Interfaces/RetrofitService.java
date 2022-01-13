package com.example.moviestreamingapp.Interfaces;

import com.example.moviestreamingapp.Model.MovieCredits;
import com.example.moviestreamingapp.Model.MovieDetails;
import com.example.moviestreamingapp.Model.MovieImages;
import com.example.moviestreamingapp.Model.MovieImagesBackDropsAndPosters;
import com.example.moviestreamingapp.Model.MovieResponse;
import com.example.moviestreamingapp.Model.MovieVideos;
import com.example.moviestreamingapp.Model.PersonDetails;
import com.example.moviestreamingapp.Model.PersonImages;
import com.example.moviestreamingapp.Model.PersonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService
{
    //Create service movie
    @GET("search/movie")
    Call<MovieResponse> getMoviesByQuery(@Query("api_key") String api_key, @Query("query") String query);

    //Create service for person
    @GET("movie/{movie_id}")
    Call<MovieDetails> getMovieDetailsById(@Path("movie_id") int movie_id, @Query("api_key") String api_key);

    //Create service for credit
    @GET("movie/{movie_id}/credits")
    Call<MovieCredits> getMovieCreditsById(@Path("movie_id") int movie_id, @Query("api_key") String api_key);

    //Create service for video
    @GET("movie/{movie_id}/videos")
    Call<MovieVideos> getMovieVideosById(@Path("movie_id") int movie_id, @Query("api_key") String api_key);

    //Create service for credit
    @GET("movie/{movie_id}/images")
    Call<MovieImages> getMovieImagesById(@Path("movie_id") int movie_id, @Query("api_key") String api_key);

    //Create service for person
    @GET("search/person")
    Call<PersonResponse> getPersonsByQuery(@Query("api_key") String api_key, @Query("query") String query);

    //Create service for person
    @GET("person/{person_id}")
    Call<PersonDetails> getPersonDetailsByQuery(@Path("person_id") int person_id, @Query("api_key") String api_key);

    //create service to get the images
    @GET("person/{person_id}/images")
    Call<PersonImages> getPersonImagesById(@Path("person_id") int person_id, @Query("api_key") String api_key);



}
