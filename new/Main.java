import java.util.*;

// esta es la interface dice lo que puede hacer
interface Operaciones {
    void agregar(String nombre, int nota);
    void eliminar(String nombre);
    void buscar(String nombre);
    void listar();
}
// Esta es la clase que hace lo que dice la interfaz

class SistemaNotas implements Operaciones {
    private Map<String, Integer> mapaNotas = new HashMap<>();

        // Usamos un Map para guardar el nombre y la nota del estudiante

    public void agregar(String nombre, int nota) {
        mapaNotas.put(nombre, nota);
        System.out.println("Estudiante agregado.");
    }

    public void eliminar(String nombre) {
        if (mapaNotas.containsKey(nombre)) {
            mapaNotas.remove(nombre);
            System.out.println("Estudiante eliminado.");
        } else {
            System.out.println("No se encontró al estudiante.");
        }
    }

    public void buscar(String nombre) {
        if (mapaNotas.containsKey(nombre)) {
            System.out.println(nombre + " tiene nota: " + mapaNotas.get(nombre));
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    public void listar() {
        System.out.println("Lista de estudiantes:");
        for (String nombre : mapaNotas.keySet()) {
            System.out.println(nombre + " - " + mapaNotas.get(nombre));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SistemaNotas sistema = new SistemaNotas();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("1. Agregar");
            System.out.println("2. Eliminar");
            System.out.println("3. Buscar");
            System.out.println("4. Listar");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Nota: ");
                    int nota = sc.nextInt();
                    sc.nextLine(); // limpiar buffer
                    sistema.agregar(nombre, nota);
                    break;
                case 2:
                    System.out.print("Nombre a eliminar: ");
                    String elim = sc.nextLine();
                    sistema.eliminar(elim);
                    break;
                case 3:
                    System.out.print("Nombre a buscar: ");
                    String busc = sc.nextLine();
                    sistema.buscar(busc);
                    break;
                case 4:
                    sistema.listar();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 5);

        sc.close(); //  cerramos el Scanner
    }
}
