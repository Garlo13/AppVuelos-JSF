/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenvuelosjsf.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrián
 */
@Entity
@Table(name = "AIRLINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Airline.findAll", query = "SELECT a FROM Airline a")
    , @NamedQuery(name = "Airline.findByAirline", query = "SELECT a FROM Airline a WHERE a.airline = :airline")
    , @NamedQuery(name = "Airline.findByAirlineFull", query = "SELECT a FROM Airline a WHERE a.airlineFull = :airlineFull")
    , @NamedQuery(name = "Airline.findByBasicRate", query = "SELECT a FROM Airline a WHERE a.basicRate = :basicRate")
    , @NamedQuery(name = "Airline.findByDistanceDiscount", query = "SELECT a FROM Airline a WHERE a.distanceDiscount = :distanceDiscount")
    , @NamedQuery(name = "Airline.findByBusinessLevelFactor", query = "SELECT a FROM Airline a WHERE a.businessLevelFactor = :businessLevelFactor")
    , @NamedQuery(name = "Airline.findByFirstclassLevelFactor", query = "SELECT a FROM Airline a WHERE a.firstclassLevelFactor = :firstclassLevelFactor")
    , @NamedQuery(name = "Airline.findByEconomySeats", query = "SELECT a FROM Airline a WHERE a.economySeats = :economySeats")
    , @NamedQuery(name = "Airline.findByBusinessSeats", query = "SELECT a FROM Airline a WHERE a.businessSeats = :businessSeats")
    , @NamedQuery(name = "Airline.findByFirstclassSeats", query = "SELECT a FROM Airline a WHERE a.firstclassSeats = :firstclassSeats")})
public class Airline implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "AIRLINE")
    private String airline;
    @Size(max = 24)
    @Column(name = "AIRLINE_FULL")
    private String airlineFull;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BASIC_RATE")
    private Double basicRate;
    @Column(name = "DISTANCE_DISCOUNT")
    private Double distanceDiscount;
    @Column(name = "BUSINESS_LEVEL_FACTOR")
    private Double businessLevelFactor;
    @Column(name = "FIRSTCLASS_LEVEL_FACTOR")
    private Double firstclassLevelFactor;
    @Column(name = "ECONOMY_SEATS")
    private Integer economySeats;
    @Column(name = "BUSINESS_SEATS")
    private Integer businessSeats;
    @Column(name = "FIRSTCLASS_SEATS")
    private Integer firstclassSeats;

    public Airline() {
    }

    public Airline(String airline) {
        this.airline = airline;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAirlineFull() {
        return airlineFull;
    }

    public void setAirlineFull(String airlineFull) {
        this.airlineFull = airlineFull;
    }

    public Double getBasicRate() {
        return basicRate;
    }

    public void setBasicRate(Double basicRate) {
        this.basicRate = basicRate;
    }

    public Double getDistanceDiscount() {
        return distanceDiscount;
    }

    public void setDistanceDiscount(Double distanceDiscount) {
        this.distanceDiscount = distanceDiscount;
    }

    public Double getBusinessLevelFactor() {
        return businessLevelFactor;
    }

    public void setBusinessLevelFactor(Double businessLevelFactor) {
        this.businessLevelFactor = businessLevelFactor;
    }

    public Double getFirstclassLevelFactor() {
        return firstclassLevelFactor;
    }

    public void setFirstclassLevelFactor(Double firstclassLevelFactor) {
        this.firstclassLevelFactor = firstclassLevelFactor;
    }

    public Integer getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(Integer economySeats) {
        this.economySeats = economySeats;
    }

    public Integer getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(Integer businessSeats) {
        this.businessSeats = businessSeats;
    }

    public Integer getFirstclassSeats() {
        return firstclassSeats;
    }

    public void setFirstclassSeats(Integer firstclassSeats) {
        this.firstclassSeats = firstclassSeats;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (airline != null ? airline.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Airline)) {
            return false;
        }
        Airline other = (Airline) object;
        if ((this.airline == null && other.airline != null) || (this.airline != null && !this.airline.equals(other.airline))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examenvuelosjsf.entity.Airline[ airline=" + airline + " ]";
    }
    
}
