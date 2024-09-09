package br.edu.ifnmg.poo.crud.repository;

import br.edu.ifnmg.poo.crud.entity.Entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author ana
 * @param <E>
 */
public interface IDao<E extends Entity> {

    public String getSaveStatement();

    public String getUpdateStatement();

    public String getFindByIdStatement();

    public String getFindAllStatement();

    public String getDeleteStatement();

    public void composeSaveOrUpdateStatement(PreparedStatement pstmt, E e);

    public E extractObject(ResultSet rs);

    public List<E> extractObjects(ResultSet rs);

    public Long saveOrUpdate(E e);

    public E findById(Long id);

    public List<E> findAll();

    public void delete(Long id);

}
