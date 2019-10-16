package cn.com.demo.tp07.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class MyRequestAttributeListener implements ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("********adddedddd");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("!!!!!!!!!!!!replacedddddd");
	}

}
