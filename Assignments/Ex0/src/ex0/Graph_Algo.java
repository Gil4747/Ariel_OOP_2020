
import java.util.*;


public class Graph_Algo implements graph_algorithms {
 private Graph_DS Gds;
 public static final int NIL = -1;
 public static final int white = 0;
 public static final int gray = 1;
 public static final int black = 2;

 public Graph_Algo() {
	this.Gds=new Graph_DS();
 }
 public Graph_Algo(graph g) {
	this.Gds=(Graph_DS)g;
 }

	/**
	 * Init the graph on which this set of algorithms operates on.
	 * @param g
	 */
	@Override	
 public void init(graph g) {
	this.Gds=(Graph_DS)g;
 }
	/** 
	 * Compute a deep copy of this graph.
	 * @return
	 */
	@Override
 public graph copy() {
	Graph_DS cop=new Graph_DS();
	Iterator<node_data> x=this.Gds.getV().iterator();
	while(x.hasNext()) {
		cop.addNode(x.next());
	}
	return cop;
 }
	/**
	 * Returns true if and only if there is a valid path from EVREY node to each
	 * other node.
	 * @return
	 */
	@Override
 public boolean isConnected() {
	if(Gds.getV().size()<2)
		return true;
    boolean visited[]=new boolean[Gds.getV().size()*100];       
	LinkedList<Integer> queue=new LinkedList<Integer>(); 
    node_data temp=Gds.getV().iterator().next();
	int src=temp.getKey();
    visited[src]=true; 
    queue.add(src); 
	while (queue.size()!=0) 
	{ 
	      src=queue.poll(); 
	      Iterator<node_data> i=Gds.getNode(src).getNi().iterator(); 
	      while (i.hasNext()) 
	      { 
               int n=i.next().getKey(); 
               if (!visited[n]) 
	            { 
	                visited[n]=true; 
	                 queue.add(n); 
	            } 
	       } 
   }
    int k=0;
	 while(k<visited.length) {
	       if(!visited[k] && Gds.getMap().containsKey(k))
	      		return false;
	    	k++;
    }
      return true;      
 }
	/**
	 * returns the length of the shortest path between src to dest
	 * Note: if no such path --> returns -1
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */

	@Override
 public int shortestPathDist(int src, int dest) {
	Gds.restDist();	
    if(src==dest)
	    return 0;
    if(!Gds.getMap().containsKey(src) || !Gds.getMap().containsKey(dest))
	   return -1;
    PriorityQueue<NodeData> queue = new PriorityQueue<NodeData>(new Comparator<NodeData>() {
		 @Override
	public int compare(NodeData o1, NodeData o2) {
		return - Integer.compare(o2.getDist(),o1.getDist());
	}
	});
     NodeData temp=(NodeData)Gds.getNode(src);
     temp.setTag(black);
	 queue.add(temp);
	 temp.setDist(0);
		   
	 while(!queue.isEmpty()) {
	      temp=queue.poll();
	      if(temp.getKey()==dest) {
	    	temp.setTag(black);
	    	  break;
	      }
		  Iterator<node_data> pathFirst=temp.getNi().iterator();
		  
		  while(pathFirst.hasNext()) {
			  NodeData t=(NodeData)pathFirst.next();
				  
			  if(t.getTag()!=black && t.getDist()>temp.getDist()+1) {
				  t.setTag(gray);
				  queue.add(t);
				  t.setDist(temp.getDist()+1);
			  }
					  
		  }
		  temp.setTag(black);
	 }
	 if(Gds.getNode(dest).getTag()!=black)
		 return -1;
	 NodeData ansD= (NodeData)Gds.getNode(dest);
	 NodeData ansS= (NodeData)Gds.getNode(src);
	 int ans=ansS.getDist()+ansD.getDist();
	 if(ans<0)
		 return -1;
	  return ansS.getDist()+ansD.getDist();
		  
 }
	/**
	 * returns the the shortest path between src to dest - as an ordered List of nodes:
	 * src--> n1-->n2-->...dest
	 * Note if no such path --> returns null;
	 * @param src - start node
	 * @param dest - end (target) node
	 * @return
	 */
	@Override
  public List<node_data> shortestPath(int src, int dest) {
	 if(!Gds.getMap().containsKey(src) || !Gds.getMap().containsKey(dest))
		  return null;
	  List<node_data> L=new LinkedList<node_data>();  
	  Gds.restDist();
			
	  if(src==dest) {
		 L.add(Gds.getNode(src));
		 return L;
	  }
	  if(!Gds.getMap().containsKey(src) || !Gds.getMap().containsKey(dest))
		  return null;
	  PriorityQueue<NodeData> queue = new PriorityQueue<NodeData>(new Comparator<NodeData>() {
	  @Override
	  public int compare(NodeData o1, NodeData o2) {
		 return - Integer.compare(o2.getDist(),o1.getDist());
      }
	  });
	  NodeData temp=(NodeData)Gds.getV().iterator().next();
	  temp.setTag(black);
	  queue.add(temp);
	  temp.setDist(0);
	  while(!queue.isEmpty()) {
		  temp=queue.poll();	  
		  Iterator<node_data> pathFirst=temp.getNi().iterator();	  
		  while(pathFirst.hasNext()) {
			  NodeData t=(NodeData)pathFirst.next();	  
			  if(t.getTag()!=gray &&t.getTag()!=black && t.getDist()>temp.getDist()+1) {
				  t.setTag(gray);
				  queue.add(t);
				  t.setDist(temp.getDist()+1);
				  t.setLis(temp.getLis());
				  t.getLis().add(t);
					  
			  }		  
		  }
		  temp.setTag(black);
		   if(temp.getKey()==dest)
			  break;
	   }
	  if(Gds.getNode(dest).getTag()!=black)
			 return null;
	  NodeData ans= (NodeData)Gds.getNode(dest);
	  return ans.getLis();
		 
  }
}