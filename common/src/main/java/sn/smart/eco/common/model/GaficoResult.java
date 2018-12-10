package sn.smart.eco.common.model;

public class GaficoResult {

  private String error;
  private String warning;
  private String info;
  private GaficoState state;

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

  public GaficoState getState() {
    return state;
  }

  public void setState(GaficoState state) {
    this.state = state;
  }
}
