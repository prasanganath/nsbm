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
public class Mstregister1 {
    private int id;
    private String firstname;
    private String lastname;
    private String previouscourse;   
    private int age;
    private int contactno;
    private String email;
    private String courseid;
    private Connection con=dbconnect.getConnection();    //
    
    public Mstregister1(int Id,String FirstName,String LastName,String PreviousCourse,int Age,int ContactNo,String Email,String CourseId)
    {
        this.id=Id;
        this.firstname=FirstName;
        this.lastname=LastName;
        this.previouscourse=PreviousCourse;
        this.age=Age;
        this.contactno=ContactNo;
        this.email=Email;
        this.courseid=CourseId;
    }  
    
    public int getId(){
        return id;
    }
    public String getFirstName(){
        return firstname;
    }
    public String getLastName(){
        return lastname;
    }
    public String getPreviousCourse(){
        return previouscourse;
    }
    public int getAge(){
        return age;
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
    
    public void save() throws SQLException{
        String query="INSERT INTO master(masid,fname,lname,previouscourse,age,contactno,email,courseid)VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement insql=con.prepareStatement(query);
        insql.setInt(1,this.getId());
        insql.setString(2,this.getFirstName());
        insql.setString(3,this.getLastName());
        insql.setString(4,this.getPreviousCourse());
        insql.setInt(5,this.getAge());
        insql.setInt(6,this.getContactNo());
        insql.setString(7,this.getEmail());
        insql.setString(8,this.getCourseId());
        
        insql.execute();
        
        
    } 
    
    public void delete() throws SQLException{
        String query="DELETE FROM master WHERE masid=?";
        PreparedStatement delsql=con.prepareStatement(query);
        delsql.setInt(1,this.getId());
        delsql.execute();
    }
    
    public void update() throws SQLException{
        String query="UPDATE master SET fname=?,lname=?,previouscourse=?,age=?,contact=?,email=?,courseid=? WHERE masid=?";
        PreparedStatement updsql=con.prepareStatement(query);
        updsql.setString(1,this.getFirstName());
        updsql.setString(2,this.getLastName());
        updsql.setString(3,this.getPreviousCourse());
        updsql.setInt(4,this.getAge());
        updsql.setInt(5,this.getContactNo());
        updsql.setString(6,this.getEmail());
        updsql.setString(7,this.getCourseId());
        updsql.setInt(8,this.getId());
        
        updsql.execute();
        
    }
    
    
    
}
