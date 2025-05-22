package LAB211week2;

public class TinhBMI {
    private double weight; 
    private double height; 

    public TinhBMI(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double calculateBMI() {
    if (height <= 0) throw new IllegalArgumentException("Height must be greater than 0");
    if (weight <= 0) throw new IllegalArgumentException("Weight must be greater than 0");
    return weight / (height * height);
    }

    public String getBMIStatus() {
        double bmi = calculateBMI();
        if (bmi < 19) {
            return "Your BMI is " + bmi + ": Under-Standard";
        } else if (bmi < 25) {
            return "Your BMI is " + bmi + ": Standard";
        } else if (bmi < 30) {
            return "Your BMI is " + bmi + ": Overweight";
        } else if (bmi < 40) {
            return "Your BMI is " + bmi + ": Fat - should lose weight";
        } else {
            return "Your BMI is " + bmi + ": Very fat - should lose weight immediately";
        }
    }
}
