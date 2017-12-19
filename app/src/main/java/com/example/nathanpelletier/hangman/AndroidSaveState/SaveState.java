package com.example.nathanpelletier.hangman.AndroidSaveState;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Eddy on 2017-12-18.
 */

public class SaveState extends AppCompatActivity {




    Context context;
    //for the story

    private int CrooksGivenUp;

    private int NetWorth = 0;

    private int Rank;

public void onCreate(Bundle saveInstanceState){
    super.onCreate(saveInstanceState);
    context = getApplicationContext();


}



    public String StoryProgress(){
        if (CrooksGivenUp <10 ){
            Rank = 1;
            return "easy";
        }// stay in easy difficulty
        else if(CrooksGivenUp > 10||CrooksGivenUp < 20 ){
            Rank = 2;
            return"medium";
        }//stay in medium difficulty
        else{
            Rank = 3;
            return "hard";
        }//stay hard

    }//Keep track of difficulty

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
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

    public void setNetWorth(int NetWoth) {
        NetWorth = NetWorth;
    }

    public void crooksgivenup(){
        if (StoryProgress()=="easy"){
            CrooksGivenUp = 5;
        }
        else if(StoryProgress() == "medium"){
            CrooksGivenUp = 10;
        }else{
            CrooksGivenUp = 15;
        }
    }


}//class
