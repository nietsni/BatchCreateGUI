package top.instein.batchcreator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import org.apache.commons.io.FileUtils;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class CreaterApp {

	private JFrame frmV;
	private JPanel panel;
	private JButton btnAddEcho;
	private JScrollPane scrollPane;
	private JTextArea textAreaContent;
	private JTextField textFieldEcho;
	private JButton btnEchoOff;
	private JButton btnEchoOn;
	private JButton btnTest;
	private JButton btnPauseExit;
	private JButton btnAddRemark;
	private JTextField textFieldRemark;
	private JButton btnAddCMD;
	private JTextField textFieldCMD;
	private JPanel panel_1;
	private JLabel lblName;
	private JTextField textFieldVarName;
	private JLabel lblValue;
	private JTextField textFieldVarValue;
	private JButton btnVarAdd;
	private JComboBox comboBox;
	private JLabel lblNewLabel;

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
		frmV.getContentPane().add(getBtnTest());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(6, 6, 772, 241);
			panel.setLayout(null);
			panel.add(getBtnAddEcho());
			panel.add(getTextFieldEcho());
			panel.add(getBtnEchoOff());
			panel.add(getBtnEchoOn());
			panel.add(getBtnPauseExit());
			panel.add(getBtnAddRemark());
			panel.add(getTextFieldRemark());
			panel.add(getBtnAddCMD());
			panel.add(getTextFieldCMD());
			panel.add(getPanel_1());
		}
		return panel;
	}

	/**
	 * add new command to content
	 * 
	 * @param newLine
	 */
	private void addToBatchLn(String newLine) {
		String content = getTextAreaContent().getText();
		content += newLine + "\r\n";
		getTextAreaContent().setText(content);
	}
	
	private void addToBatch(String newLine) {
		String content = getTextAreaContent().getText();
		content += newLine;
		getTextAreaContent().setText(content);
	}

	private JButton getBtnAddEcho() {
		if (btnAddEcho == null) {
			btnAddEcho = new JButton("Add Echo");
			btnAddEcho.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String netLine = getTextFieldEcho().getText();
					addToBatchLn("echo " + netLine);
				}
			});
			btnAddEcho.setBounds(6, 31, 105, 30);
		}
		return btnAddEcho;
	}

	private JScrollPane getScrollPane_2() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(6, 259, 772, 258);
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
			textFieldEcho.setBounds(118, 31, 648, 30);
			textFieldEcho.setColumns(10);
		}
		return textFieldEcho;
	}

	private JButton getBtnEchoOff() {
		if (btnEchoOff == null) {
			btnEchoOff = new JButton("Echo Off");
			btnEchoOff.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToBatchLn("@echo off");
				}
			});
			btnEchoOff.setBounds(6, 0, 105, 30);
		}
		return btnEchoOff;
	}

	private JButton getBtnEchoOn() {
		if (btnEchoOn == null) {
			btnEchoOn = new JButton("Echo On");
			btnEchoOn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToBatchLn("@echo on");
				}
			});
			btnEchoOn.setBounds(119, 0, 105, 30);
		}
		return btnEchoOn;
	}

	private JButton getBtnTest() {
		if (btnTest == null) {
			btnTest = new JButton("test");
			btnTest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						File tempBatchFile = new File("temp.bat");
						FileUtils.writeStringToFile(tempBatchFile, getTextAreaContent().getText(), "gbk");
						String batchPath = tempBatchFile.getAbsolutePath();
						Runtime.getRuntime().exec("cmd /c start " + batchPath);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnTest.setBounds(688, 525, 90, 30);
		}
		return btnTest;
	}

	private JButton getBtnPauseExit() {
		if (btnPauseExit == null) {
			btnPauseExit = new JButton("pause&exit");
			btnPauseExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToBatchLn("pause");
					addToBatchLn("exit");
				}
			});
			btnPauseExit.setBounds(236, 0, 105, 30);
		}
		return btnPauseExit;
	}

	private JButton getBtnAddRemark() {
		if (btnAddRemark == null) {
			btnAddRemark = new JButton("Add remark");
			btnAddRemark.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToBatchLn("rem " + getTextFieldRemark().getText());
				}
			});
			btnAddRemark.setBounds(6, 62, 105, 30);
		}
		return btnAddRemark;
	}

	private JTextField getTextFieldRemark() {
		if (textFieldRemark == null) {
			textFieldRemark = new JTextField();
			textFieldRemark.setColumns(10);
			textFieldRemark.setBounds(118, 62, 648, 30);
		}
		return textFieldRemark;
	}

	private JButton getBtnAddCMD() {
		if (btnAddCMD == null) {
			btnAddCMD = new JButton("Add CMD");
			btnAddCMD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToBatchLn(getTextFieldCMD().getText());
				}
			});
			btnAddCMD.setBounds(6, 96, 105, 30);
		}
		return btnAddCMD;
	}

	private JTextField getTextFieldCMD() {
		if (textFieldCMD == null) {
			textFieldCMD = new JTextField();
			textFieldCMD.setColumns(10);
			textFieldCMD.setBounds(118, 96, 648, 30);
		}
		return textFieldCMD;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Set Var", TitledBorder.LEADING, TitledBorder.TOP, null,
					new Color(59, 59, 59)));
			panel_1.setBounds(6, 129, 760, 62);
			panel_1.setLayout(null);
			panel_1.add(getLblName());
			panel_1.add(getTextFieldVarName());
			panel_1.add(getLblValue());
			panel_1.add(getTextFieldVarValue());
			panel_1.add(getBtnVarAdd());
			panel_1.add(getComboBox());
			panel_1.add(getLblNewLabel());
		}
		return panel_1;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("name:");
			lblName.setBounds(350, 25, 55, 18);
		}
		return lblName;
	}

	private JTextField getTextFieldVarName() {
		if (textFieldVarName == null) {
			textFieldVarName = new JTextField();
			textFieldVarName.setText("");
			textFieldVarName.setBounds(417, 19, 78, 30);
			textFieldVarName.setColumns(10);
		}
		return textFieldVarName;
	}

	private JLabel getLblValue() {
		if (lblValue == null) {
			lblValue = new JLabel("value:");
			lblValue.setBounds(507, 25, 55, 18);
		}
		return lblValue;
	}

	private JTextField getTextFieldVarValue() {
		if (textFieldVarValue == null) {
			textFieldVarValue = new JTextField();
			textFieldVarValue.setText("");
			textFieldVarValue.setColumns(10);
			textFieldVarValue.setBounds(574, 19, 78, 30);
		}
		return textFieldVarValue;
	}

	private JButton getBtnVarAdd() {
		if (btnVarAdd == null) {
			btnVarAdd = new JButton("Add");
			btnVarAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBoxModel.addElement(textFieldVarName.getText());
					addToBatchLn(textFieldVarName.getText() + "=" + textFieldVarValue.getText());
				}
			});
			btnVarAdd.setBounds(664, 19, 90, 30);
		}
		return btnVarAdd;
	}

	DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						JComboBox j = (JComboBox) e.getSource();
						if(j.getItemCount()>1) {
							addToBatch("%"+j.getSelectedItem()+"%");
						}
					}
				}
			});
			comboBox.setBounds(110, 20, 223, 28);
			comboBox.setModel(comboBoxModel);
		}
		return comboBox;

	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("select var:");
			lblNewLabel.setBounds(20, 25, 83, 18);
		}
		return lblNewLabel;
	}
}
