package com.example.nathanpelletier.hangman;

import android.content.Intent;
import android.graphics.Bitmap;
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


public class Game extends AppCompatActivity {

  private final int STRIKES = 6;
  private int MONEY_PER_WIN = 5;
  private int MONEY_PER_LOSS = 25;
  private int moneyOnHand = 0;
  private int wrongGuesses = 0;
  private  int correctGuesses = 0;

  /**
   * the random word selected by computer based off of difficulty selected
   */
  private String CHOSEN_WORD;

  /**
   * Character array to store output. Might need to add final so only this class can modify the
   * variable.
   */
  public char[] REVEALED_LETTERS;

  /* allows access to GetWordClass */
  private GetWord GET_A_RANDOM_WORD = new GetWord();

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

    String SELECTED_DIFFICULTY = getIntentData();
    wordPicker(SELECTED_DIFFICULTY);
    gamePosterChanger(SELECTED_DIFFICULTY);

    inGameMenu();

    printDashes();

    printLives(STRIKES);


  } // onCreate(Bundle)

  /**
   * Runs all methods in game class.
   *
   * also checks player progress (win/loss)
   */
  public void onStart() {
    super.onStart();

    int v = 0;

    //test//e
    //Log.d("value","STRIKES:" + STRIKES);
    //Log.d("value","correct guesses:" + correctGuesses);
    //Log.d("value","Word:" + CHOSEN_WORD);
    //Log.d("value","onStart:" + v);

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

  } // onStart()


  /**
   * Removes one life icon
   */
  public void removeLife(){
    LinearLayout LinearLayout_Hearts = findViewById(R.id.LinearLayout_Hearts);

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
    LinearLayout LinearLayout_Hearts = findViewById(R.id.LinearLayout_Hearts);

    for (int i = 0; i < STRIKES; i++ ){
      ImageView view = new ImageView(this);
      view.setImageResource(R.drawable.lives);
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
    RelativeLayout poster = findViewById(R.id.posterLayout);
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

        REVEALED_LETTERS[i] = CHOSEN_WORD.charAt(i);
        // displayCorrectGuesses();

        for(int j = 0; j < REVEALED_LETTERS.length; j++){
          if(REVEALED_LETTERS[i] == CHOSEN_WORD.charAt(j)){
            alreadyGuessed = true;
          } // if
        } // for

      } // if
    } // for

    if(correctGuesses == oldCorrectGuessesVal){
      wrongGuesses++;
      removeLife();
    }//if

    if(correctGuesses == CHOSEN_WORD.length()){
      moneyOnHand += MONEY_PER_WIN;
      endGameScreen(1); //1 = win
    } // if
    if(wrongGuesses == STRIKES){
      if(moneyOnHand >= MONEY_PER_LOSS){
         moneyOnHand -= MONEY_PER_LOSS;
      } else {
        endGameScreen(2); //2 = lose
      } // else
    } // if
  } // charCompare

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
    REVEALED_LETTERS = new char[CHOSEN_WORD.length()];
    for(int i = 0; i < REVEALED_LETTERS.length; i++){
      REVEALED_LETTERS[i] = ' ';
    } // for
  } // wordPicker(String)

  /**
   * Inflates winorlose.xml over top of ingame.xml
   * and encapsulates all end game code
   *
   * @Result: takes in number value 1 = win; everything else is loss
   */
  public void endGameScreen(int Result){

    //initialize
    LayoutInflater LAYOUT_INFLATER_END_GAME = this.getLayoutInflater();
    RelativeLayout SCREEN = findViewById(R.id.inGameMainParent);

    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
            LinearLayout.LayoutParams.FILL_PARENT);


    View END_GAME = LAYOUT_INFLATER_END_GAME.inflate(R.layout.winorlose,null);

    END_GAME.setLayoutParams(layoutParams);

    //start
    END_GAME.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), android.R.anim.fade_in));

    SCREEN.addView(END_GAME);

    //Everything within winorlose.xml

    TextView RESULT = findViewById(R.id.Result);

    TextView Word = findViewById(R.id.ChosenWord);


    if (Result == 1){
      RESULT.setText(R.string.Win);
    }else{
      RESULT.setText(R.string.Lose);
    }//else


    Word.setText(CHOSEN_WORD);

    //onClicks
    Button EasyReplay = findViewById(R.id.EasyDifficultySelect);

    EasyReplay.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent startGame = new Intent(Game.this, Game.class);
        startGame.putExtra("Difficulty", "easy");
        startActivity(startGame);

      }//onClick
    });//popUpMenu

    Button MediumReplay =  findViewById(R.id.MediumDifficultySelect);
    MediumReplay.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent startGame  = new Intent(Game.this, Game.class);
        startGame.putExtra("Difficulty", "medium");
        startActivity(startGame);

      }
    });

    Button HardReplay = findViewById(R.id.HardDifficultySelect);
    HardReplay.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent startGame = new Intent(Game.this, Game.class);
        startGame.putExtra("Difficulty",  "hard");
        startActivity(startGame);
      }
    });


  }//endGameScreen



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

