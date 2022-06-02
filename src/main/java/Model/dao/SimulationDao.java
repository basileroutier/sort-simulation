/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dto.SimulationDto;
import model.jdbc.DBManager;
import model.repository.exception.RepositoryException;

/**
 *
 * This class is used to insert, delete, update and get a simulation from the
 * database
 */
public class SimulationDao implements Dao<Integer, SimulationDto> {

    @Override
    public void insert(SimulationDto item) throws RepositoryException {
        if (item == null) {
            throw new RepositoryException("Aucune élément donné en paramètre");
        }

        try {
            Connection connexion = DBManager.getInstance().getConnection();// DriverManager.getConnection("jdbc:sqlite:"
                                                                           // + url);

            String query = "INSERT INTO SIMULATION(timestamp, sort_type, max_size) VALUES (?,?,?)";
            PreparedStatement stmt = connexion.prepareStatement(query);
            stmt.setString(1, item.getTimestamp());
            stmt.setString(2, item.getSortType());
            stmt.setInt(3, item.getMaxSize());

            int count = stmt.executeUpdate();
            if (count <= 0) {
                System.out.println("Une erreur est arrivé lors de l'ajout d'une simulation");
            }
            // connexion.close();
        } catch (SQLException ex) {
            System.out
                    .println("INSERT_PREPARE_SIMULATION | Erreur " + ex.getMessage() + " SQLState " + ex.getSQLState());
        }
    }

    @Override
    public void delete(Integer key) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public void update(SimulationDto item) throws RepositoryException {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public SimulationDto get(Integer key) throws RepositoryException {
        SimulationDto simulation = null;
        try {
            Connection connexion = DBManager.getInstance().getConnection();// DriverManager.getConnection("jdbc:sqlite:"
                                                                           // + url);

            String query = "select * from SIMULATION where id=?";
            PreparedStatement stmt = connexion.prepareStatement(query);

            stmt.setInt(1, key);

            ResultSet result = stmt.executeQuery();

            if (result.next()) {
                Integer id = result.getInt(1);
                String timestamp = result.getString(2);
                String sortType = result.getString(3);
                Integer maxSize = result.getInt(4);
                simulation = new SimulationDto(id, timestamp, sortType, maxSize);
            }
            // connexion.close();
        } catch (SQLException ex) {
            System.out.println("GET_PREPARE_FAVORITES | Erreur " + ex.getMessage() + " SQLState " + ex.getSQLState());
        }
        return simulation;
    }

    @Override
    public List<SimulationDto> getAll() throws RepositoryException {
        List<SimulationDto> listSimulation = new ArrayList<>();
        try {
            Connection connexion = DBManager.getInstance().getConnection();// DriverManager.getConnection("jdbc:sqlite:"
                                                                           // + url);

            String query = "select * from SIMULATION";
            PreparedStatement stmt = connexion.prepareStatement(query);

            ResultSet result = stmt.executeQuery();

            while (result.next()) {
                Integer id = result.getInt(1);
                String timestamp = result.getString(2);
                String sortType = result.getString(3);
                Integer maxSize = result.getInt(4);
                SimulationDto simuDto = new SimulationDto(id, timestamp, sortType, maxSize);

                listSimulation.add(simuDto);
            }
            // connexion.close();
        } catch (SQLException ex) {
            System.out
                    .println("GETALL_PREPARE_SIMULATION | Erreur " + ex.getMessage() + " SQLState " + ex.getSQLState());
        }
        return listSimulation;
    }

}
