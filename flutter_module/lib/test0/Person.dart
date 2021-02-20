class Person {
  String name;
  int age;

  // "_"开头的变量为私有变量
  String _str;

  // 构造方法
  Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // 命名构造方法
  Person.named_con(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // "_" 私有方法
  void _toStr() {
    print("name: $name,age: $age");
  }

  factory Person p(){
    return Person.named_con("hello",11);
  }
}
