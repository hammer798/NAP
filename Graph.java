import java.util.*;

public class Graph {
	 int size; 
	 
     LinkedList<Activity> adjListArray[]; 
     Activity arr[];
       
     // constructor  
     Graph(Activity y[]) 
     { 
    	 this.arr = y;
    	 this.size = arr.length; 
        
           
         // define the size of array as  
         // number of vertices 
         adjListArray = new LinkedList[size]; 
           
         // Create a new list for each vertex 
         // such that adjacent nodes can be stored 
         for(int i = 0; i < size ; i++){ 
             adjListArray[i] = new LinkedList<>();	//generate linked lists at each array index
             adjListArray[i].add(arr[i]);			//initialize first linked list element in array to each node.
         } 
         constructGraph(adjListArray, arr);
         printGraph();
     } 
	
     public void constructGraph(LinkedList<Activity> adjListArray[], Activity arr[]) {
    	
    	for(int i = 0; i < size; i++) {
    		String temp[] = adjListArray[i].getFirst().getPredecessors();		//copy predecessors into temp string array used for comparison
    		
    		for(int j = 0; j < temp.length; j++) {
    			addActivity(getActivity(temp[j]), adjListArray[i].getFirst());
    		}
    	}
    	 
    	 
     }
     
     public void addActivity(Activity temp, Activity add) {
    	 if(temp != null) {
    		 for(int i =0; i < size; i++) {
        		 if(adjListArray[i].getFirst().getName() == temp.getName()) {
        			 adjListArray[i].add(add);
        			 break;
        		 }
        	 }
    	 }
    	 
    	
     }
     
     
     public Activity getActivity(String name) {		//Searches for activity based on string name. Return activity which is used for generating graph
    	 Activity temp = null; 
    	 for (int i = 0; i < size; i ++) {
    		 if(arr[i].getName() == name) {
    			 temp = arr[i];
    			 return temp;
    		 }
    	 }
    	 
    	 return temp;
     }
     
     
     
     public void printPaths(int first, int last)  
     { 
         boolean[] isVisited = new boolean[size]; 
         ArrayList<Activity> pathList = new ArrayList(); 
           
         //add source to path[] 
         pathList.add(adjListArray[first].getFirst()); 
           
         //Call recursive utility 
         printAllPathsUtil(first, last, isVisited, pathList); 
     } 
     private void printAllPathsUtil(int first, int last, boolean[] isVisited, List<Activity> localPathList) { 

		// Mark the current node 
		isVisited[first] = true; 
		
		if (first == last)  { 
			System.out.println(localPathList); 
		} 
		
		// Recur for all the vertices 
		// adjacent to current vertex 
		for (int i=1; i < adjListArray[first].size(); i++)  { 
			if (!isVisited[searchIndex(adjListArray[first].get(i))]){ 
			// store current node  
			// in path[] 
			localPathList.add(adjListArray[first].get(i)); 
			printAllPathsUtil(searchIndex(adjListArray[first].get(i)), last, isVisited, localPathList); 
			
			// remove current node 
			// in path[] 
			localPathList.remove(i); 
			} 
		} 
		
			// Mark the current node 
			isVisited[first] = false; 
		}
     
     
     public int searchIndex(Activity a) {
    	 for(int i = 0; i < size; i++) {
    		 if(adjListArray[i].getFirst().getName() == a.getName()) {
    			 return i;
    		 }
    	 }
    	 return -1;
     }
     
     
     
     public void printGraph() {
    	 
    	 for(int i=0; i<size; i++) {
    		 System.out.println("Adjacency list of vertex:\t" + adjListArray[i].getFirst().getName());
    		 for(int j = 0; j < adjListArray[i].size(); j++) {
    			 System.out.println(adjListArray[i].get(j).getName());
    		 }
    		 System.out.println();
    	 }
     }
	
}
