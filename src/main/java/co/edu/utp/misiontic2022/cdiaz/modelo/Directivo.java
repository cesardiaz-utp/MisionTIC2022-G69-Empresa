package co.edu.utp.misiontic2022.cdiaz.modelo;

import co.edu.utp.misiontic2022.cdiaz.excepciones.MaximoNumeroSubordinadosException;

public class Directivo extends Empleado {

    private static final String CATEGORIA_POR_DEFECTO = "No asignado";
    private static final Integer CANTIDAD_SUBORDINADOS = 2;
    
    private String categoria;

    private Empleado[] subordinados;
    private Integer numSubordinados;

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

        this.subordinados = new Empleado[CANTIDAD_SUBORDINADOS];
        this.numSubordinados = 0;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Empleado[] getSubordinados() {
        return subordinados;
    }

    public void agregarSubordinado(Empleado empleado) {
        if (numSubordinados >= CANTIDAD_SUBORDINADOS) {
            throw new MaximoNumeroSubordinadosException();
        }

        subordinados[numSubordinados++] = empleado;
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
