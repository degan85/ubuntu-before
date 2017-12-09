package employeeSearch;

public class Employee {
	
	Employee(String empid,String name,String id, String position){
		this.empid = empid;
		this.name = name;
		this.id = id;
		this.position = position;
	}
	private String empid;
	private String name;
	private String id;
	private String position;
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
