package sn.smart.eco.common.jpa.model;

import sn.smart.eco.common.utils.GaficoCommonUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "common_component")
public class GaficoComponent {
  @Transient
  public static final GaficoComponent DEFAULT = new GaficoComponent("default", "Default", true);
  @Transient
  public static final GaficoComponent BUDGET = new GaficoComponent("budget", "Budget", true);
  @Transient
  public static final GaficoComponent BILLING = new GaficoComponent("billing", "Billing", true);
  @Transient
  public static final GaficoComponent RECOVERY = new GaficoComponent("recovery", "Recovery", false);
  @Transient
  public static final GaficoComponent COMMITMENT =
      new GaficoComponent("commitment", "Commitment", false);
  @Transient
  public static final GaficoComponent PUBLIC_MARKET =
      new GaficoComponent("public_market", "Public Market", true);
  @Transient
  public static final GaficoComponent ACCOUNTANCY =
      new GaficoComponent("accountancy", "Accountancy", false);
  @Transient
  public static final GaficoComponent PAY = new GaficoComponent("pay", "Pay", false);
  // a completer
  @Id
  @Column(name = "comp_id")
  private String id;
  private String name;
  private boolean inDefaultPack;

  public GaficoComponent() {}

  public GaficoComponent(String id, String name, boolean inDefaultPack) {
    this.id = id;
    this.name = name;
    this.inDefaultPack = inDefaultPack;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isInDefaultPack() {
    return inDefaultPack;
  }

  public void setInDefaultPack(boolean inDefaultPack) {
    this.inDefaultPack = inDefaultPack;
  }

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }
}
