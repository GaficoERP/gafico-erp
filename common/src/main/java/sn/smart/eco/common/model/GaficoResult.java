package sn.smart.eco.common.model;

public class GaficoResult {

  private String error;
  private String warning;
  private String info;
  private GaficoStatus status;

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getWarning() {
    return warning;
  }

  public void setWarning(String warning) {
    this.warning = warning;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public GaficoStatus getStatus() {
    return status;
  }

  public void setStatus(GaficoStatus state) {
    this.status = state;
  }
}
