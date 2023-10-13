package InterstingInfo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileWriterTest {

    public static void main(String[] args) {

        String[] keys1 = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape", "honeydew", "kiwi", "lemon", "mango", "nectarine",
                "orange", "pear", "quince", "raspberry", "strawberry", "tangerine", "ugli fruit", "watermelon", "blueberry", "blackberry",
                "cranberry", "grapefruit", "guava", "lime", "papaya", "pineapple", "pomegranate" , "apple"};
        String[] values1 = {"red", "yellow", "red", "brown", "purple", "green", "purple", "green", "brown", "yellow", "orange",
                "orange", "orange", "green", "yellow", "red", "red", "orange", "green", "green", "green", "blue", "black", "red",
                "red", "green", "green", "green", "yellow", "red"};



        List<Map<String, String>> missingKeysAndValuesList = new LinkedList<>();

        for (int i = 0; i < values1.length; i++) {
            Map<String, String> keysValues = new LinkedHashMap<>();
            keysValues.put(keys1[i] , values1 [i]);
            missingKeysAndValuesList.add(keysValues);

        }


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
                String key= stringStringMap.keySet().toString();
                String value = stringStringMap.values().toString();
                bufferedWriter.write(key.substring(1 ,key.length()-1) + " = " + value.substring(1 ,value.length()-1));
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
