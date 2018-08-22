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
public class instruster {
    private int insid;
    private String fname;
    private String lname;
    private String subjectid;
    private Connection con=dbconnect.getConnection();
    
    
    public instruster(int insid,String fname,String lname,String subjectid){
        this.insid=insid;
        this.fname=fname;
        this.lname=lname;
        this.subjectid=subjectid;
    }
    
    public int getinsid(){
        return insid;
    }
    public String getfname(){
       return fname; 
    }
    public String getlname(){
        return lname;
    }
    public String getsubjectid(){
        return subjectid;
    }
    
    public void save() throws SQLException{
        String query="INSERT INTO instructers(insid,fname,lname,preinstitute,subjectid)";
        PreparedStatement insql=con.prepareStatement(query);
        insql.setInt(1,this.getinsid());
        insql.setString(2,this.getfname());
        insql.setString(3,this.getlname());
        insql.setString(4,this.getsubjectid());
        insql.execute();
        
        
    }
    public void delete() throws SQLException{
        String query="DELETE "
    }
    
}
