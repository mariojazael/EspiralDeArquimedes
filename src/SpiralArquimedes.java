import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SpiralArquimedes extends JFrame {
    public final List<Color> colorList = new LinkedList<>();
    private double seed = -10;
    SpiralArquimedes(){
        super("Uso de gráficos");
        setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        inicializarListaColores();
        setVisible(true);
    }

    public void inicializarListaColores(){
        colorList.add(Color.RED);
        colorList.add(Color.BLUE);
        colorList.add(Color.MAGENTA);
        colorList.add(Color.ORANGE);
        colorList.add(Color.GREEN);
        colorList.add(Color.PINK);
    }

    public void paint(Graphics g) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Definir los parámetros
        double a = 0.1; // Parámetro que controla la separación entre las vueltas del espiral
        double thetaStep = 0.1; // Paso de ángulo

        // Origen del espiral
        int originX = getWidth() / 2;
        int originY = getHeight() / 2;

        // Dibujar el espiral de Arquímedes
        try {
            for(int i = 0; i < 1000; i++){
                a = a + 0.01;
                seed = seed - 0.1d;
                dibujarEspiral(g, originX, a, originY, thetaStep, colorList, seed);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void dibujarEspiral(Graphics g, int originX, double a, int originY, double thetaStep, List<Color> colorList, double seed) throws InterruptedException {
        double theta = seed;
        double prevX = originX + a * theta * Math.cos(theta);
        double prevY = originY + a * theta * Math.sin(theta);
        while (theta < 0 * Math.PI) { // Ajusta el rango según sea necesario
            theta += thetaStep;
            g.setColor(colorList.get(new Random().nextInt(colorList.size())));
            double x = originX + a * theta * Math.cos(theta);
            double y = originY + a * theta * Math.sin(theta);
            /*try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            g.drawLine((int) prevX, (int) prevY, (int) x, (int) y);
            prevX = x;
            prevY = y;
        }
        Thread.sleep(16);
        g.setColor(Color.BLACK);
        theta = seed;
        prevX = originX + a * theta * Math.cos(theta);
        prevY = originY + a * theta * Math.sin(theta);
        while (theta < 0 * Math.PI) { // Ajusta el rango según sea necesario
            theta += thetaStep;
            double x = originX + a * theta * Math.cos(theta);
            double y = originY + a * theta * Math.sin(theta);
            /*try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            g.drawLine((int) prevX, (int) prevY, (int) x, (int) y);
            prevX = x;
            prevY = y;
        }
    }

    public static void main(String[] args) {
        new SpiralArquimedes();
    }
}



