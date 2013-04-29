/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author josimar
 */
@Entity
public class Requisicao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String AlunoRa;
    @ManyToOne
    private Disciplina diciplinaRequerida;
     @Enumerated(EnumType.STRING)  
    private StatusSolicitacao status;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
     private Calendar dataInicio;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
     private Calendar dataFinal;
    private String observacao;
    @OneToMany(mappedBy = "requisicao")
    private List<ItemHistorico>historico;

    public Requisicao() {
        this.status = StatusSolicitacao.EM_ANDAMENTO;
    }

    public Requisicao(String AlunoRa, Disciplina diciplinaRequerida, StatusSolicitacao status) {
        this.AlunoRa = AlunoRa;
        this.diciplinaRequerida = diciplinaRequerida;
        this.status = status;
        this.status = StatusSolicitacao.EM_ANDAMENTO;
    }
     
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlunoRa() {
        return AlunoRa;
    }

    public void setAlunoRa(String AlunoRa) {
        this.AlunoRa = AlunoRa;
    }

    public Calendar getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Calendar dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Disciplina getDiciplinaRequerida() {
        return diciplinaRequerida;
    }

    public void setDiciplinaRequerida(Disciplina diciplinaRequerida) {
        this.diciplinaRequerida = diciplinaRequerida;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public StatusSolicitacao getStatus() {
        return status;
    }

    public void setStatus(StatusSolicitacao status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisicao)) {
            return false;
        }
        Requisicao other = (Requisicao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Requisicao[ id=" + id + " ]";
    }
    
}
