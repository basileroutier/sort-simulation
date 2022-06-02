/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.List;
import model.dto.Dto;
import model.repository.exception.RepositoryException;

/**
 *
 * @author basile
 */
public interface Dao<K, T extends Dto<K>> {

    /**
     * Inserts an item into the Dao
     * 
     * @param item The item to be inserted.
     */
    public void insert(T item) throws RepositoryException;

    /**
     * Delete the value associated with the given key
     * 
     * @param key The key of the object to be deleted.
     */
    public void delete(K key) throws RepositoryException;

    /**
     * > Updates an item in the Dao
     * 
     * @param item The item to be updated.
     */
    public void update(T item) throws RepositoryException;

    /**
     * Get the value associated with the given key, or throw an exception if the key
     * is not found.
     * 
     * @param key The key of the object to retrieve.
     * @return The value of the key.
     */
    public T get(K key) throws RepositoryException;

    /**
     * Get all the objects of type T from the Dao.
     * 
     * @return A list of all the objects in the repository.
     */
    public List<T> getAll() throws RepositoryException;
}
