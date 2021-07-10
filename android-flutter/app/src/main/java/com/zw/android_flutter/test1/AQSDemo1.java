package com.zw.android_flutter.test1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS(AbstractQueuedSynchronizer)抽象队列同步器
 */
public class AQSDemo1 {
    public void test() {
        try {

            AtomicInteger atomicInteger = null;
            atomicInteger.addAndGet(1);
            atomicInteger.getAndIncrement();

            ReentrantLock reentrantLock = null;
            reentrantLock.lock();

            Condition condition = reentrantLock.newCondition();
            condition.await();
            condition.signal();

            CountDownLatch countDownLatch = new CountDownLatch(2);
            countDownLatch.countDown();
            countDownLatch.await();

            boolean b = Thread.interrupted();
            Thread.currentThread().isInterrupted();
            Thread.currentThread().interrupt();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 继承AbstractQueuedSynchronizer类
    private static class Syn extends AbstractQueuedSynchronizer {

        private static final long serialVersionUID = 1L;

        // 是否拥有锁
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // 获取锁
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 释放所
        protected boolean tryRelease(int releases) {
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
    }

    private final Syn syn = new Syn();

    public void lock() {
        syn.acquire(1);
    }


    public boolean tryLock() {
        return syn.tryAcquire(1);
    }

    public void unlock() {
        syn.release(1);
    }

    public boolean isLocked() {
        return syn.isHeldExclusively();
    }
}