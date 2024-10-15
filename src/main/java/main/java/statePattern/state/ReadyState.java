package main.java.statePattern.state;

public class ReadyState extends State {
    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        player.setCurrentTrackAfterStop();
        return "Ready -> Locked";
    }

    @Override
    public String onPlay() {
        String res = player.startPlayBack();
        player.changeState(new PlayingState(player));
        return res;
    }

    @Override
    public String onNext() {
        return "ReadyState not support play next;";
    }

    @Override
    public String onPrevious() {
        return "ReadyState not support play previous;";
    }
}
