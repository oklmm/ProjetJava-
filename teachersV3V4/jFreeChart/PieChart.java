package teachersV3V4.jFreeChart;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import teachersV3V4.Promotion;
import teachersV3V4.Eleve;
import teachersV3V4.exceptions.NotesVides;

/**
 * Contiens les implementations JfreeChart.
 
 */
public class PieChart extends JFrame {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construit le pie chart pour les notes.
	 * 
	 * @param applicationTitle
	 *            nom de l'application
	 * @param chartTitle
	 *            Nom du chart 
     * @param s 
        
	 *            
	 */
	public PieChart(String applicationTitle, String chartTitle, Eleve s) {
		super(applicationTitle);
		// Pour creer les dataset
		PieDataset dataset = createDatasetMarksStudent(s);
		// Basé dans le dataset creer
		JFreeChart chart = createChart(dataset, chartTitle);
		// On met les charts dans le panel
		ChartPanel chartPanel = new ChartPanel(chart);
		// taille par defaut
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		// on l'ajoute dans notre application
		setContentPane(chartPanel);

	}

	/**
	 * Construction du pie chart pour la promotion (moyenne).
	 * 
	 * @param applicationTitle
	 *            nom de l'application
	 * @param chartTitle
	 *            .
	 * @param p
	 *            
	 */
	public PieChart(String applicationTitle, String chartTitle, Promotion p) {
		super(applicationTitle);
		
		PieDataset dataset = createDatasetAveragePromotion(p);
		
		JFreeChart chart = createChart(dataset, chartTitle);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		
		setContentPane(chartPanel);
	}

	/**
	 * On cree les données pour les eleves notes.
	 * 
	 * @param s
	 *            
	 * @return  PieDataSet avec des notes entre 0 et 20.
	 */
	private PieDataset createDatasetMarksStudent(Eleve s) {
		DefaultPieDataset result = new DefaultPieDataset();
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;

		result.setValue("[0-8[", count1);
		result.setValue("[8-10[", count2);
		result.setValue("[10-12[", count3);
		result.setValue("[12-15[", count4);
		result.setValue("[15-20[", count5);

		for (int i = 0; i < s.marks.length; i++) {
			if (s.getMarks()[i] != null) {
                            int mark = (int) (s.marks[i].getValeur());
                            
                            if (mark >= 0 && mark <= 8) {
                                result.setValue("[0-8[", ++count1);
                                
                            } else if (mark >= 8 && mark <= 10) {
                                result.setValue("[8-10[", ++count2);
                                
                            } else if (mark >= 10 && mark <= 12) {
                                result.setValue("[10-12[", ++count3);
                                
                            } else if (mark >= 12 && mark <= 15) {
                                result.setValue("[12-15[", ++count4);
                                
                            } else {
                                result.setValue("[15-20[", ++count5);
                                
                            }
                        } else {
                        }
		}
		return result;
	}

	/**
	 * Ccreation des données pour la moyenne de la promo.
	 * 
	 * @param p
	 *            .
	 * @return 
	 */
	private PieDataset createDatasetAveragePromotion(Promotion p) {
		DefaultPieDataset result = new DefaultPieDataset();

		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;

		result.setValue("[0-8[", count1);
		result.setValue("[8-10[", count2);
		result.setValue("[10-12[", count3);
		result.setValue("[12-15[", count4);
		result.setValue("[15-20[", count5);
		try {
			int i;
			for (i = 0; i < p.getList().size(); i++) {
				int average = (int) (p.getList().get(i).average());

				if (average >= 0 && average <= 8) {
					result.setValue("[0-8[", ++count1);

				} else if (average >= 8 && average <= 10) {
					result.setValue("[8-10[", ++count2);

				} else if (average >= 10 && average <= 12) {

					result.setValue("[10-12[", ++count3);

				} else if (average >= 12 && average <= 15) {
					result.setValue("[12-15[", ++count4);

				} else {
					result.setValue("[15-20[", ++count5);

				}
			}
		} catch (EmptyMarks e) {
			System.out.println("Quelqu'un n'a pas de notes dans la promotion !");
		}
		return result;
	}

	/**
	 * Creation du frame pour le chart 
	 * 
	 * @param dataset
	 *            
	 * @param title
	 *            le titre
	 * @return 
	 */
	private JFreeChart createChart(PieDataset dataset, String title) {

		JFreeChart chart = ChartFactory.createPieChart3D(title, // titre
				dataset, // données
				true, // legende
				true, false);

		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(290);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		return chart;

	}
}