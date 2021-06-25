package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreelancerDAO;
import dao.FreelancerDAOImpl;
import model.Freelancer;

public class FreelancerController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	RequestDispatcher dispatcher = null;
	FreelancerDAO freelancerDAO = null;
	
	public FreelancerController() {
		freelancerDAO = new FreelancerDAOImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			
			case "LIST":
				listFreelancer(request, response);
				break;
				
			case "EDIT":
				getSingleFreelancer(request, response);
				break;
				
			case "DELETE":
				deleteFreelancer(request, response);
				break;
				
			default:
				listFreelancer(request, response);
				break;
				
		}
		
	}

	
	//supprimer freelancer
	private void deleteFreelancer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	
		if(freelancerDAO.delete(Integer.parseInt(id))) {
			request.setAttribute("NOTIFICATION", "Freelancer Deleted Successfully!");
		}
		
		listFreelancer(request, response);
	}

	//fetching 1 freelancer
	private void getSingleFreelancer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String id = request.getParameter("id");
		
		Freelancer theFreelancer= freelancerDAO.get(Integer.parseInt(id));
		
		request.setAttribute("freelancer", theFreelancer);
		
		dispatcher = request.getRequestDispatcher("/views/freelancer-form.jsp");
		
		dispatcher.forward(request, response);
	}

	
	//listing Freelancer
	private void listFreelancer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Freelancer> theList = freelancerDAO.get();
		
		request.setAttribute("list", theList);
		
		dispatcher = request.getRequestDispatcher("/views/freelancer-list.jsp");
		
		dispatcher.forward(request, response);
	}

	
	// doPost pour ajout et modification
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		Freelancer f = new Freelancer();
		f.setNom(request.getParameter("nom"));
		f.setPrenom(request.getParameter("prenom"));
		f.setEmail(request.getParameter("email"));
		f.setNb_annees_exp(request.getParameter("nb_annees_exp"));
		f.setCompetences(request.getParameter("competences"));
		
		if(id.isEmpty() || id == null) {
			
			if(freelancerDAO.save(f)) {
				request.setAttribute("NOTIFICATION", "Freelancer Saved Successfully!");
			}
		
		}else {
			
			f.setId(Integer.parseInt(id));
			if(freelancerDAO.update(f)) {
				request.setAttribute("NOTIFICATION", "Freelancer Updated Successfully!");
			}
			
		}
		
		listFreelancer(request, response);
	}

}
