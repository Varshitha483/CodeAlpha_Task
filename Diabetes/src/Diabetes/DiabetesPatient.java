package Diabetes;

public class DiabetesPatient {
	private String name;
	private int age;
	private double glucoseLevel;
	private double bmi;

	public DiabetesPatient(String name, int age, double glucoseLevel, double bmi) {
		this.name = name;
		this.age = age;
		this.glucoseLevel = glucoseLevel;
		this.bmi = bmi;
	}

	public boolean isAtRisk() {
		return glucoseLevel > 140 || bmi > 30 || age > 50;
	}

	public void displayRisk() {
		System.out.println("Patient: " + name);
		System.out.println("Age: " + age + ", Glucose Level: " + glucoseLevel + ", BMI: " + bmi);
		if (isAtRisk()) {
			System.out.println("⚠️ Risk of diabetes: HIGH");
		} else {
			System.out.println("✅ Risk of diabetes: LOW");
		}
	}
}










