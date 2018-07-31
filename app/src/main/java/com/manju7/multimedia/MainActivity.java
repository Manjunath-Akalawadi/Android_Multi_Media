package com.manju7.multimedia;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button button;
    VideoView videoView;
    MediaController mediaController;

    Button play , pause , stop;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        videoView = (VideoView) findViewById(R.id.videoView);
        mediaController = new MediaController(this);

        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        stop = (Button) findViewById(R.id.stop);

        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.bond);
    }

    public void  videoPlay(View view){

        String str = "android.resource://com.manju7.multimedia/"+R.raw.jworld;
        Uri uri =Uri.parse(str);
        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();

    }

    public void btnPlay(View view){

        mediaPlayer.start();
    }

    public void btnPause(View view){

        mediaPlayer.pause();
    }

    public void btnStop(View view){

        mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.bond);

    }
}
