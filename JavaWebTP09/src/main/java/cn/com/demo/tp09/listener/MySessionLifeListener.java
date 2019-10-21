package cn.com.demo.tp09.listener;

import java.util.Set;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class MySessionLifeListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		String currName = (String)se.getSession().getAttribute("CURR_ALIA_NAME");
		Set<String> nameSet = (Set<String>)se.getSession().getServletContext().getAttribute("ALIANAME_SET");
		if(nameSet != null && currName != null) {
			nameSet.remove(currName);
		}
	}

}
