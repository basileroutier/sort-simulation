/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 * Class used for TableView of the log
 */
public class ColumnLogParsingTable {
    private String timeStamp;
    private String sortType;
    private Integer maxSize;

    public ColumnLogParsingTable(String timeStamp, String sortType, Integer maxSize) {
        this.timeStamp = timeStamp;
        this.sortType = sortType;
        this.maxSize = maxSize;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getSortType() {
        return sortType;
    }

    public Integer getMaxSize() {
        return maxSize;
    }

}
