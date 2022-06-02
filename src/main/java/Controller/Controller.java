/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.LevelSort;
import model.Model;
import model.SortingMethod;
import model.repository.exception.RepositoryException;
import view.MainViewController;

/**
 *
 * @author basile
 */
public class Controller {
    MainViewController mainControllerView;
    Model model;

    public Controller(MainViewController mainControllerView, Model model) {
        this.mainControllerView = mainControllerView;
        this.model = model;
    }
    
    public void play(int numberThread, SortingMethod method, LevelSort level){
        try {
            model.launchThread(numberThread, method, level);
        } catch (RepositoryException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
