package StackStructure;

/**
 * ClassName: StackStructure Package StackStructure Description Author zwang2654
 *
 * @Create 3/11/2023 3:11 AM
 * @Version 1.0
 */
import java.util.Arrays;
import java.util.EmptyStackException;

public class StackStructure {
  private int[] data;
  private int top; // 栈顶指针

  public StackStructure(int capacity) {
    data = new int[capacity];
    top = -1;
  }

  public String toString() {
    int[] elements = Arrays.copyOfRange(data, 0, top + 1);
    return Arrays.toString(elements);
  }

  // 入栈操作
  public void push(int value) {
    if (top == data.length - 1) {
      throw new StackOverflowError(); // 栈满，抛出异常
    }
    data[++top] = value;
  }

  // 出栈操作
  public int pop() {
    if (isEmpty()) {
      throw new EmptyStackException(); // 栈空，抛出异常
    }
    return data[top--];
  }

  // 返回栈顶元素，但不删除
  public int peek() {
    if (isEmpty()) {
      throw new EmptyStackException(); // 栈空，抛出异常
    }
    return data[top];
  }

  // 判断栈是否为空
  public boolean isEmpty() {
    return top == -1;
  }

  // 获取栈中元素的个数
  public int size() {
    return top + 1;
  }
}
