import java.lang.*;

public class hashTable {

    private ListaEncadeada[] tabela;
    private int tamanho;
    public int modo;

    public int countI;

    public hashTable(int tamanho, int modo){
        tabela = new ListaEncadeada[tamanho];
        this.tamanho = tamanho;
        this.modo = modo;
        this.countI = 0;
    }

    public int funcaoHash(int chave, int modo){
        if(modo == 1){
            return Math.abs(chave) % tamanho;
        }
        if(modo == 2){
            double aa = chave;
            return Math.abs((int)(((aa * 0.76462)%1)*tamanho));
        }
        if(modo ==3){
            double aa = chave;
            return (Math.abs((int)(((aa * 0.76462)%1)*tamanho)) + Math.abs(chave) % 101) % tamanho;
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
        }
        tabela[index].inserir(item);
    }

//    public int busca(int chave) {
//        for (int i=0; i<tamanho; i++) {
//            if (tabela[i] != null) {
//                if (tabela[i].busca_lista(chave)) {
//                    System.out.println(i);
//                    System.out.println("Numero de iteracoes: " + countI);
//                    return i;
//                }
//
//            }
//            countI = countI + 1;
//        }
//        return -1;
//    }

    public int busca(int chave){
        if(modo == 1){
            int hashIndex = Math.abs(chave) % tamanho;
            System.out.println(hashIndex);
            return(hashIndex);
        }
        if(modo == 2){
            double aa = chave;
            int hashIndex = Math.abs((int)(((aa * 0.76462)%1)*tamanho));
            System.out.println(hashIndex);
            return hashIndex;
        }
        if(modo == 3){
            double aa = chave;
            int hashIndex = (Math.abs((int)(((aa * 0.76462)%1)*tamanho)) + Math.abs(chave) % 101) % tamanho;
            System.out.println(hashIndex);
            return hashIndex;
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

    }

}
