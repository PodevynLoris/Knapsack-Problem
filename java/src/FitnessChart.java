import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import javax.swing.*;

public class FitnessChart extends JFrame {
    private DefaultCategoryDataset dataset;
    private JFreeChart chart;
    private ChartPanel chartPanel;

    public FitnessChart() {
        this.dataset = new DefaultCategoryDataset();
        this.chart = ChartFactory.createLineChart("Fitness over generations", "Generation", "Fitness", dataset, PlotOrientation.VERTICAL, true, true, false);
        this.chartPanel = new ChartPanel(chart);
        this.chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        this.setContentPane(chartPanel);
        this.pack();
        this.setVisible(true);
    }

    public void updateChart(double fitness, int generation) {
        SwingUtilities.invokeLater(() -> dataset.addValue(fitness, "Fitness", Integer.toString(generation)));
    }
}
