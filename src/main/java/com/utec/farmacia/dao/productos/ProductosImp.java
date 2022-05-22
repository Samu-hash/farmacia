/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utec.farmacia.dao.productos;


import com.utec.farmacial.utils.ConexionDb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio
 */
public class ProductosImp implements Productos {
    
    @Override
    public Object consultarProducto(ProductosModel cli) throws SQLException {
       ConexionDb cn = new ConexionDb();
        Object[] obj = new Object[]{};
        ResultSet rs = cn.getConectar("{call sp_buscar_productos()}", 
        obj);
        return obtenerDatos(rs);
    }

    @Override
    public Object guardarProducto(ProductosModel cli) throws SQLException {
         ConexionDb cn = new ConexionDb();
        ResultSet rs = cn.getConectar("{call sp_crear_productos(?,?,?,?)}", new Object[]{
            cli.getNombre(),cli.getDescripcion(),cli.getPrecio(),cli.getExistencia()}
        );
        return obtenerDatos(rs).get(0);
    }

    @Override
    public Object actualizarProducto(ProductosModel cli) throws SQLException {
          ConexionDb cn = new ConexionDb();
        ResultSet rs = cn.getConectar("{call sp_actualizar_productos(?,?,?,?,?)}", new Object[]{
           cli.getNombre(),cli.getDescripcion(),cli.getPrecio(),cli.getExistencia()}
                );
        return obtenerDatos(rs).get(0);
    }

    @Override
    public Object eliminarProducto(ProductosModel cli) throws SQLException {
        ConexionDb cn = new ConexionDb();
        ResultSet rs = cn.getConectar("{call sp_eliminar_producto(?)}", new Object[]{
           cli.getIdproducto()}
                );
        return obtenerDatos(rs).get(0);
    }
    
     private List<ProductosModel> obtenerDatos(ResultSet rs) throws SQLException {
        List<ProductosModel> lista = new ArrayList<>();
        while (rs.next()) {
            ProductosModel t = new ProductosModel();
            if (rs.getInt("codigo") == 1) {
                t.setTitulo(rs.getString("titulo"));
                t.setDetalle(rs.getString("detalle"));
                t.setCodigo(rs.getInt("codigo"));
                t.setIdproducto(rs.getInt("idproducto"));
                t.setNombre(rs.getString("nombre"));
                t.setDescripcion(rs.getString("descripcion"));
                t.setPrecio(rs.getFloat("precio"));
                t.setExistencia(rs.getInt("existencia"));
                t.setEstado(rs.getString("estado"));
                
                
               
            } else {
                t.setTitulo(rs.getString("titulo"));
                t.setDetalle(rs.getString("detalle"));
                t.setCodigo(rs.getInt("codigo"));
            }
            lista.add(t);
        }
        return lista;
    }
    

   
}
