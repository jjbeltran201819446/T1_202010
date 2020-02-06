package model.data_structures;

import model.logic.Comparendo;

public class ListaEnlazada <T> implements IListaEnlazada <T>


{
	
	private Node<T> primerNodo;
	private int numElementos;
	
	public ListaEnlazada()
	{
		primerNodo=null;
		numElementos=0;
	}
	
	public ListaEnlazada(T cont)
	{
		primerNodo = new Node<T>(cont);
		numElementos=1;
	}
	
	public int darTamanio()
	{
		return numElementos;
	}
	
	public Node <T> darPrimerNodo()
	{
		return primerNodo;
	}
	
	public Node <T> darUltimoNodo()
	{
		Node <T> avance=primerNodo;
		
		while (avance.darSiguiente()!=null)
		{
			avance=avance.darSiguiente();
		}
		
		return avance;
	}
	
	public void agregarAlComienzo(T comparendo)
	{
		Node<T> porAgregar = new Node<T>(comparendo);
		
		if (primerNodo==null)
		{
			primerNodo=porAgregar;
		}
		else
		{
			porAgregar.cambiarSiguiente(primerNodo);
			primerNodo = porAgregar;
		}
		numElementos++;
	}
	
	
	public void agregarAlFinal(T comparendo)
	{
		Node<T> porAgregar=new Node(comparendo);
		Node<T> fin;
		
		if (primerNodo==null)
		{
			primerNodo=porAgregar;
		}
		else
		{
			fin=primerNodo;
			
			while(fin.darSiguiente()!=null)
			{
				fin=fin.darSiguiente();
			}
			fin.cambiarSiguiente(porAgregar);
			numElementos++;	
		}
	}
	
	@Override	
	public void agregarEnCualquierPos(T elemento, int pos) throws Exception 
	{
		// TODO Auto-generated method stub
		Node<T> porAgregar = new Node <T>(elemento);
		Node <T> actual=primerNodo;
		
		
		if (pos<0 || pos > numElementos)
			throw new Exception("El índice dado no está dentro de los límites de la lista");
		
		if (pos ==0)
		{
			agregarAlComienzo(elemento);
		}
		else if (pos == numElementos)
		{
			  agregarAlFinal(elemento);
		}
		else
		{
			for (int i =0;i<pos;i++)
			{
				actual = actual.darSiguiente();
			}
			
			Node<T> anteriorSiguiente = actual.darSiguiente();
			actual.cambiarSiguiente(porAgregar);
			porAgregar.cambiarSiguiente(anteriorSiguiente);
			numElementos++;
			
		}
		
	}

	public void eliminarPrimerElemento()
	{
		if(primerNodo==null)
		{
			//TODO No a ser posible eliminarlo, pero se debe validar
		}
		else
		{
			Node <T> anteriorPrimero= primerNodo;
			primerNodo=primerNodo.darSiguiente();
			anteriorPrimero.cambiarSiguiente(null);
		}
		numElementos--;
	}
	
	public void eliminarUltimoElemento() 
	{
		Node<T> actual = primerNodo;
		while(actual.darSiguiente().darSiguiente()!=null)
		{
			actual=actual.darSiguiente();
		}
		
		actual.cambiarSiguiente(null);
		numElementos--;
	}
	
	@Override
	public void eliminar(int pos) throws Exception
	{
		Node <T> actual= primerNodo;
		if (pos<0 || pos>=numElementos)
			throw new Exception("La posición indicada está fuera del arreglo");
		
		if (pos==0)
		{
			eliminarPrimerElemento();
		}
		else if (pos==numElementos-1)
		{
			eliminarUltimoElemento();
		}
		else
		{
			for (int i=0;i<pos;i++)
			{
				actual=actual.darSiguiente();
			}
			
			Node <T> anteriorSiguiente= actual.darSiguiente();
			Node<T> nuevoSiguiente = anteriorSiguiente.darSiguiente();
			actual.cambiarSiguiente(nuevoSiguiente);
		}

	}


	
}
