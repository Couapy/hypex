package cloud.marchand.hypex.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Set;

import javax.swing.JPanel;

import cloud.marchand.hypex.gui.map.Map;

/**
 * Drawing surface.
 */
@SuppressWarnings("serial")
public class Canvas extends JPanel {

    /**
     * Number of pixel for drawing a point.
     */
    private static final int POINT_WIDTH = 10;

    /**
     * Number of pixels displayed for one unit.
     */
    public static final int WIDTH_SQUARE = 100;

    /**
     * Map to display.
     */
    private Map map;

    /**
     * Instanciate a canvas.
     * 
     * @param map map to display
     */
    public Canvas(Map map) {
        this.map = map;
    }

    /**
     * Draw edges, and visible zones.
     * 
     * @param graphics graphics zone
     */
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        setBackground(Color.BLACK);

        // Paint edges and nodes
        Set<Edge> edges = map.getEdges();
        for (Edge edge : edges) {
            graphics.setColor(Color.GREEN);
            graphics.drawLine((int) edge.getA().getX() * WIDTH_SQUARE, (int) edge.getA().getY() * WIDTH_SQUARE,
                    (int) edge.getB().getX() * WIDTH_SQUARE, (int) edge.getB().getY() * WIDTH_SQUARE);
            graphics.setColor(Color.RED);
            graphics.fillOval((int) (edge.getA().getX() * WIDTH_SQUARE - POINT_WIDTH / 2),
                    (int) (edge.getA().getY() * WIDTH_SQUARE - POINT_WIDTH / 2), POINT_WIDTH, POINT_WIDTH);
            graphics.fillOval((int) (edge.getB().getX() * WIDTH_SQUARE - POINT_WIDTH / 2),
                    (int) (edge.getB().getY() * WIDTH_SQUARE - POINT_WIDTH / 2), POINT_WIDTH, POINT_WIDTH);
        }

    }

}
