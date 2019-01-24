package com.java.download_data.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.java.download_data.model.DataModel;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ServiceClass {
    private OkHttpClient client = new OkHttpClient();
    @Autowired
    private DataRepository dataRepository;


    public List<DataModel> getData(@NonNull String url) {
        List<DataModel> collect = null;
        Request getAll = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(getAll).execute();
            String line = new BufferedReader(response.body().charStream()).readLine();
           collect = parser(line);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
        return collect;
    }

    private List<DataModel> parser(String line) {
        HashMap<Object, JSONArray> hashMap = JSON.parseObject(line, HashMap.class);
        List<DataModel> collect = new ArrayList();
        hashMap.values().stream().map(e -> e.toJavaList(DataModel.class)).forEach(e -> collect.addAll(e));
        return collect;
    }


    public void save(@NonNull DataModel data) {
        dataRepository.save(data);
    }
}
