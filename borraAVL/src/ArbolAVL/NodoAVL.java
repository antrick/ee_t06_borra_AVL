package ArbolAVL;
/**
  * @authors Mart�nez Carrera Dulce Carolina
 * 			Mart�nez Hern�ndez Gabriela
 * 			S�nchez L�zcares Perla Melina
 * 			Jim�nez Rocha Alejandra
 * 
 * Clase NodoAVL<T> que ayudar� a crear un ArbolAVL<T>.
 * @param <T>
 */
public class NodoAVL<T extends Comparable<T>> {
	/**
	 * Atributos de la clase NodoAVL<T>.
	 */
	T dato;
	NodoAVL<T> izquierda, derecha;
	Integer fe;
	
	/**
	 * Constructor del NodoAVL<T> que pide como par�metro el dato.
	 * @param dato
	 */
	public NodoAVL(T dato) {
		this.dato = dato;
		this.izquierda = this.derecha = null;
		fe = 0;
	}
	
	/**
	 * M�todo que permite obtener el dato del nodo.
	 * @return
	 */
	public T getDato() {
		return dato;
	}
	
	/**
	 * M�todo que permite modificar el dato.
	 * @param dato
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * M�todo que permite obtener el apuntador del nodo izquierdo.
	 * @return
	 */
	public NodoAVL<T> getIzquierda() {
		return izquierda;
	}
	
	/**
	 * M�todo que permite cambiar la referencia izquierda del nodo.
	 * @param izquierda
	 */
	public void setIzquierda(NodoAVL<T> izquierda) {
		this.izquierda = izquierda;
	}
	
	/**
	 * M�todo que permite obtener el apuntador del nodo derecho.
	 * @return
	 */
	public NodoAVL<T> getDerecha() {
		return derecha;
	}
	
	/**
	 * M�todo que permite cambiar la referencia derecha del nodo.
	 * @param derecha
	 */
	public void setDerecha(NodoAVL<T> derecha) {
		this.derecha = derecha;
	}
	
	/**
	 * M�todo que permite devolver el valor del factor de equilibrio del nodo.
	 * @return
	 */
	public Integer getFe() {
		return fe;
	}
	
	/**
	 * M�todo que permite la modificaci�n del factor de equilibrio.
	 * @param fe
	 */
	public void setFe(Integer fe) {
		this.fe = fe;
	}	
	
	/**
	 * M�todo toString() sobreescrito de la clase Object.
	 * @return
	 */
	@Override
	public String toString(){
		String s = "";
		s += dato;
		return s;
	}
}