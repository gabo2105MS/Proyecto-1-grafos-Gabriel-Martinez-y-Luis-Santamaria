/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Functions;

import EDD.Grafo;
import EDD.Grafo_LA;
import EDD.Nodo_Grafo;
import EDD.Nodo_List;
import EDD.Simple_List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author gabri
 */
public class Function_TXT {
     public void readTxt(Grafo_LA grafo){
        
        Simple_List users = new Simple_List();
        Simple_List relations = new Simple_List();
        

        try {
            BufferedReader reader = new BufferedReader(new FileReader("test//archivo.txt"));
            String line;
            String currentSection = null;

            while ((line = reader.readLine()) != null) {
                if (line.equals("usuarios")) {
                    currentSection = "usuarios";
                } else if (line.equals("relaciones")) {
                    currentSection = "relaciones";
                } else {
                    if (currentSection != null) {
                        if (currentSection.equals("usuarios")) {
                            users.insertFinal(line);
                                Nodo_List n= new Nodo_List(line);
                                grafo.insertar(n);
//                               System.out.println(line);
                                    
                        } else if (currentSection.equals("relaciones")) {
                            String[] arista = line.split(", ");
                            System.out.println("---------------------------");
                            System.out.println(line);
                            System.out.println(arista[0]);
                            System.out.println(arista[1]);
                            System.out.println("---------------------------");
                            grafo.insertar_arista(arista[0], arista[1]);
                        }
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        grafo.show_Graph();
        

       

    }
     
     //funcion para reescribir el txt y agregar el usuarios
     public void writeTXT(String nuevoUsuario, String usuarioDestino){
         // Ruta al archivo de texto
        String rutaArchivo = "test//archivo.txt";
        
        
        try {
            // Variables para mantener el contenido
            StringBuilder usuarios = new StringBuilder();
            StringBuilder relaciones = new StringBuilder();
            
            // Variables para controlar en qué sección estamos
            boolean enUsuarios = false;
            boolean enRelaciones = false;
            boolean usuarioExistente = false;
            
            // Leer el archivo original
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.equals("usuarios")) {
                    enUsuarios = true;
                    enRelaciones = false;
                } else if (linea.equals("relaciones")) {
                    enUsuarios = false;
                    enRelaciones = true;
                } else {
                    if (enUsuarios) {
                        if (linea.equals(nuevoUsuario)) {
                            usuarioExistente = true;
                        }
                        usuarios.append(linea).append("\n");
                    } else if (enRelaciones) {
                        relaciones.append(linea).append("\n");
                    }
                }
            }
            br.close();
            
            // Verificar si el usuario ya existe
            if (!usuarioExistente) {
                usuarios.append(nuevoUsuario).append("\n");
            }
            
            // Agregar la nueva relación al final de la sección de relaciones
            relaciones.append(usuarioDestino).append(", ").append(nuevoUsuario).append("\n");
            
            // Escribir el contenido actualizado de vuelta al archivo
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo));
            bw.write("usuarios\n");
            bw.write(usuarios.toString());
            bw.write("relaciones\n");
            bw.write(relaciones.toString());
            bw.close();
            
            System.out.println("Usuario y relación agregados al archivo.");
        } catch (IOException e) {
            System.err.println("Error al leer o escribir el archivo: " + e.getMessage());
        }
    }
     
    
    //funcion para reescribir el txt y eliminar un usuario
    public void writeAndDeleteTXT(String usuarioAEliminar){
        // Ruta al archivo de texto
        String rutaArchivo = "test//archivo.txt";
        try {
            // Variables para mantener el contenido
            StringBuilder usuarios = new StringBuilder();
            StringBuilder relaciones = new StringBuilder();

            // Variables para controlar en qué sección estamos
            boolean enUsuarios = false;
            boolean enRelaciones = false;

            // Leer el archivo original
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            boolean eliminarUsuario = false;

            while ((linea = br.readLine()) != null) {
                if (linea.equals("usuarios")) {
                    enUsuarios = true;
                    enRelaciones = false;
                } else if (linea.equals("relaciones")) {
                    enUsuarios = false;
                    enRelaciones = true;
                } else {
                    if (enUsuarios) {
                        if (linea.equals(usuarioAEliminar)) {
                            eliminarUsuario = true;
                        } else {
                            usuarios.append(linea).append("\n");
                        }
                    } else if (enRelaciones) {
                        String[] partes = linea.split(", ");
                        if (!eliminarUsuario && !partes[0].equals(usuarioAEliminar) && !partes[1].equals(usuarioAEliminar)) {
                            relaciones.append(linea).append("\n");
                        } else if (eliminarUsuario) {
                            // No agregamos esta línea, lo que elimina la relación del usuario
                            eliminarUsuario = false; // Restablecemos el marcador
                        }
                    }
                }
            }
            br.close();

            // Escribir el contenido actualizado de vuelta al archivo
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo));
            bw.write("usuarios\n");
            bw.write(usuarios.toString());
            bw.write("relaciones\n");
            bw.write(relaciones.toString());
            bw.close();

            System.out.println("Relaciones del usuario eliminadas del archivo.");
        } catch (IOException e) {
            System.err.println("Error al leer o escribir el archivo: " + e.getMessage());
        }
    }
}
