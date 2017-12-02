package com.example.nathanpelletier.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Game extends AppCompatActivity {

    /**
     * keeps track of every time the user makes a wrong guess
     */
    int WRONG_GUESSES = 0;

    /**
     * keeps track of every time the user makes a right guess
     */
  int CORRECT_GUESSES = 0;

  /**
   * the random word selected by computer based off of difficulty selected
   */
  private String CHOSEN_WORD;

  /**
   * Test array to test out word selection
   *
   * DELETE THIS
   */
  private String[] TEST_WORDS = {"easy", "medium", "harrrd"};

  /**
   * Needs access modifier;
   * Needs description.
   *
   * DELETE THIS
   */
  char[] CHECKER_ARRAY;

  /**
   * Needs access modifier;
   * Needs description.
   *
   * DELETE THIS
   */
  char[] USER_INPUT_ARRAY;


  //presentation layer

  /**
   * For testing: an edit text to take in user input through the built in keyboard
   *
   * DELETE THIS
   */
  private EditText USER_GUESS;

  /**
   * For testing :Displays chosen guess word (in game screen)
   *
   * DELETE THIS
   */
  private TextView TEXTVIEW_CHOSEN_WORD;

  /**
   * For Testing: Displays result of each character guess (in game screen)
   *
   *DELETE THIS
   */
  private LinearLayout LINEARLAYOUT_GUESS_RESULTS;

  /**
   * For Testing: enter button to run comparison function
   *
   * DELETE THIS
   */
  private Button CHECK_ANSWER;

  /**
   * onCreate is used to initialize all and set view attributes
   * @param savedInstanceState
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.game);


    // TODO: 2017-11-21 Remove TEXTVIEW_CHOSEN_WORD view/variable

    //only meant to reveal random word to dev
    TEXTVIEW_CHOSEN_WORD = findViewById(R.id.random_word);

    LINEARLAYOUT_GUESS_RESULTS = findViewById(R.id.guess__result); // match or nahh

    USER_GUESS = findViewById(R.id.guessed_letter); // user single char guess

    CHECK_ANSWER = findViewById(R.id.enter_answer); // Enter button

    TEXTVIEW_CHOSEN_WORD.setText(CHOSEN_WORD);

  } // onCreate(Bundle)

  /**
   * Runs all methods in game class.
   *
   * also checks player progress (win/loss)
   */
  public void onStart() {
    super.onStart();

    wordPicker(getIntentData());

    printDashes();


    TEXTVIEW_CHOSEN_WORD.setText(CHOSEN_WORD);

    //check player progress
    if (CORRECT_GUESSES<=CHOSEN_WORD.length()) {
      if (WRONG_GUESSES <= 3) {
        inputComparison();
      } else {
        //end game
      }//else
    }else{
        //end game
    }//else

  } // onStart()

  /**
   * Creates as many textviews as the CHOSEN_WORD has letters and placing them in LINEARLAYOUT_GUESS_RESULTS
   * chronologically id from 1 - n; n = CHOSEN_WORD length
   */
  public void printDashes (){
    for(int i = 1; i < CHOSEN_WORD.length()+1; i++){
      TextView CORRECTGUESS = new TextView(this);
      CORRECTGUESS.setText(" ___ ");
      CORRECTGUESS.setId(i);

      LINEARLAYOUT_GUESS_RESULTS.addView(CORRECTGUESS);
    }//for


  }//printDashes


  /**
   * Takes in user selected difficulty(Easy, Medium, Hard) from main menu and transfers it to Game class
   * @return String SELECTED_DIFFICULTY
   */
  public String getIntentData(){

    Intent intent = getIntent();

    String SELECTED_DIFFICULTY = intent.getStringExtra("Difficulty");

    Log.d("lets see 0;" , ";the final array yay" + SELECTED_DIFFICULTY);

    return SELECTED_DIFFICULTY;

  }

  /**
   * For Testing:
   * Legacy class Prints param array into log to see contents
   *
   * @param array: chosen char array you want to print
   * @param arrayname: name of array
   */
  public void arrayLogPrint(char[] array, String arrayname) {
    for (int x = 0; x < array.length; x++) {
      Log.d("lets see 0;" + x, ";the final array yay" + arrayname + ":  " + array[x]);
    } // for
  } // arrayLogPrint(char[], String)

  /**
   * compares inputLetter to CHOSEN_WORD
   * @param inputLetter: users input char
   *
   * ToDo: return correct char and location
   */
  public void charCompare(char inputLetter) {
    for (int i = 0; i < CHOSEN_WORD.length(); i++) {
      if (inputLetter == CHOSEN_WORD.charAt(i)) {
        CORRECT_GUESSES = CORRECT_GUESSES + 1;
      }//if
      else {
        WRONG_GUESSES = WRONG_GUESSES + 1;
      }//else
    }
  }//charCompare


  /**
   * Decides which comparison is needed depending on user input length
   * For now directs only to single character comparison
   * Future allow user to guess entire word
   *
   */
  public void inputComparison() {

      CHECK_ANSWER.setOnClickListener(new View.OnClickListener() {

        /**
         * For Testing: waits for user to press enter before running compare function
         *
         * @param view: enter button
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
   * Legacy: creates array based off of CHOSEN_WORD with each letter indexed-
   * if the word = "eddy";CHECKER_ARRAY = ['e','d','d','y'];
   *
   * this manipulates the global variable CHECKER_ARRAY
   */
  public void chosenWordArray() {
    CHECKER_ARRAY = new char[TEXTVIEW_CHOSEN_WORD.length()];

    for (int i = 0; i < CHOSEN_WORD.length(); i++) {
      CHECKER_ARRAY[i] = CHOSEN_WORD.charAt(i);
    } // for
    arrayLogPrint(CHECKER_ARRAY, "checkerArray");
  } // chosenWordArray()

  /**
   * For Testing: takes selectedDifficulty and selects a word from TEST_WORD String array
   * This then manipulates global variable CHOSEN_WORD
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
