/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenvuelosjsf.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adrián
 */
@Entity
@Table(name = "CITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c")
    , @NamedQuery(name = "City.findByCityName", query = "SELECT c FROM City c WHERE c.cityName = :cityName")
    , @NamedQuery(name = "City.findByCountry", query = "SELECT c FROM City c WHERE c.country = :country")
    , @NamedQuery(name = "City.findByAirport", query = "SELECT c FROM City c WHERE c.airport = :airport")
    , @NamedQuery(name = "City.findByLanguage", query = "SELECT c FROM City c WHERE c.language = :language")})
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 24)
    @Column(name = "CITY_NAME")
    private String cityName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 26)
    @Column(name = "COUNTRY")
    private String country;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "AIRPORT")
    private String airport;
    @Size(max = 16)
    @Column(name = "LANGUAGE")
    private String language;
    @JoinColumn(name = "COUNTRY_ISO_CODE", referencedColumnName = "COUNTRY_ISO_CODE")
    @ManyToOne
    private Country countryIsoCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "destAirport")
    private Collection<Flight> flightCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "origAirport")
    private Collection<Flight> flightCollection1;

    public City() {
    }

    public City(String airport) {
        this.airport = airport;
    }

    public City(String airport, String cityName, String country) {
        this.airport = airport;
        this.cityName = cityName;
        this.country = country;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Country getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(Country countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    @XmlTransient
    public Collection<Flight> getFlightCollection() {
        return flightCollection;
    }

    public void setFlightCollection(Collection<Flight> flightCollection) {
        this.flightCollection = flightCollection;
    }

    @XmlTransient
    public Collection<Flight> getFlightCollection1() {
        return flightCollection1;
    }

    public void setFlightCollection1(Collection<Flight> flightCollection1) {
        this.flightCollection1 = flightCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (airport != null ? airport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.airport == null && other.airport != null) || (this.airport != null && !this.airport.equals(other.airport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examenvuelosjsf.entity.City[ airport=" + airport + " ]";
    }
    
}
