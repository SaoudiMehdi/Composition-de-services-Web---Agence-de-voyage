package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashape.unirest.http.exceptions.UnirestException;

import Beans.Currency;
import Work.CurrencyForm;
import Work.HotelsForm;
import Work.SettingsForm;

/**
 * Servlet implementation class ConvertMoneyS
 */
@WebServlet("/ConvertMoneyS")
public class ConvertMoneyS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ArrayList<Currency> CURRENCY_LIST = new ArrayList<Currency>();
	public static SettingsForm settings = new SettingsForm();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConvertMoneyS() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
    	list=CurrencyForm.getCurrencyCode();
		request.setAttribute("list", list);

		this.getServletContext().getRequestDispatcher("/WEB-INF/convertmoney.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  
			String amount = settings.getValeurChamp(request,"Value");
			String from = settings.getValeurChamp(request,"from");
			String to = settings.getValeurChamp(request,"to");
			System.out.println(amount);
			System.out.println(from);
			System.out.println(to);
		
			
			try {
				request.setAttribute("result", CurrencyForm.convertCurrency(amount, from, to, request));
			} catch (UnirestException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}



	  
			
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/convertmoney.jsp").forward(request, response);
	}

}
