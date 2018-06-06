package br.com.uniara.projeto;

import java.util.Scanner;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;

public class JGroupsCluster {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		JChannel channel = new JChannel();
		channel.setReceiver(new ReceiverAdapter() {
			public void receive(Message msg) {
				System.out.println(msg.getObject());
			}
		});

		channel.connect("chat");

		System.out.println("Digite Seu nome: ");
		String nome = scan.nextLine();
		System.out.println("Digite um texto ou sair para sair:");
		while (0 < 1) {

			String mensagem = scan.nextLine();
			if (mensagem.equals("sair")) {
				channel.close();
				System.exit(0);
			}
			channel.send(new Message(null, nome + ": " + mensagem));

			Thread.sleep(4000);
		}
	}
}