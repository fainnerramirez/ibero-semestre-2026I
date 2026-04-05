package atleticoibero;

import java.util.Scanner;

public class AtleticoIbero {
    /**
    * Proyecto: Sistema de gestión de equipo de fútbol "Atlético Ibero"
    * Materia: Programación Orientada a Objetos (POO)
    * Universidad: Iberoamericana
    * 
    * Descripción:
    * Este sistema permite gestionar la información de un equipo de fútbol,
    * incluyendo el registro, búsqueda, actualización y eliminación de
    * jugadores y entrenadores.
    * 
    * Se aplican conceptos fundamentales de POO como:
    * - Encapsulamiento
    * - Herencia
    * - Polimorfismo
    * - Uso de colecciones (ArrayList)
    * 
    * Estudiante: Fainner Ramirez
    * Fecha: 05/04/2026
    */
    

    public static void main(String[] args) {

        Team team = new Team();
        Scanner input = new Scanner(System.in);
        String optionUser = "";

        while (!optionUser.equals("0")) {

            System.out.println("====== Equipo de football - Atletico Ibero ========");
            System.out.println("1. Registrar Jugador");
            System.out.println("2. Registrar Entrenador");
            System.out.println("3. Listar Jugadores");
            System.out.println("4. Listar Entrenadores");
            System.out.println("5. Eliminar Jugador");
            System.out.println("6. Eliminar Entrenador");
            System.out.println("7. Modificar Jugador");
            System.out.println("8. Modificar Entrenador");
            System.out.println("0. Salir");
            optionUser = input.next();

            switch (optionUser) {

                case "1":

                    System.out.println("Nombre del jugador: ");
                    String namePlayer = input.next();

                    System.out.println("Edad del jugador: ");
                    int agePlayer = input.nextInt();

                    System.out.println("Número del jugador: ");
                    int numberPlayer = input.nextInt();

                    System.out.println("Posición del jugador: ");
                    String positionPlayer = input.next();

                    var player = new Player(namePlayer, agePlayer, positionPlayer, numberPlayer);
                    team.registerPlayer(player);

                    break;

                case "2":

                    System.out.println("Nombre del entrenador: ");
                    String nameCoach = input.next();

                    System.out.println("Edad del entrenador: ");
                    int ageCoach = input.nextInt();

                    System.out.println("Estrategia del entrenador (4-3-3): ");
                    String strategyCoach = input.next();

                    var coach = new Coach(nameCoach, ageCoach, strategyCoach);
                    team.registerCoach(coach);
                    break;

                case "3":
                    team.listPlayers();
                    break;

                case "4":
                    team.listCoachs();
                    break;

                case "5":
                    System.out.println("Ingrese el número del jugador: ");
                    int numberPlayerToDelete = input.nextInt();
                    team.deletePayer(numberPlayerToDelete);
                    break;

                case "6":
                    System.out.println("Ingrese el nombre del entrenador: ");
                    String nameCoachToDelete = input.next();
                    team.deleteCoach(nameCoachToDelete);
                    break;

                case "7":
                    System.out.println("Ingrese el nuevo nombre: ");
                    String newNamePLayer = input.next();

                    System.out.println("Nueva edad del jugador: ");
                    int newAgePlayer = input.nextInt();

                    System.out.println("Nuevo número del jugador: ");
                    int newNumberPlayer = input.nextInt();

                    System.out.println("Nueva posición del jugador: ");
                    String newPositionPlayer = input.next();

                    var playerToModify = new Player(newNamePLayer, newAgePlayer, newPositionPlayer, newNumberPlayer);
                    team.UpdatePlayer(playerToModify);
                    break;

                case "8":
                    System.out.println("Nuevo nombre del entrenador: ");
                    String newNameCoach = input.next();

                    System.out.println("Nueva edad del entrenador: ");
                    int newAgeCoach = input.nextInt();

                    System.out.println("Nueva estrategia del entrenador: ");
                    String newStrategyCoach = input.next();

                    var coachToModify = new Coach(newNameCoach, newAgeCoach, newStrategyCoach);
                    team.UpdateCoach(coachToModify);

                    break;
            }

        }
    }
}
