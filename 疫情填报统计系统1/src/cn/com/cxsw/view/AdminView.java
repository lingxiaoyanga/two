package cn.com.cxsw.view;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import cn.com.cxsw.editor.ShowEditor;
import cn.com.cxsw.editor.UserAddEditor;
import cn.com.cxsw.editor.UserQurryEditor;
import cn.com.cxsw.util.MyInput;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class AdminView extends ViewPart {

	public static final String ID = "cn.com.cxsw.view.AdminView"; //$NON-NLS-1$

	public AdminView() {
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		Button button_4 = new Button(container, SWT.NONE);
		button_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 21, SWT.NORMAL));
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MyInput input = new MyInput();
				input.setName("填写表单");
				input.setToolTipText("填写表单");
				try {
					getSite().getWorkbenchWindow().getActivePage().openEditor(input, UserAddEditor.ID);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_4.setBounds(63, 101, 212, 114);
		button_4.setText("\u75AB\u60C5\u586B\u62A5");

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	
	private void createActions() {
		// Create the actions
	}

	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
