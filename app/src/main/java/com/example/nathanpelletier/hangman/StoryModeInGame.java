package com.example.nathanpelletier.hangman;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nathanpelletier.hangman.AndroidSaveState.SaveState;

/**
 * Created by fatim on 2017-12-18.
 */

public class StoryModeInGame extends AppCompatActivity{

    TextView Rank;
    TextView gameResult;
    TextView Expenses;
    TextView previousBalance;
    TextView balance;

    SaveState saveState = new SaveState();

    int oldBalance = saveState.getNetWorth();



    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.storyend);

        int CrookDefeated =5;

        Rank = findViewById(R.id.Rank);
        gameResult = findViewById(R.id.results);
        Expenses = findViewById(R.id.expenses);
        previousBalance = findViewById(R.id.previousBalace);
        balance = findViewById(R.id.currentBalance);

        Button rightButton = findViewById(R.id.rightButton);
        Button leftButton = findViewById(R.id.leftButton);

        Intent intent = getIntent();
        String WORD = intent.getStringExtra("WORD");
        int Result = intent.getIntExtra("Result",0);

        //always the same
        Expenses.setText("$4");

        previousBalance.setText(String.valueOf(saveState.getNetWorth()));

        balance.setText(String.valueOf(oldBalance - 4));

        Rank.setText(String.valueOf(saveState.getRank()));


        //saveState stuff




        //win
        if (Result == 1){
            final int newBallance = oldBalance + CrookDefeated;
            gameResult.setText(R.string.Win);
            rightButton.setText("+" + String.valueOf(CrookDefeated)+" Balance");


            leftButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent startGame = new Intent(StoryModeInGame.this, Game.class);
                    startGame.putExtra("Story",  "yes");
                    startActivity(startGame);
                }
            });


            rightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saveState.setNetWorth(newBallance);
                    Intent startGame = new Intent(StoryModeInGame.this, Game.class);
                    startGame.putExtra("Story",  "yes");
                    startActivity(startGame);

                }
            });



        //lose
        }else{
            int newBallance = oldBalance - 4;
            gameResult.setText(R.string.Lose);
            rightButton.setText("Go Home");
            leftButton.setText("Play Again");
            saveState.setNetWorth(newBallance);

            leftButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent startGame = new Intent(StoryModeInGame.this, Game.class);
                    startGame.putExtra("Story",  "yes");
                    startActivity(startGame);
                }
            });

            rightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent Home = new Intent(StoryModeInGame.this, Menu.class);
                    startActivity(Home);
                }
            });




        }//else





    }//onCreate

    /**
     * disables built in back button
     */
    public void onBackPressed(){
    }


}


