/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import Daos.DisciplinaDao;
import beans.Disciplina;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author josimar
 */
public class DisciplinaIterator implements Iterator<Disciplina> {

    private List<Disciplina> disciplinas;
    private int quantidade = 0;
    private int ponteiro = 0;
    private Disciplina proxima;

    public DisciplinaIterator() {
        disciplinas = new DisciplinaDao().listar();
        quantidade = disciplinas.size();
    }

    @Override
    public boolean hasNext() {
        if (ponteiro < quantidade) {
            proxima = disciplinas.get(ponteiro);
            ponteiro++;
            return true;
        } else {
            proxima = null;
            return false;
        }
    }

    @Override
    public Disciplina next() {
        return proxima;
    }

    @Override
    public void remove() {
    }
}
