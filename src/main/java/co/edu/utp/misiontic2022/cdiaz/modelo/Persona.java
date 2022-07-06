package co.edu.utp.misiontic2022.cdiaz.modelo;

public abstract class Persona {
    private String nombre;
    private Integer edad;
    
    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract void mostrar();

    // Getter
    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

}
