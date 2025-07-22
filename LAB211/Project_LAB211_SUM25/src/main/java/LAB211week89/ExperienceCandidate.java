/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week89;

/**
 *
 * @author ADMIN
 */
public class ExperienceCandidate extends Candidate {
    private int expInYear;
    private String proSkill;

    public ExperienceCandidate(String candidateId, String firstName, String lastName, int birthYear, String address, String phone, String email,
                               int candidateType, int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthYear, address, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Years of experience: " + expInYear + " | Pro Skill: " + proSkill);
    }
}
