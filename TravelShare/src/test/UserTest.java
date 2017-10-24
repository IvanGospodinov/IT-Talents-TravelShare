package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dbConnection.UserDAO;
import model.User;
import model.UserException;

public class UserTest {


	private User testUser = new User("Tessdf112tTest", "Tessdf112tTest", "Tessdf112tTest", "Tessdf112tTest", "Tessdf112tTest","Tessdf112tTest");
	
	@Test
	public void testRegisterUser() throws UserException {
		UserDAO.getInstance().registerUser(testUser);
		
		
		boolean user2 = UserDAO.getInstance().loginUser("Tessdf112tTest", "Tes1sdf12tTest");
		
		assertEquals(user2, true);
		
		//testUser.setUserID(user);
	}


//@Test
//public void testRegisterUser2() {
//	int id= 0;;
//	try {
//		id = userDao.registerUser(testUser);
//		assertNotSame(id, 0);
//	} catch (UserException e) {
//		System.out.println(e.getMessage());;
//		//e.printStackTrace();
//	}
//	
//	int id2;
//	try {
//		id2 = userDao.loginUser(testUser);
//		assertEquals(id, id2);
//	} catch (UserException e) {
//		e.getMessage();
//	}

//}	

}
