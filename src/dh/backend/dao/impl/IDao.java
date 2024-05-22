package dh.backend.dao.impl;

import java.util.List;

public interface IDao<T>{
    T registrar(T t);
    T buscarPorId(Integer id);
    List<T> buscarTodos();
}
