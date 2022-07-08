package co.edu.utp.misiontic2022.cdiaz.modelo;

import java.util.Set;
import java.util.TreeSet;

public class Empresa {
    
    private String nombre;

    private Set<Empleado> empleados;

    private Set<Cliente> clientes;

    public Empresa(String nombre, Set<Empleado> empleados) {
        this.nombre = nombre;
        this.empleados = empleados;

        this.clientes = new TreeSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);

        // var pos = clientes.indexOf(cliente);
        // if (pos != -1) {
        //     clientes.remove(pos);
        // } else {
        //     throw new RuntimeException("El cliente no pertenece a esta empresa");
        // }
    }
    
}
