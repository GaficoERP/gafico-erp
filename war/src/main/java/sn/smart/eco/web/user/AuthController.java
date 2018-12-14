// package sn.smart.eco.web.user;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.core.context.SecurityContextHolder;
// import
// org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;
//
// import sn.smart.eco.auth.model.AuthToken;
// import sn.smart.eco.auth.model.LoginUser;
// import sn.smart.eco.auth.service.SecurityService;
//
//// @CrossOrigin
// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {
//
// @Autowired
// private SecurityService securityService;
//
// @RequestMapping(value = "/login", method = RequestMethod.POST)
// public AuthToken auth(@RequestBody LoginUser params) throws
// AuthenticationException {
// String token = securityService.login(params.getUsername(),
// params.getPassword());
// return new AuthToken(token);
// }
//
// @RequestMapping(value = "/logout", method = RequestMethod.POST)
// public AuthToken logoutPage(HttpServletRequest request, HttpServletResponse
// response) {
// Authentication auth = SecurityContextHolder.getContext().getAuthentication();
// if (auth != null) {
// new SecurityContextLogoutHandler().logout(request, response, auth);
// }
// return new AuthToken();
// }
//
// @ExceptionHandler({ AuthenticationException.class })
// public ResponseEntity<String>
// handleAuthenticationException(AuthenticationException e) {
// return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
// }
//
// }
