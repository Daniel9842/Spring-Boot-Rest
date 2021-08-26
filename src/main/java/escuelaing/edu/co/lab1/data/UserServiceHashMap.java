package escuelaing.edu.co.lab1.data;

import java.util.HashMap;


import org.springframework.stereotype.Service;

import escuelaing.edu.co.lab1.service.UserService;
@Service
public class UserServiceHashMap implements UserService{
	private HashMap<String, User> userHashMap = new HashMap<String,User>();
	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		userHashMap.put(user.getId(), user);
        return user;
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		if(userHashMap.containsKey(id)) {
			return userHashMap.get(id);
		}else {
			return null;
		}
	}

	@Override
	public HashMap<String, User> all() {
		// TODO Auto-generated method stub
		return userHashMap;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		userHashMap.remove(id);
	}

	@Override
	public User update(User user, String userId) {
		// TODO Auto-generated method stub
		userHashMap.put(userId,user);
		return user;
	}

}
