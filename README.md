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

## Endpoints NÃO aplicados ( Será aplicado nos proximos commits ):

- ❌ Consulta da rastreabilidade de um lote pelo ID (de onde veio, para onde foi)
- ❌ Filtragem por qualidade da soja e país de destino

