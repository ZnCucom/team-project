package audio;

import javax.sound.sampled.Clip;

public class WavPlayer {
  private final Clip clip;

  public WavPlayer(Clip clip) {
    this.clip = clip;
  }

  // Play 总是从头播放，先停下当前播放，再回到第 0 帧。
  public void play() {
    clip.stop();
    clip.setFramePosition(0);
    clip.start();
  }

  // stop() 会保留当前播放位置，供 Resume 接着播放。
  public void pause() {
    clip.stop();
  }

  public void resume() {
    clip.start();
  }
}
