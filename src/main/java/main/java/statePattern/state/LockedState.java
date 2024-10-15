package main.java.statePattern.state;

public class LockedState extends State{

    public LockedState (Player player) {
        super(player);
        player.setPlaying(false);
    }

    @Override
    public String onLock() {
        if (player.isPlaying()) {
            player.changeState(new ReadyState(player));
            return "Stop playing";
        }
        return "Already Locked";
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Locked -> Ready";
    }

    @Override
    public String onNext() {
        return "LockedState not support playing next";
    }

    @Override
    public String onPrevious() {
        return "LockedState not support playing previous";
    }
}
