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
}
