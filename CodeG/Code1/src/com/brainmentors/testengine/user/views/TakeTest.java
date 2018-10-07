package com.brainmentors.testengine.user.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.brainmentors.testengine.question.dao.QuestionDAO;
import com.brainmentors.testengine.questions.dto.QuestionDTO;

public class TakeTest extends JFrame {

    private JPanel contentPane;
    private ButtonGroup bg = new ButtonGroup();
    
    private ArrayList<QuestionDTO> questions;
    private int currentIndex = 0;
    private void printQuestion() {
	clearSelection();
	if(currentIndex<questions.size()) {
	    QuestionDTO question = questions.get(currentIndex);
	    questionArea.setText(question.getName().trim());
	    optionA.setText(question.getOptions()[0].trim());
	    optionB.setText(question.getOptions()[1].trim());
	    optionC.setText(question.getOptions()[2].trim());
	    optionD.setText(question.getOptions()[3].trim());
	    if(question.getYourAnswer()!=null && question.getYourAnswer().trim().length()>0) {
		if(question.getYourAnswer().equals("a")) {
		    optionA.setSelected(true);
		}
		else
		if(question.getYourAnswer().equals("b")) {
		    optionB.setSelected(true);
		}
		if(question.getYourAnswer().equals("c")) {
		    optionC.setSelected(true);
		}
		else
		if(question.getYourAnswer().equals("d")) {
		    optionD.setSelected(true);
		}
		
	    }
	}
    }
    
    Timer timer;
    int count = 50;
    JLabel timeleft = new JLabel("Time Left:");
    private void timeCount() {
	timer = new Timer(100, new ActionListener() {
	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		if(count==0) {
		    timer.stop();
		    computeResult();
		}
		timeleft.setText("Time Left :"+count);;
		count--;
	    }
	});
	timer.start();
    }
    
    private void computeResult() {
	int totalScore = 0;
	if(questions!=null && questions.size()>0) {
	    for(QuestionDTO question : questions) {
		if(question.getYourAnswer()!=null && question.getYourAnswer().equals(question.getRightAnswer())) {
		    totalScore+=question.getScore();
		}
	    }
	}
	JOptionPane.showMessageDialog(this, "Score is "+totalScore, "Test", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void getQuestions() {
		QuestionDAO dao =new QuestionDAO();
		try {
		    this.questions = dao.getQuestions();
		    System.out.println("Question are "+questions);
		} catch (ClassNotFoundException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    TakeTest frame = new TakeTest();
		   
		    frame.setVisible(true);
		   
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }
    
    private void enableDisable() {
	boolean prevEnabled = false;
	boolean nextEnabled = false;
	if(questions.size()>1 && currentIndex>0) {
	    prevEnabled = true;
	    
	}
	if(currentIndex<questions.size() -1 ) {
	    nextEnabled = true;
	}
	 
	
	  btnPrev.setEnabled(prevEnabled);
	 
	  btnNext.setEnabled(nextEnabled);
	  
    }
    
    private void storeAnswer(String answer) {
	this.questions.get(currentIndex).setYourAnswer(answer);
    }
    
    /**
     * Create the frame.
     */
    JTextArea questionArea = new JTextArea();
    JRadioButton optionA = new JRadioButton("");
    JRadioButton optionB = new JRadioButton("");
    JRadioButton optionC = new JRadioButton("");
    JRadioButton optionD = new JRadioButton("");
    JButton btnPrev = new JButton("Prev");
    JButton btnNext = new JButton("Next");
    
    private void clearSelection() {
	bg.clearSelection();
	/*optionA.setSelected(false);
	optionB.setSelected(false);
	optionC.setSelected(false);
	optionD.setSelected(false);*/
	
    }
    
    public TakeTest() {
	 btnPrev.addActionListener(new ActionListener() {
	  	public void actionPerformed(ActionEvent e) {
	  	    if(currentIndex>0) {
	  		currentIndex--;
	  		printQuestion();
	  	    }
	  	    enableDisable();
	  	}
	  });
	 btnNext.addActionListener(new ActionListener() {
	  	public void actionPerformed(ActionEvent e) {
	  	    if(currentIndex<questions.size()-1) {
	  		  currentIndex++;
	  		  printQuestion();
	  	    }
	  	  
	  	    enableDisable();
	  	}
	  });
	getQuestions();
	printQuestion();
	enableDisable();
    	setResizable(false);
	setTitle("Take Test");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 576, 520);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(34, 60, 546, 166);
	contentPane.add(scrollPane);
	
	
	scrollPane.setRowHeaderView(questionArea);
	optionA.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		storeAnswer("a");
		}
		
	});
	optionB.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    storeAnswer("b");
		}
	});
	optionC.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    storeAnswer("c");
		}
	});
	optionD.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    storeAnswer("d");
		}
	});
	
	
	optionA.setBounds(34, 255, 237, 23);
	contentPane.add(optionA);
	
	
	optionB.setBounds(34, 290, 237, 23);
	contentPane.add(optionB);
	
	
	optionC.setBounds(34, 325, 237, 23);
	contentPane.add(optionC);
	
	
	optionD.setBounds(34, 360, 237, 23);
	contentPane.add(optionD);
	bg.add(optionA);
	bg.add(optionB);
	bg.add(optionC);
	bg.add(optionD);
	
	
	timeleft.setBounds(45, 17, 100, 31);
	contentPane.add(timeleft);
	
	
	btnPrev.setBounds(28, 430, 117, 29);
	contentPane.add(btnPrev);
	
	
	btnNext.setBounds(171, 430, 117, 29);
	contentPane.add(btnNext);
	
	JButton btnEndTest = new JButton("End Test");
	btnEndTest.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    computeResult();
		}
	});
	btnEndTest.setBounds(315, 430, 117, 29);
	contentPane.add(btnEndTest);
	 this.timeCount();
    }
}
