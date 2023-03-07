package GA;

import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import javax.swing.*;
import java.awt.*;

public class FitnessChart extends JFrame {
    private DefaultCategoryDataset dataset;
    private JFreeChart chart;
    private JFreeChart chart2;
    private ChartPanel chartPanel;


    private int windowSize = 20; // Will calculate the average fitness over "windowSize" generation.


    public FitnessChart() {
        this.dataset = new DefaultCategoryDataset();
        this.chart = ChartFactory.createLineChart("Fitness over generations", "Generation", "Fitness", dataset, PlotOrientation.VERTICAL, true, true, false);
        this.chartPanel = new ChartPanel(chart);
        this.chartPanel.setPreferredSize(new java.awt.Dimension(1000, 333));
        this.setContentPane(chartPanel);
        this.pack();
        this.setVisible(true);
    }

    public void updateChart(double fitness, int generation) {

        SwingUtilities.invokeLater(() -> {
            // add the current fitness to the dataset
            dataset.addValue(fitness, "Fitness", Integer.toString(generation));

            // if we have enough data points, calculate the average fitness over the last windowSize generations
            if (dataset.getColumnCount() >= windowSize) {
                double sum = 0.0;
                for (int i = dataset.getColumnCount() - windowSize; i < dataset.getColumnCount(); i++) {
                    sum += dataset.getValue(0, i).doubleValue();
                }
                double averageFitness = sum / windowSize;
                dataset.addValue(averageFitness, "Average Fitness", Integer.toString(generation));
            }
        });
    }
}


