package main.java.statePattern.state;

public class Main {
    public static void main(String[] args) {
        /** playing 状态下按下
         *      play     : 会暂停（切换到 ready state)
         *      lock     : 上锁 (切换到 lock state)
         *      next     : 下一首
         *      previous : 上一首
         *  ready 状态下按下：
         *      play     : 开始播放歌曲（切换到 playing state）
         *          这里从那一首开始播放就取决于 player 中维护的 currentTrack
         *      lock     : 上锁 (切换到 lock state)
         *      next     : 不支持
         *      previous : 不支持
         *  lock 状态下按下：
         *      play     : 切换到 ready state
         *      lock     : 检查一下player是否还在playing
         *      next     : 不支持
         *      previous : 不支持
         */
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}

