package sushigame.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import comp401.sushi.Nigiri;
import comp401.sushi.Plate;
import sushigame.model.Belt;
import sushigame.model.BeltEvent;
import sushigame.model.BeltObserver;


public class PlateViewWidget extends JPanel implements ActionListener, MouseListener{
	private JLabel _plabel;
	private Plate _plate;
	private JButton _button;
	private JFrame _myFrame; 
	
	
	public PlateViewWidget(Plate p){
	_plate = p;
	_plabel = new JLabel("");
	_button = new JButton();
	_myFrame = new JFrame();
	_button.setName(_plate.getContents().getName());
	_button.addActionListener(this);
	_button.setBackground(Color.WHITE);
	_button.addMouseListener(this);
	_button.setActionCommand("pressed");
	
	_plabel.setMinimumSize(new Dimension(300, 20));
	_plabel.setPreferredSize(new Dimension(300, 20));
	_plabel.setOpaque(true);
	_plabel.setBackground(Color.GRAY);
	
	
	}
	
	public void refresh(){
		if (_plate == null) {
			_plabel.setText("");
			_plabel.setBackground(Color.GRAY);
		} else {
			_plabel.setText(_plate.getContents().getName() + ", Placed by: " + _plate.getChef().getName() + "/n" );
			switch (_plate.getColor()) {
			case RED:
				_plabel.setBackground(Color.RED); break;
			case GREEN:
				_plabel.setBackground(Color.GREEN); break;
			case BLUE:
				_plabel.setBackground(Color.BLUE); break;
			case GOLD:
				_plabel.setBackground(Color.YELLOW); break;
			}
		}
	}
	public JLabel getJLabel(){
		return _plabel;
	}
	
	public Plate getPlate(){
		return _plate;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                _myFrame.setAlwaysOnTop(true);
                _myFrame.initialize(instance);

                _myFrame.setLocation(instance.nMainPanelXPosition,instance.nMainPanelYPosition);
                _myFrame.setVisible(true);
            }
        });
    }

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
