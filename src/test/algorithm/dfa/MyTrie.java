package test.algorithm.dfa;

import org.apache.commons.lang3.CharUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTrie {

    private class TrieNode {
        /**
         * 是否敏感词的结尾
         */
        private boolean isEnd = false;

        /**
         * 下一层节点
         */
        Map<Character, TrieNode> subNodes = new HashMap<>();

        /**
         * 添加下一个敏感词节点
         *
         * @param c
         * @param node
         */
        public void addSubNode(Character c, TrieNode node) {
            subNodes.put(c, node);
        }

        /**
         * 获取下一个敏感词节点
         *
         * @param c
         * @return
         */
        public TrieNode getSubNode(Character c) {
            return subNodes.get(c);
        }

        public void setEnd(boolean end) {
            this.isEnd = end;
        }

        public boolean getIsEnd() {
            return this.isEnd;
        }


    }

    private static final String DEFAULT_REPLACEMENT = "***";

    /**
     * 根节点
     */
    private TrieNode rootNode;


    public MyTrie() {
        rootNode = new TrieNode();
    }

    /**
     * 识别特殊符号
     */
    private boolean isSymbol(Character c) {
        int ic = (int) c;
        // 0x2E80-0x9FFF 东亚文字范围
        return !CharUtils.isAsciiAlphanumeric(c) && (ic < 0x2E80 || ic > 0x9FFF);
    }


    /**
     * 将敏感词添加到字典树中
     * @param
     */
    public void addWord(List<String> texts) {
        texts.stream().forEach(text -> {
            if (text == null || text.trim().equals(""))
                return;

            TrieNode curNode = rootNode;
            int length = text.length();
            //遍历每个字
            for (int index = 0; index < length; ++index) {
                Character c = text.charAt(index);
                /**
                 * 过滤特殊字符
                 */
                if (isSymbol(c))
                    continue;

                TrieNode nextNode = curNode.getSubNode(c);
                // 第一次添加的节点
                if (nextNode == null) {
                    nextNode = new TrieNode();
                    curNode.addSubNode(c, nextNode);
                }
                curNode = nextNode;

                // 设置敏感词标识
                if (index == length - 1) {
                    curNode.setEnd(true);
                }
            }
        });
    }

    /**
     * 过滤敏感词
     * @param text
     * @return
     */
    public String filter(String text) {
        if (text == null || text.trim().equals(""))
            return text;

        String replacement = DEFAULT_REPLACEMENT;
        StringBuilder result = new StringBuilder();

        TrieNode curNode = rootNode;
        int begin = 0; // 回滚位置
        int position = 0;// 当前位置

        while (position < text.length()) {
            Character c = text.charAt(position);

            // 过滤空格等
            if (isSymbol(c)) {

                if (curNode == rootNode) {
                    result.append(c);
                    ++begin;
                }

                ++position;
                continue;
            }

            curNode = curNode.getSubNode(c);

            // 当前位置的匹配结束
            if (curNode == null) {
                // 以begin开始的字符串不存在敏感词
                result.append(text.charAt(begin));
                // 跳到下一个字符开始测试
                position = begin + 1;
                begin = position;
                // 回到树初始节点,重新匹配
                curNode = rootNode;

            } else if (curNode.getIsEnd()) {
                // 发现敏感词，从begin到position的位置用replacement替换掉
                result.append(replacement);
                position = position + 1;
                begin = position;
                // 回到树初始节点,重新匹配
                curNode = rootNode;
            } else {
                ++position;
            }

        }

        result.append(text.substring(begin));

        return result.toString();
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {

        MyTrie tree = new MyTrie();
        //添加敏感词
        String[] trees = {"de",
                "bca",
                "ad",
                "ef",
                "bd",
                "ff"};
        List<String> treeList = new ArrayList<>();
        String abd = "";
        for (int i = 0; i < 100000000; i++) {
            treeList.add("浩鲸云计算科技有限公司");
//            abd += "哔哩哔哩";
        }
        tree.addWord(treeList);

        //过滤敏感词
        String res = tree.filter("这是一家浩鲸云计算科技有限公司的员工");
        System.out.println(res);
    }
}
