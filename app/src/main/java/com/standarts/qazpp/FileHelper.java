package com.standarts.qazpp;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHelper {
    private static String FilePath(String filename){
        return "data/data/" + BuildConfig.APPLICATION_ID + "/" + filename + ".json";
    }

    public static String ReadFromFile(String filename){
        try {
            File file = new File(FilePath(filename));
            if(!file.exists()){
                return "";
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            return reader.readLine();
        } catch(Exception e) {
            return "";
        }
    }
    public static boolean WriteToFile(String filename, String text){
        try {
            File file = new File(FilePath(filename));
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            writer.flush();
            writer.close();
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
