package entities;

import java.util.List;
import java.util.Map;

/**
 * Created by carlosmorais on 23/02/2017.
 */
public class DataCenter {
    //private List<Video> videos;
    Map<Integer, Video> videos;

    public DataCenter(Map<Integer, Video> videos) {
        this.videos = videos;
    }

    public Map<Integer, Video> getVideos() {
        return videos;
    }

    public void setVideos(Map<Integer, Video> videos) {
        this.videos = videos;
    }
}
