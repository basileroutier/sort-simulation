/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.repository;

import java.util.List;
import model.dto.Dto;
import model.repository.exception.RepositoryException;

/**
 * Repository interface
 */
public interface Repository<K, T extends Dto<K>> {

    /**
     * This function adds an item to the repository.
     * Check if it is update or add by using contains method
     * 
     * @param item The item to add to the repository.
     */
    public void add(T item) throws RepositoryException;

    /**
     * Removes the value associated with the given key from the repository
     * 
     * @param key The key of the entry to remove.
     */
    public void remove(K key) throws RepositoryException;

    /**
     * Retrieves the value associated with the given key
     * 
     * @param key The key of the object to retrieve.
     * @return The value of the key.
     */
    public T get(K key) throws RepositoryException;

    /**
     * Get all the objects of type T from the repository.
     * 
     * @return A list of all the objects in the repository.
     */
    public List<T> getAll() throws RepositoryException;

    /**
     * Returns true if the repository contains the specified key
     * 
     * @param key The key to search for.
     * @return A boolean value.
     */
    public boolean contains(K key) throws RepositoryException;
}
