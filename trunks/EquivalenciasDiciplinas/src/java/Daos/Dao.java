/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import java.util.List;

/**
 *
 * @author marcossilvano
 */
public interface Dao<T> {

    void persistir(T entidade);
    void remover(T entidade);
    T obterPorId(int id);
    List<T> listar(String filtro);
    List<T> listar();
}
