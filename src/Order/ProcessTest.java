package Order;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ProcessTest {

	@Test
	void testProcess() {
		OrderProcessing junit = new OrderProcessing();
		assertEquals((junit.Process(new Order("t1","sell","apple",325,25,"c01"))).size(),0);
		assertEquals((junit.Process(new Order("t2","sell","apple",320,30,"c02"))).size(),0);
		assertEquals((junit.Process(new Order("t3","buy","apple",315,20,"c03"))).size(),0);
		assertEquals((junit.Process(new Order("t4","buy","apple",330,35,"c04"))).size(),2);
	}

}
