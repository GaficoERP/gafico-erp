package sn.smart.eco.web.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sn.smart.eco.auth.model.User;
import sn.smart.eco.auth.service.UserService;

@RestController
@RequestMapping("/rest/users")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	
    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> listUser() throws AccessDeniedException{
        return userService.findAll();
    }
	
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id) throws AccessDeniedException{
        return userService.findById(id);
    }
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
    public User saveUser(@RequestBody User user) throws AccessDeniedException{
        return userService.create(user);
    }
	
}
