package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fornite.util.ForniteStack;

class ForniteStackTest {

	ForniteStack<Integer> stack;
	
	void escenario1() {
		stack = new ForniteStack<>();
		for (int i = 0; i < 40; i++) {
			stack.push(i);
		}
	}

	void escenario2() {
		stack = new ForniteStack<>();
		for (int i = 0; i < 15; i++) {
			stack.push((int)(Math.random()*15));
		}
	}
	
	void escenario3() {
		stack = new ForniteStack<>();
	}
	
	@Test
	void pushTest()
	{
		escenario1();
		stack.push(41);
		assertEquals(41, stack.top().intValue());
		
		escenario2();
		stack.push(13);
		assertEquals(16, stack.size());
		
		escenario3();
		stack.push(4);
		assertFalse(stack.isEmpty());
	}
	
	@Test
	void popTest()
	{
		escenario1();
		stack.pop();
		assertNotEquals(39, stack.top());
		
		escenario2();
		int k = stack.size();
		stack.pop();
		assertEquals(k-1, stack.size());
		
		escenario3();
		boolean f = false;
		
		try {
			stack.pop();
		} catch (Exception e) {
			f = true;
		}
		assertTrue(f);
	}
	
	@Test
	void topTest()
	{
		escenario1();
		assertEquals(39, stack.top().intValue());
		
		escenario2();
		stack.push(34);
		assertEquals(34, stack.top().intValue());
		
		escenario3();
		boolean f = false;
		try {
			assertNull(stack.top());
		} catch (Exception e) {
			f = true;
		}
		
		assertTrue(f);
		
	}
	
	@Test
	void isEmptyTest()
	{
		escenario1();
		assertFalse(stack.isEmpty());
		
		escenario3();
		assertTrue(stack.isEmpty());
	}
	
	@Test
	void sizeTest()
	{
		escenario1();
		assertEquals(40, stack.size());
		
		escenario3();
		assertEquals(0, stack.size());
	}
}
