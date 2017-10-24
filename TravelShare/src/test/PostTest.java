package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import dbConnection.PostDAO;
import model.Post;
import model.UserException;

public class PostTest {
	
//	long timeNow = Calendar.getInstance().getTimeInMillis();
//	java.sql.Timestamp ts = new java.sql.Timestamp(Calendar.getInstance().getTimeInMillis());
	
	
	private PostDAO postDao = new PostDAO();
	private Post postTest = new Post("rrr","rrr",    LocalDate.now(),  LocalDate.now(), 1,1,"sofia");
	
	
	
	//java.sql.Timestamp ts = new java.sql.Timestamp(timeNow);
	
	//preparedStatement.setTimestamp(TIME_COL_INDEX, ts);
	

	@Test
	public void test() {
		
		int result = 0;
		try {
			result = postDao.createPost(postTest);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(result, 0);
		
		
		System.out.println("ID after post " + result);
		
		//fail("Not yet implemented");
	}

}



