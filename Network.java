import java.util.ArrayList;

public class Network {
	private Activity head, tail;
	private Activity[] activities;
		
		public  Network(String n, int d, Activity[] p) {
			tail = new Activity(n, d, null);
			tail.next = null;
			tail.previous = null;
			
		}
		
		public Network(Activity[] activities) {
			this.activities = activities;
			findHead();
			findTail();
		}
		
		public void add(Activity n) {
			Activity currentActivity = tail;
			
			while(currentActivity.previous != null) {
				currentActivity = currentActivity.previous;
			}
			
			
			n.next = currentActivity;
			currentActivity.previous = n;
			
			
			
		}
		
		public void findHead() {
			for(int x = 0; x < activities.length; x++) {
				if(activities[x].getPredecessors() == null || activities[x].getPredecessors().length < 1) {
					this.head = activities[x];
				}
			}
		}
		
		public void findTail() {
			ArrayList<Activity> temp = new ArrayList<Activity>();
			for(int x = 0; x < activities.length; x++) {
				Activity current = activities[x];
				temp.add(current);
				for(int y = 0; y < current.getPredecessors().length; y++) {
					for(int z = 0; z < activities.length; z++) {
						if(temp.get(z).getName().equals(current.getName())) {
							temp.remove(z);
							if(temp.size() == 1) {
								tail = temp.get(0);
								return;
							}
						}
						
					}
				}
			}
		}
		
	
}
