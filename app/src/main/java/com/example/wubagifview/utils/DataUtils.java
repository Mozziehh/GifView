package com.example.wubagifview.utils;

import com.example.wubagifview.model.ImageData;

import java.util.ArrayList;
import java.util.HashMap;

public class DataUtils {

    static HashMap<String, String> dataMap = new HashMap<>();

    private static HashMap<String, String> getData(){
        dataMap.put("image_1", "gif_1");
        dataMap.put("image_2", "gif_2");
        dataMap.put("image_3", "gif_3");
        dataMap.put("image_4", "gif_4");
        dataMap.put("image_5", "gif_5");
        dataMap.put("image_6", "gif_6");
        dataMap.put("image_7", "gif_7");
        dataMap.put("image_8", "gif_8");
        dataMap.put("image_9", "gif_9");
        dataMap.put("image_10", "gif_10");
        dataMap.put("image_11", "gif_11");
        dataMap.put("image_12", "gif_12");
        dataMap.put("image_13", "gif_13");
        dataMap.put("image_14", "gif_14");
        dataMap.put("image_15", "gif_15");
        return dataMap;
    }

    private static ArrayList<ImageData> imageDataList = new ArrayList<ImageData>();
    public static ArrayList<ImageData> getImageData(){
        imageDataList.clear();
        dataMap.clear();
        getData();
        for(String data : dataMap.keySet()){
            ImageData imageData = new ImageData();
            imageData.imageUrl = data;
            imageData.gifUrl = dataMap.get(data);
            imageDataList.add(imageData);
        }
        return imageDataList;
    }

    static HashMap<String, String> homeMap = new HashMap<>();


    private static HashMap<String, String> getFrescoData(){
        //为了保护用户隐私，我把这里面mock的数据删除了
        //按照这种方式自己mock数据即可，key是图片，value是gif
        homeMap.put("", "");
        return homeMap;

    }

    private static ArrayList<ImageData> frescoImageDataList = new ArrayList<ImageData>();

    public static ArrayList<ImageData> getFrescoImageData(){
        frescoImageDataList.clear();
        homeMap.clear();
        getFrescoData();
        for(String data : homeMap.keySet()){
            ImageData imageData = new ImageData();
            imageData.imageUrl = data;
            imageData.gifUrl = homeMap.get(data);
            frescoImageDataList.add(imageData);
        }
        return frescoImageDataList;
    }
}
