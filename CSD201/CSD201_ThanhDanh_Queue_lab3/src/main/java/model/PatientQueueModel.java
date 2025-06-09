/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
import java.util.LinkedList;
import java.util.Queue;

public class PatientQueueModel {
    private Queue<Patient> queue = new LinkedList<>();

    public void registerPatient(Patient p) {
        queue.add(p);
    }

    public Patient processPatient() {
        return queue.poll(); 
    }

    public Queue<Patient> getAllPatients() {
        return queue;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
