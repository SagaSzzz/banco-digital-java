# Banco Digital em Java

Projeto desenvolvido em Java puro com foco em Programação Orientada a Objetos.  
O sistema simula operações bancárias via terminal, permitindo criação de contas, depósitos, saques, transferências, consulta de extrato e diferenciação entre conta corrente e conta poupança.

## Funcionalidades

- Criar conta corrente
- Criar conta poupança
- Buscar conta por número
- Listar contas cadastradas
- Realizar depósitos
- Realizar saques
- Realizar transferências entre contas
- Consultar extrato
- Aplicar rendimento em conta poupança
- Cobrança de taxa em saque de conta corrente

## Conceitos aplicados

- Programação Orientada a Objetos
- Classes e objetos
- Encapsulamento
- Herança
- Polimorfismo
- Classes abstratas
- ArrayList
- Enum
- Exceptions personalizadas
- LocalDateTime
- Separação em camadas

## Estrutura do projeto

```txt
src/
├── model/
│   ├── Cliente.java
│   ├── Conta.java
│   ├── ContaCorrente.java
│   ├── ContaPoupanca.java
│   └── Transacao.java
├── service/
│   └── BancoService.java
├── menu/
│   └── Menu.java
├── exception/
│   ├── ContaNaoAchadaException.java
│   ├── SaldoInsuficienteException.java
│   └── ValorInvalidoException.java
│   └── ContaComSaldoException.java
│   └── NumeroContaInvalidoException.java
├── enums/
│   └── StatusTransacao.java
└── Main.java
