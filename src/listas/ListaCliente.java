package listas;

import datosBanco.Cliente;
import javax.swing.JOptionPane;

public class ListaCliente {
	private NodoCliente inicio, fin;
	
	public ListaCliente(){
		inicio = fin = null;
	}
	
	public NodoCliente getInicio() {
		return inicio;
	}

	public void setInicio(NodoCliente inicio) {
		this.inicio = inicio;
	}

	public NodoCliente getFin() {
		return fin;
	}

	public void setFin(NodoCliente fin) {
		this.fin = fin;
	}

	//Metodo para saber cuando la lista esta vacia
	public boolean vacio(){
		return inicio == null;
	}
	
	//Metodo para agregar nodos al Final
	public void agregarFinal(Cliente dato){
		if(!vacio()){
			fin = new NodoCliente(dato,null,fin);
			fin.anterior.siguiente = fin;
		}
		
		else{
			inicio = fin = new NodoCliente(dato);
		}
	}
	
	//Metodo para agregar al inicio
	public void agregarInicio(Cliente dato){
		if(!vacio()){
			inicio = new NodoCliente(dato,inicio,null);
			inicio.siguiente.anterior = inicio;
		}
		
		else{
			inicio = fin = new NodoCliente(dato);
		}
	}
	
	//Metodo para mostrar la lista de Inicio a Fin
	public void imprimirInicioFin(){
		if(!vacio()){
			String datos = "\n";
			NodoCliente aux = inicio;
			
			while(aux != null){
				datos = datos + "["+aux.dato.toString()+"]\n";
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
			NodoCliente aux = fin;
			
			while(aux != null){
				datos = datos + "["+aux.dato+"]<=>";
				aux = aux.anterior;
			}
			
			JOptionPane.showMessageDialog(null, datos,"Mostrando Lista de Inicio a Fin",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
    
	//Metodo para recpuperar el ultimo Nodo
    public Cliente recuperarFinal(){
    	NodoCliente vacio = new NodoCliente();
            
        if(!vacio()){
        	NodoCliente aux = fin;
			
            while(aux != null){
            	break;
            }
			
            return aux.dato;
        }
            
        else{
        	return vacio.dato;
        }
    }
    
    //Metodo para recuperar cualquier nodo en especifico
    public Cliente recuperarCliente(int cuenta){
         Cliente cliente = new Cliente();
         
         if (inicio != null){
        	 NodoCliente aux = inicio;
                                  
             while (aux != null){
            	 if (aux.getDato().getCuenta().getNumCta() == cuenta ){
            		 cliente = aux.getDato();
                         break;
            	 }
                 
            	 aux = aux.getSiguiente();
             }                     
         }
          
         return cliente;
     }
    
    //Metodo para imprimir los nodos
    public void imprimir(){
		if(!vacio()){
			NodoCliente aux = inicio;
			
			while(aux != null){
				aux.dato.imprimir();
				aux = aux.siguiente;
			}
		}
	}
    
    //Busca un nodo especifico
    public boolean buscar(int cuenta){
        boolean resp = false;
         
        if (inicio != null){
        	NodoCliente aux = inicio;
                                  
            while (aux != null){
            	if (aux.getDato().getCuenta().getNumCta() == cuenta ){
            		resp = true;
            	}
                 
            	aux = aux.getSiguiente();
            }                     
        }
          
        return resp;
    }
     
     
    public void eliminaValor(Integer valor){
    	if (inicio != null){
    		NodoCliente aux = inicio;
            NodoCliente ant = null;
             
            while (aux != null){
            	if (aux.getDato().getCuenta().getNumCta() == valor ){
            		if (ant == null){
            			inicio = inicio.getSiguiente();
                        aux.setSiguiente(null);
                        aux= inicio;
            		}
            		 
            		else { 
                        ant.setSiguiente(aux.getSiguiente());
                        aux.setSiguiente(null);
                        aux = ant.getSiguiente();
                    }  
                }
            	 
            	else{
                    ant = aux;
                    aux = aux.getSiguiente();
                }
            }
        }                       
    }
}
