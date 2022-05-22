/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utec.farmacia.controller.productos;
import com.google.gson.Gson;
import com.utec.farmacia.dao.productos.ProductosImp;
import com.utec.farmacia.dao.productos.ProductosModel;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Julio
 */
@Path("Productos")
@Stateless
public class ProductosController {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/listar")
    public String ListarProductos(String json) {
        Gson gson = new Gson();

        try {
            ProductosModel valores = gson.fromJson(json, ProductosModel.class);
            ProductosImp imp = new ProductosImp();

            return gson.toJson(imp.consultarProducto(valores));

        } catch (Exception e) {
            ProductosModel ate = new ProductosModel();
            ate.setTitulo("Transaccion denegada");
            ate.setDetalle("Error: " + e.getMessage());
            return gson.toJson(ate);
        }
    }
    
    
    
}
