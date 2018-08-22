
package javafxapplication1.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafxapplication1.dbconnect;


public class User {
    private int id;
    private String firstname;
    private String lastname;
    private int age;
    private int contactno;
    private String address;
    private String alresult;
    private String email;
    private String courseid;
    private Connection con=dbconnect.getConnection();
    
    
    
    public User(int Id,String FirstName,String LastName,int Age,int ContactNo,String Address,String AlResult,String Email,String CourseId )
    {
    
    this.id=Id;
    this.firstname=FirstName;
    this.lastname=LastName;
    this.age=Age;
    this.contactno=ContactNo;
    this.address=Address;
    this.alresult=AlResult;
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
    public int getAge(){
        return age;
    }
    public int getContactNo(){
        return contactno;
    }
    public String getAddress(){
        return address;
    }
    public String getAlResult(){
        return alresult;
    }
    public String getEmail(){
        return email;
    }
    public String getCourseId(){
        return courseid;
    }
    
    public void save() throws SQLException{                ////////////////
       String query="INSERT INTO users(stuid,fname,lname,age,contactno,address,alresult,email,courseid) VALUES(?,?,?,?,?,?,?,?,?)" ;
       PreparedStatement insql=con.prepareStatement(query);
       insql.setInt(1,this.getId());
       insql.setString(2,this.getFirstName());
       insql.setString(3,this.getLastName());
       insql.setInt(4,this.getAge());
       insql.setInt(5,this.getContactNo());
       insql.setString(6,this.getAddress());
       insql.setString(7,this.getAlResult());
       insql.setString(8,this.getEmail());
       insql.setString(9,this.getCourseId());
       insql.execute();
       
    }
    
    public void update() throws SQLException{
        String query="UPDATE users SET fname=?,lname=?,age=?,contactno=?,address=?,alresult=?,email=?,courseid=? WHERE stuid=?";
        PreparedStatement updsql=con.prepareStatement(query);
        updsql.setString(1,this.getFirstName());
        updsql.setString(2,this.getLastName());
        updsql.setInt(3,this.getAge());
        updsql.setInt(4,this.getContactNo());
        updsql.setString(5,this.getAddress());
        updsql.setString(6,this.getAlResult());
        updsql.setString(7,this.getEmail());
        updsql.setString(8,this.getCourseId());
        updsql.setInt(9,this.getId());
        updsql.execute();
        
        
    }
    
    public void delete() throws SQLException{
        String query="DELETE FROM users WHERE stuid=?";
         PreparedStatement delsql=con.prepareStatement(query);
         delsql.setInt(1, this.getId());
         delsql.execute();
        
        
    }
    
    
    
}
