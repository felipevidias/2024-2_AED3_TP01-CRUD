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

### Classe `Arquivo<T>`

A classe `Arquivo<T>` é responsável por gerenciar a persistência de objetos do tipo `T`, que deve implementar a interface `Registro`. Utiliza um arquivo de dados e um índice hash extensível para armazenar e recuperar objetos de forma eficiente.

#### Atributos:
- **`T objeto`**: Referência ao objeto genérico que será manipulado.
- **`Constructor<T> construtor`**: Construtor utilizado para criar instâncias do tipo `T`.
- **`File diretorio`**: Diretório onde o arquivo de dados é armazenado.
- **`String fileName`**: Nome do arquivo de dados.
- **`final int fimCabecalho`**: Posição final do cabeçalho no arquivo (4 bytes).
- **`HashExtensivel<IDEndereco> indiceDireto`**: Índice direto utilizando uma tabela hash extensível.

#### Métodos:
- **`Arquivo(Constructor<T> construtor, String fN)`**: Inicializa o arquivo de dados e o índice hash extensível. Cria o diretório de dados se não existir e inicializa o arquivo com um cabeçalho contendo o ID inicial.
- **`int create(T objeto)`**: Cria um novo registro no arquivo de dados. Atribui um ID ao objeto, escreve o objeto no final do arquivo e atualiza o índice com o ID e o endereço do registro.
- **`T read(int id)`**: Lê um registro do arquivo com base no ID. Usa o índice para encontrar o endereço do registro e então lê o objeto do arquivo.
- **`boolean delete(int id)`**: Marca um registro como excluído (usando uma "lápide"). O registro não é removido fisicamente, mas é marcado como inativo.
- **`boolean update(T novoObjeto)`**: Atualiza um registro existente. Se o novo registro cabe no espaço do registro antigo, ele é sobrescrito. Caso contrário, o registro antigo é marcado como excluído e um novo registro é criado no final do arquivo.
- **`List<T> listAll()`**: Lista todos os registros ativos no arquivo. Pula registros marcados como excluídos e lê os registros válidos.

### Classe `Main`

A classe `Main` contém o ponto de entrada do programa. Ela cria instâncias de tarefas e utiliza a classe `Arquivo` para realizar operações de criação, leitura, atualização e exclusão de tarefas.

#### Atributos:
- **`Arquivo<ToDo> arqTarefa`**: Instância da classe `Arquivo` usada para armazenar e manipular tarefas.

#### Métodos:
- **`public static void main(String[] args)`**: Método principal do programa. Cria algumas tarefas de exemplo, realiza operações de CRUD (Create, Read, Update, Delete) e exibe os resultados no console.

## Experiência de Desenvolvimento

### Implementação dos Requisitos
Sim, todos os requisitos foram implementados com sucesso. O índice direto é gerenciado usando uma tabela hash extensível, e todas as operações básicas (inclusão, leitura, atualização e exclusão) foram implementadas conforme solicitado.

### Operação Mais Difícil
A operação de atualização foi a mais desafiadora. Lidar com registros que podem ter tamanhos diferentes e garantir que o espaço em disco seja gerenciado corretamente apresentou complexidade adicional. Isso exigiu a marcação de registros antigos como excluídos e a criação de novos registros no final do arquivo, se necessário.

### Desafios Enfrentados
- **Gerenciamento do Espaço**: A atualização de registros grandes que não cabem no espaço originalmente alocado foi um desafio, exigindo a gestão correta do espaço no arquivo e o ajuste do índice.
- **Manutenção da Integridade dos Dados**: Manter a consistência do índice direto após operações de inserção, exclusão e atualização foi crucial para garantir que os dados fossem corretamente recuperados e manipulados.

## Resultados

Os resultados foram satisfatórios. O sistema de gerenciamento de registros funciona conforme o esperado, com o índice hash extensível proporcionando acesso eficiente e operações básicas funcionando corretamente.

## Respostas para Questões
- O trabalho possui um índice direto implementado com a tabela hash extensível? **Sim**
- A operação de inclusão insere um novo registro no fim do arquivo e no índice e retorna o ID desse registro? **Sim**
- A operação de busca retorna os dados do registro, após localizá-lo por meio do índice direto? **Sim**
- A operação de alteração altera os dados do registro e trata corretamente as reduções e aumentos no espaço do registro? **Sim**
- A operação de exclusão marca o registro como excluído e o remove do índice direto? **Sim**
- O trabalho está funcionando corretamente? **Sim**
- O trabalho está completo? **Sim**
- O trabalho é original e não a cópia de um trabalho de outro grupo? **Sim, é original.**
