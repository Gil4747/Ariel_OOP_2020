Athur:Gil Thioni (:

university class project of an implementation of (undirectional) unweighted graph.

in the project we implements three class.
each class represents a diffrent part of the graph structer.

(1) NodeData - my implemetiton of the interface node_data.
    the class represents the set of operations applicable on a 
    node (vertex) in an (undirectional) unweighted graph.
    
    class data:
    key - represent the node id.
    Ni - represent the node's neighbor (in the graph).
    id - a static value used to assure all node key is uniqe.
    info -  remark (meta data) associated with this node.
    Lis - Java List to be use in one of the algo.
    
     Methods:
     
    *getKey() - This method Return the key (id) associated with this node.
	   Note: each node_data have a unique key - by defining 
	   static Integer "id" represent the current key value 
	   which increasing by 1 in every time a new node created and added to the graph.
     time complicity - O(1)  (by hashmap method)
     
    *getNi() - This method returns a collection with 
	   all the Neighbor nodes of this node_data.
	   I saved the Nodes in HashMap so we use ".values" method to 
	   get it in O(1) time complicity.
     
    *hasNi(key) -  This method return true iff this key are adjacent to this.node, as an edge between them.
     by using HashMap.contains(key) method.
     time complicity - O(1) (by hashmap method)
     
    *hasNi(int key) - This method adds the node_data (t) to this node_data.
	    accurding to the Prof this method is wrongly designed and was used mainly for educational example - to be improved in next assiment.
      time complicity - O(1) (by hashmap method)
      
    *removeNode(node_data node) - This method Removes the edge between this.node to node_data node.
    time complicity - O(1) (by hashmap method)
    
    *getInfo() - this method return the remark (meta data) associated with this node.
    time complicity - O(1) (by hashmap method)
    
    *setInfo() - this method allows changing the remark (meta data) associated with this node.
    time complicity - O(1) (by hashmap method)
    
    *getTag() - geting Temporal data (aka color: e,g, white, gray, black) 
	   which can be used be algorithms.
     time complicity - O(1) (by hashmap method)
     
 (2) Graph_DS - my implemetiton of the interface graph,represents an undirectional unweighted graph.
    
        class data:
        map - java HashMap represents the graph nodes.
        edges - represents the total amount of edges in the graph .
        Mc- represents Mode Count for testing changes in the graph.
        
      Methods:
        
     *getNode(int key) - this method returns the node_data by the node_id (key).
      time complicity - O(1) (by hashmap method)
     
     *hasEdge(int node1,int node2) - the method returns true if there is an edge between node1 and node2,otherwise returns false.
      time complicity - O(1) (by hashmap method)
     
     *addNode(node_data n) - method to add a new node to the graph with the given node_data.
      time complicity -  O(N) (to update all node n nighbers edges)
     
     *connect(int node1, int node2) - Connect an edge between node1 and node2.
      time complicity - O(1) (by hashmap method)
    
     *getV()- This method return a pointer (shallow copy) for the
	      collection representing all the nodes in the graph.
        O(1) (by hashmap method)
        
     *getV(int node_id) - This method returns a collection containing all the
	    nodes connected to node_id.
      O(1) (by hashmap method)
      
     *removeNode(int key) - This method Delete the node (with the given ID) from the graph
	    and removes all edges which starts or ends at this node
      O(N) (to update all node n nighbers edges)
    
     *removeEdge(int node1, int node2) - This method Delete the edge from the graph.
     O(1) (by hashmap method)
     
     *nodeSize() - return the number of vertices (nodes) in the graph.
     O(1) (by hashmap method)
     
     *edgeSize() - return the number of edges.
     O(1) (updates during other methods runtime)
     
     *getMC() - this method return the Mode Count.
     O(1) (updates during other methods runtime)
     
 (3) Graph_Algo - this class represents the "regular" Graph Theory algorithms.
     
      class data:
      
       Gds - Graph_DS to apply this algorithms on.
       NIL,white,gray,black - enums style to represent node's status used in algorithms.
       
       Methods:
       
       *init(graph g) - Init the graph on which this set of algorithms operates on.
       O(1) (by hashmap method)
       
       *copy() - Compute a deep copy of this graph.
       O(N) (Deep copy required O(1) for every new node created and added to new graph)
       
       *isConnected() - my implemetiton of the BFS algo. this method Returns true if there is a valid path from EVREY node to each
        other node in undirectional graph.
        O(N) (get to all nodes in graph note:N=V)
        
       *shortestPathDist(int src,int dest) - my implemetiton of the dikstrka algo. returns the length of the shortest path between  node src to node dest.
        im using priority queue to get every node visit by its rank from node src to node dest. 
        note: i overrided compare function to make PQ to works like an MinHeap.
        O(N*V) (all nighbers of all nodes in the graph)
        
       
         
    
    
    
    
     
