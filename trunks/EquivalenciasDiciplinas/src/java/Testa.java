
import Daos.DiciplinaDao;
import Daos.ProfessorDao;
import beans.Disciplina;
import beans.Professor;
import java.util.Calendar;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josimar
 */
public class Testa {
    public static void main(String[] args) {
                Professor p1 = new Professor("professor 20", "Teste@teste.teste");
                new ProfessorDao().persistir(p1);
                //p1.setDiciplinas(listar);
                Professor p2 = new Professor("professor 50", "Teste@teste.teste");
                new ProfessorDao().persistir(p2);
                Disciplina d = new Disciplina("testeeee", p2);
                Disciplina d2 = new Disciplina("testeeee222", p2);
               
                new ProfessorDao().persistir(p1);
                new DiciplinaDao().persistir(d);
                new DiciplinaDao().persistir(d2);
        List<Disciplina> listar = new DiciplinaDao().listar();
        
        System.out.println(listar);
    }
    
}












//                long ini = Calendar.getInstance().getTimeInMillis();
//                        teste t = new teste();
//                        teste t2 = new teste();
//                        teste t3 = new teste();
//                        teste t4 = new teste();
//              
//              t.run();
//              t2.run();
//              t3.run();
//              t4.run();
//                long fim = Calendar.getInstance().getTimeInMillis();
//                System.out.println((fim-ini)/1000);
