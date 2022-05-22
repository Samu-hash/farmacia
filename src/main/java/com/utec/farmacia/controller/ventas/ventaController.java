
package com.utec.farmacia.controller.ventas;

import com.google.gson.Gson;
import com.utec.farmacia.dao.ventas.VentaImp;
import com.utec.farmacia.dao.ventas.VentaModel;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


public class ventaController {
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/guardar")
    public String guardarDatos(String json) {
        Gson gson = new Gson();
        VentaModel vent = new VentaModel();
        try {
            VentaModel valores = gson.fromJson(json, VentaModel.class);
            VentaImp vimp = new VentaImp();

            vent = (VentaModel) vimp.guardarVenta(valores);
        } catch (Exception e) {
            vent.setEstado(new Short("0"));
            vent.setTitulo("Transaccion denegada");
            vent.setDetalle("Error: " + e.getMessage());
        }
        return gson.toJson(vent);
    }
}
