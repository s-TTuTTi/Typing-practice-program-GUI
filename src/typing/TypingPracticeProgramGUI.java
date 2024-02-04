package typing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TypingPracticeProgramGUI extends JFrame {
	private WordManager wordManager = new WordManager();
	private JTextArea textWindow;
	private JTextField numOfWordTextField;
	private JTextField widthOfLineTextField;
	private JTextField typeWordTextField;
	private JTextField deleteWhatTextField;
	private int countOfWord = -1;
	private int numOfCorrectWord = 0;
	
	public TypingPracticeProgramGUI() {

	}
	
	public JPanel createCommandPanel() {

	}

	public JPanel createDeletePanel() {

	}

	public JPanel createExercisePanel() {

	}

	public JPanel createTypeWordPanel() {

	}

	public JPanel createLabelPanel(String labelTitle) {

	}

	public JPanel createButtonPanel(JButton button) {

	}

	class ButtonActionListener implements ActionListener {

	}

	// remove all data in exercise pool and restore all data in word pool
	// clear all textField and textArea
	// initialize countOfWord and numOfCorrectWord
	public void reset() {

	}

	// if all words are typed correctly, reset should be conducted.
	class TypeKeyAdapter extends KeyAdapter {

	}
	
	public void createMenuBar() {

	}
	
	class FileMenuActionListener implements ActionListener {

	}
	
	public static void main(String[] args) {

	}
}
