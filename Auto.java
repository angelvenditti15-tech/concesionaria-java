package modelo;

public class Auto extends Vehiculo {
    private int cantidadPuertas;

    public Auto(String marca, String modelo, int anio, double precio, int cantidadPuertas) {
        super(marca, modelo, anio, precio);
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public String getTipo() { return "Auto"; }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("   Puertas: " + cantidadPuertas);
    }

    public int getCantidadPuertas() { return cantidadPuertas; }
}
