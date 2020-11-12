
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Graph_DS implements graph {
  private HashMap<Integer,node_data> map;
  private static int ModeCount=0;
  private static int edg=0;
  
  public Graph_DS() {
    this.map=new HashMap<Integer,node_data>(); 
     ModeCount=0;
     edg=0;
  }
  
  public Graph_DS(Graph_DS other) {
	  this.map=other.map;
	  }
  
  public Graph_DS(HashMap<Integer,node_data> map) {
	  this.map=map;
	  ModeCount=0;
      edg=0;
  }
  /**
	 * return the node_data by the id of the node.
	 * @param key - the node_id
	 * @return the node_data by the id of the node, null if none.
	 */

  @Override	
  public node_data getNode(int key) {
	  if(!map.containsKey(key))
		return null;
	  return map.get(key);	
  }
  /**
	 * return true iff (if and only if) there is an edge between node1 and node2.
	 * @param node1
	 * @param node2
	 * @return
	 */
  @Override
  public boolean hasEdge(int node1, int node2) {
	  if(map.get(node1).getNi().contains(map.get(node2)) && map.get(node2).getNi().contains(map.get(node1)))
			  return true;
	  return false;
  }
  /**
	 * add a new node to the graph with the given node_data.
	 * @param n
	 */
  @Override
  public void addNode(node_data n) {
	  if(map.containsKey(n.getKey())) {
		  Iterator<node_data> y=n.getNi().iterator();
		  while(y.hasNext()) {
			  y.next().removeNode(n);
			  edg--;
			  ModeCount++;
		  } 
	  }
	  map.put(n.getKey(),n);
	  ModeCount++;
	  Iterator<node_data> x=n.getNi().iterator();
	  while(x.hasNext()) {
		  x.next().addNi(n);
		  edg++;
	  }
  }
  /**
   * Connect an edge between node1 and node2.
   * Note: if the edge node1-node2 already exists - the method simply does nothing.
   */
  @Override
  public void connect(int node1, int node2) {
	  if(map.containsKey(node1)&& map.containsKey(node2)) {
	 if(!(map.get(node1).getNi().contains((map.get(node2)))) && node1!=node2){
		  map.get(node1).addNi(map.get(node2));
		  map.get(node2).addNi(map.get(node1));
		  ModeCount++;
		  edg++;
	 }
	 }
  }
  /**
	 * This method return a pointer (shallow copy) for the
	 * collection representing all the nodes in the graph. 
	 * @return Collection<node_data>
	 */
  @Override
  public Collection<node_data> getV(){
      Collection<node_data> ans;
	  ans=map.values();
	  return ans;
	  
  }
  /**
	 * This method returns a collection containing all the
	 * nodes connected to node_id
	 * @return Collection<node_data>
	 */
  @Override
  public Collection<node_data> getV(int node_id){
	  if(map.isEmpty())
		  return null;
	  return map.get(node_id).getNi();
  }
  /**
	 * Delete the node (with the given ID) from the graph -
	 * and removes all edges which starts or ends at this node.
	 * This method should run in O(n), |V|=n, as all the edges should be removed.
	 * @return the data of the removed node (null if none). 
	 * @param key
	 */
  @Override
  public node_data removeNode(int key) {
	  if(map.containsKey(key)) {
	  node_data temp=map.get(key);
	  int c=map.get(key).getNi().size();
	  edg=edg-(c);
	  Iterator<node_data> x=map.get(key).getNi().iterator();
	  while(x.hasNext()) {
			  x.next().getNi().remove(map.get(key));
	  }
	  map.remove(key);
	  ModeCount++;
	  return temp;
	  }
	  else
		  return null;
  }
  /**
	 * Delete the edge from the graph, 
	 * @param node1
	 * @param node2
	 */
  @Override
  public void removeEdge(int node1, int node2) {
	  if(map.get(node1).getNi().contains(map.get(node2))) {
		  map.get(node1).removeNode(map.get(node2));
		  map.get(node2).removeNode(map.get(node1));
		  ModeCount++;
		  edg--;
	  }  
  }
  /** return the number of vertices (nodes) in the graph.
	 * @return
	 */
  @Override
  public int nodeSize() {
	  return map.size();
  }
  /** 
	 * return the number of edges (undirectional graph).
	 * @return
	 */
  @Override
  public int edgeSize() {
	  return edg;   
  }
  /**
   * return the Mode Count - for testing changes in the graph.
   * Any change in the inner state of the graph should cause an increment in the ModeCount
   * @return
   */
  @Override
  public int getMC() {
	  return  ModeCount;
  }
  /**
   * return the HashMap of the graph
   * @return
   */
  public HashMap<Integer,node_data> getMap(){
	  return this.map;
  }
  /**
	 * Goes over all the nodes in the graph and puts in their dist a maximum number and in their tag 0
	 */
public void restDist() {
	// TODO Auto-generated method stub
	Iterator<node_data> it=map.values().iterator();
	while(it.hasNext()) {
		NodeData n=(NodeData)it.next();
		n.setDist(Integer.MAX_VALUE);
		n.setTag(0);
	}
}
}
