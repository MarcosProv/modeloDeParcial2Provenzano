package model;

// profe no entendi que tipo de asociacion es. Porque para que sea de compocicion,
// entiendo que no podria pasarle al hotel las habitaciones por parametro.
//
// Tampoco entendo que hacer en el metodo de Hotel "reservarHabitacion". 
// Porque yo nececito crear la habitacion deluxe con cualquier numero minimo de estadia 
// para calcular el recargo de 20% del metodo calcularPrecioTotal(int dias) 
//
// El test 1-3 y 1-4 creo que estan mezclados con los dos test de arriba,o no entiendi la consigna.
// Tambien tube problemas con los suguientes

public class Main {

    public static void main(String[] args) {

        Hotel hotel = new Hotel("Los Moras");

        System.out.println("1-1");
        try {
            HabitacionEstandar habitacionEstandar1 = new HabitacionEstandar(false, 0.0, "10001", 80.0);
            hotel.agregarHabitacion(habitacionEstandar1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1-2");
        try {
            HabitacionEstandar habitacionEstandar2 = new HabitacionEstandar(true, 15.0, "10002", 90.0);
            hotel.agregarHabitacion(habitacionEstandar2);
            System.out.println(habitacionEstandar2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1-3");
        try {
            System.out.println(hotel.calcularCostoEstadia("10001", 3));
            System.out.println(hotel.calcularCostoEstadia("10002", 3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1-3");
        try {
            System.out.println(hotel.calcularCostoEstadia("10001", 3));
            System.out.println(hotel.calcularCostoEstadia("10002", 3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("1-4");
        try {
            System.out.println(hotel.calcularCostoEstadia("10002", 4));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("2-1");
        try {
            HabitacionDeluxe habitacionDeluxe1 = new HabitacionDeluxe(true, 25.0, 2, "2001", 200.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("2-2");
        try {
            HabitacionDeluxe habitacionDeluxe2 = new HabitacionDeluxe(false, 30, 1, "20002", 250.0);
            hotel.agregarHabitacion(habitacionDeluxe2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("2-3");
        try {
            HabitacionDeluxe habitacionDeluxe3 = new HabitacionDeluxe(false, 25, 7, "20001", 200.0);
            hotel.agregarHabitacion(habitacionDeluxe3);
            System.out.println(hotel.calcularCostoEstadia("20001", 8));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("2-4");
        try {
            hotel.incluirDesayuno(true, "20001");
            System.out.println(hotel.calcularCostoEstadia("20001", 5));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("2-5");
        try {
            HabitacionDeluxe habitacionDeluxe4 = new HabitacionDeluxe(false, 25, 7, "2001", 200.0);
            System.out.println(hotel.calcularCostoEstadia("2001", 3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("3-1");
        try {
            hotel.reservarHabitacion("1002", 2);
            hotel.liberarHabitacion("1002");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("3-2");
        try {
            HabitacionEstandar habitacionEstandar3 = new HabitacionEstandar(false, 10.0, "10012", 100.0);
            hotel.agregarHabitacion(habitacionEstandar3);
            hotel.reservarHabitacion("10012", 4);
            hotel.reservarHabitacion("10012", 4);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("3-3");
        try {
            HabitacionDeluxe habitacionDeluxe5 = new HabitacionDeluxe(true, 25, 7, "20005", 200.0);
            hotel.agregarHabitacion(habitacionDeluxe5);
            System.out.println(hotel.calcularCostoEstadia("20005", 5));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("3-4");
        try {
            HabitacionDeluxe habitacionDeluxe6 = new HabitacionDeluxe(true, 25, 7, "20005", 200.0);
            hotel.agregarHabitacion(habitacionDeluxe6);
            HabitacionDeluxe habitacionDeluxe7 = new HabitacionDeluxe(true, 25, 7, "20005", 200.0);
            hotel.agregarHabitacion(habitacionDeluxe6);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        
    }

}
