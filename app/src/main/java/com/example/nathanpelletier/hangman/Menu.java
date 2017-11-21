package com.example.nathanpelletier.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

//onClicks Set up ----------------------------------------

        Button EasySelect = findViewById(R.id.EasyDifficultySelect);
        EasySelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGame = new Intent(Menu.this, Game.class);
                startGame.putExtra("Difficulty", R.string.Easy);
                startActivity(startGame);
            }
        });

        Button MediumSelect =  findViewById(R.id.MediumDifficultySelect);
        MediumSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGame = new Intent(Menu.this, Game.class);
                startGame.putExtra("Difficulty", R.string.Medium);
                startActivity(startGame);

            }
        });

        Button HardSelect = findViewById(R.id.HardDifficultySelect);
        HardSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGame = new Intent(Menu.this, Game.class);
                startGame.putExtra("Difficulty",  R.string.Hard);
                startActivity(startGame);
            }
        });
    }
}
