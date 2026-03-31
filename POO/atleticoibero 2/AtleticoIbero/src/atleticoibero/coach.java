
package atleticoibero;

public class coach extends Person  {
    
    private final  String strategy;
    
    public coach(String name, int age, String strategy) {
        super(name, age);
        this.strategy = strategy;
    }
    
    @Override
    public void showinfo() {
        System.out.println("coach: " + name +
                " | age: " + age +
                " | strategy: " + strategy);
    }
    
    
    
}
