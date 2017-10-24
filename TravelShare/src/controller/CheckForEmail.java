package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dbConnection.UserDAO;

@WebServlet(asyncSupported = true, name = "CheckForEmailServlet", urlPatterns = { "/CheckForEmail" })
public class CheckForEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String result = UserDAO.getInstance().checkForEmail(email);
		if(result!=null) {
			System.out.println(result);
			response.getWriter().print(new Gson().toJson(result));
		} else {
			response.getWriter().print("No such email has been registered!");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
