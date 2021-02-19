import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:flutter_module/test1/Demo1Page.dart';
import 'package:flutter_module/test1/MethodChannelDemo.dart';

void main() {
  String initParams = window.defaultRouteName;
  print("main defaultRouteName initParams:$initParams");

  if (initParams == "Demo1Page") {
    return runApp(Demo1Page());
  } else if (initParams == "MethodChannelDemo") {
    return runApp(MethodChannelDemo());
  }

  runApp(Demo1Page());
}
