package controller;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	public final static String RUTA_COMPLETA = "./data/comparendos_dei_2018.geojson";
	public final static String RUTA_INCOMPLETA="./data/comparendos_dei_2018_small.geojson";
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					//TODO
				    modelo = new Modelo();
				    modelo.leerJson(RUTA_COMPLETA);
				    view.printMessage("Lista enlazada creada");
				    view.printMessage("Numero actual de elementos " + modelo.darTamanio() + "\n---------");						
					break;
				case 2: 
					int tam = modelo.darTamanio();
					view.printMessage("La lista tiene un total de: "+tam+" elementos.");
					break;
				case 3:
					view.printMessage("--------- \nPor favor dé el ID del comparendo a buscar");
					String par=lector.next();
					String mensaje = modelo.buscar(par);
					view.printMessage(mensaje);
					break;
				case 4:
					view.printMessage("A continuación la lista:\n");
					modelo.ImprimirLista();
					break;	
				case 5:
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
