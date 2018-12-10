package sn.smart.eco.commonjpa.service;

import sn.smart.eco.commonjpa.model.Level;

import java.util.List;
import java.util.Set;

public interface LevelService {

  public Level addLevel(Level level);

  public Level updateLevel(Level level);

  public List<Level> addAllLevels(Set<Level> levels);

  public void deleteLevel(String levelName);

  public List<Level> findLevelsByPrevious(Level previous);

}
