package sn.smart.eco.clients.model;

import sn.smart.eco.common.utils.GaficoCommonUtils;
import sn.smart.eco.commonjpa.model.GaficoComponent;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client_license")
public class GaficoLicense {
  @Id
  @Column(name = "license_id")
  private String licenseId;
  @Column(nullable = false)
  private Date startDate;
  private Date endDate;
  private Long nbUsers;
  @OneToMany
  // @JoinTable(name = "client_license_component", joinColumns = @JoinColumn(name = "license_id"),
  // inverseJoinColumns = @JoinColumn(name = "comp_id"))
  private Set<GaficoComponent> components;
  @ManyToOne
  private ClientInfo owner;

  public GaficoLicense() {}

  public GaficoLicense(String licenseId, Date startDate, Date endDate, Long nbUsers,
      Set<GaficoComponent> components, ClientInfo owner) {
    this.licenseId = licenseId;
    this.startDate = startDate;
    this.endDate = endDate;
    this.nbUsers = nbUsers;
    this.components = components;
    this.owner = owner;
  }



  public String getLicenseId() {
    return licenseId;
  }

  public void setLicenseId(String licenseId) {
    this.licenseId = licenseId;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public Long getNbUsers() {
    return nbUsers;
  }

  public void setNbUsers(Long nbUsers) {
    this.nbUsers = nbUsers;
  }

  public Set<GaficoComponent> getComponents() {
    return components;
  }

  public void setComponents(Set<GaficoComponent> components) {
    this.components = components;
  }

  public ClientInfo getOwner() {
    return owner;
  }

  public void setOwner(ClientInfo owner) {
    this.owner = owner;
  }

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }
}
