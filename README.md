# Personnel-Management

This Java program, named PersonnelManagement, allows users to manage information about faculty, students, and staff in an educational institution. It uses the `Personnel`, `Person`, `Student`, `Employee`, `Faculty`, and `Staff` classes to represent different roles within the institution. The program provides options to enter information for faculty, students, and staff, print tuition invoices, and print information for faculty and staff members.

## How it Works

### Person Class

The `Person` class is an abstract class that serves as the base class for `Student`, `Employee`, `Faculty`, and `Staff`. It includes common properties such as name and ID and provides an abstract method `print()`.

### Student Class

The `Student` class extends the `Person` class and represents a student in the educational institution. It includes information such as GPA, credit hours, discount, and provides methods to calculate tuition and print a tuition invoice.

### Employee Class

The `Employee` class is an abstract class that extends the `Person` class and serves as the base class for `Faculty` and `Staff`. It includes a property for the department.

### Faculty Class

The `Faculty` class extends the `Employee` class and represents a faculty member in the institution. It includes information such as rank and provides a method to print faculty information.

### Staff Class

The `Staff` class extends the `Employee` class and represents a staff member in the institution. It includes information such as status (full-time or part-time) and provides a method to print staff information.

### Personnel Class

The `Personnel` class is responsible for managing a list of people, including students, faculty, and staff. It includes methods to add students, faculty, and staff to the list and to print information for a person based on their ID.

### Main Class

The `Main` class serves as the main program. It provides an interactive interface for users to choose options such as entering information for faculty, students, and staff, printing tuition invoices, and printing information for faculty and staff members.

## Classes and Methods

### Person Class

- `public String getName()`: Gets the name of the person.
- `public void setName(String name)`: Sets the name of the person.
- `public String getId()`: Gets the ID of the person.
- `public void setId(String id)`: Sets the ID of the person.
- `public abstract void print()`: Abstract method to print information about the person.

### Student Class

- `public double getGpa()`: Gets the GPA of the student.
- `public void setGpa(double gpa)`: Sets the GPA of the student.
- `public int getCreditHours()`: Gets the credit hours of the student.
- `public void setCreditHours(int creditHours)`: Sets the credit hours of the student.
- `public double getDiscount()`: Gets the discount percentage for the student.
- `public double getTuition()`: Calculates the tuition for the student.
- `public void print()`: Prints a tuition invoice for the student.

### Employee Class

- `public String getDepartment()`: Gets the department of the employee.
- `public void setDepartment(String department)`: Sets the department of the employee.

### Faculty Class

- `public String getRank()`: Gets the rank of the faculty member.
- `public void setRank(String rank)`: Sets the rank of the faculty member.
- `public void print()`: Prints information about the faculty member.

### Staff Class

- `public String getStatus()`: Gets the status (full-time or part-time) of the staff member.
- `public void setStatus(String status)`: Sets the status of the staff member.
- `public String getFullStatus()`: Gets the full status of the staff member (full-time or part-time).
- `public void print()`: Prints information about the staff member.

### Personnel Class

- `public void addStudent(String name, String id, double gpa, int creditHours)`: Adds a new student to the list.
- `public void addFaculty(String name, String id, String department, String rank)`: Adds a new faculty member to the list.
- `public void addStaff(String name, String id, String department, String status)`: Adds a new staff member to the list.
- `public void printInfo(String id)`: Prints information for a person based on their ID.

### Main Class

- `public static void main(String[] args)`: The main method to run the program. It provides an interactive interface for users to manage personnel information.

## Usage

1. **Compile the Program:**
   - Open a terminal and navigate to the directory containing the program files.
   - Compile the program using the following command:
     ```bash
     javac Project1.java
     ```

2. **Run the Program:**
   - After compilation, run the program with the following command:
     ```bash
     java Project1
     ```

3. **Interactive Input:**
   - Follow the on-screen prompts to manage personnel information.
   - Choose options such as entering faculty or student information, printing tuition invoices, or printing faculty and staff information.

4. **View Output:**
   - The program will provide information based on the chosen options.

## Example

```bash
javac Project1.java
java Project1
