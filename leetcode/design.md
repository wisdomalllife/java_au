# Design

+ [Binary Search Tree Iterator](#binary-search-tree-iterator)

## Binary Search Tree Iterator

https://leetcode.com/problems/binary-search-tree-iterator/

```java
class BSTIterator {
    ArrayList<Integer> queue;
    int index;

    public BSTIterator(TreeNode root) {
        this.index = -1; //указатель на наименьший элемент
        this.queue = new ArrayList<Integer>();
        this.inorder(root); //заполняем стэк
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        this.inorder(root.left);
        this.queue.add(root.val);
        this.inorder(root.right);
    }

    public int next() {
        this.index += 1;
        return this.queue.get(this.index);
    }

    public boolean hasNext() {
        return this.index != this.queue.size() - 1;
    }
}

```