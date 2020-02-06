package model.data_structures;

public class Node <E>
{
	private Node <E> siguiente;
	private E contenido;
	
	public Node (E cont)
	{
		siguiente=null;
		contenido=cont;
	}
	
	public Node<E> darSiguiente()
	{
		return siguiente;
	}
	
	public void cambiarSiguiente(Node<E> nuevoSiguiente)
	{
		siguiente = nuevoSiguiente;
	}
	
	public E darContenido()
	{
		return contenido;
	}
	
	public void modificarContenido(E nuevo)
	{
		contenido=nuevo;
	}
	
}