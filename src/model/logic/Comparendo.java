package model.logic;

public class Comparendo 
{
	
	private String objectId;
	
	private String fecha;
	
	private String medio;
	
	private String claseVeh;
	
	private String tipoServ;
	
	private String infracc;
	
	private String desc;
	
	private String localidad;
	
	public Comparendo(String o, String f, String m, String cv, String ts, String i, String d, String l)
	{
		objectId=o;
		fecha=f;
		medio=m;
		claseVeh=cv;
		tipoServ=ts;
		infracc=i;
		desc=d;
		localidad=l;
	}
	
	public String darObjectID()
	{
		return objectId;
	}
	
	public void cambiarObjectID(String nuevo)
	{
		objectId= nuevo;
	}
	
	public String darFecha()
	{
		return fecha;
	}
	
	public void cambiarFecha(String nuevo)
	{
		fecha= nuevo;
	}
	
	public String darMedio()
	{
		return medio;
	}
	
	public void cambiarMedio(String nuevo)
	{
		medio= nuevo;
	}
	
	public String dartTipoVeh()
	{
		return claseVeh;
	}
	
	public void cambiarTipoVeh(String nuevo)
	{
		claseVeh = nuevo;
	}
	
	public String darTipoServ()
	{
		return tipoServ;
	}
	
	public void cambiarTipoServ(String nuevo)
	{
		tipoServ= nuevo;
	}
	
	public String darInfracc()
	{
		return infracc;
	}
	
	public void cambiarInfracc(String nuevo)
	{
		infracc= nuevo;
	}
	
	public String darDesc()
	{
		return desc;
	}
	
	public void cambiarDesc(String nuevo)
	{
		desc= nuevo;
	}
	
	public String darLocalidad()
	{
		return localidad;
	}
	
	public void cambiarLocalidad(String nuevo)
	{
		fecha= nuevo;
	}
	
}
