package atleticoibero;

import java.util.ArrayList;

/**
 *
 * @author framir02 - ibero
 */
public class Team {
    private ArrayList<Player> players;
    private ArrayList<Coach> coachs;
    
    public Team(){
        this.players = new ArrayList<Player>();
        this.coachs = new ArrayList<Coach>();
    }
    
    public Player searchPlayerByNumber(int number){
        return players.stream().filter(e -> e.getNumber() == number).findFirst().orElse(null);
    }
    
    public Coach searchCoachByName(String name){
        return coachs.stream().filter(e -> e.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
    
    public void registerPlayer(Player player){
        var existPlayer = searchPlayerByNumber(player.getNumber());
        if(existPlayer != null){
            System.out.println("El jugador con el número " + player.getNumber() + " ya existe. Escoge otro número");
            return;
        }
        this.players.add(player);
    }
    
    public void registerCoach(Coach coach){
        var existCoach = searchCoachByName(coach.getName());
        if(existCoach != null){
            System.out.println("El entreandor con nombre " + coach.getName() + " ya existe. Escoge otro nombre");
            return;
        }
        this.coachs.add(coach);
    }
    
    public void listPlayers(){
        int i = 1;
        System.out.println("==== Lista de jugadores del equipo ====");
        for(Player player: this.players){
            System.out.println("Jugador número "+ i);
            System.out.println("Nombre: " + player.getName());
            System.out.println("Posición: " + player.getPosition());
            System.out.println("Número: " + player.getNumber());
            System.out.println("-------------------------------------");
            i++;
        }
    }
    
    public void listCoachs(){
        int i = 1;
        System.out.println("==== Lista de entrenadores ====");
        for(Coach coach: this.coachs){
            System.out.println("Entreador número "+ i);
            System.out.println("Nombre: " + coach.getName());
            System.out.println("Estratégia: " + coach.getStrategy());
            System.out.println("-------------------------------------");
            i++;
        }
    }
    
    public boolean deletePayer(int numberPlayer){
        var existPlayer = searchPlayerByNumber(numberPlayer);
        if(existPlayer == null){
            System.out.println("El jugador con el número " + numberPlayer + " No existe.");
            return false;
        }
        
        this.players.remove(existPlayer);
        return true;
    }
    
    public boolean deleteCoach(String nameCoach){
        var existCoach = searchCoachByName(nameCoach);
        if(existCoach == null){
            System.out.println("El entreador con nombre " + nameCoach + " no existe.");
            return false;
        }
        
        this.coachs.remove(existCoach);
        return true;
    }
    
    public boolean UpdatePlayer(Player player){
        var existPlayer = searchPlayerByNumber(player.getNumber());
        if(existPlayer == null){
            System.out.println("El jugador con número " + player.getNumber() + " No existe.");
            return false;
        }
        
        existPlayer.setAge(player.getAge());
        existPlayer.setName(player.getName());
        existPlayer.setNumber(player.getNumber());
        existPlayer.setPosition(player.getPosition());
        
        return true;
    }
    
    public boolean UpdateCoach(Coach coach){
        var existCoach = searchCoachByName(coach.getName());
        if(existCoach == null){
            System.out.println("El entrenador con nombre " + coach.getName() + " No existe.");
            return false;
        }
        
        existCoach.setAge(coach.getAge());
        existCoach.setName(coach.getName());
        existCoach.setStrategy(coach.getStrategy());
        
        return true;
    }
}