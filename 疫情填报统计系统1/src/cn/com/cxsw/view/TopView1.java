package cn.com.cxsw.view;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

public class TopView1 extends ViewPart {

	public static final String ID = "cn.com.cxsw.view.Top"; //$NON-NLS-1$

	public TopView1() {
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundImage(SWTResourceManager.getImage(TopView1.class, "/cn/com/cxsw/imgs/\u957F\u56FE3.PNG"));
		
		Label lblLIS = new Label(container, SWT.NONE);
		lblLIS.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 19, SWT.BOLD));
		lblLIS.setBounds(152, 35, 268, 50);
		lblLIS.setText("L I S T E N E R");
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setBackgroundImage(SWTResourceManager.getImage(TopView1.class, "/cn/com/cxsw/imgs/0.PNG"));
		composite.setBounds(10, 0, 136, 123);
		
		Label label = new Label(container, SWT.NONE);
		label.setText(" \u897F \u5317 \u5E08 \u8303 \u5927 \u5B66 ");
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 19, SWT.BOLD));
		label.setBounds(154, 35, 305, 50);
		
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
