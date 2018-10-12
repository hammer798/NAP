public class NewGraph {
      public boolean adjMatrix[][];
      public int numVertices;
      public Activity[] list;
      public ArrayList<ArrayList<Activity>> paths = null;
      public int[] errorList = new int[2];
 
      public NewGraph(Activity[] list) {
          this.numVertices = list.length;
          adjMatrix = new boolean[numVertices][numVertices];
          this.list = list;
          constructGraph();
          Activity end = findEnd();
          Activity start = findStart();
          if(end != null && start != null) {
        	  this.paths = getPaths(end, null, -1);
          }
          
          
    }
      public void constructGraph() {
    	  for(int i = list.length-1; i>-1; i--) {
    		  Activity[] predecessor = convertPredecessors(list[i]);
    		  for(int j = 0; j < predecessor.length - 1; j++) {
    			  if(searchNode(predecessor[j]) != -1) {
    				  addEdge(i, searchNode(predecessor[j]));
    			  }
    			  
    		  }
 
    	  }
      }
      
      //find the ending node of the network
      public Activity findEnd() {
    	  Activity end = null;
		  boolean foundEnd = false;

    	  for(int x = 0; x < numVertices; x++)
    	  {
    		  boolean isEnd = true;
    		  for(int y = 0; y < numVertices; y++) {
    			  if(adjMatrix[y][x] == true)
    				  isEnd = false;
    		  }
    		  if(isEnd == true && foundEnd == false) {
    			  end = list[x];
    			  foundEnd = true;
    		  }
    		  else if(isEnd == true && foundEnd == true)
    			  errorList[0] = 1; //unconnected node error
    	  }
    	  if(end == null)
    		  errorList[1] = 1; //loop error
    	  return end;
      }
      
      public Activity findStart() {
    	  Activity start = null;
    	  boolean foundStart = false;
    	  
    	  for(int x = 0; x < numVertices; x++) {
    		  boolean isStart = true;
    		  for(int y = 0; y < numVertices; y++) {
    			  if(adjMatrix[x][y] == true)
    				  isStart = false;
    		  }
    		  if(isStart == true && foundStart == false) {
    			  start = list[x];
    			  foundStart = true;
    		  }
    		  else if(isStart == true && foundStart == true)
    			  errorList[0] = 1; //unconnected node error
    	  }
    	  if(start == null)
    		  errorList[1] = 1; //loop error
    	  return start;
      }
      
      public Activity[] convertPredecessors(Activity node) {
    	  Activity[] predecessors = new Activity[node.getPredecessors().length];
    	  for(int x = 0; x < node.getPredecessors().length; x++) {
    		  predecessors[x] = findActivity(node.getPredecessors()[x].getName());
    	  }
    	  return predecessors;   	  
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
      
      public Activity findActivity(String name) {
    	  for(int i = 0; i < list.length; i++) {
    		  if(list[i].getName().equals(name))
    			  return list[i];
    	  }
      }
 
      public void addEdge(int i, int j) {
                adjMatrix[i][j] = true;
                //adjMatrix[j][i] = true;
    }
 
      public void removeEdge(int i, int j) {
                adjMatrix[i][j] = false;
                //adjMatrix[j][i] = false;
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
    	
    	ArrayList<Activity> currentPath;
    	
    	if(currentPathIndex == -1)
    	{
    		currentPathIndex = 0;
    		currentPath = new ArrayList<Activity>();
    		currentPath.add(end);
    		paths.add(currentPath);
    	}
    	else
    		currentPath = paths.get(currentPathIndex);
    	
    	Activity[] predecessors = convertPredecessors(end);	
    	
    	//adds the current nodes predecessors to new paths if necessary, calls the function recursively
    	//yes, the big O on this is atrocious, but it should work
		for(int x = 1; x < predecessors.length; x++) {
			ArrayList<Activity> newPath = new ArrayList<Activity>(currentPath);
			newPath.add(predecessors[x]);
			paths.add(newPath);
			paths = getPaths(predecessors[x], paths, paths.size()-1);
		}
		currentPath.add(predecessors[0]);
		paths.set(currentPathIndex, currentPath);
		
		if(predecessors.length != 0 && currentPath.size() < list.length)
			paths = getPaths(predecessors[0], paths, currentPathIndex);
		else if(predecessors.length != 0 && currentPath.size() >= list.length)
			errorList[1] = 1; //loop error
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

    public void InsertionSort(ArrayList<ArrayList<Activity>> paths) {
        for(int j = 1; j < paths.size(); j++) {
            int key = calcPathDuration(paths.get(j));
            int i = j-1;
            
            while(i >= 0 && calcPathDuration(paths.get(i)) > key) {
                paths.set(i+1, paths.get(i));
                i--;
            }
            paths.set(i+1, paths.get(j));
        }
    }
    

}
