package entities;

import java.util.List;
import java.util.Map;

/**
 * Created by carlosmorais on 23/02/2017.
 */
public class CacheServer {
    private int id;
    private int capacity;

    private Map<Integer, EndPoint> endPoints;
    private Map<Integer, Integer> latencies;

    public CacheServer(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public Map<Integer, EndPoint> getEndPoints() {
        return endPoints;
    }

    public void setEndPoints(Map<Integer, EndPoint> endPoints) {
        this.endPoints = endPoints;
    }

    public Map<Integer, Integer> getLatencies() {
        return latencies;
    }

    public void setLatencies(Map<Integer, Integer> latencies) {
        this.latencies = latencies;
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
        for(EndPoint e: endPoints.values()){
            if(e.getRequests().containsKey(v.getId())) {
                int n = e.getRequests().get(v.getId());
                if (n > 0) {
                    r += n * (int) ((e.getLatencyToDC() - latencies.get(e.getId()) / v.getSize()));
                }
            }

        }
        return r;
    }

    @Override
    public String toString() {
        return "CacheServer{" +
                "id=" + id +
                ", capacity=" + capacity +
                "}\n";
    }
}
