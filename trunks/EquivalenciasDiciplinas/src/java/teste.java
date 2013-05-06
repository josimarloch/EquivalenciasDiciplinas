
import Daos.DisciplinaDao;
import beans.Disciplina;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author josimar
 */
public class teste implements Runnable {

    String nome;

    @Override
    public void run() {
        for (int i = 0; i < 25000; i++) {
            new DisciplinaDao().persistir(new Disciplina("xxx"));
            System.out.println("terminou");

        }
    }
}
