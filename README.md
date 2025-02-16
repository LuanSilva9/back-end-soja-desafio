# Desafio técnico Soja 🌱 (Back-end)

Esse desafio consiste em criar uma aplicação Rest que simule a criação de lotes de soja relacionados a fazendas, assim como seus transportes e exportação no fim.

## Para funcionar nos temos as tabelas:

- `Users (id, nome, role)`
- `Fazenda (id, nome, localização, produtor_id, área cultivada)`
- `Lote de Soja (id, fazenda_id, data_colheita, quantidade, qualidade)`
- `Transporte (id, lote_id, origem, destino, data_saida, data_chegada, status)`
- `Exportação (id, lote_id, país_destino, pais_embarque, data_exportacao)`

## Regras de Negocio 👾:

- Um lote só pode ser exportado se já passou pelo transporte
- A qualidade do lote deve ser informada no momento da colheita (ex: "Alta", "Média", "Baixa")
- O status do transporte pode ser: "Em trânsito", "Entregue" ou "Cancelado"
- O transporte só pode existir se a qualidade da soja estiver pelo menos com status "Média", caso contrario deve ser jogado para um Silo.

## Endpoints aplicados:

- ✅ Cadastro de fazendas, usuarios, lotes de soja, transportes e exportações
- ✅ Captura de dados das tabelas de maneira geral e/ou por ID, salvo casos em que nossa logica não permite listar todos  de uma vez, como o transporte, lote (consulta geral pelo nome da fazenda), e exportação
- ✅ Filtragem por qualidade da soja e país de destino
- ✅ Consulta da rastreabilidade de um lote pelo ID (de onde veio, para onde foi)

## Banco de dados 🐘

O banco de dados está em PostgreSQL, então é necessario configurar o projeto como tal, e acertar as configurações de variaveis de ambiente (Para isso é necessario criar um arquivo .env na raiz do projeto:

```
DB_URL=jdbc:postgresql://localhost:5432/meu_bd
DB_USER=usuario
DB_PASSWORD=senha
```

## Funcionalidades adicionais

O desafio está concluido, o desafio era majoritariamente a criação das tabelas, regras e endpoints, mas nós podemos usar nossa criatividade e pensar em funcionalidades futuras que podem deixar nossa aplicação mais rica, como por exemplo:

- **[Regra de negocio]** Prazos de Transporte e Exportação: Se um lote atrasar no transporte por muito tempo, o status pode mudar automaticamente para "Vencido" e impedir a exportação.
- **[Regra de negocio]** Preço da Soja Dinâmico: Implementação de um sistema que calcula o valor de um lote com base na qualidade da soja e na cotação do mercado internacional (poderia integrar com uma API externa para pegar os valores em tempo real).
- **[Entidade]** Histórico de Alterações: Criar um log que armazena mudanças no status do transporte e exportação, para rastrear quem alterou e quando.
- **[Endpoint]** ```GET /cotacao-soja``` -> Retorna o preço atual da soja no mercado internacional.
- **[Endpoint]** ```POST /exportacao/simular``` ->  Usuário insere um lote e país de destino, e o sistema retorna tempo estimado, impostos, preço final esperado.
- **[Endpoint]** ```GET /transportes/atrasados ``` -> Retorna transportes que já passaram da data prevista de chegada.
- **[Endpoint]** ```GET /lotes/{id}/relatorio``` -> Retorna data de colheita, qualidade, histórico de transporte, status de exportação, destino final, e valor de mercado.