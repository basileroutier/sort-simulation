/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.LevelSort;
import Model.Model;
import Model.SortingMethod;
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
        model.launchThread(numberThread, method, level);
    }
}
