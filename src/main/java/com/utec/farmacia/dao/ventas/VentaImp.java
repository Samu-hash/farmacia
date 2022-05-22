
package com.utec.farmacia.dao.ventas;

import com.utec.farmacial.utils.ConexionDb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VentaImp {
    
    private static final String patron = "P@arcial_4_Progra_4";


    public Object guardarVenta(VentaModel ven) throws SQLException {
        ConexionDb cn = new ConexionDb();
        ResultSet rs = cn.getConectar("{call sp_crear_ventas(?,?,?,?,?,?)}", new Object[]{
            ven.getIdproducto(),ven.getDescripcion(),ven.getTotal(),ven.getFecha_venta(),ven.getEstado(),patron}
        );
        return guardarVenta((VentaModel) rs);
    }

    }

