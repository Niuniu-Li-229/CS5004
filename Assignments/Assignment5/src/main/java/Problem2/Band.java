package Problem2;

import java.util.ArrayList;

public class Band implements Creator{

  private String bandName;
  private ArrayList<RecordingArtist> recordingArtists;

  public Band (String name, ArrayList<RecordingArtist> recordingArtists){
    this.bandName = name;
    this.recordingArtists = recordingArtists;
  }

  @Override
  public String getName(){
    return bandName;
  }

  public boolean hasMember(RecordingArtist artist){
    return recordingArtists.contains(artist);
  }

}
