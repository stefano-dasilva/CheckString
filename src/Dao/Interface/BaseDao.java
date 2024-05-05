package Dao.Interface;

import Model.Bean;

import java.util.List;

public interface BaseDao {

    List<?> getAll(Class c);
    Object findByInput(String input,Class c);
    Object findById(Integer id, Class c);

    Object create(Bean b);
    Object update(Bean b);
}
