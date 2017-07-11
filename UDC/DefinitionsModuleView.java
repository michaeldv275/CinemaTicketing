
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angel
 */
public class DefinitionsModuleView {
    
    public DefinitionsModuleView(){
        
        JFrame frame = new JFrame("Definitions Module");
        Accordion outlookBar = new Accordion();
        outlookBar.addBar("Add Movie", addMovie());
        outlookBar.addBar("Add  Theater", addTheater());
        outlookBar.addBar("Movie Showing Schedules", movieShowingSched());
        
        outlookBar.setVisibleBar(2);
        frame.getContentPane().add(outlookBar);
        
        frame.setSize(500, 400);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setResizable(false);
        frame.setLocation(d.width/2 - 400, d.height/2 - 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
    }
    
    public JPanel addMovie(){
        
        JPanel panel = new JPanel(null);
        JLabel titleLabel, descLabel, genreLabel, moviePosterLabel;
        JButton addBtn;
        JTextField titleTextField = new JTextField();
        JTextField descTextField = new JTextField();
        String[] genreString = {"Horror", "Comedy", "Romance", "Action"};
        JComboBox genre = new JComboBox(genreString);
        
        titleLabel = new JLabel("Title:");
        descLabel = new JLabel("Description:");
        genreLabel = new JLabel("Genre:");
        moviePosterLabel = new JLabel("Movie Poster:");
        addBtn = new JButton ("Add Movie");
        
        panel.add(titleLabel);
        panel.add(titleTextField);
        panel.add(descLabel);
        panel.add(descTextField);
        panel.add(genreLabel);
        panel.add(genre);
        panel.add(moviePosterLabel);
        panel.add(addBtn);
        
        titleLabel.setBounds(80, 40, 100, 25);
        titleTextField.setBounds(180, 40, 230, 25);
        
        descLabel.setBounds(80, 70, 100, 25);
        descTextField.setBounds(180, 70, 230, 25);
        
        genreLabel.setBounds(80, 100, 100, 25);
        genre.setBounds(180, 100, 230, 25);
        
        moviePosterLabel.setBounds(80, 130, 100, 25);
        
        addBtn.setBounds(190, 220, 120, 25);
        
        return panel;
    }
     
    public JPanel addTheater(){
        
        JPanel panel = new JPanel(null);
        JLabel nameLabel, flrNumLabel, rowNumLabel, colNumLabel, priceLabel;
        JButton addBtn;
        JTextField nameTextField = new JTextField();
        JTextField flrNumTextField = new JTextField();
        JTextField rowNumTextField = new JTextField();
        JTextField colNumTextField = new JTextField();
        JTextField priceTextField = new JTextField();
        
        nameLabel = new JLabel("Name:");
        flrNumLabel = new JLabel("Number of floors:");
        rowNumLabel = new JLabel("Number of seats in a row:");
        colNumLabel = new JLabel("Number of seats in a column:");
        priceLabel = new JLabel("Price per seat:");
        addBtn = new JButton ("Add Theater");
        
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(flrNumLabel);
        panel.add(flrNumTextField);
        panel.add(rowNumLabel);
        panel.add(rowNumTextField);
        panel.add(colNumLabel);
        panel.add(colNumTextField);
        panel.add(priceLabel);
        panel.add(priceTextField);
        panel.add(addBtn);
        
        nameLabel.setBounds(80, 40, 150, 25);
        nameTextField.setBounds(260, 40, 100, 25);
        
        flrNumLabel.setBounds(80, 70, 150, 25);
        flrNumTextField.setBounds(260, 70, 100, 25);
        
        rowNumLabel.setBounds(80, 100, 150, 25);
        rowNumTextField.setBounds(260, 100, 100, 25);
        
        colNumLabel.setBounds(80, 130, 170, 25);
        colNumTextField.setBounds(260, 130, 100, 25);
        
        priceLabel.setBounds(80, 160, 150, 25);
        priceTextField.setBounds(260, 160, 100, 25);
        
        addBtn.setBounds(180, 220, 130, 25);
        
        return panel;
    }
    
    public JPanel movieShowingSched(){
        
        JPanel panel = new JPanel(null);
        JLabel theaterLabel;
        JButton selectBtn;
        JComboBox theaterComboBox = new JComboBox(/*get arraylist of theaters here*/);
        
        theaterLabel = new JLabel("Select Theater:");
        selectBtn = new JButton ("Select");
        
        panel.add(theaterLabel);
        panel.add(theaterComboBox);
        panel.add(selectBtn);
        
        theaterLabel.setBounds(200, 50, 160, 25);
        theaterComboBox.setBounds(170, 90, 160, 25);
        selectBtn.setBounds(190, 220, 120, 25);
        
        return panel;
    }
    
    public class Accordion extends JPanel implements ActionListener {
        private JPanel topPanel = new JPanel( new GridLayout( 1, 1 ) );
        private JPanel bottomPanel = new JPanel( new GridLayout( 1, 1 ) );
        private Map bars = new LinkedHashMap();
        private int visibleBar = 0;
        private JComponent visibleComponent = null;
    
    public Accordion()
    {
        this.setLayout( new BorderLayout() );
        this.add( topPanel, BorderLayout.NORTH );
        this.add( bottomPanel, BorderLayout.SOUTH );
    }
    
    public void addBar( String name, JComponent component )
    {
        BarInfo barInfo = new BarInfo( name, component );
        barInfo.getButton().addActionListener( this );
        this.bars.put( name, barInfo );
        render();
    }
   
    public void addBar( String name, Icon icon, JComponent component )
    {
        BarInfo barInfo = new BarInfo( name, icon, component );
        barInfo.getButton().addActionListener( this );
        this.bars.put( name, barInfo );
        render();
    }
    
    public void removeBar( String name )
    {
        this.bars.remove( name );
        render();
    }
    
    public int getVisibleBar()
    {
        return this.visibleBar;
    }
    
    public void setVisibleBar( int visibleBar )
    {
        if( visibleBar > 0 &&
           visibleBar < this.bars.size() - 1 )
        {
            this.visibleBar = visibleBar;
            render();
        }
    }
    
    public void render(){
        int totalBars = this.bars.size();
        int topBars = this.visibleBar + 1;
        int bottomBars = totalBars - topBars;
       
        Iterator itr = this.bars.keySet().iterator();
       
        this.topPanel.removeAll();
        GridLayout topLayout = ( GridLayout )this.topPanel.getLayout();
        topLayout.setRows( topBars );
        BarInfo barInfo = null;
        for( int i=0; i<topBars; i++ )
        {
            String barName = ( String )itr.next();
            barInfo = ( BarInfo )this.bars.get( barName );
            this.topPanel.add( barInfo.getButton() );
        }
        this.topPanel.validate();
       
        if( this.visibleComponent != null )
        {
            this.remove( this.visibleComponent );
        }
        this.visibleComponent = barInfo.getComponent();
        this.add( visibleComponent, BorderLayout.CENTER );
        this.bottomPanel.removeAll();
        GridLayout bottomLayout = ( GridLayout )this.bottomPanel.getLayout();
        bottomLayout.setRows( bottomBars );
        for( int i=0; i<bottomBars; i++ )
        {
            String barName = ( String )itr.next();
            barInfo = ( BarInfo )this.bars.get( barName );
            this.bottomPanel.add( barInfo.getButton() );
        }
        this.bottomPanel.validate();
        this.validate();
    }
    
    public void actionPerformed( ActionEvent e ){
        int currentBar = 0;
        for( Iterator i=this.bars.keySet().iterator(); i.hasNext(); )
        {
            String barName = ( String )i.next();
            BarInfo barInfo = ( BarInfo )this.bars.get( barName );
            if( barInfo.getButton() == e.getSource() )
            {
                this.visibleBar = currentBar;
                render();
                return;
            }
            currentBar++;
        }
    }
    
    class BarInfo {
       
        private String name;
        private JButton button;
        private JComponent component;
        
        public BarInfo( String name, JComponent component )
        {
            this.name = name;
            this.component = component;
            this.button = new JButton( name );
        }
       
        public BarInfo( String name, Icon icon, JComponent component )
        {
            this.name = name;
            this.component = component;
            this.button = new JButton( name, icon );
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public void setName( String name )
        {
            this.name = name;
        }
        
        public JButton getButton()
        {
            return this.button;
        }
        
        public JComponent getComponent()
        {
            return this.component;
        }
    }
   
  
    }
}
