package proyecto;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaJuego extends JFrame {
    private final PanelJuego panelJuego;

    public VentanaJuego() {
        setTitle("Rebotes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        panelJuego = new PanelJuego();
        add(panelJuego, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        JButton botonAgregar = new JButton("¡Patea!");
        JButton botonSalir = new JButton("Salir");

        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelJuego.agregarPelota();
            }
        });

        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panelBotones.add(botonAgregar);
        panelBotones.add(botonSalir);
        add(panelBotones, BorderLayout.SOUTH);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    panelJuego.moverPelotas();
                    panelJuego.repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
