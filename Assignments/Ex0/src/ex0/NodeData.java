
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
	 this.dist=Integer.MAX_VALUE;
	 this.info="";
  }
  
  public NodeData(int key){
	this.key=key;  
	this.Ni=new HashMap<Integer,node_data>();
	this.tag=0;
	Lis=new ArrayList<node_data>();
	this.dist=Integer.MAX_VALUE;
	this.info="";
  }
  
  @Override
  public int getKey(){
		return key;
  }
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
   @Override
 public void removeNode(node_data node) {
     if(Ni.containsKey(node.getKey()))
        Ni.remove(node.getKey());   
 }
   
   @Override
 public String getInfo() {
   return this.info;
 }
   @Override
 public void setInfo(String s) {
	   this.info=s;
 }
   @Override
   public int getTag() {
	   return this.tag;
   }
   @Override
 public void setTag(int t) {
   this.tag=t;
 }
public int getDist() {
   return this.dist;
 }
public void setDist(int t) {
	   this.dist=t;
 }


 public List<node_data> getLis() {
	return Lis;
 }
 

  public void setLis(List<node_data> lis) {
	Lis = lis;
  }
}
