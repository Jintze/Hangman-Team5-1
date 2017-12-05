package com.example.nathanpelletier.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by jinzhe on 2017-11-27.
 * Nathan copied Jinzhe's work into the entire alphabet 2017-12-04
 */

public class Keyboard extends AppCompatActivity {

  public void onCreate(Bundle saveInstanceState){
    super.onCreate(saveInstanceState);
    setContentView(R.layout.keyboard);
  }

  public void onStartA(){
    super.onStart();

    final Button LETTER_A = findViewById(R.id.LetterA);

    LETTER_A.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","a");

        LETTER_A.setEnabled(false);
        LETTER_A.setBackgroundColor(73);

      }//onClick
    });


  }//onStartA

  public void onStartB(){
    super.onStart();

    final Button LETTER_B = findViewById(R.id.LetterB);

    LETTER_B.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","b");

        LETTER_B.setEnabled(false);
        LETTER_B.setBackgroundColor(73);

      }//onClick
    });


  }//onStartB

  public void onStartC(){
    super.onStart();

    final Button LETTER_C = findViewById(R.id.LetterC);

    LETTER_C.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","c");

        LETTER_C.setEnabled(false);
        LETTER_C.setBackgroundColor(73);

      }//onClick
    });


  }//onStartC

  public void onStartD(){
    super.onStart();

    final Button LETTER_D = findViewById(R.id.LetterD);

    LETTER_D.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","d");

        LETTER_D.setEnabled(false);
        LETTER_D.setBackgroundColor(73);

      }//onClick
    });


  }//onStartD

  public void onStartE(){
    super.onStart();

    final Button LETTER_E = findViewById(R.id.LetterE);

    LETTER_E.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","e");

        LETTER_E.setEnabled(false);
        LETTER_E.setBackgroundColor(73);

      }//onClick
    });


  }//onStartE

  public void onStartF(){
    super.onStart();

    final Button LETTER_F = findViewById(R.id.LetterF);

    LETTER_F.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","f");

        LETTER_F.setEnabled(false);
        LETTER_F.setBackgroundColor(73);

      }//onClick
    });


  }//onStartF

  public void onStartG(){
    super.onStart();

    final Button LETTER_G = findViewById(R.id.LetterG);

    LETTER_G.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","g");

        LETTER_G.setEnabled(false);
        LETTER_G.setBackgroundColor(73);

      }//onClick
    });


  }//onStartG

  public void onStartH(){
    super.onStart();

    final Button LETTER_H = findViewById(R.id.LetterH);

    LETTER_H.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","h");

        LETTER_H.setEnabled(false);
        LETTER_H.setBackgroundColor(73);

      }//onClick
    });


  }//onStartH

  public void onStartI(){
    super.onStart();

    final Button LETTER_I = findViewById(R.id.LetterI);

    LETTER_I.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","i");

        LETTER_I.setEnabled(false);
        LETTER_I.setBackgroundColor(73);

      }//onClick
    });


  }//onStartI

  public void onStartJ(){
    super.onStart();

    final Button LETTER_J = findViewById(R.id.LetterJ);

    LETTER_J.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","j");

        LETTER_J.setEnabled(false);
        LETTER_J.setBackgroundColor(73);

      }//onClick
    });


  }//onStartJ

  public void onStartK(){
    super.onStart();

    final Button LETTER_K = findViewById(R.id.LetterK);

    LETTER_K.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","k");

        LETTER_K.setEnabled(false);
        LETTER_K.setBackgroundColor(73);

      }//onClick
    });


  }//onStartK

  public void onStartL(){
    super.onStart();

    final Button LETTER_L = findViewById(R.id.LetterL);

    LETTER_L.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","l");

        LETTER_L.setEnabled(false);
        LETTER_L.setBackgroundColor(73);

      }//onClick
    });


  }//onStartL

  public void onStartM(){
    super.onStart();

    final Button LETTER_M = findViewById(R.id.LetterM);

    LETTER_M.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","m");

        LETTER_M.setEnabled(false);
        LETTER_M.setBackgroundColor(73);

      }//onClick
    });


  }//onStartM

  public void onStartN(){
    super.onStart();

    final Button LETTER_N = findViewById(R.id.LetterN);

    LETTER_N.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","n");

        LETTER_N.setEnabled(false);
        LETTER_N.setBackgroundColor(73);

      }//onClick
    });


  }//onStartN

  public void onStartO(){
    super.onStart();

    final Button LETTER_O = findViewById(R.id.LetterO);

    LETTER_O.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","o");

        LETTER_O.setEnabled(false);
        LETTER_O.setBackgroundColor(73);

      }//onClick
    });


  }//onStartO

  public void onStartP(){
    super.onStart();

    final Button LETTER_P = findViewById(R.id.LetterP);

    LETTER_P.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","p");

        LETTER_P.setEnabled(false);
        LETTER_P.setBackgroundColor(73);

      }//onClick
    });


  }//onStartP

  public void onStartQ(){
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


  }//onStartQ

  public void onStartR(){
    super.onStart();

    final Button LETTER_R = findViewById(R.id.LetterR);

    LETTER_R.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","r");

        LETTER_R.setEnabled(false);
        LETTER_R.setBackgroundColor(73);

      }//onClick
    });


  }//onStartR

  public void onStartS(){
    super.onStart();

    final Button LETTER_S = findViewById(R.id.LetterS);

    LETTER_S.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","s");

        LETTER_S.setEnabled(false);
        LETTER_S.setBackgroundColor(73);

      }//onClick
    });


  }//onStartS

  public void onStartT(){
    super.onStart();

    final Button LETTER_T = findViewById(R.id.LetterT);

    LETTER_T.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","t");

        LETTER_T.setEnabled(false);
        LETTER_T.setBackgroundColor(73);

      }//onClick
    });


  }//onStartT

  public void onStartU(){
    super.onStart();

    final Button LETTER_U = findViewById(R.id.LetterU);

    LETTER_U.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","e");

        LETTER_U.setEnabled(false);
        LETTER_U.setBackgroundColor(73);

      }//onClick
    });


  }//onStartU

  public void onStartV(){
    super.onStart();

    final Button LETTER_V = findViewById(R.id.LetterV);

    LETTER_V.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","v");

        LETTER_V.setEnabled(false);
        LETTER_V.setBackgroundColor(73);

      }//onClick
    });


  }//onStartV

  public void onStartW(){
    super.onStart();

    final Button LETTER_W = findViewById(R.id.LetterW);

    LETTER_W.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","w");

        LETTER_W.setEnabled(false);
        LETTER_W.setBackgroundColor(73);

      }//onClick
    });


  }//onStartW

  public void onStartX(){
    super.onStart();

    final Button LETTER_X = findViewById(R.id.LetterX);

    LETTER_X.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","x");

        LETTER_X.setEnabled(false);
        LETTER_X.setBackgroundColor(73);

      }//onClick
    });


  }//onStartX

  public void onStartY(){
    super.onStart();

    final Button LETTER_Y = findViewById(R.id.LetterY);

    LETTER_Y.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","y");

        LETTER_Y.setEnabled(false);
        LETTER_Y.setBackgroundColor(73);

      }//onClick
    });


  }//onStartY

  public void onStartZ(){
    super.onStart();

    final Button LETTER_Z = findViewById(R.id.LetterZ);

    LETTER_Z.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        Intent KEYBOARD_INPUT = new Intent(Keyboard.this, Game.class);
        KEYBOARD_INPUT.putExtra("key","z");

        LETTER_Z.setEnabled(false);
        LETTER_Z.setBackgroundColor(73);

      }//onClick
    });


  }//onStartZ

}//onCreate
