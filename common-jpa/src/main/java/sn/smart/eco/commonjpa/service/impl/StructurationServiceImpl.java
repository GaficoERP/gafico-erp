package sn.smart.eco.commonjpa.service.impl;

import sn.smart.eco.common.model.PlanType;
import sn.smart.eco.commonjpa.model.Structuration;
import sn.smart.eco.commonjpa.repositories.LevelTypeRepository;
import sn.smart.eco.commonjpa.repositories.StructurationRepository;
import sn.smart.eco.commonjpa.service.StructurationService;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class StructurationServiceImpl implements StructurationService {
  @Autowired
  private StructurationRepository structRepository;
  @Autowired
  private LevelTypeRepository ltRepository;

  @Override
  public Structuration findStructurationByName(@NonNull String name) {
    return structRepository.getOne(name);
  }

  @Override
  public Structuration findStructurationByType(@NonNull PlanType type) {
    return structRepository.findByType(type);
  }

  @Override
  public Structuration addStructuration(@NonNull Structuration struct) {
    if (CollectionUtils.isNotEmpty(struct.getLevels())) {
      struct.getLevels().forEach(lt -> ltRepository.save(lt));
    }
    return structRepository.save(struct);
  }

}
