package com.example.nathanpelletier.hangman;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
    /**
     * Created by fatim on 2017-12-04.m
     */

    public class WinOrLose extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.winorlose);


            Button BACK_HOME_BUTTON = findViewById(R.id.GameOver);

            BACK_HOME_BUTTON.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent GO_HOME = new Intent(WinOrLose.this, Menu.class);
                    startActivity(GO_HOME);

                }//onClick
            });//popUpMenu

        }//OnCreate
    }//AppCompatActivity
