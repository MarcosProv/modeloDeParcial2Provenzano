package model;

import java.util.ArrayList;

public class Hotel {
    
    private String nombre;
    private ArrayList<Habitacion> listaHabitaciones;
    
    public Hotel(String nombre) {
        this.nombre = nombre;
        this.listaHabitaciones = new ArrayList<Habitacion>();
    }

    // verificar que tods las excepciones sean atrapadas
    public void agregarHabitacion(Habitacion habitacion) {
        listaHabitaciones.add(habitacion);
    }
    
    public Habitacion buscarHabitacion(String codigoHabitacion) {
        for (Habitacion habitacion : listaHabitaciones) {
            if (habitacion.codHabitacion.equals(codigoHabitacion)) {
                return habitacion;
            }
        }
        throw new IllegalArgumentException("La habitacion no existe");
    }
    
    public boolean liberarHabitacion(String codigoHabitacion) {
        boolean retorno = false;
        Habitacion habitacion = buscarHabitacion(codigoHabitacion);
        if (habitacion != null && habitacion.preguntarOcupada() == true) {
            habitacion.cambiarEstado();
            habitacion.asignarReserva(0);
            retorno = true;
        }
        return retorno;
    }
    
    public double calcularCostoEstadia(String codigoHabitacion, int dias) {
        Habitacion habitacion = buscarHabitacion(codigoHabitacion);
        return habitacion.calcularPrecioTotal(dias);
    }
    
    public void incluirDesayuno(boolean estado, String codHabitacion) {
        Habitacion habitacion = buscarHabitacion(codHabitacion);
        if (habitacion instanceof HabitacionDeluxe) {
            HabitacionDeluxe habitacionDeluxe = (HabitacionDeluxe) habitacion;
            habitacionDeluxe.incluirDesayuno(estado);
        } else {
            throw new IllegalArgumentException("La habitacion no es una habitacion Deluxe");
        }
    }
    
    public boolean reservarHabitacion(String codigoHabitacion, int dias) {
        Habitacion habitacion = buscarHabitacion(codigoHabitacion);
        if (habitacion != null && habitacion.preguntarOcupada() == false) {
            habitacion.cambiarEstado();
            habitacion.reserva = dias;
            return true;
        } else {
            throw new IllegalArgumentException("La habitacion ya esta reservada");
        }
    }
}
