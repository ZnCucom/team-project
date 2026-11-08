package audio;

import java.net.URL;

public class MusicTrack {
  private final String name;
  private final URL source;
  private final boolean builtIn;

  public MusicTrack(String name, URL source, boolean builtIn) {
    this.name = name;
    this.source = source;
    this.builtIn = builtIn;
  }

  public String getName() {
    return name;
  }

  public URL getSource() {
    return source;
  }

  public boolean isBuiltIn() {
    return builtIn;
  }

  @Override
  public String toString() {
    return name;
  }
}
