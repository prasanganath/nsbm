/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafxapplication1.dbconnect;

/**
 *
 * @author user
 */
public class Lecregister1 {
    private int id;
    private String fullname;
    
    private String preinstitute;
    private int contactno;
    private String email;
    private String courseid;
    private Connection con=dbconnect.getConnection();  //
    
    public Lecregister1(int ID,String FullName,String PreInstitute,int ContactNo,String Email,String CourseId)
    {
        this.id=ID;
        this.fullname=FullName;
        
        this.preinstitute=PreInstitute;
        this.contactno=ContactNo;
        this.email=Email;
        this.courseid=CourseId;
        
    }
    
    public int getID(){
        return id;
    
    }
    public String getFullName(){
        return fullname;
    }
    
    public String getPreInstitute(){
        return preinstitute;
    }
    public int getContactNo(){
        return contactno;
    }
    public String getEmail(){
        return email;
    }
    public String getCourseId(){
        return courseid;
    }
    
    public void save() throws SQLException{  //
       String query="INSERT INTO lectures(lecid,fname,preinstitute,contact,email,courseid) VALUES (?,?,?,?,?,?) ";
       PreparedStatement inssql=con.prepareStatement(query);
       inssql.setInt(1,this.getID());
       inssql.setString(2,this.getFullName());
      
       inssql.setString(3,this.getPreInstitute());
       inssql.setInt(4,this.getContactNo());
       inssql.setString(5,this.getEmail());
       inssql.setString(6,this.getCourseId());
       
       inssql.execute();
       
       
        
    }
    public void update() throws SQLException{
        String query="UPDATE lectures SET fname=?,preinstitute=?,contact=?,email=?,courseid=? WHERE lecid=?";
        PreparedStatement updsql=con.prepareStatement(query);
        updsql.setString(1,this.getFullName());
        updsql.setString(2,this.getPreInstitute());
        updsql.setInt(3,this.getContactNo());
        updsql.setString(4,this.getEmail());
        updsql.setString(5,this.getCourseId());
        updsql.setInt(6,this.getID());
        updsql.execute();
        
    }
    public void delete() throws SQLException{
        String query="DELETE FROM lectures WHERE lecid=?";
         PreparedStatement delsql=con.prepareStatement(query);
         delsql.setInt(1, this.getID());
         delsql.execute();
        
        
    }
    
    
}
