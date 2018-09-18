package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fornite.util.ForniteQueue;
import fornite.util.ForniteStack;

class ForniteQueueTest {

ForniteQueue<Integer> queue;
	
	void escenario1() {
		queue = new ForniteQueue<Integer>();
		for (int i = 0; i < 40; i++) {
			queue.enqueue(i);
		}
	}

	void escenario2() {
		queue = new ForniteQueue<Integer>();
		for (int i = 0; i < 40; i++) {
			queue.enqueue((int)(Math.random()*15));
		}
	}
	
	void escenario3() {
		queue = new ForniteQueue<Integer>();
	}
	
	@Test
	void isEmptyTest()
	{
		escenario1();
		assertFalse(queue.isEmpty());
		
		escenario3();
		assertTrue(queue.isEmpty());
	}
	
	@Test
	void frontTest()
	{
		boolean f = false;
		try {
			escenario1();
			assertEquals(0, queue.front());
			
		
			escenario3();
			assertNull(queue.front());
		} catch (Exception e) {
			f = true;
		}
		
		assertTrue(f);
	}
	
	@Test
	void dequeueTest()
	{
		boolean f = false;
		try {
			escenario1();
			queue.dequeue();
			assertEquals(1, queue.front());
			
		
			escenario3();
			assertNull(queue.dequeue());
		} catch (Exception e) {
			f = true;
		}
		
		assertTrue(f);
	}
	
	@Test
	void enqueueTest()
	{
		escenario1();
		queue.enqueue(41);
		assertEquals(41, queue.getLast().getItem());
		
		escenario2();
		queue.enqueue(13);
		assertEquals(13, queue.getLast().getItem());
		
		escenario3();
		queue.enqueue(4);
		assertFalse(queue.isEmpty());
	}
	
}
