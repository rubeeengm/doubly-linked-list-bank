package listas;

import datosBanco.Movimiento;

public class NodoMovimiento {
	public Movimiento dato;
	public NodoMovimiento siguiente;
	public NodoMovimiento anterior;
	
	//Constructor para cuando ya hay nodos
	public NodoMovimiento(Movimiento dato, NodoMovimiento siguiente, NodoMovimiento anterior){
		this.dato = dato;
		this.siguiente = siguiente;
		this.anterior = anterior;
	}
	
	//Constructor para cuando aun no hay nodos
	public NodoMovimiento(Movimiento dato){
		this(dato, null, null);
	}

    public NodoMovimiento() {
    }

	public Movimiento getDato() {
		return dato;
	}

	public void setDato(Movimiento dato) {
		this.dato = dato;
	}

	public NodoMovimiento getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoMovimiento siguiente) {
		this.siguiente = siguiente;
	}

	public NodoMovimiento getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoMovimiento anterior) {
		this.anterior = anterior;
	}  
}