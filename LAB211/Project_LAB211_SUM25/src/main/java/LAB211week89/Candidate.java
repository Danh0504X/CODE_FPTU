/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week89;

/**
 *
 * @author ADMIN
 */
public class Candidate {
    protected String candidateId, firstName, lastName, address, phone, email;
    protected int birthYear;
    protected int candidateType;

    public Candidate(String candidateId, String firstName, String lastName, int birthYear, String address, String phone, String email, int candidateType) {
        this.candidateId = candidateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void display() {
        System.out.printf("%s | %d | %s | %s | %s | %d\n", getFullName(), birthYear, address, phone, email, candidateType);
    }
}
