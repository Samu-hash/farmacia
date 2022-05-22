/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utec.farmacial.utils;


/**
 *
 * @author samu5
 */
public class Parametros {

    public Constants obtenerParametroConexion() {
        Constants c = new Constants();

        c.setSERVER("DESKTOP-TI15O8V\\\\SAMU");
        c.setPORT("1433");
        c.setDB_NAME("farmacia_parcial");
        c.setINTEGRAL_SECURITY("false");
        c.setUSER("sa");
        c.setPASSWORD("123456");
        c.setDRIVER("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return c;
    }
}
