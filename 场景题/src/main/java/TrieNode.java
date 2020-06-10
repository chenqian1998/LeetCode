public class TrieNode {
    private TrieNode[] son;
    private int numPass; // 有多少路径经过这个节点
    private boolean isEnd; // 是否是结束节点
    private int numsEnd; // 有多少字符串以此作为结束的节点
    private char value; // 存储值
}
