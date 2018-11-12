package sn.smart.eco.web.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.smart.eco.commonjpa.model.Structuration;
import sn.smart.eco.commonjpa.service.StructurationService;

@RestController
@RequestMapping("/rest/common/struct")
public class StructurationRestService {
	@Autowired
	private StructurationService service;

	@PostMapping("/add")
	public Structuration add(@RequestBody @NonNull Structuration struct) {
		return service.addStructuration(struct);
	}

	@GetMapping("/find/{name}")
	public Structuration find(@PathVariable("name") @NonNull String name) {
		return service.findStructuration(name);
	}

//  @GetMapping("/findByType/{type}")
//  public Structuration findByType(@PathVariable("type") @NonNull PlanType type) {
//    return service.findStructurationByType(type);
//  }
}
