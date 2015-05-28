/*
 * OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 */

package leetCode_easy;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class CloneGraph {

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode root1){
		if(root1==null||root1.neighbors==null){
			return null;
		}
		UndirectedGraphNode root2=new UndirectedGraphNode(root1.label);
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		map.put(root1, root2);
		return cloneGraph(root1,root2,map);
	}
	
	private static UndirectedGraphNode cloneGraph(UndirectedGraphNode root1,UndirectedGraphNode root2,HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
		//use a queue
		LinkedList<UndirectedGraphNode> queue=new LinkedList<UndirectedGraphNode>();
		queue.add(root1);
		UndirectedGraphNode current;
		while(!queue.isEmpty()){
			UndirectedGraphNode temp=queue.remove();//removes the head of the list..dequeue
			current=map.get(temp);
			for(UndirectedGraphNode aNeighbor:temp.neighbors){
				if(!map.containsKey(aNeighbor)){
					map.put(aNeighbor, new UndirectedGraphNode(aNeighbor.label));
					current.neighbors.add(map.get(aNeighbor));
					queue.add(aNeighbor);
				}
				else{
					current.neighbors.add(map.get(aNeighbor));
				}
			}
		}
		return root2;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UndirectedGraphNode zero=new UndirectedGraphNode(0);
		UndirectedGraphNode one=new UndirectedGraphNode(1);
		UndirectedGraphNode two=new UndirectedGraphNode(2);
		zero.neighbors.add(one);
		zero.neighbors.add(two);
		one.neighbors.add(zero);
		one.neighbors.add(two);
		two.neighbors.add(zero);
		two.neighbors.add(one);
		two.neighbors.add(two);
		UndirectedGraphNode cloneOne=cloneGraph(zero);
		System.out.println();
		printGraph(cloneOne);
		System.out.println();
		printGraph(zero);
		
	}

	private static void printGraph(UndirectedGraphNode root) {
		Set<Integer> visit=new HashSet<Integer>();
		printGraph(root, visit);
	}

	private static void printGraph(UndirectedGraphNode root, Set<Integer> visit) {
		visit.add(root.label);
		//System.out.println("root value: "+root.label);
		System.out.println(root.label);
		for(UndirectedGraphNode neighbor:root.neighbors){
			//System.out.println("neighbor: "+neighbor.label);
			if(!visit.contains(neighbor.label)){
				printGraph(neighbor, visit);
			}
		}
	}
	
	public static void addNodes(String list){
		list=list.replaceAll("\\s+", "");
		for(int i=0; i<list.length(); i++){
			if(list.charAt(i)=='#' || list.charAt(i)==','){
				continue;
			}
		}
	}

}
