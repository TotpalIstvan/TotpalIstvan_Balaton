package hu.petrik.balaton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Balaton {
    private int[][] matrix;
    private int n;
    private int m;

    public Balaton() {
        init();
        beolvasas();
    }

    private void init(){
        try{
            BufferedReader r= new BufferedReader(new FileReader("balaton.txt"));
            String sor= r.readLine();
            this.n = 0;
            this.m = sor.split("\\t",-1).length;
            while (sor !=null){
                this.n++;
                sor= r.readLine();
            }
            this.matrix = new int[this.n][this.m];
            r.close();
        }
        catch (IOException e){
            e.getMessage();
        }
    }
    private void beolvasas(){
        try{
            BufferedReader r= new BufferedReader(new FileReader("balaton.txt"));
            String sor= r.readLine();
            int sorIndex = 0;
            while (sor !=null){
                String [] st= sor.split("\\t");
                for (int i = 0; i < st.length; i++) {
                    if(st[i].equals("")){
                        matrix[sorIndex][i]=0;
                    }
                    else {
                        matrix[sorIndex][i] = Integer.parseInt(st[i]);
                    }
                }
                sorIndex++;
                sor= r.readLine();
            }
            r.close();
        }
        catch (IOException e){
            e.getMessage();
        }
    }


    @Override
    public String toString() {
        String s= "";
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                if (this.matrix[i][j] == 0) {
                    s += " " + this.matrix[i][j] + " ";
                } else {
                    s += + this.matrix[i][j] + " ";
                }

            }
            s += "\n";
        }
        return s;
    }
}

