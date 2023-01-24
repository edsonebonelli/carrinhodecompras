package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import modelo.Produto;
import utills.Utills;

public class Mercado {
	
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Produto> produtos;
	private static Map<Produto, Integer> carrinho;
	
	public static void main(String[] args) {
		produtos = new ArrayList<>();
		carrinho = new HashMap<>();
		menu();
	}
	
	private static void menu() {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("-------------------Welcome to Market-----------------------------");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("---------Selecione uma Opção que Deseja Realizar-----------------");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("|          Opção 1 - Cadastrar         |");
		System.out.println("|          Opção 2 - Listar            |");
		System.out.println("|          Opção 3 - Comprar           |");
		System.out.println("|          Opção 4 - Carrinho          |");
		System.out.println("|          Opção 5 - Sair              |");
		
		int option = input.nextInt();
		
		switch (option) {
			case 1:
				cadastrarProdutos();
				break;
				
			case 2:
				listarProdutos();
				break;
				
				
			case 3:
				comprarProdutos();
				break;
				
			case 4:
				verCarrinho();
				break;
				
			case 5:
				System.out.println("Obrigado pela Preferência!");
				System.exit(option);
			default:
				System.out.println("Opção Inválida!");
				menu();
				break;
				
		}			
	}

	private static void cadastrarProdutos() {
		System.out.println("Nome do produto: ");
		String nome = input.next();
		
		System.out.println("Preço do produto: ");
		Double price = input.nextDouble();
		
		Produto produto = new Produto(nome,  price);
		produtos.add(produto);
		
		System.out.println(produto.getName() + "Cadastrado com Sucesso");
		menu();
	}
	
	private static void listarProdutos() {
		if(produtos.size() > 0) {
			System.out.println("Lista de Produtos! \n");
			
			for (Produto p : produtos) {
				System.out.println(p);
			}
		} else {
				System.out.println("Nenhum Produto Cadastrado!");
		}
			menu();
	}
	
	private static void comprarProdutos() {
		if(produtos.size() > 0) {
			System.out.println("Código do produto: \n");
			
			System.out.println("-------------------Produtos Disponíveis-----------------------------");
			for (Produto p : produtos) {
				System.out.println(p + "\n");
			}
			int id = Integer.parseInt(input.next());
			boolean isPresent = false;
			
			for (Produto p : produtos) {
				if(p.getId() == id) {
					int qtd = 0;
					try {
						qtd = carrinho.get(p);
						//CHECA SE O PRODUTO JÁ ESTÁ NO CARRINHO, INCREMENTA QUANTIDADE.
						
					} catch (NullPointerException e) {
						//SE O PRODUTO POR O PRIMEIRO NO CARRINHO.
						carrinho.put(p, 1);
					}
					
					System.out.println(p.getName() + "Adicionado ao Carrinho");
					isPresent = true;
					
					if(isPresent) {
						System.out.println("Deseja Adicionar Outro Produto no Carrinho? ");
						System.out.println("Digite 1 para sim, ou 0 para finalizar a compra. \n");
						int option = Integer.parseInt(input.next());
						
						if (option == 1) {
							comprarProdutos();
						}else {
							finalizarCompras();
						}
						
					}
				}else {
					System.out.println("Produto não encontrado.");
					menu();
				}
			}
		}
	}
	
	private static void verCarrinho() {
		System.out.println("---Produtos no seu Carrinho---");
		if(carrinho.size() > 0){
			for (Produto p : carrinho.keySet()) {
				System.out.println("Produto: " + p + "\nQuantidade: " + carrinho.get(p));
			}
		}else {
			System.out.println("Carrinho Vazio!");
		}
		menu();
	}
	
	private static void finalizarCompras() {
		Double valorDaCompraDouble = 0.0;
		System.out.println("Seus Produtos!");
		
		for (Produto p : carrinho.keySet()) {
			int qtd = carrinho.get(p);
			valorDaCompraDouble += p.getPrice() * qtd;
			System.out.println(p);
			System.out.println("Quantidade: " + qtd);
			System.out.println("------------------");
		}
		
		System.out.println("O valor da sua compra é: " + Utills.doubletoString(valorDaCompraDouble));
		carrinho.clear();
		System.out.println("Obrigado pela Preferência!");
		menu();
	}
}
					
					
		
	
	
