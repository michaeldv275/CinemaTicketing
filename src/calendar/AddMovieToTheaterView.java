/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.GregorianCalendar;
import javax.swing.*;



/**
 *
 * @author Mico
 */
public class AddMovieToTheaterView extends JFrame{

    private int monthBound, dayBound, yearBound, yearToday,
                nod, temp;
    private String[] stringMonth;
    private JButton btnAdd;
    private JLabel lblDate, lblMovie, lblTheater;
    private JComboBox boxMonths, boxDays, boxYears, boxMovieList, boxTheaterList; 
  
    public AddMovieToTheaterView() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        
        this.setSize(450, 300);
        this.setLocation(325, 120);
        this.setVisible(true);
        this.setResizable(false);
        init();
    }

    public void init() {
        stringMonth = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        btnAdd = new JButton("Add Movie");
        lblDate = new JLabel("Date:");
        lblMovie = new JLabel("Movie List: ");
//        lblTheater = new JLabel("Theater: ");
        boxMonths = new JComboBox(stringMonth);
        boxDays = new JComboBox();
        boxYears = new JComboBox();
        boxMovieList = new JComboBox();
//        boxTheaterList = new JComboBox<>();
        
        this.add(lblMovie);
        this.add(boxMovieList);
//        this.add(lblTheater);
//        this.add(boxTheaterList);
        this.add(lblDate);
        this.add(boxMonths);
        this.add(boxDays);
        this.add(boxYears);
        this.add(btnAdd);
        
        lblMovie.setBounds(20, 10, 100, 20);
        boxMovieList.setBounds(100, 10, 250, 25);
//        lblTheater.setBounds(20, 80, 100, 20);
//        boxTheaterList.setBounds(100, 80, 200, 25);  
        lblDate.setBounds(20, 150, 100, 20);
        boxMonths.setBounds(100, 150, 100, 25);
        boxDays.setBounds(215, 150, 70, 25);
        boxYears.setBounds(300, 150, 80, 25);
        btnAdd.setBounds(130, 215, 200, 30);
        
        // Get current year
        GregorianCalendar cal = new GregorianCalendar();
	dayBound = cal.get(GregorianCalendar.DAY_OF_MONTH);
        monthBound = cal.get(GregorianCalendar.MONTH);
        yearBound = cal.get(GregorianCalendar.YEAR);
	nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        // String for years
        for (int i = yearBound-100; i <= yearBound+100; i++)
        {
            boxYears.addItem(String.valueOf(i));
	}

        // Set as current year
        boxYears.setSelectedItem("" + yearBound);
        boxMonths.setSelectedItem("" + stringMonth[monthBound]);
        refreshNumberOfDays(nod);
        
        this.setLayout(null);
    }

    public int getNumberOfDays(){
        // get selected year
        String selectedYear = boxYears.getSelectedItem().toString();
        yearToday = Integer.parseInt(selectedYear);
        // get index for selected month
        String selectedMonth = boxMonths.getSelectedItem().toString();
        int i = Arrays.asList(stringMonth).indexOf(selectedMonth);
        
        // get number of days from calendar
        GregorianCalendar calendar = new GregorianCalendar(yearToday, i, 1);
        temp = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
       
        return temp; // return number of days
    }
    
    public void refreshNumberOfDays(int numOfDays){
        /*  remove items from combobox and
            replace with number of days of chosen date */
        boxDays.removeAllItems();
        for (int j=1; j <= numOfDays; j++)
            boxDays.addItem(String.valueOf(j));
        boxDays.setSelectedItem(""+dayBound);
    }

    public void disposeMainFrame() {
        this.dispose();
    }
    
    public void setMovieList(String text){
        boxMovieList.addItem(text);
    }
    
    /* GETTERS */
    public int getBoxMonths() {
        return (boxMonths.getSelectedIndex())+1;
    }

    public int getBoxDays() {
        return Integer.parseInt(boxDays.getSelectedItem().toString());
    }

    public int getBoxYears() {
        return Integer.parseInt(boxYears.getSelectedItem().toString());
    }

    public String getBoxMovieList() {
        return boxMovieList.getSelectedItem().toString();
    }
    
    /* SETTERS */
    public void setAdd(ActionListener a){
        btnAdd.addActionListener(a);
    }

    public void setComboBoxMonth(ActionListener a){
        boxMonths.addActionListener(a);
    }
    public void setComboBoxYear(ActionListener a){
        boxYears.addActionListener(a);
    }
}
