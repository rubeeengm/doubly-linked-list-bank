package banco;

import datosBanco.Cliente;
import datosBanco.Movimiento;
import datosBanco.Cuenta;
import listas.NodoCliente;
import listas.NodoCuenta;
import listas.ListaCuenta;
import listas.ListaCliente;
import listas.ListaMovimiento;
import listas.NodoMovimiento;
import java.util.Random;
import javax.swing.JOptionPane;

public class Principal {
    ListaCliente clientes;
    ListaCuenta cuentas;
    ListaMovimiento movimientos;
    int password = 1234567;

    public Principal(){
    	clientes = new ListaCliente();		//Lista donde se guardaran los clientes
    	cuentas = new ListaCuenta();		//Lista donde se guardan las cuentas
    	movimientos = new ListaMovimiento();	//Lista donde se guardan los movimientos
    }
    
    public static void main(String[] args){
	Principal p = new Principal();
	int opc = 0;	//Se almacena la opcion deseada
	
        do{
            try{
        	opc = Integer.parseInt(JOptionPane.showInputDialog(null,"1.Registrar cliente\n"
                        + "2.Realizar movimientos\n"
                        + "3.Borrar Clientes\n"
                        + "4.Listar Clientes\n"
                        + "5.Salir\n\n"
                        + "Ingrese la opcion deseada: ","Banco",JOptionPane.INFORMATION_MESSAGE));
            
        	switch(opc){
                    case 1:
                	p.altaCliente();
                    break;
                    
                    case 2:
                	p.movimiento();
                    break;
                	
                    case 3:
                	p.borrar();
                    break;
                		
                    case 4:
                	p.listarMovimientos();
                    break;
                    
                    case 5:
                	JOptionPane.showMessageDialog(null,"Bye!");
                    break;
                    
                    default:
                	JOptionPane.showMessageDialog(null,"La opcion ingresada no se encuentra en el menu,"
                				+ " verificala por favor");
                	break;
                    }
            }catch(NumberFormatException e){
        	JOptionPane.showMessageDialog(null,"Error "+e.getMessage());
            }
        }while(opc != 5);
    }
    
    public void altaCliente(){
    	Random r = new Random();
    	Boolean salir;
    	double saldo;
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre: ");
        String apellido = JOptionPane.showInputDialog("Ingrese su apellido: ");
        int nCta = r.nextInt()*1000000;
        int nip = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el NIP que desea utilizar: "));
        
        do{
            salir = false;
            saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el saldo con el que desea dar de alta su cuenta: "));
            
            if(saldo>=1000){
                cuentas.agregarFinal(new Cuenta(nCta,0.00,nip));
                clientes.agregarFinal(new Cliente(nombre,apellido,(Cuenta)cuentas.recuperarFinal()));
                movimientos.agregarFinal(new Movimiento((Cliente)clientes.recuperarFinal(),"Apertura de la cuenta",saldo));
                JOptionPane.showMessageDialog(null, clientes.recuperarFinal().toString());
                JOptionPane.showMessageDialog(null,"Cliente registrado con exito!");
                salir = true;
            }
        
            else{
            	JOptionPane.showMessageDialog(null,"El saldo minimo con el que se puede abrir una cuenta es de $1000");
            }
        }while(!salir);
    }
    
    public void movimiento(){
        String tipoMov;
        double monto;
        int nCta;
        Boolean continuar = false;
        int intento = 0;
        NodoCuenta cta = cuentas.getInicio();
        
        if(!clientes.vacio()){
            do{
        	intento++;
        	nCta = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu numero de cuenta: "));

        	if(clientes.buscar(nCta)&& intento<5){
                    continuar = true;
        	}
        		
        	else{
                    JOptionPane.showMessageDialog(null,"El numero de cuenta ingresado no existe, verfiquelo por favor");
        	}
            }while(!continuar && intento < 5);
        	
            if(continuar){
        	intento = 0;
        	continuar = false;
            
        	do{ 
                    intento++;
                    int nip = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu nip: "));
                
                    while(cta != null){
        		if(cta.dato.getNip() == nip){
                            continuar = true;
                            break;
        		}
        				
                        cta = cta.siguiente;
                    }
        
                    if(continuar == false && intento<5){
        		JOptionPane.showMessageDialog(null,"El PIN es incorrecto, verfiquelo por favor");
                    }	
        	}while(!continuar && intento < 5);
        		
        	if(!continuar){
                    JOptionPane.showMessageDialog(null,"Sobrepasaste el numero de intentos");
        	}
            }
        	
            else{
        	JOptionPane.showMessageDialog(null,"Sobrepasaste el numero de intentos");
            }
        	
            if(continuar){
        	String salidaD = "";
        	Cliente cliente = clientes.recuperarCliente(nCta);
        	salidaD = salidaD+"Titular: "+cliente.getNombre()+" "+cliente.getApellido()+"\n"+"Cuenta:"+cliente.getCuenta()+"\n"+"Saldo: $"+cliente.getCuenta().getSaldo();
        	JOptionPane.showMessageDialog(null,salidaD);
            
        	do{
                    tipoMov = JOptionPane.showInputDialog("TIpo de movimiento (R/D): ");
                    continuar = false;
                
                    if("D".equals(tipoMov) || "d".equals(tipoMov)){
        		continuar = true;
                    }
        
                    else{
        		if("R".equals(tipoMov) || "r".equals(tipoMov)){
                            continuar = true;
        		}
            
                        else{
                            JOptionPane.showMessageDialog(null, "Opcion ingresada erronea, verificala por favor");
        		}
                    }   
        	}while(continuar == false);
            
        	do{ 
                    monto = Integer.parseInt(JOptionPane.showInputDialog("Monto: "));
                    continuar = false;
                
                    switch(tipoMov){
                	case "R":
                	case "r":
                            if(monto<0){
                		JOptionPane.showMessageDialog(null,"El monto ingresado es erroneo, verifiquelo por favor");
                            }
                		
                            else{
                		if(monto > cliente.getCuenta().getSaldo()){
                                    JOptionPane.showMessageDialog(null,"No se puede sacar mas dinero del que se tiene en la cuenta");
                		}
                			
                		else{
                                    movimientos.agregarFinal(new Movimiento(cliente, tipoMov, monto));
                                    continuar = true;
                                    JOptionPane.showMessageDialog(null,"Transaccion realizada con exito!");
                                }	
                            }	
                	break;
                		
                        case "D":
                	case "d":
                            if(monto<0){
                		JOptionPane.showMessageDialog(null,"El monto ingresado es erroneo verifiquelo por favor");
                            }	
                		
                            else{
                		movimientos.agregarFinal(new Movimiento(cliente, tipoMov, monto));
                		continuar = true;
                		JOptionPane.showMessageDialog(null,"Transaccion realizada con exito!");
                            }
                	break;
                    }    
        	}while(!continuar);
            }
    	}	
    	
        else{
            JOptionPane.showMessageDialog(null,"Aun no se han registrado clientes");
        }
    }
    
    public void borrar(){
        if(!clientes.vacio()){
            int nCta = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero de cuenta que desees eliminar"));
    		
            if(clientes.buscar(nCta)){
                int clave = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la contrase�a de administrador"));
    			
                if(clave == password){
                    clientes.eliminaValor(nCta);
                    JOptionPane.showMessageDialog(null,"Cuenta eliminada con exito");
                }
    			
                else{
                    JOptionPane.showMessageDialog(null,"Contrase�a incorrecta verificala por favor");
                }
            }
    		
            else{
    		JOptionPane.showMessageDialog(null, "El numero de cuenta ingresado no existe");
            }
        }
    	
        else{
            JOptionPane.showMessageDialog(null,"Aun no se an registrado clientes");
        }
    }
    
    public void listarMovimientos(){
        if(!clientes.vacio()){
            String datos = "\n";
            NodoCliente aux = clientes.getInicio();
			
            while(aux != null){
		datos = datos + "\n["+aux.dato.toString()+"]\n";
		
                if(!movimientos.vacio()){
                    NodoMovimiento mov = movimientos.getInicio();
					
                    while(mov != null){
			if((aux.getDato().getCuenta()) == (mov.getDato().getCliente().getCuenta()))
                            datos = datos + "["+mov.getDato().toString()+"]\n";
                            mov = mov.siguiente;
                    }
		}
                
                aux = aux.siguiente;
            }
			
            JOptionPane.showMessageDialog(null, datos);
        }
    	
        else{
            JOptionPane.showMessageDialog(null, "Aun no se han registrado clientes");
        }
    }
}