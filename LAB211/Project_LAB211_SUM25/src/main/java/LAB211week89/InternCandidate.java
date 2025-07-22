/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week89;

/**
 *
 * @author ADMIN
 */
public class InternCandidate extends Candidate {
    private String majors;
    private String semester;
    private String universityName;

    public InternCandidate(String candidateId, String firstName, String lastName, int birthYear, String address, String phone, String email,
                           int candidateType, String majors, String semester, String universityName) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Major: " + majors + " | Semester: " + semester + " | University: " + universityName);
    }
}
