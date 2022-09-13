
import Datos.Conexion;
import Datos.UsuarioDao;
import Modelo.Usuario;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FELIPE
 */
public class proof {
    public static void main(String[] args) throws SQLException {
        Usuario u = new Usuario("locaaa", "hpta", "okoko@gmal.com", "ajua", "ola lindo");
        UsuarioDao.agregarUsuario(u);
    }
}
