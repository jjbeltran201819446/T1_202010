package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.ListaEnlazada;

public class TestListaEnlazada 
{
	private ListaEnlazada lista;
	
	@Before
	public void setUp1()
	{
		lista = new ListaEnlazada<Integer>();
	}
	
	@Test
	public void testAgregarAlPrincipio()
	{
		setUp1();
		lista.agregarAlComienzo(3);
		assertEquals("El valor del primer nodo no es el esperado", 3, lista.darPrimerNodo().darContenido());
		lista.agregarAlComienzo(2);
		assertEquals("El valor del primer nodo no es el esperado", 2, lista.darPrimerNodo().darContenido());
		lista.agregarAlComienzo(1);
		assertEquals("El valor del primer nodo no es el esperado", 1, lista.darPrimerNodo().darContenido());
		
	}
	
	@Test
	
	public void testAgregarAlFinal()
	{
		setUp1();
		lista.agregarAlFinal(3);
		assertEquals("No se encontró el valor esperado", 3, lista.darUltimoNodo().darContenido());
		lista.agregarAlFinal(2);
		assertEquals("No se encontró el valor esperado", 2, lista.darUltimoNodo().darContenido());
		lista.agregarAlFinal(1);
		assertEquals("No se encontró el valor esperado", 1, lista.darUltimoNodo().darContenido());
	}
	
	@Test
	public void agregarEnCualquierPosTest()
	{
		setUp1();
		try 
		{
			lista.agregarEnCualquierPos(1, 0);
			assertEquals("No se encontró el valor esperado", 1, lista.darPrimerNodo().darContenido());
			lista.agregarEnCualquierPos(2, 1);
			assertEquals("No se encontró el valor esperado", 2, lista.darUltimoNodo().darContenido());
			lista.agregarAlComienzo(3);
			assertEquals("No se encontró el valor esperado", 3, lista.darPrimerNodo().darContenido());
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void eliminarPrimerElementoTest()
	{
		setUp1();
		lista.agregarAlComienzo(5);
		lista.agregarAlComienzo(4);
		lista.agregarAlComienzo(3);
		lista.agregarAlComienzo(2);
		lista.agregarAlComienzo(1);
		
		lista.eliminarPrimerElemento();
		assertEquals("No se devolvió el valor esperado", 2, lista.darPrimerNodo().darContenido());
	}
	
	@Test 
	public void eliminarUltimoElementoTest()
	{
		setUp1();
		lista.agregarAlComienzo(5);
		lista.agregarAlComienzo(4);
		lista.agregarAlComienzo(3);
		lista.agregarAlComienzo(2);
		lista.agregarAlComienzo(1);
		
		lista.eliminarUltimoElemento();
		assertEquals("No se devolvió el valor esperado", 4, lista.darUltimoNodo().darContenido());
	}
	
	public void eliminarPorPos() throws Exception
	{
		lista.agregarAlComienzo(5);
		lista.agregarAlComienzo(4);
		lista.agregarAlComienzo(3);
		lista.agregarAlComienzo(2);
		lista.agregarAlComienzo(1);
		
		lista.eliminar(1);
		lista.eliminar(2);
		lista.eliminar(2);
		
		assertEquals("No se devolvió el valor esperado", 3, lista.darUltimoNodo().darContenido());
		
	}
	 
}
