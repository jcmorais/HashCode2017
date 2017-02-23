package entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by carlosmorais on 23/02/2017.
 */
public class Parser {


    public DataCenter test() throws IOException {
        String fileName = "me_at_the_zoo.in";

        String path = this.getClass().getClassLoader().getResource(fileName).getPath();
        String file = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        String[] lines = file.split("\\n");

        /*
        int x = lines.length;
        for (int i = 0; i < x; i++) {
            System.out.println(lines[i]);
        }
        */

        /**
         *  1st line
         */
        String line = lines[0];
        String[] parameters = line.split(" ");
        int totalVideos = Integer.parseInt(parameters[0]);
        int totalEndpoints = Integer.parseInt(parameters[1]);
        int totalRequests = Integer.parseInt(parameters[2]);
        int totalCaches = Integer.parseInt(parameters[3]);
        int cacheSize = Integer.parseInt(parameters[4]);

        Map<Integer, Video> videos = new HashMap<>();
        Map<Integer, EndPoint> endpoints = new HashMap<>();
        Map<Integer, CacheServer> cachesservers = new HashMap<>();

        for (int i = 0; i < totalCaches; i++) {
            cachesservers.put(i, new CacheServer(i, cacheSize));
        }


        /**
         *  2nd line
         */

        line = lines[1];
        parameters = line.split(" ");

        for (int i = 0; i < totalVideos; i++)
            videos.put(i, new Video(i, Integer.parseInt(parameters[i])));



        /**
         *  Endpoints
         */

        int lineCounter = 2;

        //i = endpointID
        for (int i = 0; i < totalEndpoints; i++){
            //1st endpoint line
            parameters = lines[lineCounter].split(" ");
            int latencyToDC = Integer.parseInt(parameters[0]);
            int caches = Integer.parseInt(parameters[1]);
            lineCounter++;
            Map<Integer, Integer> cacheServers = new HashMap<>();
            for (int j = 0; j < caches; j++, lineCounter++) {
                parameters = lines[lineCounter].split(" ");
                cacheServers.put(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
            }
            // TODO: 23/02/2017 CUIDADO COM O NULL
            endpoints.put(i, new EndPoint(i, latencyToDC, cacheServers));
        }



        /**
         *  Endpoints
         */


        for (int i = 0; i < totalRequests; lineCounter++, i++) {
            parameters = lines[lineCounter].split(" ");
            int videoId = Integer.parseInt(parameters[0]);
            int endpointId = Integer.parseInt(parameters[1]);
            int numberOfRequests = Integer.parseInt(parameters[2]);
            endpoints.get(endpointId).addRequest(videoId, numberOfRequests);
        }

         return new DataCenter(videos, endpoints, cachesservers);
    }
}
