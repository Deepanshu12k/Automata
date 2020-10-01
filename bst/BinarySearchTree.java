package bst;

public class BinarySearchTree {

	BST root;
	
	BinarySearchTree(){
		this.root=null;
	}
	
	public void insert(int value) {
		if(this.root==null) {
			this.root= new BST(value);
			return;
		}
	
	BST parent = null;
	BST current = this.root;
	while(current != null) {
		parent=current;
		if (current.getValue() < value) {
			current = current.getRight();
		}else if(current.getValue()>value) {
			current = current.getLeft();
		}else {
			return;
		}
	}
	if(parent.getValue()< value) {
		parent.setRight(new BST(value));
	}else {
		parent.setLeft(new BST(value));
	}
}
	
	public boolean search(int value) {
		BST current = this.root;
		while(current != null) {
			if(current.getValue()>value) {
				current = current.getLeft();
			}else if(current.getValue()<value) {
				current = current.getRight();
			}else {
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(int value) {
		if(this.root==null) {
			return false;
		}
		BST current = this.root;
		BST parent = null;
		
		while(current.getValue() != value) {
			parent = current;
			
			if(current.getValue() > value) {
				current=current.getLeft();
			}else if(current.getValue()<value) {
				current= current.getRight();
			}
			if(current==null) {
				return false;
			}
		}
		//case 1
	if( (current.getLeft()==null) && ( current.getRight() ==null ) ) {
		if(current==this.root) {
			this.root = null;
		}else if( parent.getValue() < current.getValue() ) {
			parent.setRight(null);
		}else{
			parent.setLeft(null);
		}
		return true;
	}//case 2
	if(current.getLeft()==null) {
		if(current == this.root) {
			this.root=current.getRight();
		}else if( parent.getValue() < current.getValue() ) {
			parent.setRight(current.getRight());
		}else {
			parent.setLeft(current.getRight());
		}
		return true;
	  }else if(current.getRight() == null) {
		  if(current == this.root) {
			  this.root = current.getLeft();
		  }else if(parent.getValue() < current.getValue()) {
				parent.setRight(current.getLeft());
		  }else {
			  parent.setLeft(current.getLeft());
		  }
		  return true;
	  }
	//case 3
	if( (current.getLeft()!=null) && ( current.getRight() !=null ) ) {
		BST successor = getBiggestNodeFromLeftSubtree(current);
		successor.setLeft(current.getLeft());
		successor.setRight(current.getRight());
		if(current==this.root) {
			this.root = successor;
		}else if( parent.getValue() < successor.getValue() ) {
			parent.setRight(successor);
		}else{
			parent.setLeft(successor);
		}
		return true;
	}
	return false;
}
private BST getBiggestNodeFromLeftSubtree(BST start) {
	BST parent=start.getLeft();
	BST rightChild = parent.getRight();
	
	if(rightChild==null) {
		start.setLeft(parent.getLeft());
		return parent ;
	}
	while(rightChild.getRight() != null) {
		parent = rightChild;
		rightChild =rightChild.getRight();
	}
	parent.setRight(rightChild.getLeft() );
	return rightChild;
}	
}
