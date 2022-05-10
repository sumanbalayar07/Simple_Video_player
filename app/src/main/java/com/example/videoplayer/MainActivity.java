package com.example.videoplayer;

import static com.example.videoplayer.R.raw.jk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = findViewById(R.id.seekBar);
        ImageView imageView = findViewById(R.id.imageView);
        SurfaceView surfaceView = findViewById(R.id.surfaceView);
        mediaPlayer=MediaPlayer.create(this, jk);
        surfaceView.setKeepScreenOn(true);
        SurfaceHolder surfaceHolder= surfaceView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {@Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                mediaPlayer.setDisplay(surfaceHolder);
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

            }});
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {@Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    mediaPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }});
        imageView.setOnClickListener(view -> {
            if(mediaPlayer.isPlaying())
            {
                mediaPlayer.pause();
            }else
            {
                mediaPlayer.start();
            }
        });
    }
    protected void OnStop(Bundle SavedInstanceState)
    {
        mediaPlayer.release();
        mediaPlayer=null;
    }
}