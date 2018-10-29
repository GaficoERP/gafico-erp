package sn.smart.eco.clients.model;

import sn.smart.eco.common.model.GaficoComponent;
import sn.smart.eco.common.utils.GaficoCommonUtils;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client_license")
public class GaficoLicense {
  @Id
  @Column(name = "license_id")
  private String licenseId;
  private Date startDate;
  private Date endDate;
  @ElementCollection(targetClass = GaficoComponent.class)
  private Set<GaficoComponent> components;
  @ManyToOne // (mappedBy = "licenses")
  private ClientInfo owner;

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
