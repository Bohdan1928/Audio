package com.example.audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    SeekBar seekBar;
    Button button;
    AudioManager audioManager;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.stuff);

        audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(maxVolume);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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