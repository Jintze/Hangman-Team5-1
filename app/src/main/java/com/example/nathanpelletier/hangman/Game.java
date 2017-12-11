package com.example.nathanpelletier.hangman;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Game extends AppCompatActivity {

  /**
   * Maximum amount of errors before the game ends.
   */
  private final int STRIKES = 6;

  /**
   * keeps track of every time the user makes a wrong guess
   */
  private int WRONG_GUESSES = 0;

  /**
   * keeps track of every time the user makes a right guess
   */
  private  int CORRECT_GUESSES = 0;

  /**
   * the random word selected by computer based off of difficulty selected
   */
  private String CHOSEN_WORD;

  /**
   * Character array to store output. Might need to add final so only this class can modify the
   * variable.
   */
  public char[] REVEALED_LETTERS;

  /**
   * Test array to test out word selection
   *
   * DELETE THIS
   */
  private String[] TEST_WORDS = {"easy", "medium", "harrrdq"};

  /**
   * Displays result of each character guess (in game screen)
   */
  private LinearLayout LINEARLAYOUT_GUESS_RESULTS;

  /**
   * onCreate is used to initialize all and set view attributes
   */
  public char key;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ingame);

    LINEARLAYOUT_GUESS_RESULTS = findViewById(R.id.guess__result); // match or nahh

  } // onCreate(Bundle)

  /**
   * Runs all methods in game class.
   *
   * also checks player progress (win/loss)
   */
  public void onStart() {
    super.onStart();
    String SELECTED_DIFFICULTY = getIntentData();
    wordPicker(SELECTED_DIFFICULTY);
    gamePosterChanger(SELECTED_DIFFICULTY);

    inGameMenu();

    printDashes();


    /* not sure if we need a switch table or if we should just set all of these now */
    keyboardA();
    keyboardB();
    keyboardC();
    keyboardD();
    keyboardE();
    keyboardF();
    keyboardG();
    keyboardH();
    keyboardI();
    keyboardJ();
    keyboardK();
    keyboardL();
    keyboardM();
    keyboardN();
    keyboardO();
    keyboardP();
    keyboardQ();
    keyboardR();
    keyboardS();
    keyboardT();
    keyboardU();
    keyboardV();
    keyboardW();
    keyboardX();
    keyboardY();
    keyboardZ();


    /*//check player progress
    if (CORRECT_GUESSES<=CHOSEN_WORD.length()) {
      if (WRONG_GUESSES <= 3) {
        charCompare('r');
      } else {
        //end game
      }//else
    }else{
        //end game
    }//else*/

  } // onStart()

  public void inGameMenu(){
    ImageButton IN_GAME_MENU_BUTTON = findViewById(R.id.PopUpMenuButton);
    final LayoutInflater LAYOUT_INFLATER = this.getLayoutInflater();

    final RelativeLayout GAMESCREEN = findViewById(R.id.inGameMainParent);

    IN_GAME_MENU_BUTTON.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        view = LAYOUT_INFLATER.inflate(R.layout.popwindow,null);

        view.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in));

        GAMESCREEN.addView(view);


        //Button 1 go home

        Button BACK_HOME_BUTTON = findViewById(R.id.backToeMenuButton);

        BACK_HOME_BUTTON.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent GO_HOME = new Intent(Game.this, Menu.class);
            startActivity(GO_HOME);
          }
        });
      }
    });




  }//inGameMenu

  // TODO: 2017-12-09 Add Resource files Jintze
  /**
   * changes the poster image based on selectedDifficulty
   * @param selectedDifficulty
   */
  public void gamePosterChanger(String selectedDifficulty){
    RelativeLayout poster = findViewById(R.id.posterLayout);
    switch (selectedDifficulty){
      case "easy":{
        poster.setBackgroundResource(R.drawable.secondscreen);
        break;
      }
      case "medium":{
        poster.setBackgroundResource(R.drawable.secondscreen);
        break;
      }

      case "hard":{

        poster.setBackgroundResource(R.drawable.secondscreen);
        break;
      }
    }//switch(selectedDifficulty)


  }//gamePosterChanger

    /**
     * displays the correctly guessed letter in the proper TextView for the user
     * @param LETTER_LOCATION
     * @param GUESSED_LETTER
     */
    public void displayCorrectGuesses(int LETTER_LOCATION,char GUESSED_LETTER){
      TextView view = findViewById(LETTER_LOCATION);
      view.setText(String.valueOf(GUESSED_LETTER));
      view.setTextSize(30);
    }//displayCorrectGuesses

  /**
   * Creates as many textviews as the CHOSEN_WORD has letters and placing them in LINEARLAYOUT_GUESS_RESULTS
   * chronologically id from 1 - n; n = CHOSEN_WORD length
   */
  public void printDashes (){
    for(int i = 0; i < CHOSEN_WORD.length(); i++){
      TextView CORRECT_GUESS = new TextView(this);
      CORRECT_GUESS.setText(" ___ ");
      CORRECT_GUESS.setId(i);

      LINEARLAYOUT_GUESS_RESULTS.addView(CORRECT_GUESS);
    }//for
  }//printDashes

  /**
   * Takes in user selected difficulty(Easy, Medium, Hard) from main menu and transfers it to Game class
   * @return String SELECTED_DIFFICULTY
   */
  public String getIntentData() {
    Intent intent = getIntent();
    String SELECTED_DIFFICULTY = intent.getStringExtra("Difficulty");
    Log.d("lets see 0;", ";the final array yay" + SELECTED_DIFFICULTY);
    return SELECTED_DIFFICULTY;
  } // getIntentData()

  /**
   * compares inputLetter to CHOSEN_WORD
   * ToDo: return correct char and location
   * Train of thought: use a global variable to represent letters that are uncovered by the user;
   * go through chosen word with selected letter; if selected character match at location of chosen
   * word, add that character to the ith position in the global variable. The other method can just
   * access this file's global variable.
   * @param inputLetter: users input char
   */
  public void charCompare(char inputLetter) {
    boolean alreadyGuessed = false;
    for (int i = 0; i < CHOSEN_WORD.length(); i++) {
      if (inputLetter == CHOSEN_WORD.charAt(i)) {
        displayCorrectGuesses(i,inputLetter); // peter I just added this
        REVEALED_LETTERS[i] = CHOSEN_WORD.charAt(i);
        // displayCorrectGuesses();

        for(int j = 0; j < REVEALED_LETTERS.length; j++){
          if(REVEALED_LETTERS[i] == CHOSEN_WORD.charAt(j)){
            alreadyGuessed = true;
          } // if
        } // for

        if(!alreadyGuessed){
          CORRECT_GUESSES = CORRECT_GUESSES + 1;
        }//
      } // if
      else {
        WRONG_GUESSES++;
      } // else
    } // for
    if(CORRECT_GUESSES == CHOSEN_WORD.length()){
      //endGameWin();
    } // if
    if(WRONG_GUESSES == STRIKES){
      //endGameLose();
    } // if
  } // charCompare

  /**
   * For Testing: takes selectedDifficulty and selects a word from TEST_WORD String array
   * This then manipulates global variable CHOSEN_WORD
   * Initialize REVEALED_LETTERS to spaces.
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
    REVEALED_LETTERS = new char[CHOSEN_WORD.length()];
    for(int i = 0; i < REVEALED_LETTERS.length; i++){
      REVEALED_LETTERS[i] = ' ';
    } // for
  } // wordPicker(String)




















//------------------------------------------------------------------------------------------

  public void keyboardA(){

    final Button Guess_Key = findViewById(R.id.LetterA);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('a');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardB(){

    final Button Guess_Key = findViewById(R.id.LetterB);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('b');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardC(){

    final Button Guess_Key = findViewById(R.id.LetterC);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('c');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardD(){

    final Button Guess_Key = findViewById(R.id.LetterD);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('d');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardE(){

    final Button Guess_Key = findViewById(R.id.LetterE);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('e');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardF(){

    final Button Guess_Key = findViewById(R.id.LetterF);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('f');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardG(){

    final Button Guess_Key = findViewById(R.id.LetterG);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('g');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardH(){

    final Button Guess_Key = findViewById(R.id.LetterH);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('h');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardI(){

    final Button Guess_Key = findViewById(R.id.LetterI);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('i');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardJ(){

    final Button Guess_Key = findViewById(R.id.LetterJ);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('j');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardK(){

    final Button Guess_Key = findViewById(R.id.LetterK);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('k');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardL(){

    final Button Guess_Key = findViewById(R.id.LetterL);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('l');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardM(){

    final Button Guess_Key = findViewById(R.id.LetterM);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('m');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardN(){

    final Button Guess_Key = findViewById(R.id.LetterN);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('n');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardO(){

    final Button Guess_Key = findViewById(R.id.LetterO);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('o');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardP(){

    final Button Guess_Key = findViewById(R.id.LetterP);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('p');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardQ(){

    final Button Guess_Key = findViewById(R.id.LetterQ);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('q');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardR(){

    final Button Guess_Key = findViewById(R.id.LetterR);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('r');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardS(){

    final Button Guess_Key = findViewById(R.id.LetterS);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('s');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardT(){

    final Button Guess_Key = findViewById(R.id.LetterT);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('t');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardU(){

    final Button Guess_Key = findViewById(R.id.LetterU);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('u');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardV(){

    final Button Guess_Key = findViewById(R.id.LetterV);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('v');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardW(){

    final Button Guess_Key = findViewById(R.id.LetterW);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('w');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardX(){

    final Button Guess_Key = findViewById(R.id.LetterX);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('x');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardY(){

    final Button Guess_Key = findViewById(R.id.LetterY);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('y');


        Guess_Key.setBackgroundColor(Color.BLACK);
      }
    });

  }//Keyboard

  public void keyboardZ(){

    final Button Guess_Key = findViewById(R.id.LetterZ);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('z');


        Guess_Key.setBackgroundColor(Color.BLACK);

      }
    });

  }//Keyboard


  /**
   *
   * @param letter (char)
   */
  public void keyPress(char letter){
    charCompare(letter);
  }


} // Game

