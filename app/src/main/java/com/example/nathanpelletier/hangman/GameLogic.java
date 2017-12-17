package com.example.nathanpelletier.hangman;

import android.app.Activity;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Method;

/**
 * Created by Eddy on 2017-12-16.
 */

public class GameLogic extends Activity {

    final int STRIKES = 6;

    /**
     * keeps track of every time the user makes a wrong guess
     */
    int WRONG_GUESSES = 0;

    /**
     * keeps track of every time the user makes a right guess
     */
    int CORRECT_GUESSES = 0;

    /**
     * the random word selected by computer based off of difficulty selected
     */
    String CHOSEN_WORD;

    /**
     * Character array to store output. Might need to add final so only this class can modify the
     * variable.
     */
    String[] REVEALED_LETTERS;





    public GameLogic(String Word,String[]array){
        this.CHOSEN_WORD = Word;
        this.REVEALED_LETTERS = array;

    }//



    public void charCompare(char inputLetter) {

        int OLD_CORRECT_GUESSES_VAL = CORRECT_GUESSES;
        for (int i = 0; i < CHOSEN_WORD.length(); i++) {
            if (inputLetter == CHOSEN_WORD.charAt(i)) {
                //displayCorrectGuesses(i,inputLetter); // peter I just added this
                CORRECT_GUESSES++;



                REVEALED_LETTERS[i] = String.valueOf(inputLetter);
                // displayCorrectGuesses();


            } // if
        } // for

        if(CORRECT_GUESSES == OLD_CORRECT_GUESSES_VAL){
            WRONG_GUESSES++;
            //removeLife();
        }//if

        if(CORRECT_GUESSES == CHOSEN_WORD.length()){
            //endGameScreen();
        } // if
        if(WRONG_GUESSES == STRIKES){
            //endGameScreen();


        } // if
    } // charCompare






}//com.example.nathanpelletier.hangman.GameLogic
