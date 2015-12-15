package it.unical.ea;

import javax.servlet.http.HttpSession;


public class SessionHandler {

	public static boolean existsUser(HttpSession session) {
		String user = (String) session.getAttribute("user");
		return user != null;
	}
	
//	public static Car getPurchase(HttpSession session) {
//		Car car = (Car) session.getAttribute("purchase");
//		if(car == null) {
//			car = new Car();
//			session.setAttribute("purchase", car);
//		}		
//		return car;
//	}
}
