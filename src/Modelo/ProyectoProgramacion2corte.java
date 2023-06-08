
package Modelo;

import Vista.Inicio;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Falabella
 */
public class ProyectoProgramacion2corte {

    /**
     * @param args the command line arguments
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, SQLException {
        try {
            Inicio inicio = new Inicio();
            inicio.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProyectoProgramacion2corte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
