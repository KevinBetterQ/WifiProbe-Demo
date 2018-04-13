package com.wifi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wifi.db.QueryData;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//获取客流量和入店量
		int guestNum = QueryData.query_guestNum();
		int entryNum = QueryData.query_entryNum();
		
		System.out.println("guest="+guestNum);
		System.out.println("entry="+entryNum);
		
		//获取客流变化和入店变化
		Map<String, Integer> guestFlow = QueryData.query_guestFlow();
		List<String> listGuest_t = new ArrayList<>();
		List<String> listGuest_n = new ArrayList<>();
		Iterator<String> itguest = guestFlow.keySet().iterator();
		while(itguest.hasNext()){
			String key = itguest.next().toString();
			listGuest_n.add(String.valueOf(guestFlow.get(key)));
			key = key.split(" ")[1];
			key = "\"" + key + "\"";
			listGuest_t.add(key);
			
		}
		System.out.println("convert finished 1");
		for(int i =0 ;i<listGuest_t.size();i++){
			System.out.print("Key :"+listGuest_t.get(i));
			System.out.println(" Value :"+listGuest_n.get(i));
		}
				
		//获取入店变化
		Map<String, Integer> entryFlow = QueryData.query_entryFlow();
		List<String> listEntry_t = new ArrayList<>();
		List<String> listEntry_n = new ArrayList<>();
		Iterator<String> itentry = entryFlow.keySet().iterator();
		while(itentry.hasNext()){
			String key = itentry.next().toString();
			listEntry_t.add(key);
			listEntry_n.add(String.valueOf(entryFlow.get(key)));
		}
		/*System.out.println("convert finished2");
		for(int i =0 ;i<listEntry_t.size();i++){
			System.out.print("Key :"+listEntry_t.get(i));
			System.out.println(" Value :"+listEntry_n.get(i));
		}*/
		
		//通过request传递给前端页面
		request.setAttribute("guestNum", guestNum);
		request.setAttribute("entryNum", entryNum);
		
		request.setAttribute("listGuest_t", listGuest_t);
		request.setAttribute("listGuest_n", listGuest_n);
		request.setAttribute("listEntry_t", listEntry_t);
		request.setAttribute("listEntry_n", listEntry_n);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
