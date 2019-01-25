package com.java.download_data.model;

import lombok.Data;

import java.util.List;
/**
 * Class for ListUrl bean
 *
 * @author Khmelyar Volodymyr
 */
@Data
public class ListUrl {
    private List<String> urls;

    public ListUrl() {
    }
}
