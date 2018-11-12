package sn.smart.eco.commonjpa.service.impl;

import sn.smart.eco.commonjpa.model.Level;
import sn.smart.eco.commonjpa.model.Structuration;
import sn.smart.eco.commonjpa.repositories.LevelRepository;
import sn.smart.eco.commonjpa.repositories.StructurationRepository;
import sn.smart.eco.commonjpa.service.StructurationService;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public class StructurationServiceImpl implements StructurationService {
  @Autowired
  private StructurationRepository structRepository;
  @Autowired
  private LevelRepository lvRepository;

  @Override
  public Structuration findStructuration(@NonNull String name) {
    return structRepository.getOne(name);
  }


  @Override
  public Structuration addStructuration(@NonNull Structuration struct) {
    if (CollectionUtils.isNotEmpty(struct.getLevels())) {
      // saves/updates all levels
      lvRepository.saveAll(struct.getLevels());
    }
    return structRepository.save(struct);
  }


  @Override
  public Structuration addLevel(@NonNull Structuration struct, @NonNull Level level) {
    struct.addLevel(level);
    // saves all updates
    return addStructuration(struct);
  }


  @Override
  public Structuration addLevels(Structuration struct, List<Level> levels) {
    struct.getLevels().addAll(levels);
    return addStructuration(struct);
  }

}
