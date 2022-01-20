/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "machine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machine.findAll", query = "SELECT m FROM Machine m"),
    @NamedQuery(name = "Machine.findById", query = "SELECT m FROM Machine m WHERE m.id = :id"),
    @NamedQuery(name = "Machine.findByDateAchat", query = "SELECT m FROM Machine m WHERE m.dateAchat = :dateAchat"),
    @NamedQuery(name = "Machine.findByMarque", query = "SELECT m FROM Machine m WHERE m.marque = :marque"),
    @NamedQuery(name = "Machine.findByPrix", query = "SELECT m FROM Machine m WHERE m.prix = :prix"),
    @NamedQuery(name = "Machine.findByReference", query = "SELECT m FROM Machine m WHERE m.reference = :reference")})
public class Machine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dateAchat")
    @Temporal(TemporalType.DATE)
    private Date dateAchat;
    @Size(max = 255)
    @Column(name = "marque")
    private String marque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix")
    private double prix;
    @Size(max = 255)
    @Column(name = "reference")
    private String reference;
    @JoinColumn(name = "salle_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Salle salleId;

    public Machine() {
    }

    public Machine(Integer id) {
        this.id = id;
    }

    public Machine(Integer id, double prix) {
        this.id = id;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Salle getSalleId() {
        return salleId;
    }

    public void setSalleId(Salle salleId) {
        this.salleId = salleId;
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
        if (!(object instanceof Machine)) {
            return false;
        }
        Machine other = (Machine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Machine[ id=" + id + " ]";
    }
    
}
