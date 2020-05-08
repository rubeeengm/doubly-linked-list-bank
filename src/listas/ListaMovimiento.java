package listas;

import datosBanco.Movimiento;
import javax.swing.JOptionPane;

public class ListaMovimiento {
	private NodoMovimiento inicio, fin;
	
	public ListaMovimiento(){
		inicio = fin = null;
	}
	
	public NodoMovimiento getInicio() {
		return inicio;
	}

	public void setInicio(NodoMovimiento inicio) {
		this.inicio = inicio;
	}

	public NodoMovimiento getFin() {
		return fin;
	}

	public void setFin(NodoMovimiento fin) {
		this.fin = fin;
	}

	//Metodo para saber cuando la lista esta vacia
	public boolean vacio(){
		return inicio == null;
	}
	
	//Metodo para agregar nodos al Final
	public void agregarFinal(Movimiento dato){
		if(!vacio()){
			fin = new NodoMovimiento(dato,null,fin);
			fin.anterior.siguiente = fin;
		}
		
		else{
			inicio = fin = new NodoMovimiento(dato);
		}
	}
	
	//Metodo para agregar al inicio
	public void agregarInicio(Movimiento dato){
		if(!vacio()){
			inicio = new NodoMovimiento(dato,inicio,null);
			inicio.siguiente.anterior = inicio;
		}
		
		else{
			inicio = fin = new NodoMovimiento(dato);
		}
	}
	
	//Metodo para mostrar la lista de Inicio a Fin
	public void imprimirInicioFin(){
		if(!vacio()){
			String datos = "<=>";
			NodoMovimiento aux = inicio;
			
			while(aux != null){
				datos = datos + "["+aux.dato+"]<=>";
				aux = aux.siguiente;
			}
			
			JOptionPane.showMessageDialog(null, datos,"Mostrando Lista de Inicio a Fin",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Metodo para mostrar la lista de Fin a Inicio
	public void imprimirFinInicio(){
		if(!vacio()){
			String datos = "<=>";
			NodoMovimiento aux = fin;
			
			while(aux != null){
				datos = datos + "["+aux.dato+"]<=>";
				aux = aux.anterior;
			}
			
			JOptionPane.showMessageDialog(null, datos,"Mostrando Lista de Inicio a Fin",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	//Metodo para recpuperar el ultimo Nodo
    public Movimiento recuperarFinal(){
    	NodoMovimiento vacio = new NodoMovimiento();
            
        if(!vacio()){
        	NodoMovimiento aux = fin;
			
            while(aux != null){
            	break;
            }
			
            return aux.dato;
        }
            
        else{
        	return vacio.dato;
        }
    }
}
