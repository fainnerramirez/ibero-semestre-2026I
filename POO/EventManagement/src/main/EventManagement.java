package eventmanagement;

import java.util.List;
import java.util.Scanner;

import dao.CategoriaDAO;
import dao.EventoDAO;
import dao.PersonaDAO;
import models.Categoria;
import models.Evento;
import models.Persona;

public class EventManagement {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║       SISTEMA DE GESTIÓN DE EVENTOS  ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  1. Gestión de Eventos               ║");
            System.out.println("║  2. Gestión de Personas              ║");
            System.out.println("║  3. Gestión de Categorías            ║");
            System.out.println("║  4. Gestión de Inscripciones         ║");
            System.out.println("║  5. Gestión de Ponentes              ║");
            System.out.println("║  6. Gestión de Organizadores         ║");
            System.out.println("║  7. Gestión de Reservas              ║");
            System.out.println("║  8. Gestión de Pagos                 ║");
            System.out.println("║  9. Gestión de Notificaciones        ║");
            System.out.println("║  0. Salir                            ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("  Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> menuEventos();
                case 2 -> menuPersonas();
                case 3 -> menuCategorias();
                case 4 -> menuInscripciones();
                case 5 -> menuPonentes();
                case 6 -> menuOrganizadores();
                case 7 -> menuReservas();
                case 8 -> menuPagos();
                case 9 -> menuNotificaciones();
                case 0 -> System.out.println("\n  👋 ¡Hasta luego!\n");
                default -> System.out.println("  ⚠ Opción no válida.");
            }
        } while (opcion != 0);
    }

    // ─────────────────────────────────────────────
    //  MENÚ EVENTOS
    // ─────────────────────────────────────────────
    static void menuEventos() {
        EventoDAO dao = new EventoDAO();
        int op;
        do {
            System.out.println("\n┌─── GESTIÓN DE EVENTOS ───────────────┐");
            System.out.println("│  1. Listar todos los eventos          │");
            System.out.println("│  2. Buscar evento por ID              │");
            System.out.println("│  3. Crear nuevo evento                │");
            System.out.println("│  4. Actualizar evento                 │");
            System.out.println("│  5. Eliminar evento                   │");
            System.out.println("│  0. Volver al menú principal          │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.print("  Opción: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1 -> {
                    List<Evento> eventos = dao.listarTodos();
                    if (eventos.isEmpty()) {
                        System.out.println("  No hay eventos registrados.");
                    } else {
                        eventos.forEach(e -> System.out.println("  " + e));
                    }
                }
                case 2 -> {
                    System.out.print("  ID del evento: ");
                    int id = scanner.nextInt();
                    Evento e = dao.buscarPorId(id);
                    System.out.println(e != null ? "  " + e : "  Evento no encontrado.");
                }
                case 3 -> {
                    System.out.print("  Nombre: ");        String nombre = scanner.nextLine();
                    System.out.print("  Descripción: ");   String desc   = scanner.nextLine();
                    System.out.print("  Fecha (YYYY-MM-DD): "); String fecha = scanner.nextLine();
                    System.out.print("  Ubicación ID: ");  int ubicId = scanner.nextInt();
                    System.out.print("  Modalidad ID: ");  int modId  = scanner.nextInt();
                    System.out.print("  Tipo Evento ID: "); int tipoId = scanner.nextInt();
                    scanner.nextLine();

                    Evento nuevo = new Evento();
                    nuevo.setNombre(nombre);
                    nuevo.setDescripcion(desc);
                    // nuevo.setFecha(fecha);      ← ajusta según tu modelo
                    // nuevo.setUbicacionId(ubicId);
                    // nuevo.setModalidadId(modId);
                    // nuevo.setTipoEventoId(tipoId);
                    boolean ok = dao.insertar(nuevo);
                    System.out.println(ok ? "  ✅ Evento creado." : "  ❌ Error al crear evento.");
                }
                case 4 -> {
                    System.out.print("  ID del evento a actualizar: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    Evento e = dao.buscarPorId(id);
                    if (e == null) { System.out.println("  Evento no encontrado."); break; }
                    System.out.print("  Nuevo nombre (" + e.getNombre() + "): ");
                    String nom = scanner.nextLine();
                    if (!nom.isBlank()) e.setNombre(nom);
                    boolean ok = dao.actualizar(e);
                    System.out.println(ok ? "  ✅ Actualizado." : "  ❌ Error al actualizar.");
                }
                case 5 -> {
                    System.out.print("  ID del evento a eliminar: ");
                    int id = scanner.nextInt();
                    boolean ok = dao.eliminar(id);
                    System.out.println(ok ? "  ✅ Eliminado." : "  ❌ Error al eliminar.");
                }
                case 0 -> System.out.println("  ↩ Volviendo...");
                default -> System.out.println("  ⚠ Opción no válida.");
            }
        } while (op != 0);
    }

    // ─────────────────────────────────────────────
    //  MENÚ PERSONAS
    // ─────────────────────────────────────────────
    static void menuPersonas() {
        PersonaDAO dao = new PersonaDAO();
        int op;
        do {
            System.out.println("\n┌─── GESTIÓN DE PERSONAS ──────────────┐");
            System.out.println("│  1. Listar personas                   │");
            System.out.println("│  2. Buscar por ID                     │");
            System.out.println("│  3. Registrar persona                 │");
            System.out.println("│  4. Actualizar persona                │");
            System.out.println("│  5. Eliminar persona                  │");
            System.out.println("│  0. Volver                            │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.print("  Opción: ");
            op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1 -> dao.listarTodos().forEach(p -> System.out.println("  " + p));
                case 2 -> {
                    System.out.print("  ID: ");
                    Persona p = dao.buscarPorId(scanner.nextInt());
                    System.out.println(p != null ? "  " + p : "  No encontrado.");
                }
                case 3 -> {
                    System.out.print("  Nombre: ");    String nom  = scanner.nextLine();
                    System.out.print("  Apellido: ");  String ape  = scanner.nextLine();
                    System.out.print("  Email: ");     String mail = scanner.nextLine();
                    System.out.print("  Teléfono: ");  String tel  = scanner.nextLine();
                    Persona p = new Persona();
                    p.setNombre(nom); p.setApellido(ape);
                    p.setEmail(mail); p.setTelefono(tel);
                    System.out.println(dao.insertar(p) ? "  ✅ Persona registrada." : "  ❌ Error.");
                }
                case 4 -> {
                    System.out.print("  ID: "); int id = scanner.nextInt(); scanner.nextLine();
                    Persona p = dao.buscarPorId(id);
                    if (p == null) { System.out.println("  No encontrado."); break; }
                    System.out.print("  Nuevo email (" + p.getEmail() + "): ");
                    String mail = scanner.nextLine();
                    if (!mail.isBlank()) p.setEmail(mail);
                    System.out.println(dao.actualizar(p) ? "  ✅ Actualizado." : "  ❌ Error.");
                }
                case 5 -> {
                    System.out.print("  ID: ");
                    System.out.println(dao.eliminar(scanner.nextInt()) ? "  ✅ Eliminado." : "  ❌ Error.");
                }
                case 0 -> System.out.println("  ↩ Volviendo...");
                default -> System.out.println("  ⚠ Opción no válida.");
            }
        } while (op != 0);
    }

    // ─────────────────────────────────────────────
    //  MENÚ CATEGORÍAS
    // ─────────────────────────────────────────────
    static void menuCategorias() {
        CategoriaDAO dao = new CategoriaDAO();
        int op;
        do {
            System.out.println("\n┌─── GESTIÓN DE CATEGORÍAS ────────────┐");
            System.out.println("│  1. Listar categorías                 │");
            System.out.println("│  2. Buscar por ID                     │");
            System.out.println("│  3. Crear categoría                   │");
            System.out.println("│  4. Actualizar categoría              │");
            System.out.println("│  5. Eliminar categoría                │");
            System.out.println("│  0. Volver                            │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.print("  Opción: ");
            op = scanner.nextInt(); scanner.nextLine();

            switch (op) {
                case 1 -> dao.listarTodos().forEach(c -> System.out.println("  " + c));
                case 2 -> {
                    System.out.print("  ID: ");
                    Categoria c = dao.buscarPorId(scanner.nextInt());
                    System.out.println(c != null ? "  " + c : "  No encontrada.");
                }
                case 3 -> {
                    System.out.print("  Nombre categoría: ");
                    String nom = scanner.nextLine();
                    Categoria c = new Categoria(); c.setNombre(nom);
                    System.out.println(dao.insertar(c) ? "  ✅ Categoría creada." : "  ❌ Error.");
                }
                case 4 -> {
                    System.out.print("  ID: "); int id = scanner.nextInt(); scanner.nextLine();
                    Categoria c = dao.buscarPorId(id);
                    if (c == null) { System.out.println("  No encontrada."); break; }
                    System.out.print("  Nuevo nombre: "); String nom = scanner.nextLine();
                    if (!nom.isBlank()) c.setNombre(nom);
                    System.out.println(dao.actualizar(c) ? "  ✅ Actualizado." : "  ❌ Error.");
                }
                case 5 -> {
                    System.out.print("  ID: ");
                    System.out.println(dao.eliminar(scanner.nextInt()) ? "  ✅ Eliminada." : "  ❌ Error.");
                }
                case 0 -> System.out.println("  ↩ Volviendo...");
                default -> System.out.println("  ⚠ Opción no válida.");
            }
        } while (op != 0);
    }

    // ─────────────────────────────────────────────
    //  MENÚ INSCRIPCIONES
    // ─────────────────────────────────────────────
    static void menuInscripciones() {
        // InscripcionDAO dao = new InscripcionDAO();  ← descomenta cuando tengas el DAO
        int op;
        do {
            System.out.println("\n┌─── GESTIÓN DE INSCRIPCIONES ─────────┐");
            System.out.println("│  1. Listar inscripciones              │");
            System.out.println("│  2. Inscribir persona a evento        │");
            System.out.println("│  3. Cancelar inscripción              │");
            System.out.println("│  0. Volver                            │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.print("  Opción: ");
            op = scanner.nextInt(); scanner.nextLine();
            switch (op) {
                case 1 -> System.out.println("  [Implementar: dao.listarTodos()]");
                case 2 -> {
                    System.out.print("  ID Persona: ");  int pId = scanner.nextInt();
                    System.out.print("  ID Evento: ");   int eId = scanner.nextInt(); scanner.nextLine();
                    System.out.println("  [Implementar: dao.inscribir(" + pId + ", " + eId + ")]");
                }
                case 3 -> {
                    System.out.print("  ID Inscripción: "); int id = scanner.nextInt(); scanner.nextLine();
                    System.out.println("  [Implementar: dao.eliminar(" + id + ")]");
                }
                case 0 -> System.out.println("  ↩ Volviendo...");
                default -> System.out.println("  ⚠ Opción no válida.");
            }
        } while (op != 0);
    }

    // ─────────────────────────────────────────────
    //  MENÚ PONENTES
    // ─────────────────────────────────────────────
    static void menuPonentes() {
        int op;
        do {
            System.out.println("\n┌─── GESTIÓN DE PONENTES ──────────────┐");
            System.out.println("│  1. Listar ponentes                   │");
            System.out.println("│  2. Registrar ponente                 │");
            System.out.println("│  3. Actualizar ponente                │");
            System.out.println("│  4. Eliminar ponente                  │");
            System.out.println("│  0. Volver                            │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.print("  Opción: ");
            op = scanner.nextInt(); scanner.nextLine();
            switch (op) {
                case 1 -> System.out.println("  [Implementar con PonteDAO]");
                case 2 -> {
                    System.out.print("  Nombre ponente: "); String nom = scanner.nextLine();
                    System.out.print("  Especialidad: ");   String esp = scanner.nextLine();
                    System.out.println("  [Implementar: dao.insertar(ponente)]");
                }
                case 3, 4 -> System.out.println("  [Implementar con PonteDAO]");
                case 0 -> System.out.println("  ↩ Volviendo...");
                default -> System.out.println("  ⚠ Opción no válida.");
            }
        } while (op != 0);
    }

    // ─────────────────────────────────────────────
    //  MENÚ ORGANIZADORES
    // ─────────────────────────────────────────────
    static void menuOrganizadores() {
        int op;
        do {
            System.out.println("\n┌─── GESTIÓN DE ORGANIZADORES ─────────┐");
            System.out.println("│  1. Listar organizadores              │");
            System.out.println("│  2. Registrar organizador             │");
            System.out.println("│  3. Actualizar organizador            │");
            System.out.println("│  4. Eliminar organizador              │");
            System.out.println("│  0. Volver                            │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.print("  Opción: ");
            op = scanner.nextInt(); scanner.nextLine();
            switch (op) {
                case 1, 2, 3, 4 -> System.out.println("  [Implementar con OrganizadorDAO]");
                case 0 -> System.out.println("  ↩ Volviendo...");
                default -> System.out.println("  ⚠ Opción no válida.");
            }
        } while (op != 0);
    }

    // ─────────────────────────────────────────────
    //  MENÚ RESERVAS
    // ─────────────────────────────────────────────
    static void menuReservas() {
        int op;
        do {
            System.out.println("\n┌─── GESTIÓN DE RESERVAS ──────────────┐");
            System.out.println("│  1. Listar reservas                   │");
            System.out.println("│  2. Crear reserva                     │");
            System.out.println("│  3. Cancelar reserva                  │");
            System.out.println("│  0. Volver                            │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.print("  Opción: ");
            op = scanner.nextInt(); scanner.nextLine();
            switch (op) {
                case 1, 2, 3 -> System.out.println("  [Implementar con ReservaDAO]");
                case 0 -> System.out.println("  ↩ Volviendo...");
                default -> System.out.println("  ⚠ Opción no válida.");
            }
        } while (op != 0);
    }

    // ─────────────────────────────────────────────
    //  MENÚ PAGOS
    // ─────────────────────────────────────────────
    static void menuPagos() {
        int op;
        do {
            System.out.println("\n┌─── GESTIÓN DE PAGOS ─────────────────┐");
            System.out.println("│  1. Listar pagos                      │");
            System.out.println("│  2. Registrar pago                    │");
            System.out.println("│  3. Anular pago                       │");
            System.out.println("│  0. Volver                            │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.print("  Opción: ");
            op = scanner.nextInt(); scanner.nextLine();
            switch (op) {
                case 1, 2, 3 -> System.out.println("  [Implementar con PagoDAO]");
                case 0 -> System.out.println("  ↩ Volviendo...");
                default -> System.out.println("  ⚠ Opción no válida.");
            }
        } while (op != 0);
    }

    // ─────────────────────────────────────────────
    //  MENÚ NOTIFICACIONES
    // ─────────────────────────────────────────────
    static void menuNotificaciones() {
        int op;
        do {
            System.out.println("\n┌─── GESTIÓN DE NOTIFICACIONES ────────┐");
            System.out.println("│  1. Ver notificaciones                │");
            System.out.println("│  2. Enviar notificación               │");
            System.out.println("│  3. Eliminar notificación             │");
            System.out.println("│  0. Volver                            │");
            System.out.println("└───────────────────────────────────────┘");
            System.out.print("  Opción: ");
            op = scanner.nextInt(); scanner.nextLine();
            switch (op) {
                case 1, 2, 3 -> System.out.println("  [Implementar con NotificacionDAO]");
                case 0 -> System.out.println("  ↩ Volviendo...");
                default -> System.out.println("  ⚠ Opción no válida.");
            }
        } while (op != 0);
    }
}