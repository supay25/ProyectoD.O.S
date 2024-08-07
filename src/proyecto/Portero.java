package proyecto;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Portero {
    private double x, y;
    private double dy;
    private final double width, height;
    private final Color color;

    public Portero(double x, double y, double width, double height, double dy, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.dy = dy;
        this.color = color;
    }

    public void mover(int limiteSuperior, int limiteInferior) {
        y += dy;
        if (y < limiteSuperior) {
            y = limiteSuperior;
            dy = -dy;
        } else if (y + height > limiteInferior) {
            y = limiteInferior - height;
            dy = -dy; // Oscila entre los postes superior e inferior
        }
    }

    public void dibujar(Graphics2D g2) {
        g2.setColor(color);
        Rectangle2D rect = new Rectangle2D.Double(x, y, width, height);
        g2.fill(rect);
    }

    public boolean colisiona(Pelota pelota) { // Revisa si el portero atrapó la pelota
        double px = pelota.getX();
        double py = pelota.getY();
        double pr = pelota.getRadio();
        return px + pr > x && px - pr < x + width && py + pr > y && py - pr < y + height;
    }

    public void reiniciarPosicion(double nuevaY) {
        this.y = nuevaY;
        this.dy = 0; // Mantener al portero quieto
    }

    public void comenzarMovimiento(Random random) {
        this.dy = 2 + random.nextDouble() * 4; // Movimiento aleatorio entre 2 y 6
        if (random.nextBoolean()) {
            this.dy = -this.dy; // Cambiar dirección aleatoriamente
        }
    }

    public double getX() {
        return x;
    }
}
