/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author basile
 */
public class SeriesSort {
    
    private List<Integer[]> generatedNumber;
    private List<Integer> nombreOperations;
    private final PropertyChangeSupport pcs;
    
        
    public final static String PROPERTY_ACTION_SORTING_FINISH = "model.ThreadSort.sortingFinish";

    public SeriesSort() {
        generatedNumber = new ArrayList<>();
        nombreOperations = new ArrayList<>();
        this.pcs = new PropertyChangeSupport(this);
    }
    
    public void generateListInteger(int numberOperation){
        for (int i = 0; i <= numberOperation; i += 10) {
            generatedNumber.add(generateInt(i));
        }
    }
    
    public synchronized Integer[] getAvailableInteger(){
        if(generatedNumber.size()!=0){
            Integer[] array = generatedNumber.get(0);
            generatedNumber.remove(0);
            return array;
        }
        return null;
    }

    public List<Integer> getNombreOperations() {
        return nombreOperations;
    }

    public void addNombreOperation(Integer nombreOp) {
        nombreOperations.add(nombreOp);
    }
    
    public void resetNombreOperation(){
        nombreOperations.clear();
    }

    private Integer[] generateInt(int numberGeneration) {
        Integer[] generatedNumber = new Integer[numberGeneration];
        Random rand = new Random(); // instance of random class
        for (int i = 0; i < numberGeneration; i++) {
            generatedNumber[i] = rand.nextInt(numberGeneration + 1);
        }
        return generatedNumber;
    }
    
    /**
     * Add listener to the observator
     * @param listener PropertyChangeListener: the listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    /**
     * Remove listener to the observator
     * @param listener PropertyChangeListener: the listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    /**
     * Notify all the observator with a specific message and content
     * @param message String: message
     * @param objectSend Object: content to send
     */
    public void change(Object objectSend) {
        pcs.firePropertyChange(PROPERTY_ACTION_SORTING_FINISH, null, objectSend);
    }
}
