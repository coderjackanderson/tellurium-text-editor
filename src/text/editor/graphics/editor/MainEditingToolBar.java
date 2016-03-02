package text.editor.graphics.editor;

import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.text.StyledEditorKit;


/**
 * The tool bar for the main editing screen. Will contain items to edit text
 * styles and to also open, create new, and save files.
 * 
 * Created on:  March 01, 2016
 * Edited on:   March 01, 2016
 *
 * @author Jackie Chan
 */
public class MainEditingToolBar extends JToolBar {
    
    
    /** Buttons for the tool bar. */
    private static JButton newFileButton, openFileButton, saveFileButton, 
                           boldButton, italicButton, underlineButton;
    
    
    /** The combo box that contains the font sizes. */
    private static JComboBox fontSizeComboBox;
    
    
    /** The combo box that contains the available fonts. */
    private static JComboBox fontNamesComboBox;
    
    
    /** The default constructor for the tool bar. */
    public MainEditingToolBar(){createToolBar();}
    
    
    /** Creates and adds controls to the tool bar. */
    private void createToolBar() {
        newFileButton   = new JButton("New");
        openFileButton  = new JButton("Open");
        saveFileButton  = new JButton("Save");
        
        // These buttons will contain images. 
        boldButton      = new JButton(new ImageIcon("res/bold_action_32x32_white_icon.png"));
        italicButton    = new JButton(new ImageIcon("res/italic_action_32x32_white_icon.png"));
        underlineButton = new JButton(new ImageIcon("res/underline_action_32x32_white_icon.png"));
        
        boldButton.addActionListener(new StyledEditorKit.BoldAction());
        italicButton.addActionListener(new StyledEditorKit.ItalicAction());
        underlineButton.addActionListener(new StyledEditorKit.UnderlineAction());
        
        fontNamesComboBox = new JComboBox(GraphicsEnvironment.
                                            getLocalGraphicsEnvironment().
                                            getAvailableFontFamilyNames());
        fontNamesComboBox.setEditable(true);
        
        List<Integer> array = new ArrayList();
        for(int i = 0; i < 100; i++) {if(i % 2 == 0) array.add(i);}
        
        fontSizeComboBox = new JComboBox(array.toArray());
        fontSizeComboBox.setEditable(true);
        
        this.add(newFileButton);
        this.add(openFileButton);
        this.add(saveFileButton);
        
        this.addSeparator();
        
        this.add(new JLabel("Font: "));
        this.add(fontNamesComboBox);
        
        this.addSeparator();
        
        this.add(new JLabel("Font Size: "));
        this.add(fontSizeComboBox);
        
        this.addSeparator();
        
        this.add(boldButton);
        this.add(italicButton);
        this.add(underlineButton);
    }
    
}