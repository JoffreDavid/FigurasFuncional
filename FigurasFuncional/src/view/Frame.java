package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Frame {
    private JFrame frame;
    private JPanel drawingPanel;
    private Drawable currentDrawable;

    public Frame() {
        frame = new JFrame("Dibujar Figuras");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (currentDrawable != null) {
                    drawShape(currentDrawable, g);
                }
            }
        };
        drawingPanel.setPreferredSize(new Dimension(200, 200));
        drawingPanel.setBackground(Color.WHITE);

        JButton triangleButton = new JButton("Dibujar Triangulo");
        triangleButton.addActionListener((ActionEvent e) -> setCurrentDrawable((Graphics g) -> {
            int[] xPoints = {75, 150, 0};
            int[] yPoints = {0, 150, 150};
            g.setColor(Color.RED);
            g.fillPolygon(xPoints, yPoints, 3);
        }));

        JButton squareButton = new JButton("Dibujar Cuadrado");
        squareButton.addActionListener((ActionEvent e) -> setCurrentDrawable((Graphics g) -> {
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, 150, 150);
        }));

        JButton circleButton = new JButton("Dibujar Circulo");
        circleButton.addActionListener((ActionEvent e) -> setCurrentDrawable((Graphics g) -> {
            g.setColor(Color.BLUE);
            g.fillOval(0, 0, 150, 150);
        }));

        frame.add(triangleButton);
        frame.add(squareButton);
        frame.add(circleButton);
        frame.add(drawingPanel);
    }

    public void show() {
        frame.setVisible(true);
    }

    private void setCurrentDrawable(Drawable drawable) {
        this.currentDrawable = drawable;
        drawingPanel.repaint();
    }

    private void drawShape(Drawable drawable, Graphics g) {
        drawable.draw(g);
    }
}