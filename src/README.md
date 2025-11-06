# Meu Plantário (Terminal) — Projeto Lhamalware

Pequeno app de terminal em Java para cadastrar e listar plantas, salvando os dados em um arquivo de texto (`meuPlantario.txt`). Desenvolvido para a disciplina de ADS — PUC-GO (grupo Lhamalware).

## O que o programa faz (versão atual)
- Cadastro de plantas (anexa ao arquivo `meuPlantario.txt`)
- Listar plantas (lê e exibe nomes salvos)
- Menu simples via `Scanner`

Funcionalidades ainda a implementar no seu código atual:
- Remover plantas (opção 3 está vazia)
- Lembretes (opção 4 está vazia)
- Validações adicionais e tratamento de exceções mais completo

## Formato do arquivo de dados
Cada planta é gravada em uma linha no arquivo `meuPlantario.txt` com campos separados por ponto-e-vírgula `;`:

Formato:
```
nome;diasRega;intensidadeRega;diasAdubo
```

Exemplo de linha:
```
Espada-de-Sao-Jorge;7;rega média;30
```

Campos:
- `nome` — nome da planta (String)
- `diasRega` — número inteiro (intervalo de rega em dias)
- `intensidadeRega` — texto (ex.: "rega baixa", "rega média", "rega alta")
- `diasAdubo` — número inteiro (intervalo de adubagem em dias)

> Observação: o programa atual grava essas 4 informações e adiciona uma nova linha por planta.

## Como compilar e executar

1. Abra um terminal no diretório do projeto (onde está `Main.java`).

2. Compile:
```bash
javac Main.java
```

3. Execute:
```bash
java Main
```

O arquivo `meuPlantario.txt` será criado automaticamente no mesmo diretório, caso ainda não exista.

## Estrutura do menu (uso)
Ao executar, o menu apresenta opções numeradas. Exemplo de fluxo básico:
- Escolha `2` para listar plantas já cadastradas.
- Escolha `1` para cadastrar uma nova planta; siga as perguntas no terminal.
- Escolha `0` (ou `5` dependendo da sua versão do menu) para sair.

(Dica: no seu código atual o loop termina quando `menu != 4` — revise essa condição caso queira que o programa encerre quando escolher a opção "5".)

## Boas práticas recomendadas
- Não versionar (`git`) o arquivo `meuPlantario.txt` com dados reais do usuário. Em vez disso, adicione ao repositório um `plants.example.txt` com exemplos e inclua `meuPlantario.txt` no `.gitignore`.
- Faça backup antes de alterar o formato do arquivo.
- Ao implementar remoção/edição, leia todas as linhas, modifique em memória e sobrescreva o arquivo (evite editar linhas diretamente).

Exemplo sugerido de `.gitignore`:
```
# arquivos compilados
*.class

# dados locais
meuPlantario.txt

# IDEs
/.idea/
/*.iml
.vscode/
```

## Como colaborar (Git / GitHub)
Fluxo simples:
1. Inicializar repositório local:
```bash
git init
git add .
git commit -m "Primeiro commit - versão inicial do Meu Plantário"
```
2. Criar repositório no GitHub e conectar remoto:
```bash
git remote add origin https://github.com/SEU-USER/NOME-REPO.git
git branch -M main
git push -u origin main
```
3. Colegas clonam com:
```bash
git clone https://github.com/SEU-USER/NOME-REPO.git
```
Sugestão de colaboração: cada pessoa crie uma branch para a feature (ex.: `feature/remover-plantas`) e abra Pull Request para integrar à `main`.

## Próximos passos sugeridos (para você ou para o grupo)
- Implementar a opção 3 (remover plantas) e 4 (lembretes) no `Main.java`.
- Ajustar a condição de encerramento do `do/while` (atual `while (menu!= 4)` parece inconsistente com o menu).
- Melhorar validação de entradas (tratar `InputMismatchException` quando o usuário digita texto onde se espera número).
- Adicionar `plants.example.txt` para facilitar quem clonar o repositório.

---

Grupo Lhamalware — PUC-GO  
Arquivo de dados: `meuPlantario.txt`