import java.lang.*;

public class hashTable {

    private ListaEncadeada[] tabela;
    private int tamanho;
    public int modo;

    public hashTable(int tamanho, int modo){
        tabela = new ListaEncadeada[tamanho];
        this.tamanho = tamanho;
        this.modo = modo;
    }

    public int funcaoHash(int chave, int modo){
        if(modo == 1){
            return Math.abs(chave) % tamanho;
        }
        return Math.abs(chave) % tamanho;
    }

    public void put(int item){

        int index = funcaoHash(item, modo);
        if(tabela[index] != null){
            if(tabela[index].busca_lista(item)){return;}

        }
        else{
            tabela[index] = new ListaEncadeada();
        }
        tabela[index].inserir(item);
    }

    public int busca(int chave) {
        for (int i=0; i<tamanho; i++)
            if ( tabela[i]!=null )
                if ( tabela[i].busca_lista(chave) ) return i;
        return -1;
    }

    public void imprime() {
        for (int i=0; i<tamanho; i++) {
            System.out.print("\nHASH[" + i + "] -> ");
            if ( tabela[i]!=null )
                tabela[i].imprime();
                System.out.println("null");
        }
    }

}
