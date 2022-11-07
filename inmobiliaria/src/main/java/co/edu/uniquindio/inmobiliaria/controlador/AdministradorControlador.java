package co.edu.uniquindio.inmobiliaria.controlador;

import co.edu.uniquindio.inmobiliaria.modelo.Empleado;

import java.util.Optional;

public class AdministradorControlador {

//    public boolean agregarEmpleado(Empleado empleado) {
//        if (buscarEmpleado(empleado).isPresent()) {
//            throw new RuntimeException("El empleado ya existe");
//        }
//        Datos.getIntancia().empleados.add(empleado);
//        return true;
//    }
//
//    public boolean actualizarEmpleado(Empleado empleadoActualizado) {
//        Optional<Empleado> empleado = buscarEmpleado(empleadoActualizado);
//        if (!empleado.isPresent()) {
//            throw new RuntimeException("El empleado no existe");
//        }
//        empleado = Optional.of(empleadoActualizado);
//        return true;
//    }
//
//    public boolean bloquearCuentaEmpleado(String identificacion) {
//        Optional<Empleado> empleado = buscarEmpleado(identificacion);
//        if (!empleado.isPresent()) {
//            throw new RuntimeException("El empleado no existe");
//        }
//        empleado.get().getUsuario().setEstado(false);
//        actualizarEmpleado(empleado.get());
//        return empleado.get().getUsuario().isEstado();
//    }
//
//    public boolean desbloquearCuentaEmpleado(String identificacion) {
//        Optional<Empleado> empleado = buscarEmpleado(identificacion);
//        if (!empleado.isPresent()) {
//            throw new RuntimeException("El empleado no existe");
//        }
//        empleado.get().getUsuario().setEstado(true);
//        actualizarEmpleado(empleado.get());
//        return empleado.get().getUsuario().isEstado();
//    }
//
//    private Optional<Empleado> buscarEmpleado(String identificacion) {
//        return Datos.getIntancia().empleados.stream()
//                .filter((empl) -> empl.getDocumento().equals(identificacion)).findFirst();
//    }
//
//    private Optional<Empleado> buscarEmpleado(Empleado empleado) {
//        return Datos.getIntancia().empleados.stream()
//                .filter((empl) -> empl.getDocumento().equals(empleado.getDocumento())).findFirst();
//    }
}
