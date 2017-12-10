package com.example.nathanpelletier.hangman;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by fatim on 2017-12-04.m
 */

public class Popup extends AppCompatActivity{

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ingame);

    ImageButton popUpMenu = findViewById(R.id.PopUpMenuButton);

    popUpMenu.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(Popup.this, Popup.class));

        setContentView(R.layout.popwindow);

        DisplayMetrics displayMetrics = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout(width*8,height*6);


      }//onClick
    });//popUpMenu

  }//OnCreate


}//AppCompatActivity
