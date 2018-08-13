package in.rama.practise.trees;

import java.util.*;

public class TopView {
    public static String getTopView(TreeNode rootNode){
        if(Objects.isNull(rootNode)){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Set<Integer> topViewHds = new HashSet<>();

        Queue<QItem> bfsQueue = new LinkedList<>();
        bfsQueue.add(new QItem(rootNode, 0));

        while(!bfsQueue.isEmpty()){
            QItem qItem = bfsQueue.remove();
            int hd = qItem.horizontalDistance;
            TreeNode n = qItem.node;

            if(!topViewHds.contains(hd)){
                topViewHds.add(hd);
                System.out.println(n.key + " ");
                sb.append(n.key).append(" ");
            }

            if(n.left != null){
                bfsQueue.add(new QItem(n.left, hd -1));
            }

            if(n.right != null){
                bfsQueue.add(new QItem(n.right, hd+1));
            }
        }

        return sb.toString();
    }

    private static class QItem
    {
        TreeNode node;
        int horizontalDistance;
        public QItem(TreeNode n, int h)
        {
            node = n;
            horizontalDistance = h;
        }
    }
}
