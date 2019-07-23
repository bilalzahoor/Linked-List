

public class Node{
		private Node address;
		private int data;
		private Node next;
		
		
		
		public Node(int d) {
			// TODO Auto-generated constructor stub
			address=this;
			data=d;
			next=null;
		}


		Node getAddress(){
			return address;
			
		}
		
		int getData(){
			return data;
		}
		void setNext(Node n){
			next=n;
			
		}
		Node getNext(){
			return next;
			
		}
	}
