/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import beans.Disciplina;
import java.util.List;

/**
 *
 * @author josimar
 */
public class DiciplinaDao extends DaoGenerics<Disciplina> {

    public DiciplinaDao() {
        clazz = Disciplina.class;
    }
    public void persisteList(List<Disciplina>diciplinas){
        for(Disciplina d: diciplinas){
            persistir(d);
        }
    }
    
}
