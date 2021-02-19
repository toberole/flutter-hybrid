import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:flutter_module/test1/Demo1Page.dart';
import 'package:flutter_module/test1/MyApp.dart';

void main() {
  String initParams = window.defaultRouteName;
  print("main defaultRouteName initParams:$initParams");
  if (initParams == "Demo1Page") {
    return runApp(Demo1Page());
  }
  runApp(Demo1Page());
}
