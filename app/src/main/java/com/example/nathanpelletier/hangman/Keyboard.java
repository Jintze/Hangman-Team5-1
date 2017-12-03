package com.example.nathanpelletier.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by jinzhe on 2017-11-27.
 */

public class Keyboard extends AppCompatActivity {

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.keyboard);
    }

    public void onStart(){
        super.onStart();

        final Button LETTER_Q = findViewById(R.id.LetterQ);

        LETTER_Q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
                KEYBOARD_INPUT.putExtra("key","q");

                LETTER_Q.setEnabled(false);
                LETTER_Q.setBackgroundColor(73);



            }//onClick
        });


    }//onStart

}//onCreate
