package datosBanco;

public class Cuenta {
    private int numCta;
    private double saldo;
    private int nip;
    
    public Cuenta() {
    }

    public Cuenta(int numCta, double saldo, int nip) {
        this.numCta = numCta;
        this.saldo = saldo;
        this.nip = nip;
    }

    public int getNumCta() {
        return numCta;
    }

    public void setNumCta(int numCta) {
        this.numCta = numCta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }
    
    @Override
    public String toString() {
        return "|No. Cuenta: " + numCta + "|----|Saldo: $" + saldo +"|";
    }
    
    public void imprimir(){
        System.out.println(toString());
    }
	
    public void depositar(double importe){
	setSaldo(getSaldo()+importe);
    }
	
    public void retirar (double importe){
        setSaldo(getSaldo()-importe);
    }
}