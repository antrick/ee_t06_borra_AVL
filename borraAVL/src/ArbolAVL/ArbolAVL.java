package ArbolAVL;

/**
 * @authors Le�n Felipe Villavicencio Fern�ndez
 * 
 * Clase que permite crear un �rbol balanceado AVL(Adelson-Velskii-Landis).
 * @param <T>
 */
public class ArbolAVL<T extends Comparable<T>>{
	/**
	 * Atributo de la clase.
	 */
    NodoAVL<T> raiz;
    
    /**
     * Constructor del �rbol AVL.
     */
    public ArbolAVL() {
    	this.raiz = null;
	}
    
    /**
     * M�todo que retorna la ra�z del �rbol AVL.
     * @return
     */
    public NodoAVL<T> getRaiz() {
		return raiz;
	}

    /**
     * M�todo que modifica la ra�z del �rbol AVL.
     * @param raiz
     */
	public void setRaiz(NodoAVL<T> raiz) {
		this.raiz = raiz;
	}

	/**
	 * M�todo que permite revisar la rama izquierda del �rbol.
	 * @param nodo
	 * @param direccion
	 */
	public void revisarI(NodoAVL<T> nodo, Integer direccion){
        NodoAVL<T> nodo1, nodo2, nodo3;
        if (direccion ==-1){
          nodo1=(NodoAVL<T>) nodo.getIzquierda();
          nodo2=(NodoAVL<T>) nodo1.getIzquierda();
        }else{
          nodo1=(NodoAVL<T>) nodo.getDerecha();
          nodo2=(NodoAVL<T>) nodo1.getIzquierda();    
        }
        if(nodo2.getFe() == -1){// Rotacion II
            nodo1.setIzquierda(nodo2.getDerecha());
            nodo2.setDerecha(nodo1);
            nodo1.setFe(0);
            if (direccion == -1){
                nodo.setIzquierda(nodo2);
            }else{
                nodo.setDerecha(nodo2); 
            }
        }else{ // Rotacion ID
            nodo3 = (NodoAVL<T>) nodo2.getDerecha();
            nodo1.setIzquierda(nodo3.getDerecha());
            nodo3.setDerecha(nodo1);
            nodo2.setDerecha(nodo3.getIzquierda());
            nodo3.setIzquierda(nodo2);
            if(nodo3.getFe() == -1){
                nodo1.setFe(1);
            }else{
                nodo1.setFe(0);
            }
            if (nodo3.getFe() == 1){
                nodo2.setFe(-1);
            }else{
                nodo2.setFe(0);
            }
            if (direccion == -1){
                nodo.setIzquierda(nodo3);
            }else{
                nodo.setDerecha(nodo3); 
            }
            
        }
        nodo1.setFe(0);
    }
    
	/**
	 * M�todo que permite revisar la rama derecha del �rbol.
	 * @param nodo
	 * @param direccion
	 */
    public void revisarD(NodoAVL<T> nodo, Integer direccion){
        NodoAVL<T> nodo1, nodo2, nodo3;
        if (direccion ==-1){
            nodo1=  nodo.getIzquierda();
            nodo2=  nodo1.getDerecha();
        }else{
            nodo1=  nodo.getDerecha();
            nodo2=  nodo1.getDerecha();
        }
        if(nodo2.getFe() == 1){// Rotacion DD
            nodo1.setDerecha(nodo2.getIzquierda());
            nodo2.setIzquierda(nodo1);
            nodo1.setFe(0);
            if (direccion == -1){
                nodo.setIzquierda(nodo2);
            }else{
                nodo.setDerecha(nodo2); 
            }
            
            
        }else{ // Rotacion DI
            nodo3 = (NodoAVL<T>) nodo2.getIzquierda();
            nodo1.setDerecha(nodo3.getIzquierda());
            nodo3.setIzquierda(nodo1);
            nodo2.setIzquierda(nodo3.getDerecha());
            nodo3.setDerecha(nodo2);
            if(nodo3.getFe() == 1){
                nodo1.setFe(-1);
            }else{
                nodo1.setFe(0);
            }
            if (nodo3.getFe() == -1){
                nodo2.setFe(1);
            }else{
                nodo2.setFe(0);
            }
            if (direccion == -1){
                nodo.setIzquierda(nodo3);
            }else{
                nodo.setDerecha(nodo3); 
            }
            
        }
        nodo1.setFe(0);
    }
    
    /**
     * M�todo auxiliar de inserci�n.
     * @param nodo
     * @param dato
     * @return
     */
    private Integer _insertar(NodoAVL<T> nodo, T dato){
        Integer resultado = 0;
        if (dato.compareTo(nodo.getDato()) < 0){
            if (nodo.getIzquierda() == null){
                nodo.setIzquierda(new NodoAVL<T>(dato));
                switch ( (nodo).getFe()){
                case 1: // El arbol se balance�
                     (nodo).setFe(0);
                    resultado = 0;
                    break;
                case 0: // Se carg� del lado izquierdo
                     (nodo).setFe(-1);
                    resultado = 1;
                    break;              
                }
                //resultado = 1;
                
            }else{
                switch (_insertar(nodo.getIzquierda(),dato)){
                case 1: // Se insrt� un dato nuevo, revisar.
                    switch ( (nodo).getFe()){
                    case 1: // El arbol se balance�
                         (nodo).setFe(0);
                        resultado = 0;
                        break;
                    case 0: // Se carg� del lado izquierdo
                         (nodo).setFe(-1);
                        resultado = 1;
                        break;  
                    case -1: // Reestructuracion del arbol
                        //if (nodo == raiz){
                            resultado = -1;
                        //}else{                        
                            
                            
                            
                        //}
                        break;
                    }
                    break;
                case -1:
                    revisarI( (nodo),-1);
                    break;
                case -2:
                    revisarD( (nodo),-1);
                    break;
                }
            }
        }else{
            if (dato.compareTo(nodo.getDato()) > 0){
                if (nodo.getDerecha() == null){
                    nodo.setDerecha(new NodoAVL<T>(dato));
                    switch ( (nodo).getFe()){
                    case -1: // El arbol se balance�
                         (nodo).setFe(0);
                        resultado = 0;
                        break;
                    case 0: // Se carg� del lado izquierdo
                         (nodo).setFe(1);
                        resultado = 1;
                        break;              
                    }
                }else{
                    switch (_insertar(nodo.getDerecha(),dato)){
                    case 1: // Se insrt� un dato nuevo, revisar.
                        switch ( (nodo).getFe()){
                        case -1: // El arbol se balance�
                             (nodo).setFe(0);
                            resultado = 0;
                            break;
                        case 0: // Se carg� del lado der
                             (nodo).setFe(1);
                            resultado = 1;
                            break;  
                        case 1: // Reestructuracion del arbol
                                resultado = -2;
                            }
                            break;
                    case -1:
                        revisarI( (nodo),1);
                        break;
                    case -2:
                        revisarD( (nodo),1);
                    break;
                    
                        }                       
                        
                    }
                }
            }
        return resultado;
   }
    
   /**
    * M�todo que permite insertar valores en el �rbol AVL.   
    * @param dato
    * @return
    */
    public Integer insertar(T dato) {
        if (raiz == null){
            raiz = new NodoAVL<T>(dato);
        }else{
            Integer result = _insertar(raiz, dato);
            if (result == -1){
            
                // Reestructuraci�n del arbol
                    NodoAVL<T> nodo1, nodo2;
                    nodo1=  raiz.getIzquierda();
                    
                    if(nodo1.getFe() == -1){// Rotacion II
                        raiz.setIzquierda(nodo1.getDerecha());
                        nodo1.setDerecha(raiz);
                         (raiz).setFe(0);
                        raiz = nodo1;
                    }else{ // Rotacion ID
                        nodo2 = (NodoAVL<T>) nodo1.getDerecha();
                        raiz.setIzquierda(nodo2.getDerecha());
                        nodo2.setDerecha(raiz);
                        nodo1.setDerecha(nodo2.getIzquierda());
                        nodo2.setIzquierda(nodo1);
                        if(nodo2.getFe() == -1){
                             (raiz).setFe(1);
                        }else{
                             (raiz).setFe(0);
                        }
                        if (nodo2.getFe() == 1){
                            nodo1.setFe(-1);
                        }else{
                            nodo1.setFe(0);
                        }
                        raiz = nodo2;
                    }
                     (raiz).setFe(0);
            
            }else if (result == -2){
                // Reestructuraci�n del arbol
                NodoAVL<T> nodo1, nodo2;
                nodo1=  raiz.getDerecha();
                
                if(nodo1.getFe() == 1){// Rotacion DD
                    raiz.setDerecha(nodo1.getIzquierda());
                    nodo1.setIzquierda(raiz);
                     (raiz).setFe(0);
                    raiz = nodo1;
                }else{ // Rotacion DI
                    nodo2 = (NodoAVL<T>) nodo1.getIzquierda();
                    raiz.setDerecha(nodo2.getIzquierda());
                    nodo2.setIzquierda(raiz);
                    nodo1.setIzquierda(nodo2.getDerecha());
                    nodo2.setDerecha(nodo1);
                    if(nodo2.getFe() == 1){
                         (raiz).setFe(-1);
                    }else{
                         (raiz).setFe(0);
                    }
                    if (nodo2.getFe() == -1){
                        nodo1.setFe(1);
                    }else{
                        nodo1.setFe(0);
                    }
                    raiz = nodo2;
                    
                }
                
                 (raiz).setFe(0);
        
            }
        }
        return 0;
    }
	
    /**
     * M�todo toString() sobreescrito de la clase Object.
     */
	@Override
	public String toString() {
		String s = "";
		s += raiz.getDato();
		return s;
	}
	
	public void eliminar(T dato){
		eliminaBalanceado(raiz, dato);
	}
	
	public void eliminaBalanceado(NodoAVL<T> raiz, T dato){
		NodoAVL<T> otro;
		Boolean bo = false;
		if(raiz != null){
			if(dato.compareTo(raiz.getDato()) < 0){
				eliminaBalanceado(raiz.getIzquierda(), dato);
				restructura1(raiz, bo);
			}else{
				if(dato.compareTo(raiz.getDato()) > 0){
					eliminaBalanceado(raiz.getDerecha(), dato);
					restructura2(raiz,bo);
				}else{
					otro = raiz;
					if(otro.getDerecha() == null){
						raiz = otro.getIzquierda();
					}else{
						if(otro.getIzquierda() == null){
							raiz = otro.getDerecha();
						}else{
							borra(otro.getIzquierda(),otro,bo);
							restructura1(raiz, bo);							
						}
					}
				}
			}
		}else{
			System.out.println("El nodo no se encuentra en el �rbol");
		}
//		return otro;
	}
	
	public void restructura1(NodoAVL<T> raiz, Boolean bo){
		NodoAVL<T> nodo1, nodo2;
		if(bo){
			switch(raiz.getFe()){
				case -1: raiz.setFe(0);
						 break;
				case 0: raiz.setFe(1);
						bo = false;
						break;
				case 1: //restructuraci�n del �rbol
						nodo1 = raiz.getDerecha();
						if(nodo1.getFe() == 0){ //Rotaci�n DD
							raiz.setDerecha(nodo1.getIzquierda());
							nodo1.setIzquierda(raiz);
							switch(nodo1.getFe()){
								case 0: raiz.setFe(1);
										nodo1.setFe(-1);
										bo = false;
										break;
								case 1: raiz.setFe(0);
										nodo1.setFe(0);
										break;
							}
							raiz = nodo1;
							//Termina la rotaci�n DD
						}else{ //Rotaci�n DI
							nodo2 = nodo1.getIzquierda();
							raiz.setDerecha(nodo2.getIzquierda());
							nodo2.setIzquierda(raiz);
							nodo1.setIzquierda(nodo2.getDerecha());
							if(nodo2.getFe() == 1){
								raiz.setFe(-1);
							}else{
								raiz.setFe(0);
							}
							
							if(raiz.getFe() == -1){
								nodo1.setFe(1);
							}else{
								nodo1.setFe(0);
							}
							raiz = nodo2;
							nodo2.setFe(0);
							//Termina la rotaci�n DI
						}
			}
		}
	}
	
	public void restructura2(NodoAVL<T> raiz, Boolean band){
		NodoAVL<T> nodo1, nodo2;
		if(band){
			switch(raiz.getFe()){
				case 1: raiz.setFe(0);
						break;
				case 0: raiz.setFe(-1);
						band = false;
						break;
				case -1: //Restructuraci�n del �rbol
						nodo1 = raiz.getIzquierda();
						if(raiz.getFe() <= 0){ //Rotaci�n II
							raiz.setIzquierda(nodo1.getDerecha());
							nodo1.setDerecha(raiz);
							switch(nodo1.getFe()){
								case 0: raiz.setFe(-1);
										nodo1.setFe(1);
										band = false;
										break;
								case 1: raiz.setFe(0);
								nodo1.setFe(0);
							}
							raiz = nodo1;
							//Termina la rotaci�n II
						}else{ //Rotaci�n ID
							nodo2 = nodo1.getDerecha();
							raiz.setIzquierda(nodo2.getDerecha());
							nodo2.setDerecha(raiz);
							nodo1.setDerecha(nodo2.getIzquierda());
							nodo2.setIzquierda(nodo1);
							if(nodo2.getFe() == -1){
								raiz.setFe(1);
							}else{
								raiz.setFe(0);
							}
							
							if(nodo2.getFe() == 1){
								nodo1.setFe(-1);
							}else{
								nodo1.setFe(0);
							}
							raiz = nodo2;
							nodo2.setFe(0);							
						}//Termina la rotaci�n ID
			}
		}
	}
	
	public void borra(NodoAVL<T> aux, NodoAVL<T> otro, Boolean band){
		if(aux.getDerecha() != null){
			borra(aux.getDerecha(), otro, band);
			restructura2(aux, band);
		}else{
			otro.setDato(aux.getDato());
			aux = aux.getIzquierda();
			band = true;
		}
	}
	
	 public static void main(String[] args) {
			ArbolAVL<Integer> prueba = new ArbolAVL<Integer>();
			prueba.insertar(86);
			prueba.insertar(65);
			prueba.insertar(70);
			prueba.insertar(67);
			prueba.insertar(73);
			prueba.insertar(93);
			prueba.insertar(69);
			prueba.insertar(25);
			prueba.insertar(66);
			prueba.insertar(68);
			prueba.insertar(47);
			prueba.insertar(62);
			prueba.insertar(10);
			prueba.insertar(60);
			BTreePrinter.printNode(prueba.getRaiz());
			
			prueba.eliminaBalanceado(prueba.getRaiz(), 25);
			BTreePrinter.printNode(prueba.getRaiz());
		}
}