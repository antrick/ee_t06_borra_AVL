package ArbolAVL;
/**
  * @authors Martínez Carrera Dulce Carolina
 * 			Martínez Hernández Gabriela
 * 			Sánchez Lázcares Perla Melina
 * 			Jiménez Rocha Alejandra
 * 
 * Clase NodoAVL<T> que ayudará a crear un ArbolAVL<T>.
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
	 * Constructor del NodoAVL<T> que pide como parámetro el dato.
	 * @param dato
	 */
	public NodoAVL(T dato) {
		this.dato = dato;
		this.izquierda = this.derecha = null;
		fe = 0;
	}
	
	/**
	 * Método que permite obtener el dato del nodo.
	 * @return
	 */
	public T getDato() {
		return dato;
	}
	
	/**
	 * Método que permite modificar el dato.
	 * @param dato
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Método que permite obtener el apuntador del nodo izquierdo.
	 * @return
	 */
	public NodoAVL<T> getIzquierda() {
		return izquierda;
	}
	
	/**
	 * Método que permite cambiar la referencia izquierda del nodo.
	 * @param izquierda
	 */
	public void setIzquierda(NodoAVL<T> izquierda) {
		this.izquierda = izquierda;
	}
	
	/**
	 * Método que permite obtener el apuntador del nodo derecho.
	 * @return
	 */
	public NodoAVL<T> getDerecha() {
		return derecha;
	}
	
	/**
	 * Método que permite cambiar la referencia derecha del nodo.
	 * @param derecha
	 */
	public void setDerecha(NodoAVL<T> derecha) {
		this.derecha = derecha;
	}
	
	/**
	 * Método que permite devolver el valor del factor de equilibrio del nodo.
	 * @return
	 */
	public Integer getFe() {
		return fe;
	}
	
	/**
	 * Método que permite la modificación del factor de equilibrio.
	 * @param fe
	 */
	public void setFe(Integer fe) {
		this.fe = fe;
	}	
	
	/**
	 * Método toString() sobreescrito de la clase Object.
	 * @return
	 */
	@Override
	public String toString(){
		String s = "";
		s += dato;
		return s;
	}
}