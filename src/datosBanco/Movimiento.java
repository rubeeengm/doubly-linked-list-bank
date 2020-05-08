package datosBanco;

public class Movimiento {
    private Cliente Cliente;
    private String tipoMov;
    private double importe;

    public Movimiento() {
    }

    public Movimiento(Cliente Cliente, String tipoMov, double importe) {
        this.Cliente = Cliente;
        this.tipoMov = tipoMov;
        this.importe = importe;
        
        if("Apertura de la cuenta".equals(tipoMov)){
            this.Cliente.getCuenta().depositar(importe);
        }
        
        if("D".equals(tipoMov) || "d".equals(tipoMov)){
            this.Cliente.getCuenta().depositar(importe);
            this.tipoMov = "Deposito";
        }
        
        else{
            if("R".equals(tipoMov) || "r".equals(tipoMov)){
                this.Cliente.getCuenta().retirar(importe);
                this.tipoMov = "Retiro";
            }       
        }
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "|Tipo de movimiento: "+tipoMov+"|----|Importe: $"+importe+"|";
    }
    
    public void imprimir(){
        System.out.println(toString());
    }
}