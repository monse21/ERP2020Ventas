package Modelo;

/**
 *
 * @author DELL
 */
public class Tripulacion {
    
    Empleado Empleado;
    Envios envio;
    String rol;

    public Tripulacion() {
    }

    
    public Empleado getEmpleado() {
        return Empleado;
    }

    public void setEmpleado(Empleado Empleado) {
        this.Empleado = Empleado;
    }

    public Envios getEnvio() {
        return envio;
    }

    public void setEnvio(Envios envio) {
        this.envio = envio;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
