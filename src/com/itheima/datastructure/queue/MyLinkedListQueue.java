package com.itheima.datastructure.queue;

import java.util.Iterator;
import java.util.StringJoiner;

/**
 * 基于单向环形链表实现
 * @param <E> 队列中元素类型
 */
public class MyLinkedListQueue<E> implements Queue<E> , Iterable<E> {

    private final MyNode<E> head = new MyNode<>(null,null);
    private MyNode<E> tail = head;

    private int size = 0;

    private int cap = Integer.MAX_VALUE;

    public MyLinkedListQueue(){
        this.tail.next = head;
    }
    public MyLinkedListQueue(Integer cap){
        this.tail.next = head;
        this.cap = cap;
    }

    private static class MyNode<E> {
        E val;
        MyNode<E> next;
        public MyNode(E val,MyNode<E> next){
            this.val = val;
            this.next = next;
        }
    }

    @Override
    public boolean offer(E value) {
        if (isFull()){
            return false;
        }
        MyNode<E> addNode = new MyNode<>(value,head);
        tail.next = addNode;
        tail = addNode;
        size ++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()){
            return null;
        }
        MyNode<E> poll = head.next;
        if (poll == tail){
            tail = head;
        }
        head.next = poll.next;
        size--;
        return poll.val;
    }

    @Override
    public E peek() {
        if (isEmpty()){
            return null;
        }
       return head.next.val;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == cap;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            MyNode<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p!= head;
            }

            @Override
            public E next() {
                E e = p.val;
                p=p.next;
                return e;
            }
        };
    }


    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",");
        for (E e : this) {
            sj.add(e.toString());
        }
        return sj.toString();
    }
}
