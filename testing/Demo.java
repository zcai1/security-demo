import security.qual.TopSecret;

public class Demo {
  String s;

  void foo(String p) {}
  void bar(@TopSecret String s) {
    // :: fixable-error: (argument.type.incompatible)
    foo(s);
  }
}
