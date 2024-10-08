package br.edu.ifnmg.poo.crud.repository;

import br.edu.ifnmg.poo.crud.entity.Entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class Dao
 *
 * @author AnaLuizanc
 * @author T1T1R3
 * @param <E>
 */
public abstract class Dao<E extends Entity>
        implements IDao<E> {

    public static final String DB = "alphasystem";

    @Override
    public Long saveOrUpdate(E e) {
        Long id = 0L;
        if (e.getId() == null || e.getId() <= 0) {
            try (PreparedStatement preparedStatement
                    = DbConnection.getConnection().prepareStatement(
                            getSaveStatement(), Statement.RETURN_GENERATED_KEYS)) {
                composeSaveOrUpdateStatement(preparedStatement, e);
                preparedStatement.executeUpdate();

                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    id = resultSet.getLong(1);
                }

            } catch (Exception exception) {
                System.out.println("Exception: " + exception);
            }
        } else {
            try (PreparedStatement preparedStatement
                    = DbConnection.getConnection().prepareStatement(getUpdateStatement())) {
                composeSaveOrUpdateStatement(preparedStatement, e);
                preparedStatement.executeUpdate();

                id = ((Entity) e).getId();

            } catch (Exception exception) {
                System.out.println("Exception: " + exception);
            }
        }
        return id;
    }

    @Override
    public E findById(Long id) {
        try (PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(getFindByIdStatement())) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return extractObject(resultSet);
            }
        } catch (Exception exception) {
            System.out.println("Exception: " + exception);
        }
        return null;
    }

    @Override
    public List<E> extractObjects(ResultSet rs) {
        List<E> objects = new ArrayList<>();

        try {
            while (rs.next()) {
                objects.add(extractObject(rs));
            }
        } catch (SQLException exception) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, exception);
        }

        return objects.isEmpty() ? null : objects;
    }

    @Override
    public List<E> findAll() {
        try (PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(getFindAllStatement())) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return extractObjects(resultSet);
        } catch (Exception exception) {
            System.out.println("Exception: " + exception);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement preparedStatement
                = DbConnection.getConnection().prepareStatement(getDeleteStatement())) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();

        } catch (Exception exception) {
            System.out.println("Exception: " + exception);

        }
    }

}
