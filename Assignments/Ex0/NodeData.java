
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class NodeData implements node_data {
  private static int id=0;
  private int key;
  public HashMap<Integer,node_data> Ni;
  private String info;
  private int tag;
  private int dist=Integer.MAX_VALUE;
  private List<node_data> Lis;
  
  public NodeData(){
	this.key=id++;
	 this.Ni=new HashMap<Integer,node_data>();
	 this.tag=0;
	 Lis=new ArrayList<node_data>();
	 this.info="key="+key+" tag="+tag+" Ni="+Ni+" Lis="+Lis;
  }
  
  public NodeData(int key){
	this.key=key;  
	this.Ni=new HashMap<Integer,node_data>();
	this.tag=0;
	Lis=new ArrayList<node_data>();
	this.info="key="+key+" tag="+tag+" Ni="+Ni+" Lis="+Lis;
  }
  /**
	 * Return the key (id) associated with this node.
	 * Note: each node_data have a unique key - by defining 
	 * static Integer "id" represent the current key value 
	 * which increasing by 1 in every time node created.
	 * @return
	 */
  @Override
  public int getKey(){
		return key;
  }
  /**
	 * This method returns a collection with 
	 * all the Neighbor nodes of this node_data.
	 * I saved the Nodes in HashMap so we use ".values" method to 
	 * get it in O(1) time complicity */
  @Override
  public Collection<node_data> getNi(){
	   return this.Ni.values(); 
  }
   /**
    * return true iff this<==>key are adjacent, as an edge between them.
	 * @param key
    * @return
    */
   @Override
 public boolean hasNi(int key) {
	  return(Ni.containsKey(key)); 
 }
   /** This method adds the node_data (t) to this node_data.
	 * @param node
	 * */
   @Override
 public void addNi(node_data t) {
	  if(t!=null && t.getKey()!=this.key)
	   Ni.put(t.getKey(),t);
 }
   /**
     * Removes the edge this-node,
	 * @param node
	 */
   @Override
 public void removeNode(node_data node) {
     if(Ni.containsKey(node.getKey()))
        Ni.remove(node.getKey());   
 }
   /**
	 * return the remark (meta data) associated with this node.
	 * @return
	 */
   @Override
 public String getInfo() {
   return this.info;
 }
   /**
	 * Allows changing the remark (meta data) associated with this node.
	 * @param s
	 */
   @Override
 public void setInfo(String s) {
	   this.info=s;
 }
   /**
	 * return the color of the node
	 * "white"=0- who have not yet reached
	 * "gray"=1 — put him in a queue to check on his neighbors
	 * "black"=2-already passed on it and it's neighbors
	 * @return
	 */
   @Override
   public int getTag() {
	   return this.tag;
   }
   /** 
     *Put the new value in the tag. 
	 * @param t - the new value of the tag.
	 */
   @Override
 public void setTag(int t) {
   this.tag=t;
 }
     /**
	 * return the distance of the vertex from the first vertex of the graph.
	 * @return
	 */
 public int getDist() {
   return this.dist;
 }
   /** 
    *Put the new value in the dist 
	 * @param t - the new value of the dist
	 */
 public void setDist(int t) {
	   this.dist=t;
 }
  /**
    * return a list of nodes through which it is possible to reach from one node and another node.
	* @return
    */  

 public List<node_data> getLis() {
	return Lis;
 }
 /** 
  *Put the new list in the Lis 
   * @param lis - the new value of the Lis
   */
  public void setLis(List<node_data> lis) {
	Lis = lis;
  }
}
