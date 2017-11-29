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

  /**
   * Needs description.
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.game);

    // TODO: 2017-11-21 Remove TEXTVIEW_CHOSEN_WORD view/variable

    //only meant to reveal random word to dev
    TEXTVIEW_CHOSEN_WORD = findViewById(R.id.random_word);

    TEXTVIEW_GUESS_RESULTS = findViewById(R.id.guess__result); // match or nahh

    USER_GUESS = findViewById(R.id.guessed_letter); // user single char guess

    CHECK_ANSWER = findViewById(R.id.enter_answer); // Enter button

    TEXTVIEW_CHOSEN_WORD.setText(CHOSEN_WORD);

  } // onCreate(Bundle)

  /**
   * Needs description.
   */
  public void onStart() {
    super.onStart();

    wordPicker(SELECTED_DIFFICULTY);

    TEXTVIEW_CHOSEN_WORD.setText(CHOSEN_WORD);

    chosenWordArray();

    inputComparison();
    //array that will be used for comparison

  } // onStart()

  /**
   * Needs description.
   * @param array
   * @param arrayname
   */
  public void arrayLogPrint(char[] array, String arrayname) {
    for (int x = 0; x < array.length; x++) {
      Log.d("lets see 0;" + x, ";the final array yay" + arrayname + ":  " + array[x]);
    } // for
  } // arrayLogPrint(char[], String)

  /**
   * Needs description.
   * @param inputLetter
   */
  public void charCompare(char inputLetter) {

  //  for(int i = 0; i < CHOSEN_WORD.length(); i++){
  //    if(CHOSEN_WORD.charAt(i) == inputLetter){
  //      //TODO disable inputLetter and return true;
  //    } // if
  //  } // for

    USER_INPUT_ARRAY = new char[CHOSEN_WORD.length()];

    for (int c = 0; c < CHECKER_ARRAY.length; c++) {
      if (inputLetter == CHECKER_ARRAY[c]) {
        USER_INPUT_ARRAY[c] = inputLetter;
      } // if
    } // for
    arrayLogPrint(USER_INPUT_ARRAY, "loook at me fuck with me: "); // get rid of this.
  } // charCompare(char)

  /**
   * Needs description.
   */
  public void inputComparison() {
    CHECK_ANSWER.setOnClickListener(new View.OnClickListener() {

      /**
       * Needs description.
       * @param view
       */
      @Override
      public void onClick(View view) {
        int UsersGuessLetterAmount = USER_GUESS.getText().toString().length();

        if (UsersGuessLetterAmount <= 1) {
          charCompare(USER_GUESS.getText().toString().charAt(0));
        } // if
      } // onClick(View)
    }); // CHECK_ANSWER.setOnClickListener()
  } // inputComparison()

  /**
   * Needs description.
   */
  public void chosenWordArray() {
    CHECKER_ARRAY = new char[TEXTVIEW_CHOSEN_WORD.length()];

    for (int i = 0; i < CHOSEN_WORD.length(); i++) {
      CHECKER_ARRAY[i] = CHOSEN_WORD.charAt(i);
    } // for
    arrayLogPrint(CHECKER_ARRAY, "checkerArray");
  } // chosenWordArray()

  /**
   * data prep
   * @param selectedDifficulty
   */
  public void wordPicker(String selectedDifficulty) {
    switch(selectedDifficulty){
      case "easy":
        CHOSEN_WORD = TEST_WORDS[0];
        break;
      case "medium":
        CHOSEN_WORD = TEST_WORDS[1];
        break;
      case "hard":
        CHOSEN_WORD = TEST_WORDS[2];
        break;
    } // switch
  } // wordPicker(String)

}
