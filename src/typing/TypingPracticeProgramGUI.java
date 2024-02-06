package typing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.View;

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
		setTitle("Typing Practice Program");
		setBounds(100,100,450,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		 
		add(createCommandPanel(),BorderLayout.NORTH);
		add(createTypeWordPanel(),BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public JPanel createCommandPanel() {
		JPanel commandPanel = new JPanel();
		 setLayout(new GridLayout(1,2)); 
		 add(createDeletePanel());
		 add(createExercisePanel());
		
		 return commandPanel;
	}

	public JPanel createDeletePanel() {
		JPanel deletePanel = new JPanel(new FlowLayout());
		JLabel deleteLbl = new JLabel("Delete what : ");
		deleteWhatTextField = new JTextField(14);
		JButton deleteBtn = new JButton("Delete");
		
		deletePanel.add(deleteLbl);
		deletePanel.add(deleteWhatTextField);
		deletePanel.add(deleteBtn);
		
		return deletePanel;

	}

	public JPanel createExercisePanel() {
		JPanel exercisePanel = new JPanel(new FlowLayout());
		
		JLabel wordsLbl = new JLabel("Words : ");
		numOfWordTextField = new JTextField(5);
		JLabel widthLbl = new JLabel("Width : ");
		widthOfLineTextField = new JTextField(5);
		JButton makeBtn = new JButton("Make");
		JButton resetBtn = new JButton("Reset"); 
		exercisePanel.add(wordsLbl);
		exercisePanel.add(numOfWordTextField);
		exercisePanel.add(widthLbl);
		exercisePanel.add(widthOfLineTextField);

		exercisePanel.add(makeBtn);
		exercisePanel.add(resetBtn); 
		
		return exercisePanel;
	}
// ======================================================

	public JPanel createTypeWordPanel() {
		JPanel typeWordPanel = new JPanel(new FlowLayout());
		
		
		JLabel enterWordLbl = new JLabel("Enter a word : ");
		textWindow = new JTextArea(7,13);
		JTextField enterWordTxt = new JTextField(14); 
		typeWordPanel.add(enterWordLbl);
		typeWordPanel.add(enterWordTxt);
		return typeWordPanel;
	}

	public JPanel createLabelPanel(String labelTitle) {
		JPanel testPanel = new JPanel();
		
		return testPanel;
	}

	public JPanel createButtonPanel(JButton button) {
		JPanel testPanel = new JPanel();
		
		return testPanel;
	}

	class ButtonActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
//			 //이벤트가 발생한 버튼에 설정된 action command 읽어오기 
//		      String command=e.getActionCommand();
//		      if(command.equals("send")) {
//		         //JTextField에 입력한 문자열 읽어오기
//		    	  String msg = inputMsg.getText();
//		    	  JOptionPane.showMessageDialog(this, msg);
//		      }else if (command.equals("delete")) {
//		    	  //빈 문자열을 넣어주어서 삭제하기
//		    	  inputMsg.setText("");
//		      } 
			
		}

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
		MenuBar menuBar = new MenuBar();
		
		Menu file = new Menu("파일");
		MenuItem fileLoad = new MenuItem("Load");
		MenuItem fileExit = new MenuItem("Exit");
		file.add(fileLoad);
		file.add(fileExit);
		
		menuBar.add(file);
		setMenuBar(menuBar);
		setVisible(true);
	}
	
	class FileMenuActionListener implements ActionListener {

	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
		}

	}
	
	public static void main(String[] args) {
		
		new TypingPracticeProgramGUI();
		
		

	}
}
