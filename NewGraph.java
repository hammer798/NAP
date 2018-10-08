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
    				  addEdge(i, j);
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


}
