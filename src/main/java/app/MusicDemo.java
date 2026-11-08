package app;

import audio.WavPlayer;
import view.MusicPanel;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MusicDemo {
  public static void main(String[] args) throws Exception {
    // 从运行时的资源根目录查找随程序打包的 WAV。
    URL audio = MusicDemo.class.getResource("/music/demo.wav");
    if (audio == null) {
      throw new IllegalStateException("Cannot find /music/demo.wav");
    }

    // Clip 会预加载音频，因此加载完毕后可以关闭输入流。
    Clip clip = AudioSystem.getClip();
    try (AudioInputStream input = AudioSystem.getAudioInputStream(audio)) {
      clip.open(input);
    }

    // 在 Swing 的事件派发线程（EDT）上创建并显示窗口。
    SwingUtilities.invokeLater(() -> {
      JFrame frame = new JFrame("Music Demo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(new MusicPanel(new WavPlayer(clip)));
      frame.setSize(320, 140);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
    });
  }
}
