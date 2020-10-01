package bst;

public class BST {
	
	 private  int  value;
	 private BST left;
	 private BST right;
	 
	 BST(int value){
		 this.value = value;
		 left = null;
		 right = null;
	 }
   public int getValue() {
		return value;
	}
   public void setValue(int value) {
	   this.value = value;
    }
  public BST getLeft(){
	 return  left;
 }

  public void setLeft(BST left) {
	   this.left = left;
   }
  public BST getRight(){
	 return  right;
 }
  public void setRight(BST right) {
	   this.right = right;
  }

}
