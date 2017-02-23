import entities.CacheServer;
import entities.DataCenter;
import entities.EndPoint;
import entities.Parser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by carlosmorais on 23/02/2017.
 */
public class Run {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        System.out.println(parser.test());


        DataCenter dataCenter = parser.test();


        for (CacheServer cacheServer : dataCenter.getCachesServers().values()) {
            Map<Integer, Integer> latencies = new HashMap<>();
            Map<Integer, EndPoint> endpoints = new HashMap<>();
            for (EndPoint endPoint : dataCenter.getEndpoints().values()) {
                if(endPoint.getCacheServers().containsKey(cacheServer.getId())) {
                    endpoints.put(endPoint.getId(), endPoint);
                    latencies.put(endPoint.getId(), endPoint.getCacheServers().get(cacheServer.getId()));
                }
            }
            cacheServer.setEndPoints(endpoints);
            cacheServer.setLatencies(latencies);
        }

        int n = dataCenter.getCacheServersSize();
        int m = dataCenter.getVideosSize();

        int tamCache;
        int tabela[][] = new int[n][m];
        int i, j, maior=0;
        int a, b;
        tabela = dataCenter.preencheTabela(tabela);
        int parar=n*m;
        boolean continua = true;
        while(parar>0){
            a=0;
            b=0;
            maior = 0;
            for(i=0;i<n;i++){
                for(j=0; j<m; j++)
                    if(tabela[i][j]>maior)
                    {
                        maior=tabela[i][j];
                        a=j;
                        b=i;
                    }
            }
            if (maior == 0) continua = false;
            parar--;
            int tamV = dataCenter.getVideos().get(a).getSize();
            int tamC = dataCenter.getCachesServers().get(b).getCapacity();
            if(tamV <= tamC){
                dataCenter.getCachesServers().get(b).setCapacity(tamC-tamV);
                tabela[a][b]= -2;
            } //guardar info para o ficheiro de output
            tabela[a][b]= -1;

        }
        //precorrer tabela encontrar -2 e preencher por cahces;
        int cachesUsadas = 0;


        for (i=0; i<n; i++)
            for(j=0; j<m; j++)
                if (tabela[i][j]== -2){
            cachesUsadas++;
            j=m;
        }

        for (i=0; i<n; i++)
            for(j=0; j<m; j++)
                System.out.println(tabela[i][j]);

        int nVideos;
        StringBuilder sb = new StringBuilder();

            PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
            writer.println(cachesUsadas);

            for (i=0; i<n; i++){
                sb.append(i + " ");
                nVideos = 0;
                for(j=0; j<m; j++){
                    if (tabela[i][j]== -2){
                        nVideos++;
                        sb.append(tabela[i][j] + " ");
                    }
                    if(nVideos !=0)
                    writer.println(sb.toString());
                }
                writer.close();
        }

        System.out.println("DONE");
        System.exit(0);

    }





}

