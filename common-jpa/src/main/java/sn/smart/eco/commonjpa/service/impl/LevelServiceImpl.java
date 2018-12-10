package sn.smart.eco.commonjpa.service.impl;

import sn.smart.eco.commonjpa.model.Level;
import sn.smart.eco.commonjpa.repositories.LevelRepository;
import sn.smart.eco.commonjpa.service.LevelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

@Service
@Transactional
public class LevelServiceImpl implements LevelService {
  @Autowired
  private LevelRepository lvRepository;


  @Override
  public Level addLevel(@NonNull Level level) {
    return lvRepository.save(level);
  }

  @Override
  public List<Level> addAllLevels(@NonNull Set<Level> levels) {
    return lvRepository.saveAll(levels);
  }

  @Override
  public void deleteLevel(@NonNull String levelName) {
    lvRepository.deleteById(levelName);
  }

  @Override
  public Level updateLevel(Level level) {
    return lvRepository.save(level);
  }

  @Override
  public List<Level> findLevelsByPrevious(Level previous) {
    Optional<List<Level>> levels = lvRepository.findByPrevious(previous);
    if (levels.isPresent()) {
      return levels.get();
    }

    return new ArrayList<>();
  }

}
