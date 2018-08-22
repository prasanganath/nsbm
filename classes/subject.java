/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.classes;

import com.mysql.cj.protocol.Resultset;
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
public class subject {
    private String  subjectid;
    private int noofassignment;
    private String courseid;
    private String subjectname;    /////////////
    private Connection con=dbconnect.getConnection();
    
    public subject(String subjectid,int noofassignment,String courseid,String subjectname){
        this.subjectid=subjectid;
        this.noofassignment=noofassignment;
        this.courseid=courseid;
        this.subjectname=subjectname;  //////////
    }
    
    public String getsubjectid(){
        return subjectid;
    }
    public int getnoofassignment(){
        return noofassignment;
    }
    public String getcourseid(){
        return courseid;
        
    }
    public String getsubjectname(){
        return subjectname;           ///////
    }
    
    public void save() throws  SQLException{
        String query="INSERT INTO subject(subjectid,noofassignment,courseid,subjectname) VALUE(?,?,?,?)";
        PreparedStatement insql=con.prepareStatement(query);
        insql.setString(1,this.getsubjectid());
        insql.setInt(2,this.getnoofassignment());
        insql.setString(3,this.getcourseid());
        insql.setString(4,this.getsubjectname()); /////
        
        insql.execute();
        
        
    }
    
    public void update() throws SQLException{
        String query="UPDATE subject SET noofassignment=?,courseid=?,subjectname=? WHERE subjectid=?";
        PreparedStatement updsql=con.prepareStatement(query);
        updsql.setInt(1,this.getnoofassignment());
        updsql.setString(2,this.getcourseid());
        updsql.setString(3,this.getsubjectname());  //////
        updsql.setString(4,this.getsubjectid());
        updsql.execute();
        
        
    }
    
    public void delete() throws SQLException{
        String query="DELETE subject FROM course1 where id=?";
        PreparedStatement delsql=con.prepareStatement(query);
        delsql.setString(1,this.getsubjectid());
        delsql.setInt(2,this.getnoofassignment());
        delsql.setString(3,this.getcourseid());
        delsql.setString(4,this.getsubjectname()); ////////
        
        delsql.execute();
        
        
    }
    public static ArrayList<subject> getsubject(String courseid) throws SQLException{
        ArrayList<subject> all=new ArrayList();
        Connection con=dbconnect.getConnection();
        String query="SELECT * FROM subject WHERE courseid=?";
        PreparedStatement abc=con.prepareStatement(query);
        
        abc.setString(1,courseid);
        
        ResultSet result=abc.executeQuery();
        int noofassignment=0;
        String subjectid=null;
        String subjectname=null;   /////
        
        while(result.next()){
            noofassignment=result.getInt("noofassignment");
            subjectid=result.getString("subjectid");
            subjectname=result.getString("subjectname");  /////
           
             System.out.println(subjectid);
          subject thissubject=new subject(subjectid,noofassignment,courseid,subjectname);
         
          all.add(thissubject);
            
        }
        return all;
        
        
    }
    
    
}
