package com.example.nathanpelletier.hangman;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by jinzhe on 2017-11-27.
 */


public class Keyboard extends Activity {

    //Game game = new Game();

    Game game = new Game();


    /**
     *
     * Sets button q to black after key press
     * @param activity
     */
    public void keyPress(final Activity activity){

        final Button Guess_Key = activity.findViewById(R.id.LetterQ);

        Guess_Key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("sheeeesh","please please please mercy meeeee");

                Guess_Key.setBackgroundColor(Color.BLACK);

                game.charCompare('q');
            }
        });

    }//Keyboard


}//onCreate
