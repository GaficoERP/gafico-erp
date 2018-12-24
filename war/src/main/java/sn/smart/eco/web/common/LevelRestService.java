package sn.smart.eco.web.common;

import sn.smart.eco.commonjpa.model.Level;
import sn.smart.eco.commonjpa.service.LevelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/rest/common/level")
public class LevelRestService {

  @Autowired
  private LevelService service;

  @PostMapping("/add")
  public Level add(@RequestBody @NonNull Level level) {
    return service.addLevel(level);
  }

  @PostMapping("/update")
  public Level update(@RequestBody @NonNull Level level) {
    return service.updateLevel(level);
  }

  @PostMapping("/addAll")
  public List<Level> addAll(@RequestBody @NonNull Set<Level> levels) {
    return service.addAllLevels(levels);
  }

  @GetMapping("/findByPrevious/{position}/{structuration}")
  public Level findByPrevious(@PathVariable @NonNull Integer position,
      @PathVariable @NonNull String structuration) {
    return service.findByPositionAndIdentifierStructuration(position, structuration);
  }
}
