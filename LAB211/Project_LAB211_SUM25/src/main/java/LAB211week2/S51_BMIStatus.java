/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week2;

/**
 *
 * @author ADMIN
 */
public enum S51_BMIStatus {
    UNDER_STANDARD("Under-standard"),
    STANDARD("Standard"),
    OVERWEIGHT("Overweight"),
    FAT("Fat – should lose weight"),
    VERY_FAT("Very fat – should lose weight immediately");

    private final String label;

    S51_BMIStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
