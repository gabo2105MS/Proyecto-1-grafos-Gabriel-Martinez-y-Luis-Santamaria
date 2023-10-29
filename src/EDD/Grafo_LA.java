/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * 1-2-4
 *
 * 3
 * 4
 * 5-4-3-2
 *
 * @author gabri
 */
//clase grafo de listas de adyacencia
public class Grafo_LA {

    Simple_List[] usuarios;
    int tamano_grafo;

    //constructor
    public Grafo_LA(int tamano) {
        usuarios = new Simple_List[tamano];
        tamano_grafo = tamano;
    }

    //funcion para insertar un nodo dentro del grafo
    public void insertar(Nodo_List n) {
        boolean insertado = false;
        for (int i = 0; i < tamano_grafo; i++) {
            if (usuarios[i] == null) {
                usuarios[i] = new Simple_List();
                usuarios[i].setHead(n);
                insertado = true;

                break;
            }
        }
        if (!insertado) {
            Grafo_LA nuevo = new Grafo_LA(tamano_grafo + 1);
            for (int i = 0; i < tamano_grafo; i++) {
                nuevo.insertar(usuarios[i].getHead());
            }
            nuevo.insertar(n);
            usuarios = nuevo.usuarios;
            tamano_grafo++;

        }
    }

    //funcion para imprimir el grafo
    public void imprimir_grafo() {
        for (int i = 0; i < tamano_grafo; i++) {
            if (usuarios[i] != null) {
                System.out.println(usuarios[i].getHead().getElement());
                usuarios[i].show();
            }
        }
    }

    //funcion para eliminar un usuario
    public void eliminar(String usuario) {
        if (buscarUser(usuario)) {

            for (int i = 0; i < tamano_grafo; i++) {
                if (usuarios[i].getHead().getElement().equals(usuario)) {
                    usuarios[i] = null;
                    tamano_grafo--;

                } else {
                    usuarios[i].delete(usuario);

                }
            }
            System.out.println("Eliminado");
        }
    }

    //funcion para buscar un usuario en el grafo
    public boolean buscarUser(String usuario) {
        for (int i = 0; i < tamano_grafo; i++) {
            if (usuarios[i].getHead().getElement().equals(usuario)) {
                return true;
            } 
        }
        return false;
    }

    //funcion para insertar una relacion
    public void insertar_arista(String usuario_origen, String usuario_Destino) {

        if (buscarUser(usuario_origen) && buscarUser(usuario_Destino)) {
            for (int i = 0; i < tamano_grafo; i++) {
                if (usuarios[i].getHead().getElement().equals(usuario_origen)) {
                    usuarios[i].insertFinal(usuario_Destino);
                    System.out.println("insertado");
                    break;
                }
            }
        }
    }

    public void show_Graph() {
        System.out.println(tamano_grafo);
        System.out.println("");
        for (int i = 0; i < tamano_grafo; i++) {
            if (usuarios[i] != null) {
                usuarios[i].show();
                System.out.println("");
            }
        }

    }
    
    //validacion del user name proporcionado por el usuario
    public boolean userNameValidation(String username) {
        //Verificar que el nombre de usuario comience con @
        if (!username.startsWith("@")) {
            return false;
        }

        // Verificar que el nombre de usuario consista en letras minúsculas, números y @
        for (char c : username.substring(1).toCharArray()) {
            if (!(Character.isLowerCase(c) || Character.isDigit(c) || c == '@')) {
                return false;
            }
        }
        return true;
    }
    
    
       public int getSize() {
        return tamano_grafo;
    }

    public Simple_List[] getUsers() {
        return usuarios;
    }
}
