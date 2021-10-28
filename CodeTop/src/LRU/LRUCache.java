package LRU;

import javax.jws.WebMethod;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/09/11:16
 * @Description: 三尺秋水尘不染
 */
//来串串LRU
public class LRUCache {
    /*1.初始化
        @Param HashMap<Integer,Node> map;  使用内置hashmap保存(key,node)
        @Param DoubleList cache;           自定义的双向链表
        @Param  int cap;                   链表容量
        @Method  LRUCache(int capacity)    将以上参数实例化.
    2.写方法:
        @Method   addRecently(int key,int value)  需要**同时更新**  map和cache
                @Return NULL;

        @Method   removeLeastRecently()           删除最近最久未使用的元素
                    @Return NULL;                 最近最久未使用的一定在头部
                                                  根据 key 删除

        @Method   deleteKey(int key)              同时删除
                @Return NULL;

        @Method makeRecently(int key)             将某个map中已存在 key 标记为最近使用的元素
               @Return NULL;                      先从双链表删除
                                                   再添加到链表末尾， 因为尾部是最近使用过的元素

***压轴出场***
        @Method   get()                          首先看他有没有在 map ?
            @Return                                             makeRecently && return map.get(key).value;
                                                                    : -1


        @Method   put()                           有没有重复的 ?  1.删了再加
                    @Return                                     deleteKey(key);
                                                                addRecently(key,value);
                                                                return;
                                                             :  有没有满了?
                                                             //满了的话删除最近最久未使用的元素
                                                                    removeLeastRecently();
                                                             :  都不符合的话这就是一个新的元素喽
                                                                addRecently(key, value);
*/
    HashMap<Integer,Node> map;
    DoubleList cache;
    int cap;
    public LRUCache(int capacity){
        map = new HashMap();
        cache  = new DoubleList();
        this.cap = capacity;
    }

    public void addRecently(int key,int value){
        Node node = new Node(key,value);
        //同时更新map和双向链表
        cache.addList(node);
        map.put(key,node);
    }
    public void deleteKey(int key){
        Node  node = map.get(key);
        //t同时删除
        map.remove(node);
        cache.remove(node);
    }
    //删除最近最久未使用的元素
    public void removeLeastRecently(){
        //最近最久未使用的一定在头部
        Node oldNode = cache.removeHead();
        int oldKey = oldNode.key;
        //根据key删除
        map.remove(oldKey);

    }


    // 将某个map中已存在 key 标记为最近使用的元素
    public void makeRecently(int key){
        Node node = map.get(key);
        // 先从双链表删除
        cache.remove(node);
        // 再添加到链表末尾， 因为尾部是最近使用过的元素
        cache.addList(node);
    }
//压轴出场的最简单函数
    //首先是最近使用的
    public int get(int key){
        if(map.containsKey(key)){
            //标记当前key为最近使用的,在返回其value
            makeRecently(key);
            return map.get(key).value;
        }
        else return -1;
    }
    //判断这个加入的东西是不是东西
    public void put(int key,int value){
        //如果这个map中有了这个元素
        if(map.containsKey(key)){
//            1.删了再加
            deleteKey(key);
            addRecently(key,value);
            return;
        }
        //判断空间是不是满了???
        int size = cache.getSize();

        if(size == cap){
            //满了的话删除最近最久未使用的元素
            removeLeastRecently();
        }
//        都不符合的话这就是一个新的元素喽
        addRecently(key, value);

    }


    //1.初始化参数head tail size,并且让他们互指
//    2.写尾插  删节点   删头结点 方法
   // @Method
//    (addList(Node)尾部插入/
//    (remove(Node node))有参数/
//    (removeHead)/
//    (getSize)
//
class DoubleList{

        //初始化Node  他有:
        Node head ,tail;
        int size;
        //初始化链表

        public DoubleList() {
            //伪头部和尾部
            head = new Node(0,0);
            tail = new Node(0,0);
            //是他们俩互指以用来保证链表链接

            //<-head(next)-> - <-(pre)tail>
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        //尾部插入
        public void addList(Node node){
// 添加到链表尾部，且越靠近链表尾部，越代表最近使用过
            // 如当前链表为： <head-> <-1-> <-待添加-> <-tail->，加入结点<-2->
//        第一步:两头指(node的pre和next直接赋值)   野蛮插入(node.next直接成为tail)
            node.pre = tail.pre;
            node.next = tail;
            //第二部:藕断丝连:(//此时tail.pre = 结点1    还未断开
            //     确保node连接(直接都成为node)
            tail.pre.next = node;
            tail.pre = node;
            size++;
            //更新链表长度
        }

        //删除指定节点
        //金典技巧之"我砍我自己"
        public void remove(Node node){
            //忘记pre 忘记next
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        //!!删除头部必须返回头部!!!!
        public Node removeHead(){
            //空即是色,色即是空
            if(head.next == null){
                return null;
            }
            Node first = head.next;
            //写了就调用
            remove(first);
            //重要
            return first;
        }

        //获取链表长度
        public int getSize(){
            return size;
        }

    }

    //链表节点
    class Node{
        int key,value;
        Node pre , next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }

    }
    //    1.swap的写
    public void swap(int[] num,int i,int j){
        int temp = num[j];
        num[j] = num[i];
        num[i] = temp;
    }


}
