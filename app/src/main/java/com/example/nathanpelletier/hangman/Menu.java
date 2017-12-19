package com.example.nathanpelletier.hangman;

import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;

public class Menu extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

//onClicks Set up ----------------------------------------


        videoView = (VideoView) findViewById(R.id.VideoScreen);

        Button EasySelect = findViewById(R.id.EasyDifficultySelect);
        EasySelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGame = new Intent(Menu.this, Game.class);
                startGame.putExtra("Difficulty", "easy");
                startActivity(startGame);
            }
        });

        Button MediumSelect =  findViewById(R.id.MediumDifficultySelect);
        MediumSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGame  = new Intent(Menu.this, Game.class);
                startGame.putExtra("Difficulty", "medium");
                startActivity(startGame);

            }
        });

        Button HardSelect = findViewById(R.id.HardDifficultySelect);
        HardSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGame = new Intent(Menu.this, Game.class);
                startGame.putExtra("Difficulty",  "hard");
                startActivity(startGame);
            }
        });

        final Button StoryVideo = findViewById(R.id.StoryIntro);
        final Button StoryPlay = findViewById(R.id.StoryPlay);

        AnimationUtils animationUtils = new AnimationUtils();

        Button StorySelect = findViewById(R.id.StoryMode);
        StorySelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               StoryPlay.setVisibility(View.VISIBLE);
               StoryVideo.setVisibility(View.VISIBLE);

               StoryPlay.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       Intent startGame = new Intent(Menu.this, Game.class);
                       startGame.putExtra("Story",  "yes");
                       startActivity(startGame);



                   }//onClick
               });
               StoryVideo.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       Intent startvideo = new Intent(Menu.this, StoryMode.class);
                       startActivity(startvideo);



                   }//onClick
               });

            }
        });
    }
}
