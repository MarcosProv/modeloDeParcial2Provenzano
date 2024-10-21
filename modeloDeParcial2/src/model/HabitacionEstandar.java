package model;

public class HabitacionEstandar extends Habitacion {

    private boolean limpiezaIncluida;
    private double costoLimpieza;

    public HabitacionEstandar(boolean limpiezaIncluida, double costoLimpieza, String codHabitacion, double precioPorNoche) {
        super(codHabitacion, precioPorNoche);
        this.limpiezaIncluida = limpiezaIncluida;
        this.costoLimpieza = costoLimpieza;
    }

    @Override
    double calcularPrecioTotal(int dias) {
        double costoTotal;
        if (dias > 0) {
            if (limpiezaIncluida) {
                costoTotal = costoLimpieza + (dias * precioPorNoche);
            } else {
                costoTotal = dias * (precioPorNoche + costoLimpieza);
            }
        } else {
            throw new IllegalArgumentException("El numero de dias en invalido");
        }
        return costoTotal;
    }

    @Override
    public String toString() {
        return " HabitacionEstandar " + super.toString() + "limpiezaIncluida=" + limpiezaIncluida + ", costoLimpieza=" + costoLimpieza;
    }

}
