package cn.com.cxsw.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import java.util.Date;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.com.cxsw.util.DateUtil;
import cn.com.cxsw.util.DbUtil;
import cn.com.cxsw.util.MsgUtil;
import cn.com.cxsw.util.ValidatePassWordUtil;
import cn.com.cxsw.utils.StringRegexUtils;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class UserAddDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_3;
	private Text text_4;
	private DbUtil db=new DbUtil();
	private String sourcePath;
	private Text text_5;
	private Text text_1;
	private Text text_2;


	/**
	 * Create the dialog.
	 * @param 
	 * @param style
	 */
	public UserAddDialog(Shell parent, int style) {
		super(parent, style);
		setText("学生注册");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.MIN | SWT.MAX);
		shell.setBackgroundImage(SWTResourceManager.getImage(UserAddDialog.class, "/cn/com/cxsw/imgs/logo.PNG"));
		shell.setSize(1390, 885);
		shell.setText(getText());
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.BOLD));
		composite.setBackgroundImage(SWTResourceManager.getImage(UserAddDialog.class, "/cn/com/cxsw/imgs/32.PNG"));
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		composite.setBounds(0, 0, 1384, 845);
		
		Label label_13 = new Label(composite, SWT.NONE);
		label_13.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_13.setText(" *");
		label_13.setForeground(SWTResourceManager.getColor(255, 99, 71));
		label_13.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label_13.setBounds(404, 157, 57, 24);
		
		text = new Text(composite, SWT.BORDER);
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				// 校验学号
				String name = text_3.getText().trim();
				if (ValidatePassWordUtil.validateName(name)) {
					label_13.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
					label_13.setText(" √ ");
				} else {
					label_13.setForeground(SWTResourceManager.getColor(255, 99, 71));
					label_13.setText(" * ");
				}
			}
		});
		text.setBounds(202, 160, 196, 30);
		
		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_1.setText("\u6027\u522B\uFF1A");
		label_1.setBounds(579, 163, 48, 24);
		
		Button button = new Button(composite, SWT.RADIO);
		button.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		button.setText("男");
		button.setBounds(671, 163, 61, 24);
		
		Button button_1 = new Button(composite, SWT.RADIO);
		button_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		button_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		button_1.setText("女");
		button_1.setBounds(761, 163, 57, 24);
		
		Label label_2 = new Label(composite, SWT.NONE);
		label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setText("\u6240\u5728\u5730\u533A\uFF1A");
		label_2.setBounds(579, 315, 82, 24);
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setItems(new String[] {"\u5170\u5DDE\u5E02", "\u5317\u4EAC\u5E02", "\u5357\u4EAC\u5E02", "\u4E0A\u6D77\u5E02", "\u82CF\u5DDE\u5E02", "\u53A6\u95E8\u5E02"});
		combo.setBounds(671, 312, 161, 32);
		combo.select(2);
		
		text_5 = new Text(composite, SWT.BORDER);
		text_5.setBounds(202, 231, 196, 30);
		
		text_1 = new Text(composite, SWT.BORDER);
		text_1.setBounds(202, 486, 196, 30);
		
		text_2 = new Text(composite, SWT.BORDER);
		text_2.setBounds(671, 231, 161, 30);
		
		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_3.setText("\u59D3\u540D\uFF1A");
		label_3.setBounds(123, 234, 64, 24);
		
		Label label_5 = new Label(composite, SWT.NONE);
		label_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_5.setText("\u5B66\u9662\uFF1A");
		label_5.setBounds(123, 489, 61, 24);
		
		Label label_6 = new Label(composite, SWT.NONE);
		label_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_6.setText("\u73ED\u7EA7\uFF1A");
		label_6.setBackgroundImage(null);
		label_6.setBounds(579, 234, 61, 24);
		
		Label label_7 = new Label(composite, SWT.NONE);
		label_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_7.setText("\u5BC6\u7801\uFF1A");
		label_7.setBounds(123, 315, 57, 24);
		
		Label label_8 = new Label(composite, SWT.NONE);
		label_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_8.addFocusListener(new FocusAdapter() {
			
		});
		label_8.setText(" *");
		label_8.setForeground(SWTResourceManager.getColor(255, 99, 71));
		label_8.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label_8.setBounds(404, 309, 57, 24);
		
		text_3 = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		text_3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				// 校验密码（数字，六位）
				String passWord = text_3.getText().trim();
				if (ValidatePassWordUtil.validateUserPassWord(passWord)) {
					label_8.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
					label_8.setText(" √ ");
				} else {
					label_8.setForeground(SWTResourceManager.getColor(255, 99, 71));
					label_8.setText(" * ");
				}
			}
		});
		text_3.setBounds(202, 312, 196, 30);
		
		Label label_9 = new Label(composite, SWT.NONE);
		label_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_9.setText("\u5E74\u7EA7\uFF1A");
		label_9.setBounds(123, 399, 48, 24);
		
		Combo combo_1 = new Combo(composite, SWT.NONE);
		combo_1.setItems(new String[] {"2016\u7EA7", "2017\u7EA7", "2018\u7EA7", "2019\u7EA7"});
		combo_1.setBounds(202, 396, 196, 32);
		
		Label label_14 = new Label(composite, SWT.NONE);
		label_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_14.setText(" *");
		label_14.setForeground(SWTResourceManager.getColor(255, 99, 71));
		label_14.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.BOLD));
		label_14.setBounds(844, 393, 57, 24);
		
		Button button_3 = new Button(composite, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String id = text.getText().trim();
				//校验学号
				if ("".equals(id)) {
					MsgUtil.showMsgInfo("学号不可以为空！");
					return;
				}
				String sql1 = "";
				String name = text_5.getText().trim();
				String password = text_3.getText().trim();
				String sex = "";
				if (button.getSelection()) {
					sex = "男";
				}else if(button_1.getSelection()){
					sex = "女";
				}
				String nj = combo_1.getText();
				String xy = text_1.getText().trim();
				String bj = text_2.getText().trim();
				String city = combo.getText();
				String phone = text_4.getText().trim();

				//校验电话号码
				boolean res1 = StringRegexUtils.isRegexpValidate(phone, StringRegexUtils.mobil_regexp);
				if (!res1) {
					MsgUtil.showMsgInfo("电话号码不合法！");
					return;
				}
				
				/*Date date=new Date();
				String d=date.toLocaleString();*/
				//执行保存sql
				String sql = "INSERT INTO USER(u_id,u_name,u_sex,u_p"
						+ "word,u_nj,u_xy,u_bj,u_city,u_num) VALUES(?,?,?,?,?,?,?,?,?)";
				int res = db.update(sql,id,name,sex,password,nj,xy,bj,city,phone);
				if (res > 0) {
					MsgUtil.showMsgOK("注册成功！");
					shell.close();
				}else{
					MsgUtil.showMsgError("注册失败！");
				}
				
			}
		});
		button_3.setText("\u6CE8\u518C");
		button_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		button_3.setBounds(471, 648, 114, 34);
		
		Label label_10 = new Label(composite, SWT.NONE);
		label_10.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_10.setText("\u7535\u8BDD\u53F7\u7801\uFF1A");
		label_10.setBounds(579, 399, 90, 24);
		
		text_4 = new Text(composite, SWT.BORDER);
		text_4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				//校验电话号码
				String phone = text_4.getText().trim();
				if (StringRegexUtils.isRegexpValidate(phone, StringRegexUtils.mobil_regexp)) {
					label_14.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
					label_14.setText(" √ ");
				} else {
					label_14.setForeground(SWTResourceManager.getColor(255, 99, 71));
					label_14.setText(" * ");
				}
			}
		});
		text_4.setBounds(671, 396, 167, 30);
		
		Label label_11 = new Label(composite, SWT.NONE);
		label_11.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_11.setText("\u7F16\u8F91\u4E2A\u4EBA\u4FE1\u606F");
		label_11.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BORDER));
		label_11.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.BOLD));
		label_11.setBounds(124, 24, 210, 48);
		
		Label label_12 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_12.setBounds(35, 78, 1294, 2);
		
		Label label = new Label(composite, SWT.NONE);
		label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label.setBounds(123, 163, 61, 24);
		label.setText("\u5B66\u53F7\uFF1A");	
		
		
		
	}
}
