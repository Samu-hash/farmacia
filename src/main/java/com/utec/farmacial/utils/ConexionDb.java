package com.utec.farmacial.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ConexionDb {

    protected Connection cn;
    private Parametros param;

    public Connection conectarDb() {
        param = new Parametros();
        Constants c = param.obtenerParametroConexion();
        try {
            String url = "jdbc:sqlserver://" + c.getSERVER() + ":" + c.getPORT() + ";databaseName=" + c.getDB_NAME() + ";integratedSecurity=" + c.getINTEGRAL_SECURITY();
            String user = c.getUSER();
            String password = c.getPASSWORD();

            Class.forName(c.getDRIVER());

            cn = DriverManager.getConnection(url, user, password);
        } catch (Exception x) {
            x.printStackTrace();
            return null;
        }
        return cn;
    }

    public ResultSet getConectar(String procedure, Object[] obj) throws SQLException {
        this.cn = this.conectarDb();
        System.out.println(cn);
        CallableStatement st = this.cn.prepareCall(procedure);
        if (!Objects.isNull(obj)) {
            int contador = 1;
            for (Object object : obj) {
                try {
                    Long.valueOf(object.toString());
                    st.setLong(contador, Long.valueOf(object.toString()));
                } catch (Exception e) {
                    st.setString(contador, object.toString());
                }
                contador++;
            }
        }

        ResultSet rs = st.executeQuery();
        return rs;
    }
}
