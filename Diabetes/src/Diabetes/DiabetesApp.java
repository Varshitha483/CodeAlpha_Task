package Diabetes;

public class DiabetesApp {
	public static void main(String[] args) {

		DiabetesPatient patient1 = new DiabetesPatient("Anita", 55, 160.5, 32.0);
		DiabetesPatient patient2 = new DiabetesPatient("Rahul", 35, 120.0, 25.5);

		patient1.displayRisk();
		
		System.out.println();
		
		patient2.displayRisk();

	}
}