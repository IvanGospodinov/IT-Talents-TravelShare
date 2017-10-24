package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dbConnection.UserDAO;
import model.User;
import model.UserException;

@WebServlet("/Register")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String AVATAR_URL = "/Users/Ivan/Desktop/Java EE/ShareTravel/WebContent/images/";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Part avatarPart = request.getPart("user_pictureURL");
			InputStream fis = avatarPart.getInputStream();
			File myFile = new File(AVATAR_URL+request.getParameter("uname")+".jpg");
			if(!myFile.exists()){
				myFile.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(myFile);
			int b = fis.read();
			while(b != -1){
				fos.write(b);
				b = fis.read();
			}
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String avatarUrl = "images/"+request.getParameter("uname")+".jpg";

		User user = new User(
				request.getParameter("uname"),
				request.getParameter("password"),
				request.getParameter("user_email"),
				request.getParameter("user_firstname"),
				request.getParameter("user_lastname"),
				avatarUrl
				);
		System.out.println(user.getPictureURL());

		try {
			UserDAO.getInstance().registerUser(user);
			if(user.getUserID() != 0) {
				request.getSession().setAttribute("userID", user.getUserID());
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				String username = request.getParameter("name");
				response.addCookie(new Cookie("username", user.getFirstName()));
			} else {
				request.setAttribute("user", null);
				request.getRequestDispatcher("/Error.html").forward(request, response);			
			}
		} catch (UserException e) {
			e.printStackTrace();
		}
	}


}