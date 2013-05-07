/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import beans.Aluno;
import org.hibernate.Query;

/**
 *
 * @author josimar
 */
public class AlunoDao extends DaoGenerics<Aluno> {

    public AlunoDao() {
        clazz = Aluno.class;
    }
    public Aluno getPorRA(String RA){
        Aluno aluno = null;
        if (!RA.equals("")) {
            session = getsession();
            Query select = session.createQuery(
                    "From aluno where ra = '" +RA+"'" );
            aluno = (Aluno) select.uniqueResult();
            session.flush();
        }
        return aluno;
    }
    public boolean alunoExiste(String ra){
        return getPorRA(ra)!=null;
    }
    
    
}
