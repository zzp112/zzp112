package edu.fjnu.hrmis;
/**
 * @author zzp
 *
 */
/**
 * 仿qq注册界面窗口，
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
		jb1.setText("用户名");
		txtUserName.setText("");
		jb2.setText("密码");
		txtPassWord.setText("");
		jt1.setText("");
		button.setText("注册");
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
					 * 调用加密类
					 */
					EncryptionDecryptionUtils lock = new EncryptionDecryptionUtils();
					UserNameDao tree = new UserNameDaoTxtImp();
					/**
					 * 设置标志位，用来最终抛出异常，为了避免在循环完之前过早抛出而终止，产生错误的判断
					 */
					boolean flag = true;
					/**
					 * 对while是否继续循环的判断
					 */
					boolean isContinued = true;
					while (isContinued) {
						for (User user : tree.TreeUsers()) {
							/**
							 * 设置密码和用户名，如果用户已经存在则告诉用户此用户已经存在并定义标志位为false，终止循环
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
							 * 对用户名和密码是否为空的判断，如果为空则提示请输入密码
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
						 * 当标志位为true的时候就插入数据flag设为true避免继续循环而产生误判
						 */
						if (flag == true) {
							User user = new User();
							user.setUsername(adaptee.txtUserName.getText()
									.toString());
							//加密
							user.setPassword(lock.encrypt(adaptee.txtPassWord
									.getText()));
							// 保存到文件中
							tree.saveUser(user);
							JOptionPane.showConfirmDialog(null,"注册成功！!");
							flag = false;
							break;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				String username = adaptee.txtUserName.getText();
				String pwd = adaptee.txtPassWord.getPassword().toString();
				adaptee.jt1.setText("您的用户名是：" + username + "\n您的输入密码是：" + pwd);
			}

		});

	}

}