package model;

public class HabitacionDeluxe extends Habitacion {

    private boolean incluyeDesayuno;
    private double tarifaDesayuno;
    private int numeroNochesMinimas;

    public HabitacionDeluxe(boolean incluyeDesayuno, double tarifaDesayuno, int numeroNochesMinimas, String codHabitacion, double precioPorNoche) {
        super(codHabitacion, precioPorNoche);
        this.incluyeDesayuno = incluyeDesayuno;
        this.tarifaDesayuno = tarifaDesayuno;
        this.numeroNochesMinimas = numeroNochesMinimas;
    }

    @Override
    double calcularPrecioTotal(int dias) {
        double costoTotal = dias * precioPorNoche;
        if (dias > 0) {
            if (incluyeDesayuno) {
                costoTotal += tarifaDesayuno * dias;
            }
            if (dias > 7) {
                costoTotal *= 0.90;
            }
            if (numeroNochesMinimas > dias) {
                costoTotal *= 1.20;
            }
            return costoTotal;
        } else {
            throw new IllegalArgumentException("El numero de dias en invalido");
        }
    }
    
    public void incluirDesayuno(boolean estado){
        incluyeDesayuno = estado;
    }

    @Override
    public String toString() {
        return "HabitacionDeluxe " +  super.toString() + "incluyeDesayuno=" + incluyeDesayuno + ", tarifaDesayuno=" 
        + tarifaDesayuno + ", numeroNochesMinimas=" + numeroNochesMinimas;
    }
    
 

    
}
