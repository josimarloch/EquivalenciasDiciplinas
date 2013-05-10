/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import beans.Professor;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author josimar
 */
public class ProfessorDao extends DaoGenerics<Professor> {

    public ProfessorDao() {
        clazz = Professor.class;
    }
    
    public Professor getPorEmail(String email){
         Professor professor = null;
        if (!email.equals("")) {
            session = getsession();
            Query select = session.createQuery(
                    "From " + clazz.getSimpleName() + " where email = '" +email+"'" );
            professor = (Professor) select.uniqueResult();
            session.flush();
        }
        return professor;
        
    }
    
    
}
