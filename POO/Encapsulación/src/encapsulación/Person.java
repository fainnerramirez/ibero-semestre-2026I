/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encapsulación;

/**
 *
 * @author framir02 - Ibero
 */
public class Person {
    
    private String _name;
    private int _age;
    
    public Person(String name, int age){
        this._name = name;
        this._age = age;
    }
    
    //getters and setters
    public String getName(){
        return this._name;
    }
    
    public int getAge(){
        return this._age;
    }
    
    public void setName(String name){
        this._name = name;
    }
    
    public void setAge(int age){
        if(this._age > 0) {
            this._age = age;
        }
        else {
            System.out.println("Edad inválida...ingresa una edad válida");
        }
    }    
}