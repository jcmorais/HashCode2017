package entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by carlosmorais on 23/02/2017.
 */
public class Parser {


    public void test() throws IOException {
        String fileName = "me_at_the_zoo.in";




        String path = this.getClass().getClassLoader().getResource(fileName).getPath();
        List<String> list = new ArrayList<>();

        String file = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);

        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            //br returns as stream and convert it into a List
            //br.lines().collect(Collectors.to);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //list.forEach(System.out::println);


        

        for (String s : list) {






        }








    }
}
