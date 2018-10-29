package sn.smart.eco.clients.model;

import sn.smart.eco.common.utils.GaficoCommonUtils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client_address")
public class Address {
  @Id
  @GeneratedValue
  @Column(name = "add_id")
  private Long id;
  private String address;
  private String city;
  private String country;
  private String zipCode;
  private boolean actual;
  private Date creationDate;
  @OneToMany(mappedBy = "addresses")
  private Set<ClientInfo> clients;

  public Address() {}

  public Address(String address, String city, String country, String zipCode, boolean isActual,
      Date creationDate, Set<ClientInfo> clients) {
    this.address = address;
    this.city = city;
    this.country = country;
    this.zipCode = zipCode;
    this.actual = isActual;
    this.creationDate = creationDate;
    this.clients = clients;
  }



  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public boolean isActual() {
    return actual;
  }

  public void setActual(boolean isActual) {
    this.actual = isActual;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public Set<ClientInfo> getClients() {
    return clients;
  }

  public void setClients(Set<ClientInfo> clients) {
    this.clients = clients;
  }

  public void addClientInfo(ClientInfo client) {
    if (CollectionUtils.isEmpty(clients)) {
      clients = new HashSet<>();
    }

    clients.add(client);
  }

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }
}
