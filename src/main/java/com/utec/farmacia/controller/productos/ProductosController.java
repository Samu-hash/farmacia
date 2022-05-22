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
    
     @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/guardar")
    public String guardarDatos(String json) {
        Gson gson = new Gson();
        ProductosModel pdm = new ProductosModel();
        try {
            ProductosModel valores = gson.fromJson(json, ProductosModel.class);
            ProductosImp pimp = new ProductosImp();

            pdm = (ProductosModel) pimp.guardarProducto(valores);
        } catch (Exception e) {
            pdm.setTitulo("Transaccion denegada");
            pdm.setDetalle("Error: " + e.getMessage());
        }
        return gson.toJson(pdm);
    }
    
     @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/actualizar")
    public String actualizarDatos(String json) {
        Gson gson = new Gson();
        ProductosModel pm = new ProductosModel();
        try {
            ProductosModel valores = gson.fromJson(json, ProductosModel.class);
           ProductosImp pimp = new ProductosImp();

            pm = (ProductosModel) pimp.actualizarProducto(valores);
        } catch (Exception e) {
            pm.setTitulo("Transaccion denegada");
            pm.setDetalle("Error: " + e.getMessage());
        }
        return gson.toJson(pm);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/eliminar")
    public String eliminarDatos(String json) {
        Gson gson = new Gson();
        ProductosModel pm = new ProductosModel();
        try {
            ProductosModel datos = gson.fromJson(json, ProductosModel.class);
            ProductosImp pimp = new ProductosImp();

            pm = (ProductosModel) pimp.eliminarProducto(datos);
        } catch (Exception e) {
            pm.setTitulo("Transaccion denegada");
            pm.setDetalle("Error: " + e.getMessage());
        }
        return gson.toJson(pm);
    }
    
    
    
    
    
}
