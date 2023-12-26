import java.util.Scanner;

public class Project1 {
	public static void main(String[] args) {
		Personnel personnel = new Personnel();
		String sc = "";
		
		System.out.println("Welcome to my Personnel Management Program\n");
		while(!sc.equals("7"))
		{
			System.out.println("Choose one of the options:");
			System.out.println("1- Enter the information a faculty");
			System.out.println("2- Enter the information of a student");
			System.out.println("3- Print tuition invoice for a student");
			System.out.println("4- Print faculty information");
			System.out.println("5- Enter the information of a staff memeber");
			System.out.println("6- Print the information of a staff memeber");
			System.out.println("7- exit program\n");
			
			System.out.print("\tEnter your selection: ");
			sc = (new Scanner(System.in)).nextLine();
			System.out.println();
			
			if(sc.equals("1")) {
				String name, id, rank, department;
				Scanner tempSc = new Scanner(System.in);
				
				System.out.println("Enter faculty info:");
				System.out.print("\tName of The faculty: ");
				name = tempSc.nextLine();
				System.out.print("\tID: ");
				id = tempSc.nextLine();
				System.out.print("\n\tRank: ");
				rank = tempSc.nextLine();
				
				while(!rank.toLowerCase().equals("professor") && !rank.toLowerCase().equals("adjuct")) {
					System.out.printf("\t\t\"%s\" is invalid", rank);
					System.out.print("\n\tRank: ");
					rank = tempSc.nextLine();
				}
				
				System.out.print("\n\tDepartment: ");
				department = tempSc.nextLine();
				
				while(!department.toLowerCase().equals("mathematics") && !department.toLowerCase().equals("engineering") && !department.toLowerCase().equals("sciences")) {
					System.out.printf("\t\t\"%s\" is invalid", department);
					department = tempSc.nextLine();
				}
				
				personnel.addFaculty(name, id, department, rank);
			}
			
			else if(sc.equals("2")) {
				String name, id;
				double gpa; 
				int creditHr;
				Scanner tempSc = new Scanner(System.in);
				
				System.out.println("Enter faculty info:");
				System.out.print("\tName of student: ");
				name = tempSc.nextLine();
				System.out.print("\tID: ");
				id = tempSc.nextLine();
				System.out.print("\tGpa: ");
				gpa = tempSc.nextDouble();
				System.out.print("\tCredit hours: ");
				creditHr = tempSc.nextInt();
				
				personnel.addStudent(name, id, gpa, creditHr);
			}
			
			else if(sc.equals("3")) {
				String id;
				Scanner tempSc = new Scanner(System.in);
				
				System.out.print("Enter Student's ID: ");
				id = tempSc.nextLine();
				
				System.out.println();
				personnel.printInfo(id);
			}
			
			else if(sc.equals("4")) {
				String id;
				Scanner tempSc = new Scanner(System.in);
				
				System.out.print("Enter faculty's ID: ");
				id = tempSc.nextLine();
				
				System.out.println();
				personnel.printInfo(id);
			}
			
			else if(sc.equals("5")) {
				String name, id, status, department;
				Scanner tempSc = new Scanner(System.in);
				
				System.out.print("Enter faculty info:");
				System.out.print("Name of The faculty: ");
				name = tempSc.nextLine();
				System.out.print("ID: ");
				id = tempSc.nextLine();
				System.out.print("Department: ");
				department = tempSc.nextLine();
				
				while(!department.toLowerCase().equals("mathematics") && !department.toLowerCase().equals("engineering") && !department.toLowerCase().equals("sciences")) {
					System.out.printf("'%s' is invalid", department);
					department = tempSc.nextLine();
				}
				
				System.out.print("Status, enter pfor part time, or f for full time: ");
				status = tempSc.nextLine();
				
				while(!status.toLowerCase().equals("f") && !status.toLowerCase().equals("p")) {
					System.out.printf("'%s' is invalid", status);
					status = tempSc.nextLine();
				}
				
				personnel.addStaff(name, id, department, status);
			}
			
			else if(sc.equals("6")) {
				String id;
				Scanner tempSc = new Scanner(System.in);
				
				System.out.print("Enter staff's ID: ");
				id = tempSc.nextLine();
				
				System.out.println();
				personnel.printInfo(id);
			}
	
			else if(sc.equals("7"))
				break;
			
			else
				System.out.println("Invalid entry- please try again");
			
			
			System.out.println();
		}
		
		System.out.println("Goodbye!");
	}
}

//--------------------------- 
abstract class Person{
	private String name;
	private String id;
	
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public Person() {
		this.name = "Not Found";
		this.id = "Not Found";
	}
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public String getId() { return id; }
	
	public void setId(String id) { this.id = id; }
	
	public abstract void print();
}

//--------------------------- 
class Student extends Person{
	private double gpa;
	private double discount;
	private int creditHours;
	
	public Student(String name, String id, double gpa, int creditHours) {
		super(name, id);
		this.gpa = gpa;
		this.creditHours = creditHours;
		setDiscount();
	}
	
	public Student(String name, String id) {
		super(name, id);
		gpa = 0.0;
		creditHours = 0;
		discount = 0.0;
	}
	
	public double getGpa() { return gpa; }
	
	public void setGpa(double gpa) { this.gpa = gpa; }
	
	public int getCreditHours() { return creditHours; }
	
	public void setCreditHours(int creditHours) { this.creditHours = creditHours; }
	
	public double getDiscount() { return discount; }
	
	private void setDiscount() {
		if(gpa >= 3.85) 
			discount = 0.25;
		else 
			discount = 0;
	}
	
	public double getTuition() {
		return ( (creditHours*236.45) - ((creditHours*236.45) * getDiscount()) + 52);
	}
	
	public void print() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(getName() + "\t" + getId());
		System.out.println("Credit Hours: " + getCreditHours() + " ($236.45/credit hour)");
		System.out.println("Fees: $52\n");
		System.out.printf("Total payment: $%.2f" + "\t($" + getDiscount() + " discount applied)\n", getTuition());
		System.out.println("---------------------------------------------------------------------------");
	}
}


//--------------------------- 
abstract class Employee extends Person{
	private String department;
	
	public Employee(String name, String id, String department) {
		super(name, id);
		this.department = department;
	}
	
	public Employee(String name, String id) {
		super(name, id);
		this.department = "Not Found";
	}
	
	public String getDepartment() { return department; }
	
	public void setDepartment(String department) { this.department = department; }
}

//--------------------------- 
class Faculty extends Employee{
	private String rank;
	
	public Faculty(String name, String id, String department, String rank) {
		super(name, id, department);
		this.rank = rank;
	}
	
	public Faculty(String name, String id, String department) {
		super(name, id, department);
		this.rank = "Not Found";
	}
	
	public String getRank() { return rank; }
	
	public void setRank(String rank) { this.rank = rank; }
	
	public void print() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(getName() + "\t" + getId());
		System.out.println(getDepartment() + " department, " + getRank());
		System.out.println("---------------------------------------------------------------------------");
	}
}

//--------------------------- 
class Staff extends Employee{
	private String status;
	
	public Staff(String name, String id, String department, String status) {
		super(name, id, department);
		this.status = status;
	}
	
	public String getStatus() { return status; }
	
	public void setStatus(String status) { this.status = status; }
	
	public String getFullStatus() {
		if(getStatus().equals("f"))
			return "Full Time";
		else if(getStatus().equals("p"))
			return "Part Time";
		return "Invalid";
	}
	
	public void print() {
		System.out.println("---------------------------------------------------------------------------");
		System.out.println(getName() + "\t" + getId());
		System.out.println(getDepartment() + " department, " + getFullStatus());
		System.out.println("---------------------------------------------------------------------------");
	}
}

//--------------------------- 
class Personnel{
	private Person list[];
	
	public Personnel() {
		list = new Person[100];
	}
	
	public void addStudent(String name, String id, double gpa, int creditHours) {
		for(int i=0; i<100; i++) {
			if(list[i] != null && list[i].getId().equals(id)) {
				System.out.println("Invalid object (ID already in use)");
				break;
			}
			
			else if(list[i] == null) {
				list[i] = new Student(name, id, gpa, creditHours);
				System.out.println("Student added!");
				break;
			}
		}
	}
	
	public void addFaculty(String name, String id, String department, String rank) {
		for(int i=0; i<100; i++) {
			if(list[i] != null && list[i].getId().equals(id)) {
				System.out.println("Invalid object (ID already in use)");
				break;
			}
			
			else if(list[i] == null) {
				list[i] = new Faculty(name, id, department, rank);
				System.out.println("Faculty added!");
				break;
			}
		}
	}
	
	public void addStaff(String name, String id, String department, String status) {
		for(int i=0; i<100; i++) {
			if(list[i] != null && list[i].getId().equals(id)) {
				System.out.println("Invalid object (ID already in use)");
				break;
			}
			
			else if(list[i] == null) {
				list[i] = new Staff(name, id, department, status);
				System.out.println("Staff added!");
				break;
			}
		}
	}
	
	public void printInfo(String id) {
		for(int i=0; i<100;i++) {
			if(list[i] != null && list[i].getId().equals(id)) {
				list[i].print();
			}
		}
	}
}
