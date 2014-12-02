package edu.fjnu.hrmis;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;

import javax.swing.SwingConstants;

import edu.fjnu.hrmis.dao.UserNameDao;
import edu.fjnu.hrmis.dao.UserNameDaoTxtImp;
import edu.fjnu.hrmis.domain.User;
import edu.fjnu.hrmis.exception.InvalidEmployeeInfoException;
import edu.fjnu.hrmis.ui.UIType;
import edu.fjnu.hrmis.utils.EmpMISUtils;
import edu.fjnu.hrmis.utils.EncryptionDecryptionUtils;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * @author zzp
 *
 */
/**
 * ��QQ��¼����
 * 
 */

public class Login extends JFrame {
	// �û���
	private JTextField username;
	// ����
	private JPasswordField password;
	// С����
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JLabel jl4;
	// С��ť
	private JButton bu1;
	private JButton bu2;
	private JButton bu3;
	// ��ѡ��
	private JCheckBox jc1;
	private JCheckBox jc2;
	// �б��
	private JComboBox jcb;

	/*
	 * ���췽��
	 */
	public Login() {
		// ���ô��ڱ���
		this.setTitle("\u5458\u5DE5\u7BA1\u7406\u767B\u9646\u754C\u9762");
		// ���������ʼ��
		init();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ò��ַ�ʽΪ���Զ�λ
		getContentPane().setLayout(null);
		// �û���¼״̬ѡ��
		jcb = new JComboBox();
		getContentPane().add(jcb);
		jcb.addItem("����");
		jcb.addItem("����");
		jcb.addItem("�뿪");
		jcb.setBounds(37, 157, 55, 20);
		this.setBounds(0, 0, 355, 280);
		// ���ô���ı���ͼ��
		this.setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						"D:\\eclipse\\\u5927\u4F5C\u4E1A1GUI-EmpMIS\\QQ\u622A\u56FE20141103195748.png"));
		// �����С���ܸı�
		this.setResizable(false);
		// ������ʾ
		this.setLocationRelativeTo(null);
		// ����ɼ�
		this.setVisible(true);
	}

	/*
	 * ��ʼ������
	 */
	public void init() {
		// ����һ������
		Container con = this.getContentPane();
		jl1 = new JLabel();
		jl1.setHorizontalAlignment(SwingConstants.CENTER);
		// ���ñ���ͼƬ
		jl1.setBounds(0, 0, 355, 265);
		// QQ��¼ͷ���趨
		jl2 = new JLabel();
		jl2.setIcon(new ImageIcon(
				"D:\\eclipse\\\u5927\u4F5C\u4E1A1GUI-EmpMIS\\QQ\u622A\u56FE20141103195538.png"));
		jl2.setBounds(40, 95, 50, 60);
		// �û������¼�����
		username = new JTextField();
		username.setFont(username.getFont().deriveFont(
				username.getFont().getSize() + 3f));
		username.setToolTipText("");
		username.setText("");
		username.setBounds(100, 100, 150, 20);
		// �û������¼������Աߵ�����
		jl3 = new JLabel("ע���˺�");

		/**
		 * ��ע�������Ϣ��Ӧ
		 */
		jl3.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent e) {
				Regist regist = new Regist();
				regist.show();

			}
		});
		jl3.setBounds(260, 100, 70, 20);
		// ���������
		password = new JPasswordField();
		password.setToolTipText("password");
		//password.setForeground(new Color(255, 255, 204));
		password.setBounds(100, 130, 150, 20);
		// ����������Աߵ�����
		jl4 = new JLabel("�һ�����");
		jl4.setBounds(260, 130, 70, 20);
		// ������·�����
		jc1 = new JCheckBox("��ס����");
		jc1.setBounds(105, 155, 80, 15);
		jc2 = new JCheckBox("�Զ���¼");
		jc2.setBounds(185, 155, 80, 15);
		// ��ť�趨
		bu1 = new JButton("��¼");
		bu1.setBounds(280, 200, 65, 20);
		// ����ť���1���¼�
		bu1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// ���ý����෽��
					EncryptionDecryptionUtils key = new EncryptionDecryptionUtils();
					String str = e.getActionCommand();
					if ("��¼".equals(str)) {
						String getName = username.getText();
						UserNameDao tree = new UserNameDaoTxtImp();
						/**
						 * ���û�������û���������Ļ���ϵͳ��ʾ����
						 */
						if (getName.toString().equals("")
								|| password.toString().equals("")) {
							JOptionPane.showConfirmDialog(null,
									"you have not input username or password!!"
											+ getName);
							throw new InvalidEmployeeInfoException(
									"you have not input username or password!!");
						}
						/**
						 * ����ı�־
						 */
						boolean falg = true;
						for (User user : tree.listUser()) {
							// �û��������ڵĻ�
							System.out.println(user);
							// �û����Ƿ���ڵ��ж�
							if (user.getUsername().toString()
									.equals((getName.toString()))) {
								// �����Ƿ���ȷ���ж�
								/**
								 * ���ù�����ļ��ܽ����еĽ��ܺ���
								 */
								if (key.decrypt(user.getPassword().toString())
										.equals((password.getText().toString()))) {
									JOptionPane.showConfirmDialog(null,
											"what you input is: " + getName);
									// �رյ�¼����
									setVisible(false);
									// �������˵�
									EmpMISUtils
											.runUIComponent(UIType.MAIN_MENU);
									System.out
											.println("================  EmpMIS 1.0 Quit ok! =================");
									falg = true;
									break;
								} else {
									JOptionPane.showConfirmDialog(null,
											"this password not correct!");
									throw new InvalidEmployeeInfoException(
											"this password not correct!!");
								}
							} else {
								/**
								 * һ��û���ҵ������������������ƥ���򽫱�־��Ϊfalse
								 */
								falg = false;
							}
						}
						/**
						 * ��⵽��־Ϊfalse�׳��쳣
						 */
						if (falg == false) {
							JOptionPane.showConfirmDialog(null,
									"this username not found!!" + getName);
							throw new InvalidEmployeeInfoException(
									"this username not found!!");
						}
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		bu2 = new JButton("���˺�");
		bu2.setBounds(5, 200, 75, 20);
		bu3 = new JButton("����");
		bu3.setBounds(100, 200, 65, 20);

		// �������������װ��
		jl1.add(jl2);
		jl1.add(jl3);
		jl1.add(jl4);
		jl1.add(jc1);
		jl1.add(jc2);
		jl1.add(bu1);
		jl1.add(bu2);
		jl1.add(bu3);
		con.add(jl1);
		con.add(username);
		con.add(password);
	}
}
