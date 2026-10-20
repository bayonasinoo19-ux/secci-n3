package com.ejemplo.transporte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practica {
    public static void main(String[] args) {
        System.out.println("--- PRUEBAS ETAPA 1 ---");
        Vehiculo v1 = new Vehiculo("VEH301", 8);
        System.out.println(v1.descripcion());
        v1.setCapacidad(-5);
        System.out.println("Capacidad después de intentar -5: " + v1.getCapacidad());
        v1.setCapacidad(10);
        System.out.println("Capacidad después de cambiar a 10: " + v1.getCapacidad());

        System.out.println("\n--- PRUEBAS ETAPA 2 (Polimorfismo) ---");
        Vehiculo vehiculoBase = new Vehiculo("VEH301", 8);
        Vehiculo bus1 = new Bus("BUS101", 40, "Centro-Norte");
        Vehiculo taxi1 = new Taxi("TAX201", 4, "Taxis Bogotá");

        System.out.println(vehiculoBase.descripcion() + " | Tarifa 10km: " + vehiculoBase.calcularTarifa(10));
        System.out.println(bus1.descripcion() + " | Tarifa 10km: " + bus1.calcularTarifa(10));
        System.out.println(taxi1.descripcion() + " | Tarifa 10km: " + taxi1.calcularTarifa(10));

        System.out.println("\n--- PRUEBAS ETAPA 3 (Colecciones) ---");
        // 1. Crear List<Vehiculo> con 5 vehículos (2 buses, 2 taxis y 1 vehículo base)
        List<Vehiculo> flota = new ArrayList<>();
        flota.add(new Bus("BUS101", 40, "Centro-Norte"));
        flota.add(new Bus("BUS102", 35, "Sur-Occidente"));
        flota.add(new Taxi("TAX201", 4, "Taxis Bogotá"));
        flota.add(new Taxi("TAX202", 4, "Taxis Libres"));
        flota.add(new Vehiculo("VEH301", 8));

        System.out.println("Total de vehículos en la flota: " + flota.size());

        // 2. Con un for-each imprimir descripción y tarifa para 10 km
        for (Vehiculo v : flota) {
            System.out.println(v.descripcion() + " -> Tarifa (10 km): $" + v.calcularTarifa(10));
        }

        // 3. Con un for-each e if contar cuántos vehículos tienen capacidad mayor a 10
        int contadorMayoresA10 = 0;
        for (Vehiculo v : flota) {
            if (v.getCapacidad() > 10) {
                contadorMayoresA10++;
            }
        }
        System.out.println("Vehículos con capacidad mayor a 10: " + contadorMayoresA10);

        // 4. Crear Map<String, String> conductores con tres pares placa -> nombre
        Map<String, String> conductores = new HashMap<>();
        conductores.put("BUS101", "Carlos");
        conductores.put("BUS102", "María");
        conductores.put("TAX201", "Andrés");

        // 5. Imprimir conductor de placa existente y comprobar placa inexistente con containsKey
        String placaExistente = "BUS101";
        System.out.println("El conductor de " + placaExistente + " es " + conductores.get(placaExistente));

        String placaNoExistente = "XYZ999";
        if (conductores.containsKey(placaNoExistente)) {
            System.out.println("El conductor de " + placaNoExistente + " es " + conductores.get(placaNoExistente));
        } else {
            System.out.println("La placa " + placaNoExistente + " no tiene conductor asignado.");
        }
    }
}