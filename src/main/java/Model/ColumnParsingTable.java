/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author basile
 */
public class ColumnParsingTable {
    private SortingMethod method;
    private int size;
    private int operation;
    private double duration;

    public ColumnParsingTable(SortingMethod method, int size, int operation, double duration) {
        this.method = method;
        this.size = size;
        this.operation = operation;
        this.duration = duration;
    }

    public SortingMethod getMethod() {
        return method;
    }

    public int getSize() {
        return size;
    }

    public int getOperation() {
        return operation;
    }

    public double getDuration() {
        return duration;
    }

}
