package co.edu.uniquindio.dominio;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class Administrador extends Persona{

    private List<Empleado> empleados;
    private Usuario usuaro;

    public Administrador(String nombre, String documeto, String celular,
                         List<Empleado> empleados, Usuario usuaro) {
        super(nombre, documeto, celular);
        this.empleados = empleados;
        this.usuaro = usuaro;
    }


    public void agregarEmpleado(Empleado empleado){
        if(buscarEmpleado(empleado).isPresent()){
            throw new RuntimeException("El empleado ya existe");
        }
        empleados.add(empleado);
    }

    public void actualizarEmpleado(Empleado empleadoActualizado){
        Optional<Empleado> empleado = buscarEmpleado(empleadoActualizado);
        if(empleado.isPresent()){
            empleado = Optional.of(empleadoActualizado);
        }
    }

    public void bloquearCuentaEmpleado(Empleado empleado){
        if(!buscarEmpleado(empleado).isPresent()){
            throw new RuntimeException("El empleado no existe");
        }
        empleado.getUsuario().setEstado(false);
        actualizarEmpleado(empleado);
    }

    public void desbloquearCuentaEmpleado(Empleado empleado){
        if(!buscarEmpleado(empleado).isPresent()){
            throw new RuntimeException("El empleado no existe");
        }
        empleado.getUsuario().setEstado(true);
        actualizarEmpleado(empleado);
    }

    private Optional<Empleado> buscarEmpleado(Empleado empleado){
        return empleados.stream().filter((empl) -> empl.getDocumeto().equals(empleado.getDocumeto())).findFirst();
    }

}
