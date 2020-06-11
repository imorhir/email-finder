package edu.depaul.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import sun.security.util.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListWriterTest {


    @Test
    @DisplayName("Test List writer writes every element from the list into an output stream")
    public void testListWrite() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ListWriter list = new ListWriter(out);
        List myList = new ArrayList<String>(Arrays.asList("2", "3","4"));

        try {
            list.writeList(myList);
            BufferedReader bufferedReader = new BufferedReader(new StringReader(new String(out.toByteArray())));
            String line;
            int i = 0;
            while (( line = bufferedReader.readLine()) != null){
              assertEquals(line, myList.get(i));
              System.out.println(myList.get(i) +" "+  line);
              i++;


            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
