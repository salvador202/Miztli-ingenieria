/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author salador
 */
@Entity
@Table(name = "tiene_contrato_u")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TieneContratoU.findAll", query = "SELECT t FROM TieneContratoU t"),
    @NamedQuery(name = "TieneContratoU.findByContrato", query = "SELECT t FROM TieneContratoU t WHERE t.contrato = :contrato")})
public class TieneContratoU1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "contrato")
    private Integer contrato;
    @JoinColumn(name = "estudiante", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Estudiante1 estudiante;
    @JoinColumn(name = "prestador", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Prestador1 prestador;

    public TieneContratoU1() {
    }

    public TieneContratoU1(Integer contrato) {
        this.contrato = contrato;
    }

    public Integer getContrato() {
        return contrato;
    }

    public void setContrato(Integer contrato) {
        this.contrato = contrato;
    }

    public Estudiante1 getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante1 estudiante) {
        this.estudiante = estudiante;
    }

    public Prestador1 getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador1 prestador) {
        this.prestador = prestador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contrato != null ? contrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TieneContratoU1)) {
            return false;
        }
        TieneContratoU1 other = (TieneContratoU1) object;
        if ((this.contrato == null && other.contrato != null) || (this.contrato != null && !this.contrato.equals(other.contrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.TieneContratoU[ contrato=" + contrato + " ]";
    }
    
}
