# Repositório de Atividades DAOO

Este repositório contém todas as atividades e projetos realizados na disciplina de **Desenvolvimento Avançado de Orientação a Objetos (DAOO)** do curso de Tecnologia em Sistemas para Internet (TSI).

A estrutura foi organizada para facilitar a execução, compreensão e acompanhamento do progresso das atividades realizadas durante o semestre.

---

## Estrutura do Repositório

As atividades estão distribuídas entre a branch principal (`main`) e branches específicas, conforme descrito abaixo:

- **`main`**: Contém as Atividades 2.1, 2.2 e atividade 3.
- **`atividade-2`**: Contém as Atividades 2.1, 2.2.
- **`atividade-3`**: Contém o código e as soluções da Atividade 3.
- **`atividade-4`**: Contém o código e as soluções da Atividade 4.
- **`atividade-5`**: Contém o código e as soluções da Atividade 5.
- **`atividade-6`**: Contém o código e as soluções da Atividade 6.

---

## Como Rodar o Projeto

Siga os passos abaixo para configurar o ambiente e rodar o projeto corretamente:

### **1. Pré-requisitos**

Certifique-se de ter os seguintes softwares instalados no seu sistema:

- **Git**: Para clonar o repositório.  
  [Download Git](https://git-scm.com/downloads)

- **Docker** e **Docker Compose**: Para rodar o ambiente via container.  
  [Download Docker](https://docs.docker.com/get-docker/)

- **PHP 8.2 ou superior** (caso precise executar localmente sem Docker).  
  [Download PHP](https://www.php.net/downloads.php)

---

### **2. Clonar o Repositório**

Clone o repositório no seu ambiente local:

```bash
git clone https://github.com/[seu-usuario]/[nome-do-repositorio].git
```

Entre no diretório do projeto:

```bash
cd [nome-do-repositorio]
```

---

### **3. Configurar o Ambiente com Docker**

#### **3.1. Instalar as Dependências do Laravel**

Execute o comando abaixo para instalar o Laravel e suas dependências no ambiente Docker:

```bash
docker run --rm -v $(pwd):/app composer install
```

#### **3.2. Configurar o Laravel Sail**

Crie o alias para facilitar o uso do Laravel Sail:

```bash
alias sail='[ -f sail ] && bash sail || bash vendor/bin/sail'
```

#### **3.3. Subir os Contêineres**

Inicie o ambiente com os serviços necessários:

```bash
sail up -d
```

Esse comando inicializa os contêineres em segundo plano.

---

### **4. Configurar o Projeto Laravel**

#### **4.1. Configurar o Arquivo `.env`**

Renomeie o arquivo `.env.example` para `.env`:

```bash
cp .env.example .env
```

Atualize as variáveis do arquivo `.env`:

```env
APP_NAME=Laravel
APP_ENV=local
APP_KEY=base64:<sua-key-aqui>
APP_DEBUG=true
APP_URL=http://localhost

DB_CONNECTION=mysql
DB_HOST=mysql
DB_PORT=3306
DB_DATABASE=laravel
DB_USERNAME=root
DB_PASSWORD=root
```

#### **4.2. Gerar a Key do Laravel**

Dentro do contêiner, execute o seguinte comando para gerar a chave de aplicação:

```bash
sail artisan key:generate
```

---

### **5. Rodar as Migrações e Seeds**

Com os contêineres ativos, execute as migrações para criar o banco de dados e popular tabelas, se necessário:

```bash
sail artisan migrate --seed
```

---

### **6. Testar no Navegador**

1. Acesse a aplicação no navegador:

   ```
   http://localhost
   ```

2. Caso esteja usando o phpMyAdmin, acesse:
   ```
   http://localhost:8081
   ```

---

## Como Acessar Outras Branches

1. **Listar as Branches Disponíveis**

   ```bash
   git branch -a
   ```

2. **Trocar para uma Branch Específica**

   Para acessar o código de uma atividade específica, troque para a branch correspondente:

   ```bash
   git checkout atividade-04   # Para a Atividade 4
   git checkout atividade-05   # Para a Atividade 5
   git checkout atividade-06   # Para a Atividade 6
   ```

---

## Solução de Problemas

1. **Permissões no Docker**  
   Caso precise usar `sudo` para comandos Docker, adicione o usuário ao grupo Docker:

   ```bash
   sudo usermod -aG docker $USER
   ```

   Reinicie o terminal ou faça logout/login no sistema.

2. **Erro de Dependências**  
   Certifique-se de rodar o seguinte comando no diretório do projeto:

   ```bash
   composer install
   ```

3. **Banco de Dados Não Conecta**  
   Verifique se as configurações no arquivo `.env` estão corretas, especialmente os valores de `DB_HOST`, `DB_USERNAME` e `DB_PASSWORD`.

---

## Informações Adicionais

- **Desenvolvido por:** Luis Henrique Victoria
- **Tecnologias Utilizadas:** Laravel, Docker, MySQL.
- **Contato:** [luisvictoria.pl028@academico.ifsul.edu.br]

---
