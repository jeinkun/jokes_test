package com.olga.jokes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService Instance;
    private static final String BASE_URL = "http://api.icndb.com/jokes/";
    private Retrofit Retrofit;

    private NetworkService() {
        Retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static NetworkService getInstance() {
        if (Instance == null) {
            Instance = new NetworkService();
        }
        return Instance;
    }

    public JokeApi getJSONApi() {
        return Retrofit.create(JokeApi.class);
    }

}
