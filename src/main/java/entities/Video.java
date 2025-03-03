package entities;

/**
 * Created by carlosmorais on 23/02/2017.
 */
public class Video {
    private int id;
    private int size;

    public Video(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", size=" + size +
                "}\n";
    }
}
