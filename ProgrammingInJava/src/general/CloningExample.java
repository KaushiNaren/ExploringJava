package general;

public class CloningExample {
	public static void main(String... args) {

		EmployeeC original = new EmployeeC(1, "naren1", new DepartmentC(101, "depart1"));
		try {
			EmployeeC cloned = (EmployeeC) original.clone();
			
			
			System.out.println("Before Modificaiton....");
			System.out.println("Original-->"+original);
			System.out.println("Cloned --->"+cloned);
			
			System.out.println("After Modificaiton !!!");
			
			
		} catch (CloneNotSupportedException e) {

			e.printStackTrace();
		}

	}

}

class EmployeeC implements Cloneable {

	private int id;
	private String name;
	DepartmentC department;

	public EmployeeC(int id, String name, DepartmentC department) {
		this.id = id;
		this.name = name;
		this.department = department;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartmentC getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentC department) {
		this.department = department;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {

		EmployeeC clonedEmp = (EmployeeC) super.clone();
		DepartmentC deptCloned = (DepartmentC) clonedEmp.getDepartment().clone();
		clonedEmp.setDepartment(deptCloned);
		return super.clone();

	}

}

class DepartmentC implements Cloneable {

	int deptId;

	String deptName;

	public DepartmentC(int deptId, String deptName) {
		this.deptId = deptId;
		this.deptName = deptName;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
