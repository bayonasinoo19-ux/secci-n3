package com.ejemplo.transporte;

public class Vehiculo {
    // 1. Atributos privados
    private String placa;
    private int capacidad;

    // 2. Constructor que usa el setter para validar la capacidad
    public Vehiculo(String placa, int capacidad) {
        this.placa = placa;
        setCapacidad(capacidad);
    }

    // 3. Getters
    public String getPlaca() {
        return placa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    // 4. Setter con validación (solo asigna si es mayor que 0)
    public void setCapacidad(int capacidad) {
        if (capacidad > 0) {
            this.capacidad = capacidad;
        }
    }

    // 5. Método para calcular tarifa base
    public double calcularTarifa(double km) {
        return km * 1500;
    }

    // 6. Método de descripción
    public String descripcion() {
        return "Placa " + placa + ", capacidad " + capacidad;
    }
}