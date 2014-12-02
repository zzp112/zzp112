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
 * 仿QQ登录界面
 * 
 */

public class Login extends JFrame {
	// 用户名
	private JTextField username;
	// 密码
	private JPasswordField password;
	// 小容器
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JLabel jl4;
	// 小按钮
	private JButton bu1;
	private JButton bu2;
	private JButton bu3;
	// 复选框
	private JCheckBox jc1;
	private JCheckBox jc2;
	// 列表框
	private JComboBox jcb;

	/*
	 * 构造方法
	 */
	public Login() {
		// 设置窗口标题
		this.setTitle("\u5458\u5DE5\u7BA1\u7406\u767B\u9646\u754C\u9762");
		// 窗体组件初始化
		init();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置布局方式为绝对定位
		getContentPane().setLayout(null);
		// 用户登录状态选择
		jcb = new JComboBox();
		getContentPane().add(jcb);
		jcb.addItem("在线");
		jcb.addItem("隐身");
		jcb.addItem("离开");
		jcb.setBounds(37, 157, 55, 20);
		this.setBounds(0, 0, 355, 280);
		// 设置窗体的标题图标
		this.setIconImage(Toolkit
				.getDefaultToolkit()
				.getImage(
						"D:\\eclipse\\\u5927\u4F5C\u4E1A1GUI-EmpMIS\\QQ\u622A\u56FE20141103195748.png"));
		// 窗体大小不能改变
		this.setResizable(false);
		// 居中显示
		this.setLocationRelativeTo(null);
		// 窗体可见
		this.setVisible(true);
	}

	/*
	 * 初始化方法
	 */
	public void init() {
		// 创建一个容器
		Container con = this.getContentPane();
		jl1 = new JLabel();
		jl1.setHorizontalAlignment(SwingConstants.CENTER);
		// 设置背景图片
		jl1.setBounds(0, 0, 355, 265);
		// QQ登录头像设定
		jl2 = new JLabel();
		jl2.setIcon(new ImageIcon(
				"D:\\eclipse\\\u5927\u4F5C\u4E1A1GUI-EmpMIS\\QQ\u622A\u56FE20141103195538.png"));
		jl2.setBounds(40, 95, 50, 60);
		// 用户号码登录输入框
		username = new JTextField();
		username.setFont(username.getFont().deriveFont(
				username.getFont().getSize() + 3f));
		username.setToolTipText("");
		username.setText("");
		username.setBounds(100, 100, 150, 20);
		// 用户号码登录输入框旁边的文字
		jl3 = new JLabel("注册账号");

		/**
		 * 对注册添加消息响应
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
		// 密码输入框
		password = new JPasswordField();
		password.setToolTipText("password");
		//password.setForeground(new Color(255, 255, 204));
		password.setBounds(100, 130, 150, 20);
		// 密码输入框旁边的文字
		jl4 = new JLabel("找回密码");
		jl4.setBounds(260, 130, 70, 20);
		// 输入框下方文字
		jc1 = new JCheckBox("记住密码");
		jc1.setBounds(105, 155, 80, 15);
		jc2 = new JCheckBox("自动登录");
		jc2.setBounds(185, 155, 80, 15);
		// 按钮设定
		bu1 = new JButton("登录");
		bu1.setBounds(280, 200, 65, 20);
		// 给按钮添加1个事件
		bu1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// 调用解密类方法
					EncryptionDecryptionUtils key = new EncryptionDecryptionUtils();
					String str = e.getActionCommand();
					if ("登录".equals(str)) {
						String getName = username.getText();
						UserNameDao tree = new UserNameDaoTxtImp();
						/**
						 * 如果没有输入用户名或密码的话，系统提示输入
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
						 * 定义的标志
						 */
						boolean falg = true;
						for (User user : tree.listUser()) {
							// 用户名不存在的话
							System.out.println(user);
							// 用户名是否存在的判断
							if (user.getUsername().toString()
									.equals((getName.toString()))) {
								// 密码是否正确的判断
								/**
								 * 调用工具类的加密解密中的解密函数
								 */
								if (key.decrypt(user.getPassword().toString())
										.equals((password.getText().toString()))) {
									JOptionPane.showConfirmDialog(null,
											"what you input is: " + getName);
									// 关闭登录界面
									setVisible(false);
									// 启动主菜单
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
								 * 一旦没有找到密码或者密码姓名不匹配则将标志设为false
								 */
								falg = false;
							}
						}
						/**
						 * 检测到标志为false抛出异常
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

		bu2 = new JButton("多账号");
		bu2.setBounds(5, 200, 75, 20);
		bu3 = new JButton("设置");
		bu3.setBounds(100, 200, 65, 20);

		// 所有组件用容器装载
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
