package co.edu.utp.misiontic2022.cdiaz.excepciones;

import java.io.InputStream;
import java.io.OutputStream;

public class MaximoNumeroClientesException extends Exception {

    public MaximoNumeroClientesException(String message) {
        super(message);
    }

    /**
     * Esta función hace copia de los datos que llegan por el flujo de entrada y los
     * envía por el flujo de salida
     * 
     * @param in  Flujo de entrada
     * @param out Flujo de salida
     * @throws Throwable Excepción al intentar enviar datos por los flujos
     */
    public void doIo2(InputStream in, OutputStream out) throws Throwable {
        int c;
        try {
            while ((c = in.read()) >= 0) {
                c = Character.toLowerCase((char) c);
                out.write(c);
            }
        } catch (Throwable t) {
            throw t;
        }
    }
}
