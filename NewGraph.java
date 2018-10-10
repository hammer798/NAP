public class NewGraph {
      public boolean adjMatrix[][];
      public int numVertices;
      public Activity[] list;
 
      public NewGraph(Activity[] list) {
          this.numVertices = list.length;
          adjMatrix = new boolean[numVertices][numVertices];
          this.list = list;
          
          
    }
      public void constructGraph() {
    	  for(int i = list.length-1; i>-1; i--) {
    		  Activity[] predecessor = list[i].getPredecessors();
    		  for(int j = 0; j < predecessor.length - 1; j++) {
    			  if(searchNode(predecessor[j]) != -1) {
    				  addEdge(i, searchNode(predecessor[j]));
    			  }
    			  
    		  }
 
    	  }
      }
      
      public int searchNode(Activity p) {
    	  int index = -1;
    	  for (int i=0; i < list.length; i++) {
    		  if (p == list[i]) {
    			  index = i;
    		  }
    	  }
    	  return index;
      }
 
      public void addEdge(int i, int j) {
                adjMatrix[i][j] = true;
                adjMatrix[j][i] = true;
    }
 
      public void removeEdge(int i, int j) {
                adjMatrix[i][j] = false;
                adjMatrix[j][i] = false;
    }
 
      public boolean isEdge(int i, int j) {
                  return adjMatrix[i][j];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (boolean j : adjMatrix[i]) {
                s.append((j?1:0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    
    //starts at ending node, orignally called with paths = null, currentPathIndex = -1
    public  ArrayList<ArrayList<Activity>> getPaths(Activity end, ArrayList<ArrayList<Activity>> paths, int currentPathIndex){
    	int endIndex = searchNode(end);
    	
    	if(paths == null)
    		paths = new ArrayList<ArrayList<Activity>>();
    	
    	if(currentPathIndex == -1)
    	{
    		currentPathIndex = 0;
    		ArrayList<Activity> currentPath = new ArrayList<Activity>();
    		currentPath.add(end);
    		paths.add(currentPath);
    	}
    	else
    		currentPath = paths.get(currentPathIndex);
    	
    	Activitiy[] predecessors = end.getPredecessors();	
    	
    	//adds the current nodes predecessors to new paths if necessary, calls the function recursively
    	//yes, the big O on this is atrocious, but it should work
		for(int x = 1; x < predecessors.length; x++) {
			ArrayList<Activity> newPath = currentPath;
			newPath.add(predecessors[x]);
			paths.add(newPath);
			paths = getPaths(predecessors[x], paths, paths.size()-1);
		}
		currentPath.add(predecessors[0]);
		paths.set(currentPathIndex, currentPath);
		
		if(end.getPredecessors().length != 0)
			paths = getPaths(predecessors[0], paths, currentPathIndex);

		return paths;
    }
    
    //just adds all the durations in the path
    public int calcPathDuration(Activity[] path) {
    	int total = 0;
    	if(path != null) {
	    	for(int x = 0; x < path.length; x++) {
	    		total += path[x].getDuration();
	    	}
    	}
    	return total;
    }
    
    //assumes we're taking from the getPaths function, which builds paths from back to start
    public String printPath(Activity[] path) {
    	StringBuilder s = new StringBuilder();
    	
    	//add names of all activities in path from beginning to end
    	for(int i = path.length - 1; i > -1; i++) {
    		s.append(path[i].getName());
    		if(i != 0)
    			s.append(", ");
    		else
    			s.append ("\t");
    	}
    	
    	//tack duration of the path onto the end
    	s.append(calcPathDuration(path));
    	
    	return s.toString();
    }
    

}
