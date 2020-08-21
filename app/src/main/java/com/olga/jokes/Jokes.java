package com.olga.jokes;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Jokes {
    public static ArrayList<String> jokes = new ArrayList<>();

    //отправка запроса на сервер
    public void getJokes(int count) {
        NetworkService.getInstance()
                .getJSONApi()
                .getJokes(count)
                .enqueue(new Callback<Joke>() {

                    @Override
                    public void onResponse(@NonNull Call<Joke> call, @NonNull Response<Joke> response) {
                        jokes.clear();
                        Joke joke = response.body();

                        for (int i = 0; i < joke.getJoke().size(); i++) {
                            jokes.add(joke.getJoke().get(i).getJoke());
                        }
                        //размещение данных на активности
                        DataAdapter dataAdapter = new DataAdapter(jokes);

                        MainActivity.recyclerView.setAdapter(dataAdapter);
                    }

                    @Override
                    public void onFailure(@NonNull Call<Joke> call, @NonNull Throwable t) {

                        jokes.add("Error occurred while getting request!");
                        DataAdapter dataAdapter = new DataAdapter(jokes);

                        MainActivity.recyclerView.setAdapter(dataAdapter);
                        t.printStackTrace();
                    }
                });

    }
}
