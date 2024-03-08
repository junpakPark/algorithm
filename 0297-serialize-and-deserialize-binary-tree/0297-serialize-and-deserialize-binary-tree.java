public class Codec {

 public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(root.val);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                String left = serializeNode(node.left, queue);
                String right = serializeNode(node.right, queue);

                stringBuilder.append(left)
                        .append(right);
            }

            return stringBuilder.toString();
        }

        private String serializeNode(final TreeNode node, final Queue<TreeNode> queue) {
            StringBuilder stringBuilder = new StringBuilder(",");

            if (node == null) {
                stringBuilder.append(" ");
                return stringBuilder.toString();
            }

            queue.add(node);
            stringBuilder.append(node.val);

            return stringBuilder.toString();
        }

        public TreeNode deserialize(String data) {
            if (Objects.equals(data, "")) {
                return null;
            }

            String[] nodes = data.split(",");
            TreeNode head = new TreeNode(Integer.parseInt(nodes[0]));

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(head);

            int index = 1;

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (!nodes[index].equals(" ")) {
                    node.left = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.add(node.left);
                }
                index++;

                if (!nodes[index].equals(" ")) {
                    node.right = new TreeNode(Integer.parseInt(nodes[index]));
                    queue.add(node.right);
                }
                index++;
            }

            return head;
        }
    }

