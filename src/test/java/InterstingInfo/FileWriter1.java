package InterstingInfo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileWriter1 {

    public static void main(String[] args) {

        Map<String, String> firstPageKeysValues = new LinkedHashMap<>();
        firstPageKeysValues.put("key111" , "apple");
        Map<String, String> secongPageKeysValues = new LinkedHashMap<>();
        secongPageKeysValues.put("key1211" , "orange");

        List<Map<String, String>> missingKeysAndValuesList = new LinkedList<>();
        missingKeysAndValuesList.add(firstPageKeysValues);
        missingKeysAndValuesList.add(secongPageKeysValues);

        missingKeyWriter(missingKeysAndValuesList);


    }

    public static void missingKeyWriter(List<Map<String, String>> itemList) {
        String fileName = "item_list.txt";

        try {
            // Create a FileWriter to write to the file

            FileWriter fileWriter = new FileWriter("filename.txt");

            // Create a BufferedWriter to improve write performance
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Write each item from the list to the file
            for (Map<String, String> stringStringMap : itemList) {
                bufferedWriter.write(stringStringMap.keySet().toString());
                bufferedWriter.write(stringStringMap.values().toString());
                bufferedWriter.newLine(); // Add a new line for each item
            }

            // Close the BufferedWriter and FileWriter to save changes
            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Items have been written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
