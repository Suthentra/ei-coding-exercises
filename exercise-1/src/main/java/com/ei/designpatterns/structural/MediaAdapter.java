package com.ei.designpatterns.structural;

public class MediaAdapter implements MediaPlayer {

    AdvancedMediaPlayer advancedPlayer;

    public MediaAdapter(String audioType) {
        if(audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer = new VlcPlayer();
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String filename) {
        if(audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer.playVlc(filename);
        } else if(audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer.playMp4(filename);
        } else {
            System.out.println("Invalid media type: " + audioType);
        }
    }
}
