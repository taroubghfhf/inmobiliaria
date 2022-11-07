//package co.edu.uniquindio.inmobiliaria.controlador;
//
//import co.edu.uniquindio.inmobiliaria.modelo.Usuario;
//
//import java.util.List;
//import java.util.Optional;
//
//
//public class UsuarioControlador {
//
//    public String recuperarClave(String correo, String fraseSeguridad){
//        Optional<Usuario> usuario = consultarUsuario(correo);
//        if(usuario.isPresent()
//                && usuario.get().getCorreo().equals(correo)
//                && usuario.get().getFraseSeguridad().equals(fraseSeguridad)){
//            return usuario.get().getClave();
//        }
//        throw new RuntimeException("Datos invalidos, intente de nuevo!");
//    }
//
//    private Optional<Usuario> consultarUsuario(String correo){
//        List<Usuario> usuarios = Datos.getIntancia().getUsuarios();
//        return usuarios.stream().filter(usuario -> usuario.getCorreo().equals(correo)).findFirst();
//    }
//
//}
