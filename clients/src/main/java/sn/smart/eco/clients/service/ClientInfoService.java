package sn.smart.eco.clients.service;

import sn.smart.eco.clients.model.ClientInfo;

public interface ClientInfoService {
  public ClientInfo findClientInfo(String name);

  public ClientInfo addClientInfo(ClientInfo client);
}
