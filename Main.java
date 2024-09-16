import java.io.*;
import java.time.LocalDate;

public class Main {

    // Arquivo declarado fora de main() para ser poder ser usado por outros métodos
    private static Arquivo<ToDo> arqTarefa;

    public static void main(String[] args) {
        LocalDate inicio1, fim1, inicio2, fim2, inicio3, fim3;
        inicio1 = LocalDate.of(2024, 1, 15); // Data de início para Tarefa 1
        fim1 = LocalDate.of(2024, 1, 20); // Data de fim para Tarefa 1
        inicio2 = LocalDate.of(2024, 2, 5); // Data de início para Tarefa 2
        fim2 = LocalDate.of(2024, 2, 10); // Data de fim para Tarefa 2
        inicio3 = LocalDate.of(2024, 3, 1); // Data de início para Tarefa 3
        fim3 = LocalDate.of(2024, 3, 5); // Data de fim para Tarefa 3

        // Tarefas de exemplo
        Tarefa t1 = new Tarefa("Revisar relatório", inicio1, fim1, (byte) 1, (byte) 3);
        Tarefa t2 = new Tarefa("Preparar apresentação", inicio2, fim2, (byte) 2, (byte) 2);
        Tarefa t3 = new Tarefa("Enviar e-mail", inicio3, fim3, (byte) 1, (byte) 1);
        int id1, id2, id3;

        try {
            File arq = new File("dados/tarefas.db");
            if (arq.exists()) {
                arq.delete();
                File hashDirectory = new File("dados/tarefas.hash_d.db");
                hashDirectory.delete();
                File hashBuckets = new File("dados/tarefas.hash_c.db");
                hashBuckets.delete();
            }

            arqTarefa = new Arquivo<Tarefa>(Tarefa.class.getConstructor(), "tarefas");

            // Insere as três tarefas
            id1 = arqTarefa.create(t1);
            t1.setId(id1);
            id2 = arqTarefa.create(t2);
            t2.setId(id2);
            id3 = arqTarefa.create(t3);
            t3.setId(id3);

            // Mostra tarefas inseridas
            System.out.println("Tarefa inserida com ID \n" + id3 + ": " + arqTarefa.read(id3));
            System.out.println("Tarefa inserida com ID \n" + id1 + ": " + arqTarefa.read(id1));

            // Altera uma tarefa e exibe o resultado
            System.out.println("Atualizando a tarefa com ID " + id2 + ":");
            Tarefa tarefaAntiga = arqTarefa.read(id2);
            System.out.println("Tarefa antiga: \n" + tarefaAntiga);
            t2.setNome("Preparar slides");
            arqTarefa.update(t2);
            System.out.println("Tarefa atualizada: \n" + arqTarefa.read(id2));

            // Altera uma tarefa para um nome diferente e exibe o resultado
            System.out.println("Atualizando a tarefa com ID " + id1 + ":");
            tarefaAntiga = arqTarefa.read(id1);
            System.out.println("Tarefa antiga: \n" + tarefaAntiga);
            t1.setNome("Revisar e corrigir relatório");
            arqTarefa.update(t1);
            System.out.println("Tarefa atualizada: \n" + arqTarefa.read(id1));

            // Excluir uma tarefa e mostra que não existe mais
            System.out.println("Excluindo a tarefa com ID " + id3 + ":");
            tarefaAntiga = arqTarefa.read(id3);
            if (arqTarefa.delete(id3)) {
                System.out.println("Tarefa excluída: \n" + tarefaAntiga);
            } else {
                System.out.println("Falha ao excluir a tarefa com ID " + id3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
