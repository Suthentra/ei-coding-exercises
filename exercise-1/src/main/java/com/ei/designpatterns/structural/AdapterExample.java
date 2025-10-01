package com.ei.designpatterns.structural;

public class AdapterExample implements MediaPlayer {

    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String filename) {
        // Built-in support for mp3
        if(audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + filename);
        }
        // MediaAdapter for other formats
        else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, filename);
        } else {
            System.out.println("Invalid media type: " + audioType);
        }
    }

    // Test the Adapter
    public static void main(String[] args) {
        AdapterExample player = new AdapterExample();

        player.play("mp3", "song.mp3");
        player.play("mp4", "video.mp4");
        player.play("vlc", "movie.vlc");
        player.play("avi", "file.avi");  // Invalid media type
    }
}
