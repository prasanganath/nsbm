/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafxapplication1.dbconnect;

/**
 *
 * @author user
 */
public class course {
    private String courseid;
    private String coursename;
    private Connection con=dbconnect.getConnection();
    
    public course(String courseid,String coursename){
        this.courseid=courseid;
        this.coursename=coursename;
    }
    
    public String getcourseid(){
     return courseid ;
    }
    public String getcoursename(){
        return coursename;
    }
    
    public void save() throws SQLException{
        String query="INSERT INTO course1(courseid,coursename) VALUES(?,?)";
        PreparedStatement insql=con.prepareStatement(query);
        insql.setString(1,this.getcourseid());
        insql.setString(2,this.getcoursename());
        insql.execute();
        
        
        
    }
    
    public void update() throws SQLException{
        String query="UPDATE course SET coursename=? WHERE courseid=?";
        PreparedStatement updsql=con.prepareStatement(query);
        updsql.setString(1,this.getcoursename());
        updsql.setString(2,this.getcourseid());
        updsql.execute();
    }
    public void delete() throws SQLException{
        String query="DELETE course FROM course1 WHERE courseid=?";
        PreparedStatement upddel=con.prepareStatement(query);
        upddel.setString(1,this.getcourseid());
        upddel.execute();
    }
    
    
    
    
    public static course find(String courseid) throws SQLException{
        Connection con=dbconnect.getConnection();
        String query="SELECT * FROM course1 WHERE courseid=?";
        PreparedStatement ert=con.prepareStatement(query);
        ert.setString(1,courseid);
        ResultSet result=ert.executeQuery();
        String courseid1=null;
        String name=null;
        while(result.next()){
             courseid1=result.getString("courseid");
             name=result.getString("coursename");
            
             
            
        }
        course thiscourse=new course(courseid1,name);
        
        return thiscourse;
        
    }
}
