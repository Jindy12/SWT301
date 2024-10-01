/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamd
 */
public class Account {
    private int accountid;
    private String name;
    private String pass;
    private int isAdmin;
    private int isShop;
    

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getIsShop() {
        return isShop;
    }

    public void setIsShop(int isShop) {
        this.isShop = isShop;
    }

    public Account(int accountid, String name, String pass) {
        this.accountid = accountid;
        this.name = name;
        this.pass = pass;
    }

    public Account(int accountid, String name, String pass, int isAdmin, int isShop) {
        this.accountid = accountid;
        this.name = name;
        this.pass = pass;
        this.isAdmin = isAdmin;
        this.isShop = isShop;
    }

    public Account() {
    }
   

    
    
}
