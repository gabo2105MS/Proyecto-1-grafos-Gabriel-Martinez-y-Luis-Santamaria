/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author gabri
 */
public class Nodo_List {
      //atributos
    private Nodo_List pnext;
    private String element;
    
    //constructor
    public Nodo_List( String element) {
        this.pnext = null;
        this.element = element;
    }
    
    //getter and setter

    public Nodo_List getPnext() {
        return pnext;
    }

    public void setPnext(Nodo_List pnext) {
        this.pnext = pnext;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
