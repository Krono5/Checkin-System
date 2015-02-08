package test;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;
import web.Events;
import web.WebRequest;

public class TestAPI {
	public static String loginId = "";
	
	@Test
	public void testLogin(){
		loginId = WebRequest.login("eventSignin", "eventSignin");
	}
	
	@Test 
	public void testAllEvents(){
		Events.getAll(loginId);
	}
	
}
