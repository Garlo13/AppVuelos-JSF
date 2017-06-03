/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenvuelosjsf.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Adrián
 */
@Embeddable
public class FlightPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "FLIGHT_ID")
    private String flightId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEGMENT_NUMBER")
    private int segmentNumber;

    public FlightPK() {
    }

    public FlightPK(String flightId, int segmentNumber) {
        this.flightId = flightId;
        this.segmentNumber = segmentNumber;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public int getSegmentNumber() {
        return segmentNumber;
    }

    public void setSegmentNumber(int segmentNumber) {
        this.segmentNumber = segmentNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightId != null ? flightId.hashCode() : 0);
        hash += (int) segmentNumber;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FlightPK)) {
            return false;
        }
        FlightPK other = (FlightPK) object;
        if ((this.flightId == null && other.flightId != null) || (this.flightId != null && !this.flightId.equals(other.flightId))) {
            return false;
        }
        if (this.segmentNumber != other.segmentNumber) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examenvuelosjsf.entity.FlightPK[ flightId=" + flightId + ", segmentNumber=" + segmentNumber + " ]";
    }
    
}
