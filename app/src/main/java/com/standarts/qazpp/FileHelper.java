package com.standarts.qazpp;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileHelper {
    private static String FilePath(String filename){
        return StoragePath() + filename + ".json";
    }

    public static String StoragePath(){
        return "data/data/" + BuildConfig.APPLICATION_ID + "/";
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

    public static ArrayList<File> GetStorageFilesOfType(String filetype){
        File filesFolder = new File(FileHelper.StoragePath());

        File[] files = filesFolder.listFiles();
        Log.d("FILES", files.length + " files");

        ArrayList<File> filesOfType = new ArrayList<>();
        for(File file : files){
            if(file.getName().contains("." + filetype)){
                filesOfType.add(file);
            }
        }

        return filesOfType;
    }

    public static void ClearQuizFolder(){
        for(File file : GetStorageFilesOfType("json")){
            file.delete();
        }
    }

    public static String FileNameOnly(File file){
        if(!file.getName().contains(".")){
            Log.d("FILES", "File does not have extension, no operation will be done");
            return file.getName();
        }
        return file.getName().split("\\.")[0];
    }

    public static String CreateSafeFilename(String raw) {
        return raw.trim().toLowerCase().replace(" ", "_");
    }

    public static boolean RemoveFile(String filename) {
        File file = new File(FilePath(filename));
        Log.d("FILES", "removing " + file.getName());
        if(file.exists()){
            return file.delete();
        }
        return false;
    }
}
