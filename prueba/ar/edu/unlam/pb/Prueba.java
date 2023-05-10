package ar.edu.unlam.pb;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert.*;
import org.junit.Test;


public class Prueba {
	
	@Test
	public void queSeCreeElSupermercado() {
		Supermercado supermercado= new Supermercado();
		assertNotNull(supermercado);
	}
	
	

}
