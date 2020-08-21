package com.olga.jokes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JokeApi {
    @GET("random/{count}")
    public Call<Joke> getJokes(@Path("count") int count);
}