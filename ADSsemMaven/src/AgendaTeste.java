import java.util.List;
import java.util.Scanner;

import acessodados.AgendaTelefonica;
import entidades.Contato;


public class AgendaTeste{
    public static void main(String[]args ) throws Exception{
        AgendaTelefonica agenda = new AgendaTelefonica();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU AGENDA TELEFÔNICA =====");
            System.out.println("1. Adicionar um novo contato");
            System.out.println("2. Remover um contato existente");
            System.out.println("3. Buscar um contato pelo nome");
            System.out.println("4. Listar todos os contatos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    agenda.cadastrarContato(new Contato(nome, telefone, email));
                    break;
                case 2:
                    System.out.print("Nome do contato a remover: ");
                    String nomeRemover = sc.nextLine();
                    agenda.removerContato(nomeRemover);
                    break;
                case 3:
                    System.out.print("Nome do contato a buscar: ");
                    String nomeBuscar = sc.nextLine();
                    Contato contato = agenda.buscarContato(nomeBuscar);
                    if (contato != null) {
                        System.out.println("Nome: " + contato.getNome());
                        System.out.println("Telefone: " + contato.getTelefone());
                        System.out.println("Email: " + contato.getEmail());
                    }
                    break;
                case 4:
                    List<Contato> contatos = agenda.listarContatos();
                    for (Contato c : contatos) {
                        System.out.println("ID: " + c.getId() +
                                           ", Nome: " + c.getNome() +
                                           ", Telefone: " + c.getTelefone() +
                                           ", Email: " + c.getEmail());
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}