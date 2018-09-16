package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fornite.util.ForniteHashTable;
import fornite.util.ForniteList;
import fornite.util.FornitePair;

class ForniteHashtableTest {

	ForniteHashTable<Integer,Integer> hash;
	
	void escenario1() {
		hash = new ForniteHashTable<>();
		for (int i = 0; i < 40; i++) {
			hash.put(i, 2*i);
		}
	}
	
	
	void escenario2() {
		hash = new ForniteHashTable<>();
		for (int i = 1; i < 40; i++) {
			hash.put(7*i, 2*i);
		}
	}
	
	
	void escenario3() {
		hash = new ForniteHashTable<>();
	}
	
	@Test
	void getTest()
	{
		escenario1();
		for (int i = 0; i < 40; i++) {
			Integer n = 2*i;
			assertEquals(n, hash.get(i));
			
		}
		
		escenario2();
		for (int i = 0; i < 40; i+=6) {
			Integer n = 2*i;
			assertNotEquals(n, hash.get(i));
			
		}
		
		escenario3();
		
		assertNull(hash.get(2));
	}

	@Test
	void putTest()
	{
		escenario1();
		Integer j = hash.get(4);
		hash.put(4, 3);
		assertNotEquals(j, hash.get(4));
		
		escenario2();
		hash.put(3, 9);
		Integer k =9;
		assertEquals(k, hash.get(3));
		
		escenario3();
		hash.put(45, 3);
		assertNotNull(hash.get(45));
	}
	
	@Test
	void removeTest()
	{
		escenario1();
		hash.remove(7);
		Integer k = 34;
		assertEquals(k, hash.get(17));
		
		escenario2();
		hash.remove(6);
		assertNull(hash.get(6));
	}
	
	@Test
	void sizeTest()
	{
		escenario1();
		assertEquals(40, hash.size());
		
		escenario3();
		assertEquals(0, hash.size());
	}
	
	@Test
	void isEmptyTest()
	{
		escenario1();
		assertFalse(hash.isEmpty());
		
		escenario3();
		assertTrue(hash.isEmpty());
	}
	
}
