import java.awt.*;
import javax.swing.*;

public class LinearRegressionGraph extends JFrame {
    private String[] genders = {"male", "female", "male", "female", "male", "female", "male", "female"};
    private double[] tips = {10.0, 15.0, 20.0, 25.0, 30.0, 35.0, 40.0, 45.0};

    public LinearRegressionGraph() {
        setTitle("Linear Regression Graph");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;

        // Set background color
        g2.setBackground(Color.WHITE);

        // Calculate regression line
        int n = genders.length;
        double sumX = 0.0;
        double sumY = 0.0;
        double sumXY = 0.0;
        double sumXX = 0.0;

        for (int i = 0; i < n; i++) {
            double x = i + 1;
            double y = tips[i];

            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumXX += x * x;
        }

        double meanX = sumX / n;
        double meanY = sumY / n;
        double slope = (sumXY - n * meanX * meanY) / (sumXX - n * meanX * meanX);
        double intercept = meanY - slope * meanX;

        // Set axis labels
        g2.setColor(Color.BLACK);
        g2.drawString("Gender", 230, 380);
        g2.drawString("Tips", 22,225);

        // Draw X-axis
        g2.drawLine(50, 350, 550, 350);
        for (int i = 0; i < n; i++) {
            int x = 50 + (i * 50);
            g2.drawLine(x, 355, x, 345);
        }

        // Draw Y-axis
        g2.drawLine(50, 350, 50, 50);
        for (int i = 0; i < 8; i++) {
            int y = 350 - (i * 50);
            g2.drawLine(45, y, 55, y);
            
            // Draw tip values on the y-axis
            String tipLabel = String.valueOf(i * 10);
            g2.drawString(tipLabel, 25, y + 5);
        }

        // Draw scatter plot points and labels
        g2.setColor(Color.RED);
        for (int i = 0; i < n; i++) {
            int x = 50 + (i * 50);
            int y = 350 - (int) (tips[i] * 5);
            g2.fillOval(x - 2, y - 2, 5, 5);
            g2.drawString(genders[i], x - 10, y - 20);
            g2.drawString(String.valueOf(tips[i]), x - 10, y - 5);
        }

        // Draw regression line
        g2.setColor(Color.BLUE);
        int x1 = 50;
        int y1 = (int) (intercept * 5);
        int x2 = 550;
        int y2 = (int) ((slope * (n + 1) + intercept) * 5);
        g2.drawLine(x1, 350 - y1, x2, 350 - y2);
    }

    public static void main(String[] args) {
        LinearRegressionGraph graph = new LinearRegressionGraph();
        graph.setVisible(true);
    }
}