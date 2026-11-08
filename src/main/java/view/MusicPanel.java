package view;

import audio.WavPlayer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MusicPanel extends JPanel{
  // Swing 面板负责处理按钮点击，具体的音频控制交给 WavPlayer。
  public MusicPanel(WavPlayer player) {
    JButton playButton = new JButton("Play");
    playButton.addActionListener(event -> player.play());

    JButton pauseButton = new JButton("Pause");
    pauseButton.addActionListener(event -> player.pause());

    JButton resumeButton = new JButton("Resume");
    resumeButton.addActionListener(event -> player.resume());

    add(playButton);
    add(pauseButton);
    add(resumeButton);
  }
  
}
