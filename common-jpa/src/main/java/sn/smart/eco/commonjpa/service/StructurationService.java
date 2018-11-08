package sn.smart.eco.commonjpa.service;

import sn.smart.eco.common.model.PlanType;
import sn.smart.eco.commonjpa.model.Structuration;

public interface StructurationService {

  public Structuration addStructuration(Structuration struct);

  public Structuration findStructurationByName(String name);

  public Structuration findStructurationByType(PlanType type);
}
