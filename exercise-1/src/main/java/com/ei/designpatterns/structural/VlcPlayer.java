package com.ei.designpatterns.structural;

public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String filename) {
        System.out.println("Playing VLC file: " + filename);
    }

    @Override
    public void playMp4(String filename) {
        // Do nothing
    }
}
