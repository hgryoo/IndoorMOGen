package ui;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Main {
    
    private Shell shell;
    
    private Text txtfilePath;
    private Button btnBrowse;
    
    private Button btnSubmit;
    private Button btnCancel;
    private Label lblNewLabel;

    
    private File igmlFile;
    
    
    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args) {
        try {
            Main window = new Main();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the window.
     */
    public void open() {
        Display display = Display.getDefault();
        shell = new Shell();
        shell.setSize(450, 300);
        shell.setText("SWT Application");
        shell.setLayout(new GridLayout(2, true));
        
        txtfilePath = new Text(shell, SWT.BORDER);
        GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd_text.widthHint = 192;
        txtfilePath.setLayoutData(gd_text);
        
        btnBrowse = new Button(shell, SWT.NONE);
        btnBrowse.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
        btnBrowse.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                
                FileDialog dialog = new FileDialog (shell, SWT.OPEN);
                String [] filterNames = new String [] {"IndoorGML File", "All Files (*)"};
                String [] filterExtensions = new String [] {"*.xml;*.gml;*.igml;", "*"};
                String filterPath = "/";
                String platform = SWT.getPlatform();
                if (platform.equals("win32")) {
                        filterNames = new String [] {"IndoorGML File", "All Files (*.*)"};
                        filterExtensions = new String [] {".xml;*.gml;*.igml;", "*.*"};
                        filterPath = "c:\\";
                }
                dialog.setFilterNames (filterNames);
                dialog.setFilterExtensions (filterExtensions);
                dialog.setFilterPath (filterPath);
                
                String path = dialog.open();
                txtfilePath.setText(path);
            }
        });
        btnBrowse.setText("Browse IndoorGML");
        
        btnSubmit = new Button(shell, SWT.NONE);
        GridData gd_btnNewButton_1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
        gd_btnNewButton_1.widthHint = 205;
        btnSubmit.setLayoutData(gd_btnNewButton_1);
        btnSubmit.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                igmlFile = new File(txtfilePath.getText());
                if(igmlFile.canRead()) {
                    txtfilePath.setEnabled(false);
                    btnBrowse.setEnabled(false);
                } else {
                    
                }
            }
        });
        btnSubmit.setText("Submit");
        
        btnCancel = new Button(shell, SWT.NONE);
        btnCancel.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                txtfilePath.setText("");
                txtfilePath.setEnabled(true);
                btnBrowse.setEnabled(true);
            }
        });
        GridData gd_btnNewButton_2 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
        gd_btnNewButton_2.widthHint = 36;
        btnCancel.setLayoutData(gd_btnNewButton_2);
        btnCancel.setText("Cancel");
        new Label(shell, SWT.NONE);
        new Label(shell, SWT.NONE);
        
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
}
