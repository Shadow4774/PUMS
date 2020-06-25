package it.enaip.corso.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.enaip.corso.model.DaoImpl;
import it.enaip.corso.model.User;

@WebServlet(name = "UserController", urlPatterns = { "/UserController" })
public class UserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DaoImpl userDao = DaoImpl.getInstance();
	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*/
		String action = req.getServletPath();
		/*/
		String action = req.getParameter("op");
		//*/
		try {
			switch (action) {
			case "new":
				showNewForm(req, resp);
				break;
			case "insert":
				insertUser(req, resp);
				break;
			case "delete":
				deleteUser(req, resp);
				break;
			case "edit":
				showEditForm(req, resp);
				break;

			case "update":
				updateUser(req, resp);
				break;
			default:
				listUser(req, resp);
				break;
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "SQL Error", e);
		}

	}

	private void updateUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		int age = Integer.parseInt(req.getParameter("age"));
		String department = req.getParameter("location");
		User user = new User(id, name, surname, age, department);
		userDao.update(user);
		resp.sendRedirect("/PUMS/UserController?op=list");
	}

	private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String id = req.getParameter("id");
		Optional<User> existingUser = userDao.find(id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/UserForm.jsp");
		existingUser.ifPresent(s -> req.setAttribute("user", s));
		dispatcher.forward(req, resp);
	}

	private void deleteUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = new User(id);
		userDao.delete(user);
		resp.sendRedirect("/PUMS/UserController?op=list");

	}

	private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/UserForm.jsp");
		dispatcher.forward(req, resp);

	}

	private void listUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("jsp/UserForm.jsp");
		List<User> listUser = userDao.findAll();
		req.setAttribute("listUser", listUser);
		dispatcher.forward(req, resp);
	}

	private void insertUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {

		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		int age = Integer.parseInt(req.getParameter("age"));
		String department = req.getParameter("department");
		User user = new User(name, surname, age, department);
		userDao.save(user);
		resp.sendRedirect("/PUMS/UserController?op=list");
	}

}
