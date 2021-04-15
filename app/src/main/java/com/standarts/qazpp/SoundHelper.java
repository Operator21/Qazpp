package com.standarts.qazpp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class SoundHelper {
    //private static SoundPool soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
    private Context context;
    private MediaPlayer mediaPlayer;

    public SoundHelper(Context context){
        this.context = context;
        mediaPlayer = MediaPlayer.create(context, R.raw.click);
    }

    public void PlayClick(){
        //soundPool.play(soundPool.load(context, R.raw.click, 1), 1, 1,0,0, 1.5f);
        mediaPlayer.start();
    }
}
