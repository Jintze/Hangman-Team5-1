package com.example.nathanpelletier.hangman;

/**
 * Created by jinzhe on 2017-12-01.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.AndroidCharacter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;

public class Keyboard extends AppCompatActivity {
    private Button button;
    private Button btnPopup;
    private String[] datas = {"1","2","3","4","5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyboard);

        btnPopup = (Button)findViewById(R.id.menu) ;
        btnPopup.setOnClickListener(new Mylistener());
    }

    class Mylistener implements View.OnClickListener{

        public void onClick(View view){
            View popupView = Keyboard.this.getLayoutInflater().inflate(R.layout.popupwindow, null);
            ListView lsvMore = (ListView)popupView.findViewById(R.id.lsvMore);
            lsvMore.setAdapter(new ArrayAdapter<String>(Keyboard.this, android.R.layout.simple_list_item_1, datas));
            PopupWindow window = new PopupWindow(popupView, 400, 600);
            window.setAnimationStyle(R.style.popup_window_anim);
            window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#F8F8F8")));
            window.setFocusable(true);
            window.setOutsideTouchable(true);
            window.update();
            window.showAsDropDown(btnPopup, 0, 20);
        }

    }

    Button LetterQ =  findViewById(R.id.LetterQ);
        LetterQ.setOnClickListener(new View.OnClickListener() {
            LetterQ.setEnabled(false);
    }
}


