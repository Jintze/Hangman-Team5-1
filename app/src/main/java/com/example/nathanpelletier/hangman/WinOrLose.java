package com.example.nathanpelletier.hangman;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
     * Created by fatim on 2017-12-04.m
     */

    public class WinOrLose extends AppCompatActivity {


    /**
     * Inflates winorlose.xml over top of ingame.xml
     * and encapsulates all end game code
     *
     * @Result: takes in number value 1 = win; everything else is loss
     */
    public void onCreate (Bundle savedInsatnceState){
        super.onCreate(savedInsatnceState);
        setContentView(R.layout.winorlose);

        Intent intent = getIntent();
        String WORD = intent.getStringExtra("WORD");
        int Result = intent.getIntExtra("Result",0);


        //Everything within winorlose.xml

        TextView RESULT = findViewById(R.id.Result);

        TextView Word = findViewById(R.id.ChosenWord);


        if (Result == 1){
            RESULT.setText(R.string.Win);
        }else{
            RESULT.setText(R.string.Lose);
        }//else


        Word.setText(WORD);

        //onClicks
        Button BackToMenu = findViewById(R.id.MainMenu);
        BackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Home = new Intent(WinOrLose.this, Menu.class);
                startActivity(Home);

            }//onClick
        });//popUpMenu

        Button EasyReplay = findViewById(R.id.EasyDifficultySelect);
        EasyReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startGame = new Intent(WinOrLose.this, Game.class);
                startGame.putExtra("Difficulty", "easy");
                startActivity(startGame);

            }//onClick
        });//popUpMenu

        Button MediumReplay =  findViewById(R.id.MediumDifficultySelect);
        MediumReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGame  = new Intent(WinOrLose.this, Game.class);
                startGame.putExtra("Difficulty", "medium");
                startActivity(startGame);

            }
        });

        Button HardReplay = findViewById(R.id.HardDifficultySelect);
        HardReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGame = new Intent(WinOrLose.this, Game.class);
                startGame.putExtra("Difficulty",  "hard");
                startActivity(startGame);
            }
        });


    }//endGameScreen


    public void onBackPressed(){
    }


    }//AppCompatActivity
