package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.sun.javafx.scene.paint.GradientUtils.Parser;

import model.data_structures.ListaEnlazada;
import model.data_structures.Node;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo<T> 
{
	private ListaEnlazada<Comparendo> lista;
	
	private Comparendo porAgregar;
	
	private String componente;
	
	private String objectId;
	
	private String fecha;
	
	private String medio;
	
	private String claseVeh;
	
	private String tipoServ;
	
	private String infracc;
	
	private String desc;
	
	private String localidad;
	
	
	
	public Modelo()
	{
		lista = new ListaEnlazada<>();
		porAgregar = new Comparendo("","","","","","","","");
		componente="";
	}
	
	public int darTamanio()
	{
		return lista.darTamanio();
	}
	
	
	public void leerJson(String ruta)
	{
		FileReader fr=null;
		JsonParser parsero= new JsonParser();
		
		try
		{
			fr= new FileReader(ruta);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JsonElement info=parsero.parse(fr);
		dumpJSONElement(info);
	}
	
	
	
	private void dumpJSONElement(JsonElement elemento) 
	{
		
		if (elemento.isJsonObject()) 
		{
			
	        JsonObject obj = elemento.getAsJsonObject();
	        
	        java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
	        java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
	        
	        while (iter.hasNext()) 
	        {
	            java.util.Map.Entry<String,JsonElement> entrada = iter.next();
	            parteComparendo(entrada.getKey());	            

	            dumpJSONElement(entrada.getValue());
	        }

	    }
		else if (elemento.isJsonArray()) 
		{			
	        JsonArray array = elemento.getAsJsonArray();
	        java.util.Iterator<JsonElement> iter = array.iterator();
	        
	        while (iter.hasNext()) 
	        {
	            JsonElement entrada = iter.next();
	            dumpJSONElement(entrada);
	        }

	    } 
		else if (elemento.isJsonPrimitive()) 
		{
	        JsonPrimitive valor = elemento.getAsJsonPrimitive();
	        
	        if(componente.equals("OBJECTID"))
	        {
	        	objectId = valor.getAsString();
	        	System.out.println(valor);
	        }
	        else if (componente.equals("FECHA_HORA"))
			{
	        	fecha = valor.getAsString();
				System.out.println(valor);
			}
			else if (componente.equals("MEDIO_DETE"))
			{
				medio = valor.getAsString();
				System.out.println(valor);
			}
			else if (componente.equals("CLASE_VEHI"))
			{
				claseVeh = valor.getAsString();
				System.out.println(valor);
			}
			else if (componente.equals("TIPO_SERVI"))
			{
				tipoServ = valor.getAsString();
				System.out.println(valor);
			}
			else if (componente.equals("INFRACCION"))
			{
				infracc = valor.getAsString();
				System.out.println(valor);
			}
			else if (componente.equals("DES_INFRAC"))
			{
				desc = valor.getAsString();
				System.out.println(valor);
				
			}
			else if (componente.equals("LOCALIDAD"))
			{				
				localidad = valor.getAsString();
				Comparendo llegado = new Comparendo(objectId, fecha, medio, claseVeh, tipoServ, infracc, desc, localidad);
				
				lista.agregarAlComienzo(llegado);
				System.out.println(llegado.darObjectID());
				componente = "";
				
				System.out.println(valor);
				System.out.println("---------------");
			}
	    } 
		else if (elemento.isJsonNull()) 
		{
	        System.out.println("Es vacío");
	    } 
		else 
		{
	        System.out.println("No corresponde al valor esperado");
	    }
		
	}

	public void parteComparendo(String palabra)
	{
		if (palabra.equals("OBJECTID"))
		{
			componente = "OBJECTID";
		}
		else if (palabra.equals("FECHA_HORA"))
		{
			componente = "FECHA_HORA";
		}
		else if (palabra.equals("MEDIO_DETE"))
		{
			componente= "MEDIO_DETE";
		}
		else if (palabra.equals("CLASE_VEHI"))
		{
			componente = "CLASE_VEHI";
		}
		else if (palabra.equals("TIPO_SERVI"))
		{
			componente = "TIPO_SERVI";
		}
		else if (palabra.equals("INFRACCION"))
		{
			componente = "INFRACCION";
		}
		else if (palabra.equals("DES_INFRAC"))
		{
			componente = "DES_INFRAC";
		}
		else if (palabra.equals("LOCALIDAD"))
		{
			componente = "LOCALIDAD";
		}
	}
	
	
	public String buscar (String identificador)
	{
		Node<Comparendo> avance = (Node<Comparendo>) lista.darPrimerNodo();
		String respuesta = "";
		
		for (int i=0;i<lista.darTamanio();i++)
		{
			if (avance.darContenido().darObjectID().equals(identificador))
			{
				respuesta = "A continuación se presenta la información del comparendo: \nId: " 
				+avance.darContenido().darObjectID()+"\nFecha: "
				+avance.darContenido().darFecha()+"\nMedio: "
				+avance.darContenido().darMedio()+"\nTipo de Vehículo: "
				+avance.darContenido().dartTipoVeh()+"\nTipo de Servicio: "
				+avance.darContenido().darTipoServ()+"\nInfracción: "
				+avance.darContenido().darInfracc()+"\nDescripción: "
				+avance.darContenido().darDesc();
			}
			
			avance=avance.darSiguiente();
		}
		
		if (respuesta=="")
			respuesta="No se encontró el elemento buscado";
			
		return respuesta;
	}
	
	public void ImprimirLista()
	{
		Node <Comparendo> avance = (Node<Comparendo>)lista.darPrimerNodo();
		
		for (int i=0;i<lista.darTamanio();i++)
		{
			System.out.println("Id: "+avance.darContenido().darObjectID());
			System.out.println("Fecha: "+avance.darContenido().darObjectID());
			System.out.println("Medio: "+avance.darContenido().darMedio());
			System.out.println("Tipo de Vehículo: "+avance.darContenido().dartTipoVeh());
			System.out.println("Tipo de Servicio: "+avance.darContenido().darTipoServ());
			System.out.println("Infracción: "+avance.darContenido().darInfracc());
			System.out.println("Descripción: "+avance.darContenido().darDesc());
			System.out.println("------------------------------------------");
			avance=avance.darSiguiente();
		}
	}

}
