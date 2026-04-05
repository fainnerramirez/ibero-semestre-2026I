package atleticoibero;

public class Player  extends Person {
    
    private String position;
    private int number;

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
    
    public String getPosition() {
        return position;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }   
    
    public void setNumber(int number){
        this.number = number;
    }
    
    public void setPosition(String position){
        this.position = position;
    }
}
