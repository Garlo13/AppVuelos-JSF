/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenvuelosjsf.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "COUNTRY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")
    , @NamedQuery(name = "Country.findByCountry", query = "SELECT c FROM Country c WHERE c.country = :country")
    , @NamedQuery(name = "Country.findByCountryIsoCode", query = "SELECT c FROM Country c WHERE c.countryIsoCode = :countryIsoCode")
    , @NamedQuery(name = "Country.findByRegion", query = "SELECT c FROM Country c WHERE c.region = :region")})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 26)
    @Column(name = "COUNTRY")
    private String country;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "COUNTRY_ISO_CODE")
    private String countryIsoCode;
    @Size(max = 26)
    @Column(name = "REGION")
    private String region;
    @OneToMany(mappedBy = "countryIsoCode")
    private Collection<City> cityCollection;

    public Country() {
    }

    public Country(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public Country(String countryIsoCode, String country) {
        this.countryIsoCode = countryIsoCode;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryIsoCode() {
        return countryIsoCode;
    }

    public void setCountryIsoCode(String countryIsoCode) {
        this.countryIsoCode = countryIsoCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @XmlTransient
    public Collection<City> getCityCollection() {
        return cityCollection;
    }

    public void setCityCollection(Collection<City> cityCollection) {
        this.cityCollection = cityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryIsoCode != null ? countryIsoCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.countryIsoCode == null && other.countryIsoCode != null) || (this.countryIsoCode != null && !this.countryIsoCode.equals(other.countryIsoCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "examenvuelosjsf.entity.Country[ countryIsoCode=" + countryIsoCode + " ]";
    }
    
}
