package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbConnection.PostDAO;
import model.Post;
import model.UserException;

@WebServlet("/welcome.jsp")

public class CreatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreatePost() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//String category = request.getParameter("category");
		String title = request.getParameter("title");
		String location = request.getParameter("location");
		String description = request.getParameter("description");
		
		
		Post post = new Post(title, location, description);
		int result =0;
		try {
			result = PostDAO.getInstance().createPost(post);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//req.getRequestDispatcher("").forward(req, resp);
		return;
		
		
		
		
		
		//doGet(request, response);
		
		
		
		
		
		
	}

}
