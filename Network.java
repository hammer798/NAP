
public class Network {
	Activity tail;
		
		public  Network(String n, int d, Activity[] p) {
			tail = new Activity(n, d, null);
			tail.next = null;
			tail.previous = null;
			
		}
		public void add(Activity n) {
			Activity currentActivity = tail;
			
			while(currentActivity.previous != null) {
				currentActivity = currentActivity.previous;
			}
			
			
			n.next = currentActivity;
			currentActivity.previous = n;
			
			
			
		}
	
}
