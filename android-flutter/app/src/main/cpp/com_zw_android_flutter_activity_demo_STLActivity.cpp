#include "com_zw_android_flutter_activity_demo_STLActivity.h"

#include <vector>
#include <list>

#include <map>
#include <unordered_map>
#include <string>
#include <android/log.h>
#include <deque>
//#include <shared_mutex>
#include <thread>

/*
 * Class:     com_zw_android_flutter_activity_demo_STLActivity
 * Method:    test_dequeue
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_zw_android_1flutter_activity_demo_STLActivity_test_1dequeue
        (JNIEnv *env, jclass jclazz) {
    // 获取cpu核数
    int hc = std::thread::hardware_concurrency();

    __android_log_print(ANDROID_LOG_INFO, "jni-log", "hardware_concurrency: %d", hc);

    std::deque<int> deque;
    deque.push_back(1);
    deque.push_back(2);
    deque.insert(deque.begin(), 3);

    for (auto i:deque) {
        __android_log_print(ANDROID_LOG_INFO, "jni-log", "v: %d", i);
    }
}

/*
 * Class:     com_zw_android_flutter_activity_demo_STLActivity
 * Method:    test_btn_vector_list
 * Signature: ()V
 */
JNIEXPORT void JNICALL
Java_com_zw_android_1flutter_activity_demo_STLActivity_test_1btn_1vector_1list
        (JNIEnv *env, jclass jclazz) {
    std::vector<int> v;
    v.push_back(1);
    v.insert(v.begin(), 0);
    for (auto &i:v) {
        __android_log_print(ANDROID_LOG_INFO, "jni-log", "v: %d", i);
    }

    __android_log_print(ANDROID_LOG_INFO, "jni-log", "v: %d", v[0]);

    std::list<int> list;
    list.push_back(1);
    list.insert(list.begin(), 0);
    __android_log_print(ANDROID_LOG_INFO, "jni-log", "size: %d", list.size());

    list.insert(++(list.begin()), 2);
    for (int i = 0; i < list.size(); ++i) {
        int k = list.back();
        __android_log_print(ANDROID_LOG_INFO, "jni-log", "k: %d", k);
    }
}

/**
 * map： map内部实现了一个红黑树（红黑树是非严格平衡二叉搜索树，而AVL是严格平衡二叉搜索树），红黑树具有自动排序的功能，因此map内部的所有元素都是有序的，红黑树的每一个节点都代表着map的一个元素。因此，对于map进行的查找，删除，添加等一系列的操作都相当于是对红黑树进行的操作。map中的元素是按照二叉搜索树（又名二叉查找树、二叉排序树，特点就是左子树上所有节点的键值都小于根节点的键值，右子树所有节点的键值都大于根节点的键值）存储的，使用中序遍历可将键值按照从小到大遍历出来。
 * unordered_map: unordered_map内部实现了一个哈希表（也叫散列表，通过把关键码值映射到Hash表中一个位置来访问记录，查找的时间复杂度可达到O(1)，其在海量数据处理中有着广泛应用）。因此，其元素的排列顺序是无序的。
 */
/*
 * Class:     com_zw_android_flutter_activity_demo_STLActivity
 * Method:    test_map
 * Signature: ()V
 */
JNIEXPORT void JNICALL
Java_com_zw_android_1flutter_activity_demo_STLActivity_test_1map(JNIEnv *env, jclass jclazz) {
    std::map<std::string, std::string> m1;
    m1.insert(std::make_pair<std::string, std::string>("a", "a!"));
    m1.insert(std::make_pair<std::string, std::string>("c", "a!"));
    m1.insert(std::make_pair<std::string, std::string>("b", "a!"));

    auto itr = m1.find("Hello");
    if (itr != m1.end()) {
        std::string s = itr->second;
        __android_log_print(ANDROID_LOG_INFO, "jni-log", "hello %s", s.c_str());
    }

    for (auto &item:m1) {
        __android_log_print(ANDROID_LOG_INFO, "jni-log", "first: %s,second: %s", item.first.c_str(),
                            item.second.c_str());
    }

    std::unordered_map<std::string, std::string> m2;
    m2.insert(std::make_pair<std::string, std::string>("a", "a"));
    m2.insert(std::make_pair<std::string, std::string>("b", "b"));
    m2.insert(std::make_pair<std::string, std::string>("c", "c"));

    for (auto &item:m2) {
        __android_log_print(ANDROID_LOG_INFO, "jni-log", "first: %s,second: %s", item.first.c_str(),
                            item.second.c_str());
    }
}

