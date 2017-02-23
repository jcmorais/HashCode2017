package entities;

import java.util.List;

/**
 * Created by carlosmorais on 23/02/2017.
 */
public class CacheServer {
    private int id;
    private int capacity;

    public CacheServer(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
