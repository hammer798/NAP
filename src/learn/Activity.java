package learn;
public class Activity {
	
	//fields
	private String name;
	private int duration;
	private String[] predecessors;
	
	//constructor, takes string, int, and array of activities
	public Activity(String n, int d, String p) {
		this.name = n; //cannot be null
		this.duration = d; //need to error check this, can only be positive		
		this.predecessors = parsePreds(p);
	}
	
	//setters
	public void setName(String n){
		this.name = n;
	}
	
	public void setDuration(int d) {
		this.duration = d;
	}
	
	public void setPredecessors(String p) {
		this.predecessors = parsePreds(p);
	}
	
	String[] parsePreds(String p) {
            String[] preds;
            if(p.contains(","))
                preds = p.split(",");
            else{
                preds = new String[1];
                preds[0] = p.trim();
            }
            return preds; 
	}
	
	//getters
	public String getName() {
		return this.name;
	}
	
	public int getDuration() {
		return this.duration;
	}
	
	public String[] getPredecessors() {
		return this.predecessors;
	}
	
	public boolean isPredecessor(Activity second) {
		for(int i = 0; i < this.predecessors.length; i++) {
			if(this.predecessors[i] == second.getName())
				return true;
		}
		return false;
	}
}
