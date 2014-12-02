package edu.fjnu.hrmis;
/**
 * @author zzp
 *
 */
/**
 * ��qqע����洰�ڣ�
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import edu.fjnu.hrmis.dao.UserNameDao;
import edu.fjnu.hrmis.dao.UserNameDaoTxtImp;
import edu.fjnu.hrmis.domain.User;
import edu.fjnu.hrmis.utils.EncryptionDecryptionUtils;

public class Regist extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JLabel jb1 = new JLabel();
	JTextField txtUserName = new JTextField(10);
	JLabel jb2 = new JLabel();
	JPasswordField txtPassWord = new JPasswordField(6);
	FlowLayout flow = new FlowLayout();
	JTextArea jt1 = new JTextArea();
	JButton button = new JButton();

	public Regist() {
		getContentPane().setBackground(new Color(153, 153, 153));
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void jbInit() throws Exception {
		setSize(new Dimension(300, 175));
		getContentPane().setLayout(flow);
		jb1.setText("�û���");
		txtUserName.setText("");
		jb2.setText("����");
		txtPassWord.setText("");
		jt1.setText("");
		button.setText("ע��");
		button.addActionListener(new TextFrame_jButton1_actionAdapter(this));

		this.getContentPane().add(jb1);
		this.getContentPane().add(txtUserName);
		this.getContentPane().add(jb2);
		this.getContentPane().add(txtPassWord);
		this.getContentPane().add(jt1);
		this.getContentPane().add(button);

	}

	
	
}

class TextFrame_jButton1_actionAdapter implements ActionListener {
	private Regist adaptee;

	TextFrame_jButton1_actionAdapter(Regist adaptee) {
		this.adaptee = adaptee;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					/**
					 * ���ü�����
					 */
					EncryptionDecryptionUtils lock = new EncryptionDecryptionUtils();
					UserNameDao tree = new UserNameDaoTxtImp();
					/**
					 * ���ñ�־λ�����������׳��쳣��Ϊ�˱�����ѭ����֮ǰ�����׳�����ֹ������������ж�
					 */
					boolean flag = true;
					/**
					 * ��while�Ƿ����ѭ�����ж�
					 */
					boolean isContinued = true;
					while (isContinued) {
						for (User user : tree.TreeUsers()) {
							/**
							 * ����������û���������û��Ѿ�����������û����û��Ѿ����ڲ������־λΪfalse����ֹѭ��
							 */
							if (adaptee.txtUserName.getText().toString()
									.equals(user.getUsername().toString())) {
								adaptee.jt1.setText("login fail");
								JOptionPane.showConfirmDialog(null,
										"this username has exists!!");
								flag = false;
								isContinued = false;
								break;

							}
							/**
							 * ���û����������Ƿ�Ϊ�յ��жϣ����Ϊ������ʾ����������
							 */
							if (adaptee.txtUserName.getText().isEmpty()
									|| adaptee.txtPassWord.getText().isEmpty()) {
								JOptionPane.showConfirmDialog(null,
										"please input username or password!!");
								flag = false;
								isContinued = false;
								break;
							}
						}
						/**
						 * ����־λΪtrue��ʱ��Ͳ�������flag��Ϊtrue�������ѭ������������
						 */
						if (flag == true) {
							User user = new User();
							user.setUsername(adaptee.txtUserName.getText()
									.toString());
							//����
							user.setPassword(lock.encrypt(adaptee.txtPassWord
									.getText()));
							// ���浽�ļ���
							tree.saveUser(user);
							JOptionPane.showConfirmDialog(null,"ע��ɹ���!");
							flag = false;
							break;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				String username = adaptee.txtUserName.getText();
				String pwd = adaptee.txtPassWord.getPassword().toString();
				adaptee.jt1.setText("�����û����ǣ�" + username + "\n�������������ǣ�" + pwd);
			}

		});

	}

}