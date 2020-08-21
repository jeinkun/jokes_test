package com.olga.jokes;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AuthorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.author_activity);

        // слушатель нажатия на пункты меню NavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_author);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_web:
                                Intent intentWeb = new Intent(AuthorActivity.this, WebActivity.class);
                                startActivity(intentWeb);
                                break;
                            case R.id.action_joke:
                                Intent intentJoke = new Intent(AuthorActivity.this, MainActivity.class);
                                startActivity(intentJoke);
                                break;
                        }
                        return false;
                    }
                });
    }
}
