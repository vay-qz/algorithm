package pers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**297
 * @author qiaozhe
 * @date 2022/3/30
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> resList = new ArrayList();
        pre(root, resList);
        return String.join(",", resList);
    }

    public void pre(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("null");
            return;
        }
        list.add(root.val + "");
        pre(root.left, list);
        pre(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String d) {
        String[] data = d.split(",");
        if (data.length == 0) {
            return null;
        }
        LinkedList<String> datas = new LinkedList(Arrays.asList(data));
        return build(datas);
    }

    private TreeNode build(LinkedList<String> datas) {
        if (datas.getFirst().equals("null")) {
            datas.removeFirst();
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(datas.getFirst()));
        datas.removeFirst();
        root.left = build(datas);
        root.right = build(datas);
        return root;
    }

}
