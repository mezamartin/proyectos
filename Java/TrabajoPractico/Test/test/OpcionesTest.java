package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Clases.Opcion;

public class OpcionesTest {
	private Opcion opcion1;

	@Before
	public void setUp(){
		opcion1=new Opcion("aca va la afirmacion");
	}

	@Test
	public void testUnaOpcionConoceSuAfirmacion() {
		assertTrue(opcion1.getAfirmacion()=="aca va la afirmacion");
		
	}

}
