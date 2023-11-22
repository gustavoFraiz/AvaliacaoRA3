import java.lang.*;

public class hashTable {

    private ListaEncadeada[] tabela;
    private int tamanho;
    public int modo;

    public int countI;

    public int count1;
    public int count2;

    public hashTable(int tamanho, int modo){
        tabela = new ListaEncadeada[tamanho];
        this.tamanho = tamanho;
        this.modo = modo;
        this.countI = 0;
        this.count1 = 0;
        this.count2 = 0;
    }

    public int funcaoHash(int chave, int modo){
        if(modo == 1){
            int hash = chave % tamanho;
            if(hash < 0){hash *= -1;}
            return hash;
        }
        if(modo == 2){
            int hash = (int) (((chave * 0.76462) % 1) * tamanho);
            if(hash < 0){hash *= -1;}
            return hash;
        }
        if(modo ==3){
            if(chave < 0){chave *= -1;}
            int hash = (int) (((Math.sqrt(chave)) % 1) * tamanho);
            if(hash < 0){hash *= -1;}
            return hash;
        }
       return -1;
    }

    public void put(int item){

        int index = funcaoHash(item, modo);
        if(tabela[index] != null){
            if(tabela[index].busca_lista(item)){return;}

        }
        else{
            tabela[index] = new ListaEncadeada();
            count1 = count1 + 1;
        }
        tabela[index].inserir(item);
        count2 = count2 + 1;
    }

    public int busca(int chave) {
        for (int i=0; i<tamanho; i++) {
            if (tabela[i] != null) {
                if (tabela[i].busca_lista(chave)) {
                    System.out.println(i);
                    System.out.println("Numero de iteracoes: " + countI);
                    return i;
                }

            }
            countI = countI + 1;
        }
        return -1;
    }


    public void imprime() {
        for (int i=0; i<tamanho; i++) {
            System.out.print("\nHASH[" + i + "] -> ");
            if ( tabela[i]!=null )
                tabela[i].imprime();
                System.out.println("null");
        }
        System.out.println("Numero de colisoes: "+ (count2 - count1));

    }

}
