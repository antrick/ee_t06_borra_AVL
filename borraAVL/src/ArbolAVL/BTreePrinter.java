package ArbolAVL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Clase que permite imprimir gr�ficamente un �rbol.
 */
public class BTreePrinter {

  public static <T extends Comparable<T>> void printNode(NodoAVL<T> root) {
  int maxLevel = BTreePrinter.maxLevel(root);

  printNodeInternal(Collections.singletonList(root), 1, maxLevel);
  }

  private static <T extends Comparable<T>> void printNodeInternal(List<NodoAVL<T>> nodes, int level, int maxLevel) {
  if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
  return;

  int floor = maxLevel - level;
  int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
  int firstSpaces = (int) Math.pow(2, (floor)) - 1;
  int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

  BTreePrinter.printWhitespaces(firstSpaces);

  List<NodoAVL<T>> newNodes = new ArrayList<NodoAVL<T>>();
  for (NodoAVL<T> node : nodes) {
  if (node != null) {
  System.out.print(node.getDato());
  newNodes.add(node.getIzquierda());
  newNodes.add(node.getDerecha());
  } else {
  newNodes.add(null);
  newNodes.add(null);
  System.out.print(" ");
  }

  BTreePrinter.printWhitespaces(betweenSpaces);
  }
  System.out.println("");

  for (int i = 1; i <= endgeLines; i++) {
  for (int j = 0; j < nodes.size(); j++) {
  BTreePrinter.printWhitespaces(firstSpaces - i);
  if (nodes.get(j) == null) {
  BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
  continue;
  }

  if (nodes.get(j).getIzquierda() != null)
  System.out.print("/");
  else
  BTreePrinter.printWhitespaces(1);

  BTreePrinter.printWhitespaces(i + i - 1);

  if (nodes.get(j).getDerecha() != null)
  System.out.print("\\");
  else
  BTreePrinter.printWhitespaces(1);

  BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
  }

  System.out.println("");
  }

  printNodeInternal(newNodes, level + 1, maxLevel);
  }

  private static void printWhitespaces(int count) {
  for (int i = 0; i < count; i++)
  System.out.print(" ");
  }

  private static <T extends Comparable<T>> int maxLevel(NodoAVL<T> node) {
  if (node == null)
  return 0;

  return Math.max(BTreePrinter.maxLevel(node.getIzquierda()), BTreePrinter.maxLevel(node.getDerecha())) + 1;
  }

  private static <T> boolean isAllElementsNull(List<T> list) {
  for (Object object : list) {
  if (object != null)
  return false;
  }

  return true;
  }
}