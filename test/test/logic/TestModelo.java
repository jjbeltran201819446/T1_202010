package test.logic;

import controller.Controller;
import model.logic.Modelo;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestModelo 
{
	private Modelo modelo;
	
	public TestModelo()
	{
		modelo= new Modelo();
	}
	
	public void setUp1()
	{
		modelo.leerJson(Controller.RUTA_INCOMPLETA);
	}
	
	@Test
	public void leerJsonTestYBuscar()
	{
		setUp1();
		assertFalse("Debió haber encontrado un objeto", modelo.buscar("29042").equals("No se encontró el elemento buscado"));
		assertFalse("Debió haber encontrado un objeto", modelo.buscar("509329").equals("No se encontró el elemento buscado"));
		assertFalse("Debió haber encontrado un objeto", modelo.buscar("519553").equals("No se encontró el elemento buscado"));
		assertFalse("Debió haber encontrado un objeto", modelo.buscar("176695").equals("No se encontró el elemento buscado"));
		assertFalse("Debió haber encontrado un objeto", modelo.buscar("395846").equals("No se encontró el elemento buscado"));
		assertFalse("Debió haber encontrado un objeto", modelo.buscar("46500").equals("No se encontró el elemento buscado"));
		assertFalse("Debió haber encontrado un objeto", modelo.buscar("58338").equals("No se encontró el elemento buscado"));
		assertFalse("Debió haber encontrado un objeto", modelo.buscar("184177").equals("No se encontró el elemento buscado"));
		assertFalse("Debió haber encontrado un objeto", modelo.buscar("395366").equals("No se encontró el elemento buscado"));
		assertFalse("Debió haber encontrado un objeto", modelo.buscar("444949").equals("No se encontró el elemento buscado"));
	}
	
}
