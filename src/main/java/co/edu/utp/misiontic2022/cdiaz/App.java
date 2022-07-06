package co.edu.utp.misiontic2022.cdiaz;

import co.edu.utp.misiontic2022.cdiaz.excepciones.MaximoNumeroClientesException;
import co.edu.utp.misiontic2022.cdiaz.modelo.Cliente;
import co.edu.utp.misiontic2022.cdiaz.modelo.Directivo;
import co.edu.utp.misiontic2022.cdiaz.modelo.Empleado;
import co.edu.utp.misiontic2022.cdiaz.modelo.Empresa;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        var cesar = new Empleado("Cesar Diaz", 42);
        cesar.setSueldoBruto(3_000_000.0);

        var juan = new Directivo("Juan Silva", 25);
        juan.setCategoria("Jefe de Desarrollo");

        var gustavo = new Empleado("Gustavo Briceño", 30);
        var ivan = new Empleado("Ivan R.", 25);

        try {
            juan.agregarSubordinado(gustavo);
            juan.agregarSubordinado(ivan);
            juan.agregarSubordinado(cesar);
        } catch (Exception ex) {
            System.err.println("El directivo no puede agregar mas subordinados");
            return ; 
        }

        var empresa = new Empresa("Grupo 69", new Empleado[] {
                cesar, juan, gustavo, ivan });

        try {
            var maria = new Cliente("Maria Adelaida", 30, "3105551223");
            empresa.agregarCliente(maria);
            empresa.agregarCliente(new Cliente("Laura Gutierrez", 28));
        } catch (MaximoNumeroClientesException ex) {
            System.err.println("Ha ocurrido un error al agregar un cliente\n\t" + ex.getMessage());
            return;
        } finally {
            System.out.println("Clientes agregados");
        }

        // Imprimir
        System.out.printf("La empresa %s tiene los siguientes empleados: %n", empresa.getNombre());
        for (var empleado : empresa.getEmpleados()) {
            empleado.mostrar();
            if (empleado instanceof Directivo) {

                var directivo = (Directivo) empleado;

                System.out.print("Y sus subordinados son: ");
                var imprimioSubordinado = false;
                for (var subordinado : directivo.getSubordinados()) {
                    if (subordinado == null) {
                        break;
                    }

                    if (imprimioSubordinado) {
                        System.out.print(", ");
                    }

                    System.out.print(subordinado.getNombre());
                    imprimioSubordinado = true;
                }
                System.out.println();
            }
        }
        System.out.println("Y sus clientes son:");
        for (var cliente : empresa.getClientes()) {
            if (cliente == null) {
                break;
            }
            cliente.mostrar();
        }
    }
}
