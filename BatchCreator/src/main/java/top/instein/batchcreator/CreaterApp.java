package top.instein.batchcreator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreaterApp {

	private JFrame frmV;
	private JPanel panel;
	private JButton btnAddEcho;
	private JScrollPane scrollPane;
	private JTextArea textAreaContent;
	private JTextField textFieldEcho;
	private JButton btnEchoOff;
	private JButton btnEchoOn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreaterApp window = new CreaterApp();
					window.frmV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreaterApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmV = new JFrame();
		frmV.setTitle("v0.0.1");
		frmV.setBounds(100, 100, 800, 600);
		frmV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmV.getContentPane().setLayout(null);
		frmV.getContentPane().add(getPanel());
		frmV.getContentPane().add(getScrollPane_2());
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(6, 6, 772, 223);
			panel.setLayout(null);
			panel.add(getBtnAddEcho());
			panel.add(getTextFieldEcho());
			panel.add(getBtnEchoOff());
			panel.add(getBtnEchoOn());
		}
		return panel;
	}
	
	/**
	 * add new command to content
	 * @param newLine
	 */
	private void addToBatch(String newLine) {
		String content = getTextAreaContent().getText();
		content += newLine+"\r\n";
		getTextAreaContent().setText(content);
	}
	
	private JButton getBtnAddEcho() {
		if (btnAddEcho == null) {
			btnAddEcho = new JButton("Add Echo");
			btnAddEcho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String netLine = getTextFieldEcho().getText();
					addToBatch("echo "+netLine);
				}
			});
			btnAddEcho.setBounds(6, 31, 90, 30);
		}
		return btnAddEcho;
	}
	private JScrollPane getScrollPane_2() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 268, 772, 287);
			scrollPane.setViewportView(getTextAreaContent());
		}
		return scrollPane;
	}
	private JTextArea getTextAreaContent() {
		if (textAreaContent == null) {
			textAreaContent = new JTextArea();
		}
		return textAreaContent;
	}
	private JTextField getTextFieldEcho() {
		if (textFieldEcho == null) {
			textFieldEcho = new JTextField();
			textFieldEcho.setBounds(108, 31, 658, 30);
			textFieldEcho.setColumns(10);
		}
		return textFieldEcho;
	}
	private JButton getBtnEchoOff() {
		if (btnEchoOff == null) {
			btnEchoOff = new JButton("Echo Off");
			btnEchoOff.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToBatch("@echo off");
				}
			});
			btnEchoOff.setBounds(6, 0, 90, 30);
		}
		return btnEchoOff;
	}
	private JButton getBtnEchoOn() {
		if (btnEchoOn == null) {
			btnEchoOn = new JButton("Echo On");
			btnEchoOn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToBatch("@echo on");
				}
			});
			btnEchoOn.setBounds(108, 0, 90, 30);
		}
		return btnEchoOn;
	}
}
