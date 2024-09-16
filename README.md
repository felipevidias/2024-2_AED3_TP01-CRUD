# 2024-2_AED3_TP01-CRUD

# Relatório de Desenvolvimento do TP
## Ana Cristina - Felipe Vilhena - Kenia Teixeira - Lucas Gabriel

## Descrição das Classes e Métodos

### Classe `Tarefa`

A classe `Tarefa` representa as tarefas que serão manipuladas no sistema. Cada tarefa tem atributos como nome, data de início, data de fim, status e prioridade.

#### Atributos:
- **`int id`**: Identificador único da tarefa.
- **`String nome`**: Nome da tarefa.
- **`LocalDate inicio`**: Data de início da tarefa.
- **`LocalDate fim`**: Data de fim da tarefa.
- **`Byte status`**: Status da tarefa (por exemplo, 1 para ativo, 0 para inativo).
- **`Byte prioridade`**: Prioridade da tarefa.

#### Métodos:
- **`void setId(int id)`**: Define o ID da tarefa.
- **`void setNome(String nome)`**: Define o nome da tarefa.
- **`void setInicio(LocalDate inicio)`**: Define a data de início da tarefa.
- **`void setFim(LocalDate fim)`**: Define a data de fim da tarefa.
- **`void setStatus(Byte status)`**: Define o status da tarefa.
- **`void setPrioridade(Byte prioridade)`**: Define a prioridade da tarefa.
- **`int getId()`**: Retorna o ID da tarefa.
- **`String getNome()`**: Retorna o nome da tarefa.
- **`LocalDate getInicio()`**: Retorna a data de início da tarefa.
- **`LocalDate getFim()`**: Retorna a data de fim da tarefa.
- **`Byte getStatus()`**: Retorna o status da tarefa.
- **`Byte getPrioridade()`**: Retorna a prioridade da tarefa.
- **`byte[] toByteArray()`**: Converte a tarefa para um array de bytes para fins de armazenamento.
- **`void fromByteArray(byte[] array)`**: Converte um array de bytes em um objeto `Tarefa`.

---

### Interface `RegHashExtensivel<T>`

A interface `RegHashExtensivel<T>` define os métodos que os objetos a serem incluídos na tabela hash extensível devem implementar.

#### Métodos:
- **`int hashCode()`**: Retorna a chave numérica que será usada no diretório hash.
- **`short size()`**: Retorna o tamanho fixo do registro.
- **`byte[] toByteArray()`**: Converte o objeto em um vetor de bytes para armazenamento.
- **`void fromByteArray(byte[] ba)`**: Constrói o objeto a partir de um vetor de bytes.

---

### Interface `Registro`

A interface `Registro` define métodos básicos que todos os registros devem implementar.

#### Métodos:
- **`void setId(int id)`**: Define o ID do registro.
- **`int getId()`**: Retorna o ID do registro.
- **`byte[] toByteArray()`**: Converte o registro para um array de bytes.
- **`void fromByteArray(byte[] array)`**: Reconstrói o registro a partir de um array de bytes.

---

### Classe `Arquivo<T>`

A classe `Arquivo<T>` é responsável por gerenciar a persistência de objetos do tipo `T`, que devem implementar a interface `Registro`. Ela utiliza um arquivo de dados e um índice hash extensível para armazenar e recuperar objetos de forma eficiente.

#### Atributos:
- **`Constructor<T> construtor`**: Construtor usado para criar instâncias do tipo `T`.
- **`File diretorio`**: Diretório onde o arquivo de dados é armazenado.
- **`String fileName`**: Nome do arquivo de dados.
- **`final int fimCabecalho`**: Posição final do cabeçalho no arquivo (4 bytes).
- **`HashExtensivel<IDEndereco> indiceDireto`**: Índice direto utilizando uma tabela hash extensível.

#### Métodos:
- **`public Arquivo(Constructor<T> construtor, String fN)`**: Inicializa o arquivo de dados e o índice hash extensível.
- **`public int create(T objeto)`**: Cria um novo registro no arquivo de dados.
- **`public T read(int id)`**: Lê um registro do arquivo com base no ID.
- **`public boolean delete(int id)`**: Marca um registro como excluído.
- **`public boolean update(T novoObjeto)`**: Atualiza um registro existente.
- **`public List<T> listAll()`**: Lista todos os registros ativos no arquivo.

---

### Classe `Main`

A classe `Main` contém o método principal que inicializa o sistema de CRUD de tarefas e testa as funcionalidades de criação, leitura, atualização e exclusão.

#### Atributos:
- **`private static Arquivo<ToDo> arqTarefa`**: Arquivo de tarefas utilizado no sistema.

#### Métodos:
- **`public static void main(String[] args)`**: Método principal que executa o CRUD de tarefas.
  
#### Passos no `main`:
1. Inicializa datas de exemplo e cria tarefas.
2. Exclui arquivos antigos se existirem para criar um novo.
3. Insere as tarefas no arquivo e armazena os IDs.
4. Exibe as tarefas inseridas.
5. Atualiza algumas tarefas e mostra o resultado.
6. Exclui uma tarefa e confirma a exclusão.

---

### Experiência de Desenvolvimento

#### Implementação dos Requisitos:
Todos os requisitos foram implementados com sucesso. O índice direto é gerenciado usando uma tabela hash extensível, e todas as operações básicas (inclusão, leitura, atualização e exclusão) foram implementadas conforme solicitado.

#### Operação Mais Difícil:
A operação de atualização foi a mais desafiadora, já que lidar com registros de tamanhos diferentes e gerenciar o espaço em disco corretamente apresentou complexidade adicional.

#### Desafios Enfrentados:
- **Gerenciamento do Espaço**: A atualização de registros grandes que não cabem no espaço original foi um desafio, exigindo a marcação de registros antigos como excluídos e a criação de novos registros no final do arquivo, se necessário.
- **Manutenção da Integridade dos Dados**: Garantir a consistência do índice após operações de inserção, exclusão e atualização foi crucial.

---

### Resultados

- O sistema de gerenciamento de registros funciona conforme o esperado.
- O índice hash extensível proporciona acesso eficiente e todas as operações básicas funcionam corretamente.
- O trabalho é original e completo.

---

## Respostas para Questões
- O trabalho possui um índice direto implementado com a tabela hash extensível? **Sim**
- A operação de inclusão insere um novo registro no fim do arquivo e no índice e retorna o ID desse registro? **Sim**
- A operação de busca retorna os dados do registro, após localizá-lo por meio do índice direto? **Sim**
- A operação de alteração altera os dados do registro e trata corretamente as reduções e aumentos no espaço do registro? **Sim**
- A operação de exclusão marca o registro como excluído e o remove do índice direto? **Sim**
- O trabalho está funcionando corretamente? **Sim**
- O trabalho está completo? **Sim**
- O trabalho é original e não a cópia de um trabalho de outro grupo? **Sim, é original.**
