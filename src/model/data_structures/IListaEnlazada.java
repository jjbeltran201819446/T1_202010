package model.data_structures;

public interface IListaEnlazada <T> 
{
	//Poner todos los métodos que se vana implementar en la lista enlazada

	public int darTamanio();

	public Node <T> darPrimerNodo();
	
	public void agregarAlComienzo(T elemento);
	
	public void agregarAlFinal(T elemento);
	
	public void agregarEnCualquierPos(T elemento, int pos) throws Exception;
	
	public void eliminar(int pos) throws Exception; 

}
