package com.cerp.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import com.cerp.Modelo.Pregunta;
import com.cerp.Vista.AdminVista;
import com.cerp.Vista.InicioVista;
import com.cerp.Vista.PreguntaVista;

public class InicioControlador implements ActionListener {

    private List<Pregunta> modelo;
    private InicioVista vista;

    public InicioControlador(List<Pregunta> modelo, InicioVista vista) {
        this.modelo = modelo;
        this.vista=vista;
        String nombre, apellido, direccion; //String son cadena de caracteres, letras, numeros y caracteres especiales *" @ etc.
        int edad, telefono;//Son valores númericos enteros. 5, 7, 9
        //Ejemplo si tengo int a = 8 y int b=4 y realizo la operación a + b = 12
        //Pero si tengo String a = 8 y String b= 4, y hago a + b = 84, en este caso no se suman, se concatenan(unir dos cadenas de caracteres diferentes). Perro + Azul, est es igual a PerroAzul, si hago Perro + " " + Azul, esto da Perro Azul
        
        String[] opciones1 = {"Encapsulamiento", "Herencia", "Polimorfismo", "Compilación"}; // [] Coleccion de datos, más de un dato dentro de la misma variable
        Pregunta nuevaPregunta1 = new Pregunta(modelo.size() + 1, "¿Cuál de los siguientes conceptos NO es un pilar fundamental de la Programación Orientada a Objetos?", "Compilación", opciones1);
        this.modelo.add(nuevaPregunta1);

        String[] opciones2 = {"Objeto", "Método", "Clase", "Atributo"};
        Pregunta nuevaPregunta2 = new Pregunta(modelo.size() + 1, "¿Qué se conoce como la plantilla o plano a partir del cual se crean los objetos en Java?", "Clase", opciones2);
        this.modelo.add(nuevaPregunta2);

        String[] opciones3 = {"Ocultar la complejidad interna de un objeto y controlar el acceso a sus datos.", "Permitir que una clase herede características de otra clase.", "Definir múltiples métodos con el mismo nombre pero diferente firma.", "Crear instancias de una clase."};
        Pregunta nuevaPregunta3 = new Pregunta(modelo.size() + 1, "¿Cuál es el propósito principal del encapsulamiento en la POO?", "Ocultar la complejidad interna de un objeto y controlar el acceso a sus datos.", opciones3);
        this.modelo.add(nuevaPregunta3);

        String[] opciones4 = {"Métodos", "Clases", "Atributos", "Constructores"};
        Pregunta nuevaPregunta4 = new Pregunta(modelo.size() + 1, "¿Cómo se denomina a las variables que pertenecen a un objeto y almacenan su estado?", "Atributos", opciones4);
        this.modelo.add(nuevaPregunta4);

        String[] opciones5 = {"Método principal", "Método estático", "Constructor", "Método abstracto"};
        Pregunta nuevaPregunta5 = new Pregunta(modelo.size() + 1, "¿Qué tipo especial de método se utiliza para inicializar un objeto recién creado en Java?", "Constructor", opciones5);
        this.modelo.add(nuevaPregunta5);
        
        vista.getItemAdmin().addActionListener(this);
        vista.getItemPreguntas().addActionListener(this);

        vista.getLabelPreguntas().setText("Hay en el sistema " + modelo.size() + " preguntas");
    }

    public void ActualizarControlador() {
        vista.getLabelPreguntas().setText("Hay en el sistema " + modelo.size() + " preguntas");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getItemAdmin()) {
            System.out.println("Hola admin");

            // Crear instancia de AdminControlador y mostrar vista AdminVista
            AdminVista vistaAdmin = new AdminVista(vista);
            AdminControlador controladorAdmin = new AdminControlador(modelo, vistaAdmin, vista);

        } else if (e.getSource() == vista.getItemPreguntas()) {
            System.out.println("Hola juego");

            // Crear instancia de AdminControlador y mostrar vista AdminVista
            PreguntaVista vistaPregunta = new PreguntaVista(vista);

            System.out.println("Hola juego luego de crear vistaPregunta");
            PreguntaControlador controladorPregunta = new PreguntaControlador(modelo, vistaPregunta, vista);

        }

        vista.dispose();

        /*  try {
            vista.getFileHandler().listToFile(modelo);
            System.out.println("******************\nEl tamanio es " + modelo.size() + "\nLista guardada correctamente");
        } catch (IOException err) {
            // TODO Auto-generated catch block
            err.printStackTrace();
        }*/
    }

    public List<Pregunta> getModelo() {
        return modelo;
    }

    public void setModelo(List<Pregunta> modelo) {
        this.modelo = modelo;
    }

    public void guardarPreguntas() {
        try {
            vista.getFileHandler().listToFile(modelo);
            System.out.println("******************\nEl tamanio es " + modelo.size() + "\nLista guardada correctamente");
        } catch (IOException err) {
            err.printStackTrace();
        }
    }

}
