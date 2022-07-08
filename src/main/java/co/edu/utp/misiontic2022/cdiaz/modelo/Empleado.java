package co.edu.utp.misiontic2022.cdiaz.modelo;

public class Empleado extends Persona  {

    protected static final Double SUELDO_POR_DEFECTO = 1_000_000d;

    protected Double sueldoBruto;

    public Empleado(String nombre, Integer edad) {
        this(nombre, edad, SUELDO_POR_DEFECTO);
    }

    public Empleado(String nombre, Integer edad, Double sueldoBruto) {
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
    }

    public Double getSueldoBruto() {
        return sueldoBruto;
    }

    public void setSueldoBruto(Double sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    @Override
    public void mostrar() {
        System.out.printf(
                "El empleado de nombre %s tiene %d años y un sueldo de $ %,.2f %n",
                getNombre(), getEdad(), sueldoBruto);
    }

    public Double calcularValorNeto() {
        var porcentajeSalud = 4d;
        var porcentajePension = 4d;

        return getSueldoBruto() * (100 - porcentajeSalud - porcentajePension) / 100;
    }

}
