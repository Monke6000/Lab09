import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersistenciaGremio {

    private static final String RUTA_CARPETA = "datos_gremio";

    public PersistenciaGremio() {
        armarCarpetaSiFalta();
    }

    private void armarCarpetaSiFalta() {
        File folder = new File(RUTA_CARPETA);
        if (!folder.exists()) {
            folder.mkdir();
            System.out.println("[Sistema] -> Se creó la carpeta '" + RUTA_CARPETA + "' exitosamente.");
        }
    }

    public void guardarRoster(ArrayList<Personaje> equipo) throws IOException {
        File archivo = new File(RUTA_CARPETA + "/roster.txt");
        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo));

        for (Personaje hero : equipo) {
            escritor.write(hero.getNombre() + "," + hero.getNivel() + "," + hero.getPuntosVida());
            escritor.newLine(); 
        }

        escritor.close();
        System.out.println("[Registro] -> Roster actualizado en disco: " + equipo.size() + " personajes.");
    }

    public ArrayList<String> cargarRoster() throws IOException {
        File archivo = new File(RUTA_CARPETA + "/roster.txt");
        ArrayList<String> datosObtenidos = new ArrayList<>();

        if (!archivo.exists()) {
            System.out.println("[Aviso] -> No se encontró roster.txt, iniciando vacío.");
            return datosObtenidos;
        }

        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        String linea;

        while ((linea = lector.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                datosObtenidos.add(linea);
            }
        }

        lector.close();
        return datosObtenidos;
    }

    public void guardarInventario(HashMap<String, Integer> items) throws IOException {
        File archivo = new File(RUTA_CARPETA + "/inventario.txt");
        BufferedWriter pluma = new BufferedWriter(new FileWriter(archivo));

        for (Map.Entry<String, Integer> entrada : items.entrySet()) {
            pluma.write(entrada.getKey() + "," + entrada.getValue());
            pluma.newLine();
        }

        pluma.close();
        System.out.println("[Registro] -> Inventario guardado (" + items.size() + " tipos de objetos).");
    }

    public HashMap<String, Integer> cargarInventario() throws IOException {
        File archivo = new File(RUTA_CARPETA + "/inventario.txt");
        HashMap<String, Integer> mochila = new HashMap<>();

        if (!archivo.exists()) return mochila;

        BufferedReader lector = new BufferedReader(new FileReader(archivo));
        String renglon;

        while ((renglon = lector.readLine()) != null) {
            String[] partes = renglon.split(",");
            if (partes.length == 2) {
                mochila.put(partes[0], Integer.parseInt(partes[1]));
            }
        }
        lector.close();
        return mochila;
    }

    public void agregarEntradaBitacora(String textoLog) throws IOException {
        File logFile = new File(RUTA_CARPETA + "/bitacora.txt");
        BufferedWriter escritor = new BufferedWriter(new FileWriter(logFile, true));
        escritor.write(textoLog);
        escritor.newLine();
        escritor.close();
    }

    public void mostrarBitacora() throws IOException {
        File logFile = new File(RUTA_CARPETA + "/bitacora.txt");

        if (!logFile.exists()) {
            System.out.println("[Aviso] -> La bitácora está limpia.");
            return;
        }

        System.out.println("\n=== BITÁCORA DE BATALLAS ===");
        BufferedReader lector = new BufferedReader(new FileReader(logFile));
        String linea;
        int num = 1;

        while ((linea = lector.readLine()) != null) {
            System.out.println(num + ". " + linea);
            num++;
        }
        lector.close();
    }
}