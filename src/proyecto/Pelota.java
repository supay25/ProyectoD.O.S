package proyecto;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Pelota {
    private double x, y;
    private double dx, dy;
    private final double radio;
    private final Color color;

    public Pelota(double x, double y, double radio, double dx, double dy, Color color) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.dx = dx;
        this.dy = dy;
        this.color = color;
    }

    public void mover(int anchoPanel, int altoPanel) {
        x += dx;
        y += dy;

        if (y - radio < 0 || y + radio > altoPanel) {
            dy = -dy; // Rebotar en los bordes superior e inferior
        }
    }

    public void dibujar(Graphics2D g2) {
        g2.setColor(color);
        Ellipse2D circulo = new Ellipse2D.Double(x - radio, y - radio, 2 * radio, 2 * radio);
        g2.fill(circulo);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadio() {
        return radio;
    }
}

