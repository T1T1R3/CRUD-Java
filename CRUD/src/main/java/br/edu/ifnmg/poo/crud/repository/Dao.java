package br.edu.ifnmg.poo.crud.repository;

import br.edu.ifnmg.poo.crud.entity.Entity;

/**
 *
 * @author ana
 * @param <E>
 */
public abstract class Dao<E extends Entity> 
        implements IDao<E> {
    
    public static final String DB = "usuarios";


}
