package spring_profile_20230717;

public class ServiceInfo {
  private String ipNumber;
  private String portNumber;

  public ServiceInfo() {}

  public ServiceInfo(String ipNumber, String portNumber) {
    this.ipNumber = ipNumber;
    this.portNumber = portNumber;
  }

  public String getIpNumber() {
    return ipNumber;
  }

  public void setIpNumber(String ipNumber) {
    this.ipNumber = ipNumber;
  }

  public String getPortNumber() {
    return portNumber;
  }

  public void setPortNumber(String portNumber) {
    this.portNumber = portNumber;
  }

  @Override
  public String toString() {
    return "ServiceInfo [ipNumber=" + ipNumber + ", portNumber=" + portNumber + "]";
  }
}
