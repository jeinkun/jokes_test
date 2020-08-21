package com.olga.jokes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    EditText jokesCount;
    public static RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jokesCount = findViewById(R.id.jokes_count);
        recyclerView = findViewById(R.id.list_jokes);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // слушатель нажатия на пункты меню NavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_joke);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_web:
                                Intent intentWeb = new Intent(MainActivity.this, WebActivity.class);
                                startActivity(intentWeb);
                                break;
                            case R.id.action_author:
                                Intent intentAuthor = new Intent(MainActivity.this, AuthorActivity.class);
                                startActivity(intentAuthor);
                                break;
                        }
                        return false;
                    }
                });
    }

    //вызов метода отправляющего запрос на получение шуток. count - кол-во шуток
    public void onClickReload(View view) {
        if(jokesCount.getText().length() > 0) {
            Jokes jokes = new Jokes();
            int count = Integer.parseInt(jokesCount.getText().toString());
            jokes.getJokes(count);
        }

    }

}
