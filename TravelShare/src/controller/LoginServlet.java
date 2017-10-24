package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbConnection.UserDAO;
import model.User;
import model.UserException;
import util.Encrypter;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		User user =  null;


		boolean userExists = false;	
		try {
			userExists = UserDAO.getInstance().loginUser(request.getParameter("user_email"),request.getParameter("password"));
			if(userExists) {
				user = UserDAO.getInstance().getUser(request.getParameter("user_email"));
				request.getSession().setAttribute("userID", user.getUserID());
				request.getSession().setAttribute("user", user);
				String username = request.getParameter("uname");
				response.addCookie(new Cookie("name", user.getFirstName()));
				ServletContext application = getServletConfig().getServletContext();			
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else{
				request.setAttribute("error", "user does not exist");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (SQLException | UserException e) {
			request.setAttribute("error", "database problem : " + e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);

		}
	}


}
