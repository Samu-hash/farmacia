
package com.utec.farmacia.dao.ventas;

import java.sql.SQLException;


public interface Ventas {
   
    
    Object guardarVenta(VentaModel ven) throws SQLException;
    
    
}
