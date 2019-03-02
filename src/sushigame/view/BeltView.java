package sushigame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import comp401.sushi.Nigiri;
import comp401.sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;
import sushigame.model.TimedPlate;
import sushigame.model.TimedPlateImpl;

public class BeltView extends JPanel implements BeltObserver {

	private Belt belt;
	private JLabel[] belt_labels;

	public BeltView(Belt b) {
		this.belt = b;
		belt.registerBeltObserver(this);
		setLayout(new GridLayout(belt.getSize(), 1));
		belt_labels = new JLabel[belt.getSize()];
		for (int i = 0; i < belt.getSize(); i++) {
			JLabel plabel = new JLabel("");
			plabel.setMinimumSize(new Dimension(300, 20));
			plabel.setPreferredSize(new Dimension(800, 50));
			plabel.setOpaque(true);
			plabel.setBackground(Color.GRAY);
			add(plabel);
			belt_labels[i] = plabel;
		}
		refresh();
	}

	@Override
	public void handleBeltEvent(BeltEvent e) {	
		refresh();
	}

	private void refresh() {
		
		for (int i=0; i<belt.getSize(); i++) {
			Plate p = belt.getPlateAtPosition(i);
			JLabel plabel = belt_labels[i];

			if (p == null) {
				plabel.setText("");
				plabel.setToolTipText("");
				plabel.setBackground(Color.BLACK);
			} else {
				plabel.setText(p.getContents().getName());
				String contents = "Contains: ";
				if(p.getContents().getClass().toString().equals("class comp401.sushi.Roll")){
				for(int x = 0; x < p.getContents().getIngredients().length; x++){
					double tempTrunc = Math.round(100 * p.getContents().getIngredients()[x].getAmount());
					tempTrunc = tempTrunc/100;
					contents += tempTrunc; 
					contents += " ounces of " + 
							p.getContents().getIngredients()[x].getName() + ", ";
					}
				plabel.setToolTipText(contents + "Placed by: " + p.getChef().getName() + ", Plate age: " 
						+ belt.getAgeOfPlateAtPosition(i));
				} else {
				plabel.setToolTipText("Placed by: " + p.getChef().getName() + ", Plate age: " 
				+ belt.getAgeOfPlateAtPosition(i));
				}
				switch (p.getColor()) {
				case RED:
					plabel.setBackground(Color.RED); break;
				case GREEN:
					plabel.setBackground(Color.GREEN); break;
				case BLUE:
					plabel.setBackground(Color.BLUE); break;
				case GOLD:
					plabel.setBackground(Color.YELLOW); break;
				}
			}
		}
	}
}
