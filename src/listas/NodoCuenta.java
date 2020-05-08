package listas;

import datosBanco.Cuenta;

public class NodoCuenta {
	public Cuenta dato;
	public NodoCuenta siguiente;
	public NodoCuenta anterior;
	
	//Constructor para cuando ya hay nodos
	public NodoCuenta(Cuenta dato, NodoCuenta siguiente, NodoCuenta anterior){
		this.dato = dato;
		this.siguiente = siguiente;
		this.anterior = anterior;
	}
	
	//Constructor para cuando aun no hay nodos
	public NodoCuenta(Cuenta dato){
		this(dato, null, null);
	}

    public NodoCuenta() {
    }

	public Cuenta getDato() {
		return dato;
	}

	public void setDato(Cuenta dato) {
		this.dato = dato;
	}

	public NodoCuenta getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoCuenta siguiente) {
		this.siguiente = siguiente;
	}

	public NodoCuenta getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoCuenta anterior) {
		this.anterior = anterior;
	}
}