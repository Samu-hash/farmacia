/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utec.farmacia.dao.productos;

import java.sql.SQLException;

/**
 *
 * @author Julio
 */
public interface Productos {
    

    Object consultarProducto(ProductosModel cli) throws SQLException;

    Object guardarProducto(ProductosModel cli) throws SQLException;

    Object actualizarProducto(ProductosModel cli) throws SQLException;

    Object eliminarProducto(ProductosModel cli) throws SQLException;


}
