package escuelaing.edu.co.lab1.service;


import java.util.HashMap;


import escuelaing.edu.co.lab1.data.User;

public interface UserService {
	
	
	
	User create( User user );

    User findById( String id );
    
    HashMap<String, User> all();

    void deleteById( String id );

    User update( User user, String userId );
}
