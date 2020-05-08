package listas;

import datosBanco.Cliente;

public class NodoCliente {
	public Cliente dato;
	public NodoCliente siguiente;
	public NodoCliente anterior;
	
	//Constructor para cuando ya hay nodos
	public NodoCliente(Cliente dato, NodoCliente siguiente, NodoCliente anterior){
		this.dato = dato;
		this.siguiente = siguiente;
		this.anterior = anterior;
	}
	
	//Constructor para cuando aun no hay nodos
	public NodoCliente(Cliente dato){
		this(dato, null, null);
	}

    public NodoCliente() {
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public NodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCliente getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCliente anterior) {
        this.anterior = anterior;
    }
}