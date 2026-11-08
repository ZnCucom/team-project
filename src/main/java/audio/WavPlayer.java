package audio;

import javax.sound.sampled.Clip;

import java.net.URL;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class WavPlayer {
  private Clip clip;

  public WavPlayer(Clip clip) {
    this.clip = clip;
  }

  // Play 总是从头播放，先停下当前播放，再回到第 0 帧。
  public void play() {
    clip.stop();
    clip.setFramePosition(0);
    clip.start();
  }

  // 内置资源和本地文件都用 URL 表示，播放器可以用相同的方式读取它们。
  public void play(URL source)
      throws IOException, UnsupportedAudioFileException, LineUnavailableException {
    Clip nextClip = AudioSystem.getClip();

    // 先加载新音频，加载失败时释放新 Clip，并保留当前曲目。
    try (AudioInputStream input = AudioSystem.getAudioInputStream(source)) {
      nextClip.open(input);
    } catch (IOException | UnsupportedAudioFileException | LineUnavailableException
             | IllegalArgumentException e) {
      nextClip.close();
      throw e;
    }

    clip.close();
    clip = nextClip;
    play();
  }

  // stop() 会保留当前播放位置，供 Resume 接着播放。
  public void pause() {
    clip.stop();
  }

  public void resume() {
    clip.start();
  }
}
