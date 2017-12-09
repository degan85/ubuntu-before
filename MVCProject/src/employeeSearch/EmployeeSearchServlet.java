package employeeSearch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EmployeeSearchServlet {
	private SearchBiz searchBiz;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Employee emplyee = this.searchBiz.getEmployeeByEmpid(request.getParameter("empid"));
		
		request.setAttribute("employee", emplyee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchResult.jsp");
		dispatcher.forward(request, response);
	}
	
	public void setModel(SearchBiz biz) {
		this.searchBiz = biz;
	}
}
