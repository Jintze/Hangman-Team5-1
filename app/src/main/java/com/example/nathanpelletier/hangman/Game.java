/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.nathanpelletier.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Peter Zeng
 * @author Nathan Pelletier
 * @version 0.0.2
 */
public class Game {

  /*
   * Total number of words in our current files
   */
  private final int WORD_COUNT = 333;
  //private final int WORD_COUNT = 1;

  /**
   * @param randomNumber an integer given from Random class
   * @param wordList a File with words of difficulty
   * @return String selected word.
   */
  private String selectWord(int randomNumber, File wordList) throws FileNotFoundException {
    Scanner sc = new Scanner(wordList);
    for(int i = 0; i < randomNumber; i++){
      sc.nextLine();
    }//for
    return sc.nextLine();
  }//selectWord

  /**
   * currently uses a direct call to file for testing purposes.
   * A more phone based system is needed to solve current memory issues
   * @param difficulty string used to select the correct file
   * @return File a file containing the right word list for the difficulty selected.
   */
  private File openFile(String difficulty) {
    //Context context = new ContextWrapper(null);
    String fileName = difficulty + ".txt";
    File wordList = new File(".\\app\\src\\main\\assets\\" + fileName);
    return wordList;
  }//openFile(String)

  /**
   * @return int chosen number
   */
  private int getRandomNumber() {
    Random random = new Random();
    return random.nextInt(WORD_COUNT);
  }//getRandomNumber();

  private String getWord(String difficulty) throws FileNotFoundException {
    final int randomNumber = getRandomNumber();
    File wordList = openFile(difficulty);
    return selectWord(randomNumber, wordList);
  }//getWord(String)

  /**
   * @param difficulty string given from button press
   */
  public String hangman(String difficulty) throws FileNotFoundException {
    String selectedWord = getWord(difficulty);
    return selectedWord;
  }//hangman(String);

}//Game