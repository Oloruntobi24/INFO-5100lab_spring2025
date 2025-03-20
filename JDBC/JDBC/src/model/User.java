/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Owner
 */
public class User {
    private int userID;
    private String fName;
    private String lName;
    private String gender;
    private Integer age;
    private String phoneNumber;
    private String email;
    private String college;
    private String hobby;

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
       

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    
      public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

   
    @Override
    public String toString() {
        return "User: {" + "User ID: " +userID + "First Name: " + fName + ", Last Name: " + lName + ", Gender: " + gender + ", Age: " + age + ", Phone Number: " + phoneNumber + ", Email: " + email + ", College: " + college + ", Hobby: " + hobby + " }";
    }
    
    
}
