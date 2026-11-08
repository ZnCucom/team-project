package view;

import audio.MusicTrack;
import audio.WavPlayer;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MusicPanel extends JPanel {
  // Swing 面板负责处理按钮点击，具体的音频控制交给 WavPlayer。
  public MusicPanel(WavPlayer player, MusicTrack builtInTrack) {
    setLayout(new BorderLayout(8, 8));

    JLabel selectedFileLabel = new JLabel("Select a track and press Play.");

    // DefaultListModel 保存曲目对象。JList 根据模型显示曲目，导入时更新模型即可。
    DefaultListModel<MusicTrack> tracks = new DefaultListModel<>();
    tracks.addElement(builtInTrack);

    // JList 默认调用 MusicTrack.toString()，所以列表显示曲名，音频位置留在对象里。
    JList<MusicTrack> playlist = new JList<>(tracks);
    playlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    playlist.setSelectedIndex(0);

    JButton playButton = new JButton("Play");
    playButton.addActionListener(event -> {
      // 选择一行只改变列表的选中项。点击 Play 时才读取并播放选中的曲目。
      MusicTrack selectedTrack = playlist.getSelectedValue();
      if (selectedTrack == null) {
        return;
      }

      try {
        player.play(selectedTrack.getSource());
        selectedFileLabel.setText("Playing: " + selectedTrack.getName());
      } catch (IOException | UnsupportedAudioFileException | LineUnavailableException
               | IllegalArgumentException e) {
        selectedFileLabel.setText("Could not play: " + selectedTrack.getName());
      }
    });

    JButton pauseButton = new JButton("Pause");
    pauseButton.addActionListener(event -> player.pause());

    JButton resumeButton = new JButton("Resume");
    resumeButton.addActionListener(event -> player.resume());

    JButton addWavButton = new JButton("Add Local WAV");

    // 注册点击监听器。用户点击 Add Local WAV 时，才执行下面的选择和导入流程。
    addWavButton.addActionListener(event -> {
      JFileChooser chooser = new JFileChooser();
      // 选择器按副档名筛选，并隐藏「所有文件」选项。实际文件格式要在选中后检查。
      chooser.setFileFilter(new FileNameExtensionFilter("WAV audio (*.wav)", "wav"));
      chooser.setAcceptAllFileFilterUsed(false);

      // 以当前面板为父组件打开对话框。只有确认选择才处理文件，取消时保留现有歌单。
      if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        File file = chooser.getSelectedFile();

        try {
          // 读取音频格式信息，并检查 Java Sound 是否将文件识别为 WAV。
          // 这一步只验证文件类型。能否播放要等实际打开 Clip 时确认。
          AudioFileFormat format = AudioSystem.getAudioFileFormat(file);
          if (!AudioFileFormat.Type.WAVE.equals(format.getType())) {
            selectedFileLabel.setText("Please choose a WAV file.");
            // 提前结束本次按钮事件，避免把格式不符的文件加入歌单。
            return;
          }

          // 本地文件也转成 URL，方便播放器使用和内置曲目相同的读取流程。
          MusicTrack importedTrack = new MusicTrack(file.getName(), file.toURI().toURL(), false);
          tracks.addElement(importedTrack);

          // 新曲目追加到末尾，选中它并滚动到可见位置，等待用户点击 Play。
          int importedIndex = tracks.getSize() - 1;
          playlist.setSelectedIndex(importedIndex);
          playlist.ensureIndexIsVisible(importedIndex);
          selectedFileLabel.setText("Added: " + file.getName());
        } catch (IOException | UnsupportedAudioFileException e) {
          // 文件读取失败或格式无法识别时，只更新提示，已加入的项目会保留。
          selectedFileLabel.setText("Could not open: " + file.getName());
        }
      }
    });

    // 播放按钮放在同一排，导入按钮放在上面，状态提示放在下面。
    JPanel playbackControls = new JPanel();
    playbackControls.add(playButton);
    playbackControls.add(pauseButton);
    playbackControls.add(resumeButton);

    JPanel footer = new JPanel(new BorderLayout());
    footer.add(addWavButton, BorderLayout.NORTH);
    footer.add(playbackControls, BorderLayout.CENTER);
    footer.add(selectedFileLabel, BorderLayout.SOUTH);

    // 歌单占中间的可用空间，曲目多时通过 JScrollPane 滚动。
    add(new JLabel("My Playlist"), BorderLayout.NORTH);
    add(new JScrollPane(playlist), BorderLayout.CENTER);
    add(footer, BorderLayout.SOUTH);
  }
  
}
