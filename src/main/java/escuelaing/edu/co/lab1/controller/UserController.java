package escuelaing.edu.co.lab1.controller;

import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import escuelaing.edu.co.lab1.data.User;
import escuelaing.edu.co.lab1.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	private final UserService userService;

	public UserController(@Autowired UserService userService) {
		this.userService = userService;
	}

	@GetMapping
   public ResponseEntity<HashMap<String, User>> all()
   {
       //TODO implement this method using UserService
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.all());
        }catch(Exception e) {
    	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
   }

	@GetMapping( "/{id}" )
   public ResponseEntity<User> findById( @PathVariable String id )
   {
      //TODO implement this method using UserService
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
        }catch(Exception e) {
    	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
   }

	@PostMapping
   public ResponseEntity<User> create( @RequestBody User user)
   {
        //TODO implement this method using UserService
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.create(user));
        }catch(Exception e) {
    	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
   }

	@PutMapping( "/{id}" )
   public ResponseEntity<User> update( @RequestBody User user, @PathVariable String id )
   {
        //TODO implement this method using UserService
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.update(user,id));
        }catch(Exception e) {
    	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
   }

	@DeleteMapping( "/{id}" )
   public ResponseEntity<Boolean> delete( @PathVariable String id )
   {
        //TODO implement this method using UserService
		try {
			userService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(Boolean.TRUE);
        }catch(Exception e) {
    	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }     
   }
}