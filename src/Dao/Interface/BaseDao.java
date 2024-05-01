package Dao.Interface;

import java.util.List;

public interface BaseDao {

    List<?> getAll(Class c);
    Object findByInput(String input,Class c);
    Object findById(Integer id, Class c);
}
