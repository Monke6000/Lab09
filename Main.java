import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        
        try {
            PersistenciaGremio bd = new PersistenciaGremio();

            System.out.println("\n--- BLOQUE 1: Crear personajes y guardar roster ---");
            ArrayList<Personaje> roster = new ArrayList<>();
            roster.add(new Druida("Sylva", 10, 300, 100));
            roster.add(new Arquero("Legolas", 6, 150, "Arco", 20, 95));
            roster.add(new Guerrero("Thorin", 9, 400, "Hacha", 80));
            bd.guardarRoster(roster);

            System.out.println("\n--- BLOQUE 2: Cargar roster desde archivo ---");
            ArrayList<String> lineasRoster = bd.cargarRoster();
            System.out.println("=== Roster cargado desde disco ===");
            for (String fila : lineasRoster) {
                String[] datos = fila.split(",");
                System.out.println("> Nombre: " + datos[0] + " | Nivel: " + datos[1] + " | Vida: " + datos[2]);
            }

            System.out.println("\n--- BLOQUE 3: Guardar y cargar inventario ---");
            HashMap<String, Integer> inv = new HashMap<>();
            inv.put("Poción de vida", 8);
            inv.put("Flecha élfica", 30);
            inv.put("Pergamino de fuego", 3);
            bd.guardarInventario(inv);
            
            HashMap<String, Integer> invCargado = bd.cargarInventario();
            System.out.println("=== Inventario recuperado ===");
            for (Map.Entry<String, Integer> obj : invCargado.entrySet()) {
                System.out.println(obj.getKey() + " → " + obj.getValue());
            }

            System.out.println("\n--- BLOQUE 4: Escribir entradas en la bitácora ---");
            bd.agregarEntradaBitacora("Sylva atacó a Malachar (daño: 240)");
            bd.agregarEntradaBitacora("Legolas sin flechas — no pudo atacar");
            bd.agregarEntradaBitacora("Thorin venció a Dragón de Hielo");
            
            bd.mostrarBitacora();

            System.out.println("\n--- BLOQUE 5: Verificar los archivos creados ---");
            File carpeta = new File("datos_gremio");
            System.out.println("=== Contenido físico en datos_gremio/ ===");
            for (File archivoFisico : carpeta.listFiles()) {
                System.out.println("- " + archivoFisico.getName() + " (" + archivoFisico.length() + " bytes)");
            }

        } catch (IOException e) {
            System.out.println("❌ Ups, tuvimos un error de archivo: " + e.getMessage());
        }
    }
}