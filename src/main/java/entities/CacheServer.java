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
    
      public int poupo(Video v){
        int r=0;
        for(endPoint e: endPoints){
            int n = e.nRequests(v);
            if(n>0){
            r+= n*(e.getLatencyToDC() - latencia.get(e.getID())
                    }
        }
    };

    @Override
    public String toString() {
        return "CacheServer{" +
                "id=" + id +
                ", capacity=" + capacity +
                "}\n";
    }
}
