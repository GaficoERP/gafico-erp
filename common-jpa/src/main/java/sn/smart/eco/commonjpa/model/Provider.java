package sn.smart.eco.commonjpa.model;

import sn.smart.eco.common.utils.GaficoCommonUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "common_providers")
public class Provider {
  @Id
  private String name;
  @Column(nullable = false, unique = true)
  private String ninea;
  @Column(nullable = false, unique = true)
  private String accountNumber;
  @Column(nullable = false, unique = true)
  private String accountLabel;
  @Column(nullable = false, unique = true)
  private String bankAccount;
  @Column(nullable = false)
  private String phoneNumber;
  private String phoneNumber2;
  @Column(nullable = false, unique = true)
  private String email;
  @Column(nullable = false)
  private String address;
  private String faxNumber;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNinea() {
    return ninea;
  }

  public void setNinea(String ninea) {
    this.ninea = ninea;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountLabel() {
    return accountLabel;
  }

  public void setAccountLabel(String accountLabel) {
    this.accountLabel = accountLabel;
  }

  public String getBankAccount() {
    return bankAccount;
  }

  public void setBankAccount(String bankAccount) {
    this.bankAccount = bankAccount;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPhoneNumber2() {
    return phoneNumber2;
  }

  public void setPhoneNumber2(String phoneNumber2) {
    this.phoneNumber2 = phoneNumber2;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getFaxNumber() {
    return faxNumber;
  }

  public void setFaxNumber(String faxNumber) {
    this.faxNumber = faxNumber;
  }

  @Override
  public String toString() {
    return GaficoCommonUtils.toJsonString(this);
  }
}
