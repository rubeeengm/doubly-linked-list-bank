package datosBanco;

public class Cliente {
    private String nombre;
    private String apellido;
    private Cuenta Cuenta;

    public Cliente() {
    }
    
    public Cliente(String nombre, String apellido, Cuenta Cuenta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.Cuenta = Cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Cuenta getCuenta() {
        return Cuenta;
    }

    public void setCuenta(Cuenta Cuenta) {
        this.Cuenta = Cuenta;
    }

    @Override
    public String toString() {
        return "|Nombre: " + nombre + " " + apellido + "|----" + Cuenta;
    }
    
    public void imprimir(){
        System.out.println(toString());
    }
}