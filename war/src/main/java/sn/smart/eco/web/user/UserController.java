package sn.smart.eco.web.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public List<User> listUser(){
        return userService.findAll();
    }
	
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getOne(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
    public User saveUser(@RequestBody User user){
        return userService.create(user);
    }

}
