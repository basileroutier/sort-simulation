/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import model.dto.SimulationDto;
import model.repository.SimulationRepository;
import model.repository.exception.RepositoryException;
import view.MainViewController;

/**
 *
 * @author basile
 */
public class Model {
    SeriesSort ss;
    
    private SimulationRepository simulationRepository;

    public Model(MainViewController view) {
        ss = new SeriesSort();
        ss.addPropertyChangeListener(view);
        simulationRepository = SimulationRepository.getInstance();
    }
    
    public void launchThread(int nombreThread, SortingMethod method,LevelSort level) throws RepositoryException{
        simulationRepository.add(new SimulationDto(method.getLabel(), level.getNombre()));
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
