package inheritance;

public class AdminMain extends Developer {
	public void manage() {
		System.out.println("Admin can manage the code");
	}

	public static void main(String[] args) {
		Guest guest = new Guest();
		guest.read();

		Developer developer = new Developer();
		developer.write();
		
		AdminMain admin = new AdminMain();
		admin.manage();
	}
}
