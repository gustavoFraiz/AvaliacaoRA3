import java.util.Scanner;

public class ListaEncadeada {
    private Node Lista;
    private Node atual;
    public ListaEncadeada(){
        Lista = null;
        atual = null;
    }
    public void inserir(int informação){
        Node no = new Node();
        no.setInformação(informação);
        if (Lista == null){
            Lista = no;
        }
        else{

            Node atual = Lista;
            while(atual.getProximo() != null){

                atual = atual.getProximo();
            }
            atual.setProximo(no);
        }

    }

    public void Adicionar(){
        Scanner scanner = new Scanner(System.in);
        ListaEncadeada lista = new ListaEncadeada();


        System.out.println("Digite os itens da lista (digite '0' para parar):");
        int item;
        while (true) {
            item = scanner.nextInt();
            if (item == 0) {
                break;
            }
            lista.inserir(item);
        }
        System.out.println("Lista Encadeada:");
        lista.imprime();
    }

    public void imprime(){

        Node atual = Lista;
        while (atual != null) {
            System.out.print(atual.getInformação()+ " -> ");
            atual= atual.getProximo();
        }
        System.out.println("Acabou");


    }

    public boolean busca_lista(int chave) {
        Node atual = Lista;
        while (atual!=null) {  // caminhando para o fim da lista
            if(atual.informação == chave) return true;
            atual = atual.proximo;
        }
        return false;
    }
}