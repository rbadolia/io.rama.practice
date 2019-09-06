package in.rama.practise.tree;

import org.junit.Assert;
import org.junit.Test;

public class TopViewTest {
    @Test
    public void PrintTopView(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        String result = TopView.getTopView(root);
        Assert.assertEquals(result, "1 2 3 6 ");
    }

    @Test
    public void PrintTopView_WithOnlyRight(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);

        String result = TopView.getTopView(root);
        Assert.assertEquals(result, "1 2 3 6 ");
    }
}
