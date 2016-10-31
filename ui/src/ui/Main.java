package ui;

import java.io.File;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import edu.pnu.io.SimpleIndoorGMLImporter;
import edu.pnu.model.SpaceLayer;
import edu.pnu.model.dual.State;

public class Main {
    
    private Shell shell;
    
    private Text txtfilePath;
    private Button btnBrowse;
    
    private Button btnSubmit;
    private Button btnCancel;
    private Label lblNewLabel;

    
    private File igmlFile;
    private Tree tree;
    private DateTime dateTime;
    
    
    private SpaceLayer layer;
    private Table table;
    
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
                    
                    SimpleIndoorGMLImporter importer;
                    try {
                        importer = new SimpleIndoorGMLImporter(igmlFile);
                        layer = importer.getSpaceLayer();
                        

                        String[] titles = { "ID", "Duality", "Type", "Floor" };
                        for (int i = 0; i < titles.length; i++) {
                            TableColumn column = new TableColumn(table, SWT.NONE);
                            column.setText(titles[i]);
                            table.getColumn(i).pack();
                        }
                        
                        for (int i=0; i<titles.length; i++) {
                            table.getColumn (i).pack ();
                        }
                        
                        
                        Set<State> entrances = layer.getEntrances();
                        Iterator it = entrances.iterator();
                        while(it.hasNext()) {
                            TableItem item = new TableItem(table, SWT.NONE);
                            State s = (State) it.next();
                            item.setText(0, s.getId());
                            item.setText(1, s.getDuality().getId());
                            item.setText(2, (String) s.getUserData().get("USAGE"));
                            item.setText(3, (String) s.getUserData().get("FLOOR"));
                        }
                        
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                } else {
                   //TODO : error dialog 
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
        
        tree = new Tree(shell, SWT.BORDER);
        tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        
        
        /* Table */
        table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        
        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        data.heightHint = 200;
        table.setLayoutData(data);
        
        dateTime = new DateTime(shell, SWT.BORDER);
        new Label(shell, SWT.NONE);
        
        Menu popupMenu = new Menu(shell, SWT.BAR);
        MenuItem fileItem = new MenuItem(popupMenu, SWT.CASCADE);
        fileItem.setText("File");
        MenuItem refreshItem = new MenuItem(popupMenu, SWT.NONE);
        refreshItem.setText("Refresh");
        MenuItem deleteItem = new MenuItem(popupMenu, SWT.NONE);
        deleteItem.setText("Delete");

        Menu newMenu = new Menu(popupMenu);
        fileItem.setMenu(newMenu);

        MenuItem shortcutItem = new MenuItem(newMenu, SWT.NONE);
        shortcutItem.setText("Shortcut");
        MenuItem iconItem = new MenuItem(newMenu, SWT.NONE);
        iconItem.setText("Icon");
        
        shell.setMenuBar(popupMenu);
        
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
}
