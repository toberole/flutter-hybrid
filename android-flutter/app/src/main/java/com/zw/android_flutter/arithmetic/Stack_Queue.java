package com.zw.android_flutter.arithmetic;

import java.util.Stack;

public class Stack_Queue<E> {
    private Stack<E> in = new Stack<>();
    private Stack<E> out = new Stack<>();

    public void put(E e) {
        in.push(e);
    }

    public E take() {
        if (out.size() != 0) {
            return out.pop();
        }

        if (in.size() != 0) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }

        if (out.size() == 0) return null;

        return out.pop();
    }
} 