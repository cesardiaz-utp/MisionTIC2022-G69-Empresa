package co.edu.utp.misiontic2022.cdiaz.modelo;

import java.util.ArrayList;
import java.util.List;

public class Directivo extends Empleado {

    private static final String CATEGORIA_POR_DEFECTO = "No asignado";
    
    private String categoria;

    private List<Empleado> subordinados;

    public Directivo(String nombre, Integer edad) {
        this(nombre, edad, SUELDO_POR_DEFECTO);
    }

    public Directivo(String nombre, Integer edad, Double sueldoBruto) {
        this(nombre, edad, sueldoBruto, CATEGORIA_POR_DEFECTO);
    }

    public Directivo(String nombre, Integer edad, String categoria) {
        this(nombre, edad, SUELDO_POR_DEFECTO, categoria);
    }

    public Directivo(String nombre, Integer edad, Double sueldoBruto, String categoria) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;

        this.subordinados = new ArrayList<>();
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Empleado> getSubordinados() {
        return subordinados;
    }

    public void agregarSubordinado(Empleado empleado) {
        subordinados.add(empleado);
    }

    @Override
    public Double getSueldoBruto() {
        return super.getSueldoBruto() + 100_000d;
    }

    @Override
    public void mostrar() {
        System.out.printf(
                "El directivo de nombre %s tiene %d años, un sueldo de $ %,.2f y su categoría es %s %n",
                getNombre(), getEdad(), getSueldoBruto(), categoria);
    }
}
