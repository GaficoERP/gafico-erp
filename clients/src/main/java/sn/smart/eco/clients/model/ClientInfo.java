package sn.smart.eco.clients.model;

import sn.smart.eco.common.utils.GaficoCommonUtils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client_info")
public class ClientInfo {

  @Id
  @GeneratedValue
  @Column(name = "client_id")
  private Long id;
  @Column(unique = true)
  private String name;
  @Column(unique = true)
  private String telephone;
  @Column(unique = true)
  private String email;
  private LegalStatus legalStatus;
  @OneToMany
  @JoinTable(name = "client_info_address", joinColumns = @JoinColumn(name = "client_id"),
      inverseJoinColumns = @JoinColumn(name = "add_id"))
  private Set<Address> addresses;
  @OneToMany
  @JoinTable(name = "client_info_license", joinColumns = @JoinColumn(name = "client_id"),
      inverseJoinColumns = @JoinColumn(name = "license_id"))
  private Set<GaficoLicense> licenses;

  public ClientInfo() {}

  public ClientInfo(String name, String telephone, String email, LegalStatus legalStatus) {
    this.name = name;
    this.telephone = telephone;
    this.email = email;
    this.legalStatus = legalStatus;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Address> getAddresses() {
    return addresses;
  }

  public void setAddresses(Set<Address> addresses) {
    this.addresses = addresses;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public LegalStatus getLegalStatus() {
    return legalStatus;
  }

  public void setLegalStatus(LegalStatus legalStatus) {
    this.legalStatus = legalStatus;
  }

  public Set<GaficoLicense> getLicenses() {
    return licenses;
  }

  public void setLicenses(Set<GaficoLicense> licenses) {
    this.licenses = licenses;
  }

  public void addAddress(Address address) {
    if (CollectionUtils.isEmpty(addresses)) {
      addresses = new HashSet<>();
    }

    addresses.add(address);
  }

  public void addLicense(GaficoLicense license) {
    if (CollectionUtils.isEmpty(licenses)) {
      licenses = new HashSet<>();
    }

    licenses.add(license);
  }

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }
}
