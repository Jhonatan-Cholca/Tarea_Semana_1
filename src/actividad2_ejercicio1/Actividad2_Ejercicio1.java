package actividad2_ejercicio1;

import java.util.ArrayList;
import java.util.Scanner;

public class Actividad2_Ejercicio1 
{
    static class Vehiculo 
    {
        int tipo;      // 1: buseta, 2: bus
        int año;
        int capacidad;

        public Vehiculo(int tipo, int año, int capacidad) 
        {
            this.tipo = tipo;
            this.año = año;
            this.capacidad = capacidad;
        }
    }

    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        System.out.println("              CENSO DE VEHÍCULOS");
        System.out.println("Ingrese los datos de cada vehículo.");

        while (true) 
        {
            System.out.print("Tipo (1: buseta, 2: bus, 0: Para finalizar): ");
            int tipo = teclado.nextInt();
            if (tipo == 0) 
            {
                break;
            }
            if (tipo != 1 && tipo != 2) 
            {
                System.out.println("Tipo inválido. Use 1 o 2.");
                continue;
            }

            System.out.print("Año del vehículo: ");
            int año = teclado.nextInt();
            System.out.print("Capacidad (número de pasajeros): ");
            int capacidad = teclado.nextInt();

            vehiculos.add(new Vehiculo(tipo, año, capacidad));
            System.out.println("Vehículo registrado.\n");
        }

        // Si no se ingresó ningún vehículo
        if (vehiculos.isEmpty()) 
        {
            System.out.println("No se registró ningún vehículo. Saliendo...");
            teclado.close();
            return;
        }

        // Inicializar contadores para los puntos a,b,c,d,e
        int a = 0, b = 0, c = 0, d = 0, e = 0;

        for (Vehiculo v : vehiculos) 
        {
            if (v.año < 2000) a++;
            if (v.año >= 2000 && v.capacidad < 40) b++;
            if (v.tipo == 2 && v.año > 2000 && v.capacidad > 40) c++;
            if (v.tipo == 2 && v.año < 2000 && v.capacidad > 40) d++;
            if (v.tipo == 1 && v.capacidad < 40) e++;
        }

        int f = vehiculos.size(); // total

        // Resultados
        System.out.println("\n     RESULTADOS DEL CENSO\n");
        System.out.println("a) Número de vehículos cuyo modelo sea anterior al año 2000: " + a);
        System.out.println("b) Número de vehículos cuyo modelo sea a partir del año 2000 y cuya capacidad sea menor de 40 pasajeros: " + b);
        System.out.println("c) Número de buses cuyo modelo sea posterior al año 2000 con capacidad mayor a 40 pasajeros: " + c);
        System.out.println("d) Número de buses cuyo modelo sea anterior al año 2000 con capacidad mayor de 40 pasajeros: " + d);
        System.out.println("e) Número de busetas con capacidad menor de 40 pasajeros: " + e);
        System.out.println("f) El total de vehículos de la empresa: " + f);
        System.out.println("g) Información de cada vehículo de la empresa: \n");

        for (int i = 0; i < vehiculos.size(); i++) 
        {
            Vehiculo v = vehiculos.get(i);
            String tipoStr = (v.tipo == 1) ? "Buseta" : "Bus";
            System.out.printf("Vehículo %d: Tipo=%s, Año=%d, Capacidad=%d%n",
                    (i+1), tipoStr, v.año, v.capacidad);
        }
    }
}