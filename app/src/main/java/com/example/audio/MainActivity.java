package com.example.audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button button;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.stuff);
        button = findViewById(R.id.button);
    }

    public void change(View view) {
        if (flag) {
            mediaPlayer.pause();
            button.setText("PLAY");
        } else {
            mediaPlayer.start();
            button.setText("STOP");

        }
        flag = !flag;
    }
}