package proyecto;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PanelJuego extends JPanel {
    private final List<Pelota> pelotas;
    private final Random random;

    public PanelJuego() {
        pelotas = new ArrayList<>();
        random = new Random();
        setBackground(Color.WHITE);
    }

    public void agregarPelota() {
        double radio = 15; // Tamaño fijo para la pelota
        double x = getWidth() - radio; // Posición inicial en el borde derecho
        double y = getHeight() / 2; // Posición central verticalmente
        double dx = -10; // Movimiento rápido hacia la izquierda
        double dy = -5 + random.nextDouble() * 10; // Movimiento vertical aleatorio, asegurando dirección recta
        Color color = Color.BLACK; // Color fijo para la pelota
        pelotas.add(new Pelota(x, y, radio, dx, dy, color));
    }

    public void moverPelotas() {
        Iterator<Pelota> iterador = pelotas.iterator();
        while (iterador.hasNext()) {
            Pelota pelota = iterador.next();
            pelota.mover(getWidth(), getHeight());
            if (pelota.getX() - pelota.getRadio() < 0) {
                iterador.remove(); // Eliminar la pelota que llega al borde izquierdo
            }
        }
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Pelota pelota : pelotas) {
            pelota.dibujar(g2);
        }
    }
}
