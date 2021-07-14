import 'package:flutter/material.dart';

class Demo1Page extends StatefulWidget {
  @override
  _Demo1PageState createState() => _Demo1PageState();
}

class _Demo1PageState extends State<Demo1Page> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Demo1Page",
      home: Scaffold(
        appBar: AppBar(
          title: Text("Demo1Page"),
        ),
        body: Container(
          width: double.infinity,
          height: double.infinity,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.start,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              TextField(
                maxLines: 5,
                decoration: InputDecoration(hintText: "123"),
              ),
              Row(
                children: [
                  Expanded(
                    child: RaisedButton(
                      onPressed: () {
                        print("btn1 clicked ......");
                      },
                      child: Text("btn1"),
                    ),
                  ),
                  Expanded(
                    child: RaisedButton(
                      onPressed: () {
                        print("btn2 clicked ......");
                      },
                      child: Text("btn2"),
                    ),
                  )
                ],
                mainAxisAlignment: MainAxisAlignment.start,
              ),
              Row(
                children: [
                  Expanded(
                    child: RaisedButton(
                      onPressed: () {
                        print("btn3 clicked ......");
                      },
                      child: Text("btn3"),
                    ),
                  ),
                  Expanded(
                    child: RaisedButton(
                      onPressed: () {
                        print("btn4 clicked ......");
                      },
                      child: Text("btn4"),
                    ),
                  )
                ],
                mainAxisAlignment: MainAxisAlignment.start,
              )
            ],
          ),
        ),
      ),
    );
  }
}
