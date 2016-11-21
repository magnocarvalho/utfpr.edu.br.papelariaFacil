/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.edu.br.papelariafacil.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author magno
 */
@MappedSuperclass
@Table(catalog = "dbloja", schema = "public")
@XmlRootElement
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idvenda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 10, scale = 2)
    private BigDecimal valor;
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacaovenda;
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizacaovenda;
    @JoinColumn(name = "funcionariovenda", referencedColumnName = "idfuncionario")
    @ManyToOne
    private Funcionario funcionariovenda;
    @OneToMany(mappedBy = "vendaitemvenda")
    private Set<Itemvenda> itemvendaSet;
    @OneToMany(mappedBy = "vendarecebimento")
    private Set<Recebimento> recebimentoSet;

    public Venda() {
    }

    public Venda(Integer idvenda) {
        this.idvenda = idvenda;
    }

    public Integer getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Integer idvenda) {
        this.idvenda = idvenda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getCriacaovenda() {
        return criacaovenda;
    }

    public void setCriacaovenda(Date criacaovenda) {
        this.criacaovenda = criacaovenda;
    }

    public Date getAtualizacaovenda() {
        return atualizacaovenda;
    }

    public void setAtualizacaovenda(Date atualizacaovenda) {
        this.atualizacaovenda = atualizacaovenda;
    }

    public Funcionario getFuncionariovenda() {
        return funcionariovenda;
    }

    public void setFuncionariovenda(Funcionario funcionariovenda) {
        this.funcionariovenda = funcionariovenda;
    }

    @XmlTransient
    public Set<Itemvenda> getItemvendaSet() {
        return itemvendaSet;
    }

    public void setItemvendaSet(Set<Itemvenda> itemvendaSet) {
        this.itemvendaSet = itemvendaSet;
    }

    @XmlTransient
    public Set<Recebimento> getRecebimentoSet() {
        return recebimentoSet;
    }

    public void setRecebimentoSet(Set<Recebimento> recebimentoSet) {
        this.recebimentoSet = recebimentoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvenda != null ? idvenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idvenda == null && other.idvenda != null) || (this.idvenda != null && !this.idvenda.equals(other.idvenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utfpr.edu.br.papelariafacil.vo.Venda[ idvenda=" + idvenda + " ]";
    }
    
}
