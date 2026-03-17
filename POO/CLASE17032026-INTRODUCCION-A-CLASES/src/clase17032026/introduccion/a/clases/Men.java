/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase17032026.introduccion.a.clases;

/**
 *
 * @author framir02
 */
public class Men {
    String _name;
    String _lastName;
    int _edad;
    
    public Men(String name, String lastName, int edad){
        this._name = name;
        this._lastName = lastName;
        this._edad = edad;
    }
    
    public void say(){
        System.out.println("Hola...como estás?");
    }
    
    public void showInfo(){
        System.out.println("la información del usuario es:");
        System.out.println("nombre: " + this._name);
        System.out.println("apellido: " + this._lastName);
        System.out.println("edad: " + this._edad);
    }
}
