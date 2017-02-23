import entities.DataCenter;
import entities.Parser;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by carlosmorais on 23/02/2017.
 */
public class Run {
    public static void main(String[] args) throws IOException {
        Parser parser = new Parser();
        System.out.println(parser.test());


        private DataCenter dataCenter = parser.test();
        
        
        int tamCache; 
        int tabela[][] = new int[M][N];
        int i, j, maior=0;
        int a, b;
        dataCenter.preencheTabela(tabela);
        boolean continua = true;
        while(continua){
            a=0;
            b=0;
            maior = 0;
            for(i=0;i<M;i++){
                for(j=0; j<N; j++)
                 if(tabela[i][j]>maior)
                 {
                    maior=tabela[i][j];
                    a=i;
                    b=j;
                }
            }
            if (maior == 0) continua = false;
            int tamV = dataCenter.getSizeVideo(a);
            int tamC = dataCenter.getCache(b).getCapacity();
            if((tamC+tamV) < tamCache){ 
                dataCenter.getCache(b).setCapacity(tamC+tamV);
                tabela[a][b]= -2;
            } //guardar info para o ficheiro de output
            tabela[a][b]= -1;
            
        }
        //precorrer tabela encontrar -2 e preencher por cahces;
        int cachesUsadas = 0;
   
        
        for (i=0; i<M; i++)
            for(j=0; j<N; j++)
                if tabela[i][j]== -2;{
                cachesUsadas++;
                j=N;
                        }
            
      int nVideos;
      StringBuilder sb = new StringBuilder();
      try {
        PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
        writer.println(cachesUsadas);
        
        for (i=0; i<M; i++){
            sb.append(i + " ");
            nvideos = 0;
            for(j=0; j<N; j++){
                if tabela[i][j]== -2;{
                    nvídeos++;
                    sb.append(tabela[i][j] + " ");
                }
                if(nvídeos !=0) 
                    writer.println(sb.toString());
                
        
        
        
        
    }
    writer.close();
} catch (IOException e)
}


    }
}

