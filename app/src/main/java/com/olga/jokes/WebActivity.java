package com.olga.jokes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WebActivity extends AppCompatActivity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_activity);

        webView = findViewById(R.id.webView);
        // включаем поддержку JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://www.icndb.com/api/");

        //вызываем переопределенный метод для открытия всех страниц внутри приложения.
        webView.setWebViewClient(new MyWebViewClient());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_web);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_joke:
                                Intent intentJoke = new Intent(WebActivity.this, MainActivity.class);
                                startActivity(intentJoke);
                                break;
                            case R.id.action_author:
                                Intent intentAuthor = new Intent(WebActivity.this, AuthorActivity.class);
                                startActivity(intentAuthor);
                                break;
                        }
                        return false;
                    }
                });
    }

    //навигация по webview
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
