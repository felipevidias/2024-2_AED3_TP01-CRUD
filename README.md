# 2024-2_AED3_TP01-CRUD

# Relatório de Desenvolvimento do TP

## Descrição das Classes e Métodos

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

- **Construtor**:
  ```java
  public Arquivo(Constructor<T> construtor, String fN) throws Exception
Descrição: Inicializa o arquivo de dados e o índice hash extensível. Cria o diretório de dados se não existir e inicializa o arquivo com um cabeçalho contendo o ID inicial.

create(T objeto):

```java
  public int create(T objeto) throws Exception
```
Descrição: Cria um novo registro no arquivo de dados. Atribui um ID ao objeto, escreve o objeto no final do arquivo e atualiza o índice com o ID e o endereço do registro.
read(int id):
```java

public T read(int id)
```
Descrição: Lê um registro do arquivo com base no ID. Usa o índice para encontrar o endereço do registro e então lê o objeto do arquivo.
delete(int id):
```java

public boolean delete(int id) throws Exception
```
Descrição: Marca um registro como excluído (usando uma "lapide"). O registro não é removido fisicamente, mas é marcado como inativo.
update(T novoObjeto):
```java

public boolean update(T novoObjeto) throws Exception
```
Descrição: Atualiza um registro existente. Se o novo registro cabe no espaço do registro antigo, ele é sobrescrito. Caso contrário, o registro antigo é marcado como excluído e um novo registro é criado no final do arquivo.
listAll():
```java

public List<T> listAll()
```
Descrição: Lista todos os registros ativos no arquivo. Pula registros marcados como excluídos e lê os registros válidos.
Experiência de Desenvolvimento
Implementação dos Requisitos
Sim, todos os requisitos foram implementados com sucesso. O índice direto é gerenciado usando uma tabela hash extensível, e todas as operações básicas (inclusão, leitura, atualização e exclusão) foram implementadas conforme solicitado.

Operação Mais Difícil
A operação de atualização foi a mais desafiadora. Lidar com registros que podem ter tamanhos diferentes e garantir que o espaço em disco seja gerenciado corretamente apresentou complexidade adicional. Isso exigiu a marcação de registros antigos como excluídos e a criação de novos registros no final do arquivo, se necessário.

Desafios Enfrentados
Gerenciamento do Espaço: A atualização de registros grandes que não cabem no espaço originalmente alocado foi um desafio, exigindo a gestão correta do espaço no arquivo e o ajuste do índice.
Manutenção da Integridade dos Dados: Manter a consistência do índice direto após operações de inserção, exclusão e atualização foi crucial para garantir que os dados fossem corretamente recuperados e manipulados.
Resultados
Os resultados foram satisfatórios. O sistema de gerenciamento de registros funciona conforme o esperado, com o índice hash extensível proporcionando acesso eficiente e operações básicas funcionando corretamente.

Checklist de Requisitos
O trabalho possui um índice direto implementado com a tabela hash extensível?

Sim
A operação de inclusão insere um novo registro no fim do arquivo e no índice e retorna o ID desse registro?

Sim
A operação de busca retorna os dados do registro, após localizá-lo por meio do índice direto?

Sim
A operação de alteração altera os dados do registro e trata corretamente as reduções e aumentos no espaço do registro?

Sim
A operação de exclusão marca o registro como excluído e o remove do índice direto?

Sim
O trabalho está funcionando corretamente?

Sim
O trabalho está completo?

Sim
O trabalho é original e não a cópia de um trabalho de outro grupo?

Sim
