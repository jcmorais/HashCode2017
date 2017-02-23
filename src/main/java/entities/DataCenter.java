package entities;

import java.util.List;
import java.util.Map;

/**
 * Created by carlosmorais on 23/02/2017.
 */
public class DataCenter {

    Map<Integer, Video> videos;
    Map<Integer, EndPoint> endpoints;
    Map<Integer, CacheServer> cachesServers;


    public DataCenter(Map<Integer, Video> videos, Map<Integer, EndPoint> endpoints, Map<Integer, CacheServer> cachesServers) {
        this.videos = videos;
        this.endpoints = endpoints;
        this.cachesServers = cachesServers;
    }

    public int getVideosSize(){
        return this.videos.size();
    }

    public int getEndpointsSize(){
        return this.endpoints.size();
    }

    public int getCacheServersSize(){
        return this.cachesServers.size();
    }

    public DataCenter(Map<Integer, Video> videos) {
        this.videos = videos;
    }

    public Map<Integer, Video> getVideos() {
        return videos;
    }

    public void setVideos(Map<Integer, Video> videos) {
        this.videos = videos;
    }


    public Map<Integer, EndPoint> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(Map<Integer, EndPoint> endpoints) {
        this.endpoints = endpoints;
    }

    public Map<Integer, CacheServer> getCachesServers() {
        return cachesServers;
    }

    public void setCachesServers(Map<Integer, CacheServer> cachesServers) {
        this.cachesServers = cachesServers;
    }


    @Override
    public String toString() {
        return "DataCenter{" +
                "videos=" + videos +
                ", endpoints=" + endpoints +
                ", cachesServers=" + cachesServers +
                '}';
    }
}
