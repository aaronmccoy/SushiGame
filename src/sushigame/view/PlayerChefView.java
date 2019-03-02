package sushigame.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import comp401.sushi.*;


public class PlayerChefView extends JPanel implements ActionListener {

	private List<ChefViewListener> listeners;
	private Sushi kmp_roll;
	private Sushi crab_sashimi;
	private Sushi eel_nigiri;
	private int belt_size;
	private JComboBox plateColorB, positionB, sashimiType, nigiriType;
	private JLabel positionL, goldPriceLabel, rollNameL, avocadoL, crabL, eelL, riceL, salmonL, seaweedL, shrimpL, tunaL, sashimiLabel, nigiriLabel;
	private JSlider goldPriceS, avocadoS, crabS, eelS, riceS, salmonS, seaweedS, shrimpS, tunaS;
	private JButton make_button, sashimi_button, nigiri_button, reset_button;
	private JTextField rollNameT;
	
	
	public PlayerChefView(int belt_size) {
		this.belt_size = belt_size;
		listeners = new ArrayList<ChefViewListener>();
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		//grid layout, 2 columns
		GridLayout grid = new GridLayout(0,2);
		setLayout(grid);
		JLabel plateColorL = new JLabel("Plate Color: ");
		add(plateColorL);
		
		
		plateColorB = new JComboBox();
		plateColorB.addItem("Select Color");
		plateColorB.addItem("Red");
		plateColorB.addItem("Green");
		plateColorB.addItem("Blue");
		plateColorB.addItem("Gold");
		add(plateColorB);
		
		positionL = new JLabel("Position: ");
		add(positionL);
		
		positionB = new JComboBox();
		for(int i = 0; i < belt_size; i++){
			positionB.addItem(i);
		}
		add(positionB);
		
		rollNameL = new JLabel("Roll name: ");
		add(rollNameL);
		
		rollNameT = new JTextField();
		add(rollNameT);

		goldPriceLabel = new JLabel("Gold plate price: ");
		add(goldPriceLabel);
		
		goldPriceS = new JSlider();
		goldPriceS.setMaximum(10);
		goldPriceS.setMinimum(5);
		goldPriceS.setMajorTickSpacing(1);
		goldPriceS.setPaintTicks(true);
		Hashtable labels = goldPriceS.createStandardLabels(1, 5);
		goldPriceS.setLabelTable(labels);
		goldPriceS.setPaintLabels(true);
		goldPriceS.setSnapToTicks(true);
		goldPriceS.setName("Gold plate price");
		goldPriceS.setValue(5);
		add(goldPriceS);
		
		avocadoL = new JLabel("Avocado: ");
		add(avocadoL);
		
		avocadoS = new JSlider();
		avocadoS.setMaximum(15);
		avocadoS.setMinimum(0);
		avocadoS.setValue(0);
		avocadoS.setMajorTickSpacing(1);
		avocadoS.setPaintTicks(true);
		Hashtable labels1 = avocadoS.createStandardLabels(1, 0);
		avocadoS.setLabelTable(labels1);
		avocadoS.setPaintLabels(true);
		avocadoS.setSnapToTicks(true);
		avocadoS.setName("avocado");
		add(avocadoS);
		
		crabL = new JLabel("Crab: ");
		add(crabL);
		
		crabS = new JSlider();
		crabS.setMaximum(15);
		crabS.setMinimum(0);
		crabS.setValue(0);
		crabS.setMajorTickSpacing(1);
		crabS.setPaintTicks(true);
		Hashtable labels2 = crabS.createStandardLabels(1, 0);
		crabS.setLabelTable(labels2);
		crabS.setPaintLabels(true);
		crabS.setSnapToTicks(true);
		crabS.setName("crab");
		add(crabS);
		
		eelL = new JLabel("Eel: ");
		add(eelL);
		
		eelS = new JSlider();
		eelS.setMaximum(15);
		eelS.setMinimum(0);
		eelS.setValue(0);
		eelS.setMajorTickSpacing(1);
		eelS.setPaintTicks(true);
		Hashtable labels3 = eelS.createStandardLabels(1, 0);
		eelS.setLabelTable(labels3);
		eelS.setPaintLabels(true);
		eelS.setSnapToTicks(true);
		eelS.setName("eel");
		add(eelS);
		
		riceL = new JLabel("Rice: ");
		add(riceL);
		
		riceS = new JSlider();
		riceS.setMaximum(15);
		riceS.setMinimum(0);
		riceS.setValue(0);
		riceS.setMajorTickSpacing(1);
		riceS.setPaintTicks(true);
		riceS.setLabelTable(labels3);
		riceS.setPaintLabels(true);
		riceS.setSnapToTicks(true);
		riceS.setName("rice");
		add(riceS);
		
		salmonL = new JLabel("Salmon: ");
		add(salmonL);
		
		salmonS = new JSlider();
		salmonS.setMaximum(15);
		salmonS.setMinimum(0);
		salmonS.setValue(0);
		salmonS.setMajorTickSpacing(1);
		salmonS.setPaintTicks(true);
		salmonS.setLabelTable(labels3);
		salmonS.setPaintLabels(true);
		salmonS.setSnapToTicks(true);
		salmonS.setName("salmon");
		add(salmonS);
		
		seaweedL = new JLabel("Seaweed: ");
		add(seaweedL);
		
		seaweedS = new JSlider();
		seaweedS.setMaximum(15);
		seaweedS.setMinimum(0);
		seaweedS.setValue(0);
		seaweedS.setMajorTickSpacing(1);
		seaweedS.setPaintTicks(true);
		seaweedS.setLabelTable(labels3);
		seaweedS.setPaintLabels(true);
		seaweedS.setSnapToTicks(true);
		seaweedS.setName("seaweed");
		add(seaweedS);
		
		shrimpL = new JLabel("Shrimp: ");
		add(shrimpL);
		
		shrimpS = new JSlider();
		shrimpS.setMaximum(15);
		shrimpS.setMinimum(0);
		shrimpS.setValue(0);
		shrimpS.setMajorTickSpacing(1);
		shrimpS.setPaintTicks(true);
		shrimpS.setLabelTable(labels3);
		shrimpS.setPaintLabels(true);
		shrimpS.setSnapToTicks(true);
		shrimpS.setName("shrimp");
		add(shrimpS);
		
		tunaL = new JLabel("Tuna: ");
		add(tunaL);
		
		tunaS = new JSlider();
		tunaS.setMaximum(15);
		tunaS.setMinimum(0);
		tunaS.setValue(0);
		tunaS.setMajorTickSpacing(1);
		tunaS.setPaintTicks(true);
		tunaS.setLabelTable(labels3);
		tunaS.setPaintLabels(true);
		tunaS.setSnapToTicks(true);
		tunaS.setName("tuna");
		add(tunaS);
	
		sashimiLabel = new JLabel("Sashimi Type: ");
		add(sashimiLabel);
		
		sashimiType = new JComboBox();
		sashimiType.addItem("Select Sashimi type"); //TUNA, SALMON, EEL, CRAB, SHRIMP
		sashimiType.addItem(comp401.sushi.Sashimi.SashimiType.TUNA);
		sashimiType.addItem(comp401.sushi.Sashimi.SashimiType.SALMON);
		sashimiType.addItem(comp401.sushi.Sashimi.SashimiType.EEL);
		sashimiType.addItem(comp401.sushi.Sashimi.SashimiType.CRAB);
		sashimiType.addItem(comp401.sushi.Sashimi.SashimiType.SHRIMP);
		add(sashimiType);
		
		nigiriLabel = new JLabel("Nigiri Type: ");
		add(nigiriLabel);
		
		nigiriType = new JComboBox();
		nigiriType.addItem("Select Nigiri type"); //TUNA, SALMON, EEL, CRAB, SHRIMP
		nigiriType.addItem(comp401.sushi.Nigiri.NigiriType.TUNA);
		nigiriType.addItem(comp401.sushi.Nigiri.NigiriType.SALMON);
		nigiriType.addItem(comp401.sushi.Nigiri.NigiriType.EEL);
		nigiriType.addItem(comp401.sushi.Nigiri.NigiriType.CRAB);
		nigiriType.addItem(comp401.sushi.Nigiri.NigiriType.SHRIMP);
		add(nigiriType);

		make_button = new JButton("Create Roll");
		make_button.setActionCommand("create_roll");
		make_button.addActionListener(this);
		add(make_button);

		sashimi_button = new JButton("Create Sashimi");
		sashimi_button.setActionCommand("create_sashimi");
		sashimi_button.addActionListener(this);
		add(sashimi_button);

		nigiri_button = new JButton("Create Nigiri");
		nigiri_button.setActionCommand("create_nigiri");
		nigiri_button.addActionListener(this);
		add(nigiri_button);
		
		reset_button = new JButton("Reset");
		reset_button.setActionCommand("reset");
		reset_button.addActionListener(this);
		add(reset_button);

		kmp_roll = new Roll("KMP Roll", new IngredientPortion[] {new EelPortion(1.0), new AvocadoPortion(0.5), new SeaweedPortion(0.2)});
		crab_sashimi = new Sashimi(Sashimi.SashimiType.CRAB);
		eel_nigiri = new Nigiri(Nigiri.NigiriType.EEL);
	}

	public void registerChefListener(ChefViewListener cl) {
		listeners.add(cl);
	}

	private void makeRedPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleRedPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeGreenPlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleGreenPlateRequest(plate_sushi, plate_position);
		}
	}

	private void makeBluePlateRequest(Sushi plate_sushi, int plate_position) {
		for (ChefViewListener l : listeners) {
			l.handleBluePlateRequest(plate_sushi, plate_position);
		}
	}
	
	private void makeGoldPlateRequest(Sushi plate_sushi, int plate_position, double price) {
		for (ChefViewListener l : listeners) {
			l.handleGoldPlateRequest(plate_sushi, plate_position, price);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	switch (e.getActionCommand()) {	
	case "create_roll":{
			IngredientPortion[] tempIngs = new IngredientPortion[8];
			int trueIngsIndex = 0;  // avocado crab eel rice salmon seaweed shrimp tuna
			if(avocadoS.getValue() > 0){
			tempIngs[0] = new AvocadoPortion((avocadoS.getValue() / 10.0));
			}
			if(crabS.getValue() > 0){
			tempIngs[1] = new CrabPortion(crabS.getValue() / 10.0);
			}
			if(eelS.getValue() > 0){
			tempIngs[2] = new EelPortion(eelS.getValue() / 10.0);
			}
			if(riceS.getValue() > 0){
			tempIngs[3] = new RicePortion(riceS.getValue() / 10.0);
			}
			if(salmonS.getValue() > 0){
			tempIngs[4] = new SalmonPortion(salmonS.getValue() / 10.0);
			}
			if(seaweedS.getValue() > 0){
			tempIngs[5] = new SeaweedPortion(seaweedS.getValue() / 10.0);
			}
			if(shrimpS.getValue() > 0){
			tempIngs[6] = new ShrimpPortion(shrimpS.getValue() / 10.0);
			}
			if(tunaS.getValue() > 0){
			tempIngs[7] = new TunaPortion(tunaS.getValue() / 10.0);
			}
			for(int i = 0; i < tempIngs.length; i++){
				if(tempIngs[i] != null){
					trueIngsIndex++;
				}
			}
			IngredientPortion[] ings = new IngredientPortion[trueIngsIndex];
			int x = 0;
			for(int i = 0; i < tempIngs.length; i++){
				
				if(tempIngs[i] != null){
					ings[x] = tempIngs[i];
					x++;
				}
			}
			x = 0;  //reset this counter, just in case.
			String rollName = "";
			if(rollNameT.getText() == null){
				rollName = "Unnamed roll";
			} else{
				rollName = rollNameT.getText();
			}
			Sushi customRoll = new Roll(rollName, ings);
		
			switch((String)plateColorB.getSelectedItem()){
			case "Red": {
				makeRedPlateRequest(customRoll, (int)positionB.getSelectedItem());
				break;
				}
			case "Blue": {
				makeBluePlateRequest(customRoll, (int)positionB.getSelectedItem());
				}
			case "Green": {
				makeGreenPlateRequest(customRoll, (int)positionB.getSelectedItem());
				}
			case "Gold": {
				makeGoldPlateRequest(customRoll, (int)positionB.getSelectedItem(), goldPriceS.getValue());
				}
			}
			
		}
		case "create_sashimi":
			Sashimi sashimi = new Sashimi((comp401.sushi.Sashimi.SashimiType)sashimiType.getSelectedItem());
			switch((String)plateColorB.getSelectedItem()){
			case "Red": {
				makeRedPlateRequest(sashimi, (int)positionB.getSelectedItem());
				break;
				}
			case "Blue": {
				makeBluePlateRequest(sashimi, (int)positionB.getSelectedItem());
				}
			case "Green": {
				makeGreenPlateRequest(sashimi, (int)positionB.getSelectedItem());
				}
			case "Gold": {
				makeGoldPlateRequest(sashimi, (int)positionB.getSelectedItem(), goldPriceS.getValue());
				}
			}
			break;
		case "create_nigiri":
			Nigiri nigiri = new Nigiri((comp401.sushi.Nigiri.NigiriType)nigiriType.getSelectedItem());
			switch((String)plateColorB.getSelectedItem()){
			case "Red": {
				makeRedPlateRequest(nigiri, (int)positionB.getSelectedItem());
				break;
				}
			case "Blue": {
				makeBluePlateRequest(nigiri, (int)positionB.getSelectedItem());
				}
			case "Green": {
				makeGreenPlateRequest(nigiri, (int)positionB.getSelectedItem());
				}
			case "Gold": {
				makeGoldPlateRequest(nigiri, (int)positionB.getSelectedItem(), goldPriceS.getValue());
				}
			}
			break;
		case "reset":
			plateColorB.setSelectedIndex(0);
			positionB.setSelectedIndex(0);
			sashimiType.setSelectedIndex(0);
			nigiriType.setSelectedIndex(0);
			goldPriceS.setValue(0);
			avocadoS.setValue(0);
			crabS.setValue(0);
			eelS.setValue(0);
			riceS.setValue(0);
			salmonS.setValue(0);
			seaweedS.setValue(0);
			shrimpS.setValue(0);
			tunaS.setValue(0);
			break;
		}
		
		
		
	}
}
