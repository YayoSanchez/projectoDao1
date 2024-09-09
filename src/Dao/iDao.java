package Dao;

import java.util.List;

public interface iDao<T> {
    T guardar(T t);
    T buscarPorId(Integer id);
    void actualizar(T t);
    void eliminar(Integer id);
    List<T> buscarTodos();
}

