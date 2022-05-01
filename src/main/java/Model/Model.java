/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import view.MainViewController;

/**
 *
 * @author basile
 */
public class Model {
    SeriesSort ss;

    public Model(MainViewController view) {
        ss = new SeriesSort();
        ss.addPropertyChangeListener(view);
    }
    
    public void launchThread(int nombreThread, SortingMethod method,LevelSort level){
        ss.generateListInteger(level.getNombre());
        for(int i=0;i<nombreThread;i++){
            ThreadSort thread = new ThreadSort(ss, method);
            thread.start();
        }
    }
    
    public int getNumberThreadCurrent(){
        return Thread.activeCount();
    }
    
}
