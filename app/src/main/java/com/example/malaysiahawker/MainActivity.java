package com.example.malaysiahawker;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button searchBtn, recommendsBtn, alphabetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBtn = findViewById(R.id.hawker_search);

        searchBtn.setOnClickListener(v -> openSearchHawker());

        recommendsBtn = findViewById(R.id.hawker_recommends);

        recommendsBtn.setOnClickListener(v -> openRecommendsHawker());

        alphabetBtn = findViewById(R.id.hawker_alphabet);

        alphabetBtn.setOnClickListener(v -> openAlphabetHawker());
    }

    private void openSearchHawker() {
        Intent intent = new Intent(this,SearchHawker.class);
        startActivity(intent);
    }

   private void openRecommendsHawker(){
        Intent intent = new Intent(this, RecommendsHawker.class);
        startActivity(intent);
    }

    private void openAlphabetHawker(){
        Intent intent = new Intent(this, AlphabetHawker.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //exit
        menu.add("Exit").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //here, close the activity
                finish();
                return false;
            }
        });
        return true;
    }
}