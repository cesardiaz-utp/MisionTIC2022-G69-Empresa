package co.edu.utp.misiontic2022.cdiaz.modelo;

import co.edu.utp.misiontic2022.cdiaz.excepciones.MaximoNumeroClientesException;

public class Empresa {
    
    private static final Integer CANTIDAD_CLIENTES = 1;

    private String nombre;

    private Empleado[] empleados;

    private Cliente[] clientes;
    private Integer numClientes;

    public Empresa(String nombre, Empleado[] empleados) {
        this.nombre = nombre;
        this.empleados = empleados;

        this.clientes = new Cliente[CANTIDAD_CLIENTES];
        this.numClientes = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) throws MaximoNumeroClientesException {
        // Valido
        if (numClientes >= CANTIDAD_CLIENTES) {
            var ex = new MaximoNumeroClientesException("La empresa no puede agregar un cliente más");
            try {
                ex.doIo2(System.in, System.out);
            } catch (Throwable e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            throw ex;
        }

        // Proceso
        clientes[numClientes] = cliente;
        numClientes++;
    }

    
}
