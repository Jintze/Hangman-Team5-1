package com.example.nathanpelletier.hangman;

import android.net.Uri;
import android.view.View;
import android.widget.VideoView;

/**
 * Created by fatim on 2017-12-19.
 */

public class StoryMode {
    VideoView videoView;
    public void onClick(){
            String vidoePath ="C:\\Users\\fatim\\Desktop\\Hangman-Team5-1\\app\\src\\main\\res\\raw\\storymodevideo.mp4";
            Uri uri = Uri.parse(vidoePath);
            videoView.setVideoURI(uri);
            videoView.start();
    }
}
