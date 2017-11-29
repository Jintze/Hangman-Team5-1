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
  * Intent intentdata = getIntent();
  * String SELECTED_DIFFICULTY;
  */

  /**
   * Needs access modifier;
   * Needs description.
   */
  String SELECTED_DIFFICULTY = "hard";

  /**
   * Needs description.
   */
  private String CHOSEN_WORD;

  /**
   * Needs description.
   */
  private String[] TEST_WORDS = {"easy", "medium", "harrrd"};

  /**
   * Needs access modifier;
   * Needs description.
   */
  char[] CHECKER_ARRAY;

  /**
   * Needs access modifier;
   * Needs description.
   */
  char[] USER_INPUT_ARRAY;


  //presentation layer

  /**
   * Needs description.
   */
  private EditText USER_GUESS;

  /**
   * Needs description
   */
  private TextView TEXTVIEW_CHOSEN_WORD;

  /**
   * Needs description.
   */
  private TextView TEXTVIEW_GUESS_RESULTS;

  /**
   * Needs description.
   */
  private Button CHECK_ANSWER;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.game);


    // TODO: 2017-11-21 Remove TEXTVIEW_CHOSEN_WORD view/variable
    //only meant to reveal random word to dev
    TEXTVIEW_CHOSEN_WORD = findViewById(R.id.random_word);


    //match or nahh
    TEXTVIEW_GUESS_RESULTS = findViewById(R.id.guess__result);

    //user single char guess
    USER_GUESS = findViewById(R.id.guessed_letter);

    //Enter button
    CHECK_ANSWER = findViewById(R.id.enter_answer);

    TEXTVIEW_CHOSEN_WORD.setText(CHOSEN_WORD);

  }

  public void onStart() {
    super.onStart();

    WordPicker(SELECTED_DIFFICULTY);

    TEXTVIEW_CHOSEN_WORD.setText(CHOSEN_WORD);

    ChosenWord_array();

    InputComparison();
    //array that will be used for comparison

  }

  public void ArrayLogPrint(char[] array, String arrayname) {
    for (int x = 0; x < array.length; x++) {
      Log.d("lets see 0;" + x, ";the final array yay" + arrayname + ":  " + array[x]);
    }
  }

  public void CharCompare(char inputletter) {
    USER_INPUT_ARRAY = new char[CHOSEN_WORD.length()];

    for (int c = 0; c < CHECKER_ARRAY.length; c++) {
      if (inputletter == CHECKER_ARRAY[c]) {
        USER_INPUT_ARRAY[c] = inputletter;
      }
    }
    ArrayLogPrint(USER_INPUT_ARRAY, "loook at me fuck with me: ");
  }

  public void InputComparison() {
    CHECK_ANSWER.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        int UsersGuessLetterAmount = USER_GUESS.getText().toString().length();

        if (UsersGuessLetterAmount <= 1) {
          CharCompare(USER_GUESS.getText().toString().charAt(0));
        }
      }
    });
  }

  public void ChosenWord_array() {
    CHECKER_ARRAY = new char[TEXTVIEW_CHOSEN_WORD.length()];

    for (int i = 0; i < CHOSEN_WORD.length(); i++) {
      CHECKER_ARRAY[i] = CHOSEN_WORD.charAt(i);
    }
    ArrayLogPrint(CHECKER_ARRAY, "checkerArray");
  }


  //data prep
  public void WordPicker(String selectedDifficulty) {
    if (selectedDifficulty == "easy") {
      CHOSEN_WORD = TEST_WORDS[0];
    } else if (selectedDifficulty == "medium") {
      CHOSEN_WORD = TEST_WORDS[1];
    } else {
      CHOSEN_WORD = TEST_WORDS[2];
    }
  }

}
