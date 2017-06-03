/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenvuelosjsf.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrián
 */
@Entity
@Table(name = "FLIGHT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f")
    , @NamedQuery(name = "Flight.findByFlightId", query = "SELECT f FROM Flight f WHERE f.flightPK.flightId = :flightId")
    , @NamedQuery(name = "Flight.findBySegmentNumber", query = "SELECT f FROM Flight f WHERE f.flightPK.segmentNumber = :segmentNumber")
    , @NamedQuery(name = "Flight.findByDepartTime", query = "SELECT f FROM Flight f WHERE f.departTime = :departTime")
    , @NamedQuery(name = "Flight.findByArriveTime", query = "SELECT f FROM Flight f WHERE f.arriveTime = :arriveTime")
    , @NamedQuery(name = "Flight.findByMeal", query = "SELECT f FROM Flight f WHERE f.meal = :meal")
    , @NamedQuery(name = "Flight.findByFlyingTime", query = "SELECT f FROM Flight f WHERE f.flyingTime = :flyingTime")
    , @NamedQuery(name = "Flight.findByMiles", query = "SELECT f FROM Flight f WHERE f.miles = :miles")
    , @NamedQuery(name = "Flight.findByAircraft", query = "SELECT f FROM Flight f WHERE f.aircraft = :aircraft")})
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FlightPK flightPK;
    @Column(name = "DEPART_TIME")
    @Temporal(TemporalType.TIME)
    private Date departTime;
    @Column(name = "ARRIVE_TIME")
    @Temporal(TemporalType.TIME)
    private Date arriveTime;
    @Column(name = "MEAL")
    private Character meal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FLYING_TIME")
    private Double flyingTime;
    @Column(name = "MILES")
    private Integer miles;
    @Size(max = 6)
    @Column(name = "AIRCRAFT")
    private String aircraft;
    @JoinColumn(name = "DEST_AIRPORT", referencedColumnName = "AIRPORT")
    @ManyToOne(optional = false)
    private City destAirport;
    @JoinColumn(name = "ORIG_AIRPORT", referencedColumnName = "AIRPORT")
    @ManyToOne(optional = false)
    private City origAirport;

    public Flight() {
    }

    public Flight(FlightPK flightPK) {
        this.flightPK = flightPK;
    }

    public Flight(String flightId, int segmentNumber) {
        this.flightPK = new FlightPK(flightId, segmentNumber);
    }

    public FlightPK getFlightPK() {
        return flightPK;
    }

    public void setFlightPK(FlightPK flightPK) {
        this.flightPK = flightPK;
    }

    public Date getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Character getMeal() {
        return meal;
    }

    public void setMeal(Character meal) {
        this.meal = meal;
    }

    public Double getFlyingTime() {
        return flyingTime;
    }

    public void setFlyingTime(Double flyingTime) {
        this.flyingTime = flyingTime;
    }

    public Integer getMiles() {
        return miles;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public City getDestAirport() {
        return destAirport;
    }

    public void setDestAirport(City destAirport) {
        this.destAirport = destAirport;
    }

    public City getOrigAirport() {
        return origAirport;
    }

    public void setOrigAirport(City origAirport) {
        this.origAirport = origAirport;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightPK != null ? flightPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.flightPK == null && other.flightPK != null) || (this.flightPK != null && !this.flightPK.equals(other.flightPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examenvuelosjsf.entity.Flight[ flightPK=" + flightPK + " ]";
    }
    
}
