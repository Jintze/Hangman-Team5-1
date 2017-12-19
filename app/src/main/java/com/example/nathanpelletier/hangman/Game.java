package com.example.nathanpelletier.hangman;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.nathanpelletier.hangman.AndroidSaveState.SaveState;


public class Game extends AppCompatActivity {
  SaveState saveState = new SaveState();


  //To Play the game
  private int STRIKES = 6;
  private int wrongGuesses = 0;
  private  int correctGuesses = 0;
  /**
   * the random word selected by computer based off of difficulty selected
   */
  private String CHOSEN_WORD;


  //StoryMode
  boolean storymode = false;

  //extra




  /* allows access to GetWordClass */
  private GetWord GET_A_RANDOM_WORD = new GetWord();

  /**
   * Displays result of each character guess (in game screen)
   */
  LinearLayout LINEARLAYOUT_GUESS_RESULTS;

  /*public void onPause() {
    super.onPause();

    Log.d("onPause","onPause is now running ");
    savegame();


  }//onPause*/

  /*public void onResume() {
    super.onResume();
    Log.d("onResume","onResume is now running ");
    restoreGame();


    if(storymode){
      InGameCheck();

    }

  }//onResume*/

  /*public void restoreGame(){

    SharedPreferences preferences = getPreferences(MODE_PRIVATE);

    saveState.setCHOSEN_WORD(preferences.getString("word","DEFAULT"));//double check
    saveState.setInGame(preferences.getBoolean("InGame",false));



  }

  public void savegame(){
    SharedPreferences preferences = getPreferences(MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();

    editor.putString("word",CHOSEN_WORD);
    editor.putInt("STRIKES",STRIKES);

    //commit to storage
    editor.apply();
  }*/

  /*public void onSaveInstanceState(Bundle savedInstanceState){
    super.onSaveInstanceState(savedInstanceState);

    savedInstanceState.putString("word",CHOSEN_WORD);
    savedInstanceState.putBoolean("InGame",ingame);
    savedInstanceState.putInt("STRIKES",STRIKES);
    savedInstanceState.putInt("wrongGuesses",wrongGuesses);
    savedInstanceState.putInt("correctGuesses",correctGuesses);
  }

  public void onRestoreInstanceState(Bundle savedInstanceState){
    super.onRestoreInstanceState(savedInstanceState);

    savedInstanceState.getString("word");
    savedInstanceState.getBoolean("InGame");
    savedInstanceState.getInt("STRIKES");
    savedInstanceState.getInt("wrongGuesses");
    savedInstanceState.getInt("correctGuesses");

  }*/


  public void Directory(){
    Intent storyIntent = getIntent();
    String SAVED_DIFFICULTY = saveState.StoryProgress();//from saveState

    //game mode check
    if (null == storyIntent.getStringExtra("Story")){
       storymode = false;
    }else{
      storymode = true;
      //button press check
    }

    //game mode execution
    if (storymode){
      //initialize CurrentBalance and

      StoryMode(SAVED_DIFFICULTY);
    }else
      RegularGame();
  }

  public void StoryMode(String Difficulty){
    wordPicker(Difficulty);
    gamePosterChanger(Difficulty);

    inGameMenu();

    printDashes();

    printLives(STRIKES);

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

    //needs a different end game
  }//StoryMode

  public void RegularGame(){

    String SELECTED_DIFFICULTY = getIntentData();
    wordPicker(SELECTED_DIFFICULTY);
    gamePosterChanger(SELECTED_DIFFICULTY);

    inGameMenu();

    printDashes();

    printLives(STRIKES);

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

  }//StoryMode


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.ingame);

    LINEARLAYOUT_GUESS_RESULTS = findViewById(R.id.GuessResult); // match or nahh

    Directory();



  } // onCreate(Bundle)

  /**
   * Runs all methods in game class.
   *
   * also checks player progress (win/loss)
   */
  public void onStart() {
    super.onStart();



  } // onStart()


  /**
   * Removes one life icon
   */
  public void removeLife(){
    LinearLayout LinearLayout_Hearts = findViewById(R.id.LinearLayoutHearts);

    View view = LinearLayout_Hearts.getChildAt(STRIKES - wrongGuesses);

    LinearLayout_Hearts.removeView(view);

    Log.d("lives delete ","id Num : " + (STRIKES- wrongGuesses));
  }//removeLife


  /**
   * Strike value = amount of hearts printed
   *
   * created id is i + length of the word
   */
  public void printLives(int STRIKES){
    LinearLayout LinearLayout_Hearts = findViewById(R.id.LinearLayoutHearts);

    for (int i = 0; i < STRIKES; i++ ){
      ImageView view = new ImageView(this);
      view.setImageResource(R.drawable.heart2);
      view.setId(i+CHOSEN_WORD.length());

      Log.d("lives print ","id Num : "+ (i+CHOSEN_WORD.length()));
      LinearLayout_Hearts.addView(view);
    }
  }//

  /**
   * top left menu button onclick this sends you back to the title screen
   * todo: change icon
   */
  public void inGameMenu(){
    ImageButton IN_GAME_MENU_BUTTON = findViewById(R.id.PopUpMenuButton);
    IN_GAME_MENU_BUTTON.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent GO_HOME = new Intent(Game.this, Menu.class);
        startActivity(GO_HOME);
      }
    });





  }//inGameMenu

  /**
   * changes the poster image based on selectedDifficulty
   * @param selectedDifficulty
   */
  public void gamePosterChanger(String selectedDifficulty){
    RelativeLayout poster = findViewById(R.id.PosterLayout);
    //todo: fatima link photos here
    switch (selectedDifficulty){
      case "easy":{
        poster.setBackgroundResource(R.drawable.secondscreen);
        break;
      }//easy
      case "medium":{
        poster.setBackgroundResource(R.drawable.secondscreen);
        break;
      }//medium
      case "hard":{
        poster.setBackgroundResource(R.drawable.secondscreen);
        break;
      }//hard
    }//switch(selectedDifficulty)
  }//gamePosterChanger

  /**
   * displays the correctly guessed letter in the proper TextView
   * -Text size 30-
   * @param LETTER_LOCATION
   * @param GUESSED_LETTER
   */
  public void displayCorrectGuesses(int LETTER_LOCATION,char GUESSED_LETTER){
    TextView view = findViewById(LETTER_LOCATION);
    view.setText(String.valueOf(GUESSED_LETTER));
    view.setTextSize(30);
  }//displayCorrectGuesses

  /**
   * Creates as many textviews side by side as the CHOSEN_WORD has letters
   * and placing them in LINEARLAYOUT_GUESS_RESULTS chronologically
   * id from 0 - n; n = CHOSEN_WORD length
   */
  public void printDashes (){
    for(int i = 0; i < CHOSEN_WORD.length(); i++){
      TextView CORRECT_GUESS = new TextView(this);
      CORRECT_GUESS.setText(" ___ ");
      CORRECT_GUESS.setId(i);
      Log.d("dashes print ","id Num : "+ i);
      LINEARLAYOUT_GUESS_RESULTS.addView(CORRECT_GUESS);
    }//for
  }//printDashes

  /**
   * Takes in user selected difficulty(Easy, Medium, Hard) from main menu and
   * transfers it to Game class
   * @return String SELECTED_DIFFICULTY
   */
  public String getIntentData() {
    Intent intent = getIntent();
    String SELECTED_DIFFICULTY = intent.getStringExtra("Difficulty");
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
    int oldCorrectGuessesVal = correctGuesses;
    for (int i = 0; i < CHOSEN_WORD.length(); i++) {
      if (inputLetter == CHOSEN_WORD.charAt(i)) {
        displayCorrectGuesses(i,inputLetter);
        correctGuesses++;

      } // if
    } // for
    if(correctGuesses == oldCorrectGuessesVal){
      wrongGuesses++;
      removeLife();
    }//if

    WinOrLossChecker();



  } // charCompare


  public void WinOrLossChecker(){
    if(correctGuesses == CHOSEN_WORD.length()){

      endGameScreen(1); //1 = win
    } // if
    if(wrongGuesses == STRIKES){
        endGameScreen(2); //2 = lose
      } // else
    } // WinOrlossChecker


  /**
   * For Testing: takes selectedDifficulty and selects a word from TEST_WORD String array
   * This then manipulates global variable CHOSEN_WORD
   * Initialize REVEALED_LETTERS to spaces.
   * @param selectedDifficulty
   */
  public void wordPicker(String selectedDifficulty){
    switch(selectedDifficulty){
      case "easy":
        CHOSEN_WORD = GET_A_RANDOM_WORD.start("easy");
        break;
      case "medium":
        CHOSEN_WORD = GET_A_RANDOM_WORD.start("medium");
        break;
      case "hard":
        CHOSEN_WORD = GET_A_RANDOM_WORD.start("hard");
        break;
    } // switch

  } // wordPicker(String)

  public void endGameScreen(int Result) {
    if (storymode) {

      //todo: get this sorted fatima plz

      Intent endGameIntent = new Intent(Game.this, StoryModeInGame.class);

      endGameIntent.putExtra("Result", Result);
      endGameIntent.putExtra("WORD", CHOSEN_WORD);

      startActivity(endGameIntent);

    }// storymode game over screen
    else {
      Intent endGameIntent = new Intent(Game.this, WinOrLose.class);

      endGameIntent.putExtra("Result", Result);
      endGameIntent.putExtra("WORD", CHOSEN_WORD);

      startActivity(endGameIntent);
    }//regular game end screen
  }//endGameScreen


  /**
   * disables built in back button
   */
  public void onBackPressed(){
  }


//------------------------------------------------------------------------------------------

  /**
   * Encapsulates all code necessary to run keyboard
   *
   * NOT WORKIN
   */
  public void keyboard(){
  /* not sure if we need a switch table or if we should just set all of these now */

  }//Keyboard

  /**
   * Runs charCompare after key is pressed
   * @param letter (char)
   */
  public void keyPress(char letter){
    charCompare(letter);
  }//keyPress

  public void keyboardA(){

    final Button Guess_Key = findViewById(R.id.LetterA);

    Guess_Key.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //Log.d("sheeeesh","please please please mercy meeeee");

        keyPress('a');

        Guess_Key.setBackgroundColor(Color.BLACK);

        Guess_Key.setEnabled(false);
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
        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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
        Guess_Key.setEnabled(false);


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

        Guess_Key.setEnabled(false);

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
        Guess_Key.setEnabled(false);


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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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
        Guess_Key.setEnabled(false);


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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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
        Guess_Key.setEnabled(false);


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
        Guess_Key.setEnabled(false);


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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

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

        Guess_Key.setEnabled(false);

        Guess_Key.setBackgroundColor(Color.BLACK);

      }
    });

  }//Keyboard


} // Game