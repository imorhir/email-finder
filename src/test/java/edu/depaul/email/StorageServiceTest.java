package edu.depaul.email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StorageServiceTest {




    @Test
    @DisplayName("Testing AddLocation and StoreList from StorageService")
    void TestingStorageServise(){


        ArrayList<String>  colection = new ArrayList<>(Arrays.asList("@zak", "@sam,", "@omia"));
        StorageService storage = new StorageService();

        storage.addLocation(StorageService.StorageType.EMAIL, "myEmail.txt").storeList(StorageService.StorageType.EMAIL, colection);
        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader("myEmail.txt"));
            String line;
            int i = 0;
            while (( line = bufferedReader.readLine()) != null){
                assertEquals(line, colection.get(i));
                System.out.println(colection.get(i) +" "+  line);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}