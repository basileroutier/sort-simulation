/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * SimulationDto is a Dto that holds a timestamp, a sortType, and a maxSize
 */
public class SimulationDto extends Dto<Integer> {

    String timestamp;
    String sortType;
    Integer maxSize;

    public SimulationDto(Integer key, String timestamp, String sortType, Integer maxSize) {
        super(key);
        this.timestamp = timestamp;
        this.sortType = sortType;
        this.maxSize = maxSize;
    }

    public SimulationDto(String sortType, Integer maxSize) {
        super(0);
        Date date = new Date();
        this.timestamp = new Timestamp(date.getTime()).toString();
        this.sortType = sortType;
        this.maxSize = maxSize;
    }

    /**
     * This function returns the timestamp of the current time
     * 
     * @return The timestamp.
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * This function returns the sort type
     * 
     * @return The sortType variable is being returned.
     */
    public String getSortType() {
        return sortType;
    }

    /**
     * This function returns the maximum size of the cache
     * 
     * @return The maxSize variable is being returned.
     */
    public Integer getMaxSize() {
        return maxSize;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.timestamp);
        hash = 37 * hash + Objects.hashCode(this.sortType);
        hash = 37 * hash + this.maxSize;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimulationDto other = (SimulationDto) obj;
        if (this.maxSize != other.maxSize) {
            return false;
        }
        if (!Objects.equals(this.timestamp, other.timestamp)) {
            return false;
        }
        if (!Objects.equals(this.sortType, other.sortType)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return timestamp + ':' + sortType + ':' + maxSize;
    }

}
