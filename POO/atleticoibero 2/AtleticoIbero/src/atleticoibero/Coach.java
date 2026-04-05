/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atleticoibero;

/**
 *
 * @author framir02
 */
public class Coach extends Person {
    
    private String strategy;
    
    public Coach(String name, int age, String strategy) {
        super(name, age);
        this.strategy = strategy;
    }
    
    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getStrategy() {
        return strategy;
    }
    
     public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    @Override
    public void showinfo() {
        System.out.println("coach: " + name +
                " | age: " + age +
                " | strategy: " + strategy);
    }
}
