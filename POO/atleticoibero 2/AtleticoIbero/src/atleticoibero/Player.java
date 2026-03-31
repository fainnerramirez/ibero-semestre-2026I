
package atleticoibero;

public class Player  extends Person {
    
    private final String position;
    private final int number;
 
    public Player(String name, int age, String position, int number) {
        super(name, age);
        this.position = position;
        this.number = number;
    }
    
    @Override
    public void showinfo() {
    
        System.out.println("Player:" + name +
                "| age: " + age +
                " | position: " + position +
                " | number: " + number);
    }
    
            
            
}
