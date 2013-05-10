
import Daos.DisciplinaDao;
import Daos.ProfessorDao;
import beans.Disciplina;
import beans.Professor;
import controler.DisciplinaIterator;
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
//                Professor p1 = new Professor("professor 20", "Teste@teste.teste");
//                new ProfessorDao().persistir(p1);
//                //p1.setDiciplinas(listar);
//                Professor p2 = new Professor("professor 50", "Teste@teste.teste");
//                new ProfessorDao().persistir(p2);
//                Disciplina d = new Disciplina("testeeee", p2);
//                Disciplina d2 = new Disciplina("testeeee222", p2);
//               
//                new ProfessorDao().persistir(p1);
//                new DisciplinaDao().persistir(d);
//                new DisciplinaDao().persistir(d2);
//        List<Disciplina> listar = new DisciplinaDao().listar();
//        
//        System.out.println(listar);
        //new DisciplinaDao().getPorIDCurso("1");
        DisciplinaIterator d = new DisciplinaIterator();
        while(d.hasNext()){
            System.out.println(d.next().getNome());
        }
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
