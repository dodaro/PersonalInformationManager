package it.unical.ea;

import javax.servlet.http.HttpSession;


public class SessionHandler {

	public static boolean existsUser(HttpSession session) {
		String user = (String) session.getAttribute("user");
		return user != null;
	}
	
}
