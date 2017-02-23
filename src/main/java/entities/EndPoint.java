package entities;

import java.util.Map;

/**
 * Created by carlosmorais on 23/02/2017.
 */
public class EndPoint {
    private int id;
    private int latencyToDC;

    private Map<Integer, Integer> requests; //videoID to  numberOfRequests
    private Map<Integer, Integer> cacheServers; //cacheID,  latency



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLatencyToDC() {
        return latencyToDC;
    }

    public void setLatencyToDC(int latencyToDC) {
        this.latencyToDC = latencyToDC;
    }

    public Map<Integer, Integer> getRequests() {
        return requests;
    }

    public void setRequests(Map<Integer, Integer> requests) {
        this.requests = requests;
    }

    public Map<Integer, Integer> getCacheServers() {
        return cacheServers;
    }

    public void setCacheServers(Map<Integer, Integer> cacheServers) {
        this.cacheServers = cacheServers;
    }
}
