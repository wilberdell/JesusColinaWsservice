/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author AzureUser
 */
public class Anonymize {
public static String anonymize(String post) throws FileNotFoundException, IOException{
        BufferedReader csvReader = null;
        StringBuilder postanonymized = new StringBuilder();
        StringBuilder output = new StringBuilder();
        output.append("<h1>Anonimized Blog Post: </h1><br/>");
        String row = "", tempString = "";
        String [] tempPost = post.split(" ");
        boolean hasComma = false;
        
        for(int i = 0; i < tempPost.length; i++){
            tempString = tempPost[i];
            //"src/test/resources/fileTest.txt"
            //csvReader = new BufferedReader(new FileReader("Source Packages/com.service/names.csv"));
           csvReader = new BufferedReader(new FileReader("C:\\Users\\AzureUser\\Desktop\\DB\\names.csv"));
            while ((row = csvReader.readLine()) != null) {
                if(tempString.contains(",")) hasComma = true;
                tempString = tempString.replaceAll("[,.]", "");
                if(tempString.equals(row)){
                    tempString = "****";
                    if(hasComma){
                        tempString = tempString.concat(",");
                        hasComma = false;
                    }
                    break;
                } else{
                    tempString = tempString;
                }
            }
            postanonymized.append(tempString + " ");
        }
        output.append(postanonymized);
        System.out.println("<h2>"+postanonymized.toString()+"</h2>");
        csvReader.close();
        return output.toString();
    }
}
