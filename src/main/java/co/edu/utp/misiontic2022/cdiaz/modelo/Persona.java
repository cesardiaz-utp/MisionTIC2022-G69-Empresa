package co.edu.utp.misiontic2022.cdiaz.modelo;

public abstract class Persona implements Comparable<Persona> {
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

    @Override
    public int compareTo(Persona persona) {
        var comparado = getNombre().compareTo(persona.getNombre());
        if (comparado != 0) {
            return comparado;
        }

        return getEdad().compareTo(persona.getEdad());
    }

}
