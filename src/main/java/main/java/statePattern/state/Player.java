package main.java.statePattern.state;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private State state;
    private boolean playing = false;
    private List<String> playList = new ArrayList<>();
    private int currentTrack = 0;

    Player () {
        this.state = new ReadyState(this);
        playing = true;
        for (int i = 0; i < 12; i++) {
            playList.add("track" + i);
        }
    }

    public String onPlay() {
        return getState().onPlay();
    }

    public String onLock() {
        return getState().onLock();
    }

    public String onNext() {
        return getState().onNext();
    }

    public String onPrevious() {
        return getState().onPrevious();
    }

    public State getState() {
        return state;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public String startPlayBack() {
        return "Playing " + playList.get(currentTrack);
    }

    public String nextTrack() {
        currentTrack++;
        if (currentTrack >= playList.size()) {
            currentTrack = 0;
        }
        return "Playing " + playList.get(currentTrack);
    }

    public String previousTrack() {
        currentTrack--;
        if (currentTrack < 0) {
            currentTrack = playList.size() - 1;
        }
        return "Playing " + playList.get(currentTrack);
    }

    public void setCurrentTrackAfterStop () {
        this.currentTrack = 0;
    }

}
