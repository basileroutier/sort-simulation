/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package model;

/**
 *
 * @author basile
 */
public enum SortingMethod {
    BUBBLE("Trie fusion"),
    MERGE("Trie à bulle");
    
    private String label;

   SortingMethod(String label) {
            this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
    public String toString(){
        return label;
    }
}
