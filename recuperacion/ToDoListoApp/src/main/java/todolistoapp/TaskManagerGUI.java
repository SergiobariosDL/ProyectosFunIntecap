/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package todolistoapp;
  import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.Graphics;
/**
 *
 * @author Usuario
 */
public class TaskManagerGUI extends JFrame {

   



    private final DefaultListModel<String> modeloTareas = new DefaultListModel<>();
    private final ArrayList<Tarea> listaTareas = new ArrayList<>();

    private final JList<String> lista;
    private final JTextField campoNombre;
    private final JComboBox<String> comboPrioridad;
    private final JComboBox<String> comboCategoria;
        private final JButton btnAgregar;
        private final JButton btnEliminar;
        private final JButton btnEditar;
        private final JButton btnCompletar;
        private final JButton btnFiltrar;
        private final JButton btnMostrarTodas;
         private final JButton btnIm;
        
        
    public TaskManagerGUI() {
        setTitle("Gestor de Tareas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior: entrada de datos
        JPanel panelSuperior = new JPanel(new FlowLayout (FlowLayout.LEFT));
        panelSuperior.add(new JLabel("Tarea:"));
        campoNombre = new JTextField(10);
        panelSuperior.add(campoNombre);

        panelSuperior.add(new JLabel("Prioridad:"));
        comboPrioridad = new JComboBox<>(new String[]{"Alta", "Media", "Baja"});
        panelSuperior.add(comboPrioridad);

        panelSuperior.add(new JLabel("Categoría:"));
        comboCategoria = new JComboBox<>(new String[]{"Trabajo", "Personal", "Estudio"});
        panelSuperior.add(comboCategoria);

        btnAgregar = new JButton("Agregar");
        panelSuperior.add(btnAgregar);

        add(panelSuperior, BorderLayout.NORTH);

        // Panel central: lista de tareas
        lista = new JList<>(modeloTareas);
        add(new JScrollPane(lista), BorderLayout.CENTER);

        // Panel inferior: botones de acción
        JPanel panelInferior = new JPanel();
        btnEliminar = new JButton("Eliminar");
        btnEditar = new JButton("Editar");
        btnCompletar = new JButton("Completar");
        btnFiltrar = new JButton("Filtrar");
        btnMostrarTodas = new JButton("Mostrar Todo");
        btnIm = new JButton("Imprimir");
        
        panelInferior.add(btnEliminar);
        panelInferior.add(btnEditar);
        panelInferior.add(btnCompletar);
        panelInferior.add(btnFiltrar);
        
        
        
        panelInferior.add(btnMostrarTodas);
        panelInferior.add(btnIm);
        
        
        
        
        
        
        
        

        add(panelInferior, BorderLayout.SOUTH);

        // Eventos
        btnAgregar.addActionListener(e -> agregarTarea());
        btnEliminar.addActionListener(e -> eliminarTarea());
        btnEditar.addActionListener(e -> editarTarea());
        btnCompletar.addActionListener(e -> completarTarea());
        btnFiltrar.addActionListener(e -> filtrarTareas());
        btnMostrarTodas.addActionListener(e -> mostrarTodasTareas());
        
        
  btnIm.addActionListener(e -> {
    PrinterJob job = PrinterJob.getPrinterJob();
    job.setJobName("Impresión de Tareas");

    job.setPrintable((graphics, pageFormat, pageIndex) -> {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        int y = 100; // posición vertical inicial
        graphics.drawString("===== Lista de Tareas =====", 100, y);
        y += 20;

        for (Tarea t : listaTareas) {
            graphics.drawString(t.toString(), 100, y);
            y += 20; // espacio entre líneas
        }

        graphics.drawString("==========================", 100, y);
        return Printable.PAGE_EXISTS;
    });

    try {
        if (job.printDialog()) { // muestra diálogo de impresora
            job.print();
        }
    } catch (PrinterException ex) {
        ex.printStackTrace();
    }
});
        
    }

    // Clase interna para representar una tarea
    class Tarea {
        String nombre, prioridad, categoria;
        boolean completada;

        public Tarea(String nombre, String prioridad, String categoria) {
            this.nombre = nombre;
            this.prioridad = prioridad;
            this.categoria = categoria;
            this.completada = false;
        }

        @Override
        public String toString() {
            return (completada ? "[✔] " : "[ ] ") + nombre + " - " + prioridad + " - " + categoria;
        }
    }
    
    
    
    

    // Métodos funcionales
    private void mostrarTodasTareas() {
    modeloTareas.clear();
    for (Tarea t : listaTareas) {
        modeloTareas.addElement(t.toString());
    }
}
    private void agregarTarea() {
        String nombre = campoNombre.getText();
        if (nombre.isEmpty()) return;

        String prioridad = (String) comboPrioridad.getSelectedItem();
        String categoria = (String) comboCategoria.getSelectedItem();
        Tarea tarea = new Tarea(nombre, prioridad, categoria);

        listaTareas.add(tarea);
        modeloTareas.addElement(tarea.toString());
        campoNombre.setText("");
    }

    private void eliminarTarea() {
        int index = lista.getSelectedIndex();
        if (index != -1) {
            listaTareas.remove(index);
            modeloTareas.remove(index);
        }
    }

    private void editarTarea() {
        int index = lista.getSelectedIndex();
        if (index != -1) {
            Tarea tarea = listaTareas.get(index);
            String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", tarea.nombre);
            if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
                tarea.nombre = nuevoNombre;
                modeloTareas.set(index, tarea.toString());
            }
        }
    }

    private void completarTarea() {
        int index = lista.getSelectedIndex();
        if (index != -1) {
            Tarea tarea = listaTareas.get(index);
            tarea.completada = true;
            modeloTareas.set(index, tarea.toString());
        }
    }

    private void filtrarTareas() {
        String categoria = JOptionPane.showInputDialog("Filtrar por categoría (Trabajo, Personal, Estudio):");
        modeloTareas.clear();
        for (Tarea t : listaTareas) {
            if (t.categoria.equalsIgnoreCase(categoria)) {
                modeloTareas.addElement(t.toString());
            }
        }
    }
} 
    
    

   
    
