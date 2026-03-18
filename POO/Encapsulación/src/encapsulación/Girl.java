/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encapsulación;

/**
 *
 * @author framir02
 */
public class Girl extends Person {
    private int _timeRelation;
    
    public Girl(String name, int age, int timeRelation){
       super(name, age);
       this._timeRelation = timeRelation;
    }
    
    public int getTimeRelation(){
        return this._timeRelation;
    }
    
    public void setTimeRelation(int time){
        if(time >= 0){
            this._timeRelation = time;
        }
        else {
            System.out.println("El tiempo de relacion no es válido");
        }
    }
    
    //mismo metodo del padre pero se comporta diferente con el hijo
    @Override
    public void say(){
        System.out.println("Hola me llamo " + getName());
        System.out.println("Tengo " + getAge() + " Años");
    }
}
