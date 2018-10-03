
public class Activity {
	
	//fields
	private String name;
	private int duration;
	private Activity[] predecessors;
	
	//constructor, takes string, int, and array of activities
	public Activity(String n, int d, Activity[] p) {
		this.name = n; //cannot be null
		this.duration = d; //need to error check this, can only be positive		
		this.predecessors = p;
	}
	
	//setters
	public void setName(String n){
		this.name = n;
	}
	
	public void setDuration(int d) {
		this.duration = d;
	}
	
	public void setPredecessors(Activity[] p) {
		this.predecessors = p;
	}
	
	//getters
	public String getName() {
		return this.name;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public Activity[] getPredecessors() {
		return this.predecessors;
	}
}
