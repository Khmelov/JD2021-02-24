package by.it.runcov.jd01_09;

interface Patterns {

    String OPERATION = "[-+*/]";
    String SCALAR = "-?[0-9]+(\\.[0-9]+?";
    String VECTOR = "\\{"+SCALAR+"(,"+SCALAR+"}";
}