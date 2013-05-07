/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import beans.Disciplina;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author josimar
 */
public class DisciplinaDao extends DaoGenerics<Disciplina> {

    public DisciplinaDao() {
        clazz = Disciplina.class;
    }
    public void persisteList(List<Disciplina>diciplinas){
        for(Disciplina d: diciplinas){
            persistir(d);
        }
    }
    public List<Disciplina> getPorIDCurso(String id){
         List<Disciplina> lista = null;
        if (id != null) {
            session = getsession();
            Query query = session.createQuery(
                    "select d from Disciplina d where d.curso.id= " +id );
                 //   "From disciplina where curso.id = " +id );
            lista = query.list();
            session.flush();
        }
        return lista;
    }
    
}
