package test;

import static org.junit.Assert.*;
import org.junit.Test;
import web.Events;

public class TestAPI {
	
	@Test
	public void testEvents(){
		Events.getAll();
	}
	
}
