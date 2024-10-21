package model;

public abstract class Habitacion {

    protected String codHabitacion;
    protected boolean estaOcupada;
    protected double precioPorNoche;
    protected int reserva;

    public Habitacion(String codHabitacion, double precioPorNoche) {
        this.codHabitacion = validarCaracteres(codHabitacion);
        estaOcupada = false;
        this.precioPorNoche = precioPorNoche;
        reserva = 0;

    }

    abstract double calcularPrecioTotal(int dias);

    public void asignarReserva(int dias) {
        if (dias >= 0) {
            reserva = dias;
        } else {
            throw new IllegalArgumentException("Cantidad de dias invalida");
        }
    }

    public boolean preguntarOcupada() {
        return estaOcupada;
    }

    public void cambiarEstado() {
        estaOcupada = !estaOcupada;
    }

    String validarCaracteres(String caracteres) {
        
        if (caracteres.length() != 5 || caracteres.equals(null)) {
            throw new IllegalArgumentException("El codico de habitacion tiene una cantidad de caracteres en invalida");
        }
        return caracteres;
    }

    @Override
    public String toString() {
        return "codHabitacion=" + codHabitacion + ", estaOcupada=" + estaOcupada + ", precioPorNoche=" + precioPorNoche + ", reserva=" + reserva;
    }
    

}
