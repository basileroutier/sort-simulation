/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author basile
 */
public enum LevelSort {
    VERY_EASY("Very easy : 100", 100),
    EASY("Easy : 1 000", 1_000),
    MEDIUM("Medium : 10 000", 10_000),
    HARD("Hard : 100 000", 100_000),
    VERY_HARD("Very hard : 1 000 000", 1_000_000);
    
    private String label;
    private int nombre;

   LevelSort(String label, int nombre) {
            this.label = label;
            this.nombre = nombre;
    }

    public String getLabel() {
        return label;
    }
    
    public int getNombre(){
        return nombre;
    }
    
    public String toString(){
        return label;
    }
}
