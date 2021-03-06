package cn.com.cxsw.view;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

import cn.com.cxsw.dialog.Discnum;
import cn.com.cxsw.dialog.Discshop;
import cn.com.cxsw.editor.UserAddEditor;
import cn.com.cxsw.editor.UserQurryEditor;
import cn.com.cxsw.util.MyInput;

public class AdminView1 extends ViewPart {

	public static final String ID = "cn.com.cxsw.view.AdminView1"; //$NON-NLS-1$

	public AdminView1() {
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Button button_5 = new Button(container, SWT.NONE);
		button_5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 21, SWT.NORMAL));
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MyInput input = new MyInput();
				input.setName("用户信息查询");
				input.setToolTipText("用户信息查询");
				try {
					getSite().getWorkbenchWindow().getActivePage().openEditor(input, UserQurryEditor.ID);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_5.setBounds(37, 135, 322, 134);
		button_5.setText("\u5B66\u751F\u9632\u63A7\u67E5\u8BE2");
		
		Button button_6 = new Button(container, SWT.NONE);
		button_6.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 21, SWT.NORMAL));
		button_6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Discnum dn = new Discnum(container.getShell(), SWT.NONE);
				dn.open();
			}
		});
		button_6.setText("\u5065\u5EB7\u72B6\u51B5\u7EDF\u8BA1");
		button_6.setBounds(37, 379, 322, 134);
		
		Button button_7 = new Button(container, SWT.NONE);
		button_7.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 21, SWT.NORMAL));
		button_7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Discshop ds = new Discshop(container.getShell(), SWT.NONE);
				ds.open();
			}
		});
		button_7.setText("\u6240\u5728\u5730\u533A\u7EDF\u8BA1");
		button_7.setBounds(37, 617, 322, 134);

		createActions();
		initializeToolBar();
		initializeMenu();
	}
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

}
