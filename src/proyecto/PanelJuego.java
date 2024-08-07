package proyecto;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PanelJuego extends JPanel {
    private final List<Pelota> pelotas;
    private final Random random;
    private final Portero portero;
    private int marcadorEquipo1;
    private int marcadorEquipo2;
    private int penalesEquipo1;
    private int penalesEquipo2;
    private boolean turnoEquipo1;
    private final Font marcadorFont;
    private final int posteSuperior;
    private final int posteInferior;

    public PanelJuego() {
        pelotas = new ArrayList<>();
        random = new Random();
        setBackground(Color.WHITE);
        marcadorFont = new Font("Arial", Font.BOLD, 48);
        marcadorEquipo1 = 0;
        marcadorEquipo2 = 0;
        penalesEquipo1 = 0;
        penalesEquipo2 = 0;
        turnoEquipo1 = true; // Empieza el equipo 1

        posteSuperior = 100; // Posición Y del poste superior
        posteInferior = 500; // Posición Y del poste inferior

        portero = new Portero(50, (posteSuperior + posteInferior) / 2 - 25, 10, 50, 0, Color.RED); // Inicialmente quieto
    }

    public void agregarPelota() {
        if ((penalesEquipo1 < 5 && turnoEquipo1) || (penalesEquipo2 < 5 && !turnoEquipo1)) {
            double radio = 15;
            double x = getWidth() - radio;
            double y = getHeight() / 2;
            double dx = -10;
            double dy = -5 + random.nextDouble() * 10;

            Color color;
            if (turnoEquipo1) {
                color = Color.RED; // Color de la pelota para Perú
                penalesEquipo1++;
            } else {
                color = Color.YELLOW; // Color de la pelota para Colombia
                penalesEquipo2++;
            }

            pelotas.add(new Pelota(x, y, radio, dx, dy, color));

            // Cambiar el turno después de agregar la pelota
            turnoEquipo1 = !turnoEquipo1;

            // Reiniciar la posición del portero y comenzar el movimiento
            portero.reiniciarPosicion((posteSuperior + posteInferior) / 2 - 25);
            portero.comenzarMovimiento(random);
        }
    }

    public void moverPelotas() {
        Iterator<Pelota> iterador = pelotas.iterator();
        while (iterador.hasNext()) {
            Pelota pelota = iterador.next();
            pelota.mover(getWidth(), getHeight());

            if (portero.colisiona(pelota)) {
                iterador.remove();
            } else if (pelota.getX() - pelota.getRadio() < 0) {
                if (pelota.getY() > posteSuperior && pelota.getY() < posteInferior) {
                    if (!turnoEquipo1) {
                        marcadorEquipo1++;
                    } else {
                        marcadorEquipo2++;
                    }
                }
                iterador.remove();
            }
        }
        portero.mover(posteSuperior, posteInferior);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Pelota pelota : pelotas) {
            pelota.dibujar(g2);
        }
        portero.dibujar(g2);

        // Dibujar los postes de la portería
        g2.setColor(Color.BLACK);
        g2.fillRect(0, posteSuperior, 10, 10);
        g2.fillRect(0, posteInferior, 10, 10);

        g2.setFont(marcadorFont);
        FontMetrics fm = g2.getFontMetrics();
        String marcadorTexto1 = "Peru: " + marcadorEquipo1;
        String marcadorTexto2 = "Colombia: " + marcadorEquipo2;
        int textoAncho1 = fm.stringWidth(marcadorTexto1);
        int textoAncho2 = fm.stringWidth(marcadorTexto2);
        int textoX1 = (getWidth() / 4) - (textoAncho1 / 2);
        int textoX2 = (3 * getWidth() / 4) - (textoAncho2 / 2);
        int textoY = fm.getHeight();
        g2.setColor(Color.BLACK);
        g2.drawString(marcadorTexto1, textoX1, textoY);
        g2.drawString(marcadorTexto2, textoX2, textoY);
    }

    public int getPenalesEquipo1() {
        return penalesEquipo1;
    }

    public int getPenalesEquipo2() {
        return penalesEquipo2;
    }

    public int getMarcadorEquipo1() {
        return marcadorEquipo1;
    }

    public int getMarcadorEquipo2() {
        return marcadorEquipo2;
    }
}
