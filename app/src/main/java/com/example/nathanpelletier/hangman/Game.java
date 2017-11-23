package com.example.nathanpelletier.hangman;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    /*cannot get intent to work
        Intent intentdata = getIntent();
        String selectedDifficulty;
        */

    String selectedDifficulty = "hard";

    private String ChosenWord;

    private String[] test_words = {"easy", "medium", "harrrd"};

    char[] checker_array;

    char[] user_input_array;


    //presentation layer

    private EditText user_guess;

    private TextView chosen_word;

    private TextView guess_result;

    private Button check_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);



        // TODO: 2017-11-21 Remove chosen_word view/variable
        //only meant to reveal random word to dev
        chosen_word = findViewById(R.id.random_word);


        //match or nahh
        guess_result =  findViewById(R.id.guess__result);

        //user single char guess
        user_guess =  findViewById(R.id.guessed_letter);

        //Enter button
        check_answer =  findViewById(R.id.enter_answer);

        chosen_word.setText(ChosenWord);

    }

    public void onStart () {
        super.onStart();

        WordPicker(selectedDifficulty);

        chosen_word.setText(ChosenWord);

        ChosenWord_array();

        InputComparison();
        //array that will be used for comparison

    }

    public void ArrayLogPrint (char[]array, String arrayname){
        for(int x =0; x < array.length; x++) {
            Log.d("lets see 0;" +x , ";the final array yay"+arrayname+":  " + array[x]);
        }
    }

    public  void CharCompare(char inputletter){
        user_input_array = new char[ChosenWord.length()];

        for(int c = 0; c < checker_array.length; c++){
            if(inputletter == checker_array[c]){
                user_input_array[c] = inputletter;
            }
        }
        ArrayLogPrint(user_input_array,"loook at me fuck with me: ");
    }

    public void InputComparison(){
        check_answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int UsersGuessLetterAmount  = user_guess.getText().toString().length();

                if (UsersGuessLetterAmount <= 1){
                    CharCompare(user_guess.getText().toString().charAt(0));
                }
            }
        });
    }

    public void ChosenWord_array(){
        checker_array = new char[chosen_word.length()];

        for (int i = 0; i < ChosenWord.length(); i++) {
            checker_array[i] = ChosenWord.charAt(i);
        }
        ArrayLogPrint(checker_array,"checkerArray");
    }


    //data prep
    public void WordPicker(String selectedDifficulty) {
        if (selectedDifficulty == "easy") {
            ChosenWord = test_words[0];
        } else if (selectedDifficulty == "medium") {
            ChosenWord = test_words[1];
        } else {
            ChosenWord = test_words[2];
        }
    }

}
