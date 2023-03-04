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

    int show = 1;
    int check = 0;

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

        //if(generation%show==0) {
            SwingUtilities.invokeLater(() -> dataset.addValue(fitness, "Fitness", Integer.toString(generation)));
            System.out.println(generation);
          //  check +=1;
           // if(check ==10) {
                show =show*10;
                check = 0;
           // }
       // }
    }

}
