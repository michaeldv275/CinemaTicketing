package calendar;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import udc.DBConnect;

public class TableCellComponent extends JPanel {

  JLabel movieName;
 
  public TableCellComponent() {

    movieName = new JLabel(); 
    add(movieName);
  }
  
  public void updateData(Schedule schedule, boolean isSelected, JTable table) {
 
      DBConnect db = null;
      db = db.getDBConnect();
      String name = "";
      
      if(schedule.getMovieID() != 0) {
        String sqlInsertUser = "SELECT * FROM movie WHERE movieID = '"+schedule.getMovieID()+"'";

        try {
            Statement st = (Statement) db.getCon().createStatement();
            ResultSet rs = st.executeQuery(sqlInsertUser);

            while(rs.next()) {
                name = rs.getString("movieName");
                System.out.println(name);
            }

        } catch(SQLException ex) {

        }
      }
    movieName.setText(name);

  }
 
}