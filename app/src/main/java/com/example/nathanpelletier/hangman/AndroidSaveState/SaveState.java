package com.example.nathanpelletier.hangman.AndroidSaveState;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by Eddy on 2017-12-18.
 */

public class SaveState extends Application {

    //for the story

    private int CrooksGivenUp;

    private int NetWorth;

    private int oldNetworth;


    public String StoryProgress(){
        if (CrooksGivenUp <10 ){
            return "easy";
        }// stay in easy difficulty
        else if(CrooksGivenUp > 10||CrooksGivenUp < 20 ){
            return"medium";
        }//stay in medium difficulty
        else{
            return "hard";
        }//stay hard

    }//Keep track of difficulty

    public int getOldNetworth(){
        return oldNetworth;
    }




    public int getCrooksGivenUp() {
        return CrooksGivenUp;
    }

    public void setCrooksGivenUp(int crooksGivenUp) {
        CrooksGivenUp = crooksGivenUp;
    }

    public int getNetWorth() {
        return NetWorth;
    }

    public void setNetWorth(int deposit) {
        oldNetworth = NetWorth;
        NetWorth = NetWorth + deposit;
    }



}//class
