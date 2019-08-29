package casillero_b;

import javax.swing.JOptionPane;

public class Casillero_b {

    public static void main(String[] args) {
        String casillero[] = {"c1", "c2", "c3", "c4", "c5", "c6"};
        boolean estado = true;
        String salida = " | ", cualCasillero,usados="";
        int opcion, posicion;
        double saldo = 0;
        int uso[] = new int[6];
        do {
            for (int i = 0; i < casillero.length; i++) {
                salida = salida + casillero[i] + " | ";
            }
            opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué opción desea?"
                    + "\n1-Ver casilleros"
                    + "\n2-Ocupar Casillero"
                    + "\n3-Desocupar casillero"
                    + "\n4-Ver cuenta\n5-Casillero más usados"
                    + "\n6-salir"));
            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, salida);
                    break;
                case 2:
                    cualCasillero = JOptionPane.showInputDialog("Cuál casillero desea?");
                    posicion = Integer.parseInt("" + cualCasillero.charAt(1));
                    if (casillero[posicion - 1].equals("**")) {
                        JOptionPane.showMessageDialog(null, "El casillero ya está reservado");
                    } else {
                        casillero[posicion - 1] = "**";
                        JOptionPane.showMessageDialog(null, "Casillero reservado");
                    }

                    break;
                case 3:
                    cualCasillero = JOptionPane.showInputDialog("Cuál casillero desea?");
                    posicion = Integer.parseInt("" + cualCasillero.charAt(1));
                    if (casillero[posicion - 1].equals("**")) {
                        casillero[posicion - 1] = "c" + posicion;
                        uso[posicion - 1]++;
                    } else {
                        JOptionPane.showMessageDialog(null, "El casillero ya está desocupado");

                    }
                    break;
                case 4:
                    for (int i = 0; i < uso.length; i++) {
                        saldo = saldo + (uso[i] * 1.50);
                    }
                    JOptionPane.showMessageDialog(null, "$" + saldo);

                    break;
                case 5:
                    for (int i = 0; i < uso.length; i++) {
                      usados=usados+"Casillero C"+(i+1)+"se ha utilizado :"+uso[i]+"veces \n";  
                    }
                    JOptionPane.showMessageDialog(null, usados);
                    break;
                case 6:
                    estado = false;
                    break;
            }
            salida = " | ";
            usados="";
            saldo=0;
        } while (estado);

    }

}
