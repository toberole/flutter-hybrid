import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class MethodChannelDemo extends StatefulWidget {
  @override
  _MethodChannelDemoState createState() => _MethodChannelDemoState();
}

class _MethodChannelDemoState extends State<MethodChannelDemo> {
  MethodChannel mc = MethodChannel("MethodChannelDemo");

  Future<dynamic> methodCallHandler(MethodCall methodCall) async {
    print(
        "flutterMethod: ${methodCall.method},methodCall.arguments:${methodCall.arguments}");
    if (methodCall.method == "native_call_flutter") {
      List args = methodCall.arguments;
      // 打印数据类型
      for (var i = 0; i < args.length; ++i) {
        print(args[i].runtimeType);
      }
    }
  }

  @override
  void initState() {
    super.initState();

    List<int> l1 = [];
    l1.add(1);
    List<String> l2 = ["hello", "world"];

    mc.setMethodCallHandler(methodCallHandler);
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "MethodChannelDemo",
      home: Scaffold(
        appBar: AppBar(
          title: Text("MethodChannelDemo"),
        ),
        body: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          mainAxisAlignment: MainAxisAlignment.start,
          mainAxisSize: MainAxisSize.max,
          children: [
            RaisedButton(
              child: Text("flutter call native"),
              onPressed: () {
                print("flutter call native ......");
                mc.invokeMethod("flutter_call_native", ["Hello", 123]);
              },
            ),
            RaisedButton(
              child: Text("native call flutter"),
              onPressed: () {
                print("native call flutter ......");
                mc.invokeMethod("native_call_flutter", null);
              },
            ),
            RaisedButton(
              child: Text("传递基本数据 1"),
              onPressed: () {
                print("传递基本数据1 ......");
                mc.invokeMethod("transfer_data1", 1);
              },
            ),
            RaisedButton(
              child: Text("传递基本数据 2"),
              onPressed: () {
                print("传递基本数据 2 ......");
                mc.invokeMethod("transfer_data2", false);
              },
            ),
            RaisedButton(
              child: Text("传递List"),
              onPressed: () {
                print("传递List ......");
                mc.invokeMethod("transfer_data_list", [1, "hello", false, 0.1]);
              },
            ),
            RaisedButton(
              child: Text("传递Map"),
              onPressed: () {
                print("传递Map ......");
                var m = {};
                m["1"] = "hello";
                m["2"] = "world";
                mc.invokeMethod("transfer_data_map", m);
              },
            ),
            RaisedButton(
              child: Text("传递数组"),
              onPressed: () {
                print("传递数组 ......");
                List<int> arr = [1, 2, 3];
                mc.invokeMethod("transfer_data_arr", arr);
              },
            )
          ],
        ),
      ),
    );
  }
}
