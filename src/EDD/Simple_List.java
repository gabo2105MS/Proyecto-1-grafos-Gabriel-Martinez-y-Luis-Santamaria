/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author gabri
 */
public class Simple_List {

    //atributos
    private Nodo_List head;
    private int size;

    //constructor
    public Simple_List() {
        this.head = null;
        this.size = 0;
    }

    //getter and setter
    public Nodo_List getHead() {
        return head;
    }

    public void setHead(Nodo_List head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //primitivas
    public boolean isEmpty() {
        return this.head == null;
    }

    public void getEmpty() {
        setHead(null);
    }

    public void show() {
        Nodo_List aux = getHead();
        while (aux != null) {
            System.out.println(aux.getElement());
            aux = aux.getPnext();
        }
    }

    //funciones--------------------------------------------------------------------
    //insertar inicio
    public void insertBeging(String element) {
        Nodo_List pnew = new Nodo_List(element);
        if (isEmpty()) {
            setHead(pnew);
        } else {
            pnew.setPnext(getHead());
            setHead(pnew);
        }
        size++;
    }

    //insertar final
    public void insertFinal(String element) {
        Nodo_List pnew = new Nodo_List(element);
        if (isEmpty()) {
            setHead(pnew);
            size++;
        } else {
            Nodo_List aux = getHead();
            while (aux.getPnext() != null) {
                aux = aux.getPnext();
            }
            aux.setPnext(pnew);
            size++;
        }

    }

    //eliminar inicio
    public void deleteBeging() {
        if (isEmpty()) {
            System.out.println("No hay nada que elimminar");
        } else {
            setHead(getHead().getPnext());
            size--;
        }
    }

    //elimminar final
    public void deleteFinal() {
        if (isEmpty()) {
            System.out.println("No hay nada que eliminar");
        } else {
            Nodo_List aux = getHead();
            while (aux.getPnext().getPnext() != null) {
                aux = aux.getPnext();
            }
            aux.setPnext(null);
            size--;
        }
    }

    //insertar por indice
    public void insertIndex(int index, String element) {
        Nodo_List pnew = new Nodo_List(element);
        if (isEmpty()) {
            setHead(pnew);
        } else {
            if (index == 0) {
                insertBeging(element);
            } else if (index < size) {
                Nodo_List aux = getHead();
                int cont = 0;
                while (cont < index - 1 && aux != null) {
                    aux = aux.getPnext();
                    cont++;
                }
                Nodo_List aux2 = aux.getPnext();
                aux.setPnext(pnew);
                pnew.setPnext(aux2);
            } else {
                System.out.println("Error in index");
            }
        }
        size++;
    }

    //funcion para buscar elementos dentro de la lista con indice
    public Object getElement(int index) {

        if (index >= 0 && index <= getSize()) {
            if (index == 0) {
                return getHead().getElement();
            } else {
                Nodo_List aux = getHead();
                for (int i = 0; i < index; i++) {
                    aux = aux.getPnext();
                }
                return aux.getElement();
            }
        } else {
            return null;
        }
    }
    //funcion para eliminar un nstring de la lista

    public void delete(String name) {
        Nodo_List aux = this.getHead();
        while (aux.getPnext() != null && !aux.getPnext().getElement().equals(name)) {
            aux = aux.getPnext();
        }

        if (aux.getPnext() != null) {
            aux.setPnext(aux.getPnext().getPnext());
        }

    }
//        public void show(){
//          Nodo_List aux = getHead();
//            while(aux.getPnext() != null){
//                System.out.println("Sirve");
//                System.out.println(aux.getElement());
//                aux = aux.getPnext();
//            }

//        }
}
