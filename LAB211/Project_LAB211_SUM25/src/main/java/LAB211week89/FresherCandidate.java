/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week89;

/**
 *
 * @author ADMIN
 */
public class FresherCandidate extends Candidate {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public FresherCandidate(String candidateId, String firstName, String lastName, int birthYear, String address, String phone, String email,
                            int candidateType, String graduationDate, String graduationRank, String education) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, candidateType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Graduation: " + graduationDate + " | Rank: " + graduationRank + " | University: " + education);
    }
}
