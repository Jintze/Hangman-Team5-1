package com.example.nathanpelletier.hangman;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    /*cannot get intent to work
        Intent intentdata = getIntent();
        String selectedDifficulty;
        */


    private String ChosenWord;



    //presentation layer

    private EditText user_guess;

    private TextView chosen_word;

    private TextView guess_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        //////////////////chosen_word.setText(ChosenWord);

        // TODO: 2017-11-21 Remove chosen_word view/variable
        //only meant to reveal random word to dev
        chosen_word = findViewById(R.id.random_word);


        //match or nahh
        guess_result =  findViewById(R.id.guess__result);

        //user single char guess
        user_guess =  findViewById(R.id.guessed_letter);

        //Enter button
        Button check_answer =  findViewById(R.id.enter_answer);


    }
}
