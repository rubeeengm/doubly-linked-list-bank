package listas;

import datosBanco.Cuenta;
import javax.swing.JOptionPane;

public class ListaCuenta {
	private NodoCuenta inicio, fin;
	
	public ListaCuenta(){
		inicio = fin = null;
	}
	
	public NodoCuenta getInicio() {
		return inicio;
	}

	public void setInicio(NodoCuenta inicio) {
		this.inicio = inicio;
	}

	public NodoCuenta getFin() {
		return fin;
	}

	public void setFin(NodoCuenta fin) {
		this.fin = fin;
	}

	//Metodo para saber cuando la lista esta vacia
	public boolean vacio(){
		return inicio == null;
	}
	
	//Metodo para agregar nodos al Final
	public void agregarFinal(Cuenta dato){
		if(!vacio()){
			fin = new NodoCuenta(dato,null,fin);
			fin.anterior.siguiente = fin;
		}
		
		else{
			inicio = fin = new NodoCuenta(dato);
		}
	}
	
	//Metodo para agregar al inicio
	public void agregarInicio(Cuenta dato){
		if(!vacio()){
			inicio = new NodoCuenta(dato,inicio,null);
			inicio.siguiente.anterior = inicio;
		}
		
		else{
			inicio = fin = new NodoCuenta(dato);
		}
	}
	
	//Metodo para mostrar la lista de Inicio a Fin
	public void imprimirInicioFin(){
		if(!vacio()){
			String datos = "<=>";
			NodoCuenta aux = inicio;
			
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
			NodoCuenta aux = fin;
			
			while(aux != null){
				datos = datos + "["+aux.dato+"]<=>";
				aux = aux.anterior;
			}
			
			JOptionPane.showMessageDialog(null, datos,"Mostrando Lista de Inicio a Fin",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
      
    
	//Metodo para recpuperar el ultimo Nodo
    public Cuenta recuperarFinal(){
    	NodoCuenta vacio = new NodoCuenta();
            
        if(!vacio()){
        	NodoCuenta aux = fin;
			
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
