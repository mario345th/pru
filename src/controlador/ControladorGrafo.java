package controlador;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Grafo;
import modelo.Vertice;
import vista.VistaGrafo;

public class ControladorGrafo extends MouseAdapter implements ActionListener,
    MouseListener {
    VistaGrafo frmGrafo;
    Grafo grafito;
    
   //Nuevo comentario de subida
    
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorGrafo() {
        this.frmGrafo = new VistaGrafo();
        this.frmGrafo.setVisible(true);
        this.frmGrafo.btnCrearArco.addActionListener(this);
        this.frmGrafo.btnMady.addActionListener(this);
        this.frmGrafo.btnPesos.addActionListener(this);
        this.frmGrafo.btnMCaminos.addActionListener(this);
        this.frmGrafo.btnAnchura.addActionListener(this);
        this.frmGrafo.btnProfundidad.addActionListener(this);
        this.frmGrafo.btnRestaurar.addActionListener(this);
        this.frmGrafo.panelGrafo.addMouseListener(this);
        //creamos direccion de memoria
        grafito = new Grafo();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmGrafo.btnCrearArco) {
            btnCrearArco();
        } else if (e.getSource() == this.frmGrafo.btnMady) {
            tabla();
        } else if (e.getSource() == this.frmGrafo.btnPesos) {
           grafito.addPesos();
        } else if (e.getSource() == this.frmGrafo.btnMCaminos) {
            matrizCamino();
        } else if (e.getSource() == this.frmGrafo.btnAnchura) {
            this.frmGrafo.textArea.setText("");
            this.frmGrafo.textArea.append(""+grafito.anchura());//append permite agregar cadenas
            
            
        } else if (e.getSource() == this.frmGrafo.btnProfundidad) {
            this.frmGrafo.textArea.setText("");
             this.frmGrafo.textArea.append(""+grafito.profundidad());//append permite agregar cadenas
          
        } else if (e.getSource() == this.frmGrafo.btnRestaurar) {
            restaurar();
        }
    }

    public void btnCrearArco() {
       
         // vertice de origen(org) y ese vertice lo vamos vamos a leer de acuerdo a lo que tenga almacenado el combox
        Vertice org = grafito.getVerticer((Comparable) this.frmGrafo.cbOrigen.getSelectedItem());////ya tenmos el vertice de origen para dibujarlo en pantalla
        Vertice dest = grafito.getVerticer((Comparable) this.frmGrafo.cbDestino.getSelectedItem());//ya tenemos el vertice de destinopara dibujarlo en pantalla
        if (org!=null && dest != null) {//pintar los vertice si el origen es diferente de null es porque exsiiten y si el destino es diferente de null es porq tambien existe 
           boolean arco = grafito.crearArco(org, dest);//si el origen y destrino existen la matrix booleana crea el arco mandandole el origen y destino
        if(arco){// si devielve que  creo el arco si devolvio verdadero tenemos que pintar la pantalla     
         //recuperamos para mandar ese vertice a pantalla para restaurar arco o para poderlo pintar en pantaalla
         marcarArcos(org,dest);       
        }
        }  else{
            JOptionPane.showMessageDialog(null,"seleccionar origen  destino" );   
        }
    }
    
    public void marcarArcos(Vertice org,Vertice dest){
        //saber si es dirigido o no dirigido
         if (grafito.isDirigido()) { //si es dirijido vamos a dibujar un arco
            if (org!=dest) {// si el origen es diferente al  destino dibujamos el arco y la fecha
               dibujarArco(org.getX(),org.getY(),dest.getX(),dest.getY()); 
           // dibujar la direccion o sentido osea laflecha
           dibujarFlecha(org.getX(),org.getY(),dest.getX(),dest.getY());
            }else{//si el origen es igual al destino ibujamos uncirculo
                dibujarCirculo(org.getX(),org.getY());//mandamos las coordenadas en x y 
            }
        }else{//si es no dirigido devemos de dibujar el arco 
             if (org!=dest) {
            dibujarArco(org.getX(),org.getY(),dest.getX(),dest.getY()); 

             }else{
           dibujarCirculo(org.getX(),org.getY());//mandamos las coordenadas en x y 

             }
         }
    }

    
    
    public void tabla() {// sirve para ver los recorridos
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("V");
        // lo que tiene la matriz de adyacencia
        for (int i = 0; i < grafito.getVertices().size(); i++) {
            modelo.addColumn(grafito.getVertices().get(i));
        }
        for (int f= 0; f<grafito.getVertices().size(); f++) {
            Object arreglo[] = new Object[grafito.getVertices().size()+1];
            for (int c = 0; c <grafito.getVertices().size(); c++) {
                arreglo[0]=grafito.getVertices().get(f);
                arreglo[c+1]= grafito.getMatrizAdy()[f][c];// poneos el valor
            }
            modelo.addRow(arreglo);
        }
           
        this.frmGrafo.tabla.setModel(modelo);
    }

    public void matrizCamino() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("V");
        
         for (int i = 0; i < grafito.getVertices().size(); i++) {
            modelo.addColumn(grafito.getVertices().get(i));
        }
        for (int f= 0; f<grafito.getVertices().size(); f++) {
            Object arreglo[] = new Object[grafito.getVertices().size()+1];
            for (int c = 0; c <grafito.getVertices().size(); c++) {
                arreglo[0]=grafito.getVertices().get(f);
                //cuando es infinito
                if (grafito.getMatrizCamino()[f][c]<1000) {
                    arreglo[c+1]= grafito.getMatrizCamino()[f][c];// poneos el valor
                }else{
                    arreglo[c+1]="∞";
                }

            }
            modelo.addRow(arreglo);
        }
         
        this.frmGrafo.tabla.setModel(modelo);
    }

    public void llenarCombo() {
        this.frmGrafo.cbOrigen.removeAllItems();
        this.frmGrafo.cbDestino.removeAllItems();
        this.frmGrafo.cbOrigen.addItem("Origen");
        this.frmGrafo.cbDestino.addItem("Destino");
       //llenar el combox
        for (int i = 0; grafito.getVertices().size() < 10; i++) {
            this.frmGrafo.cbOrigen.addItem(
                    ((Vertice)grafito.getVertices().get(i)).getV().toString());//nesesita convertir a to estring agarra el vertice y luego  qme lo devuelva en objetc y luego que me de el vertice en to estring 
             this.frmGrafo.cbDestino.addItem(
                    ((Vertice)grafito.getVertices().get(i)).getV().toString()); 
        }
        
        
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        if (evt.getSource() == this.frmGrafo.panelGrafo) {
            int posX = evt.getX();
            int posY = evt.getY();
            String v;
            do {
                v = JOptionPane.showInputDialog("vértice");
            } while (v.equals(""));
            
            
            Vertice  vertice  = new Vertice(v,posX,posY);//
            if (grafito.insertar(vertice)) {//devuelve booleano
                dibujarVertice(posX,posY,v);//si devuelve verdadero inserto correctaente
                llenarCombo();
            }
        }
    }

    public void restaurar() {
        
    }

    public void dibujarVertice(int x, int y, String n) {
        this.frmGrafo.panelGrafo.getGraphics().setColor(Color.BLACK);
        this.frmGrafo.panelGrafo.getGraphics().fillOval(x, y, 15, 15);
        this.frmGrafo.panelGrafo.getGraphics().setColor(Color.BLUE);
        Font fuente = new Font("Arial", Font.BOLD, 16);
        this.frmGrafo.panelGrafo.getGraphics().setFont(fuente);
        this.frmGrafo.panelGrafo.getGraphics().drawString(n, x, y);
    }

    public void dibujarCirculo(int x, int y) {
        this.frmGrafo.panelGrafo.getGraphics().drawOval(x - 20, y - 5, 25, 25);
    }

    public void dibujarArco(int x1, int y1, int x2, int y2) {
        ((Graphics2D) this.frmGrafo.panelGrafo.getGraphics())
                .setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        ((Graphics) this.frmGrafo.panelGrafo.getGraphics())
                .drawLine(x1, y1, x2 + 10, y2 + 10);
    }

    public void dibujarFlecha(int x1, int y1, int x2, int y2) {
        Point punto1 = new Point(x1, y1);
        Point punto2 = new Point(x2, y2);
        double angulo = 0.0, distancia = 0.0;
        double tx, ty;
        int dist = 15;
        ty = -(punto1.y - punto2.y) * 1.0;
        tx = (punto1.x - punto2.x) * 1.0;
        angulo = Math.atan(ty / tx); // para poner un ángulo
        if (tx < 0) {
            angulo += Math.PI;
        }

        Point p1 = new Point(), p2 = new Point(), punto = punto2;
        distancia = 15.0;
        p1.x = (int) (punto.x + dist * Math.cos(angulo - Math.toRadians(distancia)));
        p1.y = (int) (punto.y - dist * Math.sin(angulo - Math.toRadians(distancia)));
        p2.x = (int) (punto.x + dist * Math.cos(angulo + Math.toRadians(distancia)));
        p2.y = (int) (punto.y - dist * Math.sin(angulo + Math.toRadians(distancia)));
        ((Graphics2D) this.frmGrafo.panelGrafo.getGraphics())
                .setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(2);
        ((Graphics2D) this.frmGrafo.panelGrafo.getGraphics()).setStroke(stroke);
        this.frmGrafo.panelGrafo.getGraphics().drawLine(p1.x + 10,
                p1.y + 10, punto.x + 10, punto.y + 10);
        this.frmGrafo.panelGrafo.getGraphics().drawLine(p2.x + 10,
                p2.y + 10, punto.x + 10, punto.y + 10);
    }

    /*
    public void restaurarArcos(Vertice origen, Vertice destino) {
        
    }*/

}
