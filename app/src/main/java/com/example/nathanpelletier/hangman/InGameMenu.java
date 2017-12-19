package com.example.nathanpelletier.hangman;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by fatim on 2017-12-03.
 */

public class InGameMenu extends AppCompatActivity{

    private static final String TAG = "InGameMenu";
    private ImageButton menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingame);

        Log.d(TAG, "onCreate: Starting");

        menuButton = findViewById(R.id.BackToeMenuButton);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked InGameMenu");
                Intent intentMenuButton = new Intent(InGameMenu.this, Menu.class);
                startActivity(intentMenuButton);

            }
        });
    } // onCreate(Bundle)

    public void backToMenu(){
        Intent intentMenuButton = new Intent(InGameMenu.this, Menu.class);
        startActivity(intentMenuButton);
    }
}
