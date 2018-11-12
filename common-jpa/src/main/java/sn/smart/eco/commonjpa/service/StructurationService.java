package sn.smart.eco.commonjpa.service;

import sn.smart.eco.commonjpa.model.Level;
import sn.smart.eco.commonjpa.model.Structuration;

import java.util.List;

public interface StructurationService {

  public Structuration addStructuration(Structuration struct);

  public Structuration findStructuration(String name);

  public Structuration addLevel(Structuration struct, Level level);

  public Structuration addLevels(Structuration struct, List<Level> levels);

}
