/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.repository;

import java.util.List;
import model.dao.SimulationDao;
import model.dto.Dto;
import model.dto.SimulationDto;
import model.repository.exception.RepositoryException;

/**
 *
 * @author basile
 */
public class SimulationRepository implements Repository<Integer, SimulationDto>{
    
    private SimulationDao simulationDao;

    private SimulationRepository() {
        simulationDao = new SimulationDao();
    }
    
    
    
    @Override
    public void add(SimulationDto item) throws RepositoryException {
        if(contains(item.getKey())){
            simulationDao.update(item);
        }else{
            simulationDao.insert(item);
        }
    }

    @Override
    public void remove(Integer key) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SimulationDto get(Integer key) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SimulationDto> getAll() throws RepositoryException {
        return simulationDao.getAll();
    }

    @Override
    public boolean contains(Integer key) throws RepositoryException {
        return simulationDao.get(key)!=null;
    }
    
    public static SimulationRepository getInstance() {
        return SimulationRepositoryHolder.INSTANCE;
    }
    
    private static class SimulationRepositoryHolder {

        private static final SimulationRepository INSTANCE = new SimulationRepository();
    }
}
